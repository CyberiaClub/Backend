package pe.edu.pucp.cyberiastore.sede.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.sede.dao.SedeDAO;

public class SedeDAOImpl extends DAOImpl implements SedeDAO{
    private Sede sede;

    public SedeDAOImpl() {
        super("SEDE");
        this.sede = null;
    }

    @Override
    public Integer insertar(Sede sede) {
        this.sede = sede;
        return this.insertar();
    }

    @Override
    public Integer modificar(Sede sede) {
        this.sede = sede;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Sede sede) {
        this.sede = sede;
        return this.modificar();
    }

    @Override
    protected String obtenerListaAtributos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerCondicionPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Sede> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Sede> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Sede obtenerPorId(String idSede) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
