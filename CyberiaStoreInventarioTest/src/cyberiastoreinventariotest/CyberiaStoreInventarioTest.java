package cyberiastoreinventariotest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pe.edu.pucp.cyberiastore.inventario.bo.MarcaBO;
import pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO;
import pe.edu.pucp.cyberiastore.inventario.bo.TipoProductoBO;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public class CyberiaStoreInventarioTest {

    public static void main(String[] args) {

        MarcaBO marcaBO = new MarcaBO();

        String rutaImagen = "../Img/cyberiaproducto.jpg";
        BufferedImage imagen = null;
        byte[] imagenBytes = null;
        try {
            imagen = ImageIO.read(new File(rutaImagen));
        } catch (IOException ex) {
            Logger.getLogger(CyberiaStoreInventarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (imagen != null) {
            //convertimos la imagen a byte[]
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ImageIO.write(imagen, "jpg", baos);
            } catch (IOException ex) {
                Logger.getLogger(CyberiaStoreInventarioTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                baos.flush();
            } catch (IOException ex) {
                Logger.getLogger(CyberiaStoreInventarioTest.class.getName()).log(Level.SEVERE, null, ex);
            }

            imagenBytes = baos.toByteArray();
            try {
                baos.close();
            } catch (IOException ex) {
                Logger.getLogger(CyberiaStoreInventarioTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Insercion de Productos
        ProductoBO productoBO = new ProductoBO();
        Producto producto = new Producto();
        producto.setIdProveedor(1); // todos tiene el mismo proveedor
        producto.setImagen(imagenBytes);
        Integer v = 1;
        for (Integer i = 0; i < 30; i++) {
            if (i % 10 == 0 && i != 0) {
                v++;
            }
            producto.setIdSede(v);
            producto.setIdTipo(v);
            producto.setIdMarca(v);
            producto.setSku("SKU" + i.toString());
            producto.setNombre("nombre del producto " + i.toString());
            producto.setDescripcion("Esta es la descripcion del producto " + i.toString());
            producto.setPrecio(15.0 + i);
            producto.setCantidad(10);
            producto.setPrecioProveedor(5.0);
            productoBO.insertar(producto);
        }

    }

}
