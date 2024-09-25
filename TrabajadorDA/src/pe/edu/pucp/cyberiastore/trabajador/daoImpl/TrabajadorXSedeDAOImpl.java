
package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorXSedeDAO;

public class TrabajadorXSedeDAOImpl extends DAOImpl implements  TrabajadorXSedeDAO{
    private Integer idTrabajador;
    private Integer idSede;
    
    public TrabajadorXSedeDAOImpl() {
        super("TRABAJADOR_POR_SEDE");
    }
    
    @Override
    protected String obtenerListaAtributos() {
        return "ID_TRABAJOR, ID_SEDE";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + this.idTrabajador + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.idSede + "'");
        return sql;    
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        return "";
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("ID_TRABAJOR = ");
        sql = sql.concat("'" + this.idTrabajador + "'");
        sql = sql.concat(" and ID_SEDE = ");
        sql = sql.concat("'" + this.idSede + "'");
        return sql;
    }

    @Override
    public Integer insertar(Integer idTrabajador, Integer sede) {
        this.idTrabajador = idTrabajador;
        this.idSede = idSede;
        return this.insertar();
    }

    @Override
    public Integer eliminar(Integer idTrabajador, Trabajador sede) {
        this.idTrabajador = idTrabajador;
        this.idSede = idSede;
        return this.eliminar();
    }

    @Override
    public Integer eliminarTrabajador(Integer idTrabajador) {
        String sql = "delete from" + this.nombre_tabla + "where ID_TRABAJADOR = '" + this.idTrabajador + "'";
        return this.ejecutarTransaccionEnBD(sql);
    }


    @Override
    public ArrayList<Trabajador> buscarTrabajadorPorSede(Integer idTrabajador) {
        TrabajadorDAOImpl trabajadorDAOImpl = new TrabajadorDAOImpl();
        String sql = "select R.ID_TRABAJADOR, R.NOMBRE from TRABAJADOR R, TRABAJADOR_POR_SEDE RXU where RXU.ID_USUARIO = '" + idTrabajador + "'";
        return trabajadorDAOImpl.listarTrabajador(sql);
    }


    
}
