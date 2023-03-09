-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 09, 2023 at 10:05 AM
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
  `Salt` varchar(255) NOT NULL,
  `Nationality` varchar(255) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Nickname` varchar(255) NOT NULL,
  `Avatar` varchar(255) NOT NULL,
  `Background` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Bio` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `allusers`
--

INSERT INTO `allusers` (`ID_User`, `Name`, `Last_Name`, `Email`, `Birthday`, `Password`, `Salt`, `Nationality`, `Type`, `Nickname`, `Avatar`, `Background`, `Description`, `Bio`) VALUES
(4, 'adam', 'rafraf', 'herace9095@wwgoc.com', '2023-03-01', 'tC7YZXsB0+WsnEGJK0Uxq3hZE7NxTi7RpodCYRImfdE=', 'we1jSHC8A1+ntULGQUfrLA==', 'Tunisian', 'Artist', 'azerty', 'YQZ7RpGqF3uncaRrdKPcrnU0K6LDKE_original.jpg', '562651.jpg', 'RANDOM SHIT', 'random shit'),
(5, 'azert', 'azerty', 'mowofel487@youke1.com', '2023-03-01', '8bKZV8nPe6ldJ5n7/2pbNoLdMrHtF4Ih5XgqtpaBF/k=', 'MGdu1v8CiA2vim1n6weltw==', 'Tunisian', 'artiste', 'nour', 'mito-s-bb.JPG', 'a204d903-da0a-4851-be61-e3b1e6429563.png', 'WELL HAHA OMG SO COOL EPIC STYLE', '3D ARTIST'),
(6, 'adam', 'rafraf', 'yaxakak805@wireps.com', '2023-03-01', 'RNttaner826u5Pqd5XCdEGNPXcXU5jGhw2TLQRV+b+E=', 'sTcDyaFzNbcJEj/Cc3GzCA==', 'Tunisia', 'studio', 'foulen1', 'Opera Snapshot_2022-04-19_124643_mangaplus.shueisha.co.jp.png', 'a204d903-da0a-4851-be61-e3b1e6429563.png', 'azrr rzrzrz r grg rg rr rgr gr gr gr gr g r yeeser yyesser yesser ', '3D ARTIST'),
(7, 'ggggggggg', 'ggggggggggg', 'nour23029mathers@gmail.com', '2023-03-28', 'Ejh/tvtuIFbmRxMOSuORa+yCE74PY9FxkVvs4okWw/s=', '2zuMjRFGcYm4/4NfotP+Mw==', 'dsedef', 'Admin', 'nounou', 'note-thanun-GI10ZiPO_3w-unsplash-1200x900.jpg', '176937.jpg', 'dddddddddddddddddddddddddddddddd', 'ddddddddd'),
(9, 'Admin', 'Ladmin', 'mogoga4655@youke1.com', '2023-03-01', 'SRwIkYiFEvZjUMScRxMiLsiS8hmVMksivzvRYibb0vk=', 'n5dd0jc9tUCxMMF6KKjy0Q==', 'Tunisia', 'Admin', 'Admoun', 'YQZ7RpGqF3uncaRrdKPcrnU0K6LDKE_original.jpg', '2.jpg', 'AZRT AZ RT Z RZRZ TZ ERGR TERT ERGE RGER GER GERG ERGER GREG ERG ERGE RGER GER GERG REG REG REG ERG REGRE GR', '3D ARTIST'),
(10, 'test', 'tets', 'lacow97212@orgria.com', '2023-03-01', 'B24ur5SmWxDt6nLxHkAYIXKrB8Q1OBnyWJ5chVUg3QE=', 'bnghZ+j/tKAivqIoJaWn8w==', 'Anguilla', 'Admin', 'test', 'YQZ7RpGqF3uncaRrdKPcrnU0K6LDKE_original.jpg', '2.jpg', 'zazazazazazazazazaza', 'azazazazaza');

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `allusers`
--
ALTER TABLE `allusers`
  MODIFY `ID_User` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
