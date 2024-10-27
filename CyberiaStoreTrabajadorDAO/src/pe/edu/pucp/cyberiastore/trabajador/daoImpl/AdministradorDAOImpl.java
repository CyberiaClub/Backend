package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;
import pe.edu.pucp.cyberiastore.trabajador.dao.AdministradorDAO;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class AdministradorDAOImpl extends DAOImpl implements AdministradorDAO {

    private Administrador administrador;

    public AdministradorDAOImpl() {
        super("ADMINISTRADOR");
        this.administrador = null;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "ID_TRABAJADOR";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroInt(1, this.administrador.getIdTrabajador());
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
        String sql = "AD.id_trabajador,";
        sql = sql.concat("US.nombre, US.apellido_paterno, US.apellido_materno,US.documento,US.fecha_nacimiento,");
        sql = sql.concat("US.telefono, US.correo, US.nacionalidad,US.tipo_documento,");
        sql = sql.concat("TR.sueldo,TR.fecha_ingreso,");
        sql = sql.concat("S.nombre");
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.administrador);
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.administrador = new Administrador();
        this.administrador.setIdAdministrador(this.resultSet.getInt("id_administrativo"));
        this.administrador.setNombre(this.resultSet.getString("nombre"));
        this.administrador.setApellidoPaterno(this.resultSet.getString("APELLIDO_PATERNO"));
        this.administrador.setApellidoMaterno(this.resultSet.getString("APELLIDO_MATERNO"));
        this.administrador.setDocumento(this.resultSet.getString("DOCUMENTO"));
        this.administrador.setFechaDeNacimiento(this.resultSet.getTimestamp("FECHA_NACIMIENTO"));
        this.administrador.setTelefono(this.resultSet.getString("TELEFONO"));
        this.administrador.setCorreo(this.resultSet.getString("CORREO"));
        this.administrador.setNacionalidad(this.resultSet.getString("NACIONALIDAD"));

        String tipoDocumentoStr = this.resultSet.getString("TIPO_DOCUMENTO");
        TipoDocumento tipoDocumento = TipoDocumento.valueOf(tipoDocumentoStr);
        this.administrador.setTipoDeDocumento(tipoDocumento);

        this.administrador.setFechaDeIngreso(this.resultSet.getTimestamp("FECHA_INGRESO"));
        this.administrador.setSueldo(this.resultSet.getDouble("SUELDO"));
        this.administrador.setNombreSede(this.resultSet.getString("SEDE_NOMBRE"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.administrador = null;
    }

    @Override
    public Integer insertar(Administrador administrador) {
        this.administrador = administrador;
        Integer idTrabajador = null;// el ID de la clase que hereda
        Trabajador trabajador = new Trabajador();// traemos la clase padre
        trabajador.setSueldo(administrador.getSueldo());
        trabajador.setFechaDeIngreso(administrador.getFechaDeIngreso());
        trabajador.setIdSede(administrador.getIdSede());
        trabajador.setDocumento(administrador.getDocumento());
        trabajador.setTelefono(administrador.getTelefono());
        trabajador.setNombre(administrador.getNombre());
        trabajador.setApellidoPaterno(administrador.getApellidoPaterno());
        trabajador.setApellidoMaterno(administrador.getApellidoMaterno());
        trabajador.setFechaDeNacimiento(administrador.getFechaDeNacimiento());
        trabajador.setCorreo(administrador.getCorreo());
        trabajador.setContrasena(administrador.getContrasena());
        trabajador.setNacionalidad(administrador.getNacionalidad());
        trabajador.setDireccion(administrador.getDireccion());
        trabajador.setTipoDeDocumento(administrador.getTipoDeDocumento());

        TrabajadorDAO trabajadorDAO = new TrabajadorDAOImpl();

        Integer idAdministrador = null;

        Boolean existeTrabajador = trabajadorDAO.existeTrabajador(trabajador);
        Boolean existeAdministrador = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeTrabajador) {
                idTrabajador = trabajadorDAO.insertar(trabajador, this.usarTransaccion, this.conexion);
                this.administrador.setIdTrabajador(idTrabajador);
            } else {
                idTrabajador = trabajador.getIdTrabajador();
                this.administrador.setIdTrabajador(idTrabajador);
                Boolean abreConexion = false;
                existeAdministrador = this.existeAdministrador(this.administrador, abreConexion);
            }
            if (!existeAdministrador) {
                this.retornarLlavePrimaria = true;
                idAdministrador = super.insertar();
                this.administrador.setIdAdministrador(idAdministrador);
                this.administrador.setIdTrabajador(trabajador.getIdTrabajador());
                this.administrador.setIdUsuario(trabajador.getIdUsuario());
                this.retornarLlavePrimaria = false;
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar Administrador " + ex);
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al intentar hacer rollback - " + ex1);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
        this.usarTransaccion = true;
        return idTrabajador;
    }

    @Override
    public Integer modificar(Administrador administrador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Administrador administrador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Administrador> listarTodos() {
        return (ArrayList<Administrador>) super.listarTodos(null);
    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" AD, ");
        sql = sql.concat("trabajador TR, usuario US, trabajador_x_sede TRXS, sede S ");
        sql = sql.concat("where Ad.id_trabajador = TR.ID_TRABAJADOR ");
        sql = sql.concat("and TR.id_usuario = US.id_usuario ");
        sql = sql.concat("and TR.ID_TRABAJADOR = TRXS.ID_TRABAJADOR ");
        sql = sql.concat("and TRXS.id_sede = S.ID_SEDE ");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }

    @Override
    public Administrador obtenerPorId(Integer idAdministrador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean existeAdministrador(Administrador administrador) {
        Boolean abreConexion = true;
        return existeAdministrador(administrador, abreConexion);
    }

    @Override
    public Boolean existeAdministrador(Administrador administrador, Boolean abreConexion) {
        this.administrador = administrador;
        Integer idAdministrador = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select id_administrador from administrador where ";
            sql = sql.concat("id_trabajador=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.administrador.getIdTrabajador());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idAdministrador = this.resultSet.getInt("id_administrador");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si existe alumno - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idAdministrador != null;
    }

//    @Override
//    public Integer insertar(Administrador administrador) {
//        this.administrador = administrador;
//        Integer id = super.insertar();
//        this.administrador.setIdAdministrador(id);
//        return id;
//    }
//
//    @Override
//    public Integer modificar(Administrador administrador) {
//        this.administrador = administrador;
//        return super.modificar();
//    }
//
//    @Override
//    public ArrayList<Administrador> listarTodosAdministradores() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Administrador obtenerPorId(Integer idAdministrador) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void insertarIdAdministrador(Integer idAdministrador) {
//        this.administrador.setIdAdministrador(idAdministrador); 
//    }
//    
//    //Funciones para la logica de BD
//    @Override
//    protected String obtenerListaAtributos(){
//    }
//    
//    @Override
//    protected String obtenerListaValoresParaInsertar(){
//        String sql ="";
//        sql = sql.concat("'" + administrador.getIdTrabajador() + "'");
//        return sql;
//    }
}
