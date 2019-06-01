-- MySQL dump 10.13  Distrib 5.7.20, for macos10.12 (x86_64)
--
-- Host: localhost    Database: StoreWeb
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `List`
--

DROP TABLE IF EXISTS ShopList;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `List` (
  `user_id` varchar(45) NOT NULL COMMENT 'User表Id',
  `product_id` int(11) NOT NULL COMMENT '产品表Id',
  `num` int(11) DEFAULT NULL COMMENT '购物车内相同商品数量',
  KEY `email_idx` (`user_id`),
  KEY `product_id_idx` (`product_id`),
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `User` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `List`
--

LOCK TABLES ShopList WRITE;
/*!40000 ALTER TABLE ShopList DISABLE KEYS */;
INSERT INTO ShopList VALUES ('abc@qq.com',1,3),('ciperchou@qq.com',3,1);
/*!40000 ALTER TABLE ShopList ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Place`
--

DROP TABLE IF EXISTS `Place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Place` (
  `email` varchar(45) NOT NULL COMMENT 'User表Id',
  `place` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '收货地址',
  KEY `email_idx` (`email`),
  CONSTRAINT `email` FOREIGN KEY (`email`) REFERENCES `User` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Place`
--

LOCK TABLES `Place` WRITE;
/*!40000 ALTER TABLE `Place` DISABLE KEYS */;
INSERT INTO `Place` VALUES ('ciperchou@qq.com','湖南省沅江市嘉禾社区105栋'),('ciperchou@qq.com','湖南省长沙学院汇泽2栋'),('ciperchou@qq.com','湖南省沅江市第一中学');
/*!40000 ALTER TABLE `Place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product` (
  `id` int(11) NOT NULL COMMENT '产品表id',
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品名称',
  `type_rela_id` int(11) NOT NULL COMMENT '类型号',
  `price` varchar(45) DEFAULT NULL COMMENT '价格',
  `size` varchar(45) DEFAULT NULL COMMENT '大小(S/M/L/XL/XXL/XXXL)',
  `color` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '配色',
  `photo` varchar(45) NOT NULL COMMENT '商品图片地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (1,'休闲精品T恤',1,'120','XL','灰色','a.png'),(2,'休闲精品外套',2,'200','XL','黑色','b.png'),(3,'篮球精品T恤',9,'160','XXL','白色','c.png');
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TypeOne`
--

DROP TABLE IF EXISTS `TypeOne`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TypeOne` (
  `idTypeOne` int(11) NOT NULL COMMENT '一级分类表主键',
  `TypeName` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '类型名',
  PRIMARY KEY (`idTypeOne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TypeOne`
--

LOCK TABLES `TypeOne` WRITE;
/*!40000 ALTER TABLE `TypeOne` DISABLE KEYS */;
INSERT INTO `TypeOne` VALUES (1,'休闲'),(2,'跑步'),(3,'篮球');
/*!40000 ALTER TABLE `TypeOne` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TypeRelation`
--

DROP TABLE IF EXISTS `TypeRelation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TypeRelation` (
  `idTypeRelation` int(11) NOT NULL COMMENT '类别关系表主键',
  `typeOne` int(11) DEFAULT NULL COMMENT '一级类别id',
  `typeTwo` int(11) DEFAULT NULL COMMENT '二级类别id',
  PRIMARY KEY (`idTypeRelation`),
  KEY `TypeOne_idx` (`typeOne`),
  KEY `TypeTwo_idx` (`typeTwo`),
  CONSTRAINT `TypeOne` FOREIGN KEY (`typeOne`) REFERENCES `TypeOne` (`idTypeOne`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TypeTwo` FOREIGN KEY (`typeTwo`) REFERENCES `TypeTwo` (`idTypeTwo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TypeRelation`
--

LOCK TABLES `TypeRelation` WRITE;
/*!40000 ALTER TABLE `TypeRelation` DISABLE KEYS */;
INSERT INTO `TypeRelation` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,2,1),(6,2,2),(7,2,3),(8,2,4),(9,3,1),(10,3,2),(11,3,3),(12,3,4);
/*!40000 ALTER TABLE `TypeRelation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TypeTwo`
--

DROP TABLE IF EXISTS `TypeTwo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TypeTwo` (
  `idTypeTwo` int(11) NOT NULL COMMENT '二级分类表主键',
  `TypeName` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '类型名',
  PRIMARY KEY (`idTypeTwo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TypeTwo`
--

LOCK TABLES `TypeTwo` WRITE;
/*!40000 ALTER TABLE `TypeTwo` DISABLE KEYS */;
INSERT INTO `TypeTwo` VALUES (1,'T恤'),(2,'外套'),(3,'短裤'),(4,'长裤');
/*!40000 ALTER TABLE `TypeTwo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `email` varchar(45) NOT NULL COMMENT '主键(电子邮箱)',
  `password` varchar(45) NOT NULL COMMENT '密码',
  `tel` varchar(45) NOT NULL COMMENT '电话号码',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES ('1634076598@qq.com','123456','17665678888'),('abc@qq.com','123','17659008888'),('choucipeng@outlook.com','123456','13876598888'),('ciper@qq.com','root','16789006588'),('ciperchou@qq.com','root','15173703328'),('zzp@qq.com','root','13876586730');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-30 17:14:21
