-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: lms
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `author` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `genre` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `publisher` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`id`, `title`, `author`, `genre`, `publisher`, `price`, `quantity`) VALUES ('B0001','Đất Rừng Phương Nam','Đoàn Giỏi','Tiểu thuyết','Nhà Xuất Bản Kim Đồng',90000,20),('B0003','Clean Code','Robert C. Martin','Lập trình','Prentice Hall',350000,49),('B0004','The Pragmatic Programmer','Andrew Hunt, David Thomas','Lập trình','Addison-Wesley',400000,80),('B0005','Introduction to Algorithms','Thomas H. Cormen','Thuật toán','MIT Press',450000,70),('B0006','Design Patterns: Elements of Reusable Object-Oriented Software','Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides','Lập trình','Addison-Wesley',420000,61),('B0007','Code Complete','Steve McConnell','Lập trình','Microsoft Press',380000,90),('B0008','Head First Java','Kathy Sierra, Bert Bates','Lập trình','O\'Reilly Media',320000,109),('B0009','JavaScript: The Good Parts','Douglas Crockford','Lập trình','O\'Reilly Media',300000,120),('B0010','You Don\'t Know JS (book series)','Kyle Simpson','Lập trình','O\'Reilly Media',450000,100),('B0011','Python Crash Course','Eric Matthes','Lập trình','No Starch Press',370000,130),('B0012','Automate the Boring Stuff with Python','Al Sweigart','Lập trình','No Starch Press',340000,150),('B0013','Eloquent JavaScript','Marijn Haverbeke','Lập trình','No Starch Press',360000,95),('B0014','Learning Python','Mark Lutz','Lập trình','O\'Reilly Media',480000,70),('B0015','The C Programming Language','Brian W. Kernighan, Dennis M. Ritchie','Lập trình','Prentice Hall',390000,60),('B0016','Effective Java','Joshua Bloch','Lập trình','Addison-Wesley',410000,85),('B0017','Programming Pearls','Jon Bentley','Lập trình','Addison-Wesley',350000,75),('B0018','Cracking the Coding Interview','Gayle Laakmann McDowell','Lập trình','CareerCup',450000,120),('B0019','Structure and Interpretation of Computer Programs','Harold Abelson, Gerald Jay Sussman, Julie Sussman','Lập trình','MIT Press',400000,50),('B0020','Deep Learning','Ian Goodfellow, Yoshua Bengio, Aaron Courville','Lập trình','MIT Press',490000,55),('B0021','Truyện Kiều','Nguyễn Du','Thơ','Nhà Xuất Bản Văn Học',100000,149),('B0022','Chí Phèo','Nam Cao','Tiểu thuyết','Nhà Xuất Bản Văn Học',80000,200),('B0023','Nỗi Buồn Chiến Tranh','Bảo Ninh','Tiểu thuyết','Nhà Xuất Bản Trẻ',110000,100),('B0024','Cánh Đồng Bất Tận','Nguyễn Ngọc Tư','Tiểu thuyết','Nhà Xuất Bản Trẻ',95000,80),('B0025','Nhật Ký Đặng Thùy Trâm','Đặng Thùy Trâm','Nhật ký','Nhà Xuất Bản Hội Nhà Văn',85000,90),('B0026','Cho Tôi Xin Một Vé Đi Tuổi Thơ','Nguyễn Nhật Ánh','Văn học thiếu nhi','Nhà Xuất Bản Trẻ',75000,250),('B0027','Tắt Đèn','Ngô Tất Tố','Tiểu thuyết','Nhà Xuất Bản Văn Học',88000,109),('B0028','Quê Nội','Võ Quảng','Văn học thiếu nhi','Nhà Xuất Bản Kim Đồng',70000,130),('B0029','Dế Mèn Phiêu Lưu Ký','Tô Hoài','Văn học thiếu nhi','Nhà Xuất Bản Kim Đồng',95000,140),('B0030','Rừng Na Uy','Haruki Murakami','Tiểu thuyết','Nhã Nam',150000,50),('B0031','Mắt Biếc','Nguyễn Nhật Ánh','Tiểu thuyết','Nhà Xuất Bản Trẻ',80000,180),('B0032','Bến Không Chồng','Dương Hướng','Tiểu thuyết','Nhà Xuất Bản Phụ Nữ',90000,75),('B0033','Biên Niên Ký Chim Vặn Dây Cót','Haruki Murakami','Tiểu thuyết','Nhã Nam',170000,45),('B0034','Những Ngày Thơ Ấu','Nguyên Hồng','Hồi ký','Nhà Xuất Bản Văn Học',85000,60),('B0035','Một Thời Để Nhớ','Trần Đăng Khoa','Thơ','Nhà Xuất Bản Hội Nhà Văn',65000,100),('B0036','Nắng Tháng Tám','Trần Việt Anh','Tiểu thuyết','Nhà Xuất Bản Trẻ',92000,80),('B0037','Con Gái Người Giữ Ký Ức','Kim Thúy','Tiểu thuyết','Nhã Nam',100000,70),('B0038','Đồi Gió Hú','Emily Brontë','Tiểu thuyết','Nhà Xuất Bản Văn Học',90000,50),('B0039','Số Đỏ','Vũ Trọng Phụng','Tiểu thuyết','Nhà Xuất Bản Văn Học',85000,90);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue`
--

DROP TABLE IF EXISTS `issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issue` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_id` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `book_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `student_id` int NOT NULL,
  `student_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `issue_date` date NOT NULL,
  `due_date` date NOT NULL,
  `status` enum('Đang mượn','Đã trả','Quá hạn','Đã mất','Mất - đã nộp phạt','Quá hạn - đã nộp phạt') COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `issue_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `issue_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue`
--

LOCK TABLES `issue` WRITE;
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` (`id`, `book_id`, `book_name`, `student_id`, `student_name`, `issue_date`, `due_date`, `status`) VALUES (2,'B0006','Design Patterns: Elements of Reusable Object-Oriented Software',21520112,'Phạm Văn Hoàng','2024-05-26','2024-08-24','Đã trả'),(3,'B0006','Design Patterns: Elements of Reusable Object-Oriented Software',21520112,'Phạm Văn Hoàng','2024-04-11','2024-05-11','Quá hạn - đã nộp phạt'),(4,'B0008','Head First Java',21520112,'Phạm Văn Hoàng','2024-05-12','2024-08-24','Đang mượn'),(5,'B0027','Tắt Đèn',21520333,'Nguyễn Thị Hằng','2024-05-26','2024-06-25','Đã mất'),(6,'B0021','Truyện Kiều',21520333,'Nguyễn Thị Hằng','2024-05-26','2024-07-25','Đã mất'),(7,'B0003','Clean Code',21520333,'Nguyễn Thị Hằng','2024-05-26','2024-06-25','Đã mất');
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penalty`
--

DROP TABLE IF EXISTS `penalty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `penalty` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `student_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `book_id` varchar(5) COLLATE utf8mb4_general_ci NOT NULL,
  `book_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `penalty_amount` int NOT NULL,
  `penalty_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `penalty_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `penalty_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penalty`
