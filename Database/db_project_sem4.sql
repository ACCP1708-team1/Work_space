-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 09, 2019 lúc 01:17 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `db_project_sem4`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `about_us`
--

CREATE TABLE `about_us` (
  `id` int(11) NOT NULL,
  `title` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `about_us`
--

INSERT INTO `about_us` (`id`, `title`, `description`, `status`, `create_date`) VALUES
(1, 'A - TEAM', 'A-Team professional decorators and property refurbishers\r\nWhites Decorating & Refurbishment is a family owned business and enjoys a tremendous reputation, doing work exactly the way you need it. We pride ourselves on increasing customer expectations with quality work, friendly services and economical pricing.\r\n\r\nOur customers would testify to the professionalism and reliability we exhibit and the high quality of our work. For 30 years, we’ve enjoyed delighting our customers and this inspires and drives us forward. Our team is made up of experienced and hard working tradesmen, who are always willing to work with you to give you faultless service.\r\n\r\nOur home improvements services include decorating, home refurbishment, kitchen refurbishment, property maintenance, decoration of the Restaurants, decorating the Offices, decoration of the “Community Halls” or “Function Halls” or “Banquet Halls” for Parties or get-togethers.', 1, '2019-09-01 07:30:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id_account` int(20) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `phone` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `facebook` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `createdate` datetime NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `avatar` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `id_account_role` int(11) NOT NULL DEFAULT '2'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id_account`, `username`, `password`, `fullname`, `email`, `phone`, `facebook`, `birthday`, `createdate`, `sex`, `avatar`, `address`, `status`, `id_account_role`) VALUES
(1, 'admin', '202CB962AC59075B964B07152D234B70', 'Phan huy ich', '', '', NULL, NULL, '2019-10-09 09:44:10', 0, '', '', 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account_role`
--

CREATE TABLE `account_role` (
  `id_account_role` int(11) NOT NULL,
  `role_name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account_role`
--

INSERT INTO `account_role` (`id_account_role`, `role_name`, `status`) VALUES
(1, 'Admin', 1),
(2, 'Customer', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `category_name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `avatar` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `category_name`, `title`, `status`, `avatar`, `description`) VALUES
(1, 'Decorating the House', 'Decorating the House', 1, 'category_home.jpg', 'Decorating and Furnishing with Furniture And Glass\r\nKitchen Design\r\nFlooring Layout\r\nLightning Effects\r\nWindow Coverings\r\nColour Schemes\r\nCurtain Designing\r\nArchitectural design\r\nPlanting\r\nSeating Ali'),
(2, 'Decorating the Offices', 'Decorating the Offices', 1, 'category_home2.jpg', 'Decorating and Furnishing with Furniture and Glass, etc.\r\nFlooring Layout\r\nLightning Effects\r\nWindow Coverings\r\nColour Schemes\r\nCurtain Designing\r\nArchitectural design\r\nPlanting\r\nSeating Alignment, etc.'),
(3, 'Orther', 'Orther', 1, 'category_home3.jpg', 'Decorating and Furnishing with Furniture and Glass, etc.\r\nWindow Coverings\r\nLightning Effects\r\nCurtain Designing\r\nArchitectural design\r\nPlanting\r\nSeating Alignment, etc.'),
(4, 'Decoration of the Restaurants', 'Decoration of the Restaurants', 1, 'category_home4.jpg', 'Decorating and Furnishing with Furniture And Glass\r\nKitchen Design\r\nFlooring Layout\r\nWindow Coverings\r\nLightning Effects\r\nColour Schemes\r\nCurtain Designing\r\nArchitectural design\r\nPlanting\r\nSeating Alignment, etc.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `contact_us`
--

CREATE TABLE `contact_us` (
  `id` int(11) NOT NULL,
  `name` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `fax` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `facebook` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `contact_us`
--

INSERT INTO `contact_us` (`id`, `name`, `email`, `fax`, `phone`, `facebook`, `address`, `status`) VALUES
(1, 'A - TEAM', 'Ateam@hotmail.com.vn', '078535375867', '07806 6851', '', '330 Nguyen Kiem, Binh Thanh District, Ho Chi Minh City', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer_report`
--

CREATE TABLE `customer_report` (
  `id` int(11) NOT NULL,
  `id_account` int(11) NOT NULL,
  `title` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `id_register_service` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `faq`
--

CREATE TABLE `faq` (
  `id` int(11) NOT NULL,
  `question` text COLLATE utf8_unicode_ci NOT NULL,
  `anwers` text COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) DEFAULT '1',
  `create_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `faq`
--

INSERT INTO `faq` (`id`, `question`, `anwers`, `status`, `create_date`) VALUES
(1, 'How to login into the application?', '', 0, '2019-09-01'),
(2, 'How to register with the site?', '', 0, '2019-09-01'),
(3, 'I am not a registered user? Will I be able to apply for the service?', 'No, only the registered users will be able to apply for the service.\r\nHow to apply for the Service?', 1, '2019-09-01'),
(4, 'I reside at a location ‘X’, will I be provided with the service?', 'First you must apply for the service mentioning the service and the domain interested in, and the address at which you want the service to be provided. Then we will get back to you whether we will provide the service at that location or not. \r\n(OR)\r\nYou can provide an answer stating that the service will be provided at so and so locations only.', 1, '2019-09-01'),
(5, 'What are the charges of the service?', '', 0, '2019-09-01'),
(6, 'Will I be provided in any other services apart from the services and domains displayed? And if yes, what will be the charges?', 'Well it will be dependant on the type of the service and the domain you requested. We will revert back to you once the service request is received by us. The charges will be based on the service and the domain you preferred. This will be communicated well in advance before accepting and going ahead with the service.', 1, '2019-09-01'),
(7, 'How will I know that whether you will provide the service or not? If yes, then when will the service provided?', 'Once the service request is received, we will get back to you like whether we provide the service or not, and if we provide service we will inform when the service will be started.', 1, '2019-09-01'),
(8, 'How long will it take to complete the service?', 'Well this will be dependant on the service and domain preferred. Also it will be dependant on the work or building or complex, etc. for which the services are preferred for.', 1, '2019-09-01'),
(9, 'How will I know about the total charges for the service preferred?', 'At the time of booking for a service itself, you can find the charges for the service provided.', 1, '2019-09-01'),
(10, 'On what factors will the charges for the service depend upon?', 'The charges will be dependant on the type of the domain, and type of the service, area on which the services are preferred.', 1, '2019-09-01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice`
--

CREATE TABLE `invoice` (
  `id` int(11) NOT NULL,
  `id_account` int(11) NOT NULL,
  `create_date` date NOT NULL,
  `end_date` date NOT NULL,
  `address` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice_detail`
--

CREATE TABLE `invoice_detail` (
  `id` int(11) NOT NULL,
  `id_invoice` int(11) NOT NULL,
  `id_service` int(11) NOT NULL,
  `paid_money` double NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `page`
--

CREATE TABLE `page` (
  `id` int(11) NOT NULL,
  `name` int(11) NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `color` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `size` int(11) NOT NULL,
  `b` tinyint(1) NOT NULL DEFAULT '0',
  `i` tinyint(1) NOT NULL DEFAULT '0',
  `u` tinyint(1) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pay`
--

CREATE TABLE `pay` (
  `id` int(11) NOT NULL,
  `id_invoice` int(11) NOT NULL,
  `create_date` date NOT NULL,
  `money` decimal(10,0) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `project`
--

CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  `title` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `id_status_project` int(11) NOT NULL DEFAULT '1',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `avatar` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `project`
--

INSERT INTO `project` (`id`, `name`, `start_date`, `end_date`, `title`, `id_status_project`, `status`, `description`, `avatar`) VALUES
(1, 'Saigon Opera House', '2018-12-09', '2020-03-28', 'Under construction at 03 Le Lai, District 1, Ho Chi Minh City', 1, 1, 'Implementation: Ateam and some corporations such as VNGroup, City Land, Nova Land, etc.', 'project3.jpg'),
(2, 'Garden of Eden', '2018-08-01', '2021-03-31', 'Under construction at 330 Nguyen Kiem, District Phu Nhuan, Ho Chi Minh City', 2, 1, 'Implementation: Ateam', 'project2.jpg'),
(3, 'Golden Villas', '2017-08-01', '2018-08-01', 'Under construction at 04 Nguyen Oanh, District Go Vap, Ho Chi Minh City', 3, 1, 'Implementation: Ateam and some corporations such as VNGroup, City Land, Nova Land, etc.\r\n\r\n', 'project1.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `project_photo`
--

CREATE TABLE `project_photo` (
  `id` int(11) NOT NULL,
  `id_project` int(11) NOT NULL,
  `photo` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `project_status`
--

CREATE TABLE `project_status` (
  `id` int(11) NOT NULL,
  `name` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `avatar` varchar(250) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `project_status`
--

INSERT INTO `project_status` (`id`, `name`, `description`, `status`, `avatar`) VALUES
(1, 'On going', 'List of projects being implemented by Ateam', 1, 'project_ongoing .jpg'),
(2, 'Up coming', 'List of upcoming projects made by Ateam', 1, 'project_Upcomming.jpg'),
(3, 'Accomplished', 'List of projects completed by Ateam', 1, 'project_Accomplished.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `servicer`
--

CREATE TABLE `servicer` (
  `id` int(11) NOT NULL,
  `title` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `avatar` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `id_category` int(11) NOT NULL,
  `description` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `servicer`
--

INSERT INTO `servicer` (`id`, `title`, `avatar`, `id_category`, `description`, `status`) VALUES
(1, 'Decorating and Furnishing with Furniture And Glass', 'Service_architectural_01.jpeg', 1, 1, 1),
(2, 'Kitchen Design', '', 1, 1, 1),
(3, 'Flooring Layout', '', 1, 1, 1),
(4, 'Lightning Effects', '', 1, 1, 1),
(5, 'Window Coverings', '', 1, 1, 1),
(6, 'Colour Schemes', '', 1, 1, 1),
(7, 'Curtain Designing', '', 1, 1, 1),
(8, 'Architectural design', '', 1, 1, 1),
(9, 'Planting', '', 1, 1, 1),
(10, 'Seating Alignment in the Living Rooms', '', 1, 1, 1),
(11, 'Decorating the Offices', '', 2, 1, 1),
(12, 'Decorating and Furnishing with Furniture and Glass', '', 2, 1, 1),
(13, 'Flooring Layout', '', 2, 1, 1),
(14, 'Lightning Effects', '', 2, 1, 1),
(15, 'Window Coverings', '', 2, 1, 1),
(16, 'Colour Schemes', '', 2, 1, 1),
(17, 'Curtain Designing', '', 2, 1, 1),
(18, 'Architectural design', '', 2, 1, 1),
(19, 'Planting', '', 2, 1, 1),
(20, 'Seating Alignment', '', 2, 1, 1),
(21, 'Decorating and Furnishing with Furniture and Glass', '', 3, 1, 1),
(22, 'Window Coverings', '', 3, 1, 1),
(23, 'Lightning Effects', '', 3, 1, 1),
(24, 'Curtain Designing', '', 3, 1, 1),
(25, 'Architectural design', '', 3, 1, 1),
(32, 'Planting', '', 3, 1, 1),
(33, 'Seating Alignment', '', 3, 1, 1),
(34, 'Decorating and Furnishing with Furniture And Glass', '', 4, 1, 1),
(35, 'Kitchen Design', '', 4, 1, 1),
(36, 'Flooring Layout', '', 4, 1, 1),
(37, 'Window Coverings', '', 4, 1, 1),
(38, 'Lightning Effects', '', 4, 1, 1),
(39, 'Colour Schemes', '', 4, 1, 1),
(40, 'Curtain Designing', '', 4, 1, 1),
(41, 'Architectural design', '', 4, 1, 1),
(42, 'Planting', '', 4, 1, 1),
(43, 'Seating Alignment', '', 4, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `service_photo`
--

CREATE TABLE `service_photo` (
  `id` int(11) NOT NULL,
  `id_service` int(11) NOT NULL,
  `photo` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `title` varchar(250) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `about_us`
--
ALTER TABLE `about_us`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_account`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `id_account_role` (`id_account_role`);

--
-- Chỉ mục cho bảng `account_role`
--
ALTER TABLE `account_role`
  ADD PRIMARY KEY (`id_account_role`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Chỉ mục cho bảng `contact_us`
--
ALTER TABLE `contact_us`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `customer_report`
--
ALTER TABLE `customer_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_account` (`id_account`),
  ADD KEY `id_register_service` (`id_register_service`);

--
-- Chỉ mục cho bảng `faq`
--
ALTER TABLE `faq`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_account` (`id_account`);

--
-- Chỉ mục cho bảng `invoice_detail`
--
ALTER TABLE `invoice_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_invoce` (`id_invoice`),
  ADD KEY `id_service` (`id_service`);

--
-- Chỉ mục cho bảng `page`
--
ALTER TABLE `page`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `pay`
--
ALTER TABLE `pay`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_invoice` (`id_invoice`);

--
-- Chỉ mục cho bảng `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_status_project` (`id_status_project`);

--
-- Chỉ mục cho bảng `project_photo`
--
ALTER TABLE `project_photo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_project` (`id_project`);

--
-- Chỉ mục cho bảng `project_status`
--
ALTER TABLE `project_status`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `servicer`
--
ALTER TABLE `servicer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_category` (`id_category`);

--
-- Chỉ mục cho bảng `service_photo`
--
ALTER TABLE `service_photo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_serivce` (`id_service`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `about_us`
--
ALTER TABLE `about_us`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `id_account` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `account_role`
--
ALTER TABLE `account_role`
  MODIFY `id_account_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `contact_us`
--
ALTER TABLE `contact_us`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `customer_report`
--
ALTER TABLE `customer_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `faq`
--
ALTER TABLE `faq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `invoice_detail`
--
ALTER TABLE `invoice_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `page`
--
ALTER TABLE `page`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `pay`
--
ALTER TABLE `pay`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `project`
--
ALTER TABLE `project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `project_photo`
--
ALTER TABLE `project_photo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `project_status`
--
ALTER TABLE `project_status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `servicer`
--
ALTER TABLE `servicer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT cho bảng `service_photo`
--
ALTER TABLE `service_photo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`id_account_role`) REFERENCES `account_role` (`id_account_role`);

--
-- Các ràng buộc cho bảng `customer_report`
--
ALTER TABLE `customer_report`
  ADD CONSTRAINT `customer_report_ibfk_1` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`);

--
-- Các ràng buộc cho bảng `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`);

--
-- Các ràng buộc cho bảng `invoice_detail`
--
ALTER TABLE `invoice_detail`
  ADD CONSTRAINT `invoice_detail_ibfk_1` FOREIGN KEY (`id_invoice`) REFERENCES `invoice` (`id`),
  ADD CONSTRAINT `invoice_detail_ibfk_2` FOREIGN KEY (`id_service`) REFERENCES `servicer` (`id`);

--
-- Các ràng buộc cho bảng `pay`
--
ALTER TABLE `pay`
  ADD CONSTRAINT `pay_ibfk_1` FOREIGN KEY (`id_invoice`) REFERENCES `invoice` (`id`);

--
-- Các ràng buộc cho bảng `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`id_status_project`) REFERENCES `project_status` (`id`);

--
-- Các ràng buộc cho bảng `project_photo`
--
ALTER TABLE `project_photo`
  ADD CONSTRAINT `project_photo_ibfk_1` FOREIGN KEY (`id_project`) REFERENCES `project` (`id`);

--
-- Các ràng buộc cho bảng `servicer`
--
ALTER TABLE `servicer`
  ADD CONSTRAINT `servicer_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);

--
-- Các ràng buộc cho bảng `service_photo`
--
ALTER TABLE `service_photo`
  ADD CONSTRAINT `service_photo_ibfk_1` FOREIGN KEY (`id_service`) REFERENCES `servicer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
