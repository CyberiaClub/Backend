package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.trabajador.model.Vendedor;
import pe.edu.pucp.cyberiastore.trabajador.dao.VendedorDAO;

public class VendedorDAOImpl extends TrabajadorDAOImpl implements VendedorDAO {

    private Vendedor vendedor;

    public VendedorDAOImpl() {
        super("VENDEDOR");
        this.vendedor = null;
    }

    @Override
    public Integer insertar(Vendedor vendedor) {
        this.vendedor = vendedor;
        Integer id = super.insertar();
        vendedor.setIdUsuario(id);
        return id;
    }

    @Override
    public Integer modificar(Vendedor vendedor) {
        this.vendedor = vendedor;
        return super.modificar();
    }

    @Override
    public ArrayList<Vendedor> listarTodosAdministradores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vendedor obtenerPorId(Integer idAdministrador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertarIdVendedor(Integer idVendedor) {
        this.vendedor.setIdVendor(idVendedor);
    }
    
    //Funciones para la logica de BD
    @Override
    protected String obtenerListaAtributos(){
        return "ID_TRABAJADOR";
    }
    
    @Override
    protected String obtenerListaValoresParaInsertar(){
        String sql ="";
        sql = sql.concat("'" + this.vendedor.getIdTrabajador() + "'");
        return sql;
    }

}
