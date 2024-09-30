package pe.edu.pucp.cyberiastore.oferta.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.oferta.dao.OfertaDAO;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;


public class OfertaDAOImpl extends DAOImpl implements OfertaDAO{
    private Oferta oferta;
    public OfertaDAOImpl(){
        super("OFERTA");
        this.oferta = null;
    }
    @Override
    protected String obtenerListaAtributos() {
        return "FECHA_INICIO, FECHA_FIN, PORCENTAJE";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + oferta.getFechaDeInicio() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + oferta.getFechaDeFin() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + oferta.getPorcentaje() + "'");
        return sql;
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        String sql = "";
        sql = sql.concat("FECHA_INICIO = ");
        sql = sql.concat("'" + oferta.getFechaDeInicio() + "'");
        sql = sql.concat(",FECHA_FIN = ");
        sql = sql.concat("'" + oferta.getFechaDeFin()+ "'");
        sql = sql.concat(",PORCENTAJE = ");
        sql = sql.concat("'" + oferta.getPorcentaje()+ "'");
        return sql;
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("ID_OFERTA = ");
        sql = sql.concat("'" + oferta.getIdOferta() + "'");
        return sql;
    }

    @Override
    public Integer insertar(Oferta oferta) {
        this.oferta = oferta;
        return this.insertar();
    }

    @Override
    public Integer modificar(Oferta oferta) {
        this.oferta = oferta;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Oferta oferta) {
        this.oferta = oferta;
        return this.eliminar();
    }

    @Override
    public ArrayList<Oferta> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Oferta> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Oferta obtenerPorId(String idOferta) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat(" and ID_PERMISO = '" + idOferta + "'");
        return this.listar(sql).getFirst();
    }
    
}
