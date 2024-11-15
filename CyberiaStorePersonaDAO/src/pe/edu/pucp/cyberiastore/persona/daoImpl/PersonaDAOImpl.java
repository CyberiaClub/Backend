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

    public PersonaDAOImpl() {
        super("USUARIO");
        this.persona = null;
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
        this.persona = persona;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
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

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "DOCUMENTO, TELEFONO, NOMBRE,APELLIDO_PATERNO, APELLIDO_MATERNO,SEXO , FECHA_NACIMIENTO, CORREO, DIRECCION, ACTIVO, CONTRASEÑA, NACIONALIDAD, TIPO_DOCUMENTO,ROL";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.persona.getDocumento());
        this.incluirParametroString(2, this.persona.getTelefono());
        this.incluirParametroString(3, this.persona.getNombre());
        this.incluirParametroString(4, this.persona.getPrimerApellido());
        this.incluirParametroString(5, this.persona.getSegundoApellido());
        this.incluirParametroString(6, this.persona.getSexo() + "");
        this.incluirParametroDate(7, this.persona.getFechaDeNacimiento());
        this.incluirParametroString(8, this.persona.getCorreo());
        this.incluirParametroString(9, this.persona.getDireccion());
        this.incluirParametroBoolean(10, this.persona.getActivo());
        this.incluirParametroString(11, this.persona.getContrasena());
        this.incluirParametroString(12, this.persona.getNacionalidad());
        this.incluirParametroString(13, this.persona.getTipoDeDocumento().toString());
        this.incluirParametroString(14, this.persona.getRol().toString());
    }

    /*
     * **************************************************************************
     * MODIFICAR
     * *************************************************************************
     */
    @Override
    public Integer modificar(Persona persona) {
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
        return "ID_USUARIO=?";
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "DOCUMENTO=?, TELEFONO=?, NOMBRE=?,APELLIDO_PATERNO=?, APELLIDO_MATERNO =?,SEXO=?, FECHA_NACIMIENTO=?, CORREO=?, DIRECCION=?, ACTIVO=?, CONTRASEÑA=?, NACIONALIDAD=?, TIPO_DOCUMENTO=?,ROL=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.persona.getDocumento());
        this.incluirParametroString(2, this.persona.getTelefono());
        this.incluirParametroString(3, this.persona.getNombre());
        this.incluirParametroString(4, this.persona.getPrimerApellido());
        this.incluirParametroString(5, this.persona.getSegundoApellido());
        this.incluirParametroString(6, this.persona.getSexo() + "");
        this.incluirParametroDate(7, this.persona.getFechaDeNacimiento());
        this.incluirParametroString(8, this.persona.getCorreo());
        this.incluirParametroString(9, this.persona.getDireccion());
        this.incluirParametroBoolean(10, this.persona.getActivo());
        this.incluirParametroString(11, this.persona.getContrasena());
        this.incluirParametroString(12, this.persona.getNacionalidad());
        this.incluirParametroString(13, this.persona.getTipoDeDocumento().toString());
        this.incluirParametroString(14, this.persona.getRol().toString());
        // este es para la comparacion de id_persona = ?
        this.incluirParametroInt(15, this.persona.getIdPersona());
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
    @Override
    public ArrayList<Persona> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        return (ArrayList<Persona>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
     * OBTENER POR ID
     * *************************************************************************
     */
    @Override
    public Persona obtenerPorId(Integer idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
