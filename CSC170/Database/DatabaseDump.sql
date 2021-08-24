CREATE DATABASE  IF NOT EXISTS `cape_codd` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cape_codd`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 10.1.11.26    Database: cape_codd
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
-- Table structure for table `BUYER`
--

DROP TABLE IF EXISTS `BUYER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BUYER` (
  `BuyerName` char(35) NOT NULL,
  `Department` char(30) NOT NULL,
  `Position` char(10) DEFAULT NULL,
  `Supervisor` char(35) DEFAULT NULL,
  PRIMARY KEY (`BuyerName`),
  KEY `BUYER_SUPERVISOR_FK` (`Supervisor`),
  CONSTRAINT `BUYER_SUPERVISOR_FK` FOREIGN KEY (`Supervisor`) REFERENCES `BUYER` (`BuyerName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BUYER`
--

LOCK TABLES `BUYER` WRITE;
/*!40000 ALTER TABLE `BUYER` DISABLE KEYS */;
INSERT INTO `BUYER` VALUES ('Cindy Lo','Purchasing','Buyer 2','Mary Smith'),('Jerry Martin','Purchasing','Buyer 1','Cindy Lo'),('Mary Smith','Purchasing','Manager',NULL),('Nancy Meyers','Purchasing','Buyer 1','Pete Hansen'),('Pete Hansen','Purchasing','Buyer 3','Mary Smith');
/*!40000 ALTER TABLE `BUYER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CATALOG_SKU_2016`
--

DROP TABLE IF EXISTS `CATALOG_SKU_2016`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CATALOG_SKU_2016` (
  `CatalogID` int(11) NOT NULL AUTO_INCREMENT,
  `SKU` int(11) NOT NULL,
  `SKU_Description` char(35) NOT NULL,
  `Department` char(30) NOT NULL,
  `CatalogPage` int(11) DEFAULT NULL,
  `DateOnWebSite` date DEFAULT NULL,
  PRIMARY KEY (`CatalogID`)
) ENGINE=InnoDB AUTO_INCREMENT=20160010 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATALOG_SKU_2016`
--

LOCK TABLES `CATALOG_SKU_2016` WRITE;
/*!40000 ALTER TABLE `CATALOG_SKU_2016` DISABLE KEYS */;
INSERT INTO `CATALOG_SKU_2016` VALUES (20160001,100100,'Std. Scuba Tank, Yellow','Water Sports',23,'2016-01-01'),(20160002,100500,'Std. Scuba Tank, Light Green','Water Sports',NULL,'2016-07-01'),(20160003,100600,'Std. Scuba Tank, Dark Green','Water Sports',NULL,'2016-07-01'),(20160004,101100,'Dive Mask, Small Clear','Water Sports',24,'2016-01-01'),(20160005,101200,'Dive Mask, Med Clear','Water Sports',24,'2016-01-01'),(20160006,201000,'Half-dome Tent','Camping',45,'2016-01-01'),(20160007,202000,'Half-dome Tent Vestibule','Camping',47,'2016-01-01'),(20160008,301000,'Light Fly Climbing Harness','Climbing',76,'2016-01-01'),(20160009,302000,'Locking Carabiner, Oval','Climbing',78,'2016-01-01');
/*!40000 ALTER TABLE `CATALOG_SKU_2016` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CATALOG_SKU_2017`
--

DROP TABLE IF EXISTS `CATALOG_SKU_2017`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CATALOG_SKU_2017` (
  `CatalogID` int(11) NOT NULL AUTO_INCREMENT,
  `SKU` int(11) NOT NULL,
  `SKU_Description` char(35) NOT NULL,
  `Department` char(30) NOT NULL,
  `CatalogPage` int(11) DEFAULT NULL,
  `DateOnWebSite` date DEFAULT NULL,
  PRIMARY KEY (`CatalogID`)
) ENGINE=InnoDB AUTO_INCREMENT=20170010 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATALOG_SKU_2017`
--

