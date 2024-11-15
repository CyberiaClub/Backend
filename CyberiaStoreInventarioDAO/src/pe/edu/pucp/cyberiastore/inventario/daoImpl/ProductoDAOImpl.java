package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoDAO;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXMarcaDAO;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXTipoDAO;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProductoXProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.daoImpl.ProductoXProveedorDAOImpl;
import pe.edu.pucp.cyberiastore.sede.daoImpl.StockSedeDAOImpl;
import pe.edu.pucp.cyberiastore.sede.dao.StockSedeDAO;

public class ProductoDAOImpl extends DAOImpl implements ProductoDAO {

    private Producto producto;

    public ProductoDAOImpl() {
        super("PRODUCTO");
        this.producto = null;
        this.retornarLlavePrimaria = true;
    }

    /*
     * ************************************************************************
     * INSERTAR
     * ************************************************************************
     */
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
                // insertar productos individuales
                ArrayList<Producto> productosMiembros = this.producto.getProductosMiembros();
                if (productosMiembros != null) {
                    ProductoXProductoDAO productoXProducto = new ProductoXProductoDAOImpl();
                    for (Producto productoMiembro: productosMiembros) {
                        // idProducto es el padre, productoMiembro del hijo, cantidad
                        productoXProducto.insertar(idProducto, productoMiembro.getIdProducto(), productoMiembro.getCantidad(), this.usarTransaccion, this.conexion);
                    }
                }
                //Insertar  producto x sede
                StockSedeDAO productoxsede = new StockSedeDAOImpl();
                productoxsede.insertar(idProducto, this.producto.getIdSede(), this.producto.getCantidad(), usarTransaccion, conexion);
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
    protected String obtenerListaDeAtributosParaInsercion() {
        return "SKU, NOMBRE, DESCRIPCION, PRECIO, PRECIO_PROVEEDOR, IMAGEN, ID_TIPO_PRODUCTO, ID_SEDE";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.producto.getSku());
        this.incluirParametroString(2, this.producto.getNombre());
        this.incluirParametroString(3, this.producto.getDescripcion());
        this.incluirParametroDouble(4, this.producto.getPrecio());
        this.incluirParametroDouble(5, this.producto.getPrecioProveedor());
        this.incluirParametroByte(6, this.producto.getImagen());
        this.incluirParametroInt(7, this.producto.getTipoProducto().getIdTipoProducto());
        this.incluirParametroInt(8, this.producto.getMarca().getIdMarca());
    }

    /*
     * ************************************************************************
     * MODIFICAR
     * ************************************************************************
     */
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
            System.err.println("Error al intentar modificar PRODUCTO " + ex);
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
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "SKU=?, NOMBRE=?, DESCRIPCION=?, PRECIO=?, PRECIO_PROVEEDOR=?, IMAGEN=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.producto.getSku());
        this.incluirParametroString(2, this.producto.getNombre());
        this.incluirParametroString(3, this.producto.getDescripcion());
        this.incluirParametroDouble(4, this.producto.getPrecio());
        this.incluirParametroDouble(5, this.producto.getPrecioProveedor());
        this.incluirParametroByte(6, this.producto.getImagen());
        this.incluirParametroInt(7, this.producto.getIdProducto());
    }

    /*
     * ************************************************************************
     * ELIMINAR
     * ************************************************************************
     */
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
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.incluirParametroInt(1, this.producto.getIdProducto());
    }

    /*
     * ************************************************************************
     * OBTENER POR ID
     * ************************************************************************
     */
    @Override
    public Producto obtenerPorId(String idProducto) {
        this.producto = new Producto();
        this.producto.setIdProducto(Integer.valueOf(idProducto));
        super.obtenerPorId();
        return this.producto;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.producto.getIdProducto());
    }

    /*
     * ************************************************************************
     * LISTAR TODOS
     * ************************************************************************
     */
    @Override
    public ArrayList<Producto> listarTodos() {
        return (ArrayList<Producto>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "ID_PRODUCTO, SKU, NOMBRE, DESCRIPCION, PRECIO, PRECIO_PROVEEDOR, IMAGEN";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.producto);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.producto = new Producto();
        this.producto.setIdProducto(this.resultSet.getInt("ID_PRODUCTO"));
        this.producto.setSku(this.resultSet.getString("SKU"));
        this.producto.setNombre(this.resultSet.getString("NOMBRE"));
        this.producto.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.producto.setPrecio(this.resultSet.getDouble("PRECIO"));
        this.producto.setPrecioProveedor(this.resultSet.getDouble("PRECIO_PROVEEDOR"));
        this.producto.setImagen(this.resultSet.getBytes("IMAGEN"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.producto = null;
    }

    /*
     * *************************************************************************
     * EXISTE PRODUCTO
     * Funciones adicionales
     * *************************************************************************
     */
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
            String sql = "select ID_PRODUCTO from PRODUCTO where ";
            sql = sql.concat("SKU=? ");
            this.colocarSQLenStatement(sql);
            sql = sql.concat("or nombre=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.producto.getSku());
            this.incluirParametroString(2, this.producto.getNombre());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idProducto = this.resultSet.getInt("ID_PRODUCTO");
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

}
