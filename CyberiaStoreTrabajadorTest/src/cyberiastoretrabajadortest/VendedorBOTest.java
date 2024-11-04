package cyberiastoretrabajadortest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.trabajador.bo.VendedorBO;
import pe.edu.pucp.cyberiastore.trabajador.model.Vendedor;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.util.MuestraFecha;

public class VendedorBOTest {

    private static VendedorBO vendedorBO;
    private static ArrayList<Vendedor> listaVendedors;

    static void testVendedorBO() {
        System.out.println("\ntestVendedorBO");
        vendedorBO = new VendedorBO();
//        listaId = new ArrayList<>();
        testVendedorBOInsertar();
        testVendedorBOListarTodos();
        testVendedorBOModificar();
        testVendedorBOListarTodos();
        testVendedorBOObtenerPorId();
//        testArticuloBOEliminar(listaId);
    }

    private static void testVendedorBOInsertar() {
        System.out.println("\ntestVendedorBOInsertar");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String documento = "123123123";
        String telefono = "987654321";
        String nombre = "Jesus";
        String apellidoPaterno = "Huayhua";
        String apellidoMaterno = "Flores";
        Date fechaDeNacimiento = new Date();
        try {
            fechaDeNacimiento = sdf.parse("20-05-2001");
        } catch (ParseException ex) {
            Logger.getLogger(VendedorBOTest.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VendedorBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer idSede = 1;
        int resultado = vendedorBO.insertar(documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, direccion, contrasena, nacionalidad, tipoDeDocumento, sueldo, fechaDeIngreso, idSede);
        System.out.println("Llave primaria insertada: " + resultado);
    }

    private static void testVendedorBOModificar() {
        System.out.println("\ntestVendedorBOModificar");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer idVendedor = 1;
        Integer idTrabajador = 3;
        Integer idUsuario = 3;
        String documento = "22334455";
        String telefono = "123456789";
        String nombre = "Jesus";
        String apellidoPaterno = "Huayhua";
        String apellidoMaterno = "Flores";
        Date fechaDeNacimiento = new Date();
        try {
            fechaDeNacimiento = sdf.parse("20-05-2001");
        } catch (ParseException ex) {
            Logger.getLogger(VendedorBOTest.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VendedorBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Boolean activo = true;
        vendedorBO.modificar(idVendedor,idTrabajador, sueldo, fechaDeIngreso, idUsuario, documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
    }

    private static void testVendedorBOListarTodos() {
        System.out.println("\ntestVendedorBOListarTodos");
        listaVendedors = vendedorBO.listarTodos();
        for (Vendedor vendedor : listaVendedors) {
            System.out.print(vendedor.getIdVendedor().toString());
            System.out.print(", ");
            System.out.print(vendedor.getIdTrabajador().toString());
            System.out.print(", ");
            System.out.print(vendedor.getIdTrabajador().toString());
            System.out.print(", ");
            System.out.print(vendedor.getApellidoPaterno());
            System.out.print(", ");
            System.out.print(vendedor.getApellidoMaterno());
            System.out.print(", ");
            System.out.print(vendedor.getNombre());
            System.out.print(", ");
            System.out.print(vendedor.getTipoDeDocumento().toString());
            System.out.print(", ");
            System.out.print(vendedor.getDocumento());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(vendedor.getFechaDeNacimiento()));
            System.out.print(", ");
            System.out.print(vendedor.getTelefono());
            System.out.print(", ");
            System.out.print(vendedor.getCorreo());
            System.out.print(", ");
            System.out.print(vendedor.getNacionalidad());
            System.out.print(", ");
            System.out.print(MuestraFecha.toString(vendedor.getFechaDeIngreso()));
            System.out.print(", ");
            System.out.print(vendedor.getSueldo().toString());
            System.out.print(", ");
            System.out.println(vendedor.getNombreSede());
        }
    }

    private static void testVendedorBOObtenerPorId() {
        System.out.println("\ntestVendedorBOObtenerPorId");
        Vendedor vendedor = vendedorBO.obtenerPorId(1);
        System.out.print(vendedor.getIdVendedor().toString());
        System.out.print(", ");
        System.out.print(vendedor.getIdTrabajador().toString());
        System.out.print(", ");
        System.out.print(vendedor.getIdTrabajador().toString());
        System.out.print(", ");
        System.out.print(vendedor.getApellidoPaterno());
        System.out.print(", ");
        System.out.print(vendedor.getApellidoMaterno());
        System.out.print(", ");
        System.out.print(vendedor.getNombre());
        System.out.print(", ");
        System.out.print(vendedor.getTipoDeDocumento().toString());
        System.out.print(", ");
        System.out.print(vendedor.getDocumento());
        System.out.print(", ");
        System.out.print(MuestraFecha.toString(vendedor.getFechaDeNacimiento()));
        System.out.print(", ");
        System.out.print(vendedor.getTelefono());
        System.out.print(", ");
        System.out.print(vendedor.getCorreo());
        System.out.print(", ");
        System.out.print(vendedor.getNacionalidad());
        System.out.print(", ");
        System.out.print(MuestraFecha.toString(vendedor.getFechaDeIngreso()));
        System.out.print(", ");
        System.out.print(vendedor.getSueldo().toString());
        System.out.print(", ");
        System.out.println(vendedor.getNombreSede());
    }
}
