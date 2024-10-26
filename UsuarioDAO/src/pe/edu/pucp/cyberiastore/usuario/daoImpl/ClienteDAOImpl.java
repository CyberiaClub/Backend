package pe.edu.pucp.cyberiastore.usuario.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.usuario.dao.ClienteDAO;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class ClienteDAOImpl extends UsuarioDAOImpl implements ClienteDAO {

    private Cliente cliente;

    public ClienteDAOImpl() {
        super("CLIENTE");
        this.retornarLlavePrimaria = true;
        this.cliente = null;
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
    public Integer insertar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Boolean activo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> listarCliente(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> listarTodosCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente obtenerPorId(String idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertarIdCliente(Integer idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public Integer insertar(Cliente cliente){
//        this.cliente = cliente;
//        Integer id = this.insertar();
//        this.cliente.setIdCliente(id);
//        return id;
//    }
//    
//    @Override
//    protected String obtenerListaAtributos(){
//    }
//    
//    @Override
//    protected String obtenerListaValoresParaInsertar(){
//        String sql = "";
//        sql = sql.concat("'" + cliente.getVerificadoAsInt() + "'");
//        sql = sql.concat(", ");
//        sql = sql.concat("'" + cliente.getIdUsuario() + "'");
//        return sql;
//    }
//
//    @Override
//    public Integer modificar(Cliente cliente) {
//        this.cliente = cliente;
//        return super.modificar();
//    }
//
//    @Override
//    public Integer eliminar(Boolean activo) {
//        this.cliente.setActivo(activo);
//        return super.eliminar();
//    }
//    
//    @Override
//    public ArrayList<Cliente> listarCliente(String sql) {
//        ArrayList<Cliente> listaCliente = new ArrayList();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            this.abrirConexion();
//            this.ejecutarConsultaEnBD(sql);
//            while(this.resultSet.next()){
//                Cliente clienteTemp = new Cliente(
//                        (this.resultSet.getInt("VERIFICADO") == 1),
//                        this.resultSet.getString("DOCUMENTO"),
//                        this.resultSet.getString("TELEFONO"),
//                        this.resultSet.getString("NOMBRE"),
//                        this.resultSet.getString("APELLIDO_MATERNO"),
//                        this.resultSet.getString("APELLIDO_PATERNO"),
//                        sdf.parse(this.resultSet.getString("FECHA_NACIMIENTO")),
//                        this.resultSet.getString("CORREO"),
//                        (this.resultSet.getInt("ACTIVO") == 1),
//                        this.resultSet.getString("CONTRASEÑA"),
//                        this.resultSet.getString("NACIONALIDAD"),
//                        this.resultSet.getString("DIRECCION"),
//                        TipoDocumento.valueOf(this.resultSet.getString("idEspecialidad"))
//                );
//                listaCliente.add(clienteTemp);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                this.cerrarConexion();
//            } catch (SQLException ex) {
//                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return listaCliente;
//    }
//
//    @Override
//    public ArrayList<Cliente> listarTodosCliente() {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        return this.listarCliente(sql);
//    }
//
//    @Override
//    public Cliente obtenerPorId(String idCliente) {
//        String sql = this.obtenerListaValoresParaSeleccionar();
//        sql = sql.concat(" and ID_CLIENTE = '" + idCliente + "'");
//        return this.listarCliente(sql).getFirst();
//    }
//
//    @Override
//    protected String obtenerListaValoresParaModificar() {
//        String sql = "";
//        sql = sql.concat("VERIFICADO = ");
//        sql = sql.concat("'" + cliente.getVerificadoAsInt() + "'");
//        return sql;
//    }
//
//    @Override
//    protected String obtenerCondicionPorId() {
//        String sql = "";
//        sql = sql.concat("ID_CLIENTE = ");
//        sql = sql.concat("'" + cliente.getIdCliente() + "'");
//        return sql;
//    }
//    
//    @Override
//    protected String obtenerListaValoresParaSeleccionar() {
//        String sql = "select ID_CLIENTE, VERIFICADO, ";
//        sql = sql.concat(this.obtenerListaAtributos());
//        sql = sql.concat("from ");
//        sql = sql.concat(this.nombre_tabla);
//        sql = sql.concat(",usuario where ID_USUARIO = DOCUMENTO");
//        return sql;
//    }
//    
//    @Override
//    public void insertarIdCliente(Integer idCliente){
//        this.cliente.setIdCliente(idCliente);
//    }
}
