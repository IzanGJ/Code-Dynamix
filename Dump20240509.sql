CREATE DATABASE  IF NOT EXISTS `erp-compras` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `erp-compras`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: erp-compras
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chair`
--

DROP TABLE IF EXISTS `chair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chair` (
  `backrest` tinyint(1) NOT NULL,
  `ID` int NOT NULL,
  `wheels` int NOT NULL,
  `armrest` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_ID` FOREIGN KEY (`ID`) REFERENCES `product` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chair`
--

LOCK TABLES `chair` WRITE;
/*!40000 ALTER TABLE `chair` DISABLE KEYS */;
/*!40000 ALTER TABLE `chair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `name` varchar(45) NOT NULL,
  `CIF` varchar(9) NOT NULL,
  PRIMARY KEY (`CIF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_note`
--

DROP TABLE IF EXISTS `delivery_note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_note` (
  `delivery_ID` int NOT NULL AUTO_INCREMENT,
  `company_ID` varchar(9) NOT NULL,
  PRIMARY KEY (`delivery_ID`),
  KEY `FK_companyID_idx` (`company_ID`),
  CONSTRAINT `FK_companyID` FOREIGN KEY (`company_ID`) REFERENCES `company` (`CIF`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_note`
--

LOCK TABLES `delivery_note` WRITE;
/*!40000 ALTER TABLE `delivery_note` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_note_prod`
--

DROP TABLE IF EXISTS `delivery_note_prod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_note_prod` (
  `delivery_ID` int NOT NULL,
  `prod_ID` int NOT NULL,
  `quantity` int NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`delivery_ID`),
  KEY `FK_product_ID_idx` (`prod_ID`),
  CONSTRAINT `FK_delivery_ID` FOREIGN KEY (`delivery_ID`) REFERENCES `delivery_note` (`delivery_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_product_ID` FOREIGN KEY (`prod_ID`) REFERENCES `product` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_note_prod`
--

LOCK TABLES `delivery_note_prod` WRITE;
/*!40000 ALTER TABLE `delivery_note_prod` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_note_prod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyboard`
--

DROP TABLE IF EXISTS `keyboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `keyboard` (
  `ID` int NOT NULL,
  `type` varchar(45) NOT NULL,
  `language` varchar(45) NOT NULL,
  `lenght` int NOT NULL,
  `wireless` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_IDk` FOREIGN KEY (`ID`) REFERENCES `product` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyboard`
--

LOCK TABLES `keyboard` WRITE;
/*!40000 ALTER TABLE `keyboard` DISABLE KEYS */;
/*!40000 ALTER TABLE `keyboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mouse`
--

DROP TABLE IF EXISTS `mouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mouse` (
  `ID` int NOT NULL,
  `handDexterity` tinyint(1) NOT NULL,
  `lateralButtons` int NOT NULL,
  `wireless` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_IDm` FOREIGN KEY (`ID`) REFERENCES `product` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mouse`
--

LOCK TABLES `mouse` WRITE;
/*!40000 ALTER TABLE `mouse` DISABLE KEYS */;
/*!40000 ALTER TABLE `mouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `name` varchar(45) NOT NULL,
  `ID` int NOT NULL,
  `description` varchar(200) NOT NULL,
  `price` float NOT NULL,
  `weight` float NOT NULL,
  `color` varchar(45) NOT NULL,
  `type` varchar(8) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table`
--

DROP TABLE IF EXISTS `table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `table` (
  `ID` int NOT NULL,
  `wheels` int NOT NULL,
  `legs` int NOT NULL,
  `adjutableHeight` tinyint(1) NOT NULL,
  `material` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_IDt` FOREIGN KEY (`ID`) REFERENCES `product` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table`
--

LOCK TABLES `table` WRITE;
/*!40000 ALTER TABLE `table` DISABLE KEYS */;
/*!40000 ALTER TABLE `table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-09 19:20:49
