-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2024 at 10:43 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lms`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` varchar(5) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `genre` varchar(100) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `title`, `author`, `genre`, `publisher`, `price`, `quantity`) VALUES
('B0001', 'Đất Rừng Phương Nam', 'Đoàn Giỏi', 'Tiểu thuyết', 'Nhà Xuất Bản Kim Đồng', 90000, 20),
('B0002', 'Tôi Thấy Hoa Vàng Trên Cỏ Xanh', 'Nguyễn Nhật Ánh', 'Tiểu thuyết', 'Nhà Xuất Bản Trẻ', 78000, 16),
('B0003', 'Clean Code', 'Robert C. Martin', 'Lập trình', 'Prentice Hall', 350000, 50),
('B0004', 'The Pragmatic Programmer', 'Andrew Hunt, David Thomas', 'Lập trình', 'Addison-Wesley', 400000, 80),
('B0005', 'Introduction to Algorithms', 'Thomas H. Cormen', 'Thuật toán', 'MIT Press', 450000, 70),
('B0006', 'Design Patterns: Elements of Reusable Object-Oriented Software', 'Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides', 'Lập trình', 'Addison-Wesley', 420000, 60),
('B0007', 'Code Complete', 'Steve McConnell', 'Lập trình', 'Microsoft Press', 380000, 90),
('B0008', 'Head First Java', 'Kathy Sierra, Bert Bates', 'Lập trình', 'O\'Reilly Media', 320000, 110),
('B0009', 'JavaScript: The Good Parts', 'Douglas Crockford', 'Lập trình', 'O\'Reilly Media', 300000, 120),
('B0010', 'You Don\'t Know JS (book series)', 'Kyle Simpson', 'Lập trình', 'O\'Reilly Media', 450000, 100),
('B0011', 'Python Crash Course', 'Eric Matthes', 'Lập trình', 'No Starch Press', 370000, 130),
('B0012', 'Automate the Boring Stuff with Python', 'Al Sweigart', 'Lập trình', 'No Starch Press', 340000, 150),
('B0013', 'Eloquent JavaScript', 'Marijn Haverbeke', 'Lập trình', 'No Starch Press', 360000, 95),
('B0014', 'Learning Python', 'Mark Lutz', 'Lập trình', 'O\'Reilly Media', 480000, 70),
('B0015', 'The C Programming Language', 'Brian W. Kernighan, Dennis M. Ritchie', 'Lập trình', 'Prentice Hall', 390000, 60),
('B0016', 'Effective Java', 'Joshua Bloch', 'Lập trình', 'Addison-Wesley', 410000, 85),
('B0017', 'Programming Pearls', 'Jon Bentley', 'Lập trình', 'Addison-Wesley', 350000, 75),
('B0018', 'Cracking the Coding Interview', 'Gayle Laakmann McDowell', 'Lập trình', 'CareerCup', 450000, 120),
('B0019', 'Structure and Interpretation of Computer Programs', 'Harold Abelson, Gerald Jay Sussman, Julie Sussman', 'Lập trình', 'MIT Press', 400000, 50),
('B0020', 'Deep Learning', 'Ian Goodfellow, Yoshua Bengio, Aaron Courville', 'Lập trình', 'MIT Press', 490000, 55),
('B0021', 'Truyện Kiều', 'Nguyễn Du', 'Thơ', 'Nhà Xuất Bản Văn Học', 100000, 150),
('B0022', 'Chí Phèo', 'Nam Cao', 'Tiểu thuyết', 'Nhà Xuất Bản Văn Học', 80000, 200),
('B0023', 'Nỗi Buồn Chiến Tranh', 'Bảo Ninh', 'Tiểu thuyết', 'Nhà Xuất Bản Trẻ', 110000, 100),
('B0024', 'Cánh Đồng Bất Tận', 'Nguyễn Ngọc Tư', 'Tiểu thuyết', 'Nhà Xuất Bản Trẻ', 95000, 80),
('B0025', 'Nhật Ký Đặng Thùy Trâm', 'Đặng Thùy Trâm', 'Nhật ký', 'Nhà Xuất Bản Hội Nhà Văn', 85000, 90),
('B0026', 'Cho Tôi Xin Một Vé Đi Tuổi Thơ', 'Nguyễn Nhật Ánh', 'Văn học thiếu nhi', 'Nhà Xuất Bản Trẻ', 75000, 250),
('B0027', 'Tắt Đèn', 'Ngô Tất Tố', 'Tiểu thuyết', 'Nhà Xuất Bản Văn Học', 88000, 110),
('B0028', 'Quê Nội', 'Võ Quảng', 'Văn học thiếu nhi', 'Nhà Xuất Bản Kim Đồng', 70000, 130),
('B0029', 'Dế Mèn Phiêu Lưu Ký', 'Tô Hoài', 'Văn học thiếu nhi', 'Nhà Xuất Bản Kim Đồng', 95000, 140),
('B0030', 'Rừng Na Uy', 'Haruki Murakami', 'Tiểu thuyết', 'Nhã Nam', 150000, 50),
('B0031', 'Mắt Biếc', 'Nguyễn Nhật Ánh', 'Tiểu thuyết', 'Nhà Xuất Bản Trẻ', 80000, 180),
('B0032', 'Bến Không Chồng', 'Dương Hướng', 'Tiểu thuyết', 'Nhà Xuất Bản Phụ Nữ', 90000, 75),
('B0033', 'Biên Niên Ký Chim Vặn Dây Cót', 'Haruki Murakami', 'Tiểu thuyết', 'Nhã Nam', 170000, 45),
('B0034', 'Những Ngày Thơ Ấu', 'Nguyên Hồng', 'Hồi ký', 'Nhà Xuất Bản Văn Học', 85000, 60),
('B0035', 'Một Thời Để Nhớ', 'Trần Đăng Khoa', 'Thơ', 'Nhà Xuất Bản Hội Nhà Văn', 65000, 100),
('B0036', 'Nắng Tháng Tám', 'Trần Việt Anh', 'Tiểu thuyết', 'Nhà Xuất Bản Trẻ', 92000, 80),
('B0037', 'Con Gái Người Giữ Ký Ức', 'Kim Thúy', 'Tiểu thuyết', 'Nhã Nam', 100000, 70),
('B0038', 'Đồi Gió Hú', 'Emily Brontë', 'Tiểu thuyết', 'Nhà Xuất Bản Văn Học', 90000, 50),
('B0039', 'Số Đỏ', 'Vũ Trọng Phụng', 'Tiểu thuyết', 'Nhà Xuất Bản Văn Học', 85000, 90);

