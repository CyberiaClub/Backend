package pe.edu.pucp.cyberiastore.inventario.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.ProveedorDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.ProveedorDAO;
import pe.edu.pucp.cyberiastore.inventario.model.Proveedor;

public class ProveedorBO {

    ProveedorDAO proveedorDAO;

    public ProveedorBO() {
        this.proveedorDAO = new ProveedorDAOImpl();
    }

    public Integer insertar(Proveedor proveedor) {
        return this.proveedorDAO.insertar(proveedor);
    }

    public Integer modificar(Proveedor proveedor) {
        return this.proveedorDAO.modificar(proveedor);
    }

    public Integer eliminar(Proveedor proveedor) {
        return this.proveedorDAO.eliminar(proveedor);
    }

    public ArrayList<Proveedor> listarTodos() {
        ArrayList<Proveedor> proveedores = this.proveedorDAO.listarTodos();
        return proveedores;
    }

    public Proveedor obtenerPorId(Integer idProveedor) {
        Proveedor proveedor = this.proveedorDAO.obtenerPorId(idProveedor);
        return proveedor;
    }

}
