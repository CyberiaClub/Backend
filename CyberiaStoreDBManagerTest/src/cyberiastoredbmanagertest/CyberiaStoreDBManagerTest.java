package cyberiastoredbmanagertest;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.Trabajador.trabajador.bo.AdministradorBO;
import pe.edu.pucp.Trabajador.trabajador.bo.TrabajadorBO;
import pe.edu.pucp.Trabajador.trabajador.model.Administrador;
import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.config.DBManager;
import pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO;
import pe.edu.pucp.cyberiastore.inventario.bo.MarcaBO;
import pe.edu.pucp.cyberiastore.inventario.bo.TipoProductoBO;
import pe.edu.pucp.cyberiastore.proveedor.bo.ProveedorBO;
import pe.edu.pucp.cyberiastore.sede.bo.SedeBO;
import pe.edu.pucp.cyberiastore.usuario.bo.ClienteBO;
import pe.edu.pucp.cyberiastore.usuario.bo.UsuarioBO;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class CyberiaStoreDBManagerTest {

    public static void main(String[] args) {
//        DBManager dbmanager = DBManager.getInstance();
//        Connection conexion = dbmanager.getConnection();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        
        Administrador administrador = new Administrador();
        administrador.setDocumento("12221");
        administrador.setTelefono("987654321");
        administrador.setNombre("Jesus");
        administrador.setApellidoPaterno("Huayhua");
        administrador.setApellidoMaterno("Flores");
        try {
            administrador.setFechaDeNacimiento(sdf.parse("20-05-2001"));
        } catch (ParseException ex) {
            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        administrador.setCorreo("jmhuayhua@pucp.edu.pe");
        administrador.setDireccion("No tengo ayuda");
        administrador.setContrasena("contrasena");
        administrador.setNacionalidad("PERUANO");
        administrador.setTipoDeDocumento(TipoDocumento.DNI);
        administrador.setSueldo(900.00);
        try {
            administrador.setFechaDeIngreso(sdf.parse("20-05-2020"));
        } catch (ParseException ex) {
            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        AdministradorBO adminBO = new AdministradorBO();
        Integer id = adminBO.insertar(administrador);
        System.out.println(id.toString());
    }
}
