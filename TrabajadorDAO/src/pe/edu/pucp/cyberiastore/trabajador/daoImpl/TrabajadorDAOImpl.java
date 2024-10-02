package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.UsuarioDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

//Mencion de la Tabla
public class TrabajadorDAOImpl extends UsuarioDAOImpl implements TrabajadorDAO {

    private Trabajador trabajador;

    public TrabajadorDAOImpl() {
        super("TRABAJADOR");
        this.trabajador = null;
        this.retonarLlavePrimaria = true;
    }

    public TrabajadorDAOImpl(String tabla) {
        super(tabla);
        this.trabajador = null;
    }

    @Override
    public Integer insertar(Trabajador trabajador) {
        this.trabajador = trabajador;
        Integer id = super.insertar();
        trabajador.setIdTrabajador(id);
        return id;
    }

    @Override
    protected String obtenerListaAtributos() {
        return "SUELDO, FECHA_INGRESO, ID_USUARIO";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + trabajador.getSueldo() + "'");
        sql = sql.concat(",");
        sql = sql.concat("STR_TO_DATE('" + this.trabajador.fechaDeIngresoAsDDMMYYY() + "','%d-%m-%Y')");
        sql = sql.concat(",");
        sql = sql.concat("'" + this.trabajador.getIdUsuario() + "'");
        return sql;
    }

    @Override
    public Integer modificar(Trabajador trabajador) {
        this.trabajador = trabajador;
        return super.modificar();
    }

    @Override
    public Integer eliminar() {
        this.trabajador.setActivo(false);
        return super.eliminar();
    }

    /**
     *
     * @param sql
     * @return
     */
    public ArrayList<Trabajador> listarTrabajador(String sql) {
        ArrayList<Trabajador> listaTrabajador = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.abrirConexion();
            this.ejecutarConsultaEnBD(sql);
            while (this.resultSet.next()) {
                Trabajador trabajadorTemp = new Trabajador(
                        //public Trabajador(Double sueldo, Date fechaDeIngreso, Date fechaDeSalida, String documento, String telefono, String nombre, String apellidoPaterno, String apelldioMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
                        this.resultSet.getDouble("SUELDO"),
                        sdf.parse(this.resultSet.getString("FECHA_DE_INGRESO")),
                        //                        sdf.parse(this.resultSet.getString("FECHA_DE_SALIDA")),

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
                listaTrabajador.add(trabajadorTemp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaTrabajador;
    }

    @Override
    public ArrayList<Trabajador> listarTodosTrabajador() {
        String sql = this.obtenerListaValoresParaSeleccionar();
        return this.listarTrabajador(sql);
    }

    @Override
    public Trabajador obtenerPorId(Integer idTrabajador) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat("where DOCUMENTO = '" + idTrabajador + "'");
        return listarTrabajador(sql).getFirst();
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat(" ID_TRABAJADOR = ");
        sql = sql.concat("'" + this.trabajador.getIdTrabajador() + "';");
        return sql;
    }

    @Override
    public void insertarIdUsuario(Integer idUsuario) {
        this.trabajador.setIdUsuario(idUsuario);
    }

    @Override
    public void insertarIdTrabajador(Integer idtrabajador) {
        this.trabajador.setIdTrabajador(idtrabajador);
    }

}
