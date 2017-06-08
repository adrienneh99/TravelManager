CREATE DATABASE  IF NOT EXISTS `travel_manager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `travel_manager`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 127.0.0.1    Database: travel_manager
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `accountID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `userRole` varchar(45) NOT NULL,
  PRIMARY KEY (`accountID`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'jtraveler','broncosrule','Standard'),(2,'sbsupport','happylady','Administrator'),(3,'adrienneh','kailiefolsom','Standard'),(4,'adrienneh99','kailiefolsom','Administrator'),(5,'mikemajor','folsomkailie','Standard'),(35,'ertyerty','ertyerty','Standard'),(36,'littlebuddy22','crazydoggy','Standard'),(56,'joeshmow','joeshmow22','Standard'),(60,'ghjgjghkghkgtfghfd','sddfggdgfdgf','Standard'),(67,'lkjdslajfslljll','lskjflskjfldsjlf','Standard'),(96,'s4sdfg4sdr','dgx4serer','Standard'),(112,'asdkjfha2323','kajsdkfue32323','Standard'),(131,'herewego','mtm012275','Standard'),(132,'aggieade','kailiefolsom','Administrator');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airline`
--

DROP TABLE IF EXISTS `airline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airline` (
  `airlineID` int(11) NOT NULL AUTO_INCREMENT,
  `airlineName` varchar(45) NOT NULL,
  `seatPref` varchar(45) DEFAULT NULL,
  `airlineRewardNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`airlineID`),
  UNIQUE KEY `airlineName_UNIQUE` (`airlineName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airline`
--

LOCK TABLES `airline` WRITE;
/*!40000 ALTER TABLE `airline` DISABLE KEYS */;
INSERT INTO `airline` VALUES (1,'United','aisle','A1234'),(2,'Frontier','window','A5678');
/*!40000 ALTER TABLE `airline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `hotelID` int(11) NOT NULL AUTO_INCREMENT,
  `hotelName` varchar(45) NOT NULL,
  `roomCategory` varchar(45) DEFAULT NULL,
  `bedType` varchar(45) DEFAULT NULL,
  `roomLocation` varchar(45) DEFAULT NULL,
  `accessibility` tinyint(1) DEFAULT '0',
  `hotelRewardNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`hotelID`),
  UNIQUE KEY `hotelName_UNIQUE` (`hotelName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'Marriott','standard','1 king','high floor',0,'H1234'),(2,'Starwood','deluxe','1 king','near elevator',0,'H5678');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `accountID` int(11) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `middleName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `primaryAddress` varchar(45) NOT NULL,
  `primaryCity` varchar(45) NOT NULL,
  `primaryState` varchar(45) NOT NULL,
  `primaryZip` varchar(45) NOT NULL,
  `primaryEmail` varchar(45) NOT NULL,
  `primaryPhone` varchar(45) NOT NULL,
  `gender` char(1) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `passportNum` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`accountID`),
  CONSTRAINT `fk_accountID` FOREIGN KEY (`accountID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (3,'Adrienne','Helms','Major','1662 S Lafayette Street','Denver','CO','80210','ade@gmail.com','720-381-9141','F','1977-06-09','123456789'),(35,'ertyerty','ertyerty','ertyerty','ertyerty','ertyerty','CO','54648','ioasdfliauds@cas.com','555-555-5555','M','1985-01-28','123456789'),(36,'Folsom','M','Major','1662 S Lafayette Street','Pueblo','CO','80210','buddy@gmail.com','303-882-8455','M','2000-05-01','123456789'),(56,'Joe','T','Shmow','1234 Drive','Denver','CO','80202','joe@gmail.com','123-456-7890','M','1960-01-01','123456789'),(60,'Joe','T','Miller','1234 Avenue','Denver','CO','80202','jmiller@yahoo.com','123-456-7890','M','1965-01-01','123654987'),(67,'lkjlkjljl','j','lkjlkjlj','1234 Street','Denver','CO','80210','lkj@yahoo.com','123-456-7890','M','1968-01-01','123456789'),(96,'Msdfgosq','I','ASDfado','23423 S aslidf','Denver','CO','80210','aksdhfkal@asdf.com','303-225-2255','M','1956-01-22','123456789'),(112,'Michael','T','Major','133 S Rine St','Denver','CO','80211','helo@hello.com','303-998-8866','M','1975-01-22','524450397'),(132,'Adrienne','Helms','Major','1662 S Lafayette Street','Denver','CO','80210','ade@gmail.com','720-381-9141','F','1977-06-09','123456789');
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentalCar`
--

DROP TABLE IF EXISTS `rentalCar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rentalCar` (
  `rentalCarID` int(11) NOT NULL AUTO_INCREMENT,
  `rentalCarCompName` varchar(45) NOT NULL,
  `rentalCarType` varchar(45) DEFAULT NULL,
  `rentalCarRewardNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rentalCarID`),
  UNIQUE KEY `rentalCarCompName_UNIQUE` (`rentalCarCompName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentalCar`
--

LOCK TABLES `rentalCar` WRITE;
/*!40000 ALTER TABLE `rentalCar` DISABLE KEYS */;
INSERT INTO `rentalCar` VALUES (1,'Hertz','compact','C1234'),(2,'Enterprise','standard','C5678');
/*!40000 ALTER TABLE `rentalCar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travelPrefs`
--

DROP TABLE IF EXISTS `travelPrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `travelPrefs` (
  `travelPrefsID` int(11) NOT NULL AUTO_INCREMENT,
  `airlineID` int(11) DEFAULT NULL,
  `hotelID` int(11) DEFAULT NULL,
  `rentalCarID` int(11) DEFAULT NULL,
  PRIMARY KEY (`travelPrefsID`),
  KEY `fk_airlineID_idx` (`airlineID`),
  KEY `fk_hotelID_idx` (`hotelID`),
  KEY `fk_rentalCarID_idx` (`rentalCarID`),
  CONSTRAINT `fk_airlineID` FOREIGN KEY (`airlineID`) REFERENCES `airline` (`airlineID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_hotelID` FOREIGN KEY (`hotelID`) REFERENCES `hotel` (`hotelID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rentalCarID` FOREIGN KEY (`rentalCarID`) REFERENCES `rentalCar` (`rentalCarID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travelPrefs`
--

LOCK TABLES `travelPrefs` WRITE;
/*!40000 ALTER TABLE `travelPrefs` DISABLE KEYS */;
INSERT INTO `travelPrefs` VALUES (1,1,1,1),(2,2,2,2);
/*!40000 ALTER TABLE `travelPrefs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-01 23:07:03
