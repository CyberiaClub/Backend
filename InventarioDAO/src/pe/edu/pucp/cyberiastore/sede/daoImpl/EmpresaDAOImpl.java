package pe.edu.pucp.cyberiastore.sede.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.sede.model.Empresa;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.sede.dao.EmpresaDAO;

public class EmpresaDAOImpl extends DAOImpl implements EmpresaDAO{
    private Empresa empresa;

    public EmpresaDAOImpl() {
        super("EMPRESA");
        this.empresa = null;
    }

    @Override
    public Integer insertar(Empresa empresa) {
        this.empresa = empresa;
        return this.insertar();
    }

    @Override
    public Integer modificar(Empresa empresa) {
        this.empresa = empresa;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Empresa empresa) {
        this.empresa = empresa;
        return this.modificar();
    }

    @Override
    protected String obtenerListaAtributos() {
        return "RAZON_SOCIAL, DIRECCION";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String sql = "";
        sql = sql.concat("'" + empresa.getRUC()+ "'");
        sql = sql.concat(", ");    
        sql = sql.concat("'" + empresa.getRazonSoial()+ "'");
        sql = sql.concat(", ");
        sql = sql.concat("'" + empresa.getDireccion()+ "'");
        return sql;
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerCondicionPorId() {
        String sql = "";
        sql = sql.concat("RUC = ");
        sql = sql.concat("'" + empresa.getRUC()+ "'");
        return sql;    
    }

    @Override
    public ArrayList<Empresa> listar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Empresa> listarTodos() {
        String sql = this.obtenerListaValoresParaSeleccionar();
        return this.listar(sql);
    }

    @Override
    public Empresa obtenerPorId(String idEmpresa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
