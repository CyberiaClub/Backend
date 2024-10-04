package cyberiastoredbmanagertest;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import pe.edu.pucp.cyberiastore.oferta.bo.OfertaBO;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;
import pe.edu.pucp.cyberiastore.pedido.bo.PedidoBO;
import pe.edu.pucp.cyberiastore.pedido.model.Pedido;
import pe.edu.pucp.cyberiastore.usuario.model.Usuario;

public class CyberiaStoreDBManagerTest {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Pedido pedido = new Pedido();
        
        PedidoBO pedidobo = new PedidoBO();
        pedidobo.insertar(pedido);        
    }
}
