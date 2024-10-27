package cyberiastoretrabajadortest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.trabajador.bo.AdministradorBO;
import pe.edu.pucp.cyberiastore.trabajador.dao.AdministradorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.AdministradorDAOImpl;
import pe.edu.pucp.cyberiastore.trabajador.model.Administrador;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.util.MuestraFecha;

public class AdministradorBOTest {

    private static AdministradorBO administradorBO;
    private static ArrayList<Administrador> listaAdministradores;

    static void testAdministradorBO() {
        System.out.println("\ntestPublicacionBO");
        administradorBO = new AdministradorBO();
//        listaId = new ArrayList<>();
        testAdministradorBOInsertar();
        testAdministradorBOListarTodos();
//        testArticuloBOModificar(listaId);
//        testArticuloBOListarTodos();
//        testArticuloBOObtenerPorId(listaId);
//        testArticuloBOEliminar(listaId);
    }

    private static void testAdministradorBOInsertar() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String documento = "1214";
        String telefono = "987654321";
        String nombre = "Jesus";
        String apellidoPaterno = "Huayhua";
        String apellidoMaterno = "Flores";
        Date fechaDeNacimiento = new Date();
        try {
            fechaDeNacimiento = sdf.parse("20-05-2001");
        } catch (ParseException ex) {
            Logger.getLogger(AdministradorBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String correo = "jmhuayhua@pucp.edu.pe";
        String direccion = "No tengo ayuda";
        String contrasena = "contrasena";
        String nacionalidad = "PERUANO";
        TipoDocumento tipoDeDocumento = TipoDocumento.DNI;
        Double sueldo = 900.00;
        Date fechaDeIngreso = new Date();
        try {
            fechaDeIngreso = sdf.parse("20-05-2020");
        } catch (ParseException ex) {
            Logger.getLogger(AdministradorBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer idSede = 500;
        int resultado = administradorBO.insertar(documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, direccion, contrasena, nacionalidad, tipoDeDocumento, sueldo, fechaDeIngreso, idSede);
        System.out.println("Llave primaria insertada: " + resultado);
    }

    private static void testAdministradorBOListarTodos() {
        System.out.println("\ntestAlumnoBOListarTodos");
        listaAdministradores = administradorBO.listarTodos();
        for (Administrador administrador : listaAdministradores) {
            System.out.print(administrador.getIdTrabajador().toString());
            System.out.print(", ");
            System.out.print(administrador.getApellidoPaterno());
            System.out.print(", ");
            System.out.print(administrador.getApellidoMaterno());
            System.out.print(", ");
            System.out.print(administrador.getNombre());
            System.out.print(", ");
            System.out.print(administrador.getTipoDeDocumento().toString());
            System.out.print(", ");
            System.out.print(administrador.getDocumento());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(administrador.getFechaDeNacimiento()));
            System.out.print(", ");
            System.out.print(administrador.getTelefono());
            System.out.print(", ");
            System.out.print(administrador.getCorreo());
            System.out.print(", ");
            System.out.print(administrador.getNacionalidad());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(administrador.getFechaDeIngreso()));
            System.out.print(", ");
            System.out.print(administrador.getSueldo().toString());
            System.out.print(", ");
            System.out.print(administrador.getNombreSede());
        }
    }
}
