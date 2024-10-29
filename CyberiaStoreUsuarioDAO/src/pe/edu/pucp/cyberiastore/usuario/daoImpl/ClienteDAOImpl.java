package pe.edu.pucp.cyberiastore.usuario.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.cyberiastore.config.DAOImpl;
import pe.edu.pucp.cyberiastore.config.Tipo_Operacion;
import pe.edu.pucp.cyberiastore.usuario.dao.ClienteDAO;
import pe.edu.pucp.cyberiastore.usuario.dao.UsuarioDAO;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;

public class ClienteDAOImpl extends DAOImpl implements ClienteDAO {

    private Cliente cliente;

    public ClienteDAOImpl() {
        super("CLIENTE");
        this.retornarLlavePrimaria = true;
        this.cliente = null;
    }

    /*
     * ************************************************************************
     * INSERTAR
     * ************************************************************************
     */
    @Override
    public Integer insertar(Cliente cliente) {
        this.cliente = cliente;
        Integer idUsuario = null;
        Usuario usuario = new Usuario();
        usuario.setDocumento(this.cliente.getDocumento());
        usuario.setTelefono(this.cliente.getTelefono());
        usuario.setNombre(this.cliente.getNombre());
        usuario.setApellidoPaterno(this.cliente.getApellidoPaterno());
        usuario.setApellidoMaterno(this.cliente.getApellidoMaterno());
        usuario.setFechaDeNacimiento(this.cliente.getFechaDeNacimiento());
        usuario.setCorreo(this.cliente.getCorreo());
        usuario.setActivo(this.cliente.getActivo());
        usuario.setContrasena(this.cliente.getContrasena());
        usuario.setNacionalidad(this.cliente.getNacionalidad());
        usuario.setDireccion(this.cliente.getDireccion());
        usuario.setTipoDeDocumento(this.cliente.getTipoDeDocumento());

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Boolean existeUsuario = usuarioDAO.existeUsuario(usuario);
        Boolean existeCliente = false;
        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            if (!existeUsuario) {
                idUsuario = usuarioDAO.insertar(usuario, this.usarTransaccion, this.conexion);
                this.cliente.setIdUsuario(idUsuario);
            } else {
                idUsuario = usuario.getIdUsuario();
                this.cliente.setIdUsuario(idUsuario);
                Boolean abreConexion = false;
                existeCliente = this.existeCliente(this.cliente, abreConexion);
            }
            if (!existeCliente) {
                super.insertar();
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar - " + ex);
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
        return idUsuario;
    }

    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "VERIFICADO, ID_USUARIO";
    }

    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?,?";
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroBoolean(1, this.cliente.getVerificado());
        this.incluirParametroInt(2, this.cliente.getIdUsuario());
    }

    /*
     * ************************************************************************
     * MODIFICAR
     * ************************************************************************
     */
    @Override
    public Integer modificar(Cliente cliente) {
        Integer retorno = 0;
        this.cliente = cliente;
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(this.cliente.getIdUsuario());
        usuario.setDocumento(this.cliente.getDocumento());
        usuario.setTelefono(this.cliente.getTelefono());
        usuario.setNombre(this.cliente.getNombre());
        usuario.setApellidoPaterno(this.cliente.getApellidoPaterno());
        usuario.setApellidoMaterno(this.cliente.getApellidoMaterno());
        usuario.setFechaDeNacimiento(this.cliente.getFechaDeNacimiento());
        usuario.setCorreo(this.cliente.getCorreo());
        usuario.setActivo(this.cliente.getActivo());
        usuario.setContrasena(this.cliente.getContrasena());
        usuario.setNacionalidad(this.cliente.getNacionalidad());
        usuario.setDireccion(this.cliente.getDireccion());
        usuario.setTipoDeDocumento(this.cliente.getTipoDeDocumento());

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        this.usarTransaccion = false;
        try {
            this.iniciarTransaccion();
            usuarioDAO.modificar(usuario, this.usarTransaccion, this.conexion);
            retorno = super.modificar();
            this.comitarTransaccion();
        } catch (SQLException ex) {
            System.err.println("Error al intentar modificar - " + ex);
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
        return retorno;
    }

    @Override
    protected String obtenerPredicadoParaLlavePrimaria() {
        String sql = "";
        if (this.tipo_Operacion == Tipo_Operacion.MODIFICAR || this.tipo_Operacion == Tipo_Operacion.ELIMINAR) {
            sql = "ID_CLIENTE=?";
        } else {
            sql = "cli.ID_CLIENTE=?";
        }
        return sql;
    }

    @Override
    protected String obtenerListaDeValoresYAtributosParaModificacion() {
        return "VERIFICADO=?";
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.incluirParametroBoolean(1, this.cliente.getVerificado());
        // Este puede fallar porque esta relacionado al obtener por ID
        // pese a eso, la funcion lo soporta asi que no genera problema
        // este es para la comparacion de id_trabajador= ?
        this.incluirParametroInt(2, this.cliente.getIdCliente());
    }

    /*
     * ************************************************************************
     * ELIMINAR
     * ************************************************************************
     */
    @Override
    public Integer eliminar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * ************************************************************************
     * OBTENER POR ID
     * ************************************************************************
     */
    @Override
    public Cliente obtenerPorId(Integer idcliente) {
        this.cliente = new Cliente();
        this.cliente.setIdCliente(idcliente);
        super.obtenerPorId();
        return this.cliente;
    }

    @Override
    protected String generarSQLParaListarPorId() {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" CLI ");
        sql = sql.concat("JOIN USUARIO  US ON CLI.ID_USUARIO = US.ID_USUARIO ");
        sql = sql.concat("where US.ACTIVO = 1 ");
        sql = sql.concat("AND CLI.VERIFICADO = 1 ");
        sql = sql.concat(this.obtenerPredicadoParaLlavePrimaria());
        return sql;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.incluirParametroInt(1, this.cliente.getIdCliente());
    }

    /*
     * ************************************************************************
     * LISTAR TODOS
     * ************************************************************************
     */
    @Override
    public ArrayList<Cliente> listarTodos() {
        return (ArrayList<Cliente>) super.listarTodos(null);
    }

    @Override
    protected String generarSQLParaListarTodos(Integer limite) {
        String sql = "select ";
        sql = sql.concat(obtenerProyeccionParaSelect());
        sql = sql.concat(" from ").concat(this.nombre_tabla).concat(" CLI ");
        sql = sql.concat("JOIN USUARIO  US ON CLI.ID_USUARIO = US.ID_USUARIO ");
        sql = sql.concat("where US.ACTIVO = 1 ");
        sql = sql.concat("AND CLI.VERIFICADO = 1 ");
        if (limite != null && limite > 0) {
            sql = sql.concat(" limit ").concat(limite.toString());
        }
        return sql;
    }

    @Override
    protected String obtenerProyeccionParaSelect() {
        String sql = "CLI.ID_CLIENTE,CLI.VERIFICADO";
        sql = sql.concat("US.ID_USUARIO,US.DOCUMENTO,US.TELEFONO,");
        sql = sql.concat("US.NOMBRE,US.APELLIDO_PATERNO,US.APELLIDO_MATERNO,");
        sql = sql.concat("US.FECHA_NACIMIENTO,US.CORREO,US.DIRECCION,");
        sql = sql.concat("US.NACIONALIDAD,US.TIPO_DOCUMENTO");
        return sql;
    }

    @Override
    protected void agregarObjetoALaLista(List lista, ResultSet resultSet) throws SQLException {
        instanciarObjetoDelResultSet();
        lista.add(this.cliente);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.cliente.setIdCliente(this.resultSet.getInt("ID_CLIENTE"));
        this.cliente.setVerificado(this.resultSet.getBoolean("VERIFICADO"));
        this.cliente.setIdUsuario(this.resultSet.getInt("ID_USUARIO"));
        this.cliente.setDocumento(this.resultSet.getString("DOCUMENTO"));
        this.cliente.setTelefono(this.resultSet.getString("TELEFONO"));
        this.cliente.setNombre(this.resultSet.getString("NOMBRE"));
        this.cliente.setApellidoPaterno(this.resultSet.getString("APELLIDO_PATERNO"));
        this.cliente.setApellidoMaterno(this.resultSet.getString("APELLIDO_MATERNO"));
        this.cliente.setFechaDeNacimiento(this.resultSet.getDate("FECHA_NACIMIENTO"));
        this.cliente.setCorreo(this.resultSet.getString("CORREO"));
        this.cliente.setDireccion(this.resultSet.getString("DIRECCION"));
        this.cliente.setNacionalidad(this.resultSet.getString("NACIONALIDAD"));

        String tipoDocumentoStr = this.resultSet.getString("TIPO_DOCUMENTO");
        TipoDocumento tipoDocumento = TipoDocumento.valueOf(tipoDocumentoStr);
        this.cliente.setTipoDeDocumento(tipoDocumento);
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.cliente = null;
    }

    /*
     * *************************************************************************
     * EXISTE CLIENTE
     * Funciones adicionales
     * *************************************************************************
     */
    @Override
    public Boolean existeCliente(Cliente cliente) {
        Boolean abreConexion = true;
        return existeCliente(cliente, abreConexion);
    }

    @Override
    public Boolean existeCliente(Cliente cliente, Boolean abreConexion) {
        this.cliente = cliente;
        Integer idCliente = null;
        try {
            if (abreConexion) {
                this.abrirConexion();
            }
            String sql = "select id_cliente from cliente where ";
            sql = sql.concat("id_cliente=? ");
            this.colocarSQLenStatement(sql);
            this.incluirParametroInt(1, this.cliente.getIdCliente());
            this.ejecutarConsultaEnBD(sql);
            if (this.resultSet.next()) {
                idCliente = this.resultSet.getInt("id_cliente");
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar si zexiste cliente - " + ex);
        } finally {
            try {
                if (abreConexion) {
                    this.cerrarConexion();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return idCliente != null;
    }

}
