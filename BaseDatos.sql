-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_sistema
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_sistema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_sistema` DEFAULT CHARACTER SET utf8 ;
USE `db_sistema` ;

-- -----------------------------------------------------
-- Table `db_sistema`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sistema`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(80) NOT NULL,
  `Cedula` INT NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_sistema`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sistema`.`proveedor` (
  `idProveedor` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_sistema`.`inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sistema`.`inventario` (
  `idInventario` INT NOT NULL AUTO_INCREMENT,
  `Cantidad` INT NOT NULL,
  `Fk_proveedor` INT NOT NULL,
  `PrecioCompra` INT NOT NULL,
  `PrecioVenta` INT NOT NULL,
  PRIMARY KEY (`idInventario`),
  INDEX `fk_inventario_proveedor_idx` (`Fk_proveedor` ASC) VISIBLE,
  CONSTRAINT `fk_inventario_proveedor`
    FOREIGN KEY (`Fk_proveedor`)
    REFERENCES `db_sistema`.`proveedor` (`idProveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_sistema`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sistema`.`producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(100) NOT NULL,
  `Descripcion` VARCHAR(100) NOT NULL,
  `Codigo` VARCHAR(45) NOT NULL,
  `fk_inventario` INT NOT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC) VISIBLE,
  UNIQUE INDEX `Codigo_UNIQUE` (`Codigo` ASC) VISIBLE,
  INDEX `fk_producto_inventario_idx` (`fk_inventario` ASC) VISIBLE,
  CONSTRAINT `fk_producto_inventario`
    FOREIGN KEY (`fk_inventario`)
    REFERENCES `db_sistema`.`inventario` (`idInventario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_sistema`.`orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sistema`.`orden` (
  `idOrden` INT NOT NULL AUTO_INCREMENT,
  `Cantidad` INT NOT NULL,
  `Fk_producto` INT NOT NULL,
  `Fk_Cliente` INT NOT NULL,
  PRIMARY KEY (`idOrden`),
  INDEX `fk_orden_producto_idx` (`Fk_producto` ASC) VISIBLE,
  INDEX `fk_orden_cliente_idx` (`Fk_Cliente` ASC) VISIBLE,
  CONSTRAINT `fk_orden_cliente`
    FOREIGN KEY (`Fk_Cliente`)
    REFERENCES `db_sistema`.`cliente` (`idCliente`),
  CONSTRAINT `fk_orden_producto`
    FOREIGN KEY (`Fk_producto`)
    REFERENCES `db_sistema`.`producto` (`idProducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_sistema`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sistema`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Cedula` INT NOT NULL,
  `Contrasena` VARCHAR(45) NOT NULL,
  `Tipo_usuario` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(45) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `Cedula_UNIQUE` (`Cedula` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_sistema`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sistema`.`factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `Fecha` DATETIME NOT NULL,
  `Subtotal` INT NOT NULL,
  `Impuesto` INT NOT NULL,
  `Descuento` INT NOT NULL,
  `TotalPagar` INT NOT NULL,
  `Fk_Usuario` INT NOT NULL,
  `Fk_Orden` INT NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_factura_orden_idx` (`Fk_Orden` ASC) VISIBLE,
  INDEX `fk_factura_usuario_idx` (`Fk_Usuario` ASC) VISIBLE,
  CONSTRAINT `fk_factura_orden`
    FOREIGN KEY (`Fk_Orden`)
    REFERENCES `db_sistema`.`orden` (`idOrden`),
  CONSTRAINT `fk_factura_usuario`
    FOREIGN KEY (`Fk_Usuario`)
    REFERENCES `db_sistema`.`usuario` (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_sistema`.`tb_departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sistema`.`tb_departamento` (
  `idDepartamento` INT NOT NULL,
  `Nombre_dept` VARCHAR(45) NOT NULL,
  `extension` VARCHAR(45) NOT NULL,
  `pasillo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
