package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import pe.edu.pucp.cyberiastore.inventario.model.TipoOperacionInventario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoDAO;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.inventario.dao.ProductoXProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.dao.StockSedeDAO;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
import pe.edu.pucp.cyberiastore.inventario.model.TipoOperacionInventario;

public class ProductoDAOImpl extends DAOImpl implements ProductoDAO {

    private Producto producto;
    private Integer value;
    private TipoOperacionInventario tipoOperacion;

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
                    for (Producto productoMiembro : productosMiembros) {
                        // idProducto es el padre, productoMiembro del hijo, cantidad
                        productoXProducto.insertar(idProducto, productoMiembro.getIdProducto(), productoMiembro.getCantidad(), this.usarTransaccion, this.conexion);
                    }
                }
                //Insertar  producto x sede
//                StockSedeDAO productoxsede = new StockSedeDAOImpl();
//                productoxsede.insertar(idProducto, this.producto.getIdSede(), this.producto.getCantidad(), usarTransaccion, conexion);
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
        return "SKU, NOMBRE, DESCRIPCION, PRECIO, PRECIO_PROVEEDOR, IMAGEN, ID_TIPO_PRODUCTO, ID_MARCA";
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
            sql = "ID_PRODUCTO=?";
        } else {
            sql = "ID_PRODUCTO=?";
        }
        return sql;
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "NOMBRE=?, DESCRIPCION=?, PRECIO=?, IMAGEN=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.producto.getNombre());
        this.incluirParametroString(2, this.producto.getDescripcion());
        this.incluirParametroDouble(3, this.producto.getPrecio());
        this.incluirParametroByte(4, this.producto.getImagen());
        this.incluirParametroInt(5, this.producto.getIdProducto());
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
        this.tipoOperacion = TipoOperacionInventario.LISTAR_PRODUCTOS;
        this.value = 1;
        return (ArrayList<Producto>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "";
        switch (this.tipoOperacion) {
            case LISTAR_PRODUCTOS -> {
                sql = sql.concat(" PD.ID_PRODUCTO, PD.SKU, PD.NOMBRE, PD.DESCRIPCION, PD.PRECIO, PD.PRECIO_PROVEEDOR, ");
                sql = sql.concat("PD.IMAGEN, M.ID_MARCA, M.NOMBRE AS NOMBRE_MARCA, TP.ID_TIPO_PRODUCTO, TP.TIPO ");
            }
            case BUSCAR_POR_SKU -> {
                sql = sql.concat("PD.ID_PRODUCTO,PD.NOMBRE, PD.DESCRIPCION, PXS.STOCK_SEDE");
            }
        }
        return sql;
    }

    @Override
    protected String obtenerPredicadoParaListado() {
        String sql = "";
        switch (this.tipoOperacion) {
            case LISTAR_PRODUCTOS -> {
                sql = sql.concat(" PD ");
                sql = sql.concat("join MARCA M on PD.ID_MARCA = M.ID_MARCA ");
                sql = sql.concat("join TIPO_PRODUCTO TP on PD.ID_TIPO_PRODUCTO = TP.ID_TIPO_PRODUCTO ");
            }
            case BUSCAR_POR_SKU -> {
                sql = sql.concat(" PD ");
                sql = sql.concat("join PRODUCTO_X_SEDE PXS on PD.ID_PRODUCTO = PXS.ID_PRODUCTO ");
                sql = sql.concat("where PD.SKU=? AND PXS.ID_SEDE=?");
            }
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaListado() throws SQLException {
        switch (this.tipoOperacion) {
            case BUSCAR_POR_SKU -> {
                this.incluirParametroString(1, this.producto.getSku());
                this.incluirParametroInt(2, this.producto.getIdSede());
            }
        }
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.producto);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        switch (this.tipoOperacion) {
            case LISTAR_PRODUCTOS -> {
                this.producto = new Producto();
                this.producto.setIdProducto(this.resultSet.getInt("ID_PRODUCTO"));
                this.producto.setSku(this.resultSet.getString("SKU"));
                this.producto.setNombre(this.resultSet.getString("NOMBRE"));
                this.producto.setDescripcion(this.resultSet.getString("DESCRIPCION"));
                this.producto.setPrecio(this.resultSet.getDouble("PRECIO"));
                this.producto.setPrecioProveedor(this.resultSet.getDouble("PRECIO_PROVEEDOR"));
                this.producto.setImagen(this.resultSet.getBytes("IMAGEN"));

                Marca marca = new Marca();
                marca.setIdMarca(this.resultSet.getInt("ID_MARCA"));
                marca.setNombre(this.resultSet.getString("NOMBRE_MARCA"));

                TipoProducto tipoProd = new TipoProducto();
                tipoProd.setIdTipoProducto(this.resultSet.getInt("ID_TIPO_PRODUCTO"));
                tipoProd.setTipo(this.resultSet.getString("TIPO"));

                this.producto.setTipoProducto(tipoProd);
                this.producto.setMarca(marca);
            }
            case BUSCAR_POR_SKU -> {
                this.producto = new Producto();
                this.producto.setIdProducto(this.resultSet.getInt("PD.ID_NOMBRE"));
                this.producto.setNombre(this.resultSet.getString("PD.NOMBRE"));
                this.producto.setDescripcion(this.resultSet.getString("PD.DESCRIPCION"));
                this.producto.setCantidad(this.resultSet.getInt("PXS.STOCK_SEDE"));
            }
        }
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

//    @Override
//    public ArrayList<Producto> buscar_sku(String sku) {
//        this.value = 2;
//        List lista = new ArrayList<>();
//        try {
//            this.abrirConexion();
//            String sql = "SELECT p.NOMBRE,p.DESCRIPCION,p.PRECIO,ps.STOCK_SEDE,s.NOMBRE AS NOMBRE_SEDE ";
//            sql = sql.concat("FROM PRODUCTO p");
//            sql = sql.concat("JOIN PRODUCTO_X_SEDE ps ON p.ID_PRODUCTO = ps.ID_PRODUCTO");
//            sql = sql.concat("JOIN SEDE s ON ps.ID_SEDE = s.ID_SEDE");
//            sql = sql.concat("WHERE p.SKU = '?'");
//            this.colocarSQLenStatement(sql);
//            this.incluirParametroString(1, sku);
//            this.ejecutarConsultaEnBD(sql);
//            while (this.resultSet.next()) {
//                Producto p = new Producto();
//                p.setNombre(this.resultSet.getString("NOMBRE"));
//                p.setDescripcion(this.resultSet.getString("DESCRIPCION"));
//                p.setPrecio(this.resultSet.getDouble("PRECIO"));
//                p.setCantidad(this.resultSet.getInt("STOCK_SEDE"));
//                p.setNombreSede(this.resultSet.getString("NOMBRE_SEDE"));
//                lista.add(this.producto);
//            }
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar listarTodos - " + ex);
//        } finally {
//            try {
//                this.cerrarConexion();
//            } catch (SQLException ex) {
//                System.err.println("Error al cerrar la conexión - " + ex);
//            }
//        }
//        this.value = 0;
//        return (ArrayList<Producto>) lista;
//    }
    @Override
    public Producto buscar_sku(String sku, Integer idSede) {
        this.tipoOperacion = TipoOperacionInventario.BUSCAR_POR_SKU;
        this.producto = new Producto();
        this.producto.setSku(sku);
        this.producto.setIdSede(idSede);
        List prods = super.listarTodos(null);
        if (prods.isEmpty()) {
            return null;
        } else {
            return (Producto) prods.getFirst();
        }
    }

    @Override
    public Integer aumentarStock(Integer idProducto, Integer idSede, Integer cantidad) {
        StockSedeDAO stockSedeDAO = new StockSedeDAOImpl();
        return stockSedeDAO.aumentarStock(idSede, idSede, cantidad);
    }
}
