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
    
    public Integer insertar(Marca marca){
        return this.marcaDAO.insertar(marca);
    }
    
    public Integer eliminar(Marca marca){
        return this.marcaDAO.eliminar(marca);
    }
    
    public ArrayList<Marca> listarTodos(){
        ArrayList<Marca> marcas = this.marcaDAO.listarTodos();
        return marcas;
    }
    
    public Marca obtenerPorId(Integer idMarca){
        Marca marca = this.marcaDAO.obtenerPorId(idMarca);
        return marca;
    }
}
