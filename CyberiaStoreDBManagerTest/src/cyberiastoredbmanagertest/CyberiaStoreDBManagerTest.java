package cyberiastoredbmanagertest;

import pe.edu.pucp.cyberiastore.util.Cifrado;

public class CyberiaStoreDBManagerTest {

    public static void main(String[] args) {
        String s = Cifrado.cifrarMD5("rJOyypnQ3pZEF8NGhEF5");
        System.out.println(s);
    }
}
