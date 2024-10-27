package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Vendedor;
import pe.edu.pucp.cyberiastore.trabajador.dao.VendedorDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;

public class VendedorDAOImpl extends DAOImpl implements VendedorDAO {

    private Vendedor vendedor;

    public VendedorDAOImpl() {
        super("VENDEDOR");
        this.vendedor = null;
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
        this.incluirParametroInt(1, this.vendedor.getIdTrabajador());
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
    public Integer insertar(Vendedor vendedor) {
        this.vendedor = vendedor;
        Integer idTrabajador = null;
        Trabajador trabajador = new Trabajador();
        trabajador.setSueldo(vendedor.getSueldo());
        trabajador.setFechaDeIngreso(vendedor.getFechaDeIngreso());
        trabajador.setIdSede(vendedor.getIdSede());
        trabajador.setDocumento(vendedor.getDocumento());
        trabajador.setTelefono(vendedor.getTelefono());
        trabajador.setNombre(vendedor.getNombre());
        trabajador.setApellidoPaterno(vendedor.getApellidoPaterno());
        trabajador.setApellidoMaterno(vendedor.getApellidoMaterno());
        trabajador.setFechaDeNacimiento(vendedor.getFechaDeNacimiento());
        trabajador.setCorreo(vendedor.getCorreo());
        trabajador.setContrasena(vendedor.getContrasena());
        trabajador.setNacionalidad(vendedor.getNacionalidad());
        trabajador.setDireccion(vendedor.getDireccion());
        trabajador.setTipoDeDocumento(vendedor.getTipoDeDocumento());

        TrabajadorDAO trabajadorDAO = new TrabajadorDAOImpl();
        Integer idVendedor = null;
        Boolean existeTrabajador = trabajadorDAO.existeTrabajador(trabajador);
        Boolean existeVendedor = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeTrabajador) {
                idTrabajador = trabajadorDAO.insertar(trabajador, this.usarTransaccion, this.conexion);
                this.vendedor.setIdTrabajador(idTrabajador);
            } else {
                idTrabajador = trabajador.getIdTrabajador();
                this.vendedor.setIdTrabajador(idTrabajador);
                Boolean abreConexion = false;
                existeVendedor = this.existeVendedor(this.vendedor, abreConexion);
            }
            if (!existeVendedor) {
                this.retornarLlavePrimaria = true;
                idVendedor = super.insertar();
                this.vendedor.setIdVendor(idVendedor);
                this.vendedor.setIdTrabajador(trabajador.getIdTrabajador());
                this.vendedor.setIdUsuario(trabajador.getIdUsuario());
                this.retornarLlavePrimaria = false;
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar Vendedor " + ex);
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
        return idVendedor;
    }

    @Override
    public Integer modificar(Vendedor vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Vendedor vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Vendedor> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vendedor obtenerPorId(Integer idVendedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existeVendedor(Vendedor vendedor) {
        Boolean abreConexion = true;
        return existeVendedor(vendedor, abreConexion);
    }

    @Override
    public Boolean existeVendedor(Vendedor vendedor, Boolean abreConexion) {
        this.vendedor = vendedor;
        Integer idVendedor = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select id_vendedor from vendedor where ";
            sql = sql.concat("id_trabajador=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.vendedor.getIdTrabajador());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idVendedor = this.resultSet.getInt("id_vendedor");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe vendedor - " + ex);
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
//    public Integer insertar(Vendedor vendedor) {
//        this.vendedor = vendedor;
//        Integer id = super.insertar();
//        vendedor.setIdUsuario(id);
//        return id;
//    }
//
//    @Override
//    public Integer modificar(Vendedor vendedor) {
//        this.vendedor = vendedor;
//        return super.modificar();
//    }
//
//    @Override
//    public ArrayList<Vendedor> listarTodosAdministradores() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Vendedor obtenerPorId(Integer idAdministrador) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void insertarIdVendedor(Integer idVendedor) {
//        this.vendedor.setIdVendor(idVendedor);
//    }
//    
//    //Funciones para la logica de BD
//    @Override
//    protected String obtenerListaAtributos(){
//    }
//    
//    @Override
//    protected String obtenerListaValoresParaInsertar(){
//        String sql ="";
//        sql = sql.concat("'" + this.vendedor.getIdTrabajador() + "'");
//        return sql;
//    }
}
