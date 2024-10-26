package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.dao.MarcaDAO;
import pe.edu.pucp.cyberiastore.config.DAOImpl;

public class MarcaDAOImpl extends DAOImpl implements MarcaDAO {
    
    private Marca marca;

    public MarcaDAOImpl() {
        super("MARCA");
        this.marca = null;
        this.retornarLlavePrimaria = true;
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "NOMBRE, ACTIVO";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1,this.marca.getNombre());
        this.incluirParametroBoolean(2,this.marca.getActivo());
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
    public Integer insertar(Marca marca) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Marca marca) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Marca marca) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Marca> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Marca> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Marca obtenerPorId(String idMarca) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer obtenerUltimoId(Marca marca) {
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
    


//
//    @Override
//    public Integer insertar(Marca marca) {
//        this.marca = marca;
//        Integer id = this.insertar();
//        this.marca.setIdMarca(id);
//        return id;
//    }
//
//    @Override
//    public Integer modificar(Marca marca) {
//        this.marca = marca;
//        return this.modificar();
//    }
//
//    @Override
//    public Integer eliminar(Marca marca) {
//        this.marca = marca;
//        return this.eliminar();
//    }
//
//    @Override
//    protected String obtenerListaAtributos() {
//        
//    }
//
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String valores="";
//        
//        valores=valores.concat("'"+marca.getNombre()+"'");
//        valores=valores.concat(", ");
//        valores=valores.concat("'"+ (marca.getActivo() ? 1:0) + "'");
//        return valores;
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        String mod="NOMBRE = ";
//        
//        mod=mod.concat("'"+marca.getNombre()+"'");
//        
//        return mod;
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        String id = "ID_MARCA = ";
//        id = id.concat("'"+this.marca.getIdMarca().toString()+"'");
//        
//        return id;
//    }
//
//    @Override
//    public ArrayList<Marca> listar(String listado) {
//        ArrayList<Marca> listaMarcas = new ArrayList();
//        try{
//            this.abrirConexion();
//            this.ejecutarConsultaEnBD(listado);
//            while(this.resultSet.next()){
//                Marca plantillaMarca = new Marca(this.resultSet.getString("NOMBRE"));
//                listaMarcas.add(plantillaMarca);
//            }
//        }catch(SQLException ex){
//            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            try{
//                this.cerrarConexion();
//            }catch(SQLException ex){
//                Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return listaMarcas;
//    }
//
//    @Override
//    public ArrayList<Marca> listarTodos() {
//        String listado = this.obtenerListaValoresParaSeleccionar();
//        return this.listar(listado);
//    }
//
//    @Override
//    public Marca obtenerPorId(String idMarca) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat(" and ID_MARCA = '" + idMarca + "'");
//        return this.listar(sql).getFirst();
//    }
//    
//    @Override
//    public Integer obtenerUltimoId(Marca marca) {
//        this.marca = marca;
//        try {
//            Integer id = this.retornarUltimoAutogenerado();
//            this.marca.setIdMarca(id);
//        } catch (SQLException ex) {
//            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    public Integer obtenerIdPorNombre(String marca){
//        String sql = "select ID_MARCA as id from MARCA where NOMBRE = '"+marca+"'";
//        try {
//            Integer id = this.retonarIdPorAtributo(sql);
//            return id;
//        } catch (SQLException ex) {
//            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    @Override
//    public String imprimirId(){
//        return "" + this.marca.getIdMarca();
//    }
}
