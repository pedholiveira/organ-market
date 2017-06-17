CREATE TABLE `organ_market`.`dados_venda` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`orgao` VARCHAR(50) NOT NULL,
  	`preco` DECIMAL NOT NULL,
  	`dados_doador` VARCHAR(50) NOT NULL,
  	PRIMARY KEY (`id`)
);
