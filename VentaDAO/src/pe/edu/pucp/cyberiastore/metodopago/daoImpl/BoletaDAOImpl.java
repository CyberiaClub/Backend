package pe.edu.pucp.cyberiastore.metodopago.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.metodopago.bo.MetodoDePagoBO;
import pe.edu.pucp.cyberiastore.metodopago.dao.BoletaDAO;
import pe.edu.pucp.cyberiastore.metodopago.model.Boleta;

public class BoletaDAOImpl extends MetodoDePagoDAOImpl implements BoletaDAO {

    private Boleta boleta;

    public BoletaDAOImpl() {
        super("BOLETA");
        this.boleta = null;
        this.retonarLlavePrimaria = true;
    }

    @Override
    public Integer insertar(Boleta boleta) {
        this.boleta = boleta;
        Integer id = super.insertar();
        boleta.setIdBoleta(id);
        return id;
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

    @Override
    public void insertarIdBoleta(Integer idBoleta) {
        this.boleta.setIdBoleta(idBoleta);
    }
    
    //LOGICA para BD
    
    @Override
    protected String obtenerListaAtributos() {
        return "ACTIVO, NUMERO_BOLETA, ID_COMPROBANTE_DE_PAGO";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + this.boleta.getActivoInt() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.boleta.getNumeroDeBoleta() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.boleta.getIdMetodoDePago() + "'");
        return sql;
    }
}
