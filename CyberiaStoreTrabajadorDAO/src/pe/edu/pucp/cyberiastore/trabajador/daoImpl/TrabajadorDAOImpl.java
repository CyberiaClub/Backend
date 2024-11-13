package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;

import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorXSedeDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.usuario.dao.UsuarioDAO;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.UsuarioDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;

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
        Integer idUsuario = null;
        Usuario usuario = new Usuario();
//        usuario.setDocumento(this.trabajador.getDocumento());
//        usuario.setTelefono(this.trabajador.getTelefono());
//        usuario.setNombre(this.trabajador.getNombre());
//        usuario.setApellidoPaterno(this.trabajador.getApellidoPaterno());
//        usuario.setApellidoMaterno(this.trabajador.getApellidoMaterno());
//        usuario.setSexo(this.trabajador.getSexo());
//        usuario.setFechaDeNacimiento(this.trabajador.getFechaDeNacimiento());
//        usuario.setCorreo(this.trabajador.getCorreo());
//        usuario.setActivo(this.trabajador.getActivo());
//        usuario.setContrasena(this.trabajador.getContrasena());
//        usuario.setNacionalidad(this.trabajador.getNacionalidad());
//        usuario.setDireccion(this.trabajador.getDireccion());
//        usuario.setTipoDeDocumento(this.trabajador.getTipoDeDocumento());
        usuario.setRol(this.trabajador.getRol());
        usuario.setIdUsuario(this.trabajador.getIdUsuario());
        
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Boolean existeUsuario = usuarioDAO.existeUsuario(usuario);
        Boolean existeTrabajador = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            
            usuarioDAO.modificarRol(usuario, this.usarTransaccion, this.conexion);
            this.trabajador.setIdUsuario(idUsuario);
            Boolean abreConexion = false;
            existeTrabajador = this.existeTrabajador(this.trabajador, abreConexion);

            if (!existeTrabajador) {
                this.retornarLlavePrimaria = true;
                idTrabajador = super.insertar();
                this.trabajador.setIdTrabajador(idTrabajador);
                this.retornarLlavePrimaria = false;
                // pasamos llamar a la clase TRABAJADORXSEDE
                TrabajadorXSedeDAO trabajadorXSede = new TrabajadorXSedeDAOImpl();
                trabajadorXSede.insertar(idTrabajador, this.trabajador.getIdSede(), this.usarTransaccion, this.conexion);
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

    /*
     * *************************************************************************
     * MODIFICAR
    *************************************************************************
     */
    @Override
    public Integer modificar(Trabajador trabajador) {
        Integer retorno = 0;
        this.trabajador = trabajador;
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(this.trabajador.getIdUsuario());
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

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            usuarioDAO.modificar(usuario, this.usarTransaccion, this.conexion);
            retorno = super.modificar();
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar modificar - " + ex);
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
        return retorno;
    }

    @Override
    public Integer modificar(Trabajador trabajador, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.modificar(trabajador);
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "ID_TRABAJADOR=?";
        } else {
            sql = "TRA.ID_TRABAJADOR=?";
        }
        return sql;
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "SUELDO=?, FECHA_INGRESO=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroDouble(1, this.trabajador.getSueldo());
        this.incluirParametroDate(2, this.trabajador.getFechaDeIngreso());
        // Este puede fallar porque esta relacionado al obtener por ID
        // este es para la comparacion de id_trabajador= ?
        this.incluirParametroInt(3, this.trabajador.getIdTrabajador());
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
        this.trabajador = trabajador;
        Integer idTrabajador = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select ID_TRABAJADOR from TRABAJADOR where ";
            sql = sql.concat("ID_TRABAJADOR=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.trabajador.getIdTrabajador());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idTrabajador = this.resultSet.getInt("ID_ADMINISTRADOR");
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
}
