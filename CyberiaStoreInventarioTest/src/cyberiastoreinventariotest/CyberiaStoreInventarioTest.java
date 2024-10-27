package cyberiastoreinventariotest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.sede.dao.SedeDAO;
import pe.edu.pucp.cyberiastore.sede.daoImpl.SedeDAOImpl;
import pe.edu.pucp.cyberiastore.sede.model.Sede;

public class CyberiaStoreInventarioTest {

    public static void main(String[] args) {
        Sede sede = new Sede();
        sede.setNombre("SEDE01");
        sede.setDescripcion("NUEVA SEDE SEDE01");
        SedeDAO sedeDAO = new SedeDAOImpl();
        sedeDAO.insertar(sede);
    }

}
