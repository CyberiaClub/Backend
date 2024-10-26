package pe.edu.pucp.cyberiastore.rol.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.rol.dao.PermisoDAO;
import pe.edu.pucp.cyberiastore.rol.model.Permiso;

public class PermisoDAOImpl extends DAOImpl implements PermisoDAO {

    private Permiso permiso;

    public PermisoDAOImpl() {
        super("PERMISO");
        this.permiso = null;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "NOMBRE, DESCRIPCION, ACTIVO";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.permiso.getNombre());
        this.incluirParametroString(2, this.permiso.getDescripcion());
        this.incluirParametroBoolean(3, this.permiso.getActivo());
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
    public Integer insertar(Permiso permiso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Permiso permiso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Permiso permiso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Permiso> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Permiso> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Permiso obtenerPorId(String idPermiso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer obtenerId(Permiso permiso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String imprimirId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public Integer insertar(Permiso permiso){
//        this.permiso = permiso;
//        return this.insertar();
//    }
//    
//    @Override
//    protected String obtenerListaAtributos(){
//    }
//    
//    @Override
//    protected String obtenerListaValoresParaInsertar(){
//        String sql = "";
//        sql = sql.concat("'" + permiso.getNombre() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + permiso.getDescripcion() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + permiso.getActivo()+ "'");
//        return sql;
//    }
//
//    @Override
//    public Integer modificar(Permiso permiso) {
//        this.permiso = permiso;
//        return this.modificar();
//    }
//
//    @Override
//    public Integer eliminar(Permiso permiso) {
//        this.permiso = permiso;
//        return this.eliminar();
//    }
//    
//    @Override
//    public ArrayList<Permiso> listar(String sql) {
//        ArrayList<Permiso> listaPermiso = new ArrayList();
//        try {
//            this.abrirConexion();
//            this.ejecutarConsultaEnBD(sql);
//            while(this.resultSet.next()){
//                Permiso permisoTemp = new Permiso(
//                        this.resultSet.getInt("ID_PERMISO"),
//                        this.resultSet.getString("NOMBRE"),
//                        this.resultSet.getString("DESCRIPCION")
//                );
//                listaPermiso.add(permisoTemp);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PermisoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                this.cerrarConexion();
//            } catch (SQLException ex) {
//                Logger.getLogger(PermisoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return listaPermiso;
//    }
//
//    @Override
//    public ArrayList<Permiso> listarTodos() {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        return this.listar(sql);
//    }
//
//    @Override
//    public Permiso obtenerPorId(String idPermiso) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat(" and ID_PERMISO = '" + idPermiso + "'");
//        return this.listar(sql).getFirst();
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        String sql = "";
//        sql = sql.concat("NOMBRE = ");
//        sql = sql.concat("'" + permiso.getNombre() + "'");
//        sql = sql.concat(",DESCRIPCION = ");
//        sql = sql.concat("'" + permiso.getDescripcion()+ "'");
//        return sql;
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        String sql = "";
//        sql = sql.concat("ID_PERMISO = ");
//        sql = sql.concat("'" + permiso.getIdPermiso() + "'");
//        return sql;
//    }
//    
//    @Override
//    public Integer obtenerId(Permiso permiso) {
//        this.permiso = permiso;
//        try {
//            Integer id = this.retornarUltimoAutogenerado();
//            this.permiso.setIdPermiso(id);
//        } catch (SQLException ex) {
//            Logger.getLogger(PermisoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    @Override
//    public String imprimirId(){
//        return "" + this.permiso.getIdPermiso();
//    }
}
