package pe.edu.pucp.cyberiastore.metodopago.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.metodopago.dao.MetodoDePagoDAO;
import pe.edu.pucp.cyberiastore.metodopago.model.MetodoDePago;


public class MetodoDePagoDAOImpl extends DAOImpl implements MetodoDePagoDAO{
    private MetodoDePago metodoDePago;
    
    public MetodoDePagoDAOImpl(){
        super("METODO_PAGO");
        this.metodoDePago = null;
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
    public Integer insertar(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
        return this.insertar();
    }

    @Override
    public Integer modificar(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
        return this.modificar();
    }

    @Override
    public Integer eliminar(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
        return this.eliminar();
    }

    @Override
    public ArrayList<MetodoDePago> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<MetodoDePago> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MetodoDePago obtenerPorId(String idMetodoDePago) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat(" and ID_METODO_PAGO = '" + idMetodoDePago + "'");
        return this.listar(sql).getFirst();
    }
}