LOCK TABLES `CATALOG_SKU_2017` WRITE;
/*!40000 ALTER TABLE `CATALOG_SKU_2017` DISABLE KEYS */;
INSERT INTO `CATALOG_SKU_2017` VALUES (20170001,100100,'Std. Scuba Tank, Yellow','Water Sports',23,'2017-01-01'),(20170002,100300,'Std. Scuba Tank, Light Blue','Water Sports',23,'2017-01-01'),(20170003,100400,'Std. Scuba Tank, Dark Blue','Water Sports',NULL,'2017-08-01'),(20170004,101100,'Dive Mask, Small Clear','Water Sports',26,'2017-01-01'),(20170005,101200,'Dive Mask, Med Clear','Water Sports',26,'2017-01-01'),(20170006,201000,'Half-dome Tent','Camping',46,'2017-01-01'),(20170007,202000,'Half-dome Tent Vestibule','Camping',46,'2017-01-01'),(20170008,301000,'Light Fly Climbing Harness','Climbing',77,'2017-01-01'),(20170009,302000,'Locking Carabiner, Oval','Climbing',79,'2017-01-01');
/*!40000 ALTER TABLE `CATALOG_SKU_2017` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CATALOG_SKU_2018`
--

DROP TABLE IF EXISTS `CATALOG_SKU_2018`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CATALOG_SKU_2018` (
  `CatalogID` int(11) NOT NULL AUTO_INCREMENT,
  `SKU` int(11) NOT NULL,
  `SKU_Description` char(35) NOT NULL,
  `Department` char(30) NOT NULL,
  `CatalogPage` int(11) DEFAULT NULL,
  `DateOnWebSite` date DEFAULT NULL,
  PRIMARY KEY (`CatalogID`)
) ENGINE=InnoDB AUTO_INCREMENT=20180010 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATALOG_SKU_2018`
--

LOCK TABLES `CATALOG_SKU_2018` WRITE;
/*!40000 ALTER TABLE `CATALOG_SKU_2018` DISABLE KEYS */;
INSERT INTO `CATALOG_SKU_2018` VALUES (20180001,100100,'Std. Scuba Tank, Yellow','Water Sports',23,'2018-01-01'),(20180002,100200,'Std. Scuba Tank, Magenta','Water Sports',23,'2018-01-01'),(20180003,101100,'Dive Mask, Small Clear','Water Sports',27,'2018-01-01'),(20180004,101200,'Dive Mask, Med Clear','Water Sports',27,'2018-01-01'),(20180005,201000,'Half-dome Tent','Camping',45,'2018-01-01'),(20180006,202000,'Half-dome Tent Vestibule','Camping',45,'2018-01-01'),(20180007,203000,'Half-dome Tent Vestibule - Wide','Camping',NULL,'2018-04-01'),(20180008,301000,'Light Fly Climbing Harness','Climbing',76,'2018-01-01'),(20180009,302000,'Locking Carabiner, Oval','Climbing',78,'2018-01-01');
/*!40000 ALTER TABLE `CATALOG_SKU_2018` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CHATBOX`
--

DROP TABLE IF EXISTS `CHATBOX`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CHATBOX` (
  `name` text,
  `message` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHATBOX`
--

LOCK TABLES `CHATBOX` WRITE;
/*!40000 ALTER TABLE `CHATBOX` DISABLE KEYS */;
/*!40000 ALTER TABLE `CHATBOX` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INVENTORY`
--

DROP TABLE IF EXISTS `INVENTORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `INVENTORY` (
  `WarehouseID` int(11) NOT NULL,
  `SKU` int(11) NOT NULL,
  `SKU_Description` char(35) NOT NULL,
  `QuantityOnHand` int(11) DEFAULT NULL,
  `QuantityOnOrder` int(11) DEFAULT NULL,
  PRIMARY KEY (`WarehouseID`,`SKU`),
  KEY `SKU_DATA_Relationship` (`SKU`),
  CONSTRAINT `SKU_DATA_Relationship` FOREIGN KEY (`SKU`) REFERENCES `SKU_DATA` (`SKU`),
  CONSTRAINT `WAREHOUSE_Relationship` FOREIGN KEY (`WarehouseID`) REFERENCES `WAREHOUSE` (`WarehouseID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INVENTORY`
--

LOCK TABLES `INVENTORY` WRITE;
/*!40000 ALTER TABLE `INVENTORY` DISABLE KEYS */;
INSERT INTO `INVENTORY` VALUES (100,100100,'Std. Scuba Tank, Yellow',250,0),(100,100200,'Std. Scuba Tank, Magenta',200,30),(100,101100,'Dive Mask, Small Clear',0,500),(100,101200,'Dive Mask, Med Clear',100,500),(100,201000,'Half-dome Tent',2,100),(100,202000,'Half-dome Tent Vestibule',10,250),(100,301000,'Light Fly Climbing Harness',300,250),(100,302000,'Locking Carabiner, Oval',1000,0),(200,100100,'Std. Scuba Tank, Yellow',100,50),(200,100200,'Std. Scuba Tank, Magenta',75,75),(200,101100,'Dive Mask, Small Clear',0,500),(200,101200,'Dive Mask, Med Clear',50,500),(200,201000,'Half-dome Tent',10,250),(200,202000,'Half-dome Tent Vestibule',1,250),(200,301000,'Light Fly Climbing Harness',250,250),(200,302000,'Locking Carabiner, Oval',1250,0),(300,100100,'Std. Scuba Tank, Yellow',100,0),(300,100200,'Std. Scuba Tank, Magenta',100,100),(300,101100,'Dive Mask, Small Clear',300,200),(300,101200,'Dive Mask, Med Clear',475,0),(300,201000,'Half-dome Tent',250,0),(300,202000,'Half-dome Tent Vestibule',100,0),(300,301000,'Light Fly Climbing Harness',0,250),(300,302000,'Locking Carabiner, Oval',500,500),(400,100100,'Std. Scuba Tank, Yellow',200,0),(400,100200,'Std. Scuba Tank, Magenta',250,0),(400,101100,'Dive Mask, Small Clear',450,0),(400,101200,'Dive Mask, Med Clear',250,250),(400,201000,'Half-dome Tent',0,250),(400,202000,'Half-dome Tent Vestibule',0,200),(400,301000,'Light Fly Climbing Harness',0,250),(400,302000,'Locking Carabiner, Oval',0,1000);
/*!40000 ALTER TABLE `INVENTORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ORDER_ITEM`
--

DROP TABLE IF EXISTS `ORDER_ITEM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ORDER_ITEM` (
  `OrderNumber` int(11) NOT NULL,
  `SKU` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` decimal(9,2) NOT NULL,
  `ExtendedPrice` decimal(9,2) NOT NULL,
  PRIMARY KEY (`SKU`,`OrderNumber`),
  KEY `ORDER_ITEM_ORDER_FK` (`OrderNumber`),
  CONSTRAINT `ORDER_ITEM_ORDER_FK` FOREIGN KEY (`OrderNumber`) REFERENCES `RETAIL_ORDER` (`OrderNumber`),
  CONSTRAINT `ORDER_ITEM_SKU_FK` FOREIGN KEY (`SKU`) REFERENCES `SKU_DATA` (`SKU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ORDER_ITEM`
--

LOCK TABLES `ORDER_ITEM` WRITE;
/*!40000 ALTER TABLE `ORDER_ITEM` DISABLE KEYS */;
INSERT INTO `ORDER_ITEM` VALUES (3000,100200,1,300.00,300.00),(2000,101100,4,50.00,200.00),(3000,101100,2,50.00,100.00),(2000,101200,2,50.00,100.00),(3000,101200,1,50.00,50.00),(1000,201000,1,300.00,300.00),(1000,202000,1,130.00,130.00);
/*!40000 ALTER TABLE `ORDER_ITEM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RETAIL_ORDER`
--

DROP TABLE IF EXISTS `RETAIL_ORDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RETAIL_ORDER` (
  `OrderNumber` int(11) NOT NULL,
  `StoreNumber` int(11) DEFAULT NULL,
  `StoreZIP` char(9) DEFAULT NULL,
  `OrderMonth` char(12) NOT NULL,
  `OrderYear` int(11) NOT NULL,
  `OrderTotal` decimal(9,2) DEFAULT NULL,
  PRIMARY KEY (`OrderNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RETAIL_ORDER`
--

LOCK TABLES `RETAIL_ORDER` WRITE;
/*!40000 ALTER TABLE `RETAIL_ORDER` DISABLE KEYS */;
INSERT INTO `RETAIL_ORDER` VALUES (1000,10,'98110','December',2017,445.00),(2000,20,'02335','December',2017,310.00),(3000,10,'98110','January',2018,480.00);
/*!40000 ALTER TABLE `RETAIL_ORDER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SKU_DATA`
--

DROP TABLE IF EXISTS `SKU_DATA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SKU_DATA` (
  `SKU` int(11) NOT NULL,
  `SKU_Description` char(35) NOT NULL,
  `Department` char(30) NOT NULL,
  `Buyer` char(35) DEFAULT NULL,
  PRIMARY KEY (`SKU`),
  KEY `SKU_DATA_EMP_FK` (`Buyer`),
  CONSTRAINT `SKU_DATA_EMP_FK` FOREIGN KEY (`Buyer`) REFERENCES `BUYER` (`BuyerName`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SKU_DATA`
--

LOCK TABLES `SKU_DATA` WRITE;
/*!40000 ALTER TABLE `SKU_DATA` DISABLE KEYS */;
INSERT INTO `SKU_DATA` VALUES (100100,'Std. Scuba Tank, Yellow','Water Sports','Pete Hansen'),(100200,'Std. Scuba Tank, Magenta','Water Sports','Pete Hansen'),(100300,'Std. Scuba Tank, Light Blue','Water Sports','Pete Hansen'),(100400,'Std. Scuba Tank, Dark Blue','Water Sports','Pete Hansen'),(100500,'Std. Scuba Tank, Light Green','Water Sports','Pete Hansen'),(100600,'Std. Scuba Tank, Dark Green','Water Sports','Pete Hansen'),(101100,'Dive Mask, Small Clear','Water Sports','Nancy Meyers'),(101200,'Dive Mask, Med Clear','Water Sports','Nancy Meyers'),(201000,'Half-dome Tent','Camping','Cindy Lo'),(202000,'Half-dome Tent Vestibule','Camping','Cindy Lo'),(203000,'Half-dome Tent Vestibule - Wide','Camping','Cindy Lo'),(301000,'Light Fly Climbing Harness','Climbing','Jerry Martin'),(302000,'Locking Carabiner, Oval','Climbing','Jerry Martin');
/*!40000 ALTER TABLE `SKU_DATA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WAREHOUSE`
--

DROP TABLE IF EXISTS `WAREHOUSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WAREHOUSE` (
  `WarehouseID` int(11) NOT NULL,
  `WarehouseCity` char(30) NOT NULL,
  `WarehouseState` char(2) NOT NULL,
  `Manager` char(35) DEFAULT NULL,
  `SquareFeet` int(11) DEFAULT NULL,
  PRIMARY KEY (`WarehouseID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WAREHOUSE`
--

LOCK TABLES `WAREHOUSE` WRITE;
/*!40000 ALTER TABLE `WAREHOUSE` DISABLE KEYS */;
INSERT INTO `WAREHOUSE` VALUES (100,'Atlanta','GA','Dave Jones',125000),(200,'Chicago','IL','Lucille Smith',100000),(300,'Bangor','ME','Bart Evans',150000),(400,'Seattle','WA','Dale Rogers',130000),(500,'San Francisco','CA','Grace Jefferson',200000);
/*!40000 ALTER TABLE `WAREHOUSE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `people` (
  `name` text,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-24 11:49:27
