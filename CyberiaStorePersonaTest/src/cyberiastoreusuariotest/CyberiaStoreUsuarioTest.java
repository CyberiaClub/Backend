package cyberiastoreusuariotest;

import java.util.Date;
import pe.edu.pucp.cyberiastore.persona.bo.PersonaBO;
import pe.edu.pucp.cyberiastore.persona.model.Persona;
import pe.edu.pucp.cyberiastore.persona.model.TipoDocumento;

public class CyberiaStoreUsuarioTest {

    public static void main(String[] args) {
        // Persona BO Test
        PersonaBO personaBO = new PersonaBO();
        Date fecha = new Date();

        // Persona 2
//        Persona p2 = new Persona();
//        p2.setDocumento("23456789");
//        p2.setTelefono("5552222222");
//        p2.setNombre("Ana Sofia");
//        p2.setPrimerApellido("Rodriguez");
//        p2.setSegundoApellido("Lopez");
//        p2.setFechaDeNacimiento(fecha);
//        p2.setSexo('F');
//        p2.setCorreo("ana.rodriguez@example.com");
//        p2.setDireccion("Jr. Los Olivos 456, Lima");
//        p2.setContrasena("anaSecure456");
//        p2.setNacionalidad("Peruana");
//        p2.setTipoDeDocumento(TipoDocumento.DNI);
//        p2.setIdTipoPersona(1);
//        Integer id = personaBO.insertar(p2);
        
//        personaBO.marcarVerificado("0e9377ca-45fd-4f00-a6bf-99de39735902");
//        // Persona 3
//        Persona p3 = new Persona();
//        p3.setDocumento("34567890");
//        p3.setTelefono("5553333333");
//        p3.setNombre("Carlos Alberto");
//        p3.setPrimerApellido("Gomez");
//        p3.setSegundoApellido("Ramos");
//        p3.setFechaDeNacimiento(fecha);
//        p3.setSexo('M');
//        p3.setCorreo("carlos.gomez@example.com");
//        p3.setDireccion("Calle Las Flores 789, Arequipa");
//        p3.setContrasena("carlos789Pass");
//        p3.setNacionalidad("Peruano");
//        p3.setTipoDeDocumento(TipoDocumento.DNI);
//        p3.setIdTipoPersona(1);
//        personaBO.insertar(p3);
//        // Persona 4
//        Persona p4 = new Persona();
//        p4.setDocumento("45678901");
//        p4.setTelefono("5554444444");
//        p4.setNombre("Paula Sofia");
//        p4.setPrimerApellido("Diaz");
//        p4.setSegundoApellido("Torres");
//        p4.setFechaDeNacimiento(fecha);
//        p4.setSexo('F');
//        p4.setCorreo("sofia.diaz@example.com");
//        p4.setDireccion("Av. Javier Prado 101, Lima");
//        p4.setContrasena("sofiaTorres123");
//        p4.setNacionalidad("Peruana");
//        p4.setTipoDeDocumento(TipoDocumento.DNI);
//        p4.setIdTipoPersona(1);
//        personaBO.insertar(p4);
//        // Persona 5
//        Persona p5 = new Persona();
//        p5.setDocumento("56789012");
//        p5.setTelefono("5555555555");
//        p5.setNombre("Jorge Antonio");
//        p5.setPrimerApellido("Vargas");
//        p5.setSegundoApellido("Sanchez");
//        p5.setFechaDeNacimiento(fecha);
//        p5.setSexo('M');
//        p5.setCorreo("jorge.vargas@example.com");
//        p5.setDireccion("Jr. Amazonas 202, Cusco");
//        p5.setContrasena("jorgeSanchezSecure");
//        p5.setNacionalidad("Peruano");
//        p5.setTipoDeDocumento(TipoDocumento.DNI);
//        p5.setIdTipoPersona(1);
//        personaBO.insertar(p5);
        personaBO.enviarCorreoVerificacion("basurainformatica20@gmail.com");
    }

}
