-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 16, 2022 lúc 12:22 PM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlcanbo`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qlcongnhan`
--

CREATE TABLE `qlcongnhan` (
  `HovaTen` varchar(256) NOT NULL,
  `Tuoi` int(2) NOT NULL,
  `GioiTinh` varchar(4) NOT NULL,
  `DiaChi` varchar(256) NOT NULL,
  `Bac` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qlkysu`
--

CREATE TABLE `qlkysu` (
  `HovaTen` varchar(256) NOT NULL,
  `Tuoi` int(2) NOT NULL,
  `GioiTinh` varchar(4) NOT NULL,
  `DiaChi` varchar(256) NOT NULL,
  `NganhDaoTao` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `qlkysu`
--

INSERT INTO `qlkysu` (`HovaTen`, `Tuoi`, `GioiTinh`, `DiaChi`, `NganhDaoTao`) VALUES
('Hà', 30, 'Nữ', 'Số 89, Ngõ 88, Phố Giáp Nhị', 'IT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qlnhanvien`
--

CREATE TABLE `qlnhanvien` (
  `HovaTen` varchar(256) NOT NULL,
  `Tuoi` int(2) NOT NULL,
  `GioiTinh` varchar(4) NOT NULL,
  `DiaChi` varchar(256) NOT NULL,
  `CongViec` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `qlnhanvien`
--

INSERT INTO `qlnhanvien` (`HovaTen`, `Tuoi`, `GioiTinh`, `DiaChi`, `CongViec`) VALUES
('Trần Đức Việt', 30, 'Nam', 'Số 80, Phố Giáp Nhị, Thịnh Liệt', 'Nhân Viên');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `qlcongnhan`
--
ALTER TABLE `qlcongnhan`
  ADD PRIMARY KEY (`HovaTen`,`Tuoi`,`GioiTinh`,`DiaChi`);

--
-- Chỉ mục cho bảng `qlkysu`
--
ALTER TABLE `qlkysu`
  ADD PRIMARY KEY (`HovaTen`,`Tuoi`,`GioiTinh`,`DiaChi`);

--
-- Chỉ mục cho bảng `qlnhanvien`
--
ALTER TABLE `qlnhanvien`
  ADD PRIMARY KEY (`HovaTen`,`Tuoi`,`GioiTinh`,`DiaChi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
