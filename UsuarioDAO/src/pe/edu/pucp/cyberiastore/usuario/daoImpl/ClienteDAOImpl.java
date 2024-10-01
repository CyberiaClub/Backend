package pe.edu.pucp.cyberiastore.usuario.daoImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.usuario.dao.ClienteDAO;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class ClienteDAOImpl extends DAOImpl implements ClienteDAO {
    
    private Cliente cliente;
    
    public ClienteDAOImpl(){
        super("CLIENTE");
        this.retonarLlavePrimaria = true;
        this.cliente = null;
    }
    
    @Override
    public Integer insertar(Cliente cliente){
        this.cliente = cliente;
        Integer id = this.insertar();
        this.cliente.setIdCliente(id);
        return id;
    }
    
    @Override
    protected String obtenerListaAtributos(){
        return "VERIFICADO, ID_USUARIO";
    }
    
    @Override
    protected String obtenerListaValoresParaInsertar(){
        String sql = "";
        sql = sql.concat("'" + cliente.getVerificadoAsInt() + "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + cliente.getIdUsuario() + "'");
        return sql;
    }

    @Override
    public Integer modificar(Cliente cliente) {
        this.cliente = cliente;
        return super.modificar();
    }

    @Override
    public Integer eliminar(Boolean activo) {
        this.cliente.setActivo(activo);
        return super.eliminar();
    }
    
    @Override
    public ArrayList<Cliente> listar(String sql) {
        ArrayList<Cliente> listaCliente = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.abrirConexion();
            this.ejecutarConsultaEnBD(sql);
            while(this.resultSet.next()){
                Cliente clienteTemp = new Cliente(
                        (this.resultSet.getInt("VERIFICADO") == 1),
                        this.resultSet.getString("DOCUMENTO"),
                        this.resultSet.getString("TELEFONO"),
                        this.resultSet.getString("NOMBRE"),
                        this.resultSet.getString("APELLIDO_MATERNO"),
                        this.resultSet.getString("APELLIDO_PATERNO"),
                        sdf.parse(this.resultSet.getString("FECHA_NACIMIENTO")),
                        this.resultSet.getString("CORREO"),
                        (this.resultSet.getInt("ACTIVO") == 1),
                        this.resultSet.getString("CONTRASEÑA"),
                        this.resultSet.getString("NACIONALIDAD"),
                        this.resultSet.getString("DIRECCION"),
                        TipoDocumento.valueOf(this.resultSet.getString("idEspecialidad"))
                );
                listaCliente.add(clienteTemp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaCliente;
    }

    @Override
    public ArrayList<Cliente> listarTodos() {
        String sql = this.obtenerListaValoresParaSeleccionar();
        return this.listar(sql);
    }

    @Override
    public Cliente obtenerPorId(String idCliente) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat(" and ID_CLIENTE = '" + idCliente + "'");
        return this.listar(sql).getFirst();
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        String sql = "";
        sql = sql.concat("VERIFICADO = ");
        sql = sql.concat("'" + cliente.getVerificadoAsInt() + "'");
        return sql;
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("ID_CLIENTE = ");
        sql = sql.concat("'" + cliente.getIdCliente() + "'");
        return sql;
    }
    
    @Override
    protected String obtenerListaValoresParaSeleccionar() {
        String sql = "select ID_CLIENTE, VERIFICADO, ";
        sql = sql.concat(this.obtenerListaAtributos());
        sql = sql.concat("from ");
        sql = sql.concat(this.nombre_tabla);
        sql = sql.concat(",usuario where ID_USUARIO = DOCUMENTO");
        return sql;
    }
}
