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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cartid` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`cartid`),
  UNIQUE KEY `UK_h868whf0f0joui0xwh481wwbg` (`userid`),
  CONSTRAINT `FK1f3la5ofi3papq9kbt0yqkab7` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,0,1);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_detail`
--

DROP TABLE IF EXISTS `cart_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_detail` (
  `cart_detailid` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `cartid` int DEFAULT NULL,
  `productid` int DEFAULT NULL,
  PRIMARY KEY (`cart_detailid`),
  KEY `FKagosfrfvotpq41fl4nm9tmqey` (`cartid`),
  KEY `FKlbnemvb750tku7ufh3ervfn87` (`productid`),
  CONSTRAINT `FKagosfrfvotpq41fl4nm9tmqey` FOREIGN KEY (`cartid`) REFERENCES `cart` (`cartid`),
  CONSTRAINT `FKlbnemvb750tku7ufh3ervfn87` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_detail`
--

LOCK TABLES `cart_detail` WRITE;
/*!40000 ALTER TABLE `cart_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `categoryid` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Điện thoại','default.jpg',_binary ''),(2,'Laptop','default.jpg',_binary ''),(3,'Đồng hồ','default.jpg',_binary ''),(4,'Tai nghe','default.jpg',_binary ''),(5,'Máy cũ','default.jpg',_binary ''),(11,'dien thoaiii','default.jpg',_binary '');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `order_detailid` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `orderid` int DEFAULT NULL,
  `productid` int DEFAULT NULL,
  PRIMARY KEY (`order_detailid`),
  KEY `FK715ucxrvknue1cfnb458qh5n5` (`orderid`),
  KEY `FKlsvx45m4io6a6fdwpa14pvn92` (`productid`),
  CONSTRAINT `FK715ucxrvknue1cfnb458qh5n5` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`),
  CONSTRAINT `FKlsvx45m4io6a6fdwpa14pvn92` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `status` int DEFAULT NULL,
  `total` float DEFAULT NULL,
  `paymentid` int DEFAULT NULL,
  `sellerid` int DEFAULT NULL,
  `shippingid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `FKpl79a31yafgam9c0tklym0lbu` (`paymentid`),
  KEY `FKsog13762rb5fh68ha57h9d6p5` (`sellerid`),
  KEY `FKcqp8k0vamxe1ha3srktuxmupx` (`shippingid`),
  KEY `FKpnm1eeupqm4tykds7k3okqegv` (`userid`),
  CONSTRAINT `FKcqp8k0vamxe1ha3srktuxmupx` FOREIGN KEY (`shippingid`) REFERENCES `shipment` (`shippingid`),
  CONSTRAINT `FKpl79a31yafgam9c0tklym0lbu` FOREIGN KEY (`paymentid`) REFERENCES `payment` (`paymentid`),
  CONSTRAINT `FKpnm1eeupqm4tykds7k3okqegv` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`),
  CONSTRAINT `FKsog13762rb5fh68ha57h9d6p5` FOREIGN KEY (`sellerid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (3,_binary '','2023-11-16','2023-11-17',2,79170000,NULL,NULL,5,1),(4,_binary '\0','2023-11-16','2023-11-16',1,78170000,3,NULL,6,1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `paymentid` int NOT NULL AUTO_INCREMENT,
  `card_type` varchar(255) DEFAULT NULL,
  `cred_exp_mo` int DEFAULT NULL,
  `cred_exp_yr` int DEFAULT NULL,
  `credit_card` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`paymentid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (3,'MASTERCARD',12,2024,'12345678');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productid` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  `supplierid` int DEFAULT NULL,
  `categoryid` int DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `image` text,
  `description` text,
  `is_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`productid`),
  KEY `FK4ort9abhumpx4t2mlngljr1vi` (`categoryid`),
  KEY `FKl22gu83pf6q9mbke1ln8wjbhx` (`supplierid`),
  CONSTRAINT `FK4ort9abhumpx4t2mlngljr1vi` FOREIGN KEY (`categoryid`) REFERENCES `category` (`categoryid`),
  CONSTRAINT `FKl22gu83pf6q9mbke1ln8wjbhx` FOREIGN KEY (`supplierid`) REFERENCES `supplier` (`supplierid`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Iphone 15',1,1,1257,50,'Xanh dương','phone1.jpg','The iPhone 15 Pro Max comes with 6.7-inch OLED display with 120Hz refresh rate and Apple\'s improved A17 Pro processor. On the back there is a Triple camera setup with 48MP main camera and the prices start at 1199$. Technology solutions sales professionals meet with businesses to determine their needs for various electronic hardware and software products and services. They then work with their clients to develop and implement cost-effective and efficient solutions.',_binary ''),(2,'Iphone 12',2,1,587,100,'Vàng','phone2.jpg','The iPhone 15 Pro Max comes with 6.7-inch OLED display with 120Hz refresh rate and Apple\'s improved A17 Pro processor. On the back there is a Triple camera setup with 48MP main camera and the prices start at 1199$. Technology solutions sales professionals meet with businesses to determine their needs for various electronic hardware and software products and services. They then work with their clients to develop and implement cost-effective and efficient solutions.',_binary ''),(3,'Iphone 15 Pro Max',1,1,1487,80,'Xanh lá','phone3.jpg','The iPhone 15 Pro Max comes with 6.7-inch OLED display with 120Hz refresh rate and Apple\'s improved A17 Pro processor. On the back there is a Triple camera setup with 48MP main camera and the prices start at 1199$. Technology solutions sales professionals meet with businesses to determine their needs for various electronic hardware and software products and services. They then work with their clients to develop and implement cost-effective and efficient solutions.',_binary ''),(4,'Iphone 14 Pro Max',3,1,1187,100,'Đỏ','phone4.jpg','The iPhone 15 Plus comes with 6.7-inch OLED display with 120Hz refresh rate and Apple\'s improved A17 Pro processor. On the back there is a Triple camera setup with 48MP main camera and the prices start at 1199$. Technology solutions sales professionals meet with businesses to determine their needs for various electronic hardware and software products and services. They then work with their clients to develop and implement cost-effective and efficient solutions.',_binary ''),(5,'Iphone 14 Plus',4,1,956,80,'Đen','phone5.jpg','The iPhone 15 Pro Max comes with 6.7-inch OLED display with 120Hz refresh rate and Apple\'s improved A17 Pro processor. On the back there is a Triple camera setup with 48MP main camera and the prices start at 1199$. Technology solutions sales professionals meet with businesses to determine their needs for various electronic hardware and software products and services. They then work with their clients to develop and implement cost-effective and efficient solutions.',_binary ''),(6,'Samsung Galaxy Z Flip4 5G',4,1,565,100,'Xanh lá','phone6.jpg','Samsung Galaxy Z Flip4 5G supports frequency bands GSM , HSPA , LTE. Official announcement date is July 2022. The device is working on an Android 6.0 (Marshmallow) with a Quad-core 1.4 GHz Cortex-A53 processor and 2 GB RAM memory. Samsung Galaxy Folder2 has 16 GB of internal memory. This device has a Qualcomm MSM8917 Snapdragon 425 chipset. The main screen size is displaysize3.8 inches, 41.1 cm2 with 480 x 800 pixels, 5:3 ratio resolution. It has a 246 ppi density) ppi pixel density. The screen covers about 56.0% of the device is body. The result is quite good.',_binary ''),(7,'Samsung Galaxy Z Fold5 5G',5,1,1130,100,'Xanh dương','phone7.jpg','Samsung Galaxy Z Fold5 5G supports frequency bands GSM , HSPA , LTE. Official announcement date is July 2022. The device is working on an Android 6.0 (Marshmallow) with a Quad-core 1.4 GHz Cortex-A53 processor and 2 GB RAM memory. Samsung Galaxy Folder2 has 16 GB of internal memory. This device has a Qualcomm MSM8917 Snapdragon 425 chipset. The main screen size is displaysize3.8 inches, 41.1 cm2 with 480 x 800 pixels, 5:3 ratio resolution. It has a 246 ppi density) ppi pixel density. The screen covers about 56.0% of the device is body. The result is quite good.',_binary ''),(8,'Samsung Galaxy S23 FE 5G',6,1,630,100,'Xanh dương','phone8.jpg','Samsung Galaxy S23 FE 5G supports frequency bands GSM , HSPA , LTE. Official announcement date is July 2022. The device is working on an Android 6.0 (Marshmallow) with a Quad-core 1.4 GHz Cortex-A53 processor and 2 GB RAM memory. Samsung Galaxy Folder2 has 16 GB of internal memory. This device has a Qualcomm MSM8917 Snapdragon 425 chipset. The main screen size is displaysize3.8 inches, 41.1 cm2 with 480 x 800 pixels, 5:3 ratio resolution. It has a 246 ppi density) ppi pixel density. The screen covers about 56.0% of the device is body. The result is quite good.',_binary ''),(9,'Samsung Galaxy S23 FE 5G',8,1,630,60,'Vàng','phone9.jpg','Samsung Galaxy S23 FE 5G supports frequency bands GSM , HSPA , LTE. Official announcement date is July 2022. The device is working on an Android 6.0 (Marshmallow) with a Quad-core 1.4 GHz Cortex-A53 processor and 2 GB RAM memory. Samsung Galaxy Folder2 has 16 GB of internal memory. This device has a Qualcomm MSM8917 Snapdragon 425 chipset. The main screen size is displaysize3.8 inches, 41.1 cm2 with 480 x 800 pixels, 5:3 ratio resolution. It has a 246 ppi density) ppi pixel density. The screen covers about 56.0% of the device is body. The result is quite good.',_binary ''),(10,'Samsung Galaxy Z Flip4 5G',9,1,543,60,'Vàng','phone10.jpg','Samsung Galaxy Z Flip4 5G supports frequency bands GSM , HSPA , LTE. Official announcement date is July 2022. The device is working on an Android 6.0 (Marshmallow) with a Quad-core 1.4 GHz Cortex-A53 processor and 2 GB RAM memory. Samsung Galaxy Folder2 has 16 GB of internal memory. This device has a Qualcomm MSM8917 Snapdragon 425 chipset. The main screen size is displaysize3.8 inches, 41.1 cm2 with 480 x 800 pixels, 5:3 ratio resolution. It has a 246 ppi density) ppi pixel density. The screen covers about 56.0% of the device is body. The result is quite good.',_binary ''),(11,'Samsung Galaxy S23 Ultra 5G',10,1,911,80,'Đen','phone11.jpg','Samsung Galaxy S23 Ultra 5G supports frequency bands GSM , HSPA , LTE. Official announcement date is July 2022. The device is working on an Android 6.0 (Marshmallow) with a Quad-core 1.4 GHz Cortex-A53 processor and 2 GB RAM memory. Samsung Galaxy Folder2 has 16 GB of internal memory. This device has a Qualcomm MSM8917 Snapdragon 425 chipset. The main screen size is displaysize3.8 inches, 41.1 cm2 with 480 x 800 pixels, 5:3 ratio resolution. It has a 246 ppi density) ppi pixel density. The screen covers about 56.0% of the device is body. The result is quite good.',_binary ''),(12,'Samsung Galaxy S22 Ultra 5G 128GB',1,1,739,120,'Đỏ','phone12.jpg','Samsung Galaxy S22 Ultra 5G 128GB supports frequency bands GSM , HSPA , LTE. Official announcement date is July 2022. The device is working on an Android 6.0 (Marshmallow) with a Quad-core 1.4 GHz Cortex-A53 processor and 2 GB RAM memory. Samsung Galaxy Folder2 has 16 GB of internal memory. This device has a Qualcomm MSM8917 Snapdragon 425 chipset. The main screen size is displaysize3.8 inches, 41.1 cm2 with 480 x 800 pixels, 5:3 ratio resolution. It has a 246 ppi density) ppi pixel density. The screen covers about 56.0% of the device is body. The result is quite good.',_binary ''),(13,'Realme C53',3,1,208,70,'Xanh lá','phone14.jpg','Realme C53 supports frequency bands GSM , HSPA , LTE. Official announcement date is August 2023. The device is working on an Android 8.1 (Oreo) with a Octa-core 1.8 GHz Cortex-A53 processor. Oppo Realme 2 has 64 GB, 4 GB RAM or 32 GB, 3 GB RAM of built-in memory. This device has a Qualcomm SDM450 Snapdragon 450 chipset. The main screen size is displaysize6.2 inches, 95.9 cm2 with 720 x 1520 pixels, 19:9 ratio resolution. It has a 271 ppi density) ppi pixel density. The screen covers about 81.2% of the device is body. This screen to body ratio is a very impressive For India',_binary ''),(14,'Nokia 215 4G',4,1,208,70,'Xanh lá','phone15.jpg','Nokia 215 4G supports frequency bands GSM , HSPA , LTE. Official announcement date is August 2023. The device is working on an Android 8.1 (Oreo) with a Octa-core 1.8 GHz Cortex-A53 processor. Nokia 215 4G has 64 GB, 4 GB RAM or 32 GB, 3 GB RAM of built-in memory. This device has a Qualcomm SDM450 Snapdragon 450 chipset. The main screen size is displaysize6.2 inches, 95.9 cm2 with 720 x 1520 pixels, 19:9 ratio resolution. It has a 271 ppi density) ppi pixel density. The screen covers about 81.2% of the device is body. This screen to body ratio is a very impressive For India',_binary ''),(15,'OPPO A57 128GB',5,1,208,70,'Vàng','phone16.jpg','OPPO A57 128GB supports frequency bands GSM , HSPA , LTE. Official announcement date is August 2023. The device is working on an Android 8.1 (Oreo) with a Octa-core 1.8 GHz Cortex-A53 processor. OPPO A57 128GB has 64 GB, 4 GB RAM or 32 GB, 3 GB RAM of built-in memory. This device has a Qualcomm SDM450 Snapdragon 450 chipset. The main screen size is displaysize6.2 inches, 95.9 cm2 with 720 x 1520 pixels, 19:9 ratio resolution. It has a 271 ppi density) ppi pixel density. The screen covers about 81.2% of the device is body. This screen to body ratio is a very impressive For India',_binary ''),(16,'OPPO Reno10 Pro 5G',6,1,208,70,'Vàng','phone17.jpg','OPPO Reno10 Pro 5G supports frequency bands GSM , HSPA , LTE. Official announcement date is August 2023. The device is working on an Android 8.1 (Oreo) with a Octa-core 1.8 GHz Cortex-A53 processor. OPPO Reno10 Pro 5G has 64 GB, 4 GB RAM or 32 GB, 3 GB RAM of built-in memory. This device has a Qualcomm SDM450 Snapdragon 450 chipset. The main screen size is displaysize6.2 inches, 95.9 cm2 with 720 x 1520 pixels, 19:9 ratio resolution. It has a 271 ppi density) ppi pixel density. The screen covers about 81.2% of the device is body. This screen to body ratio is a very impressive For India',_binary ''),(17,'OPPO Find X5 Pro 5G',7,1,782,100,'Trắng','phone18.jpg','OPPO Find X5 Pro 5G supports frequency bands GSM , HSPA , LTE. Official announcement date is August 2023. The device is working on an Android 8.1 (Oreo) with a Octa-core 1.8 GHz Cortex-A53 processor. OPPO Find X5 Pro 5G has 64 GB, 4 GB RAM or 32 GB, 3 GB RAM of built-in memory. This device has a Qualcomm SDM450 Snapdragon 450 chipset. The main screen size is displaysize6.2 inches, 95.9 cm2 with 720 x 1520 pixels, 19:9 ratio resolution. It has a 271 ppi density) ppi pixel density. The screen covers about 81.2% of the device is body. This screen to body ratio is a very impressive For India',_binary ''),(18,'Dell Inspiron 16 5620 i5 1235U (P1WKN)\r\n',1,2,739,120,'Trắng','laptop1.jpg','Dell is a well-known American multinational technology company that manufactures a wide range of computer hardware and electronics, including laptops. Dell laptops are highly regarded for their performance, reliability, and innovative features. Here is a general description of a typical Dell laptop, The specific features and design of a Dell laptop can vary significantly depending on the series and model, so it is essential to research and select the one that best suits your requirements.',_binary ''),(19,'Dell Inspiron 15 3520 i5 1235U (70296960)',3,2,822,100,'Đen','laptop2.jpg','Dell is a well-known American multinational technology company that manufactures a wide range of computer hardware and electronics, including laptops. Dell laptops are highly regarded for their performance, reliability, and innovative features. Here is a general description of a typical Dell laptop, The specific features and design of a Dell laptop can vary significantly depending on the series and model, so it is essential to research and select the one that best suits your requirements.',_binary ''),(20,'Acer Aspire 3 i5 (NX.AM0SV.008)',3,2,521,40,'Vàng','laptop3.jpg','Acer is a well-known global computer hardware and electronics company that produces a wide range of laptops. Here is a general description of a typical Acer laptop, It is important to note that Acer is laptop lineup encompasses various series, such as Aspire, Predator (for gaming), Swift (for ultraportables), and Chromebook (for Chrome OS-based laptops). Each series may have a distinct design, set of features, and target audience. Therefore, it is crucial to research and choose an Acer laptop model that aligns with your specific needs and budget.',_binary ''),(21,'Acer Aspire 3 i3 1215U (NX.K6TSV.002)',4,2,391,50,'Trắng','laptop4.jpg','Acer is a well-known global computer hardware and electronics company that produces a wide range of laptops. Here is a general description of a typical Acer laptop, It is important to note that Acer is laptop lineup encompasses various series, such as Aspire, Predator (for gaming), Swift (for ultraportables), and Chromebook (for Chrome OS-based laptops). Each series may have a distinct design, set of features, and target audience. Therefore, it is crucial to research and choose an Acer laptop model that aligns with your specific needs and budget.',_binary ''),(22,'Acer Aspire 7 i5 12450H (NH.QMESV.002)',5,2,695,60,'Đen','laptop5.jpg','Acer is a well-known global computer hardware and electronics company that produces a wide range of laptops. Here is a general description of a typical Acer laptop, It is important to note that Acer is laptop lineup encompasses various series, such as Aspire, Predator (for gaming), Swift (for ultraportables), and Chromebook (for Chrome OS-based laptops). Each series may have a distinct design, set of features, and target audience. Therefore, it is crucial to research and choose an Acer laptop model that aligns with your specific needs and budget.',_binary ''),(23,'Acer Aspire 7 i5 12450H (NH.QMESV.002)',6,2,695,60,'Đen','laptop6.jpg','Acer is a well-known global computer hardware and electronics company that produces a wide range of laptops. Here is a general description of a typical Acer laptop, It is important to note that Acer is laptop lineup encompasses various series, such as Aspire, Predator (for gaming), Swift (for ultraportables), and Chromebook (for Chrome OS-based laptops). Each series may have a distinct design, set of features, and target audience. Therefore, it is crucial to research and choose an Acer laptop model that aligns with your specific needs and budget.',_binary ''),(24,'Acer Aspire 5 i5 1135G7 (NX.A28SV.007)',7,2,608,30,'Trắng','laptop7.jpg','Acer is a well-known global computer hardware and electronics company that produces a wide range of laptops. Here is a general description of a typical Acer laptop, It is important to note that Acer is laptop lineup encompasses various series, such as Aspire, Predator (for gaming), Swift (for ultraportables), and Chromebook (for Chrome OS-based laptops). Each series may have a distinct design, set of features, and target audience. Therefore, it is crucial to research and choose an Acer laptop model that aligns with your specific needs and budget.',_binary ''),(25,'Acer Aspire 3 (NX.A7SSV.007)',8,2,304,30,'Trắng','laptop8.jpg','Acer is a well-known global computer hardware and electronics company that produces a wide range of laptops. Here is a general description of a typical Acer laptop, It is important to note that Acer is laptop lineup encompasses various series, such as Aspire, Predator (for gaming), Swift (for ultraportables), and Chromebook (for Chrome OS-based laptops). Each series may have a distinct design, set of features, and target audience. Therefore, it is crucial to research and choose an Acer laptop model that aligns with your specific needs and budget.',_binary ''),(26,'Lenovo Ideapad Slim 3 i5 12450H (83ER000EVN)',9,2,652,80,'Trắng','laptop9.jpg','Lenovo is a well-known global computer hardware and electronics company that produces a wide range of laptops. Here is a general description of a typical Acer laptop, It is important to note that Acer is laptop lineup encompasses various series, such as Aspire, Predator (for gaming), Swift (for ultraportables), and Chromebook (for Chrome OS-based laptops). Each series may have a distinct design, set of features, and target audience. Therefore, it is crucial to research and choose an Lenovo laptop model that aligns with your specific needs and budget.',_binary ''),(27,'Lenovo IdeaPad Slim 5 Light (82XS002KVN)',10,2,760,100,'Trắng','laptop10.jpg','Lenovo is a well-known global computer hardware and electronics company that produces a wide range of laptops. Here is a general description of a typical Acer laptop, It is important to note that Acer is laptop lineup encompasses various series, such as Aspire, Predator (for gaming), Swift (for ultraportables), and Chromebook (for Chrome OS-based laptops). Each series may have a distinct design, set of features, and target audience. Therefore, it is crucial to research and choose an Lenovo laptop model that aligns with your specific needs and budget.',_binary ''),(28,'Lenovo Yoga 7 14IRL8 i7 (82YL006BVN)',1,2,1217,100,'Trắng','laptop11.jpg','Lenovo is a well-known global computer hardware and electronics company that produces a wide range of laptops. Here is a general description of a typical Acer laptop, It is important to note that Acer is laptop lineup encompasses various series, such as Aspire, Predator (for gaming), Swift (for ultraportables), and Chromebook (for Chrome OS-based laptops). Each series may have a distinct design, set of features, and target audience. Therefore, it is crucial to research and choose an Lenovo laptop model that aligns with your specific needs and budget.',_binary ''),(29,'HP Pavilion 14 i5 1235U (7C0P3PA)',2,2,717,100,'Vàng','laptop12.jpg','HP is a well-known global computer hardware and electronics company that produces a wide range of laptops. Here is a general description of a typical Acer laptop, It is important to note that Acer is laptop lineup encompasses various series, such as Aspire, Predator (for gaming), Swift (for ultraportables), and Chromebook (for Chrome OS-based laptops). Each series may have a distinct design, set of features, and target audience. Therefore, it is crucial to research and choose an HP laptop model that aligns with your specific needs and budget.',_binary ''),(30,'MacBook Pro 13 inch M2',3,2,1326,90,'Trắng','laptop13.jpg','MacBook is a well-known global computer hardware and electronics company that produces a wide range of laptops. Here is a general description of a typical Acer laptop, It is important to note that Acer is laptop lineup encompasses various series, such as Aspire, Predator (for gaming), Swift (for ultraportables), and Chromebook (for Chrome OS-based laptops). Each series may have a distinct design, set of features, and target audience. Therefore, it is crucial to research and choose an HP laptop model that aligns with your specific needs and budget.',_binary ''),(31,'MacBook Pro 16 inch M2 Pro',4,2,1326,90,'Trắng','laptop14.jpg','MacBook is a well-known global computer hardware and electronics company that produces a wide range of laptops. Here is a general description of a typical Acer laptop, It is important to note that Acer is laptop lineup encompasses various series, such as Aspire, Predator (for gaming), Swift (for ultraportables), and Chromebook (for Chrome OS-based laptops). Each series may have a distinct design, set of features, and target audience. Therefore, it is crucial to research and choose an HP laptop model that aligns with your specific needs and budget.',_binary ''),(32,'Tai nghe Bluetooth AirPods Pro',1,4,270,40,'Trắng','headphone1.jpg','Tai nghe Bluetooth AirPods Pro are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(33,'Tai nghe Bluetooth True Wireless AVA+ BLR GT07',2,4,19,60,'Đen','headphone2.jpg','Tai nghe Bluetooth True Wireless AVA+ BLR GT07 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(34,'Tai nghe Bluetooth True Wireless AVA+ FreeGo Plus PT19',3,4,11,100,'Trắng','headphone4.jpg','Tai nghe Bluetooth True Wireless AVA+ FreeGo Plus PT19 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(35,'Tai nghe Bluetooth True Wireless Samsung Galaxy Buds 2 Pro',4,4,152,120,'Trắng','headphone4.jpg','Tai nghe Bluetooth True Wireless Samsung Galaxy Buds 2 Pro are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(36,'Tai nghe Bluetooth True Wireless Mozard TS13',5,4,5,100,'Xanh dương','headphone5.jpeg','Tai nghe Bluetooth True Wireless Mozard TS13 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(37,'Tai nghe Bluetooth True Wireless Baseus AirNora 2',6,4,33,60,'Vàng','headphone5.jpg','Tai nghe Bluetooth True Wireless Baseus AirNora 2 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(38,'Tai nghe Bluetooth Chụp Tai Kanen K6',7,4,16,80,'Xanh dương','headphone7.jpg','Tai nghe Bluetooth Chụp Tai Kanen K6 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(39,'Tai nghe Bluetooth Chụp Tai JBL Tune 520BT',8,4,60,90,'Đen','headphone8.jpg','Tai nghe Bluetooth Chụp Tai JBL Tune 520BT are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(40,'Tai nghe Có dây AVA+ LiveBass Y232',9,4,8,40,'Đen','headphone9.jpg','Tai nghe Có dây AVA+ LiveBass Y232 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(41,'Tai nghe Bluetooth Soundpeats Opera 05',10,4,71,60,'Đen','headphone10.jpg','Tai nghe Bluetooth Soundpeats Opera 05 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(42,'Tai nghe Bluetooth True Wireless HAVIT TW947',1,4,17,50,'Vàng','headphone11.jpg','Tai nghe Bluetooth True Wireless HAVIT TW947 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(43,'Tai nghe Bluetooth True Wireless SOUL S-LIVE 30',2,4,17,50,'Đen','headphone12.jpg','Tai nghe Bluetooth True Wireless HAVIT TW947 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(44,'Tai nghe Bluetooth True Wireless Sony WF-C700N',3,4,100,50,'Xanh dương','headphone13.jpg','Tai nghe Bluetooth True Wireless Sony WF-C700N are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(45,'Tai nghe Bluetooth True Wireless Gaming Asus Rog Cetra',4,4,87,100,'Đen','headphone14.jpg','Tai nghe Bluetooth True Wireless Gaming Asus Rog Cetra are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(46,'Tai nghe Bluetooth Chụp Tai Mozard K8',5,4,13,100,'Vàng','headphone15.jpg','Tai nghe Bluetooth Chụp Tai Mozard K8 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(47,'CASIO 38.6 × 36.3 mm Unisex A168WER-2ADF',1,3,57,40,'Trắng','wristwatch1.jpg','CASIO 38.6 × 36.3 mm Unisex A168WER-2ADF is a portable timekeeping device worn on the wrist. It serves the primary function of displaying the current time and often includes various other features and designs. Here is a general description of wristwatches, Wristwatches are not only functional timekeeping devices but also fashion accessories and status symbols. Whether you are looking for a simple everyday watch, a sports watch for outdoor activities, or an elegant timepiece for special occasions, there is a wristwatch to suit your preferences.',_binary ''),(48,'CASIO 41.3 mm Nam MTS-100L-1AVDF',2,3,87,60,'Đen','wristwatch2.jpg','CASIO 41.3 mm Nam MTS-100L-1AVDF are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(49,'CASIO 25 mm Nữ LQ-139AMV-1LDF',3,3,12,80,'Đen','wristwatch3.jpg','CASIO 25 mm Nữ LQ-139AMV-1LDF are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(50,'CASIO 35 mm Nữ LW-204-4ADF',4,3,39,100,'Đỏ','wristwatch4.jpg','CASIO 35 mm Nữ LW-204-4ADF are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(51,'CASIO 35 mm Nữ LW-204-4ADF',5,3,39,100,'Đỏ','wristwatch5.jpg','CASIO 35 mm Nữ LW-204-4ADF are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(52,'CASIO 37.6 mm Nữ LWS-2200H-4AVDF',6,3,57,60,'Trắng','wristwatch6.jpg','CASIO 37.6 mm Nữ LWS-2200H-4AVDF are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(53,'CASIO 42.1 mm Nam WS-1600H-1AVDF',7,3,42,90,'Xanh dương','wristwatch7.jpg','CASIO 42.1 mm Nam WS-1600H-1AVDF are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(54,'G-SHOCK 43.2 mm Nam GM-5600G-9DR',9,3,243,110,'Đen','wristwatch9.jpg','G-SHOCK 43.2 mm Nam GM-5600G-9DR are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(55,'TITAN 26 mm Nữ 2628WM01',10,3,57,100,'Vàng','wristwatch10.jpg','TITAN 26 mm Nữ 2628WM01 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(56,'TITAN 40 mm Nam 1729SM06',1,3,50,80,'Trắng','wristwatch11.jpg','TITAN 40 mm Nam 1729SM06 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(57,'TITAN 40 mm Nam 1729SM06',2,3,50,80,'Trắng','wristwatch12.jpg','TITAN 40 mm Nam 1729SM06 are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(58,'CITIZEN C7 40 mm Nam NH8397-80H',3,3,319,80,'Đen','wristwatch13.jpg','CITIZEN C7 40 mm Nam NH8397-80H are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(59,'ORIENT Star 41 mm Nam RE-AV0B08L00B',4,3,917,110,'Đen','wristwatch14.jpg','CITIZEN C7 40 mm Nam NH8397-80H are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(60,'CITIZEN Tsuyosa Pantone 40 mm Nam',5,3,413,100,'Trắng','wristwatch15.jpg','CITIZEN Tsuyosa Pantone 40 mm Nam are audio devices that are designed to be worn over the ears to deliver sound directly to the listener. They come in various styles, sizes, and types, each catering to different needs and preferences. Here is a general description of headphones. Choosing the right pair of headphones depends on your specific needs, whether it is for immersive music listening, working from home, gaming, or portable use during workouts or commuting.',_binary ''),(61,'iphone 14 Pro Max',8,5,443,60,'Vàng','phone19.jpg','The iPhone 14 Pro Max comes with 6.7-inch OLED display with 120Hz refresh rate and Apple\'s improved A17 Pro processor. On the back there is a Triple camera setup with 48MP main camera and the prices start at 1199$. Technology solutions sales professionals meet with businesses to determine their needs for various electronic hardware and software products and services. They then work with their clients to develop and implement cost-effective and efficient solutions.',_binary ''),(62,'Samsung Galaxy A53 5G 128GB',2,5,287,20,'Đen','phone19.jpg','Samsung Galaxy A53 5G 128GB supports frequency bands GSM , HSPA , LTE. Official announcement date is July 2022. The device is working on an Android 6.0 (Marshmallow) with a Quad-core 1.4 GHz Cortex-A53 processor and 2 GB RAM memory. Samsung Galaxy Folder2 has 16 GB of internal memory. This device has a Qualcomm MSM8917 Snapdragon 425 chipset. The main screen size is displaysize3.8 inches, 41.1 cm2 with 480 x 800 pixels, 5:3 ratio resolution. It has a 246 ppi density) ppi pixel density. The screen covers about 56.0% of the device is body. The result is quite good.',_binary '');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `reviewid` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `productid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`reviewid`),
  KEY `FKg69bbwjotlkw04k2hqguscgbo` (`productid`),
  KEY `FKr5b7ngwds9au4py4plwik2ojf` (`userid`),
  CONSTRAINT `FKg69bbwjotlkw04k2hqguscgbo` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`),
  CONSTRAINT `FKr5b7ngwds9au4py4plwik2ojf` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'san pham ton tien vcl',1,1),(2,'san pham ton tien',1,1);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment`
--

DROP TABLE IF EXISTS `shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipment` (
  `shippingid` int NOT NULL AUTO_INCREMENT,
  `shiptel` varchar(255) DEFAULT NULL,
  `shipper_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shippingid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment`
--

LOCK TABLES `shipment` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
INSERT INTO `shipment` VALUES (1,'1-228-832-3305','FedexCompany'),(2,'1-717-664-9542','UPS'),(3,'1-288-751-7876','UPS'),(4,'1-585-683-9924','UPS'),(5,'1-650-659-5553','Fedex'),(6,'1-732-599-2845','UPS'),(7,'1-837-186-2802','UPS'),(8,'1-183-564-7100','Fedex');
/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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

-- Dump completed on 2023-11-16  5:09:30
