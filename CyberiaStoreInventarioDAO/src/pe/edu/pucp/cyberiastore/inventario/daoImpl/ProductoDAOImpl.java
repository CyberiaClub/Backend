package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoDAO;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXMarcaDAO;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXTipoDAO;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProductoXProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.daoImpl.ProductoXProveedorDAOImpl;
import pe.edu.pucp.cyberiastore.sede.dao.ProductoXSedeDAO;
import pe.edu.pucp.cyberiastore.sede.daoImpl.ProductoXSedeDAOImpl;

public class ProductoDAOImpl extends DAOImpl implements ProductoDAO {

    private Producto producto;

    public ProductoDAOImpl() {
        super("PRODUCTO");
        this.producto = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "SKU, NOMBRE, DESCRIPCION, PRECIO, UNIDAD";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1,this.producto.getSku());
        this.incluirParametroString(2,this.producto.getNombre());
        this.incluirParametroString(3,this.producto.getDescripcion());
        this.incluirParametroDouble(4,this.producto.getPrecio());
        this.incluirParametroString(5,this.producto.getUnidad());
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "SKU=?, NOMBRE=?, DESCRIPCION=?, PRECIO=?, UNIDAD=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "id_producto=?";
        } else {
            sql = "id_producto=?";
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1,this.producto.getSku());
        this.incluirParametroString(2,this.producto.getNombre());
        this.incluirParametroString(3,this.producto.getDescripcion());
        this.incluirParametroDouble(4,this.producto.getPrecio());
        this.incluirParametroString(5,this.producto.getUnidad());
        this.incluirParametroInt(6,this.producto.getIdProducto());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1,this.producto.getIdProducto());
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "id_Producto, sku, nombre, descripcion, precio, unidad";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.producto);
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1,this.producto.getIdProducto());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.producto = new Producto(
            this.resultSet.getInt("id_producto"),
            this.resultSet.getString("sku"),
            this.resultSet.getString("nombre"),
            this.resultSet.getString("descripcion"),
            this.resultSet.getDouble("precio"),
            this.resultSet.getString("unidad"),
            null
        );
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.producto = null;
    }

    @Override
    public Integer insertar(Producto producto) {
        this.producto = producto;
        Integer idProducto = null;
        Boolean existeProducto = this.existeProducto(producto);
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeProducto) {
                this.retornarLlavePrimaria = true;
                idProducto = super.insertar();
                this.retornarLlavePrimaria = false;
//                Insertar producto x marca
                ProductoXMarcaDAO productoxmarca = new ProductoXMarcaDAOImpl();
                productoxmarca.insertar(idProducto, this.producto.getIdMarca(), usarTransaccion, conexion);
                //Insertar  producto x sede
                ProductoXSedeDAO productoxsede = new ProductoXSedeDAOImpl();
                productoxsede.insertar(idProducto, this.producto.getIdSede(), usarTransaccion, conexion);
                // insertar producto x tipo
                ProductoXTipoDAO productoxtipo = new ProductoXTipoDAOImpl();
                productoxtipo.insertar(idProducto, this.producto.getIdTipoProducto(), usarTransaccion, conexion);
                //insertar producto x proveedor
                ProductoXProveedorDAO productoxproveedor = new ProductoXProveedorDAOImpl();
                productoxproveedor.insertar(idProducto, this.producto.getIdProveedor(), this.producto.getPrecioProveedor(), usarTransaccion, conexion);
            } else {
                idProducto = producto.getIdProducto();
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
        return idProducto;
    }

    @Override
    public Boolean existeProducto(Producto producto) {
        Boolean abreConexion = true;
        return existeProducto(producto, abreConexion);
    }

    @Override
    public Boolean existeProducto(Producto producto, Boolean abreConexion) {
        this.producto = producto;
        Integer idProducto = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select id_Producto from producto where ";
            sql = sql.concat("sku=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.producto.getSku());
            sql = sql.concat("or nombre=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.producto.getNombre());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idProducto = this.resultSet.getInt("id_Producto");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe producto - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idProducto != null;
    }

    @Override
    public Integer modificar(Producto producto) {
        Integer retorno = 0;
        this.producto = producto;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
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
    public Integer eliminar(Producto producto) {
        Integer retorno = 0;
        this.producto = producto;

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            retorno = super.eliminar();
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar eliminar - " + ex);
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
    public ArrayList<Producto> listarTodos() {
        return (ArrayList<Producto>) super.listarTodos(null);
    }

    @Override
    public Producto obtenerPorId(String idProducto) {
        this.producto = new Producto();
        this.producto.setIdProducto(Integer.valueOf(idProducto));
        super.obtenerPorId();
        return this.producto;
    }
    //    @Override
//    public Integer insertar(Producto producto) {
//        this.producto = producto;
//        Integer id = this.insertar();
//        this.producto.setIdProducto(id);
//        return id;
//    }
//
//    @Override
//    public Integer modificar(Producto producto) {
//        this.producto = producto;
//        return this.modificar();
//    }
//
//    @Override
//    public Integer eliminar(Producto producto) {
//        this.producto = producto;
//        return this.modificar();
//    }
//
//
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String valores = "";
//        valores = valores.concat("'"+producto.getSku()+"'");
//        valores = valores.concat(", ");
//        valores = valores.concat("'"+producto.getNombre()+"'");
//        valores = valores.concat(", ");
//        valores = valores.concat("'"+producto.getDescripcion()+"'");
//        valores = valores.concat(", ");
//        valores = valores.concat("'"+producto.getPrecio()+"'");
//        valores = valores.concat(", ");
//        valores = valores.concat("'"+producto.getUnidad()+"'");
//        return valores;
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        return "";
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        return "";
//    }
//
//    @Override
//    public ArrayList<Producto> listar(String listado) {
//        ArrayList<Producto> listadoProductos = new ArrayList();
//        try{
//            this.abrirConexion();
//            this.ejecutarConsultaEnBD(listado);
//            while(this.resultSet.next()){
//                Producto plantillaProducto;
//                plantillaProducto = new Producto(
//                        this.resultSet.getString("SKU"),
//                        this.resultSet.getString("NOMBRE"),
//                        this.resultSet.getString("DESCRIPCION"),
//                        this.resultSet.getDouble("PRECIO"),
//                        this.resultSet.getString("UNIDAD")
//                );
//                listadoProductos.add(plantillaProducto);
//            }
//        }catch(SQLException ex){
//            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            try{
//                this.cerrarConexion();
//            }catch(SQLException ex){
//                Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return listadoProductos;
//    }
//
//    @Override
//    public ArrayList<Producto> listarTodos() {
//        String listado = this.obtenerListaValoresParaSeleccionar();
//        return this.listar(listado);
//    }
//
//    @Override
//    public Producto obtenerPorId(String idProducto) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
//    @Override
//    public Integer obtenerId(Producto producto) {
//        this.producto = producto;
//        try {
//            Integer id = this.retornarUltimoAutogenerado();
//            this.producto.setIdProducto(id);
//            return id;
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    @Override
//    public String imprimirId(){
//        return "" + this.producto.getIdProducto();
//    }
}
