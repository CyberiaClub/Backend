package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;
import pe.edu.pucp.cyberiastore.trabajador.dao.AdministradorDAO;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;

public class AdministradorDAOImpl extends DAOImpl implements AdministradorDAO {

    private Administrador administrador;

    public AdministradorDAOImpl() {
        super("ADMINISTRADOR");
        this.administrador = null;
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
        this.incluirParametroInt(1, this.administrador.getIdTrabajador());
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
    public Integer insertar(Administrador administrador) {
        this.administrador = administrador;
        Integer idTrabajador = null;// el ID de la clase que hereda
        Trabajador trabajador = new Trabajador();// traemos la clase padre
        trabajador.setSueldo(administrador.getSueldo());
        trabajador.setFechaDeIngreso(administrador.getFechaDeIngreso());
        trabajador.setIdSede(administrador.getIdSede());
        TrabajadorDAO trabajadorDAO = new TrabajadorDAOImpl();
        Boolean existeTrabajador = trabajadorDAO.existeTrabajador(trabajador);
        Boolean existeAdministrador = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeTrabajador) {
                idTrabajador = trabajadorDAO.insertar(trabajador, this.usarTransaccion, this.conexion);
                this.administrador.setIdTrabajador(idTrabajador);
            } else {
                idTrabajador = trabajador.getIdTrabajador();
                this.administrador.setIdTrabajador(idTrabajador);
                Boolean abreConexion = false;
                existeAdministrador = this.existeAdministrador(this.administrador, abreConexion);
            }
            if (!existeAdministrador) {
                super.insertar();
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

    @Override
    public Integer modificar(Administrador administrador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Administrador administrador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Administrador> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Administrador obtenerPorId(Integer idAdministrador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Boolean existeAdministrador(Administrador administrador) {
        Boolean abreConexion = true;
        return existeAdministrador(administrador, abreConexion);
    }

    @Override
    public Boolean existeAdministrador(Administrador administrador, Boolean abreConexion) {
        this.administrador = administrador;
        Integer idAdministrador = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select idAdministrador from administrador where ";
            sql = sql.concat("idPersona=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.administrador.getIdAdministrador());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idAdministrador = this.resultSet.getInt("idAdministrador");
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
        return idAdministrador != null;
    }

//    @Override
//    public Integer insertar(Administrador administrador) {
//        this.administrador = administrador;
//        Integer id = super.insertar();
//        this.administrador.setIdAdministrador(id);
//        return id;
//    }
//
//    @Override
//    public Integer modificar(Administrador administrador) {
//        this.administrador = administrador;
//        return super.modificar();
//    }
//
//    @Override
//    public ArrayList<Administrador> listarTodosAdministradores() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Administrador obtenerPorId(Integer idAdministrador) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void insertarIdAdministrador(Integer idAdministrador) {
//        this.administrador.setIdAdministrador(idAdministrador); 
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
//        sql = sql.concat("'" + administrador.getIdTrabajador() + "'");
//        return sql;
//    }
}
