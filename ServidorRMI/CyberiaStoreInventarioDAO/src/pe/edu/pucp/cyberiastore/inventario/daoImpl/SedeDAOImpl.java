package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import pe.edu.pucp.cyberiastore.inventario.model.Sede;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.TipoOperacionInventario;
import pe.edu.pucp.cyberiastore.inventario.dao.SedeDAO;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;

public class SedeDAOImpl extends DAOImpl implements SedeDAO {

    private Sede sede;
    private TipoOperacionInventario tipoOperacionInventario;

    public SedeDAOImpl() {
        super("SEDE");
        this.sede = null;
        this.tipo_Operacion = null;
    }

    /*
     * ************************************************************************
     * INSERTAR
     * ************************************************************************
     */
    @Override
    public Integer insertar(Sede sede) {
        this.sede = sede;
        Integer idSede = null;

        Boolean existeSede = this.existeSede(sede);
        this.sede = sede;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeSede) {
                this.retornarLlavePrimaria = true;
                idSede = super.insertar();
                this.retornarLlavePrimaria = false;

            } else {
                idSede = sede.getIdSede();
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
        return idSede;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "NOMBRE, DESCRIPCION, TELEFONO, HORARIO_APERTURA, HORARIO_CIERRE";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.sede.getNombre());
        this.incluirParametroString(2, this.sede.getDescripcion());
        this.incluirParametroString(3, this.sede.getTelefono());
        this.incluirParametroLocalTime(4, this.sede.getHorarioApertura());
        this.incluirParametroLocalTime(5, this.sede.getHorarioCierre());
    }

    /*
     * ************************************************************************
     * MODIFICAR
     * ************************************************************************
     */
    @Override
    public Integer modificar(Sede sede) {
        Integer retorno = 0;
        this.sede = sede;
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
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "NOMBRE=?, DESCRIPCION=?, TELEFONO=?,HORARIO_APERTURA=?,HORARIO_CIERRE=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipoOperacionInventario != null) {
            switch (this.tipoOperacionInventario) {
                case LISTAR_STOCK_SEDE -> {
                    sql = "PER.ID_SEDE=?";
                }
                default ->
                    sql = "";
            }
        }
        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    sql = "NOMBRE=?";
                }
                case LISTAR -> {
                    sql = "";
                }
                default -> {
                    sql = "ID_SEDE=?";
                }
            }
        }

        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.sede.getNombre());
        this.incluirParametroString(2, this.sede.getDescripcion());
        this.incluirParametroString(3, this.sede.getTelefono());
        this.incluirParametroLocalTime(4, this.sede.getHorarioApertura());
        this.incluirParametroLocalTime(5, this.sede.getHorarioCierre());
        this.incluirParametroInt(6, this.sede.getIdSede());

    }

    /*
     * ************************************************************************
     * ELIMINAR
     * ************************************************************************
     */
    @Override
    public Integer eliminar(Sede sede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * ************************************************************************
     * LISTADOS
     * ************************************************************************
     */
    @Override
    public ArrayList<Sede> listarTodos() {
        this.tipo_Operacion = Tipo_Operacion.LISTAR;
        return (ArrayList<Sede>) super.listarTodos(null);
    }

    @Override
    public ArrayList<Producto> listarProductosSede(Integer idSede) {
        this.tipoOperacionInventario = TipoOperacionInventario.LISTAR_STOCK_SEDE;
        this.sede = new Sede();
        this.sede.setIdSede(idSede);
        return (ArrayList<Producto>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "";
        if (this.tipoOperacionInventario != null) {
            switch (this.tipoOperacionInventario) {
                case TipoOperacionInventario.LISTAR_STOCK_SEDE ->
                    sql = sql.concat("PD.SKU, PD.NOMBRE, PD.DESCRIPCION, PD.PRECIO,TP.TIPO, M.NOMBRE, PXS.STOCK_SEDE");
                default ->
                    sql = "";
            }
        }

        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    sql = sql.concat("ID_SEDE");
                }
                default ->
                    sql = sql.concat("ID_SEDE, NOMBRE, DESCRIPCION, TELEFONO, HORARIO_APERTURA, HORARIO_CIERRE");
            }
        }
        return sql;
    }

    @Override
    protected String obtenerPredicadoParaListado() {
        String sql = "";
        if (this.tipoOperacionInventario != null) {
            switch (this.tipoOperacionInventario) {
                case TipoOperacionInventario.LISTAR_STOCK_SEDE -> {
                    sql = sql.concat(" S ");
                    sql = sql.concat("JOIN PRODUCTO_X_SEDE PXS ON S.ID_SEDE = PXS.ID_SEDE ");
                    sql = sql.concat("JOIN PRODUCTO PD ON PXS.ID_PRODUCTO = PD.ID_PRODUCTO ");
                    sql = sql.concat("JOIN TIPO_PRODUCTO TP ON PD.ID_TIPO_PRODUCTO = TP.ID_TIPO_PRODUCTO ");
                    sql = sql.concat("JOIN MARCA M ON PD.ID_MARCA = M.ID_MARCA ");
                    sql = sql.concat("WHERE S.ID_SEDE = ?");
                }
                default -> {
                    sql = "";
                }
            }
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaListado() throws SQLException {
        if (this.tipoOperacionInventario != null) {
            switch (this.tipoOperacionInventario) {
                case TipoOperacionInventario.LISTAR_STOCK_SEDE -> {
                    this.incluirParametroInt(1, this.sede.getIdSede());
                }
            }
        }
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        if (this.tipoOperacionInventario != null) {
            switch (this.tipoOperacionInventario) {
                case TipoOperacionInventario.LISTAR_STOCK_SEDE ->
                    lista.add(this.sede.getProducto());
                default ->
                    throw new AssertionError();
            }
        }

        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case LISTAR -> {
                    lista.add(this.sede);
                }
            }
        }
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.sede = new Sede();
        if (this.tipoOperacionInventario != null) {
            switch (this.tipoOperacionInventario) {
                case TipoOperacionInventario.LISTAR_STOCK_SEDE -> {
                    Producto producto = new Producto();
                    producto.setSku(this.resultSet.getString("PD.SKU"));
                    producto.setNombre(this.resultSet.getString("PD.NOMBRE"));
                    producto.setDescripcion(this.resultSet.getString("PD.DESCRIPCION"));
                    producto.setPrecio(this.resultSet.getDouble("PD.PRECIO"));
                    producto.setCantidad(this.resultSet.getInt("PXS.STOCK_SEDE"));

                    TipoProducto tipoProd = new TipoProducto();
                    tipoProd.setTipo(this.resultSet.getString("TP.TIPO"));
                    Marca marca = new Marca();
                    marca.setNombre(this.resultSet.getString("M.NOMBRE"));

                    producto.setTipoProducto(tipoProd);
                    producto.setMarca(marca);

                    this.sede.setProducto(producto);
                }
            }
        }

        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    this.sede.setIdSede(this.resultSet.getInt("ID_SEDE"));
                }
                default -> {

                    this.sede.setIdSede(this.resultSet.getInt("ID_SEDE"));
                    this.sede.setNombre(this.resultSet.getString("NOMBRE"));
                    this.sede.setDescripcion(this.resultSet.getString("DESCRIPCION"));
                    this.sede.setTelefono(this.resultSet.getString("TELEFONO"));
                    this.sede.setHorarioApertura(this.resultSet.getTime("HORARIO_APERTURA").toLocalTime());
                    this.sede.setHorarioCierre(this.resultSet.getTime("HORARIO_CIERRE").toLocalTime());
                }
            }
        }
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.sede = null;
    }

    /*
     * ************************************************************************
     * OBTENER POR ID
     * ************************************************************************
     */
    @Override
    public Sede obtenerPorId(Integer idSede) {
        this.tipo_Operacion = Tipo_Operacion.BUSCAR_POR_ID;
        this.sede = new Sede();
        this.sede.setIdSede(idSede);
        super.buscar();
        return this.sede;
    }

    @Override
    protected void incluirValorDeParametrosParaBuscar() throws SQLException {
        if (this.tipo_Operacion != null) {
            switch (this.tipo_Operacion) {
                case EXISTE -> {
                    this.incluirParametroString(1, this.sede.getNombre());
                }
                case BUSCAR_POR_ID -> {
                    this.incluirParametroInt(1, this.sede.getIdSede());
                }
            }
        }

    }

    /*
     * *************************************************************************
     * EXISTE SEDE
     * Funciones adicionales
     * *************************************************************************
     */
    @Override
    public Boolean existeSede(Sede sede) {
        this.tipo_Operacion = Tipo_Operacion.EXISTE;
        Boolean abreConexion = true;
        this.sede = sede;
        super.buscar();
        return this.sede != null;
    }

}
