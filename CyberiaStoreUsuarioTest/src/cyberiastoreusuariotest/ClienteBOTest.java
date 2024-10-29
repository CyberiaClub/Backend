package cyberiastoreusuariotest;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.usuario.bo.ClienteBO;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class ClienteBOTest {

    private static ClienteBO clienteBO;
    private static ArrayList<Cliente> listaClientes;

//        testAdministradorBOInsertar();
//        testAdministradorBOListarTodos();
//        testAdministradorBOModificar();
//        testAdministradorBOListarTodos();
//        testAdministradorBOObtenerPorId();
    static void testClienteBO() {
        System.out.println("\ntestClienteBO");
        clienteBO = new ClienteBO();
        listaClientes = new ArrayList<Cliente>();
//        testClienteBOInsertar();
//        testClienteBOListarTodos();
//        testClienteBOModificar();
//        testClienteBOListarTodos();
        testClienteBOPorId();
//        
    }

    private static void testClienteBOInsertar() {
        System.out.println("\ntestClienteBOInsertar");
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = formateador.parse("2021-05-20");
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(ClienteBOTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        int resultado = clienteBO.insertar("11111111", "111111111", "AAAAAA", "APELLIDO AAAA", "APELLIDO AAAA", fechaNacimiento,
                "AAAAAA@gmail.com", "AAAAAAAAAAAAA", "PERUANO", "CALLE A", TipoDocumento.DNI);
        resultado = clienteBO.insertar("22222222", "222222222", "BBBBBB", "APELLIDO BBBB", "APELLIDO BBBB", fechaNacimiento, "BBBBB@gmail.com",
                "BBBBBBB", "PERUANO", "CALLE B", TipoDocumento.CARNET_DE_EXTRANJERIA);
        resultado = clienteBO.insertar("33333333", "333333333", "CCCCCC", "APELLIDO CCCC", "APELLIDO CCCC", fechaNacimiento, "CCCCCC@gmail.com",
                "CCCCCCCC", "PERUANO", "CALLE C", TipoDocumento.PASAPORTE);
    }

    private static void testClienteBOModificar() {
        Boolean activo = true;
        Boolean verificado = true;
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = formateador.parse("2021-05-20");
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(ClienteBOTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        clienteBO.modificar(1, true, 1, "11111111", "111111111", "AAAAAA", "APELLIDO AAAA", "APELLIDO AAAA", fechaNacimiento,
                "AAAAAA@gmail.com", activo, "AAAAAAAAAAAAA", "PERUANO", "CALLE A", TipoDocumento.DNI);
        clienteBO.modificar(2, true, 2, "22222222", "222222222", "BBBBBB", "APELLIDO BBBB", "APELLIDO BBBB", fechaNacimiento,
                "BBBBB@gmail.com", activo, "BBBBBBB", "PERUANO", "CALLE B", TipoDocumento.CARNET_DE_EXTRANJERIA);
        clienteBO.modificar(3, true, 3, "33333333", "333333333", "CCCCCC", "APELLIDO CCCC", "APELLIDO CCCC", fechaNacimiento,
                "CCCCCC@gmail.com", activo, "CCCCCCCC", "PERUANO", "CALLE C", TipoDocumento.PASAPORTE);
    }

    /**
     * El listar todos te va a mostrar todos los que sean VERIFICADOS
     */
    private static void testClienteBOListarTodos() {
        System.out.println("\ntestClienteBOListarTodos");
        listaClientes = clienteBO.listarTodos();
        for (Cliente cliente : listaClientes) {
            System.out.print(cliente.getIdCliente().toString() + ",");
            System.out.print(cliente.getIdUsuario().toString() + ",");
            System.out.print(cliente.getNombre() + ",");
            System.out.print(cliente.getApellidoPaterno() + ",");
            System.out.print(cliente.getApellidoMaterno() + ",");
            System.out.print(cliente.getTipoDeDocumento().toString() + ",");
            System.out.print(cliente.getCorreo() + ",");
            System.out.print(cliente.getDireccion() + ",");
            System.out.print(cliente.getNacionalidad() + ",");
            System.out.println(cliente.getTelefono());
        }
    }

    private static void testClienteBOPorId() {
        System.out.println("\ntestClienteBOPorId");
        listaClientes = clienteBO.listarTodos();
        Cliente cliente = clienteBO.obtenerPorId(1);
        System.out.print(cliente.getIdCliente().toString() + ",");
        System.out.print(cliente.getIdUsuario().toString() + ",");
        System.out.print(cliente.getNombre() + ",");
        System.out.print(cliente.getApellidoPaterno() + ",");
        System.out.print(cliente.getApellidoMaterno() + ",");
        System.out.print(cliente.getTipoDeDocumento().toString() + ",");
        System.out.print(cliente.getCorreo() + ",");
        System.out.print(cliente.getDireccion() + ",");
        System.out.print(cliente.getNacionalidad() + ",");
        System.out.println(cliente.getTelefono());
    }
}
