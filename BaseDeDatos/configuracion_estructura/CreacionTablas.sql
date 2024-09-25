-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cyberiastore
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cyberiastore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cyberiastore` DEFAULT CHARACTER SET utf8 ;
USE `cyberiastore` ;

-- -----------------------------------------------------
-- Table `cyberiastore`.`PROVEEDOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`PROVEEDOR` (
  `RUC` VARCHAR(20) NOT NULL,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `FECHA_REGISTRO` DATE NOT NULL,
  PRIMARY KEY (`RUC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`PRODUCTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`PRODUCTO` (
  `SKU` INT NOT NULL,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `DESCRIPCION` VARCHAR(45) NOT NULL,
  `PRECIO` DOUBLE NOT NULL,
  `UNIDAD` VARCHAR(45) NOT NULL,
  `ACTIVO` TINYINT NOT NULL,
  PRIMARY KEY (`SKU`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`EMPRESA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`EMPRESA` (
  `RUC` VARCHAR(20) NOT NULL,
  `RAZON_SOCIAL` VARCHAR(45) NOT NULL,
  `DIRECCION` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`RUC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`SEDE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`SEDE` (
  `ID_SEDE` INT NOT NULL,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `DESCRIPCION` VARCHAR(45) NOT NULL,
  `EMPRESA_RUC` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ID_SEDE`, `EMPRESA_RUC`),
  INDEX `fk_SEDE_EMPRESA1_idx` (`EMPRESA_RUC` ASC) VISIBLE,
  CONSTRAINT `fk_SEDE_EMPRESA1`
    FOREIGN KEY (`EMPRESA_RUC`)
    REFERENCES `cyberiastore`.`EMPRESA` (`RUC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`MARCA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`MARCA` (
  `ID_MARCA` INT NOT NULL,
  `NOMBRE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_MARCA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`TIPO_PRODUCTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`TIPO_PRODUCTO` (
  `ID_TIPO_PRODUCTO` INT NOT NULL,
  `TIPO` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_TIPO_PRODUCTO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`PRODUCTO_COMPUESTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`PRODUCTO_COMPUESTO` (
  `SKU_PAQUETE` INT NOT NULL,
  `SKU_PRODUCTO` INT NOT NULL,
  PRIMARY KEY (`SKU_PAQUETE`, `SKU_PRODUCTO`),
  INDEX `fk_PRODUCTO_has_PRODUCTO_PRODUCTO1_idx` (`SKU_PRODUCTO` ASC) VISIBLE,
  INDEX `fk_PRODUCTO_has_PRODUCTO_PRODUCTO_idx` (`SKU_PAQUETE` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTO_has_PRODUCTO_PRODUCTO`
    FOREIGN KEY (`SKU_PAQUETE`)
    REFERENCES `cyberiastore`.`PRODUCTO` (`SKU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_has_PRODUCTO_PRODUCTO1`
    FOREIGN KEY (`SKU_PRODUCTO`)
    REFERENCES `cyberiastore`.`PRODUCTO` (`SKU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`PRODUCTO_X_TIPO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`PRODUCTO_X_TIPO` (
  `ID_TIPO_PRODUCTO` INT NOT NULL,
  `PRODUCTO_SKU` INT NOT NULL,
  PRIMARY KEY (`ID_TIPO_PRODUCTO`, `PRODUCTO_SKU`),
  INDEX `fk_TIPO_PRODUCTO_has_PRODUCTO_PRODUCTO1_idx` (`PRODUCTO_SKU` ASC) VISIBLE,
  INDEX `fk_TIPO_PRODUCTO_has_PRODUCTO_TIPO_PRODUCTO1_idx` (`ID_TIPO_PRODUCTO` ASC) VISIBLE,
  CONSTRAINT `fk_TIPO_PRODUCTO_has_PRODUCTO_TIPO_PRODUCTO1`
    FOREIGN KEY (`ID_TIPO_PRODUCTO`)
    REFERENCES `cyberiastore`.`TIPO_PRODUCTO` (`ID_TIPO_PRODUCTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TIPO_PRODUCTO_has_PRODUCTO_PRODUCTO1`
    FOREIGN KEY (`PRODUCTO_SKU`)
    REFERENCES `cyberiastore`.`PRODUCTO` (`SKU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`PRODUCTO_X_PROVEEDOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`PRODUCTO_X_PROVEEDOR` (
  `PROVEEDOR_RUC` VARCHAR(20) NOT NULL,
  `PRODUCTO_SKU` INT NOT NULL,
  `PRECIO_PROVEEDOR` DOUBLE NOT NULL,
  PRIMARY KEY (`PROVEEDOR_RUC`, `PRODUCTO_SKU`),
  INDEX `fk_PROVEEDOR_has_PRODUCTO_PRODUCTO1_idx` (`PRODUCTO_SKU` ASC) VISIBLE,
  INDEX `fk_PROVEEDOR_has_PRODUCTO_PROVEEDOR1_idx` (`PROVEEDOR_RUC` ASC) VISIBLE,
  CONSTRAINT `fk_PROVEEDOR_has_PRODUCTO_PROVEEDOR1`
    FOREIGN KEY (`PROVEEDOR_RUC`)
    REFERENCES `cyberiastore`.`PROVEEDOR` (`RUC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROVEEDOR_has_PRODUCTO_PRODUCTO1`
    FOREIGN KEY (`PRODUCTO_SKU`)
    REFERENCES `cyberiastore`.`PRODUCTO` (`SKU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`PRODUCTO_X_MARCA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`PRODUCTO_X_MARCA` (
  `PRODUCTO_SKU` INT NOT NULL,
  `ID_MARCA` INT NOT NULL,
  PRIMARY KEY (`PRODUCTO_SKU`, `ID_MARCA`),
  INDEX `fk_PRODUCTO_has_MARCA_MARCA1_idx` (`ID_MARCA` ASC) VISIBLE,
  INDEX `fk_PRODUCTO_has_MARCA_PRODUCTO1_idx` (`PRODUCTO_SKU` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTO_has_MARCA_PRODUCTO1`
    FOREIGN KEY (`PRODUCTO_SKU`)
    REFERENCES `cyberiastore`.`PRODUCTO` (`SKU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_has_MARCA_MARCA1`
    FOREIGN KEY (`ID_MARCA`)
    REFERENCES `cyberiastore`.`MARCA` (`ID_MARCA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`PRODUCTO_X_SEDE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`PRODUCTO_X_SEDE` (
  `ID_SEDE` INT NOT NULL,
  `PRODUCTO_SKU` INT NOT NULL,
  `STOCK_SEDE` INT NOT NULL,
  PRIMARY KEY (`ID_SEDE`, `PRODUCTO_SKU`),
  INDEX `fk_PRODUCTO_has_SEDE_SEDE1_idx` (`ID_SEDE` ASC) VISIBLE,
  INDEX `fk_PRODUCTO_has_SEDE_PRODUCTO1_idx` (`PRODUCTO_SKU` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTO_has_SEDE_PRODUCTO1`
    FOREIGN KEY (`PRODUCTO_SKU`)
    REFERENCES `cyberiastore`.`PRODUCTO` (`SKU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_has_SEDE_SEDE1`
    FOREIGN KEY (`ID_SEDE`)
    REFERENCES `cyberiastore`.`SEDE` (`ID_SEDE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`PEDIDO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`PEDIDO` (
  `ID_PEDIDO` INT NOT NULL,
  `ESTADO` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_PEDIDO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`LINEA_PEDIDO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`LINEA_PEDIDO` (
  `PRODUCTO_SKU` INT NOT NULL,
  `PEDIDO_ID_PEDIDO` INT NOT NULL,
  `ID_LINEA_PEDIDO` INT NOT NULL,
  `NUM_LINEA` INT NOT NULL,
  PRIMARY KEY (`PRODUCTO_SKU`, `PEDIDO_ID_PEDIDO`, `ID_LINEA_PEDIDO`),
  INDEX `fk_PRODUCTO_has_PEDIDO_PEDIDO1_idx` (`PEDIDO_ID_PEDIDO` ASC) VISIBLE,
  INDEX `fk_PRODUCTO_has_PEDIDO_PRODUCTO1_idx` (`PRODUCTO_SKU` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTO_has_PEDIDO_PRODUCTO1`
    FOREIGN KEY (`PRODUCTO_SKU`)
    REFERENCES `cyberiastore`.`PRODUCTO` (`SKU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_has_PEDIDO_PEDIDO1`
    FOREIGN KEY (`PEDIDO_ID_PEDIDO`)
    REFERENCES `cyberiastore`.`PEDIDO` (`ID_PEDIDO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`OFERTA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`OFERTA` (
  `ID_OFERTA` INT NOT NULL,
  `FECHA_INICIO` DATE NOT NULL,
  `FECHA_FIN` DATE NOT NULL,
  `PORCENTAJE` INT NOT NULL,
  PRIMARY KEY (`ID_OFERTA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`PRODUCTO_has_OFERTA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`PRODUCTO_has_OFERTA` (
  `PRODUCTO_SKU` INT NOT NULL,
  `OFERTA_ID_OFERTA` INT NOT NULL,
  PRIMARY KEY (`PRODUCTO_SKU`, `OFERTA_ID_OFERTA`),
  INDEX `fk_PRODUCTO_has_OFERTA_OFERTA1_idx` (`OFERTA_ID_OFERTA` ASC) VISIBLE,
  INDEX `fk_PRODUCTO_has_OFERTA_PRODUCTO1_idx` (`PRODUCTO_SKU` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTO_has_OFERTA_PRODUCTO1`
    FOREIGN KEY (`PRODUCTO_SKU`)
    REFERENCES `cyberiastore`.`PRODUCTO` (`SKU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_has_OFERTA_OFERTA1`
    FOREIGN KEY (`OFERTA_ID_OFERTA`)
    REFERENCES `cyberiastore`.`OFERTA` (`ID_OFERTA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`METODO_PAGO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`METODO_PAGO` (
  `ID_METODO_PAGO` INT NOT NULL AUTO_INCREMENT,
  `FECHA` DATE NOT NULL,
  `SUBTOTAL` DOUBLE NOT NULL,
  `IGV` DOUBLE NOT NULL,
  `TOTAL` DOUBLE NOT NULL,
  `DESCUENTO_APLICADO` DOUBLE NOT NULL,
  `ID_PEDIDO` INT NOT NULL,
  `ID_OFERTA` INT NOT NULL,
  PRIMARY KEY (`ID_METODO_PAGO`, `ID_PEDIDO`, `ID_OFERTA`),
  INDEX `fk_METODO_PAGO_PEDIDO1_idx` (`ID_PEDIDO` ASC) VISIBLE,
  INDEX `fk_METODO_PAGO_OFERTA1_idx` (`ID_OFERTA` ASC) VISIBLE,
  CONSTRAINT `fk_METODO_PAGO_PEDIDO1`
    FOREIGN KEY (`ID_PEDIDO`)
    REFERENCES `cyberiastore`.`PEDIDO` (`ID_PEDIDO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_METODO_PAGO_OFERTA1`
    FOREIGN KEY (`ID_OFERTA`)
    REFERENCES `cyberiastore`.`OFERTA` (`ID_OFERTA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`BOLETA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`BOLETA` (
  `NUMERO_BOLETA` INT NOT NULL,
  `ID_METODO_PAGO` INT NOT NULL,
  PRIMARY KEY (`NUMERO_BOLETA`, `ID_METODO_PAGO`),
  INDEX `fk_BOLETA_METODO_PAGO1_idx` (`ID_METODO_PAGO` ASC) VISIBLE,
  CONSTRAINT `fk_BOLETA_METODO_PAGO1`
    FOREIGN KEY (`ID_METODO_PAGO`)
    REFERENCES `cyberiastore`.`METODO_PAGO` (`ID_METODO_PAGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`FACTURA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`FACTURA` (
  `NUMERO_FACTURA` INT NOT NULL,
  `RUC` VARCHAR(20) NOT NULL,
  `RAZON_SOCIAL` VARCHAR(45) NOT NULL,
  `DIRECCION` VARCHAR(45) NOT NULL,
  `ID_METODO_PAGO` INT NOT NULL,
  PRIMARY KEY (`NUMERO_FACTURA`, `ID_METODO_PAGO`),
  INDEX `fk_FACTURA_METODO_PAGO1_idx` (`ID_METODO_PAGO` ASC) VISIBLE,
  CONSTRAINT `fk_FACTURA_METODO_PAGO1`
    FOREIGN KEY (`ID_METODO_PAGO`)
    REFERENCES `cyberiastore`.`METODO_PAGO` (`ID_METODO_PAGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`USUARIO` (
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
  PRIMARY KEY (`DOCUMENTO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`CLIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`CLIENTE` (
  `ID_CLIENTE` INT NOT NULL,
  `VERIFICADO` TINYINT NOT NULL,
  `ID_USUARIO` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`, `ID_USUARIO`),
  INDEX `fk_CLIENTE_USUARIO1_idx` (`ID_USUARIO` ASC) VISIBLE,
  CONSTRAINT `fk_CLIENTE_USUARIO1`
    FOREIGN KEY (`ID_USUARIO`)
    REFERENCES `cyberiastore`.`USUARIO` (`DOCUMENTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`BOLETA_X_CLIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`BOLETA_X_CLIENTE` (
  `NUMERO_BOLETA` INT NOT NULL,
  `CLIENTE_ID_CLIENTE` INT NOT NULL,
  PRIMARY KEY (`NUMERO_BOLETA`, `CLIENTE_ID_CLIENTE`),
  INDEX `fk_BOLETA_has_CLIENTE_CLIENTE1_idx` (`CLIENTE_ID_CLIENTE` ASC) VISIBLE,
  INDEX `fk_BOLETA_has_CLIENTE_BOLETA1_idx` (`NUMERO_BOLETA` ASC) VISIBLE,
  CONSTRAINT `fk_BOLETA_has_CLIENTE_BOLETA1`
    FOREIGN KEY (`NUMERO_BOLETA`)
    REFERENCES `cyberiastore`.`BOLETA` (`NUMERO_BOLETA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BOLETA_has_CLIENTE_CLIENTE1`
    FOREIGN KEY (`CLIENTE_ID_CLIENTE`)
    REFERENCES `cyberiastore`.`CLIENTE` (`ID_CLIENTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`FACTURA_has_CLIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`FACTURA_has_CLIENTE` (
  `NUMERO_FACTURA` INT NOT NULL,
  `CLIENTE_ID_CLIENTE` INT NOT NULL,
  PRIMARY KEY (`NUMERO_FACTURA`, `CLIENTE_ID_CLIENTE`),
  INDEX `fk_FACTURA_has_CLIENTE_CLIENTE1_idx` (`CLIENTE_ID_CLIENTE` ASC) VISIBLE,
  INDEX `fk_FACTURA_has_CLIENTE_FACTURA1_idx` (`NUMERO_FACTURA` ASC) VISIBLE,
  CONSTRAINT `fk_FACTURA_has_CLIENTE_FACTURA1`
    FOREIGN KEY (`NUMERO_FACTURA`)
    REFERENCES `cyberiastore`.`FACTURA` (`NUMERO_FACTURA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURA_has_CLIENTE_CLIENTE1`
    FOREIGN KEY (`CLIENTE_ID_CLIENTE`)
    REFERENCES `cyberiastore`.`CLIENTE` (`ID_CLIENTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`ROL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`ROL` (
  `ID_ROL` INT NOT NULL,
  `NOMBRE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_ROL`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`ROL_X_USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`ROL_X_USUARIO` (
  `USUARIO_DOCUMENTO` VARCHAR(10) NOT NULL,
  `ID_ROL` INT NOT NULL,
  PRIMARY KEY (`USUARIO_DOCUMENTO`, `ID_ROL`),
  INDEX `fk_USUARIO_has_ROL_ROL1_idx` (`ID_ROL` ASC) VISIBLE,
  INDEX `fk_USUARIO_has_ROL_USUARIO1_idx` (`USUARIO_DOCUMENTO` ASC) VISIBLE,
  CONSTRAINT `fk_USUARIO_has_ROL_USUARIO1`
    FOREIGN KEY (`USUARIO_DOCUMENTO`)
    REFERENCES `cyberiastore`.`USUARIO` (`DOCUMENTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USUARIO_has_ROL_ROL1`
    FOREIGN KEY (`ID_ROL`)
    REFERENCES `cyberiastore`.`ROL` (`ID_ROL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`PERMISO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`PERMISO` (
  `ID_PERMISO` INT NOT NULL,
  `NOMBRE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_PERMISO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`PERMISO_X_ROL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`PERMISO_X_ROL` (
  `ID_ROL` INT NOT NULL,
  `ID_PERMISO` INT NOT NULL,
  PRIMARY KEY (`ID_ROL`, `ID_PERMISO`),
  INDEX `fk_ROL_has_PERMISO_PERMISO1_idx` (`ID_PERMISO` ASC) VISIBLE,
  INDEX `fk_ROL_has_PERMISO_ROL1_idx` (`ID_ROL` ASC) VISIBLE,
  CONSTRAINT `fk_ROL_has_PERMISO_ROL1`
    FOREIGN KEY (`ID_ROL`)
    REFERENCES `cyberiastore`.`ROL` (`ID_ROL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ROL_has_PERMISO_PERMISO1`
    FOREIGN KEY (`ID_PERMISO`)
    REFERENCES `cyberiastore`.`PERMISO` (`ID_PERMISO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`TIPO_TRABAJADOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`TIPO_TRABAJADOR` (
  `idTIPO_TRABAJADOR` INT NOT NULL AUTO_INCREMENT,
  `TIPO` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTIPO_TRABAJADOR`),
  UNIQUE INDEX `TIPO_UNIQUE` (`TIPO` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`TRABAJADOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`TRABAJADOR` (
  `ID_TRABAJADOR` INT NOT NULL,
  `SUELDO` DOUBLE NOT NULL,
  `FECHA_INGRESO` DATE NOT NULL,
  `FECHA_SALIDA` DATE NULL,
  `USUARIO_DOCUMENTO` VARCHAR(10) NOT NULL,
  `TIPO_TRABAJADOR_idTIPO_TRABAJADOR` INT NOT NULL,
  PRIMARY KEY (`ID_TRABAJADOR`, `USUARIO_DOCUMENTO`, `TIPO_TRABAJADOR_idTIPO_TRABAJADOR`),
  INDEX `fk_TRABAJADOR_USUARIO1_idx` (`USUARIO_DOCUMENTO` ASC) VISIBLE,
  INDEX `fk_TRABAJADOR_TIPO_TRABAJADOR1_idx` (`TIPO_TRABAJADOR_idTIPO_TRABAJADOR` ASC) VISIBLE,
  CONSTRAINT `fk_TRABAJADOR_USUARIO1`
    FOREIGN KEY (`USUARIO_DOCUMENTO`)
    REFERENCES `cyberiastore`.`USUARIO` (`DOCUMENTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TRABAJADOR_TIPO_TRABAJADOR1`
    FOREIGN KEY (`TIPO_TRABAJADOR_idTIPO_TRABAJADOR`)
    REFERENCES `cyberiastore`.`TIPO_TRABAJADOR` (`idTIPO_TRABAJADOR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cyberiastore`.`TRABAJADOR_X_SEDE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cyberiastore`.`TRABAJADOR_X_SEDE` (
  `ID_SEDE` INT NOT NULL,
  `ID_TRABAJADOR` INT NOT NULL,
  PRIMARY KEY (`ID_SEDE`, `ID_TRABAJADOR`),
  INDEX `fk_SEDE_has_TRABAJADOR_TRABAJADOR1_idx` (`ID_TRABAJADOR` ASC) VISIBLE,
  INDEX `fk_SEDE_has_TRABAJADOR_SEDE1_idx` (`ID_SEDE` ASC) VISIBLE,
  CONSTRAINT `fk_SEDE_has_TRABAJADOR_SEDE1`
    FOREIGN KEY (`ID_SEDE`)
    REFERENCES `cyberiastore`.`SEDE` (`ID_SEDE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SEDE_has_TRABAJADOR_TRABAJADOR1`
    FOREIGN KEY (`ID_TRABAJADOR`)
    REFERENCES `cyberiastore`.`TRABAJADOR` (`ID_TRABAJADOR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
