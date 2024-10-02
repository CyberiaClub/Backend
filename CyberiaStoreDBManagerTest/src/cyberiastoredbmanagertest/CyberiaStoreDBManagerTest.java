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

        for (int i = 0; i < 5; i++) {
            ProveedorBO proveedorBO = new ProveedorBO();
            try {
                proveedorBO.insertar("RUC_PRUEBA" + (i + 1), "PROVEEDOR_PRUEBA" + (i + 1), sdf.parse("01-01-2020"));
            } catch (ParseException ex) {
                Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (int i = 0; i < 3; i++) {
            SedeBO sedeBO = new SedeBO();
            sedeBO.insertar("NOMBRE_PRUEBA" + (i + 1), "DECRIPCION_PRUEBA" + (i + 1));
        }

        for (int i = 0; i < 5; i++) {
            MarcaBO marcaBO = new MarcaBO();
            marcaBO.insertar("MARCA_PRUEBA" + (i + 1));
        }

        for (int i = 0; i < 5; i++) {
            TipoProductoBO tipoProdBO = new TipoProductoBO();
            tipoProdBO.insertar("TIPO_PROD_PRUEBA" + (i + 1));
        }

            ProductoBO prodBO = new ProductoBO();
            prodBO.insertar("PRD-01", "PRODUCTO_PRUEBA1", "DESCRIPCION_PRUEBA_1", 9.9, "BASE", "TIPO_PROD_PRUEBA2", "SEDE_PRUEBA1", 20, "MARCA_PRUEBA1", "RUC_PRUEBA1", 15.9);
            prodBO.insertar("PRD-02", "PRODUCTO_PRUEBA2", "DESCRIPCION_PRUEBA_2", 9.9, "BASE", "TIPO_PROD_PRUEBA2", "SEDE_PRUEBA3", 20, "MARCA_PRUEBA3", "RUC_PRUEBA2", 15.9);
            prodBO.insertar("PRD-03", "PRODUCTO_PRUEBA3", "DESCRIPCION_PRUEBA_3", 9.9, "BASE", "TIPO_PROD_PRUEBA2", "SEDE_PRUEBA2", 20, "MARCA_PRUEBA5", "RUC_PRUEBA4", 15.9);
            prodBO.insertar("PRD-04", "PRODUCTO_PRUEBA4", "DESCRIPCION_PRUEBA_4", 9.9, "BASE", "TIPO_PROD_PRUEBA3", "SEDE_PRUEBA1", 20, "MARCA_PRUEBA2", "RUC_PRUEBA4", 15.9);
            prodBO.insertar("PRD-05", "PRODUCTO_PRUEBA5", "DESCRIPCION_PRUEBA_5", 9.9, "BASE", "TIPO_PROD_PRUEBA1", "SEDE_PRUEBA2", 20, "MARCA_PRUEBA1", "RUC_PRUEBA4", 15.9);
    }

}
