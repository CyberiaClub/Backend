package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;

import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorXSedeDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.usuario.dao.UsuarioDAO;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.UsuarioDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class TrabajadorDAOImpl extends DAOImpl implements TrabajadorDAO {

    private Trabajador trabajador;

    public TrabajadorDAOImpl() {
        super("Trabajador");
        this.trabajador = null;
        this.retornarLlavePrimaria = true;
    }

    /**
     * Este temotod sirve prinicipalmente para hacer la insercion del trabajador
     * propiamente y de su padre usuario
     *
     * @param Trabajador
     * @return
     */
    @Override
    public Integer insertar(Trabajador Trabajador) {
        this.trabajador = trabajador;
        Integer idTrabajador = null;
        Trabajador usuario = new Trabajador();

        usuario.setDocumento(this.trabajador.getDocumento());
        usuario.setTelefono(this.trabajador.getTelefono());
        usuario.setNombre(this.trabajador.getNombre());
        usuario.setApellidoPaterno(this.trabajador.getApellidoPaterno());
        usuario.setApellidoMaterno(this.trabajador.getApellidoMaterno());
        usuario.setFechaDeNacimiento(this.trabajador.getFechaDeNacimiento());
        usuario.setCorreo(this.trabajador.getCorreo());
        usuario.setActivo(this.trabajador.getActivo());
        usuario.setContrasena(this.trabajador.getContrasena());
        usuario.setNacionalidad(this.trabajador.getNacionalidad());
        usuario.setDireccion(this.trabajador.getDireccion());
        usuario.setTipoDeDocumento(this.trabajador.getTipoDeDocumento());

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Boolean existeUsuario = usuarioDAO.existeUsuario(usuario);
        Boolean existeTrabajador = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeUsuario) {
                idTrabajador = usuarioDAO.insertar(usuario, this.usarTransaccion, this.conexion);
                this.trabajador.setIdUsuario(idTrabajador);
            } else {
                idTrabajador = usuario.getIdUsuario();
                this.trabajador.setIdUsuario(idTrabajador);
                Boolean abreConexion = false;
                existeTrabajador = this.existeTrabajador(this.trabajador, abreConexion);
            }
            if (!existeTrabajador) {
                this.retornarLlavePrimaria = true;
                idTrabajador = super.insertar();
                this.trabajador.setIdTrabajador(idTrabajador);
                this.retornarLlavePrimaria = false;
                // pasamos llamar a la clase TRABAJADORXSEDE
                TrabajadorXSedeDAO trabajadorXSede = new TrabajadorXSedeDAOImpl();
                trabajadorXSede.insertar(idTrabajador, this.trabajador.getIdSede());
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar - " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al intentar hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
        this.usarTransaccion = true;
        return idTrabajador;
    }

    /**
     * Este método se define en la clase DAO, y sirve para recibir los datos del
     * hijo
     *
     * @param Trabajador
     * @param usarTransaccion
     * @param conexion
     * @return
     */
    @Override
    public Integer insertar(Trabajador Trabajador, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(Trabajador);
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "SUELDO, FECHA_INGRESO, ID_USUARIO";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroDouble(1, this.trabajador.getSueldo());
        this.incluirParametroDate(2, this.trabajador.getFechaDeIngreso());
        this.incluirParametroInt(3, this.trabajador.getIdUsuario());
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
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

    @Override
    public Integer modificar(Trabajador Trabajador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Trabajador Trabajador, Boolean usarTransaccion, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Trabajador Trabajador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Trabajador Trabajador, Boolean usarTransaccion, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Trabajador> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Trabajador obtenerPorId(Integer idTrabajador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existeTrabajador(Trabajador Trabajador) {
        Boolean abreConexion = true;
        return existeTrabajador(Trabajador, abreConexion);
    }

    @Override
    public Boolean existeTrabajador(Trabajador trabajador, Boolean abreConexion) {
        ;
        this.trabajador = trabajador;
        Integer idTrabajador = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select id_trabajador from trabajador where ";
            sql = sql.concat("id_trabajador=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.trabajador.getIdTrabajador());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idTrabajador = this.resultSet.getInt("idAdministrador");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe alumno - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idTrabajador != null;
    }

//
//    @Override
//    public Integer insertar(Trabajador trabajador) {
//        this.trabajador = trabajador;
//        Integer id = super.insertar();
//        trabajador.setIdTrabajador(id);
//        return id;
//    }
//
//    @Override
//    protected String obtenerListaAtributos() {
//    }
//
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String sql = "";
//        sql = sql.concat("'" + this.trabajador.getSueldo() + "'");
//        sql = sql.concat(",");
//        sql = sql.concat("STR_TO_DATE('" + this.trabajador.fechaDeIngresoAsDDMMYYY() + "','%d-%m-%Y')");
//        sql = sql.concat(",");
//        sql = sql.concat("'" + this.trabajador.getIdUsuario() + "'");
//        return sql;
//    }
//
//    @Override
//    public Integer modificar(Trabajador trabajador) {
//        this.trabajador = trabajador;
//        return super.modificar();
//    }
//
//    @Override
//    public Integer eliminar() {
//        this.trabajador.setActivo(false);
//        return super.eliminar();
//    }
//
//    /**
//     *
//     * @param sql
//     * @return
//     */
//    public ArrayList<Trabajador> listarTrabajador(String sql) {
//        ArrayList<Trabajador> listaTrabajador = new ArrayList();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            this.abrirConexion();
//            this.ejecutarConsultaEnBD(sql);
//            while (this.resultSet.next()) {
//                Trabajador trabajadorTemp = new Trabajador(
//                        //public Trabajador(Double sueldo, Date fechaDeIngreso, Date fechaDeSalida, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
//                        this.resultSet.getDouble("SUELDO"),
//                        sdf.parse(this.resultSet.getString("FECHA_DE_INGRESO")),
//                        //                        sdf.parse(this.resultSet.getString("FECHA_DE_SALIDA")),
//
//                        this.resultSet.getString("DOCUMENTO"),
//                        this.resultSet.getString("TELEFONO"),
//                        this.resultSet.getString("NOMBRE"),
//                        this.resultSet.getString("APELLIDO_MATERNO"),
//                        this.resultSet.getString("APELLIDO_PATERNO"),
//                        sdf.parse(this.resultSet.getString("FECHA_NACIMIENTO")),
//                        this.resultSet.getString("CORREO"),
//                        (this.resultSet.getInt("ACTIVO") == 1),
//                        this.resultSet.getString("CONTRASEÑA"),
//                        this.resultSet.getString("NACIONALIDAD"),
//                        this.resultSet.getString("DIRECCION"),
//                        TipoDocumento.valueOf(this.resultSet.getString("idEspecialidad"))
//                );
//                listaTrabajador.add(trabajadorTemp);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                this.cerrarConexion();
//            } catch (SQLException ex) {
//                Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return listaTrabajador;
//    }
//
//    @Override
//    public ArrayList<Trabajador> listarTodosTrabajador() {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        return this.listarTrabajador(sql);
//    }
//
//    @Override
//    public Trabajador obtenerPorId(Integer idTrabajador) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat("where DOCUMENTO = '" + idTrabajador + "'");
//        return listarTrabajador(sql).getFirst();
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        String sql = "";
//        sql = sql.concat(" ID_TRABAJADOR = ");
//        sql = sql.concat("'" + this.trabajador.getIdTrabajador() + "';");
//        return sql;
//    }
//
//    @Override
//    public void insertarIdUsuario(Integer idUsuario) {
//        this.trabajador.setIdUsuario(idUsuario);
//    }
//
//    @Override
//    public void insertarIdTrabajador(Integer idtrabajador) {
//        this.trabajador.setIdTrabajador(idtrabajador);
//    }
}
