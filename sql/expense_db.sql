CREATE DATABASE `expense_db`;
USE expense_db;

CREATE TABLE `expense_manager` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `name` varchar(200) NOT NULL,
  `amount` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;