--

LOCK TABLES `penalty` WRITE;
/*!40000 ALTER TABLE `penalty` DISABLE KEYS */;
INSERT INTO `penalty` (`id`, `student_id`, `student_name`, `book_id`, `book_name`, `penalty_amount`, `penalty_date`) VALUES (1,21520112,'Phạm Văn Hoàng','B0006','Design Patterns: Elements of Reusable Object-Oriented Software',20000,'2024-05-28');
/*!40000 ALTER TABLE `penalty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `gender` varchar(4) COLLATE utf8mb4_general_ci NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `major` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `is_banned` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `name`, `gender`, `birthday`, `email`, `major`, `is_banned`) VALUES (21520023,'Nguyễn Thị Thanh Hương','Nữ','2000-01-15','21520023@gm.uit.edu.vn','KH-KTTT',1),(21520056,'Trần Văn Minh','Nam','1999-03-22','21520056@gm.uit.edu.vn','HTTT',0),(21520089,'Lê Thị Mai','Nữ','2001-05-30','21520089@gm.uit.edu.vn','CNPM',0),(21520112,'Phạm Văn Hoàng','Nam','2000-07-19','21520112@gm.uit.edu.vn','KHMT',0),(21520145,'Hoàng Thị Hạnh','Nữ','1998-11-11','21520145@gm.uit.edu.vn','KTMT',0),(21520178,'Vũ Đức Anh','Nam','2001-09-05','21520178@gm.uit.edu.vn','MMT-TT',0),(21520201,'Đỗ Thị Bích Phương','Nữ','2000-02-28','21520201@gm.uit.edu.vn','KH-KTTT',0),(21520234,'Bùi Văn Trọng','Nam','1999-12-12','21520234@gm.uit.edu.vn','HTTT',0),(21520267,'Ngô Thị Lan','Nữ','2001-08-23','21520267@gm.uit.edu.vn','CNPM',0),(21520300,'Đặng Văn Hùng','Nam','2000-04-10','21520300@gm.uit.edu.vn','KHMT',0),(21520333,'Nguyễn Thị Hằng','Nữ','2000-05-25','21520333@gm.uit.edu.vn','KTMT',1),(21520366,'Trần Văn Hải','Nam','1999-08-14','21520366@gm.uit.edu.vn','KHMT',0),(21520399,'Lê Thị Hoa','Nữ','2001-03-10','21520399@gm.uit.edu.vn','CNPM',0),(21520432,'Phạm Văn Đức','Nam','2000-07-02','21520432@gm.uit.edu.vn','KH-KTTT',0),(21520465,'Hoàng Thị Diễm','Nữ','1998-12-20','21520465@gm.uit.edu.vn','MMT-TT',0),(21520498,'Vũ Văn An','Nam','2001-09-15','21520498@gm.uit.edu.vn','HTTT',0),(21520531,'Đỗ Thị Lan','Nữ','2000-02-18','21520531@gm.uit.edu.vn','KHMT',0),(21520564,'Bùi Văn Duy','Nam','1999-11-06','21520564@gm.uit.edu.vn','KTMT',0),(21520597,'Nguyễn Thị Thu','Nữ','2001-06-30','21520597@gm.uit.edu.vn','KH-KTTT',0),(21520630,'Trần Văn Tú','Nam','2000-04-25','21520630@gm.uit.edu.vn','HTTT',0),(21520663,'Lê Thị Hồng','Nữ','1999-10-12','21520663@gm.uit.edu.vn','CNPM',0),(21520696,'Phạm Văn Hòa','Nam','2001-01-28','21520696@gm.uit.edu.vn','KHMT',0),(21520729,'Hoàng Thị Trang','Nữ','2000-08-22','21520729@gm.uit.edu.vn','HTTT',0),(21520762,'Vũ Văn Bảo','Nam','1998-04-05','21520762@gm.uit.edu.vn','KHMT',0),(21520795,'Đỗ Thị Nhung','Nữ','2001-12-10','21520795@gm.uit.edu.vn','KH-KTTT',0),(21520828,'Bùi Văn Tùng','Nam','2000-06-18','21520828@gm.uit.edu.vn','MMT-TT',0),(21520861,'Nguyễn Thị Hà','Nữ','1999-02-28','21520861@gm.uit.edu.vn','CNPM',0),(21520894,'Trần Văn Lâm','Nam','2001-07-15','21520894@gm.uit.edu.vn','KHMT',0),(21520927,'Lê Thị Mỹ','Nữ','2000-09-10','21520927@gm.uit.edu.vn','KTMT',0),(21520960,'Phạm Văn Quân','Nam','1998-03-05','21520960@gm.uit.edu.vn','KH-KTTT',0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `password`, `email`, `phone`) VALUES (17,'admin123','admin@123','admin@gmail.com','0898889998');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-28 13:08:32
