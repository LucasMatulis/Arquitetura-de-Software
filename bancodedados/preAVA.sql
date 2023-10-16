CREATE SCHEMA IF NOT EXISTS `preAVA` DEFAULT CHARACTER SET utf8 ;
USE `preAVA` ;


CREATE TABLE IF NOT EXISTS `preAVA`.`Produto` (
	`id`        int primary key auto_increment,
	`nome`  varchar (50),
	`marca` varchar (50),
	`preco` double);