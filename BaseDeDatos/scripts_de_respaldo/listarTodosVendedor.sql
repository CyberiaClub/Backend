use cyberiastore;
/*
Sentencias SQL para poder listar todos los vendedores y listarlos por su ID
*/
SELECT 
    VEN.ID_VENDEDOR,
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
    vendedor VEN
JOIN trabajador TR ON VEN.ID_TRABAJADOR = TR.ID_TRABAJADOR
JOIN usuario US ON TR.ID_USUARIO = US.ID_USUARIO
JOIN trabajador_x_sede TRXS ON TR.ID_TRABAJADOR = TRXS.ID_TRABAJADOR
JOIN sede S ON TRXS.ID_SEDE = S.ID_SEDE
WHERE US.ACTIVO = 1;

SELECT 
    VEN.ID_VENDEDOR,
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
    vendedor VEN
JOIN trabajador TR ON VEN.ID_TRABAJADOR = TR.ID_TRABAJADOR
JOIN usuario US ON TR.ID_USUARIO = US.ID_USUARIO
JOIN trabajador_x_sede TRXS ON TR.ID_TRABAJADOR = TRXS.ID_TRABAJADOR
JOIN sede S ON TRXS.ID_SEDE = S.ID_SEDE
where US.ACTIVO = 1
AND VEN.ID_VENDEDOR= 1; /*El 1 se debe de cambiar por ? en JAVA, para listar por cualquier ID*/