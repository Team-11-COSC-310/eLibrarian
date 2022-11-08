CREATE DATABASE  IF NOT EXISTS `db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `summary` varchar(255) NOT NULL,
  `availability` tinyint(1) DEFAULT '1',
  `wl` int NOT NULL DEFAULT '0',
  `namelist` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Harry Potter and the Philosopher\'s Stone','J.K. Rowling','This is the first of 7 in J.K. Rowling\'s epic wizard saga!',0,23,NULL),(2,'Harry Potter and the Chamber of Secrets','J.K. Rowling','This is the second of 7 in J.K. Rowling\'s epic wizard saga!',0,1,NULL),(3,'Harry Potter and the Prisoner of Azkaban','J.K. Rowling','This is the third of 7 in J.K. Rowling\'s epic wizard saga!',0,5,NULL),(4,'Harry Potter and the Goblet of Fire','J.K. Rowling','This is the fourth of 7 in J.K. Rowling\'s epic wizard saga!',0,2,NULL),(5,'Harry Potter and the Order of the Phoenix','J.K. Rowling','This is the fifth of 7 in J.K. Rowling\'s epic wizard saga!',0,2,NULL),(6,'Harry Potter and the Half Blood Prince','J.K. Rowling','This is the sixth of 7 in J.K. Rowling\'s epic wizard saga!',0,1,NULL),(7,'Harry Potter and the Deathly Hallows','J.K. Rowling','This is the finale of J.K. Rowling\'s epic wizard saga!',1,0,NULL),(8,'The Hobbit','J.R.R. Tolkien','This is Tolkien\'s most popular work aside from LOTR',0,10,NULL),(9,'The Lord of the Rings: The Fellowship of the Ring','J.R.R. Tolkien','This is the first of 3 in Tolkien\'s epic fanatasy trilogy!',1,0,NULL),(10,'The Lord of the Rings: The Tale of Two Towers','J.R.R. Tolkien','This is the second of 3 in Tolkien\'s epic fanatasy trilogy!',1,0,NULL),(11,'The Lord of the Rings: The Return of the King','J.R.R. Tolkien','This is the finale of Tolkien\'s epic fanatasy trilogy!',1,0,NULL),(21,'ilovecoding2','you','i actually hate coding.',0,1,NULL),(22,'ilovecoding2','you','i actually hate coding.',0,1,NULL),(23,'ilovecoding2','you','i actually hate coding.',0,1,NULL),(24,'ilovecoding50','Add','ilovecoding50',0,1,NULL),(25,'pleasework','pls','PLS',0,1,NULL),(26,'pleasework','pls','PLS',0,1,NULL),(28,'testbook1','me','test for database demo ',0,1,NULL),(29,'testbook2','me','tstbk for the database borrow and join waitlist demo.',0,1,NULL),(30,'testbook3','me','tstbk for the search borrow and join waitlist demo.',1,0,NULL),(31,'demobook1','me','aqwdwadawdd',0,1,NULL),(32,'demobook2','me','adwdawdawdawd',0,1,NULL),(33,'demobook3','me','adwdawdawdawd',1,0,NULL),(34,'demobook4','me','sefsfsefsefsfe',1,0,NULL);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librarians`
--

DROP TABLE IF EXISTS `librarians`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `librarians` (
  `email` varchar(50) NOT NULL,
  KEY `email` (`email`),
  CONSTRAINT `librarians_ibfk_1` FOREIGN KEY (`email`) REFERENCES `users` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librarians`
--

LOCK TABLES `librarians` WRITE;
/*!40000 ALTER TABLE `librarians` DISABLE KEYS */;
INSERT INTO `librarians` VALUES ('johnbooks@book.com');
/*!40000 ALTER TABLE `librarians` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `email` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `session` varchar(255) DEFAULT NULL,
  `reset_token` varchar(6) DEFAULT NULL,
  `reset_token_timestamp` datetime DEFAULT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('awdawdawd','awdawda',NULL,NULL,NULL,1),('bdevos14@outlook.com','brenner14',NULL,NULL,NULL,1),('brenner@test.com','brenner',NULL,NULL,NULL,1),('c:;','cd',NULL,NULL,NULL,1),('char@outlook.com','123',NULL,NULL,NULL,1),('hdevos14@outlook.com','brenner14',NULL,NULL,NULL,1),('iheartbooks@book.com','ilovebooks14',NULL,NULL,NULL,1),('johnbooks@book.com','imthelibrarian',NULL,NULL,NULL,1),('mdevos@hotmail.com','123',NULL,NULL,NULL,1),('Q','q',NULL,NULL,NULL,1),('t@demo.com','qdadawdwa',NULL,NULL,NULL,1),('team11','test',NULL,NULL,NULL,1),('test','123',NULL,NULL,NULL,1),('test1000','123',NULL,NULL,NULL,1),('testaddwqadawdawd@awdadw.com','awdawawd',NULL,NULL,NULL,1),('testawdawdawda','dawdawdawd',NULL,NULL,NULL,1),('tester','tester',NULL,NULL,NULL,1),('tester@demo.com','aadawdawdaw',NULL,NULL,NULL,1),('tester1@demo.com','wdawadadawdawdawda',NULL,NULL,NULL,1),('testeradadwdad@demo.com','wqdqwdawawdaw',NULL,NULL,NULL,1),('testers@book.com','C',NULL,NULL,NULL,1),('testers@test.com','test',NULL,NULL,NULL,1),('testerssda@demo.com','afefafsaf',NULL,NULL,NULL,1),('tests@book.com','test',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waitlists`
--

DROP TABLE IF EXISTS `waitlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waitlists` (
  `email` varchar(50) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`email`,`id`),
  KEY `id` (`id`),
  CONSTRAINT `waitlists_ibfk_1` FOREIGN KEY (`email`) REFERENCES `users` (`email`),
  CONSTRAINT `waitlists_ibfk_2` FOREIGN KEY (`id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waitlists`
--

LOCK TABLES `waitlists` WRITE;
/*!40000 ALTER TABLE `waitlists` DISABLE KEYS */;
INSERT INTO `waitlists` VALUES ('bdevos14@outlook.com',1,'2022-11-08 04:55:26'),('johnbooks@book.com',1,'2022-11-08 03:41:41');
/*!40000 ALTER TABLE `waitlists` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-07 21:49:38
