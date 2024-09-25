package pe.edu.pucp.cyberiastore.sede.daoImpl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.sede.dao.SedeDAO;

public class SedeDAOImpl extends DAOImpl implements SedeDAO{
    private Sede sede;

    public SedeDAOImpl() {
        super("SEDE");
        this.sede = null;
    }

    @Override
    public Integer insertar(Sede sede) {
        this.sede = sede;
        return this.insertar();
    }

    @Override
    public Integer modificar(Sede sede) {
        this.sede = sede;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Sede sede) {
        this.sede = sede;
        return this.modificar();
    }

    @Override
    protected String obtenerListaAtributos() {
        return "ID, DIRECCION, NOMBRE";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String valores = "";
        valores = valores.concat("'" + sede.getNombre()+ "'");
        valores = valores.concat(", ");
        valores = valores.concat("'" + sede.getDireccion()+ "'");
        return valores;
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("ID_SEDE= ");
        sql = sql.concat("'" + sede.getIdSede()+ "'");
        return sql;
    }

    @Override
    public ArrayList<Sede> listar(String sql) {
        ArrayList<Sede> listaSede = new ArrayList();
        try {
            this.abrirConexion();
            this.ejecutarConsultaEnBD(sql);
            while(this.resultSet.next()){
                Sede plantillaSede = new Sede(
                        this.resultSet.getString("DIRECCION"),
                        this.resultSet.getString("NOMBRE")
                );
                listaSede.add(plantillaSede);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SedeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(SedeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaSede;
    }

    @Override
    public ArrayList<Sede> listarTodos() {
        String listado = this.obtenerListaValoresParaSeleccionar();
        return this.listar(listado);
    }

    @Override
    public Sede obtenerPorId(String idSede) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat(" and ID_SEDE = '" + idSede + "'");
        return this.listar(sql).getFirst();
    }
}
