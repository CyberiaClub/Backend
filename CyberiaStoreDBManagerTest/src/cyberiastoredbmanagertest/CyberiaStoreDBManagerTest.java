package cyberiastoredbmanagertest;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.Trabajador.trabajador.bo.TrabajadorBO;
import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;
import pe.edu.pucp.cyberiastore.config.DBManager;
import pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO;
import pe.edu.pucp.cyberiastore.inventario.bo.MarcaBO;
import pe.edu.pucp.cyberiastore.inventario.bo.TipoProductoBO;
import pe.edu.pucp.cyberiastore.proveedor.bo.ProveedorBO;
import pe.edu.pucp.cyberiastore.sede.bo.SedeBO;
import pe.edu.pucp.cyberiastore.usuario.bo.ClienteBO;
import pe.edu.pucp.cyberiastore.usuario.bo.UsuarioBO;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class CyberiaStoreDBManagerTest {

    public static void main(String[] args) {
//        DBManager dbmanager = DBManager.getInstance();
//        Connection conexion = dbmanager.getConnection();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

//        ProveedorBO proveedorBO = new ProveedorBO();
//        try {
//            proveedorBO.insertar("RUC_PRUEBA1","PROVEEDOR_PRUEBA1",sdf.parse("01-01-202"));
//        } catch (ParseException ex) {
//            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        SedeBO sedeBO = new SedeBO();
//        sedeBO.insertar("hola como asfdasdf 12345123 ","ESTA ES UNA DESCRIPCION DE EJEMPLO GAAAAAAAAAA");
//        UsuarioBO usuario = new UsuarioBO();
//        Integer id = null;
//        String intento = "14";
//        try {
//            id = usuario.insertar(intento, "987654321", "LEONARDO", "LEONARDO", "LEONARDO", sdf.parse("01-01-2000"), "HOLA@GMAIL.COM", "ADMIN", "PERUANA", "AV. LEONARDO", TipoDocumento.DNI);
//            ClienteBO cliente = new ClienteBO();
//            try {
//                System.out.println(id);
//                cliente.insertar(id, intento, "987654321", "LEONARDO", "LEONARDO", "LEONARDO", sdf.parse("01-01-2000"), "HOLA@GMAIL.COM", "ADMIN", "PERUANA", "AV. LEONARDO", TipoDocumento.DNI);
//            } catch (ParseException ex) {
//                Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (ParseException ex) {
//            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        Trabajador trabajador = new Trabajador();
        trabajador.setSueldo(2500.00);
        try {
            trabajador.setFechaDeIngreso(sdf.parse("01-01-2020"));
        } catch (ParseException ex) {
            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        trabajador.setFechaDeSalida(null); // Aún no tiene fecha de salida

        // Datos de Usuario (asumiendo que Trabajador hereda de Usuario)
        trabajador.setDocumento("1214");
        trabajador.setTelefono("987654321");
        trabajador.setNombre("Juan");
        trabajador.setApellidoMaterno("Perez");
        trabajador.setApellidoPaterno("Gomez");
        try {
            trabajador.setFechaDeNacimiento(sdf.parse("01-01-2020"));
        } catch (ParseException ex) {
            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        trabajador.setCorreo("juan.perez@example.com");
        trabajador.setDireccion("Calle Falsa 123");
        trabajador.setActivo(true);
        trabajador.setContrasena("contrasenaSegura");
        trabajador.setNacionalidad("PERUANO");
        trabajador.setTipoDeDocumento(TipoDocumento.PASAPORTE);
        
        TrabajadorBO trabajadorbo = new TrabajadorBO();
        trabajadorbo.insertar(trabajador);
        
        UsuarioBO usuario = new UsuarioBO();
        usuario.eliminar(trabajador.getIdUsuario());
    }
}
