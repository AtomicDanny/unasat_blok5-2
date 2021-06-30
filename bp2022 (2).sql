-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2021 at 01:08 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bp2022`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `country_of_origin` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`id`, `name`, `country_of_origin`) VALUES
(1, 'Toyota', 'Japan'),
(2, 'Nissan', 'Japan'),
(3, 'VW', 'Germany'),
(4, 'Mercedes-Benz', 'Germany'),
(5, 'Audi', 'Germany'),
(6, 'Chevrolet', 'USA'),
(7, 'Ford', 'USA'),
(8, 'Honda', 'Japan');

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `id` int(11) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `classification_id` int(11) NOT NULL,
  `model` varchar(255) NOT NULL,
  `bouwjaar` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`id`, `brand_id`, `classification_id`, `model`, `bouwjaar`, `price`) VALUES
(1, 1, 6, 'Ractis', 2007, 100),
(2, 3, 8, 'Amarok', 2012, 500),
(4, 1, 1, 'prado', 2020, 650),
(5, 4, 4, 'CLS', 2020, 1200),
(6, 2, 2, 'string', 2000, 375);

-- --------------------------------------------------------

--
-- Table structure for table `classification`
--

CREATE TABLE `classification` (
  `id` int(11) NOT NULL,
  `class` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `classification`
--

INSERT INTO `classification` (`id`, `class`) VALUES
(1, 'SUV'),
(2, 'Luxury'),
(3, 'Sportscar'),
(4, 'Sedan'),
(5, 'Coup'),
(6, 'Hatchback'),
(7, 'Truck'),
(8, 'Pick-up Truck'),
(9, 'Mini-van'),
(10, 'Convertible');

-- --------------------------------------------------------

--
-- Table structure for table `decorator`
--

CREATE TABLE `decorator` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `decorator`
--

INSERT INTO `decorator` (`id`, `name`, `price`) VALUES
(1, 'insurance', 300),
(2, 'paraphernalia', 50),
(3, 'Volle tank', 100);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(17),
(17),
(17),
(17),
(17),
(17);

-- --------------------------------------------------------

--
-- Table structure for table `klanten`
--

CREATE TABLE `klanten` (
  `id` int(11) NOT NULL,
  `naam` varchar(255) NOT NULL,
  `geslacht` varchar(255) NOT NULL,
  `tel_nummer` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `klanten`
--

INSERT INTO `klanten` (`id`, `naam`, `geslacht`, `tel_nummer`, `email`) VALUES
(1, 'Jason Bourne', 'Male', '456833', 'jbourne@hotmail.com'),
(2, 'James Bond', 'Male', '007', 'jbond@gmail.com'),
(3, 'Bella Poarch', 'Female', '6969', 'bellapoarch@gmail.com'),
(4, 'Kenson Latchmansing', 'Male', '09483290', 'x3mb6bies@gmail.com'),
(5, 'john doe ', 'Male', '32423', 'danvalfang@gmail.com'),
(6, 'jane doe', 'Female', '304304', 'admin@gmail.com'),
(7, 'jesus christ', 'Male', '3204239482390', 'example@gmail.com'),
(13, 'David Beckham', 'Male', '2343043', 'beckham@best.com'),
(15, 'Clark Kent', 'Male', '8686868', 'clarkkent@dailyplanet.com');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `klant_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `car_id`, `klant_id`, `start_date`, `end_date`, `total`) VALUES
(6, 6, 15, '2021-05-22', '2021-05-23', 375),
(7, 5, 13, '2021-05-22', '2021-05-31', 10800);

-- --------------------------------------------------------

--
-- Table structure for table `register_decorator`
--

CREATE TABLE `register_decorator` (
  `register_decorator_id` int(11) NOT NULL,
  `register_id` int(11) NOT NULL,
  `decorator_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register_decorator`
--

INSERT INTO `register_decorator` (`register_decorator_id`, `register_id`, `decorator_id`) VALUES
(1, 6, 1),
(2, 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL,
  `userDepartment` varchar(255) DEFAULT NULL,
  `userEmail` varchar(255) NOT NULL,
  `userFirstName` varchar(255) DEFAULT NULL,
  `userLastName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  `userTitle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `userDepartment`, `userEmail`, `userFirstName`, `userLastName`, `userPassword`, `userTitle`) VALUES
(1, NULL, 'd.fang@gmail.com', 'Danny', 'Fang', '1234', NULL),
(2, NULL, 'mnarain@unasat.sr', 'Maarten', 'Narain', '1234', NULL),
(3, NULL, 'harry@hogwarts.com', 'James', 'Potter', '1234', NULL),
(4, NULL, 'potter@try.com', 'JAMES', 'POTTER', '1234', NULL),
(5, NULL, 'james@bond.com', 'james', 'bond', '1234', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `userprivilege`
--

CREATE TABLE `userprivilege` (
  `userPrivilegeId` bigint(20) NOT NULL,
  `userRole` varchar(255) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userprivilege`
--

INSERT INTO `userprivilege` (`userPrivilegeId`, `userRole`, `userId`) VALUES
(1, 'Superadmin', 1),
(2, 'admin', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`id`),
  ADD KEY `brand_id` (`brand_id`),
  ADD KEY `classification_id` (`classification_id`);

--
-- Indexes for table `classification`
--
ALTER TABLE `classification`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `decorator`
--
ALTER TABLE `decorator`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `klanten`
--
ALTER TABLE `klanten`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`),
  ADD KEY `car_id` (`car_id`),
  ADD KEY `klant_id` (`klant_id`);

--
-- Indexes for table `register_decorator`
--
ALTER TABLE `register_decorator`
  ADD PRIMARY KEY (`register_decorator_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `UK_p4yevdj0vncgm8qtapdj1lyq3` (`userEmail`);

--
-- Indexes for table `userprivilege`
--
ALTER TABLE `userprivilege`
  ADD PRIMARY KEY (`userPrivilegeId`),
  ADD KEY `FKtq5tlelt80y1v476oye60so93` (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `classification`
--
ALTER TABLE `classification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `decorator`
--
ALTER TABLE `decorator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `klanten`
--
ALTER TABLE `klanten`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `register_decorator`
--
ALTER TABLE `register_decorator`
  MODIFY `register_decorator_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `userprivilege`
--
ALTER TABLE `userprivilege`
  MODIFY `userPrivilegeId` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `car_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  ADD CONSTRAINT `car_ibfk_2` FOREIGN KEY (`classification_id`) REFERENCES `classification` (`id`);

--
-- Constraints for table `register`
--
ALTER TABLE `register`
  ADD CONSTRAINT `register_ibfk_1` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
  ADD CONSTRAINT `register_ibfk_2` FOREIGN KEY (`klant_id`) REFERENCES `klanten` (`id`);

--
-- Constraints for table `userprivilege`
--
ALTER TABLE `userprivilege`
  ADD CONSTRAINT `FKtq5tlelt80y1v476oye60so93` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
