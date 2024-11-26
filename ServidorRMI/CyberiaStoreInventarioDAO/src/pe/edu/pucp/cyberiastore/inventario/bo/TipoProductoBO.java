package pe.edu.pucp.cyberiastore.inventario.bo;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.TipoProductoDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.TipoProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;

public class TipoProductoBO {

    TipoProductoDAO tipoProductoDAO;

    public TipoProductoBO() {
        this.tipoProductoDAO = new TipoProductoDAOImpl();
    }

    public Integer insertar(TipoProducto tipoProducto) {
        return this.tipoProductoDAO.insertar(tipoProducto);
    }

    public Integer modificar(TipoProducto tipoProducto) {
        return this.tipoProductoDAO.modificar(tipoProducto);
    }

    public Integer eliminar(TipoProducto tipoProducto) {
        return this.tipoProductoDAO.eliminar(tipoProducto);
    }

    public ArrayList<TipoProducto> listarTodos() {
        ArrayList<TipoProducto> tiposProducto;
        tiposProducto = tipoProductoDAO.listarTodos();
        return tiposProducto;
    }

    public TipoProducto obtenerPorId(Integer idTipoProducto) {
        TipoProducto tipoProducto = this.tipoProductoDAO.obtenerPorId(idTipoProducto);
        return tipoProducto;
    }

}
