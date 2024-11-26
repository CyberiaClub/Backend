package pe.edu.pucp.cyberiastore.oferta.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.oferta.dao.OfertaDAO;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.oferta.dao.ProductoXOfertaDAO;

public class OfertaDAOImpl extends DAOImpl implements OfertaDAO {

    private Oferta oferta;

    public OfertaDAOImpl() {
        super("OFERTA");
        this.oferta = null;
    }

    /*
     * ************************************************************************
     * Insertar
     * ************************************************************************
     */
    @Override
    public Integer insertar(Oferta oferta) {
        this.oferta = oferta;
        Integer idOferta = null;

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();

            this.retornarLlavePrimaria = true;
            idOferta = super.insertar();
            this.retornarLlavePrimaria = false;

            ProductoXOfertaDAO productoXOferta = new ProductoXOfertaDAOImpl();
            ArrayList<Producto> productosOferta = oferta.getProductos();

            for (Producto producto : productosOferta) {
                System.out.println("Id del producto otra vez: " + producto.getIdProducto());
                productoXOferta.insertar(producto.getIdProducto(), idOferta, producto.getOferta(), this.usarTransaccion, this.conexion);
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
        return idOferta;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "FECHA_INICIO, FECHA_FIN, IMAGEN";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroDate(1, this.oferta.getFechaDeInicio());
        this.incluirParametroDate(2, this.oferta.getFechaDeFin());
        this.incluirParametroByte(3, this.oferta.getImagen());
    }

    /*
     * **************************************************************************
     * MODIFICAR
     * *************************************************************************
     */
    @Override
    public Integer modificar(Oferta oferta) {
        Integer retorno = 0;
        this.oferta = oferta;
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
        return "FECHA_INICIO=?, FECHA_FIN=?,IMAGEN=?";
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if(this.tipo_Operacion != null){
            switch(this.tipo_Operacion){
                case LISTAR->{
                    sql = "";
                }
                default->{
                    sql = "ID_OFERTA=?";
                }
            }
        }
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "ID_OFERTA=?";
        } else {
            sql = "PER.ID_OFERTA=?";
        }
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroDate(1, this.oferta.getFechaDeInicio());
        this.incluirParametroDate(2, this.oferta.getFechaDeFin());
        this.incluirParametroByte(3, this.oferta.getImagen());
        this.incluirParametroInt(4, this.oferta.getIdOferta());

    }

    /*
     * **************************************************************************
     * ELIMINIAR
     * *************************************************************************
     */
    @Override
    public Integer eliminar(Oferta oferta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * **************************************************************************
     * LISTAR TODOS
     * *************************************************************************
     */
    @Override
    public ArrayList<Oferta> listarTodos() {
        this.tipo_Operacion = Tipo_Operacion.LISTAR;
        return (ArrayList<Oferta>) super.listarTodos(null);
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "ID_OFERTA, FECHA_INICIO, FECHA_FIN, PORCENTAJE,IMAGEN";
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.oferta);
    }

    @Override
    protected void incluirValorDeParametrosParaBuscar() throws SQLException {
        this.incluirParametroInt(1, this.oferta.getIdOferta());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.oferta = new Oferta();
        this.oferta.setIdOferta(this.resultSet.getInt("ID_OFERTA"));
        this.oferta.setFechaDeInicio(this.resultSet.getDate("FECHA_INICIO"));
        this.oferta.setFechaDeFin(this.resultSet.getDate("FECHA_FIN"));
        this.oferta.setPorcentaje(this.resultSet.getInt("PORCENTAJE"));
        this.oferta.setImagen(this.resultSet.getBytes("IMAGEN"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.oferta = null;
    }

    /*
     * *************************************************************************
     * OBTENER POR ID
     * Funciones adicionales
     * *************************************************************************
     */
    @Override
    public Oferta obtenerPorId(Integer idOferta) {
        this.tipo_Operacion = Tipo_Operacion.BUSCAR_POR_ID;
        this.oferta = new Oferta();
        this.oferta.setIdOferta(idOferta);
        super.buscar();
        return this.oferta;
    }

}
