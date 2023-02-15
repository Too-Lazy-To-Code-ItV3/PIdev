-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 15, 2023 at 07:53 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `artounsi`
--

-- --------------------------------------------------------

--
-- Table structure for table `allusers`
--

CREATE TABLE `allusers` (
  `ID_User` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Last_Name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Birthday` date NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Nationality` varchar(255) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Nickname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `allusers`
--

INSERT INTO `allusers` (`ID_User`, `Name`, `Last_Name`, `Email`, `Birthday`, `Password`, `Nationality`, `Type`, `Nickname`) VALUES
(4, 'Adam', 'Rafraf ', 'Adam@gmail.com', '2000-09-09', 'RNPifULlKAHje8zQFFjR0j41BrfSDyiTkZBeBRYNSmw=', 'Tunisian', 'Artiste', 'AdamRafraf');

-- --------------------------------------------------------

--
-- Table structure for table `ban`
--

CREATE TABLE `ban` (
  `ID_Ban` int(11) NOT NULL,
  `ID_User` int(11) NOT NULL,
  `Reason` varchar(255) NOT NULL,
  `DateB` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allusers`
--
ALTER TABLE `allusers`
  ADD PRIMARY KEY (`ID_User`),
  ADD UNIQUE KEY `NicknameUnique` (`Nickname`),
  ADD UNIQUE KEY `EmailUnique` (`Email`);

--
-- Indexes for table `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`ID_Ban`),
  ADD KEY `fk_banuser` (`ID_User`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `allusers`
--
ALTER TABLE `allusers`
  MODIFY `ID_User` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `ban`
--
ALTER TABLE `ban`
  MODIFY `ID_Ban` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ban`
--
ALTER TABLE `ban`
  ADD CONSTRAINT `fk_banuser` FOREIGN KEY (`ID_User`) REFERENCES `allusers` (`ID_User`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
