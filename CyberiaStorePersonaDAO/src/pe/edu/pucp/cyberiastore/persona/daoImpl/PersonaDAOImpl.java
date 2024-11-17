package pe.edu.pucp.cyberiastore.persona.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.persona.dao.PersonaDAO;
import pe.edu.pucp.cyberiastore.persona.model.Persona;
import java.util.List;

public class PersonaDAOImpl extends DAOImpl implements PersonaDAO {

    private Persona persona;
    private TipoOperacionPersona tipoOperacionPersona;

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
        switch (this.tipoOperacionPersona) {
            case INSERTAR_CLIENTE -> {
                this.retornarLlavePrimaria = true;
                id = super.insertar();
                this.retornarLlavePrimaria = false;
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
        return "DOCUMENTO, TELEFONO, NOMBRE,PRIMER_APELLIDO, SEGUNDO_APELLIDO,FECHA_NACIMIENTO, SEXO, CORREO, DIRECCION, CONTRASEÑA,NACIONALIDAD, TIPO_DOCUMENTO,ID_TIPO_PERSONA";
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
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        switch (tipoOperacionPersona) {
            case LISTAR_PERSONA_POR_DOCUMENTO ->
                sql = sql.concat("DOCUMENTO='?'");
            case MODIFICAR_PERSONA ->
                sql = sql.concat("ID_PERSONA=? ");
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
                sql = sql.concat("TELEFONO=?,CORREO=?,DIRECCION=?,CONTRASEÑA=?");
            case INSERTAR_TRABAJADOR ->
                sql = sql.concat("SUELDO=?,FECHA_INGRESO=?,ID_TIPO_PERSONA=?,ID_SEDE=?");
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
                this.incluirParametroDate(2, this.persona.getFechaIngreso());
                this.incluirParametroInt(3, this.persona.getIdPersona());
                this.incluirParametroInt(4, this.persona.getIdSede());
                this.incluirParametroString(5, this.persona.getDocumento());
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
//        return (ArrayList<Persona>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "";
        switch (tipoOperacionPersona) {
            case LISTAR_PERSONA_POR_DOCUMENTO ->
                sql = sql.concat("NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, TELEFONO, DIRECCION");
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            String sql = "select id_persona from persona where ";
            sql = sql.concat("apellido_paterno=? ");
            sql = sql.concat("and apellido_materno=? ");
            sql = sql.concat("and nombre=? ");
            sql = sql.concat("and documento=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.persona.getPrimerApellido());
            this.incluirParametroString(2, this.persona.getSegundoApellido());
            this.incluirParametroString(3, this.persona.getNombre());
            this.incluirParametroString(4, this.persona.getDocumento());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idPersona = this.resultSet.getInt("id_persona");
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

}
