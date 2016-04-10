-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2016 at 11:44 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ipmedt4`
--

-- --------------------------------------------------------

--
-- Table structure for table `gebruiker`
--

CREATE TABLE `gebruiker` (
  `gebruiker_id` int(11) NOT NULL,
  `gebruiker_naam` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gebruiker`
--

INSERT INTO `gebruiker` (`gebruiker_id`, `gebruiker_naam`) VALUES
(1, 'Collin'),
(2, 'Roy'),
(3, 'Marius');

-- --------------------------------------------------------

--
-- Table structure for table `gebruiker_sessie`
--

CREATE TABLE `gebruiker_sessie` (
  `gbr_sessie_sessie_id` int(11) NOT NULL,
  `gbr_sessie_gebruiker_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gebruiker_sessie`
--

INSERT INTO `gebruiker_sessie` (`gbr_sessie_sessie_id`, `gbr_sessie_gebruiker_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `ronde`
--

CREATE TABLE `ronde` (
  `ronde_id` int(11) NOT NULL,
  `ronde_nummer` int(11) NOT NULL,
  `ronde_sessie_id` int(11) NOT NULL,
  `ronde_kaart0` tinyint(2) NOT NULL DEFAULT '13',
  `ronde_kaart1` tinyint(2) NOT NULL DEFAULT '13',
  `ronde_kaart2` tinyint(2) NOT NULL DEFAULT '13',
  `ronde_kaart3` tinyint(2) NOT NULL DEFAULT '13',
  `ronde_kaart4` tinyint(2) NOT NULL DEFAULT '13',
  `ronde_kaart5` tinyint(2) NOT NULL DEFAULT '13',
  `ronde_kaart6` tinyint(2) NOT NULL DEFAULT '13',
  `ronde_kaart7` tinyint(2) NOT NULL DEFAULT '13'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ronde`
--

INSERT INTO `ronde` (`ronde_id`, `ronde_nummer`, `ronde_sessie_id`, `ronde_kaart0`, `ronde_kaart1`, `ronde_kaart2`, `ronde_kaart3`, `ronde_kaart4`, `ronde_kaart5`, `ronde_kaart6`, `ronde_kaart7`) VALUES
(1, 1, 1, 2, 3, 3, 13, 13, 13, 13, 13),
(2, 2, 1, 4, 4, 4, 13, 13, 13, 13, 13),
(3, 3, 1, 5, 6, 5, 13, 13, 13, 13, 13),
(4, 1, 2, 8, 8, 8, 13, 13, 13, 13, 13);

-- --------------------------------------------------------

--
-- Table structure for table `sessie`
--

CREATE TABLE `sessie` (
  `sessie_id` int(11) NOT NULL,
  `sessie_naam` varchar(255) NOT NULL,
  `sessie_timer` time NOT NULL,
  `sessie_sm_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sessie`
--

INSERT INTO `sessie` (`sessie_id`, `sessie_naam`, `sessie_timer`, `sessie_sm_id`) VALUES
(1, 'Sprint 2 april test', '00:01:00', 1),
(2, 'Final sprint april', '00:02:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `taak`
--

CREATE TABLE `taak` (
  `taak_id` int(11) NOT NULL,
  `taak_ronde_id` int(11) NOT NULL,
  `taak_naam` varchar(255) NOT NULL,
  `taak_beschrijving` varchar(355) NOT NULL,
  `taak_resultaat` tinyint(1) NOT NULL,
  `taak_opmerking` varchar(355) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `taak`
--

INSERT INTO `taak` (`taak_id`, `taak_ronde_id`, `taak_naam`, `taak_beschrijving`, `taak_resultaat`, `taak_opmerking`) VALUES
(1, 1, 'Splash screen ontwerpen', 'Splash screen in high fidelity.', 3, 'Is geen moeilijke taak voor de ontwerper.'),
(2, 2, 'Splash screen realiseren', 'Het volledige splash screen werkend in de app.', 4, 'Moet wachten op het design verder is het programmeer werk niet heel moeilijk.'),
(3, 3, 'Deelnemen sessie', 'Deelnemen sessie werkend maken.', 5, 'Geen'),
(4, 4, 'Taak 1 Lorem Ipsum', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fringilla diam id elementum posuere.', 8, 'Etiam fringilla diam id elementum posuere.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gebruiker`
--
ALTER TABLE `gebruiker`
  ADD PRIMARY KEY (`gebruiker_id`);

--
-- Indexes for table `gebruiker_sessie`
--
ALTER TABLE `gebruiker_sessie`
  ADD KEY `sessie_id` (`gbr_sessie_sessie_id`),
  ADD KEY `gebruiker_id` (`gbr_sessie_gebruiker_id`);

--
-- Indexes for table `ronde`
--
ALTER TABLE `ronde`
  ADD PRIMARY KEY (`ronde_id`),
  ADD KEY `sessie_id` (`ronde_sessie_id`);

--
-- Indexes for table `sessie`
--
ALTER TABLE `sessie`
  ADD PRIMARY KEY (`sessie_id`),
  ADD KEY `sessie_scrum_master_id` (`sessie_sm_id`);

--
-- Indexes for table `taak`
--
ALTER TABLE `taak`
  ADD PRIMARY KEY (`taak_id`),
  ADD KEY `ronde_id` (`taak_ronde_id`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gebruiker`
--
ALTER TABLE `gebruiker`
  MODIFY `gebruiker_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `ronde`
--
ALTER TABLE `ronde`
  MODIFY `ronde_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `sessie`
--
ALTER TABLE `sessie`
  MODIFY `sessie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `taak`
--
ALTER TABLE `taak`
  MODIFY `taak_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `gebruiker_sessie`
--
ALTER TABLE `gebruiker_sessie`
  ADD CONSTRAINT `gebruiker_sessie_ibfk_1` FOREIGN KEY (`gbr_sessie_sessie_id`) REFERENCES `sessie` (`sessie_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `gebruiker_sessie_ibfk_2` FOREIGN KEY (`gbr_sessie_gebruiker_id`) REFERENCES `gebruiker` (`gebruiker_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ronde`
--
ALTER TABLE `ronde`
  ADD CONSTRAINT `ronde_ibfk_1` FOREIGN KEY (`ronde_sessie_id`) REFERENCES `sessie` (`sessie_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ronde_ibfk_2` FOREIGN KEY (`ronde_id`) REFERENCES `taak` (`taak_ronde_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sessie`
--
ALTER TABLE `sessie`
  ADD CONSTRAINT `sessie_ibfk_1` FOREIGN KEY (`sessie_sm_id`) REFERENCES `gebruiker` (`gebruiker_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
