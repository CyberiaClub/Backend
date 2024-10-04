package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;
import pe.edu.pucp.cyberiastore.trabajador.dao.AdministradorDAO;



public class AdministradorDAOImpl extends TrabajadorDAOImpl implements AdministradorDAO{

    private Administrador administrador;

    public AdministradorDAOImpl() {
        super("ADMINISTRADOR");
        this.administrador = null;
    }
    
    
    @Override
    public Integer insertar(Administrador administrador) {
        this.administrador = administrador;
        Integer id = super.insertar();
        this.administrador.setIdAdministrador(id);
        return id;
    }

    @Override
    public Integer modificar(Administrador administrador) {
        this.administrador = administrador;
        return super.modificar();
    }

    @Override
    public ArrayList<Administrador> listarTodosAdministradores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Administrador obtenerPorId(Integer idAdministrador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertarIdAdministrador(Integer idAdministrador) {
        this.administrador.setIdAdministrador(idAdministrador); 
    }
    
    //Funciones para la logica de BD
    @Override
    protected String obtenerListaAtributos(){
        return "ID_TRABAJADOR";
    }
    
    @Override
    protected String obtenerListaValoresParaInsertar(){
        String sql ="";
        sql = sql.concat("'" + administrador.getIdTrabajador() + "'");
        return sql;
    }
    
}
