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
  PRIMARY KEY (`ID_PROVEEDOR`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `RUC_UNIQUE` ON `CyberiaStore`.`PROVEEDOR` (`RUC` ASC) VISIBLE;

CREATE UNIQUE INDEX `NOMBRE_UNIQUE` ON `CyberiaStore`.`PROVEEDOR` (`RAZON_SOCIAL` ASC) VISIBLE;


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
  PRIMARY KEY (`ID_MARCA`, `ID_PROVEEDOR`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `NOMBRE_UNIQUE` ON `CyberiaStore`.`MARCA` (`NOMBRE` ASC) VISIBLE;

CREATE INDEX `fk_MARCA_PROVEEDOR1_idx` ON `CyberiaStore`.`MARCA` (`ID_PROVEEDOR` ASC) VISIBLE;


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
  `ACTIVO` TINYINT NOT NULL,
  `ID_TIPO_PRODUCTO` INT NOT NULL,
  `ID_MARCA` INT NOT NULL,
  PRIMARY KEY (`ID_PRODUCTO`, `ID_TIPO_PRODUCTO`, `ID_MARCA`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `SKU_UNIQUE` ON `CyberiaStore`.`PRODUCTO` (`SKU` ASC) VISIBLE;

CREATE INDEX `fk_PRODUCTO_TIPO_PRODUCTO1_idx` ON `CyberiaStore`.`PRODUCTO` (`ID_TIPO_PRODUCTO` ASC) VISIBLE;

CREATE INDEX `fk_PRODUCTO_MARCA1_idx` ON `CyberiaStore`.`PRODUCTO` (`ID_MARCA` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_COMPUESTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_COMPUESTO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_COMPUESTO` (
  `ID_PRODUCTO_PADRE` INT NOT NULL,
  `ID_PRODUCTO` INT NOT NULL,
  `CANTIDAD` INT NOT NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_PRODUCTO_COMPUESTO_PRODUCTO1_idx` ON `CyberiaStore`.`PRODUCTO_COMPUESTO` (`ID_PRODUCTO` ASC) VISIBLE;

CREATE INDEX `fk_PRODUCTO_COMPUESTO_PRODUCTO2_idx` ON `CyberiaStore`.`PRODUCTO_COMPUESTO` (`ID_PRODUCTO_PADRE` ASC) VISIBLE;


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
  `ACTIVO` TINYINT NOT NULL,
  PRIMARY KEY (`ID_SEDE`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `ID_SEDE_UNIQUE` ON `CyberiaStore`.`SEDE` (`ID_SEDE` ASC) VISIBLE;

CREATE UNIQUE INDEX `NOMBRE_UNIQUE` ON `CyberiaStore`.`SEDE` (`NOMBRE` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_X_SEDE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_X_SEDE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_X_SEDE` (
  `ID_PRODUCTO` INT NOT NULL,
  `ID_SEDE` INT NOT NULL,
  `STOCK_SEDE` INT NOT NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_PRODUCTO_has_SEDE_PRODUCTO1_idx` ON `CyberiaStore`.`PRODUCTO_X_SEDE` (`ID_PRODUCTO` ASC) VISIBLE;

CREATE INDEX `fk_PRODUCTO_X_SEDE_SEDE1_idx` ON `CyberiaStore`.`PRODUCTO_X_SEDE` (`ID_SEDE` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`OFERTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`OFERTA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`OFERTA` (
  `ID_OFERTA` INT NOT NULL AUTO_INCREMENT,
  `FECHA_INICIO` DATE NOT NULL,
  `FECHA_FIN` DATE NOT NULL,
  `PORCENTAJE` INT NOT NULL,
  `IMAGEN` BLOB NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
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

CREATE INDEX `fk_PRODUCTO_has_OFERTA_OFERTA1_idx` ON `CyberiaStore`.`PRODUCTO_X_OFERTA` (`ID_OFERTA` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`TIPO_COMPROBANTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`TIPO_COMPROBANTE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`TIPO_COMPROBANTE` (
  `ID_TIPO_COMPROBANTE` INT NOT NULL AUTO_INCREMENT,
  `SECUENCIAL` VARCHAR(2) NOT NULL,
  `TIPO_COMPROBANTE` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  PRIMARY KEY (`ID_TIPO_COMPROBANTE`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`TIPO_PERSONA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`TIPO_PERSONA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`TIPO_PERSONA` (
  `ID_TIPO_PERSONA` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  PRIMARY KEY (`ID_TIPO_PERSONA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PERSONA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PERSONA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PERSONA` (
  `ID_PERSONA` INT NOT NULL AUTO_INCREMENT,
  `DOCUMENTO` VARCHAR(15) NOT NULL,
  `TELEFONO` VARCHAR(13) NOT NULL,
  `NOMBRE` VARCHAR(100) NOT NULL,
  `PRIMER_APELLIDO` VARCHAR(100) NOT NULL,
  `SEGUNDO_APELLIDO` VARCHAR(100) NULL,
  `FECHA_NACIMIENTO` DATE NOT NULL,
  `SEXO` CHAR NOT NULL,
  `CORREO` VARCHAR(120) NOT NULL,
  `DIRECCION` VARCHAR(120) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  `CONTRASEÑA` VARCHAR(128) NOT NULL,
  `NACIONALIDAD` VARCHAR(30) NOT NULL,
  `TIPO_DOCUMENTO` VARCHAR(25) NOT NULL,
  `SUELDO` DOUBLE NULL,
  `FECHA_INGRESO` DATE NULL,
  `FECHA_SALIDA` DATE NULL,
  `ID_TIPO_PERSONA` INT NOT NULL,
  `ID_SEDE` INT NULL,
  PRIMARY KEY (`ID_PERSONA`, `ID_TIPO_PERSONA`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `DOCUMENTO_UNIQUE` ON `CyberiaStore`.`PERSONA` (`DOCUMENTO` ASC) VISIBLE;

CREATE INDEX `fk_PERSONA_TIPO_TRABAJADOR1_idx` ON `CyberiaStore`.`PERSONA` (`ID_TIPO_PERSONA` ASC) VISIBLE;

CREATE INDEX `fk_PERSONA_SEDE1_idx` ON `CyberiaStore`.`PERSONA` (`ID_SEDE` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`COMPROBANTE_PAGO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`COMPROBANTE_PAGO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`COMPROBANTE_PAGO` (
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
  `ID_TIPO_COMPROBANTE` INT NOT NULL,
  `ID_PERSONA` INT NOT NULL,
  PRIMARY KEY (`ID_COMPROBANTE_DE_PAGO`, `ID_TIPO_COMPROBANTE`, `ID_PERSONA`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `ID_COMPROBANTE_DE_PAGO_UNIQUE` ON `CyberiaStore`.`COMPROBANTE_PAGO` (`ID_COMPROBANTE_DE_PAGO` ASC) VISIBLE;

CREATE INDEX `fk_COMPROBANTE_DE_PAGO_TIPO_TRANSACCION1_idx` ON `CyberiaStore`.`COMPROBANTE_PAGO` (`ID_TIPO_COMPROBANTE` ASC) VISIBLE;

CREATE INDEX `fk_COMPROBANTE_DE_PAGO_USUARIO1_idx` ON `CyberiaStore`.`COMPROBANTE_PAGO` (`ID_PERSONA` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`COMPROBANTE_PAGO_X_PRODUCTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`COMPROBANTE_PAGO_X_PRODUCTO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`COMPROBANTE_PAGO_X_PRODUCTO` (
  `ID_COMPROBANTE_PAGO` INT NOT NULL,
  `ID_PRODUCTO` INT NOT NULL,
  `CANTIDAD` INT NOT NULL,
  PRIMARY KEY (`ID_COMPROBANTE_PAGO`, `ID_PRODUCTO`))
ENGINE = InnoDB;

CREATE INDEX `fk_COMPROBANTE_DE_PAGO_has_PRODUCTO_PRODUCTO1_idx` ON `CyberiaStore`.`COMPROBANTE_PAGO_X_PRODUCTO` (`ID_PRODUCTO` ASC) VISIBLE;

CREATE INDEX `fk_COMPROBANTE_DE_PAGO_has_PRODUCTO_COMPROBANTE_DE_PAGO1_idx` ON `CyberiaStore`.`COMPROBANTE_PAGO_X_PRODUCTO` (`ID_COMPROBANTE_PAGO` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PAGINA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PAGINA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PAGINA` (
  `ID_PAGINA` INT NOT NULL,
  `NOMBRE` VARCHAR(100) NOT NULL,
  `REFERENCIA` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  PRIMARY KEY (`ID_PAGINA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`TIPO_PERSONA_X_PAGINA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`TIPO_PERSONA_X_PAGINA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`TIPO_PERSONA_X_PAGINA` (
  `ID_TIPO_PERSONA` INT NOT NULL,
  `ID_PAGINA` INT NOT NULL,
  PRIMARY KEY (`ID_TIPO_PERSONA`, `ID_PAGINA`))
ENGINE = InnoDB;

CREATE INDEX `fk_TIPO_PERSONA_has_PAGINA_PAGINA1_idx` ON `CyberiaStore`.`TIPO_PERSONA_X_PAGINA` (`ID_PAGINA` ASC) VISIBLE;

CREATE INDEX `fk_TIPO_PERSONA_has_PAGINA_TIPO_PERSONA1_idx` ON `CyberiaStore`.`TIPO_PERSONA_X_PAGINA` (`ID_TIPO_PERSONA` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
