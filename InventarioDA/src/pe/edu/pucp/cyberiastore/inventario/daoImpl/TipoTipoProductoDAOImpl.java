package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.TipoProductoDAO;

public class TipoTipoProductoDAOImpl extends DAOImpl implements TipoProductoDAO {

    private TipoProducto tipoProducto;

    public TipoTipoProductoDAOImpl(){
        super("TIPOPRODUCTO");
        this.tipoProducto = null;
    }

    @Override
    public Integer insertar(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this.insertar();
    }

    @Override
    public Integer modificar(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this.modificar();
    }

    @Override
    public Integer eliminar(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
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
    public ArrayList<TipoProducto> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TipoProducto> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoProducto obtenerPorId(String idTipoProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
