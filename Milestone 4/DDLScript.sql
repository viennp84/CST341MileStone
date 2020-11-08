-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema aawpey19h7mt74gk
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema aawpey19h7mt74gk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `aawpey19h7mt74gk` DEFAULT CHARACTER SET utf8 ;
USE `aawpey19h7mt74gk` ;

-- -----------------------------------------------------
-- Table `aawpey19h7mt74gk`.`artist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aawpey19h7mt74gk`.`artist` (
  `artistId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`artistId`))
ENGINE = InnoDB
AUTO_INCREMENT = 51
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `aawpey19h7mt74gk`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aawpey19h7mt74gk`.`genre` (
  `genreId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`genreId`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `aawpey19h7mt74gk`.`table_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aawpey19h7mt74gk`.`table_user` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(25) NULL DEFAULT NULL,
  `phone` VARCHAR(11) NULL DEFAULT NULL,
  `username` VARCHAR(25) NULL DEFAULT NULL,
  `password` VARCHAR(25) NULL DEFAULT NULL,
  `gender` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 684
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `aawpey19h7mt74gk`.`track`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aawpey19h7mt74gk`.`track` (
  `trackId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `albumId` INT(11) NULL DEFAULT NULL,
  `genreId` INT(11) NULL DEFAULT NULL,
  `composer` VARCHAR(100) NULL DEFAULT NULL,
  `milliseconds` INT(11) NULL DEFAULT NULL,
  `unitPrice` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`trackId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
