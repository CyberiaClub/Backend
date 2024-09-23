package pe.edu.pucp.cyberiastore.trabajador.bo;

//LOGICA DEL NEGOCIO, INCLUYE REGLAS PARA CADA TIPO DE TRABAJADOR

import java.util.Date;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.TrabajadorDAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;

public class TrabajadorBO {
    private TrabajadorDAO trabajadorDAO;
    
    public TrabajadorBO(){
        this.trabajadorDAO=new TrabajadorDAOImpl();
    }
    
    public Integer insertar(Double sueldo,Date fechaDeIngreso,Date fechaDeSalida){
        Trabajador trabajador=new Trabajador(sueldo, fechaDeIngreso, fechaDeSalida);
        return trabajadorDAO.insertar(trabajador);
    }
}
