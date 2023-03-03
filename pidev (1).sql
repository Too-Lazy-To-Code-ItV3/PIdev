-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 03 mars 2023 à 19:53
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pidev`
--

-- --------------------------------------------------------

--
-- Structure de la table `allusers`
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
-- Déchargement des données de la table `allusers`
--

INSERT INTO `allusers` (`ID_User`, `Name`, `Last_Name`, `Email`, `Birthday`, `Password`, `Salt`, `Nationality`, `Type`, `Nickname`, `Avatar`, `Background`, `Description`, `Bio`) VALUES
(4, 'adam', 'rafraf', 'herace9095@wwgoc.com', '2023-03-01', 'tC7YZXsB0+WsnEGJK0Uxq3hZE7NxTi7RpodCYRImfdE=', 'we1jSHC8A1+ntULGQUfrLA==', 'Tunisian', 'Artist', 'azerty', 'YQZ7RpGqF3uncaRrdKPcrnU0K6LDKE_original.jpg', '562651.jpg', 'RANDOM SHIT', 'random shit'),
(5, 'azert', 'azerty', 'mowofel487@youke1.com', '2023-03-01', '8bKZV8nPe6ldJ5n7/2pbNoLdMrHtF4Ih5XgqtpaBF/k=', 'MGdu1v8CiA2vim1n6weltw==', 'Tunisian', 'artiste', 'nour', 'mito-s-bb.JPG', 'a204d903-da0a-4851-be61-e3b1e6429563.png', 'WELL HAHA OMG SO COOL EPIC STYLE', '3D ARTIST'),
(6, 'adam', 'rafraf', 'yaxakak805@wireps.com', '2023-03-01', 'RNttaner826u5Pqd5XCdEGNPXcXU5jGhw2TLQRV+b+E=', 'sTcDyaFzNbcJEj/Cc3GzCA==', 'Tunisia', 'studio', 'foulen1', 'Opera Snapshot_2022-04-19_124643_mangaplus.shueisha.co.jp.png', 'a204d903-da0a-4851-be61-e3b1e6429563.png', 'azrr rzrzrz r grg rg rr rgr gr gr gr gr g r yeeser yyesser yesser ', '3D ARTIST'),
(7, 'ggggggggg', 'ggggggggggg', 'nour23029mathers@gmail.com', '2023-03-28', 'Ejh/tvtuIFbmRxMOSuORa+yCE74PY9FxkVvs4okWw/s=', '2zuMjRFGcYm4/4NfotP+Mw==', 'dsedef', 'artiste', 'nounou', 'note-thanun-GI10ZiPO_3w-unsplash-1200x900.jpg', '176937.jpg', 'dddddddddddddddddddddddddddddddd', 'ddddddddd');

-- --------------------------------------------------------

--
-- Structure de la table `allusers2`
--

CREATE TABLE `allusers2` (
  `ID_User` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Last_Name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Birthday` date NOT NULL,
  `Password` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `Nationality` varchar(255) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Nickname` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `allusers2`
--

INSERT INTO `allusers2` (`ID_User`, `Name`, `Last_Name`, `Email`, `Birthday`, `Password`, `salt`, `Nationality`, `Type`, `Nickname`, `Description`) VALUES
(2, 'nour', 'nour', 'nour23029mathers@gmail.com', '2023-03-24', 'mAaUYiJuTwWBbinLAgOOShMbLiUh0HrOh1+W5mzSrZU=', 'n7aBdvg4MRD/ooincQbncQ==', 'tunisienne', 'studio', 'noura', 'desc'),
(3, 'adam', 'adam', 'nour23029mathers@gmail.com', '2023-03-22', 'bFu2BINBzPavPpdZPzNCudfHKF8W3UI4nKXyjC4ULKw=', '+W8mSsJI4uoa4WXbq5fpkA==', 'tunisienne', 'artiste', 'adam', 'desc'),
(4, 'ggggggggggg', 'ggggggggg', 'nour23029mathers@gmail.com', '2023-03-17', 'BxWFexoE13kiepHm6nTcVf3WILsSg+B/xo3BV6Z7Kqg=', 'eEUlSt/PvvR3+F98SoRIfA==', 'fefds', 'artiste', 'nour', 'desc');

-- --------------------------------------------------------

--
-- Structure de la table `artistepostuler2`
--

CREATE TABLE `artistepostuler2` (
  `ID_User` int(50) NOT NULL,
  `idOffre` int(50) NOT NULL,
  `nomArtiste` varchar(255) NOT NULL,
  `titreOffre` varchar(255) NOT NULL,
  `datepostuler` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `artistepostuler2`
--

INSERT INTO `artistepostuler2` (`ID_User`, `idOffre`, `nomArtiste`, `titreOffre`, `datepostuler`) VALUES
(5, 50, 'nour', 'Senior VFX Artist', '2023-03-03 18:36:11');

-- --------------------------------------------------------

--
-- Structure de la table `ban`
--

CREATE TABLE `ban` (
  `ID_Ban` int(11) NOT NULL,
  `ID_User` int(11) NOT NULL,
  `Reason` varchar(255) NOT NULL,
  `DateB` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `categorie2`
--

CREATE TABLE `categorie2` (
  `id_category` int(50) NOT NULL,
  `name_category` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `categorie2`
--

INSERT INTO `categorie2` (`id_category`, `name_category`) VALUES
(1, '2d art'),
(2, '3d art');

-- --------------------------------------------------------

--
-- Structure de la table `demandetravail2`
--

CREATE TABLE `demandetravail2` (
  `ID_User` int(50) NOT NULL,
  `Nickname` varchar(255) NOT NULL,
  `titreDemande` varchar(255) NOT NULL,
  `descriptionDemande` varchar(255) NOT NULL,
  `categorieDemande` varchar(255) NOT NULL,
  `dateAjoutDemande` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `idDemande` int(50) NOT NULL,
  `idCategorie` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `demandetravail2`
--

INSERT INTO `demandetravail2` (`ID_User`, `Nickname`, `titreDemande`, `descriptionDemande`, `categorieDemande`, `dateAjoutDemande`, `idDemande`, `idCategorie`) VALUES
(5, 'nour', 'fvgfdbg', 'dfgvfdbg', '3d art', '2023-03-03 13:47:09', 15, 2),
(5, 'nour', 'gvdfgbvdfbgv', 'cfdsgvdfbvfcv', '3d art', '2023-03-03 14:08:18', 16, 2),
(5, 'nour', 'edfesgrdf', 'fdbnfgjhjlk,hgbfdsfghj', '2d art', '2023-03-03 17:20:34', 17, 1);

-- --------------------------------------------------------

--
-- Structure de la table `grosmots2`
--

CREATE TABLE `grosmots2` (
  `idMot` int(50) NOT NULL,
  `mot` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `grosmots2`
--

INSERT INTO `grosmots2` (`idMot`, `mot`) VALUES
(1, 'bhim'),
(2, 'stupid');

-- --------------------------------------------------------

--
-- Structure de la table `offretravail2`
--

CREATE TABLE `offretravail2` (
  `ID_User` int(50) NOT NULL,
  `titreOffre` varchar(255) NOT NULL,
  `descriptionOffre` varchar(255) NOT NULL,
  `categorieOffre` varchar(255) NOT NULL,
  `Nickname` varchar(255) NOT NULL,
  `dateAjoutOffre` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `typeOffre` varchar(255) NOT NULL,
  `localisationOffre` varchar(255) NOT NULL,
  `idCategorie` int(50) NOT NULL,
  `idOffre` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `offretravail2`
--

INSERT INTO `offretravail2` (`ID_User`, `titreOffre`, `descriptionOffre`, `categorieOffre`, `Nickname`, `dateAjoutOffre`, `typeOffre`, `localisationOffre`, `idCategorie`, `idOffre`) VALUES
(5, 'offre1', 'csdfcdf', '3d art', 'nour', '2023-03-03 13:03:52', 'freelance', 'Centre-Est', 2, 47),
(5, 'Art Director', 'we  want a house designer   architect to designe  for our clients', '3d art', 'nour', '2023-03-03 14:50:55', 'freelance', 'Centre-Ouest', 2, 48),
(5, 'Senior VFX Artist', 'experience needed and sailre motivant', '2d art', 'nour', '2023-03-03 15:57:45', 'contract', 'tunisie', 1, 50);

-- --------------------------------------------------------

--
-- Structure de la table `offretravailarchive2`
--

CREATE TABLE `offretravailarchive2` (
  `ID_User` int(50) NOT NULL,
  `titreOffre` varchar(255) NOT NULL,
  `descriptionOffre` varchar(255) NOT NULL,
  `categorieOffre` varchar(255) NOT NULL,
  `Nickname` varchar(255) NOT NULL,
  `dateAjoutOffre` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `typeOffre` varchar(255) NOT NULL,
  `localisationOffre` varchar(255) NOT NULL,
  `idCategorie` int(50) NOT NULL,
  `idOffre` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `allusers`
--
ALTER TABLE `allusers`
  ADD PRIMARY KEY (`ID_User`),
  ADD UNIQUE KEY `NicknameUnique` (`Nickname`),
  ADD UNIQUE KEY `EmailUnique` (`Email`);

--
-- Index pour la table `allusers2`
--
ALTER TABLE `allusers2`
  ADD PRIMARY KEY (`ID_User`),
  ADD UNIQUE KEY `Nickname` (`Nickname`);

--
-- Index pour la table `artistepostuler2`
--
ALTER TABLE `artistepostuler2`
  ADD KEY `idOffre` (`idOffre`),
  ADD KEY `artistepostuler2_ibfk_1` (`ID_User`);

--
-- Index pour la table `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`ID_Ban`),
  ADD KEY `fk_banuser` (`ID_User`);

