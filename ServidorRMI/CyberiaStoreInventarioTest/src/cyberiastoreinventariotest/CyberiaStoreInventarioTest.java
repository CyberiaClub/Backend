package cyberiastoreinventariotest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.AEADBadTagException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import jdk.dynalink.linker.support.Guards;
import pe.edu.pucp.cyberiastore.inventario.bo.MarcaBO;
import pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO;
import pe.edu.pucp.cyberiastore.inventario.bo.TipoProductoBO;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.Proveedor;
import pe.edu.pucp.cyberiastore.inventario.bo.ProveedorBO;
import pe.edu.pucp.cyberiastore.inventario.bo.SedeBO;
import pe.edu.pucp.cyberiastore.inventario.model.Sede;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;

public class CyberiaStoreInventarioTest {

    public static void main(String[] args) {
        ProductoBO pBO = new ProductoBO();
        
        ArrayList<Producto> pds = pBO.listarTodos();
    }

}
