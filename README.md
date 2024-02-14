<h1 align="center" id="title">JSPServletMysqlCRUD</h1>

<p id="description">This is a web application developed using JSP and Servlets. The goal of the application is to keep track of various types of Expense. This application involves the basic CRUD operations in Mysql Database.</p>

<p align="center"><img src="https://img.shields.io/badge/License-MIT-green" alt="shields"><span> </span><img src="https://img.shields.io/badge/Java-MySQL-blue" alt="shields"></p>


<h2>🛠️ Installation Steps:</h2>

<p>1. Configure Database</p>

```
CREATE DATABASE `expense_db`;
```
```
USE expense_db;
```
```
CREATE TABLE `expense_manager` (   `id` int NOT NULL AUTO_INCREMENT   `category` varchar(45) NOT NULL   `date` varchar(45) NOT NULL   `name` varchar(200) NOT NULL   `amount` varchar(45) DEFAULT NULL   PRIMARY KEY (`id`)   UNIQUE KEY `id_UNIQUE` (`id`) ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

<h2>Project Screenshots:</h2>

<img src="https://raw.githubusercontent.com/farhadssj/JSPServletMysqlCRUD/main/img/Screenshot%202024-02-13%20164901.png" alt="project-screenshot" width="400">

<img src="https://github.com/farhadssj/JSPServletMysqlCRUD/blob/main/img/Screenshot%202024-02-13%20164607.png?raw=true" alt="project-screenshot" width="400">

<img src="https://github.com/farhadssj/JSPServletMysqlCRUD/blob/main/img/Screenshot%202024-02-13%20164944.png?raw=true" alt="project-screenshot" width="400">

<h2>🛡️ License:</h2>

This project is licensed under the MIT License Copyright (c) 2024 Md Farhad Hossain Permission is hereby granted free of charge to any person obtaining a copy of this software and associated documentation files (the "Software") to deal in the Software without restriction including without limitation the rights to use copy modify merge publish distribute sublicense and/or sell copies of the Software and to permit persons to whom the Software is furnished to do so subject to the following conditions: The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. THE SOFTWARE IS PROVIDED "AS IS" WITHOUT WARRANTY OF ANY KIND EXPRESS OR IMPLIED INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM DAMAGES OR OTHER LIABILITY WHETHER IN AN ACTION OF CONTRACT TORT OR OTHERWISE ARISING FROM OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
