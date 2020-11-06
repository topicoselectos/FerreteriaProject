-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-11-2020 a las 09:34:49
-- Versión del servidor: 8.0.22
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ferreteriadb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_cliente`
--

CREATE TABLE `tb_cliente` (
  `idtb_cliente` int NOT NULL,
  `Nombre_cliente` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Correo` varchar(45) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Telefono` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_departamento`
--

CREATE TABLE `tb_departamento` (
  `idtb_departamento` int NOT NULL,
  `Nombre_dept` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `extensión` varchar(45) NOT NULL,
  `pasillo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tb_departamento`
--

INSERT INTO `tb_departamento` (`idtb_departamento`, `Nombre_dept`, `extensión`, `pasillo`) VALUES
(1, 'Hogar', '701', '5'),
(2, 'Jardinería', '699', '3'),
(3, 'Iluminación', '700', '4'),
(6, 'Construcción', '697', '1'),
(7, 'Plomería', '698', '2'),
(8, 'Pinturas', '702', '6'),
(9, 'Bodega', '011', 'Trasero'),
(10, 'Zona Carga', '555', 'Costado Izquierdo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_empleado`
--

CREATE TABLE `tb_empleado` (
  `idtb_empleado` int NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellido_1` varchar(45) NOT NULL,
  `Apellido_2` varchar(45) NOT NULL,
  `Cedula` int NOT NULL,
  `Contraseña` varchar(45) NOT NULL,
  `empleado_tipo` varchar(45) NOT NULL,
  `Telefono` varchar(45) NOT NULL,
  `Correo` varchar(45) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `fk_dept` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tb_empleado`
--

INSERT INTO `tb_empleado` (`idtb_empleado`, `Nombre`, `Apellido_1`, `Apellido_2`, `Cedula`, `Contraseña`, `empleado_tipo`, `Telefono`, `Correo`, `Direccion`, `fk_dept`) VALUES
(2, 'Carlos', 'Alvarado', 'Quesada', 187255419, 'alvarado002.', 'Constructor', '87291653', 'charly.002@gmail.com', 'Contiguo Maxi Pali, Guápiles', 6),
(3, 'Alfredo', 'Umaña', 'Solis', 167225309, 'pelucita123', 'Constructor', '26545534', 'alf.umñ63@hotmail.com', 'Barrio Sinaí', 6),
(4, 'Glenda', 'Arauz', 'Rodríguez', 704728761, 'ApachE78', 'Constructor', '78625473', 'arauzglen70@gmail.com', 'Barrio La Esmeralda', 6),
(5, 'Christian', 'Martínez', 'Alvarado', 765229803, 'gamer908', 'Iluminador Interiores y Exteriores', '84465222', 'alvarado12chm9@outlook.es', 'San Martín, Jiménez', 3),
(6, 'Jorge', 'Muñoz', 'Quesada', 116552908, 'qmjge.qw', 'Constructor', '78762012', 'muñozjg.21@gmail.com', 'Barrio Sinaí', 6),
(7, 'Ligia', 'Solano', 'Cruz', 701543776, 'lsc6105', 'Jardinera', '87690013', 'lisc61@hotmail.com', 'La Emilia, contiguo plaza Deportes', 2),
(8, 'Javier', 'Hernández', 'López', 765990102, 'lopez56@', 'Jardinero', '65279898', 'mar.56@hotmail.com', 'Barrio La Esmeralda', 2),
(9, 'Andres', 'Castillo', 'Méndez', 100780235, 'castle69', 'Hogar', '65720987', 'menuss691@outlook.com', 'Urbanización Toro Amarillo', 1),
(10, 'Yessenia', 'Gómez', 'Solis', 226551928, 'malibu2020', 'Hogar', '77826152', 'yessigz02@gmail.com', 'Barrio La Esmeralda', 1),
(11, 'Ana', 'Arauz', 'Quesada', 776588102, 'anitaguapileña', 'Hogar', '89009826', 'anitaquesada20@gmail.com', 'Calle Vargas', 1),
(12, 'Cristopher', 'Ureña', 'Castro', 721000176, 'crisnar72.U', 'Iluminador Interiores y Exteriores', '77180023', 'urccpher@hotmail.com', 'San Martín, Jiménez', 3),
(13, 'Mauren', 'Venegas', 'Fernández', 716220987, 'venegas71fv', 'Iluminadora Interiores y Exteriores', '88761102', 'mvenegas83@gmail.com', 'Jiménez', 3),
(14, 'Gloriana', 'Castro', 'Miranda', 200656718, 'Esponja18', 'Iluminadora Interiores y Exteriores', '76782901', 'glory.sc90@gmail.com', 'Pinares', 3),
(15, 'Alfredo', 'Carazo', 'López', 116728902, 'cttgsu81', 'Pintor', '88120012', 'alfredclpz@gmail.com', 'La Urba', 8),
(16, 'Daniel', 'Ugalde', 'Ugalde', 117820092, 'miapomp20', 'Pintor', '77162893', 'dqanivpmp61@hotmail.com', 'El Molino', 8),
(17, 'Enrique', 'Camacho', 'Arellano', 872665102, 'hack2561', 'Plomero', '67522901', 'plenca@hotmail.com', 'Coopevigua 1', 7),
(18, 'Edgar', 'Castro', 'Castillo', 267721981, 'kira0921', 'Plomero', '67829002', 'emctw02@gmail.com', 'El Molino', 7),
(19, 'David', 'Nuñez', 'Urbina', 716229011, 'ternero38', 'Bodeguero', '72090965', 'ddno1@hotmail,com', 'Jiménez', 9),
(20, 'Ronald', 'Fernández', 'Bonilla', 187220971, 'ramro023', 'Bodeguero', '76890167', 'rnf201@gmail.com', 'Urbanización Toro Amarillo', 9),
(21, 'Michael', 'Arauz', 'Aguilar', 761990278, 'michahnd', 'Bodeguero', '87508537', 'maichnd@gmail.com', 'Coopevigua 2', 9),
(22, 'Javier', 'Sánchez', 'Cruz', 761002204, 'jscyUY', 'Monta Cargas', '56942565', 'mcft29@gmail.com', 'Pinares', 10),
(23, 'Jorge', 'Zuñiga', 'Porras', 762880191, 'corredor2000', 'Cargador Material', '89858845', 'jpcorr91@hotmail.com', 'Jiménez', 10),
(24, 'José', 'Campos', 'Campos', 162772902, 'campitos89', 'Cargador Material', '65958521', 'camposcehpe@gmail.com', 'Barrio Jesúus', 10),
(25, 'Alexander', 'Alvarado', 'Prendas', 776251520, 'prendas0901', 'Cargador Material', '89852103', 'prnalex@gmail.com', 'Barrio Sinaí', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_factura`
--

CREATE TABLE `tb_factura` (
  `idtb_factura` int NOT NULL,
  `fecha` datetime NOT NULL,
  `subtotal` int NOT NULL,
  `Impuesto` int NOT NULL,
  `Total` int NOT NULL,
  `peido_fk` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_pedido`
--

CREATE TABLE `tb_pedido` (
  `idtb_pedido` int NOT NULL,
  `Cantidad` int NOT NULL,
  `producto_fk` int NOT NULL,
  `empleado_fk` int NOT NULL,
  `cliente_fk` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_producto`
--

CREATE TABLE `tb_producto` (
  `idtb_producto` int NOT NULL,
  `Nombre` varchar(85) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Descripcion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dept_fk` int NOT NULL,
  `Precio(colones)` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tb_producto`
--

INSERT INTO `tb_producto` (`idtb_producto`, `Nombre`, `Descripcion`, `dept_fk`, `Precio(colones)`) VALUES
(1, 'Cortineros Metal', 'Par de cortineros de metal para ventanas', 1, 700),
(2, 'Cortineros Madera Oscura', 'Cortineros de madera oscura para ventanas', 1, 2000),
(3, 'Cortineros Madera Clara', 'Cortineros de madera clara para ventanas todo tipo', 1, 1750),
(4, 'Alfombra 2x2 ', 'Alfombra gris con blanco grande para centro de sala de 2 metros por 2 metros de tela peluche', 1, 25000),
(5, 'Alfombras 2x1.5', 'Alfombras beige de tela peluche de 2x1.5 metros para centro de sala', 1, 15000),
(6, 'Espejos 1.50x30 cm', 'Espejo de 1.50 x 30 cm con marco de madera', 1, 4000),
(7, 'Espejos 1.90 x 30cm', 'Espejos 1.90 x 30cm con marco de madera oscura', 1, 7500),
(8, 'Tablilla PVC m2 blanco', 'Tablilla PVC por metro cuadrado Blanco nieve para cielo raso', 1, 3500),
(9, 'Tablilla PVC m2 Olmo', 'Tablilla PVC por metro cuadrado Blanco Olmo ideal para cielo raso', 1, 3600),
(10, 'Tablilla PVC m2 Cafe', 'Tablilla PVC por metro cuadrado color cafe madera', 1, 3350),
(11, 'Cerámica h1', 'Cerámica h1 por metro cuadrado color beige rayos de sol para piso de hogar', 1, 2875),
(12, 'Cerámica y2', 'Cerámica y2 por metro cuadrado color madera claro', 1, 3250),
(13, 'Cerámica y3', 'Cerámica y3 por metro cuadrado color madera oscura', 1, 3175),
(14, 'Cerámica p4', 'Cerámica p4 por metro cuadrado color blanco olmo', 1, 3550),
(15, 'Cerámica u7', 'Cerámica u7 por metro cuadrado color blanco pastel', 1, 3125),
(16, 'Porcelanato u1', 'Porcelanato u1 por metro cuadrado color beige pastel', 1, 3950),
(17, 'Porcelanato Premium k2 ', 'Porcelanato Premium k2 por metro cuadrado color blanco reflejo', 1, 4650),
(18, 'Azulejo A2', 'Azulejo A2 por metro cuadrado para baño color gris oscuro con blanco', 1, 2650),
(19, 'Azulejo E3', 'Azulejo E3 por metro cuadrado color blanco con destellos naranja para baño', 1, 2950),
(20, 'Azulejo t5', 'Azulejo t5 por metro cuadrado para baño color gris con morado suave', 1, 2780),
(21, 'Azulejo j1', 'Azulejo j1 por metro cuadrado para baño color blanco reflejo', 1, 3100),
(22, 'Azulejo t7 Premium', 'Azulejo t7 por metro cuadrado para baño color negro con gris y líneas verticales violeta ligero', 1, 3450),
(23, 'Azulejo z4 Premium', 'Azulejo z4 Premium por m2 para baño color gris turquesa', 1, 3725),
(24, 'Mueble Televisión 2x1.8m', 'Mueble Televisión 2x1.8m para sala o cuarto', 1, 243000),
(25, 'Mesa de centro vidrio-madera 60x45cm', 'Mesa de centro vidrio-madera 60x45cm ideal para muebles de sala medianos ', 1, 33700),
(26, 'Mesa de centro madera 90x50cm', 'Mesa de centro madera 90x50cm ideal para muebles de sala grandes y con espacio', 1, 49050),
(27, 'Comedor 6 sillas 2.5x1.10m', 'Comedor 6 sillas 2.5x1.10m con madera oscura', 1, 345500),
(28, 'Comedor 4 sillas 90x90cm Premium', 'Comedor 4 sillas 90x90cm Premium madera occidental ', 1, 265700);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_stock`
--

CREATE TABLE `tb_stock` (
  `idtb_stock` int NOT NULL,
  `cantidad` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`idtb_cliente`);

--
-- Indices de la tabla `tb_departamento`
--
ALTER TABLE `tb_departamento`
  ADD PRIMARY KEY (`idtb_departamento`);

--
-- Indices de la tabla `tb_empleado`
--
ALTER TABLE `tb_empleado`
  ADD PRIMARY KEY (`idtb_empleado`),
  ADD KEY `fk_dept_idx` (`fk_dept`);

--
-- Indices de la tabla `tb_factura`
--
ALTER TABLE `tb_factura`
  ADD PRIMARY KEY (`idtb_factura`),
  ADD KEY `pedido_fk_idx` (`peido_fk`);

--
-- Indices de la tabla `tb_pedido`
--
ALTER TABLE `tb_pedido`
  ADD PRIMARY KEY (`idtb_pedido`),
  ADD KEY `producto_fk_idx` (`producto_fk`),
  ADD KEY `empleado_fk_idx` (`empleado_fk`),
  ADD KEY `cliente_fk_idx` (`cliente_fk`);

--
-- Indices de la tabla `tb_producto`
--
ALTER TABLE `tb_producto`
  ADD PRIMARY KEY (`idtb_producto`),
  ADD KEY `dept_fk_idx` (`dept_fk`);

--
-- Indices de la tabla `tb_stock`
--
ALTER TABLE `tb_stock`
  ADD PRIMARY KEY (`idtb_stock`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `idtb_cliente` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_departamento`
--
ALTER TABLE `tb_departamento`
  MODIFY `idtb_departamento` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `tb_empleado`
--
ALTER TABLE `tb_empleado`
  MODIFY `idtb_empleado` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `tb_factura`
--
ALTER TABLE `tb_factura`
  MODIFY `idtb_factura` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_pedido`
--
ALTER TABLE `tb_pedido`
  MODIFY `idtb_pedido` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_producto`
--
ALTER TABLE `tb_producto`
  MODIFY `idtb_producto` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `tb_stock`
--
ALTER TABLE `tb_stock`
  MODIFY `idtb_stock` int NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_empleado`
--
ALTER TABLE `tb_empleado`
  ADD CONSTRAINT `fk_dept` FOREIGN KEY (`fk_dept`) REFERENCES `tb_departamento` (`idtb_departamento`);

--
-- Filtros para la tabla `tb_factura`
--
ALTER TABLE `tb_factura`
  ADD CONSTRAINT `pedido_fk` FOREIGN KEY (`peido_fk`) REFERENCES `tb_pedido` (`idtb_pedido`);

--
-- Filtros para la tabla `tb_pedido`
--
ALTER TABLE `tb_pedido`
  ADD CONSTRAINT `cliente_fk` FOREIGN KEY (`cliente_fk`) REFERENCES `tb_cliente` (`idtb_cliente`),
  ADD CONSTRAINT `empleado_fk` FOREIGN KEY (`empleado_fk`) REFERENCES `tb_empleado` (`idtb_empleado`),
  ADD CONSTRAINT `producto_fk` FOREIGN KEY (`producto_fk`) REFERENCES `tb_producto` (`idtb_producto`);

--
-- Filtros para la tabla `tb_producto`
--
ALTER TABLE `tb_producto`
  ADD CONSTRAINT `dept_fk` FOREIGN KEY (`dept_fk`) REFERENCES `tb_departamento` (`idtb_departamento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
