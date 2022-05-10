-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2022 at 09:13 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electrogrid`
--

-- --------------------------------------------------------

--
-- Table structure for table `powerconsumption`
--

CREATE TABLE `powerconsumption` (
  `Id` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `MobileNumber` varchar(20) NOT NULL,
  `Units` int(11) NOT NULL,
  `BillDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `powerconsumption`
--

INSERT INTO `powerconsumption` (`Id`, `UserId`, `MobileNumber`, `Units`, `BillDate`) VALUES
(5, 1, '1234567890', 3, '2022-04-25 00:00:00'),
(7, 1, '1234567890', 10, '2022-05-11 00:00:00'),
(8, 1, '1234567890', 15, '2022-05-11 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Id` int(11) NOT NULL,
  `Name` varchar(200) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `MobileNumber` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Id`, `Name`, `Address`, `MobileNumber`) VALUES
(1, 'John', 'Test Address', '1234567890');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `powerconsumption`
--
ALTER TABLE `powerconsumption`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKEY_USER` (`UserId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `powerconsumption`
--
ALTER TABLE `powerconsumption`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `powerconsumption`
--
ALTER TABLE `powerconsumption`
  ADD CONSTRAINT `FKEY_USER` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
