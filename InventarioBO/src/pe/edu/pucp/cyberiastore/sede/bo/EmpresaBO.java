package pe.edu.pucp.cyberiastore.sede.bo;

import pe.edu.pucp.cyberiastore.sede.daoImpl.EmpresaDAOImpl;
import pe.edu.pucp.cyberiastore.sede.dao.EmpresaDAO;
import pe.edu.pucp.cyberiastore.sede.model.Empresa;

public class EmpresaBO {
    EmpresaDAO empresaDAO;
    
    public EmpresaBO(){
        this.empresaDAO = new EmpresaDAOImpl();
    }
    
    public Integer insertar(String razonSoial, String RUC, String direccion){
        Empresa empresa = new Empresa(razonSoial, RUC, direccion);
        return this.empresaDAO.insertar(empresa);
    }
    
    public Integer modificar(String razonSoial, String RUC, String direccion){
        Empresa empresa = new Empresa(razonSoial, RUC, direccion);
        return this.empresaDAO.modificar(empresa);
    }
    
    public Integer eliminar(String razonSoial, String RUC, String direccion){
        Empresa empresa = new Empresa(razonSoial, RUC, direccion);
        return this.empresaDAO.eliminar(empresa);
    }
}
