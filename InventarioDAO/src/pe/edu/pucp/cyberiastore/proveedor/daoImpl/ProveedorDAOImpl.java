package pe.edu.pucp.cyberiastore.proveedor.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.daoImpl.ProveedorDAOImpl;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;

public class ProveedorDAOImpl extends DAOImpl implements ProveedorDAO {

    private Proveedor proveedor;

    public ProveedorDAOImpl() {
        super("PROVEEDOR");
        this.proveedor = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "RUC, NOMBRE, FECHA_REGISTRO, ACTIVO";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1,this.proveedor.getRuc());
        this.incluirParametroString(2,this.proveedor.getRuc());
        this.incluirParametroDate(3,this.proveedor.getFechaRegistro());
        this.incluirParametroString(4,this.proveedor.getRuc());
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
    public Integer insertar(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Proveedor> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Proveedor> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Proveedor obtenerPorId(String idProveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer obtenerId(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer obtenerIdPorRuc(String ruc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String imprimirId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public Integer insertar(Proveedor proveedor) {
//        this.proveedor = proveedor;
//        Integer id = this.insertar();
//        return id;
//    }
//
//    @Override
//    public Integer modificar(Proveedor proveedor) {
//        this.proveedor = proveedor;
//        return this.modificar();
//    }
//
//    @Override
//    public Integer eliminar(Proveedor proveedor) {
//        this.proveedor = proveedor;
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
//        valores = valores.concat("'" + proveedor.getRuc() + "'");
//        valores = valores.concat(", ");
//        valores = valores.concat("'" + proveedor.getNombre() + "'");
//        valores = valores.concat(", ");
//        valores = valores.concat("STR_TO_DATE('" + this.proveedor.fechaRegistroComoDDMMYYY()+ "','%d-%m-%Y')");
//        valores = valores.concat(", ");
//        valores = valores.concat("'"+(proveedor.getActivo()?0:1)+"'");
//        return valores;
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        String valores = "";
//        valores = valores.concat("RUC: ");
//        valores = valores.concat("'" + proveedor.getRuc() + "'");
//        valores = valores.concat(", NOMBRE: ");
//        valores = valores.concat("'" + proveedor.getNombre() + "'");
//        valores = valores.concat(", FECHA_REGISTRO: ");
//        valores = valores.concat("'" + proveedor.getFechaRegistro() + "'");
//        valores = valores.concat(", ACTIVO: ");
//        valores = valores.concat("'"+proveedor.getActivo()+"'");
//        return valores;
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        String sql = "";
//        sql = sql.concat("RUC = ");
//        sql = sql.concat("'" + proveedor.getRuc() + "'");
//        return sql;
//    }
//
//    @Override
//    public ArrayList<Proveedor> listar(String listado) {
//        ArrayList<Proveedor> listadoProveedores = new ArrayList();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            this.abrirConexion();
//            this.ejecutarConsultaEnBD(listado);
//            while (this.resultSet.next()) {
//                Proveedor plantillaProveedor = new Proveedor(
//                        this.resultSet.getString("RUC"),
//                        this.resultSet.getString("NOMBRE"),
//                        sdf.parse(this.resultSet.getString("FECHA_REGISTRO"))
//                );
//                listadoProveedores.add(plantillaProveedor);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                this.cerrarConexion();
//            } catch (SQLException ex) {
//                Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return listadoProveedores;
//    }
//
//    @Override
//    public ArrayList<Proveedor> listarTodos() {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        return this.listar(sql);
//    }
//
//    @Override
//    public Proveedor obtenerPorId(String ruc) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat(" and RUC = '" + ruc + "'");
//        return this.listar(sql).getFirst();
//    }
//    
//    @Override
//    public Integer obtenerId(Proveedor proveedor) {
//        this.proveedor = proveedor;
//        try {
//            Integer id = this.retornarUltimoAutogenerado();
//            this.proveedor.setIdProveedor(id);
//        } catch (SQLException ex) {
//            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    @Override
//    public String imprimirId(){
//        return "" + this.proveedor.getIdProveedor();
//    }
//
//    @Override
//    public Integer obtenerIdPorRuc(String ruc) {
//        String sql = "select ID_PROVEEDOR as id from PROVEEDOR where RUC = '"+ruc+"'";
//        try {
//            Integer id = this.retonarIdPorAtributo(sql);
//            return id;
//        } catch (SQLException ex) {
//            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
}
