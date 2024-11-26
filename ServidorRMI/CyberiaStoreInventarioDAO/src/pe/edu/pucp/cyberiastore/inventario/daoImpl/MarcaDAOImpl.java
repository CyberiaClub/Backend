package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import jdk.dynalink.linker.support.Guards;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.dao.MarcaDAO;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.inventario.model.Proveedor;

public class MarcaDAOImpl extends DAOImpl implements MarcaDAO {

    private Marca marca;

    public MarcaDAOImpl() {
        super("MARCA");
        this.marca = null;
        this.retornarLlavePrimaria = true;
    }

    /*
     * ************************************************************************
     * INSERTAR
     * ************************************************************************
     */
    @Override
    public Integer insertar(Marca marca) {
        this.marca = marca;
        Integer idMarca = null;

        Boolean existeMarca = this.existeMarca(marca);
        this.marca = marca;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeMarca) {
                this.retornarLlavePrimaria = true;
                idMarca = super.insertar();

                this.retornarLlavePrimaria = false;

            } else {
                idMarca = marca.getIdMarca();
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
        return idMarca;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "NOMBRE,IMAGEN,ID_PROVEEDOR";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.marca.getNombre());
        this.incluirParametroByte(2, this.marca.getImagen());
        this.incluirParametroInt(3, this.marca.getProveedor().getIdProveedor());
    }

    /*
     * ************************************************************************
     * MODIFICAR
     * ************************************************************************
     */
    @Override
    public Integer modificar(Marca marca) {
        Integer retorno = 0;
        this.marca = marca;
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
        return "NOMBRE=?,IMAGEN=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR ||
                this.tipo_Operacion == Tipo_Operacion.ELIMINAR ||
                this.tipo_Operacion==Tipo_Operacion.EXISTE) {
            sql = "ID_MARCA=? ";
        }
        
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.marca.getNombre());
        this.incluirParametroByte(2, this.marca.getImagen());
        this.incluirParametroInt(3, this.marca.getIdMarca());
    }

    /*
     * ************************************************************************
     * ELIMINAR
     * ************************************************************************
     */
    @Override
    public Integer eliminar(Marca marca) {
        Integer retorno = 0;
        this.marca = marca;

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
        this.incluirParametroInt(1, this.marca.getIdMarca());
    }

    /*
     * ************************************************************************
     * LISTADOS
     * ************************************************************************
     */
    @Override
    public ArrayList<Marca> listarTodos() {
        return (ArrayList<Marca>) super.listarTodos(null);
    }

    @Override
    public ArrayList<Marca> listarIdNombre() {
        return null;
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "";
        switch (this.tipo_Operacion) {
            case LISTAR -> {
                sql = "M.ID_MARCA, M.NOMBRE, M.IMAGEN, PR.ID_PROVEEDOR, PR.RAZON_SOCIAL ";
            }
            case EXISTE -> {
                sql = "ID_MARCA";
            }
        }
        return sql;
    }

    @Override
    protected String obtenerPredicadoParaListado() {
        String sql = "";

        sql = sql.concat(" M ");
        sql = sql.concat("join PROVEEDOR PR on M.ID_PROVEEDOR = PR.ID_PROVEEDOR");

        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.marca);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.marca = new Marca();
        switch (this.tipo_Operacion) {
            case LISTAR -> {
                this.marca.setIdMarca(this.resultSet.getInt("M.ID_MARCA"));
                this.marca.setNombre(this.resultSet.getString("M.NOMBRE"));
                this.marca.setImagen(this.resultSet.getBytes("M.IMAGEN"));

                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(this.resultSet.getInt("PR.ID_PROVEEDOR"));
                proveedor.setRazonSocial(this.resultSet.getString("PR.RAZON_SOCIAL"));

                this.marca.setProveedor(proveedor);
            }
            case EXISTE -> {
                this.marca.setIdMarca(this.resultSet.getInt("ID_MARCA"));
            }
        }

    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.marca = null;
    }

    /*
     * ************************************************************************
     * OBTENER POR ID
     * ************************************************************************
     */
    @Override
    public Marca obtenerPorId(Integer idMarca) {
        this.tipo_Operacion = Tipo_Operacion.BUSCAR_POR_ID;
        this.marca = new Marca();
        this.marca.setIdMarca(idMarca);
        super.buscar();
        return this.marca;
    }

    @Override
    protected void incluirValorDeParametrosParaBuscar() throws SQLException {
        this.incluirParametroInt(1, this.marca.getIdMarca());
    }

    /*
     * *************************************************************************
     * EXISTE MARCA
     * Funciones adicionales
     * *************************************************************************
     */
    @Override
    public Boolean existeMarca(Marca marca) {
        this.tipo_Operacion = Tipo_Operacion.EXISTE;
        Boolean abreConexion = true;
        this.marca = marca;
        super.buscar();
        return this.marca != null;
    }

}