-- --------------------------------------------------------

--
-- Table structure for table `issue`
--

CREATE TABLE `issue` (
  `id` int(11) NOT NULL,
  `book_id` varchar(5) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `student_id` int(8) NOT NULL,
  `student_name` varchar(100) NOT NULL,
  `issue_date` date NOT NULL,
  `due_date` date NOT NULL,
  `status` enum('Đang mượn','Đã trả','Quá hạn','Đã mất') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `issue`
--

INSERT INTO `issue` (`id`, `book_id`, `book_name`, `student_id`, `student_name`, `issue_date`, `due_date`, `status`) VALUES
(1, 'B0008', 'Head First Java', 21520023, 'Nguyễn Thị Thanh Hương', '2024-05-25', '2024-08-23', 'Đang mượn');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(8) NOT NULL,
  `name` varchar(100) NOT NULL,
  `gender` varchar(4) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(100) NOT NULL,
  `major` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `gender`, `birthday`, `email`, `major`) VALUES
(21520023, 'Nguyễn Thị Thanh Hương', 'Nữ', '2000-01-15', '21520023@gm.uit.edu.vn', 'KH-KTTT'),
(21520056, 'Trần Văn Minh', 'Nam', '1999-03-22', '21520056@gm.uit.edu.vn', 'HTTT'),
(21520089, 'Lê Thị Mai', 'Nữ', '2001-05-30', '21520089@gm.uit.edu.vn', 'CNPM'),
(21520112, 'Phạm Văn Hoàng', 'Nam', '2000-07-19', '21520112@gm.uit.edu.vn', 'KHMT'),
(21520145, 'Hoàng Thị Hạnh', 'Nữ', '1998-11-11', '21520145@gm.uit.edu.vn', 'KTMT'),
(21520178, 'Vũ Đức Anh', 'Nam', '2001-09-05', '21520178@gm.uit.edu.vn', 'MMT-TT'),
(21520201, 'Đỗ Thị Bích Phương', 'Nữ', '2000-02-28', '21520201@gm.uit.edu.vn', 'KH-KTTT'),
(21520234, 'Bùi Văn Trọng', 'Nam', '1999-12-12', '21520234@gm.uit.edu.vn', 'HTTT'),
(21520267, 'Ngô Thị Lan', 'Nữ', '2001-08-23', '21520267@gm.uit.edu.vn', 'CNPM'),
(21520300, 'Đặng Văn Hùng', 'Nam', '2000-04-10', '21520300@gm.uit.edu.vn', 'KHMT'),
(21520333, 'Nguyễn Thị Hằng', 'Nữ', '2000-05-25', '21520333@gm.uit.edu.vn', 'KTMT'),
(21520366, 'Trần Văn Hải', 'Nam', '1999-08-14', '21520366@gm.uit.edu.vn', 'KHMT'),
(21520399, 'Lê Thị Hoa', 'Nữ', '2001-03-10', '21520399@gm.uit.edu.vn', 'CNPM'),
(21520432, 'Phạm Văn Đức', 'Nam', '2000-07-02', '21520432@gm.uit.edu.vn', 'KH-KTTT'),
(21520465, 'Hoàng Thị Diễm', 'Nữ', '1998-12-20', '21520465@gm.uit.edu.vn', 'MMT-TT'),
(21520498, 'Vũ Văn An', 'Nam', '2001-09-15', '21520498@gm.uit.edu.vn', 'HTTT'),
(21520531, 'Đỗ Thị Lan', 'Nữ', '2000-02-18', '21520531@gm.uit.edu.vn', 'KHMT'),
(21520564, 'Bùi Văn Duy', 'Nam', '1999-11-06', '21520564@gm.uit.edu.vn', 'KTMT'),
(21520597, 'Nguyễn Thị Thu', 'Nữ', '2001-06-30', '21520597@gm.uit.edu.vn', 'KH-KTTT'),
(21520630, 'Trần Văn Tú', 'Nam', '2000-04-25', '21520630@gm.uit.edu.vn', 'HTTT'),
(21520663, 'Lê Thị Hồng', 'Nữ', '1999-10-12', '21520663@gm.uit.edu.vn', 'CNPM'),
(21520696, 'Phạm Văn Hòa', 'Nam', '2001-01-28', '21520696@gm.uit.edu.vn', 'KHMT'),
(21520729, 'Hoàng Thị Trang', 'Nữ', '2000-08-22', '21520729@gm.uit.edu.vn', 'HTTT'),
(21520762, 'Vũ Văn Bảo', 'Nam', '1998-04-05', '21520762@gm.uit.edu.vn', 'KHMT'),
(21520795, 'Đỗ Thị Nhung', 'Nữ', '2001-12-10', '21520795@gm.uit.edu.vn', 'KH-KTTT'),
(21520828, 'Bùi Văn Tùng', 'Nam', '2000-06-18', '21520828@gm.uit.edu.vn', 'MMT-TT'),
(21520861, 'Nguyễn Thị Hà', 'Nữ', '1999-02-28', '21520861@gm.uit.edu.vn', 'CNPM'),
(21520894, 'Trần Văn Lâm', 'Nam', '2001-07-15', '21520894@gm.uit.edu.vn', 'KHMT'),
(21520927, 'Lê Thị Mỹ', 'Nữ', '2000-09-10', '21520927@gm.uit.edu.vn', 'KTMT'),
(21520960, 'Phạm Văn Quân', 'Nam', '1998-03-05', '21520960@gm.uit.edu.vn', 'KH-KTTT');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `password`, `email`, `phone`) VALUES
(17, 'admin123', 'admin@123', 'admin@gmail.com', '0898889998');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `issue`
--
ALTER TABLE `issue`
  ADD PRIMARY KEY (`id`),
  ADD KEY `book_id` (`book_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `issue`
--
ALTER TABLE `issue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
