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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel_number` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `ship_address` varchar(255) DEFAULT NULL,
  `ship_city` varchar(255) DEFAULT NULL,
  `ship_state` varchar(255) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `image` text,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'customer1909','{noop}123456','customer1909@gmail.com','0842190902','ROLE_CUSTOMER','Văn Thông','273 Trịnh Đình Trọng','Hồ Chí Minh','Tân Phú',_binary '','default.png'),(2,'admin1506','{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG','admin1909@gmail.com','0842190903','ROLE_ADMIN','Nguyễn Thị Thanh Ngân','450 Thành Thái','Hồ Chí Minh','Quận 10',_binary '','default.png'),(3,'seller1406','{noop}123456','seller1909@gmail.com','0842190904','ROLE_SELLER','Nguyễn Phương Uyên','75 Võ Văn Tần','Hồ Chí Minh','Quận 3',_binary '','default.png'),(4,'customer1807','{noop}123456','customer1807@gmail.com','0842190905','ROLE_CUSTOMER','Nguyễn Thị Ngọc Thương','56 Tôn Đản','Hồ Chí Minh','Quận 4',_binary '','default.png'),(5,'seller0104','{noop}123456','seller0104@gmail.com','0842190906','ROLE_SELLER','Võ Nhất Khanh','200 Nguyễn Tri Phương','Hồ Chí Minh','Quận 10',_binary '','default.png'),(8,'yenvy123','{noop}123456','vydang@gmail.com','0842130745','ROLE_ADMIN','Đặng Yến Zy','Phổ Quang','Quảng Ngãi','Đức Phổ',_binary '\0','default.png');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
