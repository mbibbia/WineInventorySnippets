-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 12, 2018 at 10:48 PM
-- Server version: 5.7.24-0ubuntu0.18.04.1
-- PHP Version: 7.2.10-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pt_wine_inventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `country_code` varchar(2) NOT NULL,
  `country_name` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`country_code`, `country_name`) VALUES
('AR', 'Argentinien'),
('AT', 'Österreich'),
('AU', 'Australien'),
('CH', 'Schweiz'),
('CL', 'Chile'),
('DE', 'Deutschland'),
('ES', 'Spanien'),
('FR', 'Frankreich'),
('GR', 'Griechenland'),
('HR', 'Ungarn'),
('IL', 'Israel'),
('IT', 'Italien'),
('LI', 'Liechtenstein'),
('PT', 'Portugal'),
('US', 'USA'),
('ZA', 'Südafrika');

-- --------------------------------------------------------

--
-- Table structure for table `producer`
--

CREATE TABLE `producer` (
  `producer_id` bigint(20) NOT NULL,
  `producer_addressline_1` varchar(100) DEFAULT NULL,
  `producer_addressline_2` varchar(100) DEFAULT NULL,
  `producer_company` varchar(60) DEFAULT NULL,
  `producer_email` varchar(100) DEFAULT NULL,
  `producer_fax` varchar(20) DEFAULT NULL,
  `producer_name` varchar(60) DEFAULT NULL,
  `producer_phone` varchar(20) DEFAULT NULL,
  `producer_place` varchar(60) DEFAULT NULL,
  `producer_url` varchar(100) DEFAULT NULL,
  `producer_zip_code` varchar(10) DEFAULT NULL,
  `producer_country` varchar(2) DEFAULT NULL,
  `producer_region` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `producer`
--

INSERT INTO `producer` (`producer_id`, `producer_addressline_1`, `producer_addressline_2`, `producer_company`, `producer_email`, `producer_fax`, `producer_name`, `producer_phone`, `producer_place`, `producer_url`, `producer_zip_code`, `producer_country`, `producer_region`) VALUES
(1, 'Loc. Bussia 55', NULL, 'Parusso Armando di Parusso F.lli Società Agricola', 'info@parusso.com', NULL, 'Parusso', '0039 173 78257', 'Monforte d\'Alba', 'http://parusso.com/', '12065', 'IT', 18);

-- --------------------------------------------------------

--
-- Table structure for table `region`
--

CREATE TABLE `region` (
  `region_id` bigint(20) NOT NULL,
  `region_name` varchar(255) DEFAULT NULL,
  `country` varchar(2) DEFAULT NULL,
  `country_regions` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `region`
--

INSERT INTO `region` (`region_id`, `region_name`, `country`, `country_regions`) VALUES
(1, 'Champagne', 'FR', NULL),
(2, 'Kremstal', 'AT', NULL),
(3, 'Venetien', 'IT', NULL),
(4, 'Luzern', 'CH', NULL),
(5, 'Aragonien', 'ES', NULL),
(6, 'Burgund', 'FR', NULL),
(7, 'Carnuntum', 'AT', NULL),
(8, 'Asturien', 'ES', NULL),
(9, 'Murcia', 'ES', NULL),
(10, 'Veltlin', 'IT', NULL),
(11, 'Sizilien', 'IT', NULL),
(12, 'South Australia', 'AU', NULL),
(13, 'Südtirol', 'IT', NULL),
(14, 'Württemberg', 'DE', NULL),
(15, 'Rhône', 'FR', NULL),
(16, 'Leithaberg', 'AT', NULL),
(17, 'Friaul', 'IT', NULL),
(18, 'Ligurien', 'IT', NULL),
(19, 'Mendoza', 'AR', NULL),
(20, 'Traisental', 'AT', NULL),
(21, 'Piemont', 'IT', NULL),
(22, 'Kamptal', 'AT', NULL),
(23, 'Navarra', 'ES', NULL),
(24, 'Bordeaux', 'FR', NULL),
(25, 'Aargau', 'CH', NULL),
(26, 'Douro', 'PT', NULL),
(27, 'Victoria', 'AU', NULL),
(28, 'Beaujolais', 'FR', NULL),
(29, 'Loire', 'FR', NULL),
(30, 'Saale-Unstrut', 'DE', NULL),
(31, 'Savoyen', 'FR', NULL),
(32, 'Korsika', 'FR', NULL),
(33, 'Tessin', 'CH', NULL),
(34, 'Languedoc-Roussillon', 'FR', NULL),
(35, 'Rheinhessen', 'DE', NULL),
(36, 'Rheingau', 'DE', NULL),
(37, 'Western Australia', 'AU', NULL),
(38, 'Genf', 'CH', NULL),
(39, 'Hessische Bergstraße', 'DE', NULL),
(40, 'Sardinien', 'IT', NULL),
(41, 'Madrid', 'ES', NULL),
(42, 'Ahr', 'DE', NULL),
(43, 'Pfalz', 'DE', NULL),
(44, 'Bündner Herrschaft', 'CH', NULL),
(45, 'Neusiedlersee-Hügelland', 'AT', NULL),
(46, 'Mosel', 'DE', NULL),
(47, 'Provence', 'FR', NULL),
(48, 'Extremadura', 'ES', NULL),
(49, 'Katalonien', 'ES', NULL),
(50, 'La Rioja', 'ES', NULL),
(51, 'Franken', 'DE', NULL),
(52, 'Wallis', 'CH', NULL),
(53, 'Steiermark', 'AT', NULL),
(54, 'Schaffhausen', 'CH', NULL),
(55, 'Trentino', 'IT', NULL),
(56, 'Thermenregion', 'AT', NULL),
(57, 'Apulien', 'IT', NULL),
(58, 'Campania', 'IT', NULL),
(59, 'New South Wales', 'AU', NULL),
(60, 'Galicien', 'ES', NULL),
(61, 'Jura', 'FR', NULL),
(62, 'Andalusien', 'ES', NULL),
(63, 'Mittelburgenland', 'AT', NULL),
(64, 'Wagram', 'AT', NULL),
(65, 'Baden', 'DE', NULL),
(66, 'Marken', 'IT', NULL),
(67, 'Baskenland', 'ES', NULL),
(68, 'Neusiedler See', 'AT', NULL),
(69, 'Waadt', 'CH', NULL),
(70, 'Kantabrien', 'ES', NULL),
(71, 'Aostatal', 'IT', NULL),
(72, 'Drei-Seen-Land', 'CH', NULL),
(73, 'Latium', 'IT', NULL),
(74, 'Kalbrien', 'IT', NULL),
(75, 'Puschlav', 'CH', NULL),
(76, 'Lombardei', 'IT', NULL),
(77, 'Thunersee', 'CH', NULL),
(78, 'Emilia-Romagna', 'IT', NULL),
(79, 'Kastilien-León', 'ES', NULL),
(80, 'Zürich', 'CH', NULL),
(81, 'Mittelrhein', 'DE', NULL),
(82, 'Kastilien-La Mancha', 'ES', NULL),
(83, 'Abruzzen', 'IT', NULL),
(84, 'Südburgenland', 'AT', NULL),
(85, 'Umbrien', 'IT', NULL),
(86, 'Elsass', 'FR', NULL),
(87, 'Basilikata', 'IT', NULL),
(88, 'Balearen', 'ES', NULL),
(89, 'Kampanien', 'IT', NULL),
(90, 'Kanarische Inseln', 'ES', NULL),
(91, 'Weinviertel', 'AT', NULL),
(92, 'Nahe', 'DE', NULL),
(93, 'Wien', 'AT', NULL),
(94, 'Wachau', 'AT', NULL),
(95, 'Sachsen', 'DE', NULL),
(96, 'Toskana', 'IT', NULL),
(97, 'Eisenberg', 'AT', NULL),
(98, 'Molise', 'IT', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vintage`
--

CREATE TABLE `vintage` (
  `vintage_id` bigint(20) NOT NULL,
  `vintage_alcohol` double DEFAULT NULL,
  `vintage_drink_from` int(11) DEFAULT NULL,
  `vintage_drink_to` int(11) DEFAULT NULL,
  `vintage_size` double DEFAULT NULL,
  `vintage_year` int(11) DEFAULT NULL,
  `vintage_wine` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `wine`
--

CREATE TABLE `wine` (
  `wine_id` bigint(20) NOT NULL,
  `wine_name` varchar(100) DEFAULT NULL,
  `wine_classification` varchar(40) DEFAULT NULL,
  `wine_country` varchar(2) DEFAULT NULL,
  `wine_producer` bigint(20) DEFAULT NULL,
  `wine_region` bigint(20) DEFAULT NULL,
  `wine_type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wine`
--

INSERT INTO `wine` (`wine_id`, `wine_name`, `wine_classification`, `wine_country`, `wine_producer`, `wine_region`, `wine_type`) VALUES
(1, 'Barolo', 'DOC', 'IT', 1, 18, 'RED'),
(2, 'Langhe Nebbiolo', 'DOC', 'IT', 1, 18, 'RED');

-- --------------------------------------------------------

--
-- Table structure for table `wine_classification`
--

CREATE TABLE `wine_classification` (
  `classification_code` varchar(40) NOT NULL,
  `classification_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wine_classification`
--

INSERT INTO `wine_classification` (`classification_code`, `classification_name`) VALUES
('1er grand cru classé', '1er Grand Cru Classé'),
('2ème grand cru classé', '2ème Grand Cru Classé'),
('AOC', 'Appellation d\'Origine Contrôlée'),
('DOC', 'Denominazione di origine controllata'),
('DOCG', 'Denominazione di origine controllata e garantita'),
('DOP', 'Denominazione d\'Origine Protetta'),
('IGT', 'Indicazione Geografica Tipica'),
('VdT', 'Vino da Tavola');

-- --------------------------------------------------------

--
-- Table structure for table `wine_type`
--

CREATE TABLE `wine_type` (
  `type_code` varchar(20) NOT NULL,
  `type_name` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wine_type`
--

INSERT INTO `wine_type` (`type_code`, `type_name`) VALUES
('RED', 'Rotwein'),
('ROSE', 'Roséwein'),
('SPARKLING_ROSE', 'Schaumwein rosé'),
('SPARKLING_WHITE', 'Schaumwein weiss'),
('SWEET_RED', 'Süsswein rot'),
('SWEET_WHITE', 'Süsswein rot'),
('WHITE', 'Weisswein');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`country_code`);

--
-- Indexes for table `producer`
--
ALTER TABLE `producer`
  ADD PRIMARY KEY (`producer_id`),
  ADD KEY `FK_producer_producer_country` (`producer_country`),
  ADD KEY `FK_producer_producer_region` (`producer_region`);

--
-- Indexes for table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`region_id`),
  ADD KEY `FK_region_country_regions` (`country_regions`),
  ADD KEY `FK_region_country` (`country`);

--
-- Indexes for table `vintage`
--
ALTER TABLE `vintage`
  ADD PRIMARY KEY (`vintage_id`),
  ADD KEY `FK_vintage_vintage_wine` (`vintage_wine`);

--
-- Indexes for table `wine`
--
ALTER TABLE `wine`
  ADD PRIMARY KEY (`wine_id`),
  ADD KEY `FK_wine_wine_type` (`wine_type`),
  ADD KEY `FK_wine_wine_region` (`wine_region`),
  ADD KEY `FK_wine_wine_country` (`wine_country`),
  ADD KEY `FK_wine_wine_classification` (`wine_classification`),
  ADD KEY `FK_wine_wine_producer` (`wine_producer`);

--
-- Indexes for table `wine_classification`
--
ALTER TABLE `wine_classification`
  ADD PRIMARY KEY (`classification_code`);

--
-- Indexes for table `wine_type`
--
ALTER TABLE `wine_type`
  ADD PRIMARY KEY (`type_code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `producer`
--
ALTER TABLE `producer`
  MODIFY `producer_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `region`
--
ALTER TABLE `region`
  MODIFY `region_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99;
--
-- AUTO_INCREMENT for table `vintage`
--
ALTER TABLE `vintage`
  MODIFY `vintage_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `wine`
--
ALTER TABLE `wine`
  MODIFY `wine_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `producer`
--
ALTER TABLE `producer`
  ADD CONSTRAINT `FK_producer_producer_country` FOREIGN KEY (`producer_country`) REFERENCES `country` (`country_code`),
  ADD CONSTRAINT `FK_producer_producer_region` FOREIGN KEY (`producer_region`) REFERENCES `region` (`region_id`);

--
-- Constraints for table `region`
--
ALTER TABLE `region`
  ADD CONSTRAINT `FK_region_country` FOREIGN KEY (`country`) REFERENCES `country` (`country_code`),
  ADD CONSTRAINT `FK_region_country_regions` FOREIGN KEY (`country_regions`) REFERENCES `country` (`country_code`);

--
-- Constraints for table `vintage`
--
ALTER TABLE `vintage`
  ADD CONSTRAINT `FK_vintage_vintage_wine` FOREIGN KEY (`vintage_wine`) REFERENCES `wine` (`wine_id`);

--
-- Constraints for table `wine`
--
ALTER TABLE `wine`
  ADD CONSTRAINT `FK_wine_wine_classification` FOREIGN KEY (`wine_classification`) REFERENCES `wine_classification` (`classification_code`),
  ADD CONSTRAINT `FK_wine_wine_country` FOREIGN KEY (`wine_country`) REFERENCES `country` (`country_code`),
  ADD CONSTRAINT `FK_wine_wine_producer` FOREIGN KEY (`wine_producer`) REFERENCES `producer` (`producer_id`),
  ADD CONSTRAINT `FK_wine_wine_region` FOREIGN KEY (`wine_region`) REFERENCES `region` (`region_id`),
  ADD CONSTRAINT `FK_wine_wine_type` FOREIGN KEY (`wine_type`) REFERENCES `wine_type` (`type_code`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
