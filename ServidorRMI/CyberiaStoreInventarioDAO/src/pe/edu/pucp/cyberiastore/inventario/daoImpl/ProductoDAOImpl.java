package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import pe.edu.pucp.cyberiastore.inventario.model.TipoOperacionInventario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;
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
    private TipoOperacionInventario tipoOperacionInv;

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
        this.producto = producto;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeProducto) {
                this.retornarLlavePrimaria = true;
                idProducto = super.insertar();
                this.retornarLlavePrimaria = false;
                // insertar productos individuales
                if (idProducto != 0) {
                    ArrayList<Producto> productosMiembros = this.producto.getProductosMiembros();
                    if (productosMiembros != null) {
                        ProductoXProductoDAO productoXProducto = new ProductoXProductoDAOImpl();
                        for (Producto productoMiembro : productosMiembros) {
                            // idProducto es el padre, productoMiembro del hijo, cantidad
                            productoXProducto.insertar(idProducto, productoMiembro.getIdProducto(), productoMiembro.getCantidad(), this.usarTransaccion, this.conexion);
                        }
                    }
                }
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
                this.tipo_Operacion = null;
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
                this.tipo_Operacion = null;
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
        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    sql = "SKU=?";
                }
                case LISTAR -> {
                    sql = "";
                }
                default -> {
                    sql = "ID_PRODUCTO=?";
                }
            }
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
                this.tipo_Operacion = null;
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
     * LISTAR TODOS
     * ************************************************************************
     */
    @Override
    public ArrayList<Producto> listarTodos() {
        this.tipo_Operacion = Tipo_Operacion.LISTAR;
        this.value = 1;
        ArrayList<Producto> productos = (ArrayList<Producto>) super.listarTodos(null);
        this.tipo_Operacion = null;
        return productos;
        
        
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "";
        if (this.tipoOperacionInv != null) {
            switch (this.tipoOperacionInv) {
                case BUSCAR_POR_SKU -> {
                    sql = sql.concat("PD.ID_PRODUCTO,PD.SKU,PD.NOMBRE, PD.DESCRIPCION, PD.PRECIO,PD.IMAGEN,PXS.STOCK_SEDE ");
                }
                case BUSCAR_POR_PEDIDO -> {
                    sql = sql.concat("P.ID_PRODUCTO,P.NOMBRE,P.PRECIO,CXP.CANTIDAD ");
                }
            }
        }
        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    sql = sql.concat("ID_PRODUCTO ");
                }
                default -> {
                    sql = sql.concat(" PD.ID_PRODUCTO, PD.SKU, PD.NOMBRE, PD.DESCRIPCION, PD.PRECIO, PD.PRECIO_PROVEEDOR, ");
                    sql = sql.concat("PD.IMAGEN, M.ID_MARCA, M.NOMBRE AS NOMBRE_MARCA, TP.ID_TIPO_PRODUCTO, TP.TIPO, ");
                    sql = sql.concat("PXS.ID_SEDE, PXS.STOCK_SEDE");
                }
            }
        }
        return sql;
    }

    @Override
    protected String obtenerPredicadoParaListado() {
        String sql = "";
        if (this.tipoOperacionInv != null) {
            switch (this.tipoOperacionInv) {
                case BUSCAR_POR_SKU -> {
                    sql = sql.concat(" PD ");
                    sql = sql.concat("join PRODUCTO_X_SEDE PXS on PD.ID_PRODUCTO = PXS.ID_PRODUCTO ");
                    sql = sql.concat("where PD.SKU=? AND PXS.ID_SEDE=?");
                }
                case BUSCAR_POR_PEDIDO -> {
                    sql = sql.concat(" P ");
                    sql = sql.concat("join COMPROBANTE_DE_PAGO_X_PRODUCTO CXP on P.ID_PRODUCTO = CXP.ID_PRODUCTO ");
                    sql = sql.concat("where CXP.ID_COMPROBANTE_DE_PAGO=?");
                }
            }
        }
        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    sql = "";
                }
                default -> {
                    sql = sql.concat(" PD ");
                    sql = sql.concat("join PRODUCTO_X_SEDE PXS on PD.ID_PRODUCTO = PXS.ID_PRODUCTO ");
                    sql = sql.concat("join MARCA M on PD.ID_MARCA = M.ID_MARCA ");
                    sql = sql.concat("join TIPO_PRODUCTO TP on PD.ID_TIPO_PRODUCTO = TP.ID_TIPO_PRODUCTO ");
                }
            }
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaListado() throws SQLException {
        if (this.tipoOperacionInv != null) {
            switch (this.tipoOperacionInv) {
                case BUSCAR_POR_SKU -> {
                    this.incluirParametroString(1, this.producto.getSku());
                    this.incluirParametroInt(2, this.producto.getIdSede());
                }
                case BUSCAR_POR_PEDIDO -> {
                    this.incluirParametroInt(1, this.producto.getIdPedido());
                }
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
        this.producto = new Producto();

        if (this.tipoOperacionInv != null) {
            switch (this.tipoOperacionInv) {
                case BUSCAR_POR_SKU -> {
                    this.producto.setIdProducto(this.resultSet.getInt("PD.ID_PRODUCTO"));
                    this.producto.setSku(this.resultSet.getString("PD.SKU"));
                    this.producto.setNombre(this.resultSet.getString("PD.NOMBRE"));
                    this.producto.setDescripcion(this.resultSet.getString("PD.DESCRIPCION"));
                    this.producto.setPrecio(this.resultSet.getDouble("PD.PRECIO"));
                    this.producto.setImagen(this.resultSet.getBytes("PD.IMAGEN"));
                    this.producto.setCantidad(this.resultSet.getInt("PXS.STOCK_SEDE"));
                }
                case BUSCAR_POR_PEDIDO -> {
                    this.producto.setIdProducto(this.resultSet.getInt("P.ID_PRODUCTO"));
                    this.producto.setNombre(this.resultSet.getString("P.NOMBRE"));
                    this.producto.setPrecio(this.resultSet.getDouble("P.PRECIO"));
                    this.producto.setCantidad(this.resultSet.getInt("CXP.CANTIDAD"));
                }
            }
        }

        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    this.producto.setIdProducto(this.resultSet.getInt("ID_PRODUCTO"));
                }
                default -> {
                    this.producto.setIdProducto(this.resultSet.getInt("ID_PRODUCTO"));
                    this.producto.setSku(this.resultSet.getString("SKU"));
                    this.producto.setNombre(this.resultSet.getString("NOMBRE"));
                    this.producto.setDescripcion(this.resultSet.getString("DESCRIPCION"));
                    this.producto.setPrecio(this.resultSet.getDouble("PRECIO"));
                    this.producto.setPrecioProveedor(this.resultSet.getDouble("PRECIO_PROVEEDOR"));
                    this.producto.setImagen(this.resultSet.getBytes("IMAGEN"));
                    this.producto.setIdSede(this.resultSet.getInt("PXS.ID_SEDE"));
                    this.producto.setCantidad(this.resultSet.getInt("PXS.STOCK_SEDE"));

                    Marca marca = new Marca();
                    marca.setIdMarca(this.resultSet.getInt("ID_MARCA"));
                    marca.setNombre(this.resultSet.getString("NOMBRE_MARCA"));

                    TipoProducto tipoProd = new TipoProducto();
                    tipoProd.setIdTipoProducto(this.resultSet.getInt("ID_TIPO_PRODUCTO"));
                    tipoProd.setTipo(this.resultSet.getString("TIPO"));

                    this.producto.setTipoProducto(tipoProd);
                    this.producto.setMarca(marca);
                }
            }
        }
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.producto = null;
    }

    /*
     * ************************************************************************
     * OBTENER POR ID
     * ************************************************************************
     */
    @Override
    public Producto obtenerPorId(Integer idProducto) {
        this.tipo_Operacion = Tipo_Operacion.BUSCAR_POR_ID;
        this.producto = new Producto();
        this.producto.setIdProducto(idProducto);
        super.buscar();
        this.tipo_Operacion = null;
        return this.producto;
    }

    @Override
    protected void incluirValorDeParametrosParaBuscar() throws SQLException {
        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    this.incluirParametroString(1, this.producto.getSku());
                }
                case BUSCAR_POR_ID -> {
                    this.incluirParametroInt(1, this.producto.getIdProducto());
                }
            }
        }

    }

    /*
     * *************************************************************************
     * EXISTE PRODUCTO
     * Funciones adicionales
     * *************************************************************************
     */
    @Override
    public Boolean existeProducto(Producto producto) {
        this.tipo_Operacion = Tipo_Operacion.EXISTE;
        Boolean abreConexion = true;
        this.producto = producto;
        super.buscar();
        this.tipo_Operacion =null;
        return this.producto != null;
    }

    /*
     * *************************************************************************
     * BUSCAR POR SKU
     * Funciones adicionales
     * *************************************************************************
     */
    
    @Override
    public Producto buscar_sku(String sku, Integer idSede) {
        this.tipoOperacionInv = TipoOperacionInventario.BUSCAR_POR_SKU;
        this.producto = new Producto();
        this.producto.setSku(sku);
        this.producto.setIdSede(idSede);
        List prods = super.listarTodos(null);
        this.tipoOperacionInv = null;
        if (prods.isEmpty()) {
            return null;
        } else {
            return (Producto) prods.getFirst();
        }
    }

    /*
     * *************************************************************************
     * AUMENTAR STOCK
     * Funciones adicionales
     * *************************************************************************
     */
    @Override
    public Integer aumentarStock(Integer idProducto, Integer idSede, Integer cantidad) {
        StockSedeDAO stockSedeDAO = new StockSedeDAOImpl();
        return stockSedeDAO.aumentarStock(idProducto, idSede, cantidad);
    }

    /*
     * *************************************************************************
     * LINEAS DE PEDIDO
     * Funciones adicionales
     * *************************************************************************
     */
    @Override
    public ArrayList<Producto> lineasPedido(Integer idPedido) {
        this.tipoOperacionInv = TipoOperacionInventario.BUSCAR_POR_PEDIDO;
        this.producto = new Producto();
        this.producto.setIdPedido(idPedido);
        List lineas = super.listarTodos(null);
         this.tipoOperacionInv = null;
        if (lineas.isEmpty()) {
            return null;
        } else {
            return (ArrayList<Producto>) lineas;
        }
    }
}
