package pe.edu.pucp.cyberiastore.trabajador.bo;

//LOGICA DEL NEGOCIO, INCLUYE REGLAS PARA CADA TIPO DE TRABAJADOR
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.TrabajadorDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.bo.UsuarioBO;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.UsuarioDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;

public class TrabajadorBO {

    private TrabajadorDAO trabajadorDAO;

    public TrabajadorBO() {
        this.trabajadorDAO = new TrabajadorDAOImpl();
    }

}
