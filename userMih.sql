create database demospringboot

use demospringboot

CREATE TABLE IF NOT EXISTS `demospringboot`.`user` (
  `id` INT(100) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  `address` VARCHAR(300) NULL DEFAULT NULL,
  `age` INT(100) NULL DEFAULT NULL,
  `file_name` VARCHAR(200) NULL DEFAULT NULL,
`file_data` MEDIUMBLOB  NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
