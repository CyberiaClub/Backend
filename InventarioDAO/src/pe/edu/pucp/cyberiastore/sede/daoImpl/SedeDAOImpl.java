package pe.edu.pucp.cyberiastore.sede.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.sede.dao.SedeDAO;

public class SedeDAOImpl extends DAOImpl implements SedeDAO {

    private Sede sede;

    public SedeDAOImpl() {
        super("SEDE");
        this.sede = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "NOMBRE, DESCRIPCION";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.sede.getNombre());
        this.incluirParametroString(2, this.sede.getDescripcion());
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
    public Integer insertar(Sede sede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Sede sede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Sede sede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Sede> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Sede> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Sede obtenerPorId(String idSede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer obtenerId(Sede sede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer obtenerIdPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String imprimirId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public Integer insertar(Sede sede) {
//        this.sede = sede;
//        Integer id = this.insertar();
//        this.sede.setIdSede(id);
//        return id;
//    }
//
//    @Override
//    public Integer modificar(Sede sede) {
//        this.sede = sede;
//        return this.modificar();
//    }
//
//    @Override
//    public Integer eliminar(Sede sede) {
//        this.sede = sede;
//        return this.modificar();
//    }
//
//    @Override
//    protected String obtenerListaAtributos() {
//    }
//
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String valores = "";
//        valores = valores.concat("'" + sede.getNombre() + "'");
//        valores = valores.concat(", ");
//        valores = valores.concat("'" + sede.getDescripcion() + "'");
//        return valores;
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
//        sql = sql.concat("ID_SEDE= ");
//        sql = sql.concat("'" + sede.getIdSede() + "'");
//        return sql;
//    }
//
//    @Override
//    public ArrayList<Sede> listar(String sql) {
//        ArrayList<Sede> listaSede = new ArrayList();
//        try {
//            this.abrirConexion();
//            this.ejecutarConsultaEnBD(sql);
//            while (this.resultSet.next()) {
//                Sede plantillaSede = new Sede(
//                        this.resultSet.getString("NOMBRE"),
//                        this.resultSet.getString("DESCRIPCION")
//                );
//                listaSede.add(plantillaSede);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SedeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                this.cerrarConexion();
//            } catch (SQLException ex) {
//                Logger.getLogger(SedeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return listaSede;
//    }
//
//    @Override
//    public ArrayList<Sede> listarTodos() {
//        String listado = this.obtenerListaValoresParaSeleccionar();
//        return this.listar(listado);
//    }
//
//    @Override
//    public Sede obtenerPorId(String idSede) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat(" and ID_SEDE = '" + idSede + "'");
//        return this.listar(sql).getFirst();
//    }
//
//    @Override
//    public Integer obtenerId(Sede sede) {
//        this.sede = sede;
//        try {
//            Integer id = this.retornarUltimoAutogenerado();
//            this.sede.setIdSede(id);
//        } catch (SQLException ex) {
//            Logger.getLogger(SedeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    @Override
//    public String imprimirId(){
//        return "" + this.sede.getIdSede();
//    }
//
//    @Override
//    public Integer obtenerIdPorNombre(String nombre) {
//        String sql = "select ID_SEDE as id from SEDE where NOMBRE = '"+nombre+"'";
//        try {
//            Integer id = this.retonarIdPorAtributo(sql);
//            return id;
//        } catch (SQLException ex) {
//            Logger.getLogger(SedeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
}
