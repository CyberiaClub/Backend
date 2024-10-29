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
        testClienteBOInsertar();
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

        int resultado = clienteBO.insertar("11111111", "111111111", "AAAAAA", "APELLIDO AAAA", "APELLIDO AAAA", fechaNacimiento, "AAAAAA@gmail.com",
                "AAAAAAAAAAAAA", "PERUANO", "CALLE A", TipoDocumento.DNI);
    }
}
