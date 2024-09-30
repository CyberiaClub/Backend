package pe.edu.pucp.cyberiastore.metodopago.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.metodopago.dao.BoletaDAO;
import pe.edu.pucp.cyberiastore.metodopago.model.Boleta;


public class BoletaDAOImpl extends MetodoDePagoDAOImpl implements BoletaDAO{
    private Boleta boleta;
    
    public BoletaDAOImpl() {
        super("BOLETA");
        this.boleta = null;
    }
    
    @Override
    public Integer insertar(Boleta boleta) {
        this.boleta = boleta;
        return this.insertar();
    }

    @Override
    public Integer modificar(Boleta boleta) {
        this.boleta = boleta;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Boleta boleta) {
        this.boleta = boleta;
        return this.eliminar();
    }

    @Override
    public ArrayList<Boleta> listarBoleta(String sql) {
        return null;
    }

    @Override
    public ArrayList<Boleta> listarTodosBoleta() {
        return null;
    }

    @Override
    public Boleta obtenerPorId(String idBoleta) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat(" and NUMERO_BOLETA = '" + idBoleta + "'");
        return this.listarBoleta(sql).getFirst();
    }

}
