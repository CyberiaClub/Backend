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
import pe.edu.pucp.cyberiastore.sede.dao.ProductoXSedeDAO;
import pe.edu.pucp.cyberiastore.sede.daoImpl.ProductoXSedeDAOImpl;

public class ProductoDAOImpl extends DAOImpl implements ProductoDAO {

    private Producto producto;
    private Integer value;

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
                System.out.println("ID PRODUCTO: " + idProducto);
                this.retornarLlavePrimaria = false;
                // insertar productos individuales
                ArrayList<Producto> productosMiembros = this.producto.getProductosMiembros();
                if (productosMiembros != null) {
                    ProductoXProductoDAO productoXProducto = new ProductoXProductoDAOImpl();
                    for (Producto productoMiembro : productosMiembros) {
                        // idProducto es el padre, productoMiembro del hijo, cantidad
                        productoXProducto.insertar(idProducto, productoMiembro.getIdProducto(), productoMiembro.getCantidad(), this.usarTransaccion, this.conexion);
                    }
                }
                System.out.println(idProducto);
//                Insertar producto x marca
                ProductoXMarcaDAO productoxmarca = new ProductoXMarcaDAOImpl();
                productoxmarca.insertar(idProducto, this.producto.getIdMarca(), usarTransaccion, conexion);
                //Insertar  producto x sede
                ProductoXSedeDAO productoxsede = new ProductoXSedeDAOImpl();
                productoxsede.insertar(idProducto, this.producto.getIdSede(), this.producto.getCantidad(), usarTransaccion, conexion);
                // insertar producto x tipo
                ProductoXTipoDAO productoxtipo = new ProductoXTipoDAOImpl();
                productoxtipo.insertar(idProducto, this.producto.getIdTipo(), usarTransaccion, conexion);
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
    protected String obtenerListaDeAtributosParaInsercion() {
        return "SKU, NOMBRE, DESCRIPCION, PRECIO,IMAGEN";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.producto.getSku());
        this.incluirParametroString(2, this.producto.getNombre());
        this.incluirParametroString(3, this.producto.getDescripcion());
        System.out.println(this.producto.getPrecio());
        this.incluirParametroDouble(4, this.producto.getPrecio());
        this.incluirParametroByte(5, this.producto.getImagen());
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
            sql = "ID_PRODUCTO=?";
        } else {
            sql = "ID_PRODUCTO=?";
        }
        return sql;
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "SKU=?, NOMBRE=?, DESCRIPCION=?, PRECIO=?, IMAGEN=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.producto.getSku());
        this.incluirParametroString(2, this.producto.getNombre());
        this.incluirParametroString(3, this.producto.getDescripcion());
        this.incluirParametroDouble(4, this.producto.getPrecio());
        this.incluirParametroByte(5, this.producto.getImagen());
        this.incluirParametroInt(6, this.producto.getIdProducto());
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
        this.value = 1;
        return (ArrayList<Producto>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "p.ID_PRODUCTO,p.SKU,p.NOMBRE AS NOMBRE_PRODUCTO,p.DESCRIPCION AS DESCRIPCION_PRODUCTO,p.PRECIO,p.IMAGEN, ";
        sql = sql.concat("m.ID_MARCA,m.NOMBRE AS NOMBRE_MARCA, ");
        sql = sql.concat("tp.ID_TIPO_PRODUCTO,tp.TIPO AS NOMBRE_TIPO_PRODUCTO, ");
        sql = sql.concat("s.ID_SEDE,s.NOMBRE AS NOMBRE_SEDE, ");
        sql = sql.concat("prv.ID_PROVEEDOR,prv.RAZON_SOCIAL ");
        return sql;
    }

    @Override
    protected String obtenerPredicadoParaListado() {
        String sql = "PRODUCTO p";
        sql = sql.concat("LEFT JOIN PRODUCTO_X_MARCA pm ON p.ID_PRODUCTO = pm.ID_PRODUCTO ");
        sql = sql.concat("LEFT JOIN MARCA m ON pm.ID_MARCA = m.ID_MARCA ");
        sql = sql.concat("LEFT JOIN PRODUCTO_X_TIPO pt ON p.ID_PRODUCTO = pt.ID_PRODUCTO ");
        sql = sql.concat("LEFT JOIN TIPO_PRODUCTO tp ON pt.ID_TIPO_PRODUCTO = tp.ID_TIPO_PRODUCTO ");
        sql = sql.concat("LEFT JOIN PRODUCTO_X_SEDE ps ON p.ID_PRODUCTO = ps.ID_PRODUCTO ");
        sql = sql.concat("LEFT JOIN SEDE s ON ps.ID_SEDE = s.ID_SEDE ");
        sql = sql.concat("LEFT JOIN PRODUCTO_X_PROVEEDOR pp ON p.ID_PRODUCTO = pp.ID_PRODUCTO ");
        sql = sql.concat("LEFT JOIN PROVEEDOR prv ON pp.ID_PROVEEDOR = prv.ID_PROVEEDOR ");
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
        this.producto.setNombre(this.resultSet.getString("NOMBRE_PRODUCTO"));
        this.producto.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.producto.setPrecio(this.resultSet.getDouble("PRECIO"));
        this.producto.setImagen(this.resultSet.getBytes("IMAGEN"));

        this.producto.setIdMarca(this.resultSet.getInt("ID_MARCA"));
        this.producto.setNombreMarca(this.resultSet.getString("NOMBRE_MARCA"));

        this.producto.setIdMarca(this.resultSet.getInt("ID_TIPO_PRODUCTO"));
        this.producto.setNombreMarca(this.resultSet.getString("NOMBRE_TIPO_PRODUCTO"));

        this.producto.setIdMarca(this.resultSet.getInt("ID_SEDE"));
        this.producto.setNombreMarca(this.resultSet.getString("NOMBRE_SEDE"));

        this.producto.setIdMarca(this.resultSet.getInt("ID_PROVEEDOR"));
        this.producto.setNombreMarca(this.resultSet.getString("RAZON_SOCIAL"));
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
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, this.producto.getSku());
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

    @Override
    public ArrayList<Producto> buscar_sku(String sku) {
        this.value = 2;
        List lista = new ArrayList<>();
        try {
            this.abrirConexion();
            String sql = "SELECT p.NOMBRE,p.DESCRIPCION,p.PRECIO,ps.STOCK_SEDE,s.NOMBRE AS NOMBRE_SEDE ";
            sql = sql.concat("FROM PRODUCTO p");
            sql = sql.concat("JOIN PRODUCTO_X_SEDE ps ON p.ID_PRODUCTO = ps.ID_PRODUCTO");
            sql = sql.concat("JOIN SEDE s ON ps.ID_SEDE = s.ID_SEDE");
            sql = sql.concat("WHERE p.SKU = '?'");
            this.colocarSQLenStatement(sql);
            this.incluirParametroString(1, sku);
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                Producto p = new Producto();
                p.setNombre(this.resultSet.getString("NOMBRE"));
                p.setDescripcion(this.resultSet.getString("DESCRIPCION"));
                p.setPrecio(this.resultSet.getDouble("PRECIO"));
                p.setCantidad(this.resultSet.getInt("STOCK_SEDE"));
                p.setNombreSede(this.resultSet.getString("NOMBRE_SEDE"));
                lista.add(this.producto);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar listarTodos - " + ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        this.value = 0;
        return (ArrayList<Producto>) lista;
    }

}
