package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoDAO;
import pe.edu.pucp.cyberiastore.db.DAOImpl;

public class ProductoDAOImpl extends DAOImpl implements ProductoDAO {

    private Producto producto;

    public ProductoDAOImpl() {
        super("PRODUCTO");
        this.producto = null;
    }

    @Override
    public Integer insertar(Producto producto) {
        this.producto = producto;
        Integer id = this.insertar();
        this.producto.setIdProducto(id);
        return id;
    }

    @Override
    public Integer modificar(Producto producto) {
        this.producto = producto;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Producto producto) {
        this.producto = producto;
        return this.modificar();
    }

    @Override
    protected String obtenerListaAtributos() {
        return "SKU, NOMBRE, DESCRIPCION, PRECIO, UNIDAD";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String valores = "";
        valores = valores.concat("'"+producto.getSku()+"'");
        valores = valores.concat(", ");
        valores = valores.concat("'"+producto.getNombre()+"'");
        valores = valores.concat(", ");
        valores = valores.concat("'"+producto.getDescripcion()+"'");
        valores = valores.concat(", ");
        valores = valores.concat("'"+producto.getPrecio()+"'");
        valores = valores.concat(", ");
        valores = valores.concat("'"+producto.getUnidad()+"'");
        return valores;
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        return "";
    }

    @Override
    protected String obtenerCondicionPorId() {
        return "";
    }

    @Override
    public ArrayList<Producto> listar(String listado) {
        ArrayList<Producto> listadoProductos = new ArrayList();
        try{
            this.abrirConexion();
            this.ejecutarConsultaEnBD(listado);
            while(this.resultSet.next()){
                Producto plantillaProducto;
                plantillaProducto = new Producto(
                        this.resultSet.getString("SKU"),
                        this.resultSet.getString("NOMBRE"),
                        this.resultSet.getString("DESCRIPCION"),
                        this.resultSet.getDouble("PRECIO"),
                        this.resultSet.getString("UNIDAD")
                );
                listadoProductos.add(plantillaProducto);
            }
        }catch(SQLException ex){
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                this.cerrarConexion();
            }catch(SQLException ex){
                Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listadoProductos;
    }

    @Override
    public ArrayList<Producto> listarTodos() {
        String listado = this.obtenerListaValoresParaSeleccionar();
        return this.listar(listado);
    }

    @Override
    public Producto obtenerPorId(String idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Integer obtenerId(Producto producto) {
        this.producto = producto;
        try {
            Integer id = this.retornarUltimoAutogenerado();
            this.producto.setIdProducto(id);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public String imprimirId(){
        return "" + this.producto.getIdProducto();
    }
}
