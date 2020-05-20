-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 03 avr. 2020 à 14:06
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet3`
--

-- --------------------------------------------------------
--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `password`, `username`) VALUES
(2, 'jean38', 'jean'),
(1, 'babar38', 'babar'),
(3, 'pierre38', 'pierre'),
(99, '', 'testUser');

--
-- Déchargement des données de la table `work`
--

INSERT INTO `work` (`id`, `author`, `bookDescription`,`borrowable`, `publicationDate`, `reservable`, `reservationRealized`, `title`) VALUES
(2, 'Babar', 'Babar part en vacances aux Maldives', b'1', '2018-12-01 00:00:00', b'0', 0, 'Les vacances de Babar'),
(1, 'Babar', 'l\'histoire de babar', b'1', '2018-12-04 00:00:00', b'0', 0, 'Babar se marie'),
(3, 'Tolkien', 'la communauté de l\'anneau voyage', b'1', '1975-01-07 00:00:00', b'0', 0, 'Le seigneur des anneaux I'),
(4, 'Tolkien', 'La partie 2', b'1', '1980-08-05 00:00:00', b'0', 0, 'Le seigneur des anneaux II'),
(5, 'Tolkien', 'La partie 3 du livre', b'1', '1982-09-11 00:00:00', b'0', 0, 'Le seigneur des anneaux III'),
(6, 'Sartre', 'Autobiographie', b'1', '1964-09-11 00:00:00', b'0', 0, 'Les mots'),
(7, 'Asimov', 'Le Cycle des robots I', b'1', '1967-09-11 00:00:00', b'0', 0, 'Les Robots'),
(8, 'Rowling', 'La serie Harry Potter I', b'1', '1997-09-11 00:00:00', b'0', 0, 'Harry Potter à l école des sorciers'),
(99, 'testAuthor', '', b'0', '1997-09-11 00:00:00', b'1', 0, 'testReserve'),
(98, 'testAuthor', '', b'1', '1997-09-11 00:00:00', b'0', 0, 'testBorrow');

--
-- Déchargement des données de la table `work_book`
--

INSERT INTO `work_book` (`Work_id`, `booksList_id`) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(4, 6),
(5, 7),
(6, 8),
(7, 9),
(8, 10),
(9, 99);


--
-- Déchargement des données de la table `member`
--

INSERT INTO `member` (`mailAdress`, `name`, `id`) VALUES
('ketut38@gmail.com', 'babar', 1),
('test.javaketut38@gmail.com', 'jean', 2),
('test.javaketut38@gmail.com', 'pierre', 3),
('test.javaketut38@gmail.com', 'testMember', 99);

-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`id`, `available`) VALUES
(1, b'1'),
(2, b'1'),
(3, b'1'),
(4, b'1'),
(5, b'1'),
(6, b'1'),
(7, b'1'),
(8, b'1'),
(9, b'1'),
(10, b'1'),
(99, b'1');
COMMIT;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