--
-- Index pour la table `categorie2`
--
ALTER TABLE `categorie2`
  ADD PRIMARY KEY (`id_category`),
  ADD UNIQUE KEY `name_category` (`name_category`);

--
-- Index pour la table `demandetravail2`
--
ALTER TABLE `demandetravail2`
  ADD PRIMARY KEY (`idDemande`),
  ADD KEY `idCategorie` (`idCategorie`),
  ADD KEY `categorieDemande` (`categorieDemande`),
  ADD KEY `demandetravail2_ibfk_3` (`ID_User`),
  ADD KEY `demandetravail2_ibfk_4` (`Nickname`);

--
-- Index pour la table `grosmots2`
--
ALTER TABLE `grosmots2`
  ADD PRIMARY KEY (`idMot`);

--
-- Index pour la table `offretravail2`
--
ALTER TABLE `offretravail2`
  ADD PRIMARY KEY (`idOffre`),
  ADD KEY `offretravail2_ibfk_1` (`idCategorie`),
  ADD KEY `categorieOffre` (`categorieOffre`),
  ADD KEY `ID_User` (`ID_User`),
  ADD KEY `Nickname` (`Nickname`);

--
-- Index pour la table `offretravailarchive2`
--
ALTER TABLE `offretravailarchive2`
  ADD PRIMARY KEY (`idOffre`),
  ADD KEY `idCategorie` (`idCategorie`),
  ADD KEY `offretravailarchive2_ibfk_1` (`ID_User`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `allusers`
--
ALTER TABLE `allusers`
  MODIFY `ID_User` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `allusers2`
--
ALTER TABLE `allusers2`
  MODIFY `ID_User` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `ban`
--
ALTER TABLE `ban`
  MODIFY `ID_Ban` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `categorie2`
--
ALTER TABLE `categorie2`
  MODIFY `id_category` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `demandetravail2`
--
ALTER TABLE `demandetravail2`
  MODIFY `idDemande` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `grosmots2`
--
ALTER TABLE `grosmots2`
  MODIFY `idMot` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `offretravail2`
--
ALTER TABLE `offretravail2`
  MODIFY `idOffre` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT pour la table `offretravailarchive2`
--
ALTER TABLE `offretravailarchive2`
  MODIFY `idOffre` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `artistepostuler2`
--
ALTER TABLE `artistepostuler2`
  ADD CONSTRAINT `artistepostuler2_ibfk_1` FOREIGN KEY (`ID_User`) REFERENCES `allusers` (`ID_User`) ON DELETE CASCADE,
  ADD CONSTRAINT `artistepostuler2_ibfk_2` FOREIGN KEY (`idOffre`) REFERENCES `offretravail2` (`idOffre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `ban`
--
ALTER TABLE `ban`
  ADD CONSTRAINT `fk_banuser` FOREIGN KEY (`ID_User`) REFERENCES `allusers` (`ID_User`) ON DELETE CASCADE;

--
-- Contraintes pour la table `demandetravail2`
--
ALTER TABLE `demandetravail2`
  ADD CONSTRAINT `demandetravail2_ibfk_1` FOREIGN KEY (`idCategorie`) REFERENCES `categorie2` (`id_category`) ON DELETE CASCADE,
  ADD CONSTRAINT `demandetravail2_ibfk_2` FOREIGN KEY (`categorieDemande`) REFERENCES `categorie2` (`name_category`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demandetravail2_ibfk_3` FOREIGN KEY (`ID_User`) REFERENCES `allusers` (`ID_User`) ON DELETE CASCADE,
  ADD CONSTRAINT `demandetravail2_ibfk_4` FOREIGN KEY (`Nickname`) REFERENCES `allusers` (`Nickname`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `offretravail2`
--
ALTER TABLE `offretravail2`
  ADD CONSTRAINT `offretravail2_ibfk_1` FOREIGN KEY (`idCategorie`) REFERENCES `categorie2` (`id_category`) ON DELETE CASCADE,
  ADD CONSTRAINT `offretravail2_ibfk_3` FOREIGN KEY (`categorieOffre`) REFERENCES `categorie2` (`name_category`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `offretravail2_ibfk_4` FOREIGN KEY (`ID_User`) REFERENCES `allusers` (`ID_User`),
  ADD CONSTRAINT `offretravail2_ibfk_5` FOREIGN KEY (`Nickname`) REFERENCES `allusers` (`Nickname`);

--
-- Contraintes pour la table `offretravailarchive2`
--
ALTER TABLE `offretravailarchive2`
  ADD CONSTRAINT `offretravailarchive2_ibfk_1` FOREIGN KEY (`ID_User`) REFERENCES `allusers` (`ID_User`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
