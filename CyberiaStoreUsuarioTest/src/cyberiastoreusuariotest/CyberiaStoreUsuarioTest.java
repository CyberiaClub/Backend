package cyberiastoreusuariotest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.usuario.dao.ClienteDAO;
import pe.edu.pucp.cyberiastore.usuario.daoImpl.ClienteDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class CyberiaStoreUsuarioTest {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setDocumento("12341234");
        cliente.setTelefono("962378662");
        cliente.setNombre("Jesus Mauricio");
        cliente.setApellidoPaterno("Huayhua");
        cliente.setApellidoMaterno("Flores");
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = formateador.parse("2021-05-20");
        } catch (ParseException ex) {
            Logger.getLogger(CyberiaStoreUsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        cliente.setFechaDeNacimiento(fechaNacimiento);
        cliente.setCorreo("jmhuayhua@pucp.edu.pe");
        cliente.setContrasena("a;lsdkjfa;lsdkjf");
        cliente.setNacionalidad("Peruano");
        cliente.setDireccion("en la universidad de la calle");
        cliente.setTipoDeDocumento(TipoDocumento.DNI);
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        Integer id = clienteDAO.insertar(cliente);
        System.out.println(id);
    }

}
