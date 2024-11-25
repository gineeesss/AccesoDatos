CREATE TABLE `usuarios`(
	`id` int NOT NULL AUTO_INCREMENT,
	`username` varchar(12) DEFAULT NULL,
	`password` varchar(60) DEFAULT NULL,
	`email` varchar(45) DEFAULT NULL,
	PRIMARY KEY(`id`)
)ENGINE = InnoDB