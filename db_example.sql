/*
SQLyog Ultimate v8.32 
MySQL - 5.7.29-log : Database - db_example
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_example` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_example`;

/*Table structure for table `tbl1` */
DROP TABLE IF EXISTS `tbl1`;

CREATE TABLE `tbl1` (
  `userId` int(50) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `age` varchar(5) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `tbl1` */

insert  into `tbl1`(`userId`,`userName`,`age`,`birthday`) values (1,'1','1','0000-00-00'),(2,'1','1','0000-00-00'),(3,'1','1','0000-00-00'),(4,'1','1','0000-00-00'),(5,'1','1','0000-00-00'),(6,'1','1','0000-00-00'),(7,'1','1','0000-00-00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
