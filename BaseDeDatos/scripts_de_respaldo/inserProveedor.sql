select * from cyberiastore.producto;

INSERT INTO cyberiastore.PROVEEDOR ( RUC, RAZON_SOCIAL, NOMBRE_DEL_CONTACTO, CORREO, TELEFONO, DIRECCION, DESCRIPCION, ACTIVO)
VALUES ( '12345678901', 'Distribuidora Escolar S.A.', 'Juan Pérez', 'contacto@distribuidoraescolar.com', '987654321', 'Av. Los Próceres 123, Lima', 'Proveedor de útiles escolares variados para colegios e instituciones', 1);

select * from cyberiastore.tipo_producto;

select * from cyberiastore.producto;

SET FOREIGN_KEY_CHECKS = 0;
truncate table producto;
truncate table producto_x_marca;
truncate table producto_x_sede;
truncate table producto_x_proveedor;
SET FOREIGN_KEY_CHECKS = 1;