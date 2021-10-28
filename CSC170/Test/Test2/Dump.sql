-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 10.1.11.26    Database: TESTSCHEMA09
-- ------------------------------------------------------
-- Server version	5.7.33-0ubuntu0.16.04.1

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
-- Table structure for table `CLASSES`
--

DROP TABLE IF EXISTS `CLASSES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLASSES` (
  `ClassID` int(11) NOT NULL,
  `Day` varchar(10) NOT NULL,
  `Time` varchar(10) NOT NULL,
  `InstructorID` int(11) NOT NULL,
  PRIMARY KEY (`ClassID`),
  KEY `InstructorID_idx` (`InstructorID`),
  CONSTRAINT `InstructorID` FOREIGN KEY (`InstructorID`) REFERENCES `INSTRUCTOR` (`InstructorID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLASSES`
--

LOCK TABLES `CLASSES` WRITE;
/*!40000 ALTER TABLE `CLASSES` DISABLE KEYS */;
INSERT INTO `CLASSES` VALUES (101,'Wednesday','10:30am',1),(102,'Tuesday','10:00am',1),(103,'Thursday','9:00am',2);
/*!40000 ALTER TABLE `CLASSES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DANCER`
--

DROP TABLE IF EXISTS `DANCER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DANCER` (
  `DancerID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `Phone` varchar(45) NOT NULL,
  `Age` varchar(45) NOT NULL,
  `Parent/Guardian` varchar(45) NOT NULL,
  PRIMARY KEY (`DancerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DANCER`
--

LOCK TABLES `DANCER` WRITE;
/*!40000 ALTER TABLE `DANCER` DISABLE KEYS */;
INSERT INTO `DANCER` VALUES (1,'Akhil','123 Main St','123-456-7890','17','Jane'),(2,'Benjamin','321 Main St','987-654-3210','17','John');
/*!40000 ALTER TABLE `DANCER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INSTRUCTOR`
--

DROP TABLE IF EXISTS `INSTRUCTOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `INSTRUCTOR` (
  `InstructorID` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`InstructorID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INSTRUCTOR`
--

LOCK TABLES `INSTRUCTOR` WRITE;
/*!40000 ALTER TABLE `INSTRUCTOR` DISABLE KEYS */;
INSERT INTO `INSTRUCTOR` VALUES (1,'Joseph'),(2,'Billy');
/*!40000 ALTER TABLE `INSTRUCTOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROSTER`
--

DROP TABLE IF EXISTS `ROSTER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ROSTER` (
  `ClassID` int(11) NOT NULL,
  `DancerID` int(11) NOT NULL,
  PRIMARY KEY (`ClassID`,`DancerID`),
  KEY `DancerID_idx` (`DancerID`),
  CONSTRAINT `ClassID` FOREIGN KEY (`ClassID`) REFERENCES `CLASSES` (`ClassID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DancerID` FOREIGN KEY (`DancerID`) REFERENCES `DANCER` (`DancerID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROSTER`
--

LOCK TABLES `ROSTER` WRITE;
/*!40000 ALTER TABLE `ROSTER` DISABLE KEYS */;
INSERT INTO `ROSTER` VALUES (101,1),(103,1),(101,2),(102,2);
/*!40000 ALTER TABLE `ROSTER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-28 11:52:00
