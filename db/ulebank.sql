DROP DATABASE ulebank;

CREATE DATABASE ulebank;

GRANT ALL ON ulebank.* TO ulebankuser@'%' IDENTIFIED BY 'pulebankuser';
GRANT ALL ON ulebank.* TO ulebankuser@localhost IDENTIFIED BY 'pulebankuser';

USE ulebank;

-- -----------------------------------------------------
-- Table `ulebank`.`Office`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ulebank`.`Office` (
  `idOffice` VARCHAR(4) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `zip` INT NOT NULL,
  `phone` INT NOT NULL,
  PRIMARY KEY (`idOffice`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ulebank`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ulebank`.`employee` (
  `idemployee` VARCHAR(9) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `salary` FLOAT(2) NOT NULL,
  `idOffice` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`idemployee`),
  INDEX `fk_employee_Office_idx` (`idOffice` ASC),
  CONSTRAINT `fk_employee_Office`
    FOREIGN KEY (`idOffice`)
    REFERENCES `ulebank`.`Office` (`idOffice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
