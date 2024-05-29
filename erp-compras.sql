-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-05-2024 a las 00:48:22
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `erp-compras`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chair`
--

CREATE TABLE `chair` (
  `ID` int(11) NOT NULL,
  `backrest` tinyint(1) NOT NULL,
  `wheels` int(11) NOT NULL,
  `armrest` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `company`
--

CREATE TABLE `company` (
  `CIF` varchar(9) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `company`
--

INSERT INTO `company` (`CIF`, `name`) VALUES
('A24648909', 'si');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `delivery_note`
--

CREATE TABLE `delivery_note` (
  `delivery_ID` int(11) NOT NULL,
  `company_ID` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `delivery_note_prod`
--

CREATE TABLE `delivery_note_prod` (
  `delivery_ID` int(11) NOT NULL,
  `prod_ID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `keyboard`
--

CREATE TABLE `keyboard` (
  `ID` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  `language` varchar(45) NOT NULL,
  `lenght` int(11) NOT NULL,
  `wireless` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mouse`
--

CREATE TABLE `mouse` (
  `ID` int(11) NOT NULL,
  `handDexterity` tinyint(1) NOT NULL,
  `lateralButtons` int(11) NOT NULL,
  `wireless` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `ID` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `weight` float NOT NULL,
  `color` varchar(45) NOT NULL,
  `type` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `taula`
--

CREATE TABLE `taula` (
  `ID` int(11) NOT NULL,
  `wheels` int(11) NOT NULL,
  `legs` int(11) NOT NULL,
  `adjutableHeight` tinyint(1) NOT NULL,
  `material` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `chair`
--
ALTER TABLE `chair`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`CIF`);

--
-- Indices de la tabla `delivery_note`
--
ALTER TABLE `delivery_note`
  ADD PRIMARY KEY (`delivery_ID`),
  ADD KEY `FK_companyID_idx` (`company_ID`);

--
-- Indices de la tabla `delivery_note_prod`
--
ALTER TABLE `delivery_note_prod`
  ADD KEY `FK_delivery_ID_idx` (`delivery_ID`),
  ADD KEY `FK_product_ID_idx` (`prod_ID`);

--
-- Indices de la tabla `keyboard`
--
ALTER TABLE `keyboard`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `mouse`
--
ALTER TABLE `mouse`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `taula`
--
ALTER TABLE `taula`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `delivery_note`
--
ALTER TABLE `delivery_note`
  MODIFY `delivery_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `chair`
--
ALTER TABLE `chair`
  ADD CONSTRAINT `FK_ID` FOREIGN KEY (`ID`) REFERENCES `product` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `delivery_note`
--
ALTER TABLE `delivery_note`
  ADD CONSTRAINT `FK_companyID` FOREIGN KEY (`company_ID`) REFERENCES `company` (`CIF`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `delivery_note_prod`
--
ALTER TABLE `delivery_note_prod`
  ADD CONSTRAINT `FK_delivery_ID` FOREIGN KEY (`delivery_ID`) REFERENCES `delivery_note` (`delivery_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_product_ID` FOREIGN KEY (`prod_ID`) REFERENCES `product` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `keyboard`
--
ALTER TABLE `keyboard`
  ADD CONSTRAINT `FK_IDk` FOREIGN KEY (`ID`) REFERENCES `product` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mouse`
--
ALTER TABLE `mouse`
  ADD CONSTRAINT `FK_IDm` FOREIGN KEY (`ID`) REFERENCES `product` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `taula`
--
ALTER TABLE `taula`
  ADD CONSTRAINT `FK_IDt` FOREIGN KEY (`ID`) REFERENCES `product` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
