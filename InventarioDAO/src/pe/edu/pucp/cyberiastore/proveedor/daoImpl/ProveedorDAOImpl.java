package pe.edu.pucp.cyberiastore.proveedor.daoImpl;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.daoImpl.ProveedorDAOImpl;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;

public class ProveedorDAOImpl extends DAOImpl implements ProveedorDAO {

    private Proveedor proveedor;

    public ProveedorDAOImpl() {
        super("PROVEEDOR");
        this.proveedor = null;
        this.retonarLlavePrimaria = true;
    }

    @Override
    public Integer insertar(Proveedor proveedor) {
        this.proveedor = proveedor;
        Integer id = this.insertar();
        return id;
    }

    @Override
    public Integer modificar(Proveedor proveedor) {
        this.proveedor = proveedor;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Proveedor proveedor) {
        this.proveedor = proveedor;
        return this.modificar();
    }

    @Override
    protected String obtenerListaAtributos() {
        return "RUC, NOMBRE, FECHA_REGISTRO, ACTIVO";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String valores = "";
        valores = valores.concat("'" + proveedor.getRuc() + "'");
        valores = valores.concat(", ");
        valores = valores.concat("'" + proveedor.getNombre() + "'");
        valores = valores.concat(", ");
        valores = valores.concat("'" + proveedor.getFechaRegistro() + "'");
        valores = valores.concat(", ");
        valores = valores.concat("'"+proveedor.getActivo()+"'");
        return valores;
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        String valores = "";
        valores = valores.concat("RUC: ");
        valores = valores.concat("'" + proveedor.getRuc() + "'");
        valores = valores.concat(", NOMBRE: ");
        valores = valores.concat("'" + proveedor.getNombre() + "'");
        valores = valores.concat(", FECHA_REGISTRO: ");
        valores = valores.concat("'" + proveedor.getFechaRegistro() + "'");
        valores = valores.concat(", ACTIVO: ");
        valores = valores.concat("'"+proveedor.getActivo()+"'");
        return valores;
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("RUC = ");
        sql = sql.concat("'" + proveedor.getRuc() + "'");
        return sql;
    }

    @Override
    public ArrayList<Proveedor> listar(String listado) {
        ArrayList<Proveedor> listadoProveedores = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.abrirConexion();
            this.ejecutarConsultaEnBD(listado);
            while (this.resultSet.next()) {
                Proveedor plantillaProveedor = new Proveedor(
                        this.resultSet.getString("RUC"),
                        this.resultSet.getString("NOMBRE"),
                        sdf.parse(this.resultSet.getString("FECHA_REGISTRO"))
                );
                listadoProveedores.add(plantillaProveedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listadoProveedores;
    }

    @Override
    public ArrayList<Proveedor> listarTodos() {
        String sql = this.obtenerListaValoresParaSeleccionar();
        return this.listar(sql);
    }

    @Override
    public Proveedor obtenerPorId(String ruc) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat(" and RUC = '" + ruc + "'");
        return this.listar(sql).getFirst();
    }
    
    @Override
    public Integer obtenerId(Proveedor proveedor) {
        this.proveedor = proveedor;
        try {
            Integer id = this.retornarUltimoAutogenerado();
            this.proveedor.setIdProveedor(id);
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public String imprimirId(){
        return "" + this.proveedor.getIdProveedor();
    }
}
