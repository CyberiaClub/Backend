package pe.edu.pucp.cyberiastore.trabajador.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Vendedor;



public interface VendedorDAO {
    public Integer insertar(Vendedor  vendedor);
    
    public Integer modificar(Vendedor  vendedor);
    
    public ArrayList<Vendedor> listarTodosAdministradores();
    
    public Vendedor obtenerPorId(Integer idAdministrador);
    //
    public void insertarIdUsuario(Integer idUsuario);
    
    public void insertarIdTrabajador(Integer idTrabajador);
    
    public void insertarIdVendedor(Integer idVendedor);
}
