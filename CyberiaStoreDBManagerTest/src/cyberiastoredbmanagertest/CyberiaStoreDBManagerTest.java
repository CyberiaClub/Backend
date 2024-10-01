package cyberiastoredbmanagertest;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.config.DBManager;
import pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO;
import pe.edu.pucp.cyberiastore.inventario.bo.MarcaBO;
import pe.edu.pucp.cyberiastore.inventario.bo.TipoProductoBO;
import pe.edu.pucp.cyberiastore.proveedor.bo.ProveedorBO;
import pe.edu.pucp.cyberiastore.sede.bo.SedeBO;

public class CyberiaStoreDBManagerTest {

    
    public static void main(String[] args) {
//        DBManager dbmanager = DBManager.getInstance();
//        Connection conexion = dbmanager.getConnection();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
//        ProveedorBO proveedorBO = new ProveedorBO();
//        try {
//            proveedorBO.insertar("RUC_PRUEBA1","PROVEEDOR_PRUEBA1",sdf.parse("01-01-202"));
//        } catch (ParseException ex) {
//            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        SedeBO sedeBO = new SedeBO();
        sedeBO.insertar("hola como asfdasdf 123 ","ESTA ES UNA DESCRIPCION DE EJEMPLO GAAAAAAAAAA");
        sedeBO.imprimirId();
        
//        MarcaBO marcaBO = new MarcaBO();
//        marcaBO.insertar("MARCA_PRUEBA1");
//        
//        TipoProductoBO tipoProdBO = new TipoProductoBO();
//        tipoProdBO.insertar("TIPO_PROD_PRUEBA1");
//        
//        ProductoBO prodBO = new ProductoBO();
//        prodBO.insertar(1,"PRODUCTO_PRUEBA1","DESCRIPCION PRUEBA 1",9.9,"UNIDADES");
        
        
        
    }
    
}
