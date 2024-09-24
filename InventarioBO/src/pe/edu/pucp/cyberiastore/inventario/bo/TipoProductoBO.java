package pe.edu.pucp.cyberiastore.inventario.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.TipoTipoProductoDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.TipoProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;

public class TipoProductoBO {
    TipoProductoDAO tipoProductoDAO;
    
    public TipoProductoBO(){
        this.tipoProductoDAO = new TipoTipoProductoDAOImpl();
    }
    
    public Integer insertar(String tipo){
        TipoProducto tipoProducto = new TipoProducto(tipo);
        return this.tipoProductoDAO.insertar(tipoProducto);
    }
    
    public Integer modificar(String tipo){
        TipoProducto tipoProducto = new TipoProducto(tipo);
        return this.tipoProductoDAO.modificar(tipoProducto);
    }
    
    public Integer eliminar(String tipo){
        TipoProducto tipoProducto = new TipoProducto(tipo);
        return this.tipoProductoDAO.eliminar(tipoProducto);
    }
    
    public ArrayList<TipoProducto> listarTodos(){
        ArrayList<TipoProducto> tiposProducto = new ArrayList();
        
        return tiposProducto;
    }
    
    public TipoProducto buscarPorId(Integer idTipoProducto){
        TipoProducto tipoProducto = this.tipoProductoDAO.obtenerPorId(""+idTipoProducto);
        
        return tipoProducto;
    }
    
}
