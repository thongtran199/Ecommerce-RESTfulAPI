-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: java7
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `supplierid` int NOT NULL AUTO_INCREMENT,
  `company_name` text,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `contact_person` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `contact_email` varchar(255) DEFAULT NULL,
  `contact_fax` varchar(255) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`supplierid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'Mascetur','8496 Sed St.','Gia Lai','Pleiku','36447','United States','Montana Griffin','1-547-354-2975','Vivamus.non@gmail.com','1-747-514-7405',_binary ''),(2,'Vivamusdapibus','P.O. Box 185, 7096 Fusce St.','Quang Ngai','Duc Pho','12392','United States','Jamal Ward','1-808-398-1802','Cras@purusNullamscelerisque.ca','1-633-148-7287',_binary ''),(3,'Luctus sit','747-1877 Fusce Street','Ho Chi Minh','Tan Phu','45116','United States','Breanna Tran','1-179-453-8363','interdum@ametfaucibus.com','1-402-203-9423',_binary ''),(4,'Mauris','6077 Id St.','Ho Chi Minh','Quan 5','71245','United States','Armando Whitfield','1-201-374-3545','scelerisque.neque@Loremipsumdolor.com','1-214-295-9506',_binary ''),(5,'Sed','Ap #924-2093 Nisi Road','Ho Chi Minh','Quan 4','61177','United States','Venus Tyson','1-635-591-2113','eget@Sed.com','1-624-477-4294',_binary ''),(6,'Aliquam','Ap #559-963 Aliquet. Avenue','Gia Lai','Pleiku','46316','United States','Gil Watts','1-384-828-2779','mollis.lectus@Donectempus.co.uk','1-921-770-8330',_binary ''),(7,'Phasellus','396-5140 Sodales Rd.','Ho Chi Minh','Tan Phu','72723','United States','Galvin Keller','1-870-828-3188','dignissim@euduiCum.com','1-266-190-0065',_binary ''),(8,'P&G','4166 Id Avenue','Quang Ngai','Duc Pho','93824','United States','Xanthus Phillips','1-592-174-7801','ridiculus@condimentumDonecat.com','1-137-184-4261',_binary ''),(9,'Praesent eu dui','P.O. Box 135, 8772 Mauris Avenue','Gia Lai','Pleiku','34193','United States','Yael Reyes','1-925-532-3739','eleifend.vitae@pretiumaliquet.com','1-795-854-4581',_binary ''),(10,'tortor Integer','824-4773 Neque. Avenue','Gia Lai','Pleiku','99315','United States','McKenzie Owen','1-156-811-6215','elit.pede.malesuada@euaccumsansed.net','1-577-204-1040',_binary '');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-08 20:19:26
