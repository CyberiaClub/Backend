package pe.edu.pucp.cyberiastore.persona.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.persona.dao.PersonaDAO;
import pe.edu.pucp.cyberiastore.persona.model.Persona;
import java.util.List;
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
     * Insertar
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
                    this.enviarCorreoVerificacion(this.persona.getCorreo(),this.token.getValor());
                }
            }
            case INSERTAR_TRABAJADOR -> {
                this.modificar(persona);
                id = persona.getIdPersona();
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
    public Integer modificar(Persona persona) {
        this.tipoOperacionPersona = (persona.getIdSede() == null)
                ? TipoOperacionPersona.MODIFICAR_PERSONA
                : TipoOperacionPersona.INSERTAR_TRABAJADOR;
        this.persona = persona;
        return super.modificar();
    }

    @Override
    public Integer modificar(Persona persona, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.modificar(persona);
    }

    @Override
    public Integer marcarVerificado(String valorToken) {
        this.tipoOperacionPersona = TipoOperacionPersona.MARCAR_VERIFICADO;
        this.token = new Token();
        this.persona = new Persona();

        this.token.setValor(valorToken);
        TokenDAO tokenDAO = new TokenDAOImpl();
        this.token = tokenDAO.buscarTokenPorValor(this.token);
        tokenDAO.eliminar(this.token);
        this.persona.setIdPersona(this.token.getIdPersona());

        if (this.token.getActivo() == false) {
            return -1;
        } else {
            return super.modificar();
        }
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        switch (tipoOperacionPersona) {
            case LISTAR_PERSONA_POR_DOCUMENTO ->
                sql = sql.concat("DOCUMENTO=?");
            case MODIFICAR_PERSONA ->
                sql = sql.concat("ID_PERSONA=? ");
            case INSERTAR_TRABAJADOR->
                sql = sql.concat("ID_PERSONA=? ");
            case MARCAR_VERIFICADO ->
                sql = sql.concat("ID_PERSONA=? ");
            case VERIFICAR_PERSONA->{
                sql = sql.concat("CORREO = ? ");
                sql = sql.concat("AND CONTRASEÑA = ? ");
            }
            default ->
                throw new AssertionError();
        }
        return sql;
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        String sql = "";
        switch (this.tipoOperacionPersona) {
            case MODIFICAR_PERSONA ->
                sql = sql.concat("TELEFONO=?,CORREO=?,DIRECCION=?,CONTRASEÑA=? ");
            case INSERTAR_TRABAJADOR ->
                sql = sql.concat("SUELDO=?,FECHA_INGRESO=sysdate() ,ID_TIPO_PERSONA=?,ID_SEDE=? ");
            case MARCAR_VERIFICADO ->
                sql = sql.concat("VERIFICADO=? ");
            default ->
                throw new AssertionError();
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        switch (this.tipoOperacionPersona) {
            case MODIFICAR_PERSONA -> {
                this.incluirParametroString(1, this.persona.getTelefono());
                this.incluirParametroString(2, this.persona.getCorreo());
                this.incluirParametroString(3, this.persona.getDireccion());
                this.incluirParametroString(4, this.persona.getContrasena());
                this.incluirParametroInt(5, this.persona.getIdSede());
            }
            case INSERTAR_TRABAJADOR -> {
                this.incluirParametroDouble(1, this.persona.getSueldo());
                this.incluirParametroInt(2, this.persona.getIdPersona());
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "";
        switch (tipoOperacionPersona) {
            case LISTAR_PERSONA_POR_DOCUMENTO ->
                sql = sql.concat("ID_PERSONA,NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO,TELEFONO, DIRECCION");
            case VERIFICAR_PERSONA->{
                sql = sql.concat("CASE ");
                sql = sql.concat("WHEN VERIFICADO = 1 AND ID_SEDE IS NULL THEN 'CLIENTE' ");
                sql = sql.concat("WHEN VERIFICADO = 1 AND ID_SEDE IS NOT NULL THEN 'TRABAJADOR' ");
                sql = sql.concat("WHEN VERIFICADO = 0 THEN 'NO_VERIFICADO' ");
                sql = sql.concat("ELSE '' ");
                sql = sql.concat("END AS RESULTADO ");
            }
            default ->
                throw new AssertionError();
        }
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        switch (this.tipoOperacionPersona) {
            case VERIFICAR_PERSONA->{
                this.persona.setNombre(this.resultSet.getString("RESULTADO"));
            }
            case LISTAR_PERSONA_POR_DOCUMENTO->{
                this.persona.setIdPersona(this.resultSet.getInt("ID_PERSONA"));
                this.persona.setNombre(this.resultSet.getString("NOMBRE"));
                this.persona.setCorreo(this.resultSet.getString("CORREO"));
                this.persona.setTelefono(this.resultSet.getString("TELEFONO"));
                this.persona.setDireccion(this.resultSet.getString("DIRECCION"));
            }
            default->
                throw new AssertionError();
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
        super.obtenerPorId();
        return this.persona;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        switch (tipoOperacionPersona) {
            case LISTAR_PERSONA_POR_DOCUMENTO ->
                this.incluirParametroString(1, this.persona.getDocumento());
            case VERIFICAR_PERSONA ->{
                this.incluirParametroString(1,this.persona.getCorreo());
                this.incluirParametroString(2,this.persona.getContrasena());
            }
            default ->
                throw new AssertionError();
        }
    }

    /*
     * **************************************************************************
     * EXISTE USUARIO
     * y funciones adicionales
     * *************************************************************************
     */
    @Override
    public Boolean existePersona(Persona persona) {
        this.persona = persona;
        Integer idPersona = null;
        try {
            this.abrirConexion();
            String sql = "select ID_PERSONA from PERSONA where ";
            sql = sql.concat("APELLIDO_PATERNO=? ");
            sql = sql.concat("and APELLIDO_MATERNO=? ");
            sql = sql.concat("and NOMBRE=? ");
            sql = sql.concat("and DOCUMENTO=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.persona.getPrimerApellido());
            this.incluirParametroString(2, this.persona.getSegundoApellido());
            this.incluirParametroString(3, this.persona.getNombre());
            this.incluirParametroString(4, this.persona.getDocumento());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idPersona = this.resultSet.getInt("ID_PERSONA");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe persona - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.persona.setIdPersona(idPersona);
        return idPersona != null;
    }

    /*
     * **************************************************************************
     * ENVIO DE CORREOS
     * *************************************************************************
     */
    @Override
    public Boolean enviarCorreoVerificacion(String correo, String valorToken) {
        EnvioDeCorreo enviarCorreo = new EnvioDeCorreo();
        return enviarCorreo.enviarCorreoVerificacion(correo,valorToken);
    }

    /*
     * **************************************************************************
     * VERIFICACION DE CORREO
     * *************************************************************************
     */
    @Override
    public String verificarPersona(Persona persona) {
        this.persona = persona;
        this.tipoOperacionPersona = TipoOperacionPersona.VERIFICAR_PERSONA;
        super.obtenerPorId();
        if ("".equals(this.persona.getNombre())) {
            return null;
        }
        return this.persona.getNombre();
    }
}
