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
    public MetodoDePagoDAOImpl(String tabla){
        super(tabla);
        this.metodoDePago = null;
    }
    @Override
    protected String obtenerListaAtributos() {
        return "FECHA_DATE, SUBTOTAL, IGV, TOTAL, DESCUENTO_APLICADO, ID_PEDIDO, ID_OFERTA";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + metodoDePago.getFecha() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + metodoDePago.getSubtotal() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + metodoDePago.getIgv()+ "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + metodoDePago.getTotal()+ "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + metodoDePago.getDescuentoAplicado()+ "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + metodoDePago.getIdPedido()+ "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + metodoDePago.getIdOferta() + "'");
        return sql;
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        String sql = "";
        sql = sql.concat("FECHA_DATE = ");
        sql = sql.concat("'" + metodoDePago.getFecha() + "'");
        sql = sql.concat(",SUBTOTAL = ");
        sql = sql.concat("'" + metodoDePago.getSubtotal()+ "'");
        sql = sql.concat(",IGV = ");
        sql = sql.concat("'" + metodoDePago.getIgv() + "'");
        sql = sql.concat(",TOTAL = ");
        sql = sql.concat("'" + metodoDePago.getTotal() + "'");
        sql = sql.concat(",DESCUENTO_APLICADO = ");
        sql = sql.concat("'" + metodoDePago.getDescuentoAplicado()+ "'");
        sql = sql.concat(",ID_PEDIDO = ");
        sql = sql.concat("'" + metodoDePago.getIdPedido()+ "'");
        sql = sql.concat(",ID_OFERTA = ");
        sql = sql.concat("'" + metodoDePago.getIdOferta() +  "'");
        return sql;
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("ID_METODO_PAGO = ");
        sql = sql.concat("'" + metodoDePago.getIdMetodoDePago() + "'");
        return sql;
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
        return null;
    }

    @Override
    public ArrayList<MetodoDePago> listarTodos() {
        return null;
    }

    @Override
    public MetodoDePago obtenerPorId(String idMetodoDePago) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat(" and ID_METODO_PAGO = '" + idMetodoDePago + "'");
        return this.listar(sql).getFirst();
    }
}
