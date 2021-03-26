-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: mydatabase
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.04.1

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `firstName` varchar(50) NOT NULL,
  `secondName` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES ('Sean','Sanii Nejad','username','password'),('Shiren','Sanii Nejad','username2','password2');

UNLOCK TABLES;


-- Dump completed on 2021-03-26 20:26:41
