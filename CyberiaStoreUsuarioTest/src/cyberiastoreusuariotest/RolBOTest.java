package cyberiastoreusuariotest;

import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.rol.bo.RolBO;
import pe.edu.pucp.cyberiastore.rol.model.Rol;

public class RolBOTest {
    private static RolBO rolBo;
    private static ArrayList<Rol> listaRoles;
    
    static void testRolBO() {
        System.out.println("\ntestClienteBO");
        rolBo = new RolBO();
        testRolBOListarTodos();        
    }
    
    /**
     * El listar todos te va a mostrar todos los que sean VERIFICADOS
     */
    private static void testRolBOListarTodos() {
        System.out.println("\ntestClienteBOListarTodos");
        listaRoles = rolBo.listarTodos();
        for (Rol rol : listaRoles) {
            System.out.print(rol.getIdRol().toString() + ",");
            System.out.println(rol.getNombre());
        }
    }
}
