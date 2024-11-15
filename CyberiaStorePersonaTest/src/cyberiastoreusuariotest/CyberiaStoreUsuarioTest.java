package cyberiastoreusuariotest;

import java.util.Date;
import pe.edu.pucp.cyberiastore.persona.bo.PersonaBO;
import pe.edu.pucp.cyberiastore.persona.model.Persona;
import pe.edu.pucp.cyberiastore.persona.model.TipoDocumento;
import pe.edu.pucp.cyberiastore.persona.model.TipoPersona;

public class CyberiaStoreUsuarioTest {

    public static void main(String[] args) {
        // Persona BO Test
        PersonaBO personaBO = new PersonaBO();
        Date fecha = new Date();
        Persona p = new Persona();
        TipoPersona t = new TipoPersona();
        p.setDocumento("12998767");
        p.setTelefono("5551234567");
        p.setNombre("Juan");
        p.setPrimerApellido("Perez");
//        p.setSegundoApellido("Gomez"); // Puedes omitir este si es null
        p.setFechaDeNacimiento(fecha);
        p.setSexo('M');
        p.setCorreo("juan.perez@example.com");
        p.setDireccion("123 Main St");
        p.setActivo(true); // Usando boolean para campos TINYINT (1 = true, 0 = false)
        p.setContrasena("password123");
        p.setNacionalidad("Peruano");
        p.setTipoDeDocumento(TipoDocumento.DNI);
        
        t.setIdTipoPersona(1);
        p.setTipoPersona(t);
        personaBO.insertar(p);
    }

}
