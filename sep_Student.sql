-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: studentssep
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `staff`
--

DROP SCHEMA IF EXISTS studentSep;
CREATE SCHEMA studentSep;
USE studentSep;

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) DEFAULT NULL,
                         `workBegin` datetime DEFAULT NULL,
                         `workEnd` datetime DEFAULT NULL,
                         `department` varchar(45) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'FD1','2020-10-05 08:15:00','2020-10-05 16:00:00','FoodDistribution'),(2,'FD2','2020-10-05 11:30:00','2020-10-05 16:00:00','FoodDistribution'),(3,'CO1','2020-10-05 08:15:00','2020-10-05 16:00:00','Checkout'),(4,'CO2','2020-10-05 11:30:00','2020-10-05 16:00:00','Checkout');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `studentname` varchar(45) DEFAULT NULL,
                           `arrival` datetime DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=407 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Student1','2020-10-05 09:43:21'),(2,'Student2','2020-10-05 09:43:33'),(3,'Student3','2020-10-05 09:43:46'),(4,'Student4','2020-10-05 09:44:07'),(265,'Student8','2020-10-05 16:45:43'),(266,'Student9','2020-10-05 16:45:44'),(267,'Student10','2020-10-05 16:45:45'),(268,'Student11','2020-10-05 16:45:46'),(269,'Student12','2020-10-05 16:45:47'),(270,'Student13','2020-10-05 16:45:48'),(271,'Student14','2020-10-05 16:45:49'),(272,'Student15','2020-10-05 16:45:50'),(273,'Student16','2020-10-05 16:45:51'),(274,'Student17','2020-10-05 16:45:52'),(275,'Student18','2020-10-05 16:45:53'),(276,'Student19','2020-10-05 16:45:54'),(277,'Student20','2020-10-05 16:45:55'),(278,'Student21','2020-10-05 16:45:56'),(279,'Student22','2020-10-05 16:45:57'),(280,'Student23','2020-10-05 16:45:58'),(281,'Student24','2020-10-05 16:45:59'),(282,'Student25','2020-10-05 16:46:00'),(283,'Student26','2020-10-05 16:46:01'),(284,'Student27','2020-10-05 16:46:02'),(285,'Student28','2020-10-05 16:46:03'),(286,'Student29','2020-10-05 16:46:04'),(287,'Student30','2020-10-05 16:46:05'),(288,'Student31','2020-10-05 16:46:06'),(289,'Student32','2020-10-05 16:46:07'),(290,'Student33','2020-10-05 16:46:08'),(291,'Student34','2020-10-05 16:46:09'),(292,'Student35','2020-10-05 16:46:10'),(293,'Student36','2020-10-05 16:46:11'),(294,'Student37','2020-10-05 16:46:12'),(295,'Student38','2020-10-05 16:46:13'),(296,'Student39','2020-10-05 16:46:14'),(297,'Student40','2020-10-05 16:46:15'),(298,'Student41','2020-10-05 16:46:16'),(299,'Student42','2020-10-05 16:46:17'),(300,'Student43','2020-10-05 16:46:18'),(301,'Student44','2020-10-05 16:46:19'),(302,'Student45','2020-10-05 16:46:20'),(303,'Student46','2020-10-05 16:46:21'),(304,'Student47','2020-10-05 16:46:22'),(305,'Student48','2020-10-05 16:46:23'),(306,'Student49','2020-10-05 16:46:24'),(307,'Student50','2020-10-05 16:46:25'),(308,'Student51','2020-10-05 16:46:26'),(309,'Student52','2020-10-05 16:46:27'),(310,'Student53','2020-10-05 16:46:28'),(311,'Student54','2020-10-05 16:46:29'),(312,'Student55','2020-10-05 16:46:30'),(313,'Student56','2020-10-05 16:46:31'),(314,'Student57','2020-10-05 16:46:32'),(315,'Student58','2020-10-05 16:46:33'),(316,'Student59','2020-10-05 16:46:34'),(317,'Student60','2020-10-05 16:46:35'),(318,'Student61','2020-10-05 16:46:36'),(319,'Student62','2020-10-05 16:46:37'),(320,'Student63','2020-10-05 16:46:38'),(321,'Student64','2020-10-05 16:46:39'),(322,'Student65','2020-10-05 16:46:40'),(323,'Student66','2020-10-05 16:46:41'),(324,'Student67','2020-10-05 16:46:42'),(325,'Student68','2020-10-05 16:46:43'),(326,'Student69','2020-10-05 16:46:44'),(327,'Student70','2020-10-05 16:46:45'),(328,'Student71','2020-10-05 16:46:46'),(329,'Student72','2020-10-05 16:46:47'),(330,'Student73','2020-10-05 16:46:48'),(331,'Student74','2020-10-05 16:46:49'),(332,'Student75','2020-10-05 16:46:50'),(333,'Student76','2020-10-05 16:46:51'),(334,'Student77','2020-10-05 16:46:52'),(335,'Student78','2020-10-05 16:46:53'),(336,'Student79','2020-10-05 16:46:54'),(337,'Student80','2020-10-05 16:46:55'),(338,'Student81','2020-10-05 16:46:56'),(339,'Student82','2020-10-05 16:46:57'),(340,'Student83','2020-10-05 16:46:58'),(341,'Student84','2020-10-05 16:46:59'),(342,'Student85','2020-10-05 16:47:00'),(343,'Student86','2020-10-05 16:47:01'),(344,'Student87','2020-10-05 16:47:02'),(345,'Student88','2020-10-05 16:47:03'),(346,'Student89','2020-10-05 16:47:04'),(347,'Student90','2020-10-05 16:47:05'),(348,'Student91','2020-10-05 16:47:06'),(349,'Student92','2020-10-05 16:47:07'),(350,'Student93','2020-10-05 16:47:08'),(351,'Student94','2020-10-05 16:47:09'),(352,'Student95','2020-10-05 16:47:10'),(353,'Student96','2020-10-05 16:47:11'),(354,'Student97','2020-10-05 16:47:12'),(355,'Student98','2020-10-05 16:47:13'),(356,'Student99','2020-10-05 16:47:14'),(357,'Student100','2020-10-05 16:47:15'),(358,'Student101','2020-10-05 16:47:16'),(359,'Student102','2020-10-05 16:47:17'),(360,'Student103','2020-10-05 16:47:18'),(361,'Student104','2020-10-05 16:47:19'),(362,'Student105','2020-10-05 16:47:20'),(363,'Student106','2020-10-05 16:47:21'),(364,'Student107','2020-10-05 16:47:22'),(365,'Student108','2020-10-05 16:47:23'),(366,'Student109','2020-10-05 16:47:24'),(367,'Student110','2020-10-05 16:47:25'),(368,'Student111','2020-10-05 16:47:26'),(369,'Student112','2020-10-05 16:47:27'),(370,'Student113','2020-10-05 16:47:28'),(371,'Student114','2020-10-05 16:47:29'),(372,'Student115','2020-10-05 16:47:30'),(373,'Student116','2020-10-05 16:47:31'),(374,'Student117','2020-10-05 16:47:32'),(375,'Student118','2020-10-05 16:47:33'),(376,'Student119','2020-10-05 16:47:34'),(377,'Student120','2020-10-05 16:47:35'),(378,'Student121','2020-10-05 16:47:36'),(379,'Student122','2020-10-05 16:47:37'),(380,'Student123','2020-10-05 16:47:38'),(381,'Student124','2020-10-05 16:47:39'),(382,'Student125','2020-10-05 16:47:40'),(383,'Student126','2020-10-05 16:47:41'),(384,'Student127','2020-10-05 16:47:42'),(385,'Student128','2020-10-05 16:47:43'),(386,'Student129','2020-10-05 16:47:44'),(387,'Student130','2020-10-05 16:47:45'),(388,'Student131','2020-10-05 16:47:46'),(389,'Student132','2020-10-05 16:47:47'),(390,'Student133','2020-10-05 16:47:48'),(391,'Student134','2020-10-05 16:47:49'),(392,'Student135','2020-10-05 16:47:50'),(393,'Student136','2020-10-05 16:47:51'),(394,'Student137','2020-10-05 16:47:52'),(395,'Student138','2020-10-05 16:47:53'),(396,'Student139','2020-10-05 16:47:54'),(397,'Student140','2020-10-05 16:47:55'),(398,'Student141','2020-10-05 16:47:56'),(399,'Student142','2020-10-05 16:47:57'),(400,'Student143','2020-10-05 16:47:58'),(401,'Student144','2020-10-05 16:47:59'),(402,'Student145','2020-10-05 16:48:00'),(403,'Student146','2020-10-05 16:48:01'),(404,'Student147','2020-10-05 16:48:02'),(405,'Student148','2020-10-05 16:48:03'),(406,'Student149','2020-10-05 16:48:04');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-05 17:33:22
