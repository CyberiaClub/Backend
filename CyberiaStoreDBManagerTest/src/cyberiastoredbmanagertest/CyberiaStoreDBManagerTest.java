package cyberiastoredbmanagertest;

import java.sql.Connection;
import java.util.Date;
import java.text.SimpleDateFormat;
import pe.edu.pucp.cyberiastore.config.DBManager;
import pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO;
import pe.edu.pucp.cyberiastore.inventario.bo.MarcaBO;
import pe.edu.pucp.cyberiastore.inventario.bo.TipoProductoBO;
import pe.edu.pucp.cyberiastore.proveedor.bo.ProveedorBO;
import pe.edu.pucp.cyberiastore.sede.bo.SedeBO;

public class CyberiaStoreDBManagerTest {

    
    public static void main(String[] args) {
        DBManager dbmanager = DBManager.getInstance();
        Connection conexion = dbmanager.getConnection();
        
        
        ProveedorBO proveedorBO = new ProveedorBO();
//        proveedorBO.insertar("RUC_PRUEBA1","PROVEEDOR_PRUEBA1",);
        
        SedeBO sedeBO = new SedeBO();
        sedeBO.insertar("DIRECCION_PRUEBA1","NOMBRE_PRRUEBA1");
        
        MarcaBO marcaBO = new MarcaBO();
        marcaBO.insertar("MARCA_PRUEBA1");
        
        TipoProductoBO tipoProdBO = new TipoProductoBO();
        tipoProdBO.insertar("TIPO_PROD_PRUEBA1");
        
        ProductoBO prodBO = new ProductoBO();
        prodBO.insertar(1,"PRODUCTO_PRUEBA1","DESCRIPCION PRUEBA 1",9.9,"UNIDADES");
        
        
        
    }
    
}
