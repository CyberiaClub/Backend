package pe.edu.pucp.cyberiastore.inventario.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.MarcaDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.MarcaDAO;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;

public class MarcaBO {
    MarcaDAO marcaDAO;
    
    public MarcaBO(){
        this.marcaDAO = new MarcaDAOImpl();
    }
    
    public Integer insertar(String nombre){
        Marca marca = new Marca(nombre);
        return this.marcaDAO.insertar(marca);
    }
    
    public Integer modificar(String nombre){
        Marca marca = new Marca(nombre);
        return this.marcaDAO.modificar(marca);
    }
    
    public Integer eliminar(String nombre){
        Marca marca = new Marca(nombre);
        return this.marcaDAO.eliminar(marca);
    }
    
    public ArrayList<Marca> listarTodos(){
        ArrayList<Marca> marcas = new ArrayList();
        
        return marcas;
    }
    
    public Marca buscarPorId(Integer idMarca){
        Marca marca = this.marcaDAO.obtenerPorId(""+idMarca);
        
        return marca;
    }
    
}
