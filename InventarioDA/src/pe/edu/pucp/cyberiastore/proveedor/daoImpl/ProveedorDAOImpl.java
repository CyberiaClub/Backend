package pe.edu.pucp.cyberiastore.proveedor.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProveedorDAO;

public class ProveedorDAOImpl extends DAOImpl implements ProveedorDAO{
    private Proveedor proveedor;

    public ProveedorDAOImpl() {
        super("PROVEEDOR");
        this.proveedor = null;
    }

    @Override
    public Integer insertar(Proveedor proveedor) {
        this.proveedor = proveedor;
        return this.insertar();
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerCondicionPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Proveedor> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Proveedor> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Proveedor obtenerPorId(String idProveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
