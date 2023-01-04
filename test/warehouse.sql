-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 04, 2023 at 10:38 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `warehouse`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(3, 'Higiene Oral'),
(2, 'Detergente de limpeza'),
(4, 'Calçados'),
(5, 'Talho'),
(6, 'Cereais');

-- --------------------------------------------------------

--
-- Table structure for table `check_in`
--

DROP TABLE IF EXISTS `check_in`;
CREATE TABLE IF NOT EXISTS `check_in` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_id` int(11) NOT NULL,
  `driver_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `list_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `available_amount` double NOT NULL,
  `price` double NOT NULL,
  `expire_date` varchar(50) DEFAULT NULL,
  `prod_name` varchar(50) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `prod_id` (`prod_id`,`driver_id`,`user_id`),
  KEY `driver_id` (`driver_id`),
  KEY `user_id` (`user_id`),
  KEY `list_id` (`list_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `check_in`
--

INSERT INTO `check_in` (`id`, `prod_id`, `driver_id`, `user_id`, `list_id`, `amount`, `available_amount`, `price`, `expire_date`, `prod_name`, `created_at`, `updated_at`) VALUES
(5, 8, 1, 1, 1, 60, 60, 300, 'Fri Jan 06 07:00:00 CAT 2023', NULL, '2022-12-30 17:24:30', '2022-12-30 17:24:30'),
(6, 8, 1, 1, 1, 60, 60, 300, 'Fri Jan 06 07:00:00 CAT 2023', NULL, '2022-12-30 17:24:31', '2022-12-30 17:24:31'),
(7, 8, 1, 1, 1, 60, 60, 300, 'Fri Jan 06 07:00:00 CAT 2023', NULL, '2022-12-30 17:24:31', '2022-12-30 17:24:31'),
(8, 8, 1, 1, 1, 60, 60, 300, 'Fri Jan 06 07:00:00 CAT 2023', NULL, '2022-12-30 17:24:31', '2022-12-30 17:24:31'),
(9, 2, 1, 1, 1, 10, 10, 100, 'Fri Jan 06 07:00:00 CAT 2023', NULL, '2022-12-30 17:31:43', '2022-12-30 17:31:43');

-- --------------------------------------------------------

--
-- Table structure for table `check_in_list`
--

