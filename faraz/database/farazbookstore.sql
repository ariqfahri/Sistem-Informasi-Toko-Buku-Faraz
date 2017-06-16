-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2017 at 09:52 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `farazbookstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `password`) VALUES
('admin', 'rpl8');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id_buku` varchar(30) NOT NULL,
  `id_penerbit` varchar(5) NOT NULL,
  `tanggal_buku` date DEFAULT NULL,
  `judul_buku` varchar(30) DEFAULT NULL,
  `pengarang` varchar(30) DEFAULT NULL,
  `jumlah_buku` int(11) DEFAULT NULL,
  `jumlah_tersedia` int(11) DEFAULT NULL,
  `jumlah_dipinjam` int(11) DEFAULT NULL,
  `counter` int(11) DEFAULT NULL,
  `harga_pinjam` int(11) DEFAULT NULL,
  `harga_jual` int(11) DEFAULT NULL,
  `harga_baca` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id_buku`, `id_penerbit`, `tanggal_buku`, `judul_buku`, `pengarang`, `jumlah_buku`, `jumlah_tersedia`, `jumlah_dipinjam`, `counter`, `harga_pinjam`, `harga_jual`, `harga_baca`) VALUES
('123', 'fam', '2012-12-10', 'Berenang di Pulau Ikan', 'Siapa', 2, -3, 5, 6, 2000, 10000, 1000),
('456', 'fam', '2012-12-10', 'Ayam Bakar Goreng', 'Fadila Andre Mulyanto', 5, 1, 4, 4, 2000, 20000, 1500),
('890', 'fam', '2012-12-10', 'Gajah Tidur', 'Siapa', 2, 0, 2, 2, 2500, 25000, 2000);

-- --------------------------------------------------------

--
-- Table structure for table `jualbeli`
--

CREATE TABLE `jualbeli` (
  `id_jualbeli` int(11) NOT NULL,
  `tanggal_jualbeli` date DEFAULT NULL,
  `id_member` varchar(10) NOT NULL,
  `id_buku` varchar(30) NOT NULL,
  `harga_jual` int(11) NOT NULL,
  `kuantitas` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jualbeli`
--

INSERT INTO `jualbeli` (`id_jualbeli`, `tanggal_jualbeli`, `id_member`, `id_buku`, `harga_jual`, `kuantitas`, `total`) VALUES
(1, '2012-12-11', '002', '890', 25000, 1, 25000);

-- --------------------------------------------------------

--
-- Table structure for table `keuangan`
--

CREATE TABLE `keuangan` (
  `id_keuangan` int(11) NOT NULL,
  `tahun` int(11) DEFAULT NULL,
  `bulan` varchar(10) DEFAULT NULL,
  `pemasukan` int(11) DEFAULT NULL,
  `pengeluaran` int(11) DEFAULT NULL,
  `keuntungan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id_member` varchar(10) NOT NULL,
  `tanggal_member` date DEFAULT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `telepon` varchar(20) DEFAULT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id_member`, `tanggal_member`, `nama`, `alamat`, `telepon`, `email`) VALUES
('001', '2012-12-11', 'Fadila', 'Cibanteng', '0857', 'fadilaandre@gmail.com'),
('002', '2012-12-11', 'Andre', 'Cibanteng', '175', 'andrefadila@gmail.com'),
('003', '2012-12-11', 'Mulyanto', 'Cibanteng', '98651', 'andrefadila@windowslive.com'),
('004', '2017-06-08', 'alfian', 'cibanteng', '09876', 'alfiianeryandika@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `penerbit`
--

CREATE TABLE `penerbit` (
  `id_penerbit` varchar(5) NOT NULL,
  `nama_penerbit` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penerbit`
--

INSERT INTO `penerbit` (`id_penerbit`, `nama_penerbit`) VALUES
('fam', 'Fadila Andre Mulyanto');

-- --------------------------------------------------------

--
-- Table structure for table `pinjam`
--

CREATE TABLE `pinjam` (
  `id_pinjam` int(11) NOT NULL,
  `id_member` varchar(10) NOT NULL,
  `id_buku` varchar(30) NOT NULL,
  `tanggal_pinjam` date DEFAULT NULL,
  `tanggal_kembali` date DEFAULT NULL,
  `tanggal_dikembalikan` date DEFAULT NULL,
  `harga_pinjam` int(11) NOT NULL,
  `denda` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pinjam`
--

INSERT INTO `pinjam` (`id_pinjam`, `id_member`, `id_buku`, `tanggal_pinjam`, `tanggal_kembali`, `tanggal_dikembalikan`, `harga_pinjam`, `denda`) VALUES
(1, '001', '456', '2012-12-11', '2012-12-13', '2012-12-13', 2000, 0),
(2, '001', '123', '2017-06-08', '2017-06-09', '2017-06-20', 2000, 0),
(4, '001', '123', '2017-06-15', '2017-06-17', NULL, 2000, 0),
(5, '001', '123', '2017-06-15', '2017-06-15', NULL, 1000, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`),
  ADD KEY `id_penerbit` (`id_penerbit`);

--
-- Indexes for table `jualbeli`
--
ALTER TABLE `jualbeli`
  ADD PRIMARY KEY (`id_jualbeli`,`id_member`,`id_buku`),
  ADD KEY `id_member` (`id_member`),
  ADD KEY `id_buku` (`id_buku`);

--
-- Indexes for table `keuangan`
--
ALTER TABLE `keuangan`
  ADD PRIMARY KEY (`id_keuangan`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id_member`);

--
-- Indexes for table `penerbit`
--
ALTER TABLE `penerbit`
  ADD PRIMARY KEY (`id_penerbit`);

--
-- Indexes for table `pinjam`
--
ALTER TABLE `pinjam`
  ADD PRIMARY KEY (`id_pinjam`,`id_member`,`id_buku`),
  ADD KEY `id_member` (`id_member`),
  ADD KEY `id_buku` (`id_buku`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jualbeli`
--
ALTER TABLE `jualbeli`
  MODIFY `id_jualbeli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `keuangan`
--
ALTER TABLE `keuangan`
  MODIFY `id_keuangan` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pinjam`
--
ALTER TABLE `pinjam`
  MODIFY `id_pinjam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `buku`
--
ALTER TABLE `buku`
  ADD CONSTRAINT `buku_ibfk_1` FOREIGN KEY (`id_penerbit`) REFERENCES `penerbit` (`id_penerbit`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `jualbeli`
--
ALTER TABLE `jualbeli`
  ADD CONSTRAINT `jualbeli_ibfk_2` FOREIGN KEY (`id_member`) REFERENCES `member` (`id_member`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `jualbeli_ibfk_3` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pinjam`
--
ALTER TABLE `pinjam`
  ADD CONSTRAINT `pinjam_ibfk_2` FOREIGN KEY (`id_member`) REFERENCES `member` (`id_member`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pinjam_ibfk_3` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
