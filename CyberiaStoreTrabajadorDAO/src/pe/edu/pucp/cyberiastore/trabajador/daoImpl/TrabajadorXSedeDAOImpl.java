package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorXSedeDAO;

public class TrabajadorXSedeDAOImpl extends DAOImpl implements TrabajadorXSedeDAO {

    private Integer idTrabajador;
    private Integer idSede;

    public TrabajadorXSedeDAOImpl() {
        super("TRABAJADOR_X_SEDE");
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "ID_TRABAJADOR, ID_SEDE";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.idTrabajador);
        this.incluirParametroInt(2, this.idSede);
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer insertar(Integer idTrabajador, Integer idSede) {
        this.idSede = idSede;
        this.idTrabajador = idTrabajador;
        return super.insertar();
    }

    @Override
    public Integer insertar(Integer idTrabajador, Integer idSede, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(idTrabajador,idSede);
    }
//    @Override
//    protected String obtenerListaAtributos() {
//    }
//
//    @Override
//    protected String obtenerListaValoresParaInsertar() {
//        String sql = "";
//        sql = sql.concat("'" + this.idTrabajador + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + this.idSede + "'");
//        return sql;    
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        return "";
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        String sql = "";
//        sql = sql.concat("ID_TRABAJOR = ");
//        sql = sql.concat("'" + this.idTrabajador + "'");
//        sql = sql.concat(" and ID_SEDE = ");
//        sql = sql.concat("'" + this.idSede + "'");
//        return sql;
//    }
//
//    @Override
//    public Integer insertar(Integer idTrabajador, Integer idSede) {
//        this.idTrabajador = idTrabajador;
//        this.idSede = idSede;
//        return this.insertar();
//    }
//
//    @Override
//    public Integer eliminar(Integer idTrabajador, Trabajador trabajador) {
//        this.idTrabajador = idTrabajador;
////        this.idSede = idSede;
//        return this.eliminar();
//    }
//
//    @Override
//    public Integer eliminarTrabajador(Integer idTrabajador) {
//        String sql = "delete from" + this.nombre_tabla + "where ID_TRABAJADOR = '" + this.idTrabajador + "'";
//        return this.ejecutarTransaccionEnBD(sql);
//    }
//
//
//    @Override
//    public ArrayList<Trabajador> buscarTrabajadorPorSede(Integer idTrabajador) {
//        TrabajadorDAOImpl trabajadorDAOImpl = new TrabajadorDAOImpl();
//        String sql = "select R.ID_TRABAJADOR, R.NOMBRE from TRABAJADOR R, TRABAJADOR_POR_SEDE RXU where RXU.ID_USUARIO = '" + idTrabajador + "'";
//        return trabajadorDAOImpl.listarTrabajador(sql);
//    }

}
