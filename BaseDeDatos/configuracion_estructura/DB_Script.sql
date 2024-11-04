-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema CyberiaStore
-- -----------------------------------------------------

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
-- Table `CyberiaStore`.`PRODUCTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO` (
  `ID_PRODUCTO` INT NOT NULL AUTO_INCREMENT,
  `SKU` VARCHAR(8) NOT NULL,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `DESCRIPCION` TEXT NOT NULL,
  `PRECIO` DOUBLE NOT NULL,
  `IMAGEN` BLOB NULL,
  UNIQUE INDEX `SKU_UNIQUE` (`SKU` ASC) VISIBLE,
  PRIMARY KEY (`ID_PRODUCTO`))
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
  PRIMARY KEY (`ID_MARCA`),
  UNIQUE INDEX `NOMBRE_UNIQUE` (`NOMBRE` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`TIPO_PRODUCTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`TIPO_PRODUCTO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`TIPO_PRODUCTO` (
  `ID_TIPO_PRODUCTO` INT NOT NULL AUTO_INCREMENT,
  `TIPO` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  `IMAGEN` BLOB NULL,
  PRIMARY KEY (`ID_TIPO_PRODUCTO`))
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
-- Table `CyberiaStore`.`PRODUCTO_X_TIPO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_X_TIPO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_X_TIPO` (
  `ID_TIPO_PRODUCTO` INT NOT NULL,
  `ID_PRODUCTO` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_X_PROVEEDOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_X_PROVEEDOR` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_X_PROVEEDOR` (
  `ID_PROVEEDOR` INT NOT NULL,
  `ID_PRODUCTO` INT NOT NULL,
  `PRECIO_PROVEEDOR` DOUBLE NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_X_MARCA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_X_MARCA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_X_MARCA` (
  `ID_PRODUCTO` INT NOT NULL,
  `ID_MARCA` INT NOT NULL)
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
-- Table `CyberiaStore`.`PEDIDO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PEDIDO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PEDIDO` (
  `ID_PEDIDO` INT NOT NULL AUTO_INCREMENT,
  `ESTADO` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_PEDIDO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_X_PEDIDO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_X_PEDIDO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_X_PEDIDO` (
  `ID_PEDIDO` INT NOT NULL,
  `ID_PRODUCTO` INT NOT NULL,
  `CANTIDAD` INT NOT NULL,
  PRIMARY KEY (`ID_PEDIDO`, `ID_PRODUCTO`))
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
-- Table `CyberiaStore`.`COMPROBANTE_DE_PAGO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`COMPROBANTE_DE_PAGO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`COMPROBANTE_DE_PAGO` (
  `ID_COMPROBANTE_DE_PAGO` INT NOT NULL AUTO_INCREMENT,
  `FECHA` DATE NOT NULL,
  `SUBTOTAL` DOUBLE NOT NULL,
  `IGV` DOUBLE NOT NULL,
  `TOTAL` DOUBLE NOT NULL,
  `DESCUENTO_APLICADO` DOUBLE NULL,
  `ACTIVO` TINYINT NOT NULL,
  `ID_PEDIDO` INT NOT NULL,
  `ID_OFERTA` INT NULL,
  PRIMARY KEY (`ID_COMPROBANTE_DE_PAGO`, `ID_PEDIDO`),
  UNIQUE INDEX `ID_COMPROBANTE_DE_PAGO_UNIQUE` (`ID_COMPROBANTE_DE_PAGO` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`BOLETA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`BOLETA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`BOLETA` (
  `ID_BOLETA` INT NOT NULL AUTO_INCREMENT,
  `ACTIVO` TINYINT NOT NULL,
  `NUMERO_BOLETA` VARCHAR(8) NOT NULL,
  `ID_COMPROBANTE_DE_PAGO` INT NOT NULL,
  PRIMARY KEY (`ID_BOLETA`, `ID_COMPROBANTE_DE_PAGO`),
  UNIQUE INDEX `NUMERO_BOLETA_UNIQUE` (`NUMERO_BOLETA` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`FACTURA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`FACTURA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`FACTURA` (
  `ID_FACTURA` INT NOT NULL AUTO_INCREMENT,
  `NUMERO_FACTURA` VARCHAR(8) NOT NULL,
  `RUC` VARCHAR(11) NOT NULL,
  `RAZON_SOCIAL` VARCHAR(45) NOT NULL,
  `DIRECCION` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  `ID_COMPROBANTE_DE_PAGO` INT NOT NULL,
  PRIMARY KEY (`ID_FACTURA`, `ID_COMPROBANTE_DE_PAGO`),
  UNIQUE INDEX `NUMERO_FACTURA_UNIQUE` (`NUMERO_FACTURA` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`USUARIO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`USUARIO` (
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
  PRIMARY KEY (`ID_USUARIO`),
  UNIQUE INDEX `DOCUMENTO_UNIQUE` (`DOCUMENTO` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`CLIENTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`CLIENTE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`CLIENTE` (
  `ID_CLIENTE` INT NOT NULL AUTO_INCREMENT,
  `VERIFICADO` TINYINT NOT NULL,
  `ID_USUARIO` INT NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`, `ID_USUARIO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`BOLETA_X_CLIENTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`BOLETA_X_CLIENTE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`BOLETA_X_CLIENTE` (
  `ID_CLIENTE` INT NOT NULL,
  `ID_BOLETA` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`FACTURA_X_CLIENTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`FACTURA_X_CLIENTE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`FACTURA_X_CLIENTE` (
  `ID_FACTURA` INT NOT NULL,
  `ID_CLIENTE` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`ROL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`ROL` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`ROL` (
  `ID_ROL` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_ROL`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`ROL_X_USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`ROL_X_USUARIO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`ROL_X_USUARIO` (
  `ID_USUARIO` INT NOT NULL,
  `ID_ROL` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PERMISO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PERMISO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PERMISO` (
  `ID_PERMISO` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `DESCRIPCION` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  PRIMARY KEY (`ID_PERMISO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PERMISO_X_ROL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PERMISO_X_ROL` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PERMISO_X_ROL` (
  `ID_ROL` INT NOT NULL,
  `ID_PERMISO` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`TRABAJADOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`TRABAJADOR` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`TRABAJADOR` (
  `ID_TRABAJADOR` INT NOT NULL AUTO_INCREMENT,
  `SUELDO` DOUBLE NOT NULL,
  `FECHA_INGRESO` DATE NOT NULL,
  `FECHA_SALIDA` DATE NULL,
  `ID_USUARIO` INT NOT NULL,
  PRIMARY KEY (`ID_TRABAJADOR`, `ID_USUARIO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`TRABAJADOR_X_SEDE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`TRABAJADOR_X_SEDE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`TRABAJADOR_X_SEDE` (
  `ID_TRABAJADOR` INT NOT NULL,
  `ID_SEDE` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`ADMINISTRADOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`ADMINISTRADOR` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`ADMINISTRADOR` (
  `ID_ADMINISTRADOR` INT NOT NULL AUTO_INCREMENT,
  `ID_TRABAJADOR` INT NOT NULL,
  PRIMARY KEY (`ID_ADMINISTRADOR`, `ID_TRABAJADOR`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`ALMACENERO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`ALMACENERO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`ALMACENERO` (
  `ID_ALMACENERO` INT NOT NULL AUTO_INCREMENT,
  `ID_TRABAJADOR` INT NOT NULL,
  PRIMARY KEY (`ID_ALMACENERO`, `ID_TRABAJADOR`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`VENDEDOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`VENDEDOR` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`VENDEDOR` (
  `ID_VENDEDOR` INT NOT NULL AUTO_INCREMENT,
  `ID_TRABAJADOR` INT NOT NULL,
  PRIMARY KEY (`ID_VENDEDOR`, `ID_TRABAJADOR`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
