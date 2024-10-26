package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Almacenero;
import pe.edu.pucp.cyberiastore.trabajador.dao.AlmaceneroDAO;

public class AlmaceneroDAOImpl extends TrabajadorDAOImpl implements AlmaceneroDAO {

    private Almacenero almacenero;

    public AlmaceneroDAOImpl() {
        super("ALMACENERO");
        this.almacenero = null;
    }

    @Override
    public Integer insertar(Almacenero almacenero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Almacenero almacenero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Almacenero> listarTodosAdministradores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Almacenero obtenerPorId(Integer idAdministrador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertarIdAlmacenero(Integer idAlmacenero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public Integer insertar(Almacenero almacenero) {
//        this.almacenero = almacenero;
//        Integer id = super.insertar();
//        this.almacenero.setIdAlmacenero(id);
//        return id;
//        
//    }
//
//    @Override
//    public Integer modificar(Almacenero almacenero) {
//        this.almacenero = almacenero;
//        return super.modificar();
//    }
//
//    @Override
//    public ArrayList<Almacenero> listarTodosAdministradores() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Almacenero obtenerPorId(Integer idAdministrador) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void insertarIdAlmacenero(Integer idAlmacenero) {
//        this.almacenero.setIdAlmacenero(idAlmacenero);
//    }
//    //Funciones para la logica de BD
//    @Override
//    protected String obtenerListaAtributos(){
//        return "ID_TRABAJADOR";
//    }
//    
//    @Override
//    protected String obtenerListaValoresParaInsertar(){
//        String sql ="";
//        sql = sql.concat("'" + this.almacenero.getIdTrabajador() + "'");
//        return sql;
//    }
}
