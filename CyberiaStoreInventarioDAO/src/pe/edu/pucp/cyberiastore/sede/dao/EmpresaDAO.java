package pe.edu.pucp.cyberiastore.sede.dao;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.sede.model.Empresa;
public interface EmpresaDAO {
    public Integer insertar (Empresa empresa);
    
    public Integer modificar (Empresa empresa);
    
    public Integer eliminar(Empresa empresa);
    
    public ArrayList<Empresa> listar(String sql);
    
    public ArrayList<Empresa> listarTodos();
    
    public Empresa obtenerPorId(String idEmpresa);
}
