CREATE DATABASE  IF NOT EXISTS `globito` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `globito`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: globito
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `cpan`
--

DROP TABLE IF EXISTS `cpan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cpan` (
  `id_cpan` int NOT NULL AUTO_INCREMENT,
  `nom_cpan` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cpan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpan`
--

LOCK TABLES `cpan` WRITE;
/*!40000 ALTER TABLE `cpan` DISABLE KEYS */;
/*!40000 ALTER TABLE `cpan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `csaborpan`
--

DROP TABLE IF EXISTS `csaborpan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `csaborpan` (
  `id_csp` int NOT NULL,
  `nom_csp` varchar(45) NOT NULL,
  PRIMARY KEY (`id_csp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `csaborpan`
--

LOCK TABLES `csaborpan` WRITE;
/*!40000 ALTER TABLE `csaborpan` DISABLE KEYS */;
/*!40000 ALTER TABLE `csaborpan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dventa`
--

DROP TABLE IF EXISTS `dventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dventa` (
  `id_dventa` int NOT NULL AUTO_INCREMENT,
  `id_pan` int NOT NULL,
  `cant_dventa` int NOT NULL,
  `subtotal_dvental` float NOT NULL,
  `total_dventa` float NOT NULL,
  `id_venta` int NOT NULL,
  `id_eusu` int NOT NULL,
  PRIMARY KEY (`id_dventa`),
  KEY `fk_DVenta_MPan1_idx` (`id_pan`),
  KEY `fk_DVenta_Mventa1_idx` (`id_venta`),
  KEY `fk_DVenta_EUsuario1_idx` (`id_eusu`),
  CONSTRAINT `fk_DVenta_EUsuario1` FOREIGN KEY (`id_eusu`) REFERENCES `eusuario` (`id_eusu`),
  CONSTRAINT `fk_DVenta_MPan1` FOREIGN KEY (`id_pan`) REFERENCES `mpan` (`id_pan`),
  CONSTRAINT `fk_DVenta_Mventa1` FOREIGN KEY (`id_venta`) REFERENCES `mventa` (`id_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dventa`
--

LOCK TABLES `dventa` WRITE;
/*!40000 ALTER TABLE `dventa` DISABLE KEYS */;
/*!40000 ALTER TABLE `dventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eusuario`
--

DROP TABLE IF EXISTS `eusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eusuario` (
  `id_eusu` int NOT NULL AUTO_INCREMENT,
  `id_usu` int NOT NULL,
  PRIMARY KEY (`id_eusu`),
  KEY `fk_EUsuario_MUsuario1_idx` (`id_usu`),
  CONSTRAINT `fk_EUsuario_MUsuario1` FOREIGN KEY (`id_usu`) REFERENCES `musuario` (`id_usu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eusuario`
--

LOCK TABLES `eusuario` WRITE;
/*!40000 ALTER TABLE `eusuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `eusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mpan`
--

DROP TABLE IF EXISTS `mpan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mpan` (
  `id_pan` int NOT NULL,
  `nom_pan` varchar(45) NOT NULL,
  `pre_pan` float NOT NULL,
  `stock_pan` varchar(45) NOT NULL,
  `id_cpan` int NOT NULL AUTO_INCREMENT,
  `id_csp` int NOT NULL,
  PRIMARY KEY (`id_pan`),
  KEY `fk_MPan_CPan_idx` (`id_cpan`),
  KEY `fk_MPan_CSaborPan1_idx` (`id_csp`),
  CONSTRAINT `fk_MPan_CPan` FOREIGN KEY (`id_cpan`) REFERENCES `cpan` (`id_cpan`),
  CONSTRAINT `fk_MPan_CSaborPan1` FOREIGN KEY (`id_csp`) REFERENCES `csaborpan` (`id_csp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mpan`
--

LOCK TABLES `mpan` WRITE;
/*!40000 ALTER TABLE `mpan` DISABLE KEYS */;
/*!40000 ALTER TABLE `mpan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musuario`
--

DROP TABLE IF EXISTS `musuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musuario` (
  `id_usu` int NOT NULL AUTO_INCREMENT,
  `nom_usu` varchar(45) NOT NULL,
  `appat_usu` varchar(45) NOT NULL,
  `user_usu` varchar(45) NOT NULL,
  `pass_usu` varchar(45) NOT NULL,
  `priv_usu` varchar(45) NOT NULL,
  PRIMARY KEY (`id_usu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musuario`
--

LOCK TABLES `musuario` WRITE;
/*!40000 ALTER TABLE `musuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `musuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mventa`
--

DROP TABLE IF EXISTS `mventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mventa` (
  `id_venta` int NOT NULL AUTO_INCREMENT,
  `fecha_venta` date NOT NULL,
  PRIMARY KEY (`id_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mventa`
--

LOCK TABLES `mventa` WRITE;
/*!40000 ALTER TABLE `mventa` DISABLE KEYS */;
/*!40000 ALTER TABLE `mventa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-09 14:48:34
