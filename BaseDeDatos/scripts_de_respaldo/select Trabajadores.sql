use cyberiastore;
select * from administrador;
select * from trabajador;
select * from usuario;

select 
AD.ID_TRABAJADOR, 
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
S.NOMBRE as SEDE_NOMBRE
from
administrador AD,
trabajador TR,
usuario US,
trabajador_x_sede TRXS,
sede S
where Ad.id_trabajador = TR.ID_TRABAJADOR
and TR.id_usuario = US.id_usuario
and TR.ID_TRABAJADOR = TRXS.ID_TRABAJADOR
and TRXS.id_sede = S.ID_SEDE ;
