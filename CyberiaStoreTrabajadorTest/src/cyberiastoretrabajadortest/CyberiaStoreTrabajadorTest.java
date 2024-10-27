package cyberiastoretrabajadortest;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import pe.edu.pucp.cyberiastore.trabajador.dao.AdministradorDAO;
import pe.edu.pucp.cyberiastore.trabajador.dao.AlmaceneroDAO;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.dao.VendedorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AdministradorDAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AlmaceneroDAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.TrabajadorDAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.VendedorDAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;
import pe.edu.pucp.cyberiastore.trabajador.model.Almacenero;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.trabajador.model.Vendedor;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class CyberiaStoreTrabajadorTest {

    public static void main(String[] args) {
        AdministradorBOTest.testAdministradorBO();
        
        // Todo esto debería ir a clases aparte pero por mientras vamos con esto de aquí:
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        /*Almacenero*/
//        Almacenero almacenero = new Almacenero();
//        almacenero.setDocumento("6");
//        almacenero.setTelefono("987654321");
//        almacenero.setNombre("Jesus");
//        almacenero.setApellidoPaterno("Huayhua");
//        almacenero.setApellidoMaterno("Flores");
//        try {
//            almacenero.setFechaDeNacimiento(sdf.parse("20-05-2001"));
//        } catch (ParseException ex) {
//            java.util.logging.Logger.getLogger(CyberiaStoreTrabajadorTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        almacenero.setCorreo("jmhuayhua@pucp.edu.pe");
//        almacenero.setDireccion("No tengo ayuda");
//        almacenero.setContrasena("contrasena");
//        almacenero.setNacionalidad("PERUANO");
//        almacenero.setTipoDeDocumento(TipoDocumento.DNI);
//        almacenero.setSueldo(900.00);
//        try {
//            almacenero.setFechaDeIngreso(sdf.parse("20-05-2020"));
//        } catch (ParseException ex) {
//            java.util.logging.Logger.getLogger(CyberiaStoreTrabajadorTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        almacenero.setIdSede(500);
//
//        AlmaceneroDAO almaceneroDAO = new AlmaceneroDAOImpl();
//        Integer id = almaceneroDAO.insertar(almacenero);
//        System.out.println(id);
        /*Administrador*/

 /*Vendedor*/
//        Vendedor vendedor = new Vendedor();
//        vendedor.setDocumento("146");
//        vendedor.setTelefono("987654321");
//        vendedor.setNombre("Jesus");
//        vendedor.setApellidoPaterno("Huayhua");
//        vendedor.setApellidoMaterno("Flores");
//        try {
//            vendedor.setFechaDeNacimiento(sdf.parse("20-05-2001"));
//        } catch (ParseException ex) {
//            java.util.logging.Logger.getLogger(CyberiaStoreTrabajadorTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        vendedor.setCorreo("jmhuayhua@pucp.edu.pe");
//        vendedor.setDireccion("No tengo ayuda");
//        vendedor.setContrasena("contrasena");
//        vendedor.setNacionalidad("PERUANO");
//        vendedor.setTipoDeDocumento(TipoDocumento.DNI);
//        vendedor.setSueldo(900.00);
//        try {
//            vendedor.setFechaDeIngreso(sdf.parse("20-05-2020"));
//        } catch (ParseException ex) {
//            java.util.logging.Logger.getLogger(CyberiaStoreTrabajadorTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        vendedor.setIdSede(500);
//
//        VendedorDAO vendedorDAO = new VendedorDAOImpl();
//        Integer id = vendedorDAO.insertar(vendedor);
//        System.out.println(id);
    }

}
