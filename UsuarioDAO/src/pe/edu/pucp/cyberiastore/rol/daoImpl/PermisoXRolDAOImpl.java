package pe.edu.pucp.cyberiastore.rol.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.rol.dao.PermisoXRolDAO;
import pe.edu.pucp.cyberiastore.rol.model.Permiso;
import pe.edu.pucp.cyberiastore.rol.model.Rol;

public class PermisoXRolDAOImpl extends DAOImpl implements PermisoXRolDAO {
    
    private int idPermiso;
    private int idRol;
    
    public PermisoXRolDAOImpl(){
        super("PERMISO_X_ROL");
    }
    
    @Override
    public Integer insertar(int idPermiso, int idRol){
        this.idPermiso = idPermiso;
        this.idRol = idRol;
        return this.insertar();
    }
    
    @Override
    protected String obtenerListaAtributos(){
        return "ID_PERMISO, ID_ROL";
    }
    
    @Override
    protected String obtenerListaValoresParaInsertar(){
        String sql = "";
        sql = sql.concat("'" + this.idPermiso + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + this.idRol + "'");
        return sql;
    }

    @Override
    public Integer eliminar(int idPermiso, int idRol) {
        this.idPermiso = idPermiso;
        this.idRol = idRol;
        return this.eliminar();
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        return "";
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("ID_PERMISO = ");
        sql = sql.concat("'" + this.idPermiso + "'");
        sql = sql.concat(" and ID_ROL = ");
        sql = sql.concat("'" + this.idRol + "'");
        return sql;
    }

    @Override
    public Integer eliminarPermiso(int idPermiso) {
        String sql = "delete from" + this.nombre_tabla + "where ID_PERMISO = '" + this.idPermiso + "'";
        return this.ejecutarTransaccionEnBD(sql);
    }

    @Override
    public Integer eliminarRol(int idRol) {
        String sql = "delete from" + this.nombre_tabla + "where ID_ROL = '" + this.idRol + "'";
        return this.ejecutarTransaccionEnBD(sql);
    }

    @Override
    public ArrayList<Rol> buscarRolesPorIdPermiso(int idPermiso) {
        RolDAOImpl rolDAOImpl = new RolDAOImpl();
        String sql = "select R.ID_ROL, R.NOMBRE from ROL R, PERMISO_X_ROL PXR where PXR.ID_PERMISO = '" + idPermiso + "'";
        return rolDAOImpl.listar(sql);
    }

    @Override
    public ArrayList<Permiso> buscarPermisosPorIdRol(int idRol) {
        PermisoDAOImpl permisoDAOImpl = new PermisoDAOImpl();
        String sql = "select P.ID_PERMISO, P.NOMBRE, P.DESCRIPCION from PERMISO P, PERMISO_X_ROL PXR where PXR.ID_ROL = '" + idRol + "'";
        return permisoDAOImpl.listar(sql);
    }
}
