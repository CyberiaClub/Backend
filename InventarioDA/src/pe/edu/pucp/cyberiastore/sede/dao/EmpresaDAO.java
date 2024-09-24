package pe.edu.pucp.cyberiastore.sede.dao;

import pe.edu.pucp.cyberiastore.sede.model.Empresa;
public interface EmpresaDAO {
    public Integer insertar (Empresa empresa);
    
    public Integer modificar (Empresa empresa);
    
    public Integer eliminar(Empresa empresa);
}
