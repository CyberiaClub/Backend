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
  `NOMBRE` VARCHAR(45) NOT NULL,
  `FECHA_REGISTRO` DATE NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  UNIQUE INDEX `RUC_UNIQUE` (`RUC` ASC) VISIBLE,
  PRIMARY KEY (`ID_PROVEEDOR`))
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
  `UNIDAD` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `SKU_UNIQUE` (`SKU` ASC) VISIBLE,
  PRIMARY KEY (`ID_PRODUCTO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`SEDE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`SEDE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`SEDE` (
  `ID_SEDE` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `DESCRIPCION` TEXT NOT NULL,
  PRIMARY KEY (`ID_SEDE`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = armscii8;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`MARCA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`MARCA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`MARCA` (
  `ID_MARCA` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  PRIMARY KEY (`ID_MARCA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`TIPO_PRODUCTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`TIPO_PRODUCTO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`TIPO_PRODUCTO` (
  `ID_TIPO_PRODUCTO` INT NOT NULL AUTO_INCREMENT,
  `TIPO` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  PRIMARY KEY (`ID_TIPO_PRODUCTO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_COMPUESTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_COMPUESTO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_COMPUESTO` (
  `ID_PRODUCTO_PADRE` INT NOT NULL,
  `ID_PRODUCTO` INT NOT NULL,
  `CANTIDAD` INT NOT NULL,
  INDEX `fk_PRODUCTO_COMPUESTO_PRODUCTO1_idx` (`ID_PRODUCTO` ASC) VISIBLE,
  INDEX `fk_PRODUCTO_COMPUESTO_PRODUCTO2_idx` (`ID_PRODUCTO_PADRE` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTO_COMPUESTO_PRODUCTO1`
    FOREIGN KEY (`ID_PRODUCTO`)
    REFERENCES `CyberiaStore`.`PRODUCTO` (`ID_PRODUCTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_COMPUESTO_PRODUCTO2`
    FOREIGN KEY (`ID_PRODUCTO_PADRE`)
    REFERENCES `CyberiaStore`.`PRODUCTO` (`ID_PRODUCTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_X_TIPO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_X_TIPO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_X_TIPO` (
  `ID_TIPO_PRODUCTO` INT NOT NULL,
  `ID_PRODUCTO` INT NOT NULL,
  INDEX `fk_TIPO_PRODUCTO_has_PRODUCTO_TIPO_PRODUCTO1_idx` (`ID_TIPO_PRODUCTO` ASC) VISIBLE,
  INDEX `fk_TIPO_PRODUCTO_has_PRODUCTO_PRODUCTO1_idx` (`ID_PRODUCTO` ASC) VISIBLE,
  CONSTRAINT `fk_TIPO_PRODUCTO_has_PRODUCTO_TIPO_PRODUCTO1`
    FOREIGN KEY (`ID_TIPO_PRODUCTO`)
    REFERENCES `CyberiaStore`.`TIPO_PRODUCTO` (`ID_TIPO_PRODUCTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TIPO_PRODUCTO_has_PRODUCTO_PRODUCTO1`
    FOREIGN KEY (`ID_PRODUCTO`)
    REFERENCES `CyberiaStore`.`PRODUCTO` (`ID_PRODUCTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_X_PROVEEDOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_X_PROVEEDOR` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_X_PROVEEDOR` (
  `ID_PROVEEDOR` INT NOT NULL,
  `ID_PRODUCTO` INT NOT NULL,
  `PRECIO_PROVEEDOR` DOUBLE NOT NULL,
  INDEX `fk_PROVEEDOR_has_PRODUCTO_PROVEEDOR1_idx` (`ID_PROVEEDOR` ASC) VISIBLE,
  CONSTRAINT `fk_PROVEEDOR_has_PRODUCTO_PROVEEDOR1`
    FOREIGN KEY (`ID_PROVEEDOR`)
    REFERENCES `CyberiaStore`.`PROVEEDOR` (`ID_PROVEEDOR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROVEEDOR_has_PRODUCTO_PRODUCTO1`
    FOREIGN KEY (`ID_PRODUCTO`)
    REFERENCES `CyberiaStore`.`PRODUCTO` (`ID_PRODUCTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_X_MARCA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_X_MARCA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_X_MARCA` (
  `ID_PRODUCTO` INT NOT NULL,
  `ID_MARCA` INT NOT NULL,
  INDEX `fk_PRODUCTO_has_MARCA_MARCA1_idx` (`ID_MARCA` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTO_has_MARCA_PRODUCTO1`
    FOREIGN KEY (`ID_PRODUCTO`)
    REFERENCES `CyberiaStore`.`PRODUCTO` (`ID_PRODUCTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_has_MARCA_MARCA1`
    FOREIGN KEY (`ID_MARCA`)
    REFERENCES `CyberiaStore`.`MARCA` (`ID_MARCA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_X_SEDE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_X_SEDE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_X_SEDE` (
  `ID_SEDE` INT NOT NULL,
  `ID_PRODUCTO` INT NOT NULL,
  `STOCK_SEDE` INT NOT NULL,
  INDEX `fk_PRODUCTO_has_SEDE_SEDE1_idx` (`ID_SEDE` ASC) VISIBLE,
  INDEX `fk_PRODUCTO_has_SEDE_PRODUCTO1_idx` (`ID_PRODUCTO` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTO_has_SEDE_PRODUCTO1`
    FOREIGN KEY (`ID_PRODUCTO`)
    REFERENCES `CyberiaStore`.`PRODUCTO` (`ID_PRODUCTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_has_SEDE_SEDE1`
    FOREIGN KEY (`ID_SEDE`)
    REFERENCES `CyberiaStore`.`SEDE` (`ID_SEDE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Table `CyberiaStore`.`LINEA_PEDIDO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`LINEA_PEDIDO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`LINEA_PEDIDO` (
  `ID_LINEA_PEDIDO` INT NOT NULL AUTO_INCREMENT,
  `ID_PRODUCTO` INT NOT NULL,
  `NUM_LINEA` INT NOT NULL,
  `CANTIDAD` INT NOT NULL,
  PRIMARY KEY (`ID_LINEA_PEDIDO`, `ID_PRODUCTO`),
  INDEX `fk_PRODUCTO_has_PEDIDO_PRODUCTO1_idx` (`ID_PRODUCTO` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTO_has_PEDIDO_PRODUCTO1`
    FOREIGN KEY (`ID_PRODUCTO`)
    REFERENCES `CyberiaStore`.`PRODUCTO` (`ID_PRODUCTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  PRIMARY KEY (`ID_OFERTA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PRODUCTO_X_OFERTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PRODUCTO_X_OFERTA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PRODUCTO_X_OFERTA` (
  `ID_PRODUCTO` INT NOT NULL,
  `OFERTA_ID_OFERTA` INT NOT NULL,
  INDEX `fk_PRODUCTO_has_OFERTA_OFERTA1_idx` (`OFERTA_ID_OFERTA` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTO_has_OFERTA_PRODUCTO1`
    FOREIGN KEY (`ID_PRODUCTO`)
    REFERENCES `CyberiaStore`.`PRODUCTO` (`ID_PRODUCTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_has_OFERTA_OFERTA1`
    FOREIGN KEY (`OFERTA_ID_OFERTA`)
    REFERENCES `CyberiaStore`.`OFERTA` (`ID_OFERTA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  INDEX `fk_METODO_PAGO_PEDIDO1_idx` (`ID_PEDIDO` ASC) VISIBLE,
  INDEX `fk_METODO_PAGO_OFERTA1_idx` (`ID_OFERTA` ASC) VISIBLE,
  CONSTRAINT `fk_METODO_PAGO_PEDIDO1`
    FOREIGN KEY (`ID_PEDIDO`)
    REFERENCES `CyberiaStore`.`PEDIDO` (`ID_PEDIDO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_METODO_PAGO_OFERTA1`
    FOREIGN KEY (`ID_OFERTA`)
    REFERENCES `CyberiaStore`.`OFERTA` (`ID_OFERTA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  UNIQUE INDEX `NUMERO_BOLETA_UNIQUE` (`NUMERO_BOLETA` ASC) VISIBLE,
  INDEX `fk_BOLETA_METODO_PAGO1_idx` (`ID_COMPROBANTE_DE_PAGO` ASC) VISIBLE,
  CONSTRAINT `fk_BOLETA_METODO_PAGO1`
    FOREIGN KEY (`ID_COMPROBANTE_DE_PAGO`)
    REFERENCES `CyberiaStore`.`COMPROBANTE_DE_PAGO` (`ID_COMPROBANTE_DE_PAGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`FACTURA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`FACTURA` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`FACTURA` (
  `ID_FACTURA` INT NOT NULL AUTO_INCREMENT,
  `NUMERO_FACTURA` VARCHAR(8) NOT NULL,
  `RAZON_SOCIAL` VARCHAR(45) NOT NULL,
  `DIRECCION` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  `ID_COMPROBANTE_DE_PAGO` INT NOT NULL,
  PRIMARY KEY (`ID_FACTURA`, `ID_COMPROBANTE_DE_PAGO`),
  INDEX `fk_FACTURA_METODO_PAGO1_idx` (`ID_COMPROBANTE_DE_PAGO` ASC) VISIBLE,
  UNIQUE INDEX `NUMERO_FACTURA_UNIQUE` (`NUMERO_FACTURA` ASC) VISIBLE,
  CONSTRAINT `fk_FACTURA_METODO_PAGO1`
    FOREIGN KEY (`ID_COMPROBANTE_DE_PAGO`)
    REFERENCES `CyberiaStore`.`COMPROBANTE_DE_PAGO` (`ID_COMPROBANTE_DE_PAGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`USUARIO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`USUARIO` (
  `ID_USUARIO` INT NOT NULL AUTO_INCREMENT,
  `DOCUMENTO` VARCHAR(10) NOT NULL,
  `TELEFONO` VARCHAR(13) NOT NULL,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `APELLIDO_MATERNO` VARCHAR(45) NOT NULL,
  `APELLIDO_PATERNO` VARCHAR(45) NOT NULL,
  `FECHA_NACIMIENTO` DATE NOT NULL,
  `CORREO` VARCHAR(45) NOT NULL,
  `DIRECCION` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  `CONTRASEÑA` VARCHAR(256) NOT NULL,
  `NACIONALIDAD` VARCHAR(45) NOT NULL,
  `TIPO_DOCUMENTO` VARCHAR(45) NOT NULL,
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
  PRIMARY KEY (`ID_CLIENTE`, `ID_USUARIO`),
  INDEX `fk_CLIENTE_USUARIO1_idx` (`ID_USUARIO` ASC) VISIBLE,
  CONSTRAINT `fk_CLIENTE_USUARIO1`
    FOREIGN KEY (`ID_USUARIO`)
    REFERENCES `CyberiaStore`.`USUARIO` (`ID_USUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`BOLETA_X_CLIENTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`BOLETA_X_CLIENTE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`BOLETA_X_CLIENTE` (
  `ID_BOLETA` INT NOT NULL,
  `ID_CLIENTE` INT NOT NULL,
  INDEX `fk_BOLETA_has_CLIENTE_CLIENTE1_idx` (`ID_CLIENTE` ASC) VISIBLE,
  CONSTRAINT `fk_BOLETA_has_CLIENTE_BOLETA1`
    FOREIGN KEY (`ID_BOLETA`)
    REFERENCES `CyberiaStore`.`BOLETA` (`ID_BOLETA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BOLETA_has_CLIENTE_CLIENTE1`
    FOREIGN KEY (`ID_CLIENTE`)
    REFERENCES `CyberiaStore`.`CLIENTE` (`ID_CLIENTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`FACTURA_X_CLIENTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`FACTURA_X_CLIENTE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`FACTURA_X_CLIENTE` (
  `ID_FACTURA` INT NOT NULL,
  `ID_CLIENTE` INT NOT NULL,
  INDEX `fk_FACTURA_has_CLIENTE_CLIENTE1_idx` (`ID_CLIENTE` ASC) VISIBLE,
  INDEX `fk_FACTURA_has_CLIENTE_FACTURA1_idx` (`ID_FACTURA` ASC) VISIBLE,
  CONSTRAINT `fk_FACTURA_has_CLIENTE_FACTURA1`
    FOREIGN KEY (`ID_FACTURA`)
    REFERENCES `CyberiaStore`.`FACTURA` (`ID_FACTURA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURA_has_CLIENTE_CLIENTE1`
    FOREIGN KEY (`ID_CLIENTE`)
    REFERENCES `CyberiaStore`.`CLIENTE` (`ID_CLIENTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `ID_ROL` INT NOT NULL,
  INDEX `fk_USUARIO_has_ROL_ROL1_idx` (`ID_ROL` ASC) VISIBLE,
  CONSTRAINT `fk_USUARIO_has_ROL_USUARIO1`
    FOREIGN KEY (`ID_USUARIO`)
    REFERENCES `CyberiaStore`.`USUARIO` (`ID_USUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USUARIO_has_ROL_ROL1`
    FOREIGN KEY (`ID_ROL`)
    REFERENCES `CyberiaStore`.`ROL` (`ID_ROL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `ID_PERMISO` INT NOT NULL,
  INDEX `fk_ROL_has_PERMISO_PERMISO1_idx` (`ID_PERMISO` ASC) VISIBLE,
  INDEX `fk_ROL_has_PERMISO_ROL1_idx` (`ID_ROL` ASC) VISIBLE,
  CONSTRAINT `fk_ROL_has_PERMISO_ROL1`
    FOREIGN KEY (`ID_ROL`)
    REFERENCES `CyberiaStore`.`ROL` (`ID_ROL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ROL_has_PERMISO_PERMISO1`
    FOREIGN KEY (`ID_PERMISO`)
    REFERENCES `CyberiaStore`.`PERMISO` (`ID_PERMISO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  PRIMARY KEY (`ID_TRABAJADOR`, `ID_USUARIO`),
  INDEX `fk_TRABAJADOR_USUARIO1_idx` (`ID_USUARIO` ASC) VISIBLE,
  CONSTRAINT `fk_TRABAJADOR_USUARIO1`
    FOREIGN KEY (`ID_USUARIO`)
    REFERENCES `CyberiaStore`.`USUARIO` (`ID_USUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`TRABAJADOR_X_SEDE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`TRABAJADOR_X_SEDE` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`TRABAJADOR_X_SEDE` (
  `ID_SEDE` INT NOT NULL,
  `ID_TRABAJADOR` INT NOT NULL,
  INDEX `fk_SEDE_has_TRABAJADOR_SEDE1_idx` (`ID_SEDE` ASC) VISIBLE,
  INDEX `fk_SEDE_has_TRABAJADOR_TRABAJADOR1_idx` (`ID_TRABAJADOR` ASC) VISIBLE,
  CONSTRAINT `fk_SEDE_has_TRABAJADOR_SEDE1`
    FOREIGN KEY (`ID_SEDE`)
    REFERENCES `CyberiaStore`.`SEDE` (`ID_SEDE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SEDE_has_TRABAJADOR_TRABAJADOR1`
    FOREIGN KEY (`ID_TRABAJADOR`)
    REFERENCES `CyberiaStore`.`TRABAJADOR` (`ID_TRABAJADOR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`ADMINISTRADOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`ADMINISTRADOR` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`ADMINISTRADOR` (
  `ID-ADMINISTRADOR` INT NOT NULL AUTO_INCREMENT,
  `ID_TRABAJADOR` INT NOT NULL,
  PRIMARY KEY (`ID-ADMINISTRADOR`, `ID_TRABAJADOR`),
  CONSTRAINT `fk_ADMINISTRADOR_TRABAJADOR1`
    FOREIGN KEY (`ID_TRABAJADOR`)
    REFERENCES `CyberiaStore`.`TRABAJADOR` (`ID_TRABAJADOR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`ALMACENERO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`ALMACENERO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`ALMACENERO` (
  `ID_ALMACENERO` INT NOT NULL AUTO_INCREMENT,
  `ID_TRABAJADOR` INT NOT NULL,
  PRIMARY KEY (`ID_ALMACENERO`, `ID_TRABAJADOR`),
  CONSTRAINT `fk_ALMACENERO_TRABAJADOR1`
    FOREIGN KEY (`ID_TRABAJADOR`)
    REFERENCES `CyberiaStore`.`TRABAJADOR` (`ID_TRABAJADOR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`VENDEDOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`VENDEDOR` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`VENDEDOR` (
  `ID_VENDEDOR` INT NOT NULL AUTO_INCREMENT,
  `ID_TRABAJADOR` INT NOT NULL,
  PRIMARY KEY (`ID_VENDEDOR`, `ID_TRABAJADOR`),
  CONSTRAINT `fk_VENDEDOR_TRABAJADOR1`
    FOREIGN KEY (`ID_TRABAJADOR`)
    REFERENCES `CyberiaStore`.`TRABAJADOR` (`ID_TRABAJADOR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CyberiaStore`.`PEDIDO_X_LINEA_PEDIDO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CyberiaStore`.`PEDIDO_X_LINEA_PEDIDO` ;

CREATE TABLE IF NOT EXISTS `CyberiaStore`.`PEDIDO_X_LINEA_PEDIDO` (
  `ID_PEDIDO` INT NOT NULL,
  `ID_LINEA_PEDIDO` INT NOT NULL,
  PRIMARY KEY (`ID_PEDIDO`, `ID_LINEA_PEDIDO`),
  INDEX `fk_PEDIDO_has_LINEA_PEDIDO_LINEA_PEDIDO1_idx` (`ID_LINEA_PEDIDO` ASC) VISIBLE,
  INDEX `fk_PEDIDO_has_LINEA_PEDIDO_PEDIDO1_idx` (`ID_PEDIDO` ASC) VISIBLE,
  CONSTRAINT `fk_PEDIDO_has_LINEA_PEDIDO_PEDIDO1`
    FOREIGN KEY (`ID_PEDIDO`)
    REFERENCES `CyberiaStore`.`PEDIDO` (`ID_PEDIDO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PEDIDO_has_LINEA_PEDIDO_LINEA_PEDIDO1`
    FOREIGN KEY (`ID_LINEA_PEDIDO`)
    REFERENCES `CyberiaStore`.`LINEA_PEDIDO` (`ID_LINEA_PEDIDO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