DROP TABLE IF EXISTS `check_in_list`;
CREATE TABLE IF NOT EXISTS `check_in_list` (
  `list_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`list_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `check_in_list`
--

INSERT INTO `check_in_list` (`list_id`, `created_at`, `updated_at`) VALUES
(1, '2022-12-30 17:21:35', '2022-12-30 17:21:35');

-- --------------------------------------------------------

--
-- Table structure for table `check_out`
--

DROP TABLE IF EXISTS `check_out`;
CREATE TABLE IF NOT EXISTS `check_out` (
  `id` int(11) NOT NULL,
  `prod_id` int(11) NOT NULL,
  `prod_name` varchar(50) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `driver_id` int(11) NOT NULL,
  `store_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `list_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `prod_id` (`prod_id`,`user_id`),
  KEY `user_id` (`user_id`),
  KEY `driver_id` (`driver_id`),
  KEY `store_id` (`store_id`),
  KEY `list_id` (`list_id`),
  KEY `list_id_2` (`list_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `check_out_list`
--

DROP TABLE IF EXISTS `check_out_list`;
CREATE TABLE IF NOT EXISTS `check_out_list` (
  `list_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`list_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
CREATE TABLE IF NOT EXISTS `driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_name` varchar(20) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `address` text,
  `contact` varchar(50) DEFAULT NULL,
  `car_cod` varchar(15) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `car_cod` (`car_cod`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`id`, `driver_name`, `last_name`, `address`, `contact`, `car_cod`, `created_at`, `updated_at`) VALUES
(1, 'João', 'Baciquete', 'bfskjdbfsdjfbjsdbdsbjdsf', '324324234', '23-3-122-MP', '2022-11-11 11:09:39', '2022-11-11 11:09:39'),
(2, 'Francisco', 'Cossa', 'wqeqwewqewq', '234324234', '32-32M3-MC', '2022-11-11 11:09:39', '2022-11-11 11:09:39');

-- --------------------------------------------------------

--
-- Table structure for table `historic`
--

DROP TABLE IF EXISTS `historic`;
CREATE TABLE IF NOT EXISTS `historic` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `details` varchar(50) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(30) NOT NULL,
  `amount` int(11) NOT NULL DEFAULT '0',
  `unity` varchar(20) NOT NULL,
  `damaged` int(11) NOT NULL DEFAULT '0',
  `supplier_id` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`product_name`),
  KEY `supplier_id` (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `product_name`, `amount`, `unity`, `damaged`, `supplier_id`, `status`, `created_at`, `updated_at`) VALUES
(2, 'Mão De Vaca', 18, 'KG', 0, 1, 1, '2022-11-10 18:37:27', '2022-12-30 17:31:43'),
(6, 'Amendoim', 12, 'KG', 0, 1, 1, '2022-11-11 12:05:50', '2022-11-11 22:19:57'),
(7, 'Millho', 170, 'KG', 0, 5, 1, '2022-11-11 12:18:09', '2022-11-11 22:17:54'),
(8, 'Banana', 1600, 'Caixa', 0, 1, 1, '2022-11-30 06:42:55', '2022-12-30 17:24:31');

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
CREATE TABLE IF NOT EXISTS `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `store_name` varchar(20) NOT NULL,
  `address` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`store_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `store`
--

INSERT INTO `store` (`id`, `store_name`, `address`) VALUES
(1, 'Loja 1', 'Av. Samuel Magaia, 3214'),
(2, 'Loja 2', 'Av. Julius Nyerere, 8763'),
(3, 'Loja 3', 'Matola Gar, Rua Amilton Cabral, 9803'),
(4, 'Loja 4', 'MAtola Godinho, Rua 3, Nr 8402');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(20) NOT NULL,
  `country` varchar(50) NOT NULL,
  `address` text NOT NULL,
  `contact` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `country_cod` int(11) DEFAULT NULL,
  `nuit` int(11) DEFAULT NULL,
  `cep` varchar(30) DEFAULT NULL,
  `product_type` varchar(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`company`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `company`, `country`, `address`, `contact`, `email`, `country_cod`, `nuit`, `cep`, `product_type`, `created_at`, `updated_at`) VALUES
(1, 'Coca Cola', 'Moçambique', 'Matola, Av de Moçambique', '87543543', 'thecocacolacompany.com', 1324, 32442556, '878978', '(C)Gelados', '2022-11-07 12:40:19', '2022-11-07 12:40:19'),
(2, 'Maq', 'África do Sul (RSA)', 'Johanesburg, 12th Street, 3645', '45346565', 'info@maq.com', 1232, 113213354, '35434345', '(A)Merceria', '2022-11-07 14:37:24', '2022-11-07 14:37:24'),
(3, 'So Klin', 'Moçambique', 'Matola, Av de Moçambique, 6734', '8776784', 'info@soklin.com', 1324, 346565654, '36633432', 'Outros', '2022-11-07 14:38:53', '2022-11-07 15:07:46'),
(5, 'Maeva', 'Moçambique', 'Matola Godinho, Rua Graça Machel', '2312321312', 'maeva@co.mz', 2131, 3213231, '3213231', '(A)Merceria', '2022-11-07 15:49:48', '2022-11-07 15:49:48'),
(6, 'The Best Hallal', 'África do Sul (RSA)', 'Johannesburg, Nelson Mandela Street', '231312', 'info@thebesthallal.com', 231232, 233312, '2131212', '(D)Talho', '2022-11-10 18:13:16', '2022-11-10 18:13:16'),
(7, 'PEP', 'África do Sul (RSA)', 'Nell Sprit, Govment Street, 2332', '432432423', 'info@pep.com', 2131232, 32423334, '322423423423', 'Outros', '2022-11-11 09:35:26', '2022-11-11 09:35:26'),
(8, 'game', 'Moçambique', 'malhangalene', '848915261', 'info@game', 258, 123456789, '1234', '(A)Merceria', '2022-11-12 10:47:01', '2022-11-12 10:47:01');

-- --------------------------------------------------------

--
-- Table structure for table `unity`
--

DROP TABLE IF EXISTS `unity`;
CREATE TABLE IF NOT EXISTS `unity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `bi` varchar(15) NOT NULL,
  `address` text NOT NULL,
  `contact` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `profile` varchar(20) NOT NULL DEFAULT 'OPERADOR',
  `password` varchar(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `last_name`, `bi`, `address`, `contact`, `username`, `profile`, `password`, `created_at`, `updated_at`, `status`) VALUES
(1, ' Some Name', ' Some last name', '1232132132c', ' Marracuene', ' 34563455', 'admin', 'ADMINISTRADOR', 'warehouse', '2022-10-31 21:32:59', '2022-11-05 20:39:33', 1),
(2, 'Armando Joaquim', 'Mbazima', '3455432c', 'Malhampsene, rua da liberdade', '23423432', 'mbazima', 'OPERADOR', 'warehouse', '2022-11-04 20:42:15', '2022-11-07 02:42:31', 1),
(3, 'André Fernando', 'Matsangaisaa', '234323', 'Tete,  Distrito de Mothara, bairro xidenderhe, rua Florentino, casa 1321', '12321213213', 'matsanga', 'OPERADOR', 'warehouse', '2022-11-04 22:14:23', '2022-11-05 22:29:58', 0),
(4, 'Kennedy', 'Serafim', '324234223C', 'Mahotas 1, Rua do Mercado, 8980', '3122131232', '', 'OPERADOR', 'warehouse', '2022-11-05 18:57:08', '2022-11-05 23:24:26', 1),
(5, 'Simone Carvalho', 'Magalhães', '2343543244C', 'Maputo, Alto Maé,  Rua Fernando Magalhães, 2319', '4234234432', '', 'GESTOR', 'warehouse', '2022-11-05 23:10:54', '2022-11-12 10:56:09', 0),
(6, '', '', '', '', '', '', 'OPERADOR', 'warehouse', '2022-11-06 17:48:40', '2022-11-07 02:42:40', 0),
(7, 'Joao', 'Baciquete', '110233339393C', 'Bairro central', '857436143', 'Baciquete', 'OPERADOR', 'warehouse', '2022-11-12 09:21:21', '2022-11-12 09:21:21', 1),
(8, 'Marta Lino Macamo', 'Macamo', '455143143211g', 'Matola', '8489898668', 'martinha', 'GESTOR', 'warehouse', '2022-11-12 09:52:46', '2022-11-12 09:52:46', 1),
(9, 'Marta Macam', 'Macamo', '012200006363C', 'matola', '67677674', 'macamo', 'GESTOR', 'warehouse', '2022-11-12 10:41:29', '2022-11-12 10:41:29', 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `check_in`
--
ALTER TABLE `check_in`
  ADD CONSTRAINT `check_in_ibfk_1` FOREIGN KEY (`prod_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `check_in_ibfk_2` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `check_in_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `check_in_ibfk_4` FOREIGN KEY (`list_id`) REFERENCES `check_in_list` (`list_id`);

--
-- Constraints for table `check_out`
--
ALTER TABLE `check_out`
  ADD CONSTRAINT `check_out_ibfk_1` FOREIGN KEY (`prod_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `check_out_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `check_out_ibfk_4` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`),
  ADD CONSTRAINT `check_out_ibfk_5` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`id`),
  ADD CONSTRAINT `check_out_ibfk_6` FOREIGN KEY (`list_id`) REFERENCES `check_out_list` (`list_id`);

--
-- Constraints for table `historic`
--
ALTER TABLE `historic`
  ADD CONSTRAINT `historic_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
