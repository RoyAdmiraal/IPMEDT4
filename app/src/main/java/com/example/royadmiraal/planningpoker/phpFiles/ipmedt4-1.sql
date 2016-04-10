-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Gegenereerd op: 10 apr 2016 om 12:57
-- Serverversie: 10.1.10-MariaDB
-- PHP-versie: 5.6.19

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
-- Tabelstructuur voor tabel `gebruiker`
--

CREATE TABLE `gebruiker` (
  `gebruiker_id` int(11) NOT NULL,
  `gebruiker_naam` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `gebruiker`
--

INSERT INTO `gebruiker` (`gebruiker_id`, `gebruiker_naam`) VALUES
(1, 'Collin'),
(2, 'Roy'),
(3, 'Marius');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `gebruiker_sessie`
--

CREATE TABLE `gebruiker_sessie` (
  `gbr_sessie_sessie_id` int(11) NOT NULL,
  `gbr_sessie_gebruiker_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `gebruiker_sessie`
--

INSERT INTO `gebruiker_sessie` (`gbr_sessie_sessie_id`, `gbr_sessie_gebruiker_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `sessie`
--

CREATE TABLE `sessie` (
  `sessie_id` int(11) NOT NULL,
  `sessie_naam` varchar(255) NOT NULL,
  `sessie_timer` time NOT NULL,
  `sessie_sm_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `sessie`
--

INSERT INTO `sessie` (`sessie_id`, `sessie_naam`, `sessie_timer`, `sessie_sm_id`) VALUES
(1, 'Sprint 2 april test', '00:01:00', 1),
(2, 'Final sprint april', '00:02:00', 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `taak`
--

CREATE TABLE `taak` (
  `taak_id` int(11) NOT NULL,
  `taak_sessie_id` int(11) NOT NULL,
  `taak_naam` varchar(255) NOT NULL,
  `taak_beschrijving` varchar(355) NOT NULL,
  `taak_resultaat` tinyint(1) NOT NULL,
  `taak_opmerking` varchar(355) NOT NULL,
  `taak_ronde` int(11) NOT NULL,
  `taak_kaart0` tinyint(2) NOT NULL DEFAULT '13',
  `taak_kaart1` tinyint(2) NOT NULL DEFAULT '13',
  `taak_kaart2` tinyint(2) NOT NULL DEFAULT '13',
  `taak_kaart3` tinyint(2) NOT NULL DEFAULT '13',
  `taak_kaart4` tinyint(2) NOT NULL DEFAULT '13',
  `taak_kaart5` tinyint(2) NOT NULL DEFAULT '13',
  `taak_kaart6` tinyint(2) NOT NULL DEFAULT '13',
  `taak_kaart7` tinyint(2) NOT NULL DEFAULT '13'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `taak`
--

INSERT INTO `taak` (`taak_id`, `taak_sessie_id`, `taak_naam`, `taak_beschrijving`, `taak_resultaat`, `taak_opmerking`, `taak_ronde`, `taak_kaart0`, `taak_kaart1`, `taak_kaart2`, `taak_kaart3`, `taak_kaart4`, `taak_kaart5`, `taak_kaart6`, `taak_kaart7`) VALUES
(1, 1, 'Splash screen ontwerpen', 'Splash screen in high fidelity.', 3, 'Omdat het geen moeilijke taak voor de ontwerper is.', 1, 2, 3, 3, 13, 13, 13, 13, 13),
(2, 1, 'Splash screen realiseren', 'Het volledige splash screen werkend in de app.', 4, 'Er moet gewacht worden op het design verder is het programmeer werk niet heel moeilijk.', 2, 4, 4, 4, 13, 13, 13, 13, 13),
(3, 1, 'Deelnemen sessie', 'Deelnemen sessie werkend maken.', 5, 'Geen.', 3, 5, 6, 5, 13, 13, 13, 13, 13),
(4, 2, 'Splash screen realiseren', 'Het volledige splash screen werkend in de app.', 8, 'Er moet gewacht worden op het design verder is het programmeer werk niet heel moeilijk.', 1, 8, 8, 8, 13, 13, 13, 13, 13);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `gebruiker`
--
ALTER TABLE `gebruiker`
  ADD PRIMARY KEY (`gebruiker_id`);

--
-- Indexen voor tabel `gebruiker_sessie`
--
ALTER TABLE `gebruiker_sessie`
  ADD KEY `sessie_id` (`gbr_sessie_sessie_id`),
  ADD KEY `gebruiker_id` (`gbr_sessie_gebruiker_id`);

--
-- Indexen voor tabel `sessie`
--
ALTER TABLE `sessie`
  ADD PRIMARY KEY (`sessie_id`),
  ADD KEY `sessie_scrum_master_id` (`sessie_sm_id`);

--
-- Indexen voor tabel `taak`
--
ALTER TABLE `taak`
  ADD PRIMARY KEY (`taak_id`),
  ADD KEY `sessie_id` (`taak_sessie_id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `gebruiker`
--
ALTER TABLE `gebruiker`
  MODIFY `gebruiker_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT voor een tabel `sessie`
--
ALTER TABLE `sessie`
  MODIFY `sessie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT voor een tabel `taak`
--
ALTER TABLE `taak`
  MODIFY `taak_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `gebruiker_sessie`
--
ALTER TABLE `gebruiker_sessie`
  ADD CONSTRAINT `gebruiker_sessie_ibfk_1` FOREIGN KEY (`gbr_sessie_sessie_id`) REFERENCES `sessie` (`sessie_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `gebruiker_sessie_ibfk_2` FOREIGN KEY (`gbr_sessie_gebruiker_id`) REFERENCES `gebruiker` (`gebruiker_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `sessie`
--
ALTER TABLE `sessie`
  ADD CONSTRAINT `sessie_ibfk_1` FOREIGN KEY (`sessie_sm_id`) REFERENCES `gebruiker` (`gebruiker_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Beperkingen voor tabel `taak`
--
ALTER TABLE `taak`
  ADD CONSTRAINT `taak_ibfk_1` FOREIGN KEY (`taak_sessie_id`) REFERENCES `sessie` (`sessie_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
