-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30 Apr 2017 pada 13.28
-- Versi Server: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_sapipotong`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `keb_nutrisi_sapi`
--

CREATE TABLE IF NOT EXISTS `keb_nutrisi_sapi` (
  `uuid_keb_nutrisi_sapi` varchar(255) NOT NULL,
  `jenis_sapi` varchar(20) NOT NULL,
  `berat_badan` int(11) NOT NULL,
  `pbbh` double NOT NULL,
  `bk` float NOT NULL,
  `pk` float NOT NULL,
  `tdn` float NOT NULL,
  `ca` float NOT NULL,
  `p` float NOT NULL,
  `kemampuan_konsumsi` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `keb_nutrisi_sapi`
--

INSERT INTO `keb_nutrisi_sapi` (`uuid_keb_nutrisi_sapi`, `jenis_sapi`, `berat_badan`, `pbbh`, `bk`, `pk`, `tdn`, `ca`, `p`, `kemampuan_konsumsi`) VALUES
('07a5d0fe-1a1c-11e7-bd96-10c37b1febde', 'Sapi Jantan', 400, 0, 6.2, 478, 2.9, 13, 13, 2.6),
('1bbf4d81-0f81-11e7-acab-10c37b1febde', 'Sapi Dara', 200, 0, 4, 157, 6.5, 6, 6, 2),
('1bcc35d5-0f81-11e7-acab-10c37b1febde', 'Sapi Dara', 200, 0.25, 4.9, 302, 8.3, 10, 10, 4),
('1bd801b2-0f81-11e7-acab-10c37b1febde', 'Sapi Dara', 200, 0.5, 5.6, 358, 10.2, 14, 13, 4),
('1bdd26f5-0f81-11e7-acab-10c37b1febde', 'Sapi Dara', 200, 0.75, 5.5, 415, 12.1, 19, 16, 4),
('1bebe49d-0f81-11e7-acab-10c37b1febde', 'Sapi Dara', 200, 1, 5.6, 472, 13.9, 23, 18, 4),
('23ea317a-c551-11e6-acd1-10c37b1febde', 'Sapi Jantan', 150, 0, 3, 231, 1.4, 6, 6, 2),
('27911512-24fd-11e7-9781-10c37b1febde', 'Sapi Jantan', 450, 1.1, 10.2, 975, 7.2, 30, 27, 2.4),
('279bcb43-24fd-11e7-9781-10c37b1febde', 'Sapi Jantan', 450, 1.2, 10.2, 998, 7.6, 31, 28, 2.4),
('27a493fe-24fd-11e7-9781-10c37b1febde', 'Sapi Jantan', 450, 1.3, 10.2, 1018, 7.9, 32, 29, 2.4),
('3568498b-0ebb-11e7-97d6-10c37b1febde', 'Sapi Dara', 100, 0.25, 2.9, 206, 4.9, 13, 10, 3.5),
('697e5ca5-c8c7-11e6-89b2-c454448293a1', 'Sapi Jantan', 200, 0.25, 4.5, 470, 2.2, 11, 9, 4),
('698c775d-c8c7-11e6-89b2-c454448293a1', 'Sapi Jantan', 200, 0.5, 5.2, 554, 2.8, 16, 12, 4),
('699efdd0-c8c7-11e6-89b2-c454448293a1', 'Sapi Jantan', 200, 0.75, 5.4, 622, 3.2, 21, 15, 4),
('69a8fd8f-c8c7-11e6-89b2-c454448293a1', 'Sapi Jantan', 200, 1, 5.6, 690, 3.7, 27, 17, 4),
('69b9eb8c-c8c7-11e6-89b2-c454448293a1', 'Sapi Jantan', 250, 0, 4.4, 337, 2, 9, 9, 1.8),
('69c0c58e-c8c7-11e6-89b2-c454448293a1', 'Sapi Jantan', 250, 0.25, 5.3, 534, 2.6, 12, 10, 3.5),
('69cadd10-c8c7-11e6-89b2-c454448293a1', 'Sapi Jantan', 250, 0.5, 6.2, 623, 3.2, 16, 14, 3.5),
('69d1b8ed-c8c7-11e6-89b2-c454448293a1', 'Sapi Jantan', 250, 0.75, 6.4, 693, 3.8, 21, 17, 3.5),
('69d860c2-c8c7-11e6-89b2-c454448293a1', 'Sapi Jantan', 250, 1, 6.6, 760, 4.3, 28, 19, 3.5),
('6e6d449f-24fc-11e7-9781-10c37b1febde', 'Sapi Jantan', 450, 1, 10.2, 952, 6.8, 29, 26, 2.4),
('71192d20-c8c6-11e6-89b2-c454448293a1', 'Sapi Jantan', 200, 0, 3.7, 285, 1.8, 6, 6, 2),
('7325d641-1a1d-11e7-bd96-10c37b1febde', 'Sapi Jantan', 400, 0.75, 9.1, 875, 5.4, 26, 12, 2.6),
('732ee646-1a1d-11e7-bd96-10c37b1febde', 'Sapi Jantan', 400, 1, 9.3, 913, 6.2, 31, 24, 2.6),
('7331cfd3-1a1d-11e7-bd96-10c37b1febde', 'Sapi Jantan', 400, 1.1, 9.4, 942, 6.6, 32, 25, 2.6),
('733b31b5-1a1d-11e7-bd96-10c37b1febde', 'Sapi Jantan', 400, 1.2, 9.4, 967, 7, 33, 25, 2.6),
('73488b47-1a1d-11e7-bd96-10c37b1febde', 'Sapi Jantan', 400, 1.3, 9.4, 988, 7.2, 33, 26, 2.6),
('73558821-1a1d-11e7-bd96-10c37b1febde', 'Sapi Jantan', 450, 0, 6.8, 528, 3.2, 14, 14, 2.4),
('73636c78-1a1d-11e7-bd96-10c37b1febde', 'Sapi Jantan', 450, 0.75, 10, 911, 5.9, 26, 23, 2.4),
('7ac6977a-0f7e-11e7-acab-10c37b1febde', 'Sapi Dara', 150, 0, 3.3, 127, 5.3, 5, 5, 2),
('84880049-250c-11e7-9781-10c37b1febde', 'Sapi Menyusui', 300, 0, 7.3, 686, 4.2, 23, 23, 2.4),
('84918ed3-250c-11e7-9781-10c37b1febde', 'Sapi Menyusui', 350, 0, 8.1, 721, 4.5, 24, 24, 2.3),
('8499908b-250c-11e7-9781-10c37b1febde', 'Sapi Menyusui', 400, 0, 8.9, 757, 4.8, 25, 25, 2.1),
('84a66fb3-250c-11e7-9781-10c37b1febde', 'Sapi Menyusui', 450, 0, 9.6, 793, 5.1, 26, 26, 2.1),
('86c839e3-088d-11e7-b6b0-10c37b1febde', 'Sapi Jantan', 350, 1.100000023841858, 8.5, 899, 5.9, 21, 23, 2.8),
('97020975610068992', 'Sapi Jantan', 300, 0, 5, 385, 2.4, 10, 10, 1.7),
('97020975610068993', 'Sapi Jantan', 300, 0.25, 6, 588, 3, 15, 11, 3),
('97020975610068994', 'Sapi Jantan', 300, 0.5, 7, 679, 3.7, 19, 14, 3),
('97020975610068995', 'Sapi Jantan', 300, 0.75, 7.4, 753, 4.3, 23, 18, 3),
('97020975610068996', 'Sapi Jantan', 300, 1, 7.5, 819, 5, 28, 21, 3),
('97020975610068997', 'Sapi Jantan', 350, 0, 5.7, 432, 2.6, 12, 12, 1.65),
('97020975610068998', 'Sapi Jantan', 350, 0.25, 6.8, 635, 3.3, 16, 14, 2.8),
('97020975610068999', 'Sapi Jantan', 350, 0.5, 7.9, 731, 4.1, 20, 16, 2.8),
('97020975610069000', 'Sapi Jantan', 350, 0.75, 8.3, 806, 4.8, 25, 18, 2.8),
('97020975610069001', 'Sapi Jantan', 350, 1, 8.5, 874, 5.6, 30, 21, 2.8),
('9d405f02-0f83-11e7-acab-10c37b1febde', 'Sapi Dara', 250, 0, 4.8, 185, 7.6, 7, 7, 3.5),
('9d4b9e25-0f83-11e7-acab-10c37b1febde', 'Sapi Dara', 250, 0.25, 5.8, 340, 9.8, 12, 12, 3.5),
('9d4e9a78-0f83-11e7-acab-10c37b1febde', 'Sapi Dara', 250, 0.5, 6.2, 395, 12, 13, 13, 3.5),
('9d59326e-0f83-11e7-acab-10c37b1febde', 'Sapi Dara', 250, 0.75, 6.5, 451, 14.2, 18, 15, 3.5),
('9d61abf8-0f83-11e7-acab-10c37b1febde', 'Sapi Dara', 250, 1, 6.6, 507, 16.3, 23, 18, 3.5),
('9d6ed04c-0f83-11e7-acab-10c37b1febde', 'Sapi Dara', 300, 0, 5.5, 212, 8.8, 9, 9, 3),
('9d81a61f-0f83-11e7-acab-10c37b1febde', 'Sapi Dara', 300, 0.25, 6.7, 368, 11.2, 13, 13, 3),
('9d8f17f0-0f83-11e7-acab-10c37b1febde', 'Sapi Dara', 300, 0.5, 7.1, 423, 13.8, 14, 14, 3),
('9d9637a6-0f83-11e7-acab-10c37b1febde', 'Sapi Dara', 300, 0.75, 7.4, 502, 16.3, 17, 15, 3),
('9d9cff11-0f83-11e7-acab-10c37b1febde', 'Sapi Dara', 300, 1, 7.6, 535, 18.8, 21, 18, 3),
('a1f9a8a0-0f7f-11e7-acab-10c37b1febde', 'Sapi Dara', 150, 0.25, 4, 258, 6.8, 13, 11, 3.5),
('a20559e9-0f7f-11e7-acab-10c37b1febde', 'Sapi Dara', 150, 0.5, 4.2, 315, 8.3, 14, 11, 3.5),
('a210b8ea-0f7f-11e7-acab-10c37b1febde', 'Sapi Dara', 150, 0.75, 4.4, 368, 9.8, 19, 15, 3.5),
('a225c07d-0f7f-11e7-acab-10c37b1febde', 'Sapi Dara', 150, 1, 4.5, 428, 11.3, 25, 18, 3.5),
('a23a02cb-0ebb-11e7-97d6-10c37b1febde', 'Sapi Dara', 100, 0.5, 3.1, 262, 6, 14, 11, 3.5),
('a24b148e-0ebb-11e7-97d6-10c37b1febde', 'Sapi Dara', 100, 0.75, 3.2, 319, 7.1, 20, 14, 3.5),
('a256e19e-0ebb-11e7-97d6-10c37b1febde', 'Sapi Dara', 100, 1, 3.3, 375, 8.2, 26, 18, 3.5),
('a38d9e0a-c551-11e6-acd1-10c37b1febde', 'Sapi Jantan', 150, 0.25, 3.8, 400, 1.8, 12, 9, 3.5),
('a38da429-c551-11e6-acd1-10c37b1febde', 'Sapi Jantan', 150, 0.5, 4.2, 474, 2.2, 16, 10, 3.5),
('a38da498-c551-11e6-acd1-10c37b1febde', 'Sapi Jantan', 150, 0.75, 4.4, 589, 2.6, 21, 13, 3.5),
('a38da4ee-c551-11e6-acd1-10c37b1febde', 'Sapi Jantan', 150, 1, 4.5, 607, 3, 27, 16, 3.5),
('cbb0f2c4-0eb8-11e7-80a6-10c37b1febde', 'Sapi Dara', 100, 0, 2.4, 93, 3.8, 4, 4, 2.5),
('d2af036d-27e8-11e7-9430-10c37b1febde', 'Sapi Menyusui', 250, 0, 6.4, 650, 3.8, 22, 22, 2.6);

-- --------------------------------------------------------

--
-- Struktur dari tabel `komposisi_bpakan`
--

CREATE TABLE IF NOT EXISTS `komposisi_bpakan` (
`uuid_pakan` int(11) NOT NULL,
  `bahan_pakan` varchar(25) NOT NULL,
  `harga` int(11) NOT NULL,
  `berat_kering` double NOT NULL,
  `protein_kering` double NOT NULL,
  `tot_digestible_nut` double NOT NULL,
  `calsium` double NOT NULL,
  `fosfor` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `komposisi_bpakan`
--

INSERT INTO `komposisi_bpakan` (`uuid_pakan`, `bahan_pakan`, `harga`, `berat_kering`, `protein_kering`, `tot_digestible_nut`, `calsium`, `fosfor`) VALUES
(1, 'Rumput Gajah', 1000, 21, 8.3, 50, 0.59, 0.29),
(2, 'Jerami (J) Padi Segar', 5000, 40, 4.3, 40, 0, 0),
(3, 'J. Jagung Bag.Atas Segar', 3500, 28, 8.2, 57, 0.54, 0.11),
(4, 'Rumput Benggala', 3000, 27, 7.7, 50, 0.52, 0.22),
(5, 'Rumput Ilalang', 5000, 40, 5.4, 54, 0.13, 0.09),
(6, 'Dedak Halus Padi', 3500, 86, 12.5, 70, 0.06, 1.55),
(7, 'Dedak Jagung', 4000, 86, 11.3, 52, 0.06, 0.77),
(8, 'Dedak Gandum', 4500, 86, 15, 70, 0.15, 1.23),
(9, 'Jagung Kuning', 6000, 86, 10.3, 80, 0.02, 0.33),
(10, 'Daun Ketela Pohon Segar', 5000, 26, 20, 71, 0.99, 0.56),
(11, 'Daun Gliricida Segar', 4000, 27, 19.1, 65, 0.67, 0.19),
(12, 'Rendeng Segar', 3000, 35, 15.1, 65, 1.51, 0.2),
(13, 'Rendeng Kering', 2500, 86, 14.7, 54, 1.5, 0.2),
(14, 'Lamtoro Segar', 6000, 30, 23.4, 77, 2.06, 0.21),
(15, 'J. Padi Kering', 6000, 86, 3.7, 39, 0, 0),
(16, 'Geplek', 2500, 86, 1.7, 69, 0.1, 0.04),
(17, 'Onggok', 2000, 86, 2.2, 65, 0.68, 0.05),
(18, 'Cantel', 7000, 86, 11.2, 80, 0.19, 0.2),
(19, 'Tetes', 2500, 86, 4.2, 53, 0.71, 0.07),
(20, 'Bungkil Kedelai', 5500, 86, 45, 78, 0.2, 0.74),
(21, 'Bungkil Kacang', 3500, 86, 49.5, 65, 0.11, 0.74),
(22, 'Bungkil Kelapa', 3000, 86, 21.6, 66, 0.47, 0.97),
(23, 'Bungkil Kapok', 2000, 86, 31.7, 74, 0.22, 1.34),
(24, 'Bungkil Kapas', 3000, 86, 44.2, 66, 0.31, 0.85),
(25, 'Bungkil Kelapa Sawit', 2000, 86, 20.4, 81, 0.31, 0.85),
(26, 'Lamtoro Kering', 2500, 86, 23.7, 71, 1.4, 0.21);

-- --------------------------------------------------------

--
-- Struktur dari tabel `training`
--

CREATE TABLE IF NOT EXISTS `training` (
`no` int(5) NOT NULL,
  `usia` int(3) NOT NULL,
  `kelamin` int(1) NOT NULL,
  `cp` int(1) NOT NULL,
  `tekanan` int(3) NOT NULL,
  `ecg` int(3) NOT NULL,
  `maxrate` int(3) NOT NULL,
  `exang` int(2) NOT NULL,
  `oldpeak` float NOT NULL,
  `slope` int(2) NOT NULL,
  `kelas` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `training`
--

INSERT INTO `training` (`no`, `usia`, `kelamin`, `cp`, `tekanan`, `ecg`, `maxrate`, `exang`, `oldpeak`, `slope`, `kelas`) VALUES
(4, 65, 1, 4, 115, 0, 93, 1, 0, 2, 1),
(5, 32, 1, 1, 95, 0, 127, 0, 0.7, 1, 1),
(6, 61, 1, 4, 105, 0, 110, 1, 1.5, 1, 1),
(7, 50, 1, 4, 145, 0, 139, 1, 0.7, 2, 1),
(8, 57, 1, 4, 110, 1, 131, 1, 1.4, 1, 1),
(9, 51, 1, 4, 110, 0, 92, 0, 0, 2, 1),
(10, 47, 1, 4, 110, 1, 149, 0, 2.1, 1, 1),
(11, 60, 1, 4, 160, 0, 149, 0, 0.4, 2, 1),
(12, 55, 1, 2, 140, 1, 150, 0, 0.2, 1, 0),
(13, 53, 0, 4, 125, 1, 120, 0, 1.5, 1, 1),
(14, 62, 1, 4, 120, 1, 123, 1, 1.7, 3, 1),
(15, 51, 0, 4, 95, 0, 126, 0, 2.2, 2, 1),
(16, 51, 1, 4, 120, 0, 127, 1, 1.5, 1, 1),
(17, 55, 1, 4, 115, 0, 155, 0, 0.1, 2, 1),
(18, 53, 1, 2, 130, 1, 120, 0, 0.7, 3, 0),
(19, 58, 1, 4, 115, 0, 138, 0, 0.5, 1, 1),
(20, 57, 1, 4, 95, 0, 182, 0, 0.7, 3, 1),
(21, 65, 1, 4, 155, 0, 154, 0, 1, 1, 0),
(22, 60, 1, 4, 125, 0, 110, 0, 0.1, 1, 1),
(23, 41, 1, 4, 125, 0, 176, 0, 1.6, 1, 1),
(24, 53, 1, 4, 80, 0, 141, 1, 2, 3, 0),
(25, 74, 1, 2, 145, 1, 123, 0, 1.3, 1, 1),
(26, 57, 1, 3, 105, 0, 148, 0, 0.3, 2, 1),
(27, 56, 1, 4, 140, 0, 121, 1, 1.8, 1, 1),
(28, 61, 1, 4, 130, 0, 77, 0, 2.5, 2, 1),
(29, 68, 1, 4, 145, 0, 136, 0, 1.8, 1, 1),
(30, 59, 1, 3, 125, 0, 175, 0, 2.6, 2, 1),
(31, 63, 0, 4, 100, 0, 109, 0, -0.9, 2, 1),
(32, 38, 1, 4, 105, 0, 166, 0, 2.8, 1, 1),
(33, 62, 1, 4, 115, 0, 128, 1, 2.5, 3, 1),
(34, 46, 1, 4, 100, 1, 133, 0, -2.6, 2, 1),
(35, 42, 1, 4, 105, 0, 128, 1, -1.5, 3, 1),
(36, 45, 1, 4, 110, 0, 138, 0, -0.1, 1, 0),
(37, 59, 1, 4, 125, 0, 119, 1, 0.9, 1, 1),
(38, 60, 1, 4, 130, 1, 130, 1, 1.1, 3, 1),
(39, 60, 1, 3, 115, 0, 143, 0, 2.4, 1, 1),
(40, 56, 1, 4, 115, 1, 82, 0, -1, 1, 1),
(41, 38, 1, 3, 100, 0, 179, 0, -1.1, 1, 0),
(42, 51, 1, 4, 130, 0, 170, 0, -0.7, 1, 1),
(43, 62, 1, 1, 120, 2, 134, 0, -0.8, 2, 1),
(44, 72, 1, 3, 160, 2, 114, 0, 1.6, 2, 0),
(45, 63, 1, 4, 150, 1, 154, 0, 3.7, 1, 1),
(46, 63, 0, 4, 140, 2, 149, 0, 2, 1, 1),
(47, 64, 1, 4, 95, 0, 145, 0, 1.1, 3, 1),
(48, 43, 1, 4, 100, 0, 122, 0, 1.5, 3, 1),
(49, 64, 1, 4, 110, 0, 114, 1, 1.3, 3, 1),
(50, 61, 1, 4, 110, 0, 113, 0, 1.4, 2, 1),
(51, 52, 1, 4, 130, 0, 120, 0, 0, 2, 1),
(52, 51, 1, 4, 120, 0, 104, 0, 0.2, 2, 1),
(53, 69, 1, 4, 135, 0, 130, 0, 0.2, 2, 1),
(54, 59, 1, 4, 120, 0, 115, 0, 0.2, 2, 1),
(55, 48, 1, 4, 115, 0, 128, 0, 0, 2, 1),
(56, 36, 1, 4, 110, 0, 125, 1, 1, 2, 1),
(57, 53, 1, 4, 120, 0, 120, 0, 0, 2, 1),
(58, 43, 1, 4, 140, 1, 140, 1, 0.5, 1, 1),
(59, 56, 1, 4, 120, 1, 100, 1, -1, 3, 1),
(60, 58, 1, 4, 130, 1, 100, 1, 1, 2, 1),
(61, 55, 1, 4, 120, 1, 92, 0, 0.3, 1, 1),
(62, 67, 1, 1, 145, 2, 125, 0, 0, 2, 1),
(63, 46, 1, 4, 115, 0, 113, 1, 1.5, 2, 1),
(64, 53, 1, 2, 120, 0, 95, 0, 0, 2, 1),
(65, 38, 1, 3, 115, 0, 128, 1, 0, 2, 1),
(66, 44, 1, 2, 120, 0, 173, 0, 0, 1, 0),
(67, 52, 1, 3, 172, 0, 162, 0, 0.5, 1, 0),
(68, 57, 1, 3, 150, 0, 174, 0, 1.6, 1, 0),
(69, 54, 1, 4, 140, 0, 160, 0, 1.2, 1, 0),
(70, 48, 0, 3, 130, 0, 139, 0, 0.2, 1, 0),
(71, 49, 1, 2, 130, 0, 171, 0, 0.6, 1, 0),
(72, 64, 1, 1, 110, 2, 144, 1, 1.8, 2, 0),
(73, 58, 0, 1, 150, 2, 162, 0, 1, 1, 0),
(74, 54, 1, 3, 150, 2, 165, 0, 1.6, 1, 0),
(75, 54, 0, 3, 135, 0, 170, 0, 0, 1, 0),
(76, 54, 1, 3, 125, 2, 152, 0, 0.5, 3, 0),
(77, 51, 1, 1, 125, 2, 125, 1, 1.4, 1, 0),
(78, 44, 1, 2, 130, 2, 188, 0, 0, 1, 0),
(79, 65, 1, 4, 120, 0, 140, 0, 0.4, 1, 0),
(80, 65, 0, 3, 140, 2, 157, 0, 0.8, 1, 0),
(81, 53, 1, 3, 130, 2, 152, 0, 1.2, 3, 0),
(82, 41, 0, 2, 105, 0, 168, 0, 0, 1, 0),
(83, 51, 1, 3, 110, 0, 123, 0, 0.6, 1, 0),
(84, 71, 0, 2, 160, 0, 162, 0, 0.4, 1, 0),
(85, 59, 1, 3, 150, 0, 157, 0, 1.6, 1, 0),
(86, 40, 1, 1, 140, 0, 178, 1, 1.4, 1, 0),
(87, 61, 1, 3, 150, 0, 137, 1, 1, 2, 0),
(88, 59, 1, 4, 135, 0, 161, 0, 0.5, 2, 0),
(89, 44, 1, 3, 130, 0, 179, 1, 0.4, 1, 0),
(90, 42, 1, 4, 140, 0, 178, 0, 0, 1, 0),
(91, 69, 0, 1, 140, 0, 151, 0, 1.8, 1, 0),
(92, 50, 0, 3, 120, 0, 158, 0, 1.6, 2, 0),
(93, 58, 0, 3, 120, 0, 172, 0, 0, 1, 0),
(94, 66, 0, 1, 150, 0, 114, 0, 2.6, 3, 0),
(95, 43, 1, 4, 150, 0, 171, 0, 1.5, 1, 0),
(96, 70, 1, 4, 115, 1, 92, 1, 0, 2, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `uuid_user` varchar(255) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `is_logged_in` smallint(6) NOT NULL,
  `is_active` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`uuid_user`, `username`, `password`, `firstname`, `lastname`, `is_logged_in`, `is_active`) VALUES
('02afb56b-c288-11e6-902d-c454448293a1', 'wiratamap', 'e10adc3949ba59abbe56e057f20f883e', 'Wiratama', 'Paramasatya', 1, 1),
('a1bd8f07-c2a6-11e6-ab7c-208984a880cf', 'azizul', '1074fd577b80993db3913ab5ca2aceca', 'Azizul', 'H H', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `keb_nutrisi_sapi`
--
ALTER TABLE `keb_nutrisi_sapi`
 ADD PRIMARY KEY (`uuid_keb_nutrisi_sapi`);

--
-- Indexes for table `komposisi_bpakan`
--
ALTER TABLE `komposisi_bpakan`
 ADD PRIMARY KEY (`uuid_pakan`), ADD UNIQUE KEY `uuid_pakan` (`uuid_pakan`);

--
-- Indexes for table `training`
--
ALTER TABLE `training`
 ADD PRIMARY KEY (`no`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`uuid_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `komposisi_bpakan`
--
ALTER TABLE `komposisi_bpakan`
MODIFY `uuid_pakan` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `training`
--
ALTER TABLE `training`
MODIFY `no` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=97;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
