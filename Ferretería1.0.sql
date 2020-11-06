-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ferreteriadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ferreteriadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ferreteriadb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ferreteriadb` ;

-- -----------------------------------------------------
-- Table `ferreteriadb`.`tb_departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ferreteriadb`.`tb_departamento` (
  `idtb_departamento` INT NOT NULL AUTO_INCREMENT,
  `Nombre:dept` VARCHAR(45) NOT NULL,
  `extensión` VARCHAR(45) NOT NULL,
  `pasillo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtb_departamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ferreteriadb`.`tb_empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ferreteriadb`.`tb_empleado` (
  `idtb_empleado` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido_1` VARCHAR(45) NOT NULL,
  `Apellido_2` VARCHAR(45) NOT NULL,
  `Cedula` INT NOT NULL,
  `Contraseña` VARCHAR(45) NOT NULL,
  `empleado_tipo` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(45) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `fk_dept` INT NOT NULL,
  PRIMARY KEY (`idtb_empleado`),
  INDEX `fk_dept_idx` (`fk_dept` ASC) VISIBLE,
  CONSTRAINT `fk_dept`
    FOREIGN KEY (`fk_dept`)
    REFERENCES `ferreteriadb`.`tb_departamento` (`idtb_departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ferreteriadb`.`tb_stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ferreteriadb`.`tb_stock` (
  `idtb_stock` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`idtb_stock`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ferreteriadb`.`tb_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ferreteriadb`.`tb_producto` (
  `idtb_producto` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(45) NOT NULL,
  `dept_fk` INT NOT NULL,
  `total_producto` INT NOT NULL,
  PRIMARY KEY (`idtb_producto`),
  INDEX `dept_fk_idx` (`dept_fk` ASC) VISIBLE,
  INDEX `total_producto_idx` (`total_producto` ASC) VISIBLE,
  CONSTRAINT `dept_fk`
    FOREIGN KEY (`dept_fk`)
    REFERENCES `ferreteriadb`.`tb_departamento` (`idtb_departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `total_producto`
    FOREIGN KEY (`total_producto`)
    REFERENCES `ferreteriadb`.`tb_stock` (`idtb_stock`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ferreteriadb`.`tb_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ferreteriadb`.`tb_cliente` (
  `idtb_cliente` INT NOT NULL AUTO_INCREMENT,
  `Nombre_cliente` VARCHAR(45) NOT NULL,
  `Apellidos` VARCHAR(45) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtb_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ferreteriadb`.`tb_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ferreteriadb`.`tb_pedido` (
  `idtb_pedido` INT NOT NULL AUTO_INCREMENT,
  `Cantidad` INT NOT NULL,
  `producto_fk` INT NOT NULL,
  `empleado_fk` INT NOT NULL,
  `cliente_fk` INT NOT NULL,
  PRIMARY KEY (`idtb_pedido`),
  INDEX `producto_fk_idx` (`producto_fk` ASC) VISIBLE,
  INDEX `empleado_fk_idx` (`empleado_fk` ASC) VISIBLE,
  INDEX `cliente_fk_idx` (`cliente_fk` ASC) VISIBLE,
  CONSTRAINT `producto_fk`
    FOREIGN KEY (`producto_fk`)
    REFERENCES `ferreteriadb`.`tb_producto` (`idtb_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `empleado_fk`
    FOREIGN KEY (`empleado_fk`)
    REFERENCES `ferreteriadb`.`tb_empleado` (`idtb_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cliente_fk`
    FOREIGN KEY (`cliente_fk`)
    REFERENCES `ferreteriadb`.`tb_cliente` (`idtb_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ferreteriadb`.`tb_factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ferreteriadb`.`tb_factura` (
  `idtb_factura` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `subtotal` INT NOT NULL,
  `Impuesto` INT NOT NULL,
  `Total` INT NOT NULL,
  `peido_fk` INT NOT NULL,
  PRIMARY KEY (`idtb_factura`),
  INDEX `pedido_fk_idx` (`peido_fk` ASC) VISIBLE,
  CONSTRAINT `pedido_fk`
    FOREIGN KEY (`peido_fk`)
    REFERENCES `ferreteriadb`.`tb_pedido` (`idtb_pedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
