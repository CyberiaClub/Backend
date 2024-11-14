-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema CyberiaStore
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `CyberiaStore` ;

-- -----------------------------------------------------
-- Schema CyberiaStore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CyberiaStore` DEFAULT CHARACTER SET utf8 ;
USE `CyberiaStore` ;

-- -----------------------------------------------------
-- Table `CyberiaStore`.`PROVEEDOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PROVEEDOR` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PROVEEDOR` (
  `ID_PROVEEDOR` INT NOT NULL AUTO_INCREMENT,
  `RUC` VARCHAR(20) NOT NULL,
  `RAZON_SOCIAL` VARCHAR(45) NOT NULL,
  `NOMBRE_DEL_CONTACTO` VARCHAR(45) NOT NULL,
  `CORREO` VARCHAR(120) NOT NULL,
  `TELEFONO` VARCHAR(9) NOT NULL,
  `DIRECCION` VARCHAR(100) NOT NULL,
  `DESCRIPCION` TEXT NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  UNIQUE INDEX `RUC_UNIQUE` (`RUC` ASC) VISIBLE,
  PRIMARY KEY (`ID_PROVEEDOR`),
  UNIQUE INDEX `NOMBRE_UNIQUE` (`RAZON_SOCIAL` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`TIPO_PRODUCTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`TIPO_PRODUCTO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`TIPO_PRODUCTO` (
  `ID_TIPO_PRODUCTO` INT NOT NULL AUTO_INCREMENT,
  `TIPO` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  `IMAGEN` BLOB NOT NULL,
  PRIMARY KEY (`ID_TIPO_PRODUCTO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`MARCA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`MARCA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`MARCA` (
  `ID_MARCA` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  `IMAGEN` BLOB NOT NULL,
  `ID_PROVEEDOR` INT NOT NULL,
  PRIMARY KEY (`ID_MARCA`, `ID_PROVEEDOR`),
  UNIQUE INDEX `NOMBRE_UNIQUE` (`NOMBRE` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO` (
  `ID_PRODUCTO` INT NOT NULL AUTO_INCREMENT,
  `SKU` VARCHAR(8) NOT NULL,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `DESCRIPCION` TEXT NOT NULL,
  `PRECIO` DOUBLE NOT NULL,
  `PRECIO_PROVEEDOR` DOUBLE NOT NULL,
  `IMAGEN` BLOB NOT NULL,
  `ID_TIPO_PRODUCTO` INT NOT NULL,
  `ID_MARCA` INT NOT NULL,
  UNIQUE INDEX `SKU_UNIQUE` (`SKU` ASC) VISIBLE,
  PRIMARY KEY (`ID_PRODUCTO`, `ID_TIPO_PRODUCTO`, `ID_MARCA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_COMPUESTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_COMPUESTO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_COMPUESTO` (
  `ID_PRODUCTO_PADRE` INT NOT NULL,
  `ID_PRODUCTO` INT NOT NULL,
  `CANTIDAD` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`SEDE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`SEDE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`SEDE` (
  `ID_SEDE` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `DESCRIPCION` TEXT NOT NULL,
  `TELEFONO` VARCHAR(9) NOT NULL,
  `HORARIO_APERTURA` TIME NOT NULL,
  `HORARIO_CIERRE` TIME NOT NULL,
  PRIMARY KEY (`ID_SEDE`),
  UNIQUE INDEX `ID_SEDE_UNIQUE` (`ID_SEDE` ASC) VISIBLE,
  UNIQUE INDEX `NOMBRE_UNIQUE` (`NOMBRE` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_X_SEDE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_X_SEDE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_X_SEDE` (
  `ID_PRODUCTO` INT NOT NULL,
  `STOCK_SEDE` INT NOT NULL,
  `ID_SEDE` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`OFERTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`OFERTA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`OFERTA` (
  `ID_OFERTA` INT NOT NULL AUTO_INCREMENT,
  `FECHA_INICIO` DATE NOT NULL,
  `FECHA_FIN` DATE NOT NULL,
  `PORCENTAJE` INT NOT NULL,
  `IMAGEN` BLOB NULL,
  PRIMARY KEY (`ID_OFERTA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_X_OFERTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_X_OFERTA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_X_OFERTA` (
  `ID_PRODUCTO` INT NOT NULL,
  `ID_OFERTA` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`TIPO_TRANSACCION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`TIPO_TRANSACCION` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`TIPO_TRANSACCION` (
  `ID_TIPO_TRANSACCION` INT NOT NULL,
  `SECUENCIAL` VARCHAR(2) NOT NULL,
  `TIPO_TRANSACCION` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_TIPO_TRANSACCION`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`TIPO_TRABAJADOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`TIPO_TRABAJADOR` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`TIPO_TRABAJADOR` (
  `ID_TIPO_TRABAJADOR` INT NOT NULL,
  `NOMBRE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_TIPO_TRABAJADOR`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PERSONA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PERSONA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PERSONA` (
  `ID_USUARIO` INT NOT NULL AUTO_INCREMENT,
  `DOCUMENTO` VARCHAR(15) NOT NULL,
  `TELEFONO` VARCHAR(13) NOT NULL,
  `NOMBRE` VARCHAR(100) NOT NULL,
  `APELLIDO_MATERNO` VARCHAR(100) NOT NULL,
  `APELLIDO_PATERNO` VARCHAR(100) NOT NULL,
  `FECHA_NACIMIENTO` DATE NOT NULL,
  `SEXO` CHAR NOT NULL,
  `CORREO` VARCHAR(120) NOT NULL,
  `DIRECCION` VARCHAR(120) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  `CONTRASEÑA` VARCHAR(128) NOT NULL,
  `NACIONALIDAD` VARCHAR(30) NOT NULL,
  `TIPO_DOCUMENTO` VARCHAR(25) NOT NULL,
  `ID_TRABAJADOR` INT NULL,
  `SUELDO` DOUBLE NULL,
  `FECHA_INGRESO` DATE NULL,
  `FECHA_SALIDA` DATE NULL,
  `ID_TIPO_TRABAJADOR` INT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  UNIQUE INDEX `DOCUMENTO_UNIQUE` (`DOCUMENTO` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`COMPROBANTE_DE_PAGO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`COMPROBANTE_DE_PAGO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`COMPROBANTE_DE_PAGO` (
  `ID_COMPROBANTE_DE_PAGO` INT NOT NULL AUTO_INCREMENT,
  `FECHA` DATE NOT NULL,
  `SUBTOTAL` DOUBLE NOT NULL,
  `IGV` DOUBLE NOT NULL,
  `TOTAL` DOUBLE NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  `ESTADO_PEDIDO` VARCHAR(45) NOT NULL,
  `NUMERO` VARCHAR(8) NOT NULL,
  `RUC` VARCHAR(11) NULL,
  `RAZON_SOCIAL` VARCHAR(45) NULL,
  `DIRECCION` VARCHAR(45) NULL,
  `ID_TIPO_TRANSACCION` INT NOT NULL,
  `ID_PERSONA` INT NOT NULL,
  PRIMARY KEY (`ID_COMPROBANTE_DE_PAGO`, `ID_TIPO_TRANSACCION`, `ID_PERSONA`),
  UNIQUE INDEX `ID_COMPROBANTE_DE_PAGO_UNIQUE` (`ID_COMPROBANTE_DE_PAGO` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`TRABAJADOR_X_SEDE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`TRABAJADOR_X_SEDE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`TRABAJADOR_X_SEDE` (
  `ID_SEDE` INT NOT NULL,
  `ID_TRABAJADOR` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`COMPROBANTE_DE_PAGO_X_PRODUCTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`COMPROBANTE_DE_PAGO_X_PRODUCTO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`COMPROBANTE_DE_PAGO_X_PRODUCTO` (
  `ID_COMPROBANTE_DE_PAGO` INT NOT NULL,
  `ID_PRODUCTO` INT NOT NULL,
  `CANTIDAD` INT NOT NULL,
  PRIMARY KEY (`ID_COMPROBANTE_DE_PAGO`, `ID_PRODUCTO`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
