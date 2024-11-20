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
import pe.edu.pucp.cyberiastore.inventario.bo.MarcaBO;
import pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO;
import pe.edu.pucp.cyberiastore.inventario.bo.TipoProductoBO;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.Proveedor;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;

public class CyberiaStoreInventarioTest {

    public static void main(String[] args) {
        ProductoBO productoBO = new ProductoBO();
//        Producto producto = new Producto();
//        producto.setSku("7404");
//        producto.setNombre("Papel Fotocopia Oficio 75 G Paquete X 500 Und");
//        producto.setDescripcion("Contiene: Paquete con 500 hojas. Tamaño: Oficio.Gramaje: 75 g cada hoja.Imágenes referenciales.");
//        producto.setPrecio(15.70);
//        producto.setPrecioProveedor(12.50);
//        producto.setProductosMiembros(null);
//        TipoProducto tipoProducto = new TipoProducto();
//        tipoProducto.setIdTipoProducto(1);
//        Marca marca = new Marca();
//        marca.setIdMarca(1);
//        producto.setIdSede(1);
//        producto.setTipoProducto(tipoProducto);
//        producto.setMarca(marca);
//        BufferedImage imagen = null;
//        byte[] imagenBytes = null;
//        try {
//            imagen = ImageIO.read(new File("/home/errant/Documents/CyberiaClub/Img/oficina.jpg"));
//        } catch (IOException ex) {
//            Logger.getLogger(CyberiaStoreInventarioTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        if (imagen != null) {
//            //convertimos la imagen a byte[]
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            try {
//                ImageIO.write(imagen, "jpg", baos);
//            } catch (IOException ex) {
//                Logger.getLogger(CyberiaStoreInventarioTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                baos.flush();
//            } catch (IOException ex) {
//                Logger.getLogger(CyberiaStoreInventarioTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            imagenBytes = baos.toByteArray();
//            try {
//                baos.close();
//            } catch (IOException ex) {
//                Logger.getLogger(CyberiaStoreInventarioTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        producto.setImagen(imagenBytes);
//        productoBO.insertar(producto);
//        Producto p = productoBO.buscar_sku("7404",1);
//        System.out.println(p.getNombre() +"  "+p.getDescripcion()+ "  "+p.getCantidad());
//        marca.setImagen(imagenBytes);
//        marcaBO.insertar(marca);
//        MarcaBO marcaBO = new MarcaBO();
//        SedeBO sedeBO = new SedeBO();
//        TipoProductoBO tipoProdBO = new TipoProductoBO();
//        ProveedorBO proveedorBO = new ProveedorBO();
//        ProductoBO productoBO = new ProductoBO();
//        Producto producto = new Producto();
//        producto.setSku("7404");
//        producto.setNombre("Papel Fotocopia Oficio 75 G Paquete X 500 Und");
//        producto.setDescripcion("Contiene: Paquete con 500 hojas. Tamaño: Oficio.Gramaje: 75 g cada hoja.Imágenes referenciales.");
//        producto.setPrecio(15.70);
//        producto.setPrecioProveedor(12.50);
//        producto.setProductosMiembros(null);
//        TipoProducto tipoProducto = new TipoProducto();
//        tipoProducto.setIdTipoProducto(1);
//        Marca marca = new Marca();
//        marca.setIdMarca(1);
//        producto.setIdSede(1);
//        producto.setTipoProducto(tipoProducto);
//        producto.setMarca(marca);
//        BufferedImage imagen = null;
//        byte[] imagenBytes = null;
//        try {
//            imagen = ImageIO.read(new File("/home/errant/Documents/CyberiaClub/Img/oficina.jpg"));
//        } catch (IOException ex) {
//            Logger.getLogger(CyberiaStoreInventarioTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        if (imagen != null) {
//            //convertimos la imagen a byte[]
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            try {
//                ImageIO.write(imagen, "jpg", baos);
//            } catch (IOException ex) {
//                Logger.getLogger(CyberiaStoreInventarioTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {
//                baos.flush();
//            } catch (IOException ex) {
//                Logger.getLogger(CyberiaStoreInventarioTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            imagenBytes = baos.toByteArray();
//            try {
//                baos.close();
//            } catch (IOException ex) {
//                Logger.getLogger(CyberiaStoreInventarioTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        producto.setImagen(imagenBytes);
//        productoBO.insertar(producto);
        TipoProductoBO tipoProductoBO = new TipoProductoBO();
        TipoProducto tipoProducto = new TipoProducto();
        tipoProducto.setTipo("Arte");
        BufferedImage imagen = null;
        byte[] imagenBytes = null;
        try {
            imagen = ImageIO.read(new File("/home/errant/Documents/CyberiaClub/Img/arte.jpg"));
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
        tipoProducto.setImagen(imagenBytes);
        tipoProductoBO.insertar(tipoProducto);
    }

}
