
-- Host: localhost    Database: assignment3
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.04.1

-- Table structure for table `AdminStaff`
DROP TABLE IF EXISTS `AdminStaff`;
CREATE TABLE `AdminStaff` (
  `EmpID` int NOT NULL,
  `Forename` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `Gender` enum('M','F','O') NOT NULL,
  `PhoneNo` varchar(15) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Role` varchar(20) NOT NULL,
  `SchoolID` int NOT NULL,
  PRIMARY KEY (`EmpID`),
  KEY `SchoolID` (`SchoolID`),
  CONSTRAINT `AdminStaff_ibfk_1` FOREIGN KEY (`SchoolID`) REFERENCES `School` (`SchoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
LOCK TABLES `AdminStaff` WRITE;
INSERT INTO `AdminStaff` VALUES (1006,'Fred','Grimes','M','012275435665','27 Cherry Street','assistant',2),(1009,'Jill','Joffries','F','+44776618645','27 Cherry Street','manager',1),(1019,'Justine','Joffries','F','(01227)812035','19 Creosote Road','assistant',1);
UNLOCK TABLES;

-- Table structure for table `Car`
DROP TABLE IF EXISTS `Car`;
CREATE TABLE `Car` (
  `CarID` int NOT NULL,
  `RegNo` varchar(10) NOT NULL,
  `Model` varchar(50) NOT NULL,
  PRIMARY KEY (`CarID`),
  UNIQUE KEY `CarID` (`CarID`),
  UNIQUE KEY `RegNo` (`RegNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
LOCK TABLES `Car` WRITE;
INSERT INTO `Car` VALUES (124,'BD51 SMR','VW Polo'),(167,'FD52 YTR','VW Polo'),(653,'WS62 QWE','Ford Focus'),(912,'FD52 TGF','VW Polo');
UNLOCK TABLES;

-- Table structure for table `Centre`
DROP TABLE IF EXISTS `Centre`;
CREATE TABLE `Centre` (
  `CentreID` int NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `PhoneNo` varchar(50) NOT NULL,
  PRIMARY KEY (`CentreID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
LOCK TABLES `Centre` WRITE;
INSERT INTO `Centre` VALUES (1,'Canterbury','12 Meryl Street','+44 1227-968-5287'),(2,'Whitstable','5 The Strand, Whitstable','01227457012'),(3,'Faversham','1 High Street','01795 865129');
UNLOCK TABLES;

-- Table structure for table `Client`
DROP TABLE IF EXISTS `Client`;
CREATE TABLE `Client` (
  `ClientID` int NOT NULL,
  `Forename` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `Gender` enum('M','F','O') NOT NULL,
  `DoB` date NOT NULL,
  `PhoneNo` varchar(15) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `ProvLicenceNo` varchar(20) NOT NULL,
  `SchoolID` int NOT NULL,
  PRIMARY KEY (`ClientID`),
  UNIQUE KEY `ProvLicenceNo` (`ProvLicenceNo`),
  KEY `SchoolID` (`SchoolID`),
  CONSTRAINT `Client_ibfk_1` FOREIGN KEY (`SchoolID`) REFERENCES `School` (`SchoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
LOCK TABLES `Client` WRITE;
INSERT INTO `Client` VALUES (1,'Andy','Twill','M','1998-02-01','00446784129876','27 Cherry Street,CT4 7NF','TYH7890',2),(2,'Sue','Adams','F','1989-06-14','0841-234-876','45 Eggy Lane','CIO67891',1),(3,'Jean','Adams','F','2001-11-19','01227765329','4 Harkness Lane, Canterbury','RTY678923',1);
UNLOCK TABLES;

-- Table structure for table `Instructor`
DROP TABLE IF EXISTS `Instructor`;
CREATE TABLE `Instructor` (
  `EmpID` int NOT NULL,
  `Forename` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `Gender` enum('M','F','O') NOT NULL,
  `PhoneNo` varchar(15) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `LicenceNo` varchar(15) NOT NULL,
  `SchoolID` int NOT NULL,
  `CarID` int NOT NULL,
  PRIMARY KEY (`EmpID`),
  UNIQUE KEY `LicenceNo` (`LicenceNo`),
  KEY `SchoolID` (`SchoolID`),
  CONSTRAINT `Instructor_ibfk_1` FOREIGN KEY (`SchoolID`) REFERENCES `School` (`SchoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
LOCK TABLES `Instructor` WRITE;
INSERT INTO `Instructor` VALUES (2009,'James','Joffries','M','012275435665','27 Cherry Street','FTR76398',1,124),(2011,'Jim','Adams','M','065490125674','4 The Vale','TGY98555a',2,912),(2013,'Trinny','Vair','F','0044587208725','17 High Street, Chartham','YHF7665467',1,653);
UNLOCK TABLES;

-- Table structure for table `Lesson`
DROP TABLE IF EXISTS `Lesson`;
CREATE TABLE `Lesson` (
  `OnDate` date NOT NULL,
  `OnTime` time NOT NULL,
  `ClientID` int NOT NULL,
  `EmpID` int NOT NULL,
  PRIMARY KEY (`OnDate`,`OnTime`,`ClientID`),
  UNIQUE KEY `OnDate` (`OnDate`,`OnTime`,`EmpID`),
  KEY `EmpID` (`EmpID`),
  CONSTRAINT `Lesson_ibfk_1` FOREIGN KEY (`EmpID`) REFERENCES `Instructor` (`EmpID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
LOCK TABLES `Lesson` WRITE;
INSERT INTO `Lesson` VALUES ('2019-06-07','10:00:00',2,2009),('2020-08-17','16:00:00',2,2009),('2020-06-24','10:00:00',1,2011),('2020-07-12','14:00:00',1,2011),('2020-08-01','14:00:00',1,2011),('2020-08-19','16:00:00',1,2011);
UNLOCK TABLES;

-- Table structure for table `School`
DROP TABLE IF EXISTS `School`;
CREATE TABLE `School` (
  `SchoolID` int NOT NULL,
  `Address` varchar(100) NOT NULL,
  PRIMARY KEY (`SchoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
LOCK TABLES `School` WRITE;
INSERT INTO `School` VALUES (1,'12 Whitechapel, Canterbury'),(2,'9 Middle Wall, Whitestable');
UNLOCK TABLES;

-- Table structure for table `Test`
DROP TABLE IF EXISTS `Test`;
CREATE TABLE `Test` (
  `OnDate` date NOT NULL,
  `OnTime` time NOT NULL,
  `ClientID` int NOT NULL,
  `EmpID` int NOT NULL,
  `CentreID` int NOT NULL,
  `Status` enum('Not Taken','Passed','Failed') NOT NULL,
  `Reason` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`OnDate`,`OnTime`,`ClientID`),
  UNIQUE KEY `OnDate` (`OnDate`,`OnTime`,`EmpID`),
  KEY `ClientID` (`ClientID`),
  KEY `EmpID` (`EmpID`),
  KEY `CentreID` (`CentreID`),
  CONSTRAINT `Test_ibfk_1` FOREIGN KEY (`ClientID`) REFERENCES `Client` (`ClientID`),
  CONSTRAINT `Test_ibfk_2` FOREIGN KEY (`EmpID`) REFERENCES `Instructor` (`EmpID`),
  CONSTRAINT `Test_ibfk_3` FOREIGN KEY (`CentreID`) REFERENCES `Centre` (`CentreID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
LOCK TABLES `Test` WRITE;
INSERT INTO `Test` VALUES ('2019-08-13','13:00:00',2,2009,3,'Failed','Lack of Observation'),('2019-10-21','11:00:00',2,2009,2,'Failed','Speeding'),('2020-08-19','10:00:00',2,2013,2,'Not Taken',''),('2021-03-01','11:00:00',1,2011,2,'Passed','');
UNLOCK TABLES;

-- Dump completed on 2021-04-05 22:04:31
