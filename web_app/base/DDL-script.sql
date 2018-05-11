-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Bookstore
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Bookstore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Bookstore` DEFAULT CHARACTER SET utf8 ;
USE `Bookstore` ;

-- -----------------------------------------------------
-- Table `Bookstore`.`Publisher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bookstore`.`Publisher` (
  `Name` VARCHAR(255) NOT NULL,
  `Address` VARCHAR(255) NULL,
  `Phone` VARCHAR(255) NULL,
  PRIMARY KEY (`Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bookstore`.`Book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bookstore`.`Book` (
  `ISBN` INT NOT NULL,
  `Title` VARCHAR(255) NULL,
  `Publication_Year` DATE NULL,
  `Price` FLOAT NULL,
  `Category` VARCHAR(255) NULL,
  `Quantity` INT NULL,
  `Threshold` INT NULL,
  `Publisher` VARCHAR(255) NULL,
  PRIMARY KEY (`ISBN`),
  INDEX `book_publisher_fk_idx` (`Publisher` ASC),
  CONSTRAINT `Book_Publisher_FK`
    FOREIGN KEY (`Publisher`)
    REFERENCES `Bookstore`.`Publisher` (`Name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bookstore`.`Author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bookstore`.`Author` (
  `ISBN` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ISBN`, `Name`),
  CONSTRAINT `Author_Book_FK`
    FOREIGN KEY (`ISBN`)
    REFERENCES `Bookstore`.`Book` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bookstore`.`Publisher_Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bookstore`.`Publisher_Orders` (
  `ISBN` INT NOT NULL,
  `Publisher_Name` VARCHAR(255) NOT NULL,
  `Quantity` INT NULL,
  PRIMARY KEY (`ISBN`, `Publisher_Name`),
  INDEX `Orders_Publisher_FK_idx` (`Publisher_Name` ASC),
  CONSTRAINT `Orders_Book_FK`
    FOREIGN KEY (`ISBN`)
    REFERENCES `Bookstore`.`Book` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Orders_Publisher_FK`
    FOREIGN KEY (`Publisher_Name`)
    REFERENCES `Bookstore`.`Publisher` (`Name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bookstore`.`Credentials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bookstore`.`Credentials` (
  `Email` VARCHAR(255) NOT NULL,
  `Password` VARCHAR(255) NULL,
  `User_Name` VARCHAR(255) NULL,
  `Acount_Type` VARCHAR(255) NULL,
  PRIMARY KEY (`Email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bookstore`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bookstore`.`Customer` (
  `Email` VARCHAR(255) NOT NULL,
  `First_Name` VARCHAR(255) NULL,
  `Last_Name` VARCHAR(255) NULL,
  `Address` VARCHAR(255) NULL,
  `Phone` VARCHAR(255) NULL,
  PRIMARY KEY (`Email`),
  CONSTRAINT `Customer_Credentials_FK`
    FOREIGN KEY (`Email`)
    REFERENCES `Bookstore`.`Credentials` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bookstore`.`Customer_Purchases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bookstore`.`Customer_Purchases` (
  `Email` VARCHAR(255) NOT NULL,
  `ISBN` INT NOT NULL,
  `Order_Date` DATE NOT NULL,
  `Quantity` INT NULL,
  `Total_Price` FLOAT NULL,
  PRIMARY KEY (`Email`, `ISBN`, `Order_Date`),
  INDEX `Purchase_Book_FK_idx` (`ISBN` ASC),
  CONSTRAINT `Purchase_Customer_FK`
    FOREIGN KEY (`Email`)
    REFERENCES `Bookstore`.`Customer` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Purchase_Book_FK`
    FOREIGN KEY (`ISBN`)
    REFERENCES `Bookstore`.`Book` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bookstore`.`Customer_Cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bookstore`.`Customer_Cart` (
  `Email` VARCHAR(255) NOT NULL,
  `ISBN` INT NOT NULL,
  `Total_Price` FLOAT NULL,
  PRIMARY KEY (`Email`, `ISBN`),
  INDEX `Cart_Book_FK_idx` (`ISBN` ASC),
  CONSTRAINT `Cart_Customer_FK`
    FOREIGN KEY (`Email`)
    REFERENCES `Bookstore`.`Customer` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Cart_Book_FK`
    FOREIGN KEY (`ISBN`)
    REFERENCES `Bookstore`.`Book` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
