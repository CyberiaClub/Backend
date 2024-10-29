package pe.edu.pucp.cyberiastore.rol.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.rol.dao.PermisoDAO;
import pe.edu.pucp.cyberiastore.rol.model.Permiso;

public class PermisoDAOImpl extends DAOImpl implements PermisoDAO {

    private Permiso permiso;

    public PermisoDAOImpl() {
        super("PERMISO");
        this.permiso = null;
    }

    /*
     * ************************************************************************
     * Insertar
     * ************************************************************************
     */
    @Override
    public Integer insertar(Permiso permiso) {
        this.permiso = permiso;
        this.retornarLlavePrimaria = true;
        Integer id = super.insertar();
        this.retornarLlavePrimaria = false;
        return id;
    }

    @Override
    public Integer insertar(Permiso permiso, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.insertar(permiso);
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "NOMBRE, DESCRIPCION, ACTIVO";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, this.permiso.getNombre());
        this.incluirParametroString(2, this.permiso.getDescripcion());
        this.incluirParametroBoolean(3, this.permiso.getActivo());
    }

    /*
     * **************************************************************************
     * MODIFICAR
     * Los permisos no se modifican
     * *************************************************************************
     */
    @Override
    public Integer modificar(Permiso permiso) {
        this.permiso = permiso;
        return super.modificar();
    }

    @Override
    public Integer modificar(Permiso permiso, Boolean usarTransaccion, Connection conexion) {
        this.usarTransaccion = usarTransaccion;
        this.conexion = conexion;
        return this.modificar(permiso);
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        return "ID_PERMISO";
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "NOMBRE=?, DESCRIPCION=?, ACTIVO=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroString(1, this.permiso.getNombre());
        this.incluirParametroString(2, this.permiso.getDescripcion());
        this.incluirParametroBoolean(3, this.permiso.getActivo());
    }

    /*
     * **************************************************************************
     * ELIMINIAR
     * Los permisos no se eliminan
     * *************************************************************************
     */
    @Override
    public Integer eliminar(Permiso permiso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Permiso permiso, Boolean usarTransaccion, Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * **************************************************************************
     * LISTAR TODOS
     * *************************************************************************
     */
    @Override
    public ArrayList<Permiso> listarTodos() {
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
    protected void instanciarObjetoDelResultSet() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * **************************************************************************
     * OBTENER POR ID
     * *************************************************************************
     */
    @Override
    public Permiso obtenerPorId(Integer idPermiso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * **************************************************************************
     * EXISTE PERMISO
     * y funciones adicionales
     * *************************************************************************
     */
    @Override
    public Boolean existePermiso(Permiso permiso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
