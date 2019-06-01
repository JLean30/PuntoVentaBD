-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-06-2018 a las 07:14:48
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 5.6.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `puntoventa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `cedula` varchar(20) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `primerApellido` varchar(15) NOT NULL,
  `segundoApellido` varchar(15) NOT NULL,
  `telefono` int(10) NOT NULL,
  `direccion` varchar(300) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`cedula`, `nombre`, `primerApellido`, `segundoApellido`, `telefono`, `direccion`, `email`) VALUES
('604560296', 'Jean Carlos', 'Brenes ', 'Zuñiga', 64411050, 'Barranca,Puntarenas casa #603', 'Jean@gmail.com'),
('602540267', 'Ligia', 'Mendoza', 'Salas', 26635562, 'Puntarenas', 'Ligia@gmail.com'),
('602570264', 'Pablo', 'salas', 'Guido', 26615521, 'Barranca', 'Pablo@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `codFactura` varchar(4) NOT NULL,
  `codCliente` varchar(20) NOT NULL,
  `detalleFactura` varchar(700) NOT NULL,
  `fechaFactura` date NOT NULL,
  `monto` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`codFactura`, `codCliente`, `detalleFactura`, `fechaFactura`, `monto`) VALUES
('0', '604560296', 'Desifectante', '2018-03-06', '10000'),
('1', '602540267', 'Carnes de res ,Pechuga de pollo ,Pechuga de pollo', '2018-03-06', '8000'),
('2', '604560296', 'Arroz ,Cloro', '2018-03-06', '6750'),
('3', '604560296', 'Carnes de res', '2017-03-06', '10000'),
('4', '602540267', 'Carnes de res', '2017-04-07', '2000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` varchar(8) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `preciocompra` decimal(10,0) NOT NULL,
  `descuento` decimal(10,0) NOT NULL,
  `impuesto` decimal(10,0) NOT NULL,
  `fecharegistro` date NOT NULL,
  `precioventa` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `descripcion`, `preciocompra`, `descuento`, `impuesto`, `fecharegistro`, `precioventa`) VALUES
('P-1', 'Desifectante', '5000', '10', '13', '2018-03-06', '5085'),
('P-2', 'Carnes de res', '2000', '5', '12', '2018-03-06', '2128'),
('P-3', 'Pechuga de pollo', '3000', '4', '10', '2018-03-06', '3168'),
('P-4', 'Cloro', '500', '2', '13', '2018-03-06', '554'),
('P-5', 'Arroz', '850', '10', '15', '2018-03-06', '880');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `cedula` varchar(20) NOT NULL,
  `montocredito` decimal(10,0) NOT NULL,
  `nombrecomercial` varchar(200) NOT NULL,
  `contacto` varchar(80) NOT NULL,
  `direccionexacta` varchar(250) NOT NULL,
  `diascredito` int(3) NOT NULL,
  `moneda` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`cedula`, `montocredito`, `nombrecomercial`, `contacto`, `direccionexacta`, `diascredito`, `moneda`) VALUES
('12548024', '500000', 'Dos Pinos', '26541475', 'San Jose', 45, 'C'),
('21575681', '600000', 'Diana', '24857414', 'Heredia', 60, 'C'),
('52482485', '800000', 'Coca Cola', '25756954', 'Cartago', 15, 'D');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usuario` varchar(20) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `nombrecompleto` varchar(80) NOT NULL,
  `tipo` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usuario`, `contrasena`, `nombrecompleto`, `tipo`) VALUES
('cajera', 'cajera', 'Alejandra gonzales', 'C'),
('vendedor', 'vendedor', 'Carlos Ramirez', 'V');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
