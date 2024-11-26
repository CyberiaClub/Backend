package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.inventario.dao.ProveedorDAO;
import pe.edu.pucp.cyberiastore.inventario.model.Proveedor;

public class ProveedorDAOImpl extends DAOImpl implements ProveedorDAO {

    private Proveedor proveedor;

    public ProveedorDAOImpl() {
        super("PROVEEDOR");
        this.proveedor = null;
    }

    /*
     * ************************************************************************
     * INSERTAR
     * ************************************************************************
     */
    @Override
    public Integer insertar(Proveedor proveedor) {
        this.proveedor = proveedor;
        Integer idProveedor = null;

        Boolean existeProveedor = this.existeProveedor(proveedor);
        this.proveedor = proveedor;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeProveedor) {
                this.retornarLlavePrimaria = true;
                idProveedor = super.insertar();
                this.retornarLlavePrimaria = false;

            } else {
                idProveedor = proveedor.getIdProveedor();
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
        return idProveedor;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "RUC,RAZON_SOCIAL, NOMBRE_DEL_CONTACTO, CORREO, TELEFONO, DIRECCION, DESCRIPCION";

    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?,?,?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.proveedor.getRuc());

        this.incluirParametroString(2, this.proveedor.getRazonSocial());
        this.incluirParametroString(3, this.proveedor.getNombreContacto());
        this.incluirParametroString(4, this.proveedor.getCorreo());
        this.incluirParametroString(5, this.proveedor.getTelefono());
        this.incluirParametroString(6, this.proveedor.getDireccion());
        this.incluirParametroString(7, this.proveedor.getDescripcion());
    }

    /*
     * ************************************************************************
     * MODIFICAR
     * ************************************************************************
     */
    @Override
    public Integer modificar(Proveedor proveedor) {
        Integer retorno = 0;
        this.proveedor = proveedor;
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
        return "RUC=?,RAZON_SOCIAL=?, NOMBRE_DEL_CONTACTO=?, CORREO=?, TELEFONO=?, DIRECCION=?, DESCRIPCION=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR
                || this.tipo_Operacion == Tipo_Operacion.ELIMINAR
                || this.tipo_Operacion == Tipo_Operacion.EXISTE) {
            sql = "ID_PROVEEDOR=?";
        } else {
            sql = "ID_PROVEEDOR=?";
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.proveedor.getRuc());
        this.incluirParametroString(2, this.proveedor.getRazonSocial());
        this.incluirParametroString(3, this.proveedor.getNombreContacto());
        this.incluirParametroString(4, this.proveedor.getCorreo());
        this.incluirParametroString(5, this.proveedor.getTelefono());
        this.incluirParametroString(6, this.proveedor.getDireccion());
        this.incluirParametroString(7, this.proveedor.getDescripcion());
        this.incluirParametroInt(8, this.proveedor.getIdProveedor());
    }

    /*
     * ************************************************************************
     * ELIMINAR
     * ************************************************************************
     */
    @Override
    public Integer eliminar(Proveedor proveedor) {
        Integer retorno = 0;
        this.proveedor = proveedor;

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
        this.incluirParametroInt(1, this.proveedor.getIdProveedor());
    }

    /*
     * ************************************************************************
     * LISTADOS
     * ************************************************************************
     */
    @Override
    public ArrayList<Proveedor> listarTodos() {
        return (ArrayList<Proveedor>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "";
        switch (this.tipo_Operacion) {
            case LISTAR -> {
                sql = "ID_PROVEEDOR, RUC, RAZON_SOCIAL, NOMBRE_DEL_CONTACTO, CORREO, TELEFONO, DIRECCION, DESCRIPCION";
            }
            case EXISTE -> {
                sql = "ID_PROVEEDOR";
            }
        }
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.proveedor);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.proveedor = new Proveedor();
        switch (this.tipo_Operacion) {
            case LISTAR -> {
                this.proveedor.setIdProveedor(this.resultSet.getInt("ID_PROVEEDOR"));
                this.proveedor.setRuc(this.resultSet.getString("RUC"));
                this.proveedor.setRazonSocial(this.resultSet.getString("RAZON_SOCIAL"));
                this.proveedor.setNombreContacto(this.resultSet.getString("NOMBRE_DEL_CONTACTO"));
                this.proveedor.setCorreo(this.resultSet.getString("CORREO"));
                this.proveedor.setTelefono(this.resultSet.getString("TELEFONO"));
                this.proveedor.setDireccion(this.resultSet.getString("DIRECCION"));
                this.proveedor.setDescripcion(this.resultSet.getString("DESCRIPCION"));
            }
            case EXISTE -> {
                this.proveedor.setIdProveedor(this.resultSet.getInt("ID_PROVEEDOR"));
            }
        }

    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.proveedor = null;
    }

    /*
     * ************************************************************************
     * OBTENER POR ID
     * ************************************************************************
     */
    @Override
    public Proveedor obtenerPorId(Integer idProveedor) {
        this.proveedor = new Proveedor();
        this.proveedor.setIdProveedor(idProveedor);
        super.buscar();
        return this.proveedor;
    }

    @Override
    protected void incluirValorDeParametrosParaBuscar() throws SQLException {
        this.incluirParametroInt(1, this.proveedor.getIdProveedor());
    }

    /*
     * *************************************************************************
     * EXISTE PROVEEDOR
     * Funciones adicionales
     * *************************************************************************
     */
    @Override
    public Boolean existeProveedor(Proveedor proveedor) {
        Boolean abreConexion = true;
        this.proveedor = proveedor;
        super.buscar();
        return this.proveedor != null;
    }
}
