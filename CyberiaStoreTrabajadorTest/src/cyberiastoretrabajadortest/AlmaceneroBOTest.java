package cyberiastoretrabajadortest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.trabajador.bo.AlmaceneroBO;
import pe.edu.pucp.cyberiastore.trabajador.model.Almacenero;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.util.MuestraFecha;

public class AlmaceneroBOTest {

    private static AlmaceneroBO almaceneroBO;
    private static ArrayList<Almacenero> listaAlmaceneros;

    static void testAlmaceneroBO() {
        System.out.println("\ntestAlmaceneroBO");
        almaceneroBO = new AlmaceneroBO();
//        listaId = new ArrayList<>();
        testAlmaceneroBOInsertar();
        testAlmaceneroBOListarTodos();
        testAlmaceneroBOModificar();
        testAlmaceneroBOListarTodos();
        testAlmaceneroBOObtenerPorId();
//        testArticuloBOEliminar(listaId);
    }

    private static void testAlmaceneroBOInsertar() {
        System.out.println("\ntestAlmaceneroBOInsertar");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String documento = "55443322";
        String telefono = "987654321";
        String nombre = "Jesus";
        String apellidoPaterno = "Huayhua";
        String apellidoMaterno = "Flores";
        Date fechaDeNacimiento = new Date();
        try {
            fechaDeNacimiento = sdf.parse("20-05-2001");
        } catch (ParseException ex) {
            Logger.getLogger(AlmaceneroBOTest.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AlmaceneroBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer idSede = 1;
        int resultado = almaceneroBO.insertar(documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, direccion, contrasena, nacionalidad, tipoDeDocumento, sueldo, fechaDeIngreso, idSede);
        System.out.println("Llave primaria insertada: " + resultado);
    }

    private static void testAlmaceneroBOModificar() {
        System.out.println("\ntestAlmaceneroBOModificar");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer idAlmacenero = 1;
        Integer idTrabajador = 2;
        Integer idUsuario = 2;
        String documento = "99999999";
        String telefono = "123456789";
        String nombre = "Jesus";
        String apellidoPaterno = "Huayhua";
        String apellidoMaterno = "Flores";
        Date fechaDeNacimiento = new Date();
        try {
            fechaDeNacimiento = sdf.parse("20-05-2001");
        } catch (ParseException ex) {
            Logger.getLogger(AlmaceneroBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String correo = "jmhuayhua@pucp.edu.pe";
        String direccion = "Ya tengo nueva direccion";
        String contrasena = "contrasena";
        String nacionalidad = "PERUANO";
        TipoDocumento tipoDeDocumento = TipoDocumento.DNI;
        Double sueldo = 900.00;
        Date fechaDeIngreso = new Date();
        try {
            fechaDeIngreso = sdf.parse("20-05-2020");
        } catch (ParseException ex) {
            Logger.getLogger(AlmaceneroBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Boolean activo = true;
        almaceneroBO.modificar(idAlmacenero, idTrabajador, sueldo, fechaDeIngreso, idUsuario, documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
    }

    private static void testAlmaceneroBOListarTodos() {
        System.out.println("\ntestAlmaceneroBOListarTodos");
        listaAlmaceneros = almaceneroBO.listarTodos();
        for (Almacenero almacenero : listaAlmaceneros) {
            System.out.print(almacenero.getIdAlmacenero().toString());
            System.out.print(", ");
            System.out.print(almacenero.getIdTrabajador().toString());
            System.out.print(", ");
            System.out.print(almacenero.getIdTrabajador().toString());
            System.out.print(", ");
            System.out.print(almacenero.getApellidoPaterno());
            System.out.print(", ");
            System.out.print(almacenero.getApellidoMaterno());
            System.out.print(", ");
            System.out.print(almacenero.getNombre());
            System.out.print(", ");
            System.out.print(almacenero.getTipoDeDocumento().toString());
            System.out.print(", ");
            System.out.print(almacenero.getDocumento());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(almacenero.getFechaDeNacimiento()));
            System.out.print(", ");
            System.out.print(almacenero.getTelefono());
            System.out.print(", ");
            System.out.print(almacenero.getCorreo());
            System.out.print(", ");
            System.out.print(almacenero.getNacionalidad());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(almacenero.getFechaDeIngreso()));
            System.out.print(", ");
            System.out.print(almacenero.getSueldo().toString());
            System.out.print(", ");
            System.out.println(almacenero.getNombreSede());
        }
    }

    private static void testAlmaceneroBOObtenerPorId() {
        System.out.println("\ntestAlumnoBOObtenerPorId");
        Almacenero almacenero = almaceneroBO.obtenerPorId(1);
        System.out.print(almacenero.getIdAlmacenero().toString());
        System.out.print(", ");
        System.out.print(almacenero.getIdTrabajador().toString());
        System.out.print(", ");
        System.out.print(almacenero.getIdTrabajador().toString());
        System.out.print(", ");
        System.out.print(almacenero.getApellidoPaterno());
        System.out.print(", ");
        System.out.print(almacenero.getApellidoMaterno());
        System.out.print(", ");
        System.out.print(almacenero.getNombre());
        System.out.print(", ");
        System.out.print(almacenero.getTipoDeDocumento().toString());
        System.out.print(", ");
        System.out.print(almacenero.getDocumento());
        System.out.print(", ");
        System.out.print(MuestraFecha.toString(almacenero.getFechaDeNacimiento()));
        System.out.print(", ");
        System.out.print(almacenero.getTelefono());
        System.out.print(", ");
        System.out.print(almacenero.getCorreo());
        System.out.print(", ");
        System.out.print(almacenero.getNacionalidad());
        System.out.print(", ");
        System.out.print(MuestraFecha.toString(almacenero.getFechaDeIngreso()));
        System.out.print(", ");
        System.out.print(almacenero.getSueldo().toString());
        System.out.print(", ");
        System.out.println(almacenero.getNombreSede());
    }
}
