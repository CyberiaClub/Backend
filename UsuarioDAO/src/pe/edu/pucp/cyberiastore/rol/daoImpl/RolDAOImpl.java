package pe.edu.pucp.cyberiastore.rol.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.rol.dao.RolDAO;
import pe.edu.pucp.cyberiastore.rol.model.Rol;

public class RolDAOImpl extends DAOImpl implements RolDAO {
    
    private Rol rol;
    
    public RolDAOImpl(){
        super("ROL");
        this.rol = null;
    }
    
    @Override
    public Integer insertar(Rol rol){
        this.rol = rol;
        return this.insertar();
    }
    
    @Override
    protected String obtenerListaAtributos(){
        return "NOMBRE";
    }
    
    @Override
    protected String obtenerListaValoresParaInsertar(){
        String sql = "";
        sql = sql.concat("'" + rol.getNombre() + "'");
        return sql;
    }

    @Override
    public Integer modificar(Rol rol) {
        this.rol = rol;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Rol rol) {
        this.rol = rol;
        return this.eliminar();
    }
    
    @Override
    public ArrayList<Rol> listar(String sql) {
        ArrayList<Rol> listaRol = new ArrayList();
        try {
            this.abrirConexion();
            this.ejecutarConsultaEnBD(sql);
            while(this.resultSet.next()){
                Rol rolTemp = new Rol(
                        this.resultSet.getInt("ID_ROL"),
                        this.resultSet.getString("NOMBRE")
                );
                listaRol.add(rolTemp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(RolDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaRol;
    }

    @Override
    public ArrayList<Rol> listarTodos() {
        String sql = this.obtenerListaValoresParaSeleccionar();
        return this.listar(sql);
    }

    @Override
    public Rol obtenerPorId(String idRol) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat(" and ID_ROL = '" + idRol + "'");
        return this.listar(sql).getFirst();
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        String sql = "";
        sql = sql.concat("NOMBRE = ");
        sql = sql.concat("'" + rol.getNombre() + "'");
        return sql;
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("ID_ROL = ");
        sql = sql.concat("'" + rol.getIdRol() + "'");
        return sql;
    }
}
