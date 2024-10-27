use cyberiastore;
select * from administrador;
select * from trabajador;
select * from usuario;
select * from sede;
select * from trabajador_x_sede;

SELECT 
    AD.ID_ADMINISTRADOR,
    TR.ID_TRABAJADOR,
    US.ID_USUARIO,
    US.NOMBRE,
    US.APELLIDO_PATERNO,
    US.APELLIDO_MATERNO,
    US.DOCUMENTO,
    US.FECHA_NACIMIENTO,
    US.TELEFONO,
    US.CORREO,
    US.NACIONALIDAD,
    US.TIPO_DOCUMENTO,
    TR.SUELDO,
    TR.FECHA_INGRESO,
    S.NOMBRE AS SEDE_NOMBRE
FROM 
    administrador AD
JOIN trabajador TR ON AD.ID_TRABAJADOR = TR.ID_TRABAJADOR
JOIN usuario US ON TR.ID_USUARIO = US.ID_USUARIO
JOIN trabajador_x_sede TRXS ON TR.ID_TRABAJADOR = TRXS.ID_TRABAJADOR
JOIN sede S ON TRXS.ID_SEDE = S.ID_SEDE;
