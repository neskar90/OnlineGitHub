-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: assoccontracancer
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `corredores`
--

DROP TABLE IF EXISTS `corredores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `corredores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `fechanacimiento` varchar(45) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corredores`
--

LOCK TABLES `corredores` WRITE;
/*!40000 ALTER TABLE `corredores` DISABLE KEYS */;
INSERT INTO `corredores` VALUES (31,'ppp','Bronchart','renaudbronchart@gmail.com','Y3737270Z','2024-05-15','Hombre','Calle de la Infanta Mercedes','Madrid','fgdgfd'),(32,'yrdy','Bronchart','renaudbronchart@gmail.com','Y3737270Z','2024-05-27','Hombre','Calle de la Infanta Mercedes','Madrid','65445575'),(34,'ole','Bronchart','renaudbronchart@gmail.com','Y3737270Z','2024-05-27','Hombre','Calle de la Infanta Mercedes','Madrid','65445575'),(39,'ppp','Bronchart','renaudbronchart@gmail.com','Y3737270Z','2024-05-08','Hombre','Calle de la Infanta Mercedes','Madrid','fgdgfd'),(79,'Soy','test','1','dqsdsq','','','Calle de la Infanta Mercedes','Madrid',''),(80,'fds','test','1','dqsdsq','','','Calle de la Infanta Mercedes','Madrid',''),(81,'test','test','','','','','Calle de la Infanta Mercedes','Madrid','');
/*!40000 ALTER TABLE `corredores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-01 10:53:56
