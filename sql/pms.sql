/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 8.0.34 : Database - pms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pms` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `pms`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `username` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

/*Data for the table `admin` */

insert  into `admin`(`aid`,`username`,`password`) values (1,'admin','123');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `did` int NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `departmentName` char(20) DEFAULT NULL COMMENT '部门名',
  `parentdepart` int NOT NULL DEFAULT '10' COMMENT '所属上级部门',
  `departinfo` char(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '部门介绍',
  `departSalaryCoe` float NOT NULL DEFAULT '0.01' COMMENT '部门薪资系数',
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8mb3;

/*Data for the table `department` */

insert  into `department`(`did`,`departmentName`,`parentdepart`,`departinfo`,`departSalaryCoe`) values (100,'暂无部门',10,'暂无',0.01),(101,'电子部',11,'研发电子软件',0.02),(102,'软件部',11,'应用软件开发部门',0.04),(103,'销售部',12,'市场销售部门',0.02),(104,'发行部',12,'产品发行部门',0.01),(105,'人事部',10,'人事管理相关部门',0.08);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `lastName` char(20) DEFAULT NULL,
  `email` char(20) DEFAULT NULL,
  `gender` int NOT NULL DEFAULT '1' COMMENT '0女1男',
  `department` int NOT NULL DEFAULT '100' COMMENT '员工所属部门',
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=1033 DEFAULT CHARSET=utf8mb3;

/*Data for the table `employee` */

insert  into `employee`(`eid`,`lastName`,`email`,`gender`,`department`) values (1001,'朱天水','123@qq.com',0,101),(1002,'曹宏','456@qq.com',1,101),(1003,'陈奕楠','789@qq.com',0,100),(1004,'鲍小宇','111@qq.com',1,101),(1005,'杨蔡杰','222@qq.com',0,102),(1006,'周忠琪','68234114@qq.com',1,102),(1009,'临时工C','21555778@qq.com',1,103),(1010,'临时工D','24156577@qq.com',0,100),(1011,'临时工E','112345@gmail.com',0,103),(1012,'临时工F','1678@163.com',1,102),(1013,'临时工G','567858@gmail.com',1,100),(1032,'实习生5','123@11',1,103);

/*Table structure for table `exercitation` */

DROP TABLE IF EXISTS `exercitation`;

CREATE TABLE `exercitation` (
  `exid` int NOT NULL AUTO_INCREMENT,
  `exname` char(20) DEFAULT NULL,
  `exemail` char(20) DEFAULT NULL,
  `exgender` int NOT NULL DEFAULT '1',
  `exdepartment` int NOT NULL DEFAULT '100',
  `foreignskill` int NOT NULL DEFAULT '1',
  `exdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `salary` int NOT NULL DEFAULT '150',
  PRIMARY KEY (`exid`)
) ENGINE=InnoDB AUTO_INCREMENT=10018 DEFAULT CHARSET=utf8mb3;

/*Data for the table `exercitation` */

insert  into `exercitation`(`exid`,`exname`,`exemail`,`exgender`,`exdepartment`,`foreignskill`,`exdate`,`salary`) values (10001,'实习生1','181@gmail.com',0,101,1,'2023-12-29 00:00:00',200),(10002,'实习生2','qwe@da.com',1,100,1,'2023-12-29 00:00:00',100),(10003,'实习生3','546@qq.com',1,100,1,'2023-12-29 14:41:08',120),(10004,'实习生4','56@qq.com',1,100,1,'2024-01-03 20:14:28',150),(10017,'实习生5','123456@123414',1,103,1,'2024-01-10 20:59:55',145);

/*Table structure for table `older` */

DROP TABLE IF EXISTS `older`;

CREATE TABLE `older` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `name` char(20) DEFAULT NULL,
  `address` char(99) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `service_year` int DEFAULT NULL,
  `teleph` char(20) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `older` */

insert  into `older`(`eid`,`name`,`address`,`age`,`service_year`,`teleph`) values (1,'孙杰克','大都城',18,12,'198623432342'),(5,'asdsad','2342',123,345,'53452523');

/*Table structure for table `parentdepartment` */

DROP TABLE IF EXISTS `parentdepartment`;

CREATE TABLE `parentdepartment` (
  `pdid` int NOT NULL AUTO_INCREMENT,
  `pdname` char(10) NOT NULL,
  `pdinfo` char(10) DEFAULT NULL,
  PRIMARY KEY (`pdid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

/*Data for the table `parentdepartment` */

insert  into `parentdepartment`(`pdid`,`pdname`,`pdinfo`) values (10,'总经理室','总经理办事处'),(11,'研发室','研发产品的总部门'),(12,'市场室','市场销售相关部门');

/*Table structure for table `weekperformance` */

DROP TABLE IF EXISTS `weekperformance`;

CREATE TABLE `weekperformance` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `sun` int DEFAULT '0',
  `mon` int DEFAULT '0',
  `tue` int DEFAULT '0',
  `wed` int DEFAULT '0',
  `thu` int DEFAULT '0',
  `fri` int DEFAULT '0',
  `sat` int DEFAULT '0',
  `eid` int DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

/*Data for the table `weekperformance` */

insert  into `weekperformance`(`pid`,`sun`,`mon`,`tue`,`wed`,`thu`,`fri`,`sat`,`eid`) values (1,12446,20122,15678,12456,12556,25657,20134,1001),(2,23525,24245,23424,25466,23566,24545,21545,1002),(3,25587,24668,21767,24545,12456,13435,5002,1003),(4,5000,10000,15000,20000,15000,10000,5000,1004),(5,4355,4534,4345,5567,7886,25676,15455,1005),(6,25464,24565,14556,34657,24325,15767,45445,1006);

/*Table structure for table `work` */

DROP TABLE IF EXISTS `work`;

CREATE TABLE `work` (
  `wid` int NOT NULL AUTO_INCREMENT,
  `workday` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

/*Data for the table `work` */

insert  into `work`(`wid`,`workday`) values (1,21);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
