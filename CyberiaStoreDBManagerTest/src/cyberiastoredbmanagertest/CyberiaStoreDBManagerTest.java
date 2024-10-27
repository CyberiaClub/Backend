package cyberiastoredbmanagertest;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import pe.edu.pucp.cyberiastore.util.Cifrado;

public class CyberiaStoreDBManagerTest {

    public static void main(String[] args) {
        String contrasenha = "EKQ1Q2/R2335";
        Cifrado cifrado = new Cifrado();
        String c = cifrado.cifrarMD5(contrasenha);
        System.out.println(c);
    }
}
