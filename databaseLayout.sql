-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: mydatabase
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.04.1
--
-- Table structure for table `users`
--
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `firstName` varchar(50) NOT NULL,
  `secondName` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` VALUES (
'Sean','Sanii Nejad','username','password'),
('Shiren','Quinn','Ines','cereal'),
('John','Wood','JohnStar','pancake'),
('Alex','Sun','Hello','World'),
('Sam','Tuck','SamuelPow','cheesecake');

-- Dump completed on 2021-03-27  0:02:20
