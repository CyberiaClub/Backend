package pe.edu.pucp.cyberiastore.trabajador.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Vendedor;

public interface VendedorDAO {

    public Integer insertar(Vendedor vendedor);

    public Integer modificar(Vendedor vendedor);

    public Integer eliminar(Vendedor vendedor);

    public ArrayList<Vendedor> listarTodos();

    public Vendedor obtenerPorId(Integer idVendedor);

    public Boolean existeVendedor(Vendedor vendedor);

    public Boolean existeVendedor(Vendedor vendedor, Boolean abreConexion);
}
