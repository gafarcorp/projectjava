-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 07 fév. 2022 à 19:21
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `notes`
--

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(250) NOT NULL,
  `ueEnseigner` varchar(234) NOT NULL,
  `motpass` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`id`, `nom`, `prenom`, `ueEnseigner`, `motpass`) VALUES
(1, 'balo', 'ani', 'maths', ''),
(2, 'ouka', 'djaba', 'physique', ''),
(3, 'pepkessi', 'tabalo', 'svt', ''),
(4, 'bad', 'fataou', 'francais', 'fataou');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(250) NOT NULL,
  `motpass` varchar(250) NOT NULL,
  `ueEtudier` varchar(234) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `nom`, `prenom`, `motpass`, `ueEtudier`) VALUES
(1, 'badana', 'gafar', '', 'maths'),
(2, 'koulo', 'jule', 'jule', 'francais'),
(3, 'toto', 'full', 'gao', 'pysique'),
(4, 'badana', 'gafar', 'gafar', 'programation'),
(5, 'adam', 'sylvain', 'adam', 'anglais');

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `ue` varchar(50) NOT NULL,
  `noteue` int(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nom` (`nom`),
  KEY `ue` (`ue`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `note`
--

INSERT INTO `note` (`id`, `nom`, `ue`, `noteue`) VALUES
(1, 'null', 'null', 0),
(2, 'koulo', 'francais', 16),
(3, 'toto', 'pysique', 14),
(4, 'toto', 'resau', 9),
(5, 'badana', 'programation', 17);

-- --------------------------------------------------------

--
-- Structure de la table `ue`
--

DROP TABLE IF EXISTS `ue`;
CREATE TABLE IF NOT EXISTS `ue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codeUe` varchar(50) NOT NULL,
  `nomUe` varchar(250) NOT NULL,
  `credit` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ue`
--

INSERT INTO `ue` (`id`, `codeUe`, `nomUe`, `credit`) VALUES
(1, 'null', 'null', 0),
(2, '', 'kofi', 34),
(3, 'tere', 'anglais', 6),
(4, 'ANG2', 'ANGLAIS INFO', 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
