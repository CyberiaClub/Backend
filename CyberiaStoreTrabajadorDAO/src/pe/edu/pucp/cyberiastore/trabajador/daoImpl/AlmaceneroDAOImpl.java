package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.model.Almacenero;
import pe.edu.pucp.cyberiastore.trabajador.dao.AlmaceneroDAO;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;

public class AlmaceneroDAOImpl extends DAOImpl implements AlmaceneroDAO {

    private Almacenero almacenero;

    public AlmaceneroDAOImpl() {
        super("ALMACENERO");
        this.almacenero = null;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "ID_TRABAJADOR";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.almacenero.getIdTrabajador());
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
    public Integer insertar(Almacenero almacenero) {
        this.almacenero = almacenero;
        Integer idTrabajador = null;// el ID de la clase que hereda
        Trabajador trabajador = new Trabajador();// traemos la clase padre
        trabajador.setSueldo(almacenero.getSueldo());
        trabajador.setFechaDeIngreso(almacenero.getFechaDeIngreso());
        trabajador.setIdSede(almacenero.getIdSede());
        trabajador.setDocumento(almacenero.getDocumento());
        trabajador.setTelefono(almacenero.getTelefono());
        trabajador.setNombre(almacenero.getNombre());
        trabajador.setApellidoPaterno(almacenero.getApellidoPaterno());
        trabajador.setApellidoMaterno(almacenero.getApellidoMaterno());
        trabajador.setFechaDeNacimiento(almacenero.getFechaDeNacimiento());
        trabajador.setCorreo(almacenero.getCorreo());
        trabajador.setContrasena(almacenero.getContrasena());
        trabajador.setNacionalidad(almacenero.getNacionalidad());
        trabajador.setDireccion(almacenero.getDireccion());
        trabajador.setTipoDeDocumento(almacenero.getTipoDeDocumento());
        
        TrabajadorDAO trabajadorDAO = new TrabajadorDAOImpl();
        
        Boolean existeTrabajador = trabajadorDAO.existeTrabajador(trabajador);
        Boolean existeAlmacenero = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeTrabajador) {
                idTrabajador = trabajadorDAO.insertar(trabajador, this.usarTransaccion, this.conexion);
                this.almacenero.setIdTrabajador(idTrabajador);
            } else {
                idTrabajador = trabajador.getIdTrabajador();
                this.almacenero.setIdTrabajador(idTrabajador);
                Boolean abreConexion = false;
                existeAlmacenero = this.existeAlmacenero(this.almacenero, abreConexion);
            }
            if (!existeAlmacenero) {
                super.insertar();
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar Almacenero " + ex);
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

    @Override
    public Integer modificar(Almacenero almacenero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Almacenero almacenero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Almacenero> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Almacenero obtenerPorId(Integer idAlmacenero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existeAlmacenero(Almacenero almacenero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existeAlmacenero(Almacenero almacenero, Boolean abreConexion) {
        this.almacenero = almacenero;
        Integer idVendedor = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select id_almacenero from almacenero where ";
            sql = sql.concat("id_trabajador=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.almacenero.getIdTrabajador());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idVendedor = this.resultSet.getInt("id_almacenero");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe almacenero - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idVendedor != null;
    }

//    @Override
//    public Integer insertar(Almacenero almacenero) {
//        this.almacenero = almacenero;
//        Integer id = super.insertar();
//        this.almacenero.setIdAlmacenero(id);
//        return id;
//        
//    }
//
//    @Override
//    public Integer modificar(Almacenero almacenero) {
//        this.almacenero = almacenero;
//        return super.modificar();
//    }
//
//    @Override
//    public ArrayList<Almacenero> listarTodosAdministradores() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Almacenero obtenerPorId(Integer idAdministrador) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void insertarIdAlmacenero(Integer idAlmacenero) {
//        this.almacenero.setIdAlmacenero(idAlmacenero);
//    }
//    //Funciones para la logica de BD
//    @Override
//    protected String obtenerListaAtributos(){
//    }
//    
//    @Override
//    protected String obtenerListaValoresParaInsertar(){
//        String sql ="";
//        sql = sql.concat("'" + this.almacenero.getIdTrabajador() + "'");
//        return sql;
//    }
}
