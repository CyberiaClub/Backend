package pe.edu.pucp.cyberiastore.rol.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.rol.dao.PermisoDAO;
import pe.edu.pucp.cyberiastore.rol.model.Permiso;

public class PermisoDAOImpl extends DAOImpl implements PermisoDAO {
    
    private Permiso permiso;
    
    public PermisoDAOImpl(){
        super("PERMISO");
        this.permiso = null;
    }
    
    @Override
    public Integer insertar(Permiso permiso){
        this.permiso = permiso;
        return this.insertar();
    }
    
    @Override
    protected String obtenerListaAtributos(){
        return "NOMBRE, DESCRIPCION";
    }
    
    @Override
    protected String obtenerListaValoresParaInsertar(){
        String sql = "";
        sql = sql.concat("'" + permiso.getNombre() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + permiso.getDescripcion() + "'");
        return sql;
    }

    @Override
    public Integer modificar(Permiso permiso) {
        this.permiso = permiso;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Permiso permiso) {
        this.permiso = permiso;
        return this.eliminar();
    }
    
    @Override
    public ArrayList<Permiso> listar(String sql) {
        ArrayList<Permiso> listaPermiso = new ArrayList();
        try {
            this.abrirConexion();
            this.ejecutarConsultaEnBD(sql);
            while(this.resultSet.next()){
                Permiso permisoTemp = new Permiso(
                        this.resultSet.getInt("ID_PERMISO"),
                        this.resultSet.getString("NOMBRE"),
                        this.resultSet.getString("DESCRIPCION")
                );
                listaPermiso.add(permisoTemp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(PermisoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaPermiso;
    }

    @Override
    public ArrayList<Permiso> listarTodos() {
        String sql = this.obtenerListaValoresParaSeleccionar();
        return this.listar(sql);
    }

    @Override
    public Permiso obtenerPorId(String idPermiso) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat(" and ID_PERMISO = '" + idPermiso + "'");
        return this.listar(sql).getFirst();
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        String sql = "";
        sql = sql.concat("NOMBRE = ");
        sql = sql.concat("'" + permiso.getNombre() + "'");
        sql = sql.concat(",DESCRIPCION = ");
        sql = sql.concat("'" + permiso.getDescripcion()+ "'");
        return sql;
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("ID_PERMISO = ");
        sql = sql.concat("'" + permiso.getIdPermiso() + "'");
        return sql;
    }
}
