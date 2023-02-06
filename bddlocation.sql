-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 06 fév. 2023 à 17:47
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bddlocation`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) NOT NULL,
  `adress` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `adress`) VALUES
(6, 'BOTO', 'TULEAR'),
(2, 'LULU', 'XXXX'),
(3, 'TATA', 'S'),
(7, 'ALAIN BREUH', 'Fianar'),
(11, 'VOLA', 'FIANAR');

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `idCli` int(11) NOT NULL,
  `idVtr` int(11) NOT NULL,
  `nbJour` int(9) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idVtr` (`idVtr`),
  KEY `idCli` (`idCli`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `location`
--

INSERT INTO `location` (`id`, `idCli`, `idVtr`, `nbJour`, `date`) VALUES
(1, 1, 1, 10, '2022-08-02'),
(4, 2, 1, 8, '2000-08-19'),
(3, 1, 2, 6, '2022-08-03'),
(6, 3, 2, 15, '2023-01-07'),
(7, 2, 1, 15, '2022-08-16'),
(8, 2, 2, 2, '2015-02-02'),
(9, 2, 2, 10, '2022-08-13'),
(10, 2, 2, 15, '2222-02-22'),
(12, 1, 2, 20, '1099-02-02'),
(13, 7, 7, 5, '1999-05-05'),
(15, 7, 8, 8, '2022-08-18'),
(16, 11, 12, 3, '2022-08-18');

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

DROP TABLE IF EXISTS `voiture`;
CREATE TABLE IF NOT EXISTS `voiture` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `numero` varchar(50) NOT NULL,
  `marque` varchar(50) NOT NULL,
  `loyer` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `voiture`
--

INSERT INTO `voiture` (`id`, `numero`, `marque`, `loyer`) VALUES
(1, '1882 FE', 'MAZDA', 500),
(2, '1212 FC', 'MAZDA', 100),
(6, '1212 FC', 'FORD', 800),
(8, '46548 FE', 'FORD', 505),
(10, '1882 FE', 'LAMBO', 55000),
(12, '1212 FC', 'MAZDA55', 3000),
(13, '1882 FE', 'XXXXXXXXXXXXX', 15),
(99, '897 WWT', 'AUDI', 9999);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
