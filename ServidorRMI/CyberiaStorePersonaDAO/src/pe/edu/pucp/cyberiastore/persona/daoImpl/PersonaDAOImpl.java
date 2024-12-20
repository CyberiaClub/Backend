package pe.edu.pucp.cyberiastore.persona.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.persona.dao.PersonaDAO;
import pe.edu.pucp.cyberiastore.persona.model.Persona;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.persona.model.Token;
import pe.edu.pucp.cyberiastore.persona.dao.TokenDAO;
import pe.edu.pucp.cyberiastore.persona.daoImpl.TokenDAOImpl;
import pe.edu.pucp.cyberiastore.util.EnvioDeCorreo;

public class PersonaDAOImpl extends DAOImpl implements PersonaDAO {

    private Persona persona;
    private TipoOperacionPersona tipoOperacionPersona;
    private Token token;

    public PersonaDAOImpl() {
        super("PERSONA");
        this.persona = null;
        this.tipoOperacionPersona = null;
    }

    /*
     * ************************************************************************
     * INSERTAR
     * ************************************************************************
     */
    /**
     * Funcion que viene de PersonaDAO.
     *
     * Aquí también se define si queremos que se retorne la llave primaria o no
     *
     * @param persona: este tiene que contener todos sus atributos ya cargados
     * @return
     */
    @Override
    public Integer insertar(Persona persona) {
        this.tipoOperacionPersona = persona.getIdSede() == null ? TipoOperacionPersona.INSERTAR_CLIENTE : TipoOperacionPersona.INSERTAR_TRABAJADOR;
        this.persona = persona;
        Integer id = null;
        this.token = new Token();
        switch (this.tipoOperacionPersona) {
            case INSERTAR_CLIENTE -> {

                this.retornarLlavePrimaria = true;
                id = super.insertar();
                this.retornarLlavePrimaria = false;

                if (id != 0) {
                    this.token.setIdPersona(id);
                    TokenDAO tokenDAO = new TokenDAOImpl();
                    tokenDAO.insertar(this.token);
                    this.enviarCorreoVerificacion(this.persona.getCorreo(), this.token.getValor());
                }
                this.tipo_Operacion = null;
            }
            case INSERTAR_TRABAJADOR -> {
                this.modificarTrabajador(persona);
                id = persona.getIdPersona();
                this.tipoOperacionPersona = null;
            }
            default ->
                throw new AssertionError();
        }

        return id;
    }

    /**
     * Funcion definida en PersonaDAO Usada para la insersión de datos por medio
     * de herencia.
     *
     * @param persona
     * @param usarTransaccion
     * @param conexion
     * @return
     */
    @Override
    public Integer insertar(Persona persona, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(persona);
    }

