package pe.edu.pucp.cyberiastore.persona.daoImpl;

public enum TipoOperacionPersona {
    INSERTAR_CLIENTE, // Insercion de un nuevo cliente
    INSERTAR_TRABAJADOR, // El cliente va a convertirse a trabajador
    MODIFICAR_PERSONA, // Modificacion general, independiente si es cliente o trabajador.
    ELIMINAR_CLIENTE,
    ELIMINAR_TRABAJADOR,
    LISTAR_CLIENTE,
    LISTAR_TRABAJADOR,
    LISTAR_PERSONA_POR_DOCUMENTO,
    MARCAR_VERIFICADO,
    VERIFICAR_PERSONA,
    LISTAR_PAGINAS,
    LISTAR_TIPO_TRABAJADORES,
}
