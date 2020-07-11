-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 14, 2019 at 06:01 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quizapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(255) NOT NULL,
  `category_name` varchar(255) NOT NULL,
  `category_desc` varchar(2000) NOT NULL,
  `questions_available` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `category_name`, `category_desc`, `questions_available`) VALUES
(1, 'programming', 'this category holds only programming and general knowledge quetions about tech world', 10);

-- --------------------------------------------------------

--
-- Table structure for table `enroll_students`
--

CREATE TABLE `enroll_students` (
  `id` int(255) NOT NULL,
  `student_name` varchar(2000) NOT NULL,
  `student_rollno` varchar(255) NOT NULL,
  `student_emailid` varchar(255) NOT NULL,
  `student_division` varchar(10) NOT NULL,
  `student_year` varchar(255) NOT NULL,
  `student_quiz_category` varchar(500) NOT NULL,
  `quiz_attended` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enroll_students`
--

INSERT INTO `enroll_students` (`id`, `student_name`, `student_rollno`, `student_emailid`, `student_division`, `student_year`, `student_quiz_category`, `quiz_attended`) VALUES
(1, 'shivam kharde', '18102A2016', 'shivam.kharde@vit.edu.in', 'A', 'SE', 'programming', '2019-04-14 02:07:43'),
(2, 'dfgh', 'vhbjn', 'hbjn', 'A', 'SE', 'programming', '2019-04-14 02:19:48'),
(3, 'fhvjhb', 'fhjn', 'hj', 'B', 'SE', 'programming', '2019-04-14 02:20:39'),
(4, 'tyuhijk', 'yuhijo', 'tuyhijo', 'B', 'TE', 'programming', '2019-04-14 02:22:48'),
(5, 'chvjbk', 'nvhbkj', 'nlkvhbkj', 'A', 'BE', 'programming', '2019-04-14 02:24:10'),
(6, 'ghvjbkn', 'hvjbk', 'jngvjhb', 'A', 'TE', 'programming', '2019-04-14 02:25:32'),
(7, 'gghjbkn', 'vhjbk', 'nhjk', 'B', 'TE', 'programming', '2019-04-14 02:29:15'),
(8, 'nkml', 'hjk', 'vhbjnkl', 'B', 'TE', 'programming', '2019-04-14 02:32:50'),
(9, 'gjhjn', 'vhb', 'nbn', 'B', 'BE', 'programming', '2019-04-14 02:34:05'),
(10, 'fchgvjhb', 'knchvjhbkjnlm', 'jbknkml', 'B', 'SE', 'programming', '2019-04-14 02:50:12'),
(11, 'hgvjhb', 'jhbkj', 'nbn', 'A', 'TE', 'programming', '2019-04-14 02:51:16'),
(12, 'fchvjb', 'gvjhkjk', 'ghbkjnkm', 'B', 'TE', 'programming', '2019-04-14 02:52:23'),
(13, 'fgjhj', 'jhkjnk', 'jhbkjnk', 'A', 'SE', 'programming', '2019-04-14 02:54:14'),
(14, 'hgvjh', 'bhgb', 'gvjhbkjn', 'B', 'TE', 'programming', '2019-04-14 02:55:58'),
(15, 'bm', 'jhbkjn', 'n', 'C', 'SE', 'programming', '2019-04-14 02:56:36'),
(16, 'gfchgvjhbk', 'hgvjhbkj', 'fgjhk', 'A', 'SE', 'programming', '2019-04-14 02:58:33'),
(17, 'hvjh', 'jhkj', 'ghvjhbk', 'A', 'SE', 'programming', '2019-04-14 02:59:20'),
(18, 'gjhkjlk', 'hkjlk', 'gjhkjnlk', 'A', 'SE', 'programming', '2019-04-14 03:05:16'),
(19, 'dfhgjkhvjhjk', 'hbjnkml;', 'hbjnkml;', 'C', 'TE', 'programming', '2019-04-14 12:40:25'),
(20, 'shivam', '18102A2016', 'shivam121820@gmail.com', 'A', 'SE', 'programming', '2019-04-14 12:48:47'),
(21, 'fdxcvb', 'fhvjnm', 'fcbnm', 'A', 'SE', 'programming', '2019-04-14 12:53:33'),
(22, 'shivam', '18102A2016', 'shivam@gmail.com', 'B', 'TE', 'programming', '2019-04-14 12:55:10'),
(23, 'vb', 'hjk', 'cvhbjn', 'B', 'TE', 'programming', '2019-04-14 12:59:59'),
(24, 'ssss', '5555555555555', '555555555555', 'B', 'TE', 'programming', '2019-04-15 14:47:20'),
(25, 'fhjhklk', '3456787', 'fhghjjkl', 'B', 'TE', 'programming', '2019-04-16 12:41:14'),
(26, 'dfghjkl;', '456789', 'chjk', 'B', 'TE', 'programming', '2019-04-16 12:43:11'),
(27, 'fdxchvbn', 'fhvjhbknlm;,', 'hvjhbknlm;,;', 'B', 'SE', 'programming', '2019-04-17 12:42:48'),
(28, 'dfhj', 'fhjk', 'hjk', 'B', 'SE', 'programming', '2019-04-17 23:23:50'),
(29, 'fchvjbn', 'fgchgvjbknl', 'fhvjknlk', 'A', 'TE', 'programming', '2019-04-17 23:31:15'),
(30, 'fdgchvj', 'bdxfchv', 'jbkfchv', 'A', 'TE', 'programming', '2019-04-17 23:33:38'),
(31, 'fcghvjb', 'fhgvjh', 'kjfchvjhbkn', 'B', 'TE', 'programming', '2019-04-17 23:43:00'),
(32, 'gfchvjbkn', 'bnlk', 'fghgjkl', 'A', 'SE', 'programming', '2019-04-18 00:16:47'),
(33, 'fhgvjbkn', 'fcgvjhk', 'nfgchjk', 'B', 'TE', 'programming', '2019-04-18 00:19:31'),
(34, 'vhkjlHJK', 'hjk', 'hjnlk', 'A', 'SE', 'programming', '2019-04-18 00:22:50'),
(35, 'cchvjbnm', 'gvjhbknl', 'hjk', 'A', 'SE', 'programming', '2019-04-18 00:25:17'),
(36, 'nbl;', 'hkjl;', 'lgjhbkjnl', 'B', 'TE', 'programming', '2019-04-18 00:25:51'),
(37, 'fgchvjbn', 'fchvjbk', 'nlchgvjbknlm', 'B', 'BE', 'programming', '2019-04-18 00:27:34'),
(38, 'dfhgjkl', 'gjhkl;', 'nm,', 'A', 'SE', 'programming', '2019-04-18 00:31:34'),
(39, 'tdfhjkl', 'jhkl;', ';hkjl', 'A', 'TE', 'programming', '2019-04-18 00:32:38'),
(40, 'dxcvbnm', 'hbnml,', 'hgnm,', 'A', 'SE', 'programming', '2019-04-18 00:34:04'),
(41, 'fdxgchvjk', 'fhjk', 'lfhjk', 'B', 'SE', 'programming', '2019-04-18 00:36:06'),
(42, 'gfchvjbkn', 'chgvjbkn', 'lmfchgvjbn', 'A', 'SE', 'programming', '2019-04-18 00:38:10'),
(43, 'gfhvbn', 'bn', 'hjkjlk', 'B', 'TE', 'programming', '2019-04-18 00:39:25'),
(44, 'fcvbn', 'xfchvjb', 'kjbnm,', 'A', 'SE', 'programming', '2019-04-18 00:41:39'),
(45, 'bnl', 'hvjhbkjn', 'chj', 'B', 'SE', 'programming', '2019-04-18 00:46:03'),
(46, 'ghjkj', 'cv', 'bnfchvb', 'B', 'SE', 'programming', '2019-04-18 00:50:55'),
(47, 'hjk', 'chvjb', 'khvjbk', 'A', 'SE', 'programming', '2019-04-18 01:16:38'),
(48, 'fhvjbn', 'vbnm,', 'n', 'B', 'SE', 'programming', '2019-04-18 01:20:26'),
(49, 'chvjb', 'nchgvjbk', 'nhcgvjhbkjn', 'A', 'SE', 'programming', '2019-04-18 01:22:26'),
(50, 'gfhjk', 'fhjbknlk', 'fhgjhbkjn', 'C', 'SE', 'programming', '2019-04-18 01:30:22'),
(51, 'vb', 'chgvjkj', 'hgvjbn', 'A', 'SE', 'programming', '2019-04-18 01:32:43'),
(52, 'hvjbn', 'chvjbknl', 'chgvjbknl', 'B', 'TE', 'programming', '2019-04-18 01:37:46'),
(53, 'hgjkj', 'ghvjhbk', 'jghvj', 'B', 'TE', 'programming', '2019-04-18 01:40:02'),
(54, 'vb', 'hjk', 'hvjbk', 'B', 'TE', 'programming', '2019-04-18 01:41:50'),
(55, 'dfhjkl;\'', 'hjknl;', 'gfhjkl;', 'A', 'TE', 'programming', '2019-04-18 11:12:10'),
(56, 'dcfvbhnjkml', 'n,.', 'dffhgjh', 'B', 'SE', 'programming', '2019-04-18 12:38:42'),
(57, 'sdf', 'df', 'dfg', 'B', 'SE', 'programming', '2019-04-18 12:41:38'),
(58, 'hf', 'dd', 'd', 'B', 'BE', 'programming', '2019-04-18 12:43:45'),
(59, 'Advait Maidalkar', '1810C2012', 'sivamisayeda@vit.edu.in', 'C', 'SE', 'programming', '2019-04-18 14:17:51'),
(60, 'dfcvh', 'jdfhjnkml,', 'fhjnkml,;', 'A', 'SE', 'programming', '2019-04-18 14:22:56'),
(61, 'govind', '18397266', 'sfsfg@email.com', 'A', 'TE', 'programming', '2019-07-27 16:30:19'),
(62, 'jhbknlm;,\';', 'fghjkl;\'', 'fhgjkl', 'A', 'SE', 'programming', '2019-07-27 16:37:20');

-- --------------------------------------------------------

--
-- Table structure for table `main`
--

CREATE TABLE `main` (
  `id` int(255) NOT NULL,
  `question` varchar(2000) NOT NULL,
  `o1` varchar(255) NOT NULL,
  `o2` varchar(255) NOT NULL,
  `o3` varchar(255) NOT NULL,
  `o4` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `main`
--

INSERT INTO `main` (`id`, `question`, `o1`, `o2`, `o3`, `o4`, `answer`, `category`) VALUES
(1, 'who is a founder of java language?', 'Mark zukerberg', 'Elon Musk', 'Steave Jobs', 'James Gosling', 'James Gosling', 'programming'),
(2, 'Who invented C++ ?', 'Larry Wall', 'Anders Hejlsberg', 'Bjarne Stroustrup', 'John Backus', 'Bjarne Stroustrup', 'programming'),
(3, 'HTTP stands for?', 'Hello Transport Typical Pro ', 'Hypertext Transfer Ptotocol', 'Hypertext Transfer Text Ptotocol', 'Hypertext Transfer Image Ptotocol', 'Hypertext Transfer Ptotocol', 'programming'),
(4, 'The keyword used to transfer control from a function back to the calling function is?', 'switch', 'goto', 'go back', 'return', 'return', 'programming'),
(5, 'qwert', 'a', 'b', 'c', 'd', 'a', 'programming'),
(6, 'What is the logo of Java', 'Pot', 'Plate', 'Cup and Saucer', 'Bottle', 'Cup and Saucer', 'programming');

-- --------------------------------------------------------

--
-- Table structure for table `quiz_completed`
--

CREATE TABLE `quiz_completed` (
  `id` int(255) NOT NULL,
  `s_name` varchar(2000) NOT NULL,
  `s_rollno` varchar(255) NOT NULL,
  `s_division` varchar(16) NOT NULL,
  `s_year` varchar(16) NOT NULL,
  `q_category` varchar(255) NOT NULL,
  `t_questions` varchar(2000) NOT NULL,
  `correctans` varchar(2000) NOT NULL,
  `incorrectans` varchar(2000) NOT NULL,
  `score` varchar(2000) NOT NULL,
  `percent` varchar(2000) NOT NULL,
  `grade` varchar(16) NOT NULL,
  `q_endtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiz_completed`
--

INSERT INTO `quiz_completed` (`id`, `s_name`, `s_rollno`, `s_division`, `s_year`, `q_category`, `t_questions`, `correctans`, `incorrectans`, `score`, `percent`, `grade`, `q_endtime`) VALUES
(1, 'hjk', 'chvjb', 'A', 'SE', 'programming', '4', '2', '2', '2', '50.0%', 'C', '2019-04-17 19:47:16'),
(2, 'hjk', 'chvjb', 'A', 'SE', 'programming', '4', '2', '2', '2', '50.0%', 'C', '2019-04-17 19:47:22'),
(3, 'fhvjbn', 'vbnm,', 'B', 'SE', 'programming', '4', '1', '3', '1', '25.0%', 'D', '2019-04-17 19:50:51'),
(4, 'chvjb', 'nchgvjbk', 'A', 'SE', 'programming', '4', '4', '0', '4', '100.0%', 'A', '2019-04-17 19:53:31'),
(5, 'vb', 'chgvjkj', 'A', 'SE', 'programming', '4', '3', '1', '3', '75.0%', 'B', '2019-04-17 20:03:38'),
(6, 'vb', 'hjk', 'B', 'TE', 'programming', '4', '4', '0', '4', '100.0%', 'A', '2019-04-17 20:12:31'),
(7, 'dfhjkl;\'', 'hjknl;', 'A', 'TE', 'programming', '4', '3', '1', '3', '75.0%', 'B', '2019-04-18 05:44:07'),
(8, 'sdf', 'df', 'B', 'SE', 'programming', '4', '2', '2', '2', '50.0%', 'C', '2019-04-18 07:12:39'),
(9, 'Advait Maidalkar', '1810C2012', 'C', 'SE', 'programming', '5', '1', '4', '1', '20.0%', 'D', '2019-04-18 08:50:11'),
(10, 'govind', '18397266', 'A', 'TE', 'programming', '6', '4', '2', '4', '66.66667%', 'B', '2019-07-27 11:03:25');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `enroll_students`
--
ALTER TABLE `enroll_students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `main`
--
ALTER TABLE `main`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `quiz_completed`
--
ALTER TABLE `quiz_completed`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `enroll_students`
--
ALTER TABLE `enroll_students`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `main`
--
ALTER TABLE `main`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `quiz_completed`
--
ALTER TABLE `quiz_completed`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