    /**
     * En la lógica prevista, solo insertarmos el TipoDePersonaCliente
     *
     * @return
     */
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "DOCUMENTO, TELEFONO, NOMBRE,PRIMER_APELLIDO, SEGUNDO_APELLIDO,FECHA_NACIMIENTO, SEXO, CORREO, "
                + "DIRECCION, CONTRASEÑA,NACIONALIDAD, TIPO_DOCUMENTO,ID_TIPO_PERSONA";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.persona.getDocumento());
        this.incluirParametroString(2, this.persona.getTelefono());
        this.incluirParametroString(3, this.persona.getNombre());
        this.incluirParametroString(4, this.persona.getPrimerApellido());
        this.incluirParametroString(5, this.persona.getSegundoApellido());
        this.incluirParametroDate(6, this.persona.getFechaDeNacimiento());
        this.incluirParametroString(7, this.persona.getSexo() + "");
        this.incluirParametroString(8, this.persona.getCorreo());
        this.incluirParametroString(9, this.persona.getDireccion());
        this.incluirParametroString(10, this.persona.getContrasena());
        this.incluirParametroString(11, this.persona.getNacionalidad());
        this.incluirParametroString(12, this.persona.getTipoDeDocumento().toString());
        this.incluirParametroInt(13, this.persona.getIdTipoPersona());
    }

    /*
     * **************************************************************************
     * MODIFICAR
     * *************************************************************************
     */
    /**
     * @param persona
     * @return
     */
    @Override
    public Integer modificarUsuario(Persona persona) {
        this.tipoOperacionPersona = TipoOperacionPersona.MODIFICAR_PERSONA;
        this.persona = persona;
        Integer resultado = super.modificar();
        this.tipoOperacionPersona = null;
        return resultado;
    }

    public Integer modificarTrabajador(Persona persona) {
        this.tipoOperacionPersona = TipoOperacionPersona.INSERTAR_TRABAJADOR;
        this.persona = persona;
        Integer resultado = super.modificar();
        this.tipoOperacionPersona = null;
        return resultado;
    }

    @Override
    public Integer modificar(Persona persona) {
        this.persona = persona;
        return super.modificar();
    }

    @Override
    public Integer modificar(Persona persona, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        Integer resultado = super.modificar();
        this.tipo_Operacion = null;
        return resultado;
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";

        if (this.tipoOperacionPersona != null) {
            switch (tipoOperacionPersona) {
                case LISTAR_PERSONA_POR_DOCUMENTO ->
                    sql = sql.concat(" DOCUMENTO=? ");
                case MODIFICAR_PERSONA ->
                    sql = sql.concat("ID_PERSONA=? ");
                case INSERTAR_TRABAJADOR ->
                    sql = sql.concat(" DOCUMENTO=? ");
                case MARCAR_VERIFICADO ->
                    sql = sql.concat("ID_PERSONA=? ");
                case VERIFICAR_PERSONA -> {
                    sql = sql.concat(" TP.ID_TIPO_PERSONA = P.ID_TIPO_PERSONA ");
                    sql = sql.concat(" AND P.VERIFICADO = 1  ");
                    sql = sql.concat(" AND P.ACTIVO = 1  ");
                    sql = sql.concat(" AND CORREO = ? ");
                    sql = sql.concat(" AND CONTRASEÑA = ? ");
                }
            }
        }
        return sql;
    }

    @Override
    protected String obtenerPredicadoParaListado() {
        String sql = "";
        if (this.tipoOperacionPersona != null) {
            switch (this.tipoOperacionPersona) {
                case LISTAR_PERSONA_POR_DOCUMENTO -> {
                    sql = "";
                }
                case VERIFICAR_PERSONA -> {
                    sql = sql.concat(" P, TIPO_PERSONA TP ");
                }
                default ->
                    throw new AssertionError();
            }
        }
        return sql;
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        String sql = "";
        if (this.tipoOperacionPersona != null) {
            switch (this.tipoOperacionPersona) {
                case MODIFICAR_PERSONA ->
                    sql = sql.concat("TELEFONO=?,CORREO=?,DIRECCION=? ");
                case INSERTAR_TRABAJADOR ->
                    sql = sql.concat(" SUELDO=?,FECHA_INGRESO=sysdate() ,ID_TIPO_PERSONA=?,ID_SEDE=? ");
                case MARCAR_VERIFICADO ->
                    sql = sql.concat("VERIFICADO=? ");
                default ->
                    throw new AssertionError();
            }
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        if (this.tipoOperacionPersona != null) {
            switch (this.tipoOperacionPersona) {
                case MODIFICAR_PERSONA -> {
                    this.incluirParametroString(1, this.persona.getTelefono());
                    this.incluirParametroString(2, this.persona.getCorreo());
                    this.incluirParametroString(3, this.persona.getDireccion());
                    this.incluirParametroInt(4, this.persona.getIdPersona());
                }
                case INSERTAR_TRABAJADOR -> {
                    this.incluirParametroDouble(1, this.persona.getSueldo());
                    this.incluirParametroInt(2, this.persona.getIdTipoPersona());
                    this.incluirParametroInt(3, this.persona.getIdSede());
                    this.incluirParametroString(4, this.persona.getDocumento());
                }
                case MARCAR_VERIFICADO -> {
                    this.incluirParametroInt(1, 1);
                    this.incluirParametroInt(2, this.persona.getIdPersona());
                }
                default ->
                    throw new AssertionError();
            }
        }
    }

    /*
     * **************************************************************************
     * VERIFICACION DE CORREO
     * *************************************************************************
     */
    @Override
    public Integer marcarVerificado(String valorToken) {
        this.token = new Token();
        this.persona = new Persona();

        this.token.setValor(valorToken);
        TokenDAO tokenDAO = new TokenDAOImpl();
        this.token = tokenDAO.buscarTokenPorValor(this.token);
        tokenDAO.eliminar(this.token);
        this.persona.setIdPersona(this.token.getIdPersona());
        this.tipoOperacionPersona = TipoOperacionPersona.MARCAR_VERIFICADO;
        if (this.token.getActivo() == false) {
            return -1;
        } else {
            Integer resultado = super.modificar();
            this.tipoOperacionPersona = null;
            return resultado;
        }
    }

    /*
     * **************************************************************************
     * ELIMINIAR
     * *************************************************************************
     */
    @Override
    public Integer eliminar(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Persona persona, Boolean usarTransaccion, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * **************************************************************************
     * LISTAR TODOS
     * *************************************************************************
     */
    /**
     * Nuestro ListarTodos solo llama a los clientes
     *
     * @return
     */
    @Override
    public ArrayList<Persona> listarTodos() {
        this.tipo_Operacion = Tipo_Operacion.LISTAR;
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "";
        if (this.tipoOperacionPersona != null) {
            switch (tipoOperacionPersona) {
                case LISTAR_PERSONA_POR_DOCUMENTO -> {
                    sql = sql.concat("CONCAT(PRIMER_APELLIDO, ' ', COALESCE(SEGUNDO_APELLIDO, ''), ',',NOMBRE) AS NOMBRE_COMPLETO, ");
                    sql = sql.concat("CORREO, TELEFONO, DIRECCION ");
                }
                case VERIFICAR_PERSONA -> {
                    sql = sql.concat("CASE WHEN P.ID_SEDE IS NULL THEN 0 ");
                    sql = sql.concat("ELSE P.ID_SEDE END AS ID_SEDE, ");
                    sql = sql.concat("P.ID_PERSONA, P.DOCUMENTO, P.DIRECCION, P.TELEFONO, ");
                    sql = sql.concat("P.NOMBRE, P.PRIMER_APELLIDO, P.SEGUNDO_APELLIDO, ");
                    sql = sql.concat("P.CORREO, TP.NOMBRE AS TIPO_USUARIO ");
                }
            }
        }

        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        if (this.tipoOperacionPersona != null) {
            switch (this.tipoOperacionPersona) {
                case VERIFICAR_PERSONA -> {
                    this.persona.setIdSede(this.resultSet.getInt("ID_SEDE"));
                    this.persona.setIdPersona(this.resultSet.getInt("ID_PERSONA"));
                    this.persona.setDocumento(this.resultSet.getString("DOCUMENTO"));
                    this.persona.setDireccion(this.resultSet.getString("DIRECCION"));
                    this.persona.setTelefono(this.resultSet.getString("TELEFONO"));
                    this.persona.setNombre(this.resultSet.getString("NOMBRE"));
                    this.persona.setPrimerApellido(this.resultSet.getString("PRIMER_APELLIDO"));
                    this.persona.setSegundoApellido(this.resultSet.getString("SEGUNDO_APELLIDO"));
                    this.persona.setCorreo(this.resultSet.getString("CORREO"));
                    this.persona.setTipoUsuario(this.resultSet.getString("TIPO_USUARIO"));
                }
                case LISTAR_PERSONA_POR_DOCUMENTO -> {
                    this.persona.setNombre(this.resultSet.getString("NOMBRE_COMPLETO"));
                    this.persona.setCorreo(this.resultSet.getString("CORREO"));
                    this.persona.setTelefono(this.resultSet.getString("TELEFONO"));
                    this.persona.setDireccion(this.resultSet.getString("DIRECCION"));
                }
            }
        }
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.persona = null;
    }

    /*
     * **************************************************************************
     * OBTENER POR DOCUMENTO
     * *************************************************************************
     */
    @Override
    public Persona obtenerPorDocumento(String documento) {
        this.persona = new Persona();
        this.persona.setDocumento(documento);
        this.tipoOperacionPersona = TipoOperacionPersona.LISTAR_PERSONA_POR_DOCUMENTO;
        super.buscar();
        this.tipoOperacionPersona = null;
        return this.persona;
    }

    @Override
    protected void incluirValorDeParametrosParaBuscar() throws SQLException {
        if (this.tipoOperacionPersona != null) {
            switch (tipoOperacionPersona) {
                case LISTAR_PERSONA_POR_DOCUMENTO ->
                    this.incluirParametroString(1, this.persona.getDocumento());
                case VERIFICAR_PERSONA -> {
                    this.incluirParametroString(1, this.persona.getCorreo());
                    this.incluirParametroString(2, this.persona.getContrasena());
                }
            }
        }
    }

    /*
     * **************************************************************************
     * ENVIO DE CORREOS
     * *************************************************************************
     */
    @Override
    public Boolean enviarCorreoVerificacion(String correo, String valorToken) {
        EnvioDeCorreo enviarCorreo = new EnvioDeCorreo();
        return enviarCorreo.enviarCorreoVerificacion(correo, valorToken);
    }

    /*
     * **************************************************************************
     * VERIFICACION AL INGRESAR
     * **************************************************************************
     */
    @Override
    public Persona verificarPersona(Persona persona) {
        this.persona = persona;
        this.tipoOperacionPersona = TipoOperacionPersona.VERIFICAR_PERSONA;
        super.buscar();
        this.tipoOperacionPersona = null;
        return this.persona;
    }
}
