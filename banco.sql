SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `locacao` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `locacao` ;

DROP TABLE IF EXISTS `locacao`.`Categoria` ;
DROP TABLE IF EXISTS `locacao`.`Veiculo` ;
DROP TABLE IF EXISTS `locacao`.`Cliente` ;
DROP TABLE IF EXISTS `locacao`.`Funcionario` ;
DROP TABLE IF EXISTS `locacao`.`Locacao` ;
DROP TABLE IF EXISTS `locacao`.`Avaria` ;
DROP TABLE IF EXISTS `locacao`.`Locacao_Avaria` ;
DROP TABLE IF EXISTS `locacao`.`Multa` ;
DROP TABLE IF EXISTS `locacao`.`Locacao_Multa` ;

-- -----------------------------------------------------
-- Table `locacao`.`Categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locacao`.`Categoria` ;

CREATE TABLE IF NOT EXISTS `locacao`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `preco` DECIMAL(18,2) NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locacao`.`Veiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locacao`.`Veiculo` ;

CREATE TABLE IF NOT EXISTS `locacao`.`Veiculo` (
  `idVeiculo` INT NOT NULL AUTO_INCREMENT,
  `idCategoria` INT NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idVeiculo`),
  INDEX `fk_Veiculo_Categoria_idx` (`idCategoria` ASC),
  CONSTRAINT `fk_Veiculo_Categoria`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `locacao`.`Categoria` (`idCategoria`)
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locacao`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locacao`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `locacao`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locacao`.`Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locacao`.`Funcionario` ;

CREATE TABLE IF NOT EXISTS `locacao`.`Funcionario` (
  `idfuncionario` INT NOT NULL AUTO_INCREMENT,
  `matricula` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idfuncionario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locacao`.`Locacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locacao`.`Locacao` ;

CREATE TABLE IF NOT EXISTS `locacao`.`Locacao` (
  `idLocacao` INT NOT NULL AUTO_INCREMENT,
  `idVeiculo` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `idFuncionario_cad` INT NOT NULL,
  `idFuncionario_rec` INT NULL,
  PRIMARY KEY (`idLocacao`),
  INDEX `fk_Locacao_Veiculo1_idx` (`idVeiculo` ASC),
  INDEX `fk_Locacao_Cliente1_idx` (`idCliente` ASC),
  INDEX `fk_Locacao_Funcionario1_idx` (`idFuncionario_cad` ASC),
  INDEX `fk_Locacao_Funcionario2_idx` (`idFuncionario_rec` ASC),
  CONSTRAINT `fk_Locacao_Veiculo1`
    FOREIGN KEY (`idVeiculo`)
    REFERENCES `locacao`.`Veiculo` (`idVeiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Locacao_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `locacao`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Locacao_Funcionario1`
    FOREIGN KEY (`idFuncionario_cad`)
    REFERENCES `locacao`.`Funcionario` (`idfuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Locacao_Funcionario2`
    FOREIGN KEY (`idFuncionario_rec`)
    REFERENCES `locacao`.`Funcionario` (`idfuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locacao`.`Avaria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locacao`.`Avaria` ;

CREATE TABLE IF NOT EXISTS `locacao`.`Avaria` (
  `idAvaria` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,	
  PRIMARY KEY (`idAvaria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locacao`.`Locacao_Avaria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locacao`.`Locacao_Avaria` ;

CREATE TABLE IF NOT EXISTS `locacao`.`Locacao_Avaria` (
  `idAvaria` INT NOT NULL,
  `idLocacao` INT NOT NULL,
  PRIMARY KEY (`idAvaria`, `idLocacao`),
  INDEX `fk_Avaria_has_Locacao_Locacao1_idx` (`idLocacao` ASC),
  INDEX `fk_Avaria_has_Locacao_Avaria1_idx` (`idAvaria` ASC),
  CONSTRAINT `fk_Avaria_has_Locacao_Avaria1`
    FOREIGN KEY (`idAvaria`)
    REFERENCES `locacao`.`Avaria` (`idAvaria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Avaria_has_Locacao_Locacao1`
    FOREIGN KEY (`idLocacao`)
    REFERENCES `locacao`.`Locacao` (`idLocacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locacao`.`Multa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locacao`.`Multa` ;

CREATE TABLE IF NOT EXISTS `locacao`.`Multa` (
  `idMulta` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idMulta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locacao`.`Locacao_Multa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locacao`.`Locacao_Multa` ;

CREATE TABLE IF NOT EXISTS `locacao`.`Locacao_Multa` (
  `idLocacao` INT NOT NULL,
  `idMulta` INT NOT NULL,
  PRIMARY KEY (`idLocacao`, `idMulta`),
  INDEX `fk_Locacao_has_Multa_Multa1_idx` (`idMulta` ASC),
  INDEX `fk_Locacao_has_Multa_Locacao1_idx` (`idLocacao` ASC),
  CONSTRAINT `fk_Locacao_has_Multa_Locacao1`
    FOREIGN KEY (`idLocacao`)
    REFERENCES `locacao`.`Locacao` (`idLocacao`),
  CONSTRAINT `fk_Locacao_has_Multa_Multa1`
    FOREIGN KEY (`idMulta`)
    REFERENCES `locacao`.`Multa` (`idMulta`)
)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

