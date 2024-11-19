package cyberiastoreinventariotest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pe.edu.pucp.cyberiastore.inventario.bo.MarcaBO;
import pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO;
import pe.edu.pucp.cyberiastore.inventario.bo.ProveedorBO;
import pe.edu.pucp.cyberiastore.inventario.bo.TipoProductoBO;
import pe.edu.pucp.cyberiastore.inventario.bo.SedeBO;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.model.Proveedor;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.Sede;

public class CyberiaStoreInventarioTest {

    public static void main(String[] args) {

        MarcaBO marcaBO = new MarcaBO();
        SedeBO sedeBO = new SedeBO();
        TipoProductoBO tipoProdBO = new TipoProductoBO();
        ProveedorBO proveedorBO = new ProveedorBO();
        ProductoBO productoBO = new ProductoBO();

        Marca marca = new Marca();
        Sede sede = new Sede();
        TipoProducto tipoProd = new TipoProducto();
        Proveedor proveedor = new Proveedor();
        Producto producto = new Producto();
//
//        String rutaImagen = "../Img/cyberiaproducto.jpg";
//        BufferedImage imagen = null;
//        byte[] imagenBytes = null;
//        try {
//            imagen = ImageIO.read(new File(rutaImagen));
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
//
//        Insercion de tipo de producto
//        tipoProducto.setImagen(imagenBytes);
//        tipoProducto.setTipo("TIPO PRODUCTO01");
//        tipoProductoBO.insertar(tipoProducto);
//        tipoProducto.setTipo("TIPO PRODUCTO02");
//        tipoProductoBO.insertar(tipoProducto);
//        tipoProducto.setTipo("TIPO PRODUCTO03");
//        tipoProductoBO.insertar(tipoProducto);
//        tipoProducto.setTipo("TIPO PRODUCTO04");
//        tipoProductoBO.insertar(tipoProducto);
//        tipoProducto.setTipo("TIPO PRODUCTO05");
//        tipoProductoBO.insertar(tipoProducto);
//
//        insercion de marca
//        proveedor.setIdProveedor(1);
//        marca.setImagen(imagenBytes);
//        marca.setProveedor(proveedor);
//        marca.setNombre("Marca01");
//        marcaBO.insertar(marca);
//        marca.setNombre("Marca02");
//        marcaBO.insertar(marca);
//        marca.setNombre("Marca03");
//        marcaBO.insertar(marca);
//        marca.setNombre("Marca04");
//        marcaBO.insertar(marca);
//        marca.setNombre("Marca05");
//        marcaBO.insertar(marca);
//
//        Insercion de Productos
//        Producto producto = new Producto();
//        TipoProducto tipoProd = new TipoProducto();
//        marca.setIdMarca(1);
//        tipoProd.setIdTipoProducto(1);
//        marca.setIdMarca(1);
//        producto.getTipoProducto().setIdTipoProducto(1); // todos tiene el mismo proveedor
//        producto.setImagen(imagenBytes);
//        Integer v = 1;
//        for (Integer i = 0; i < 40; i++) {
//            if (i % 10 == 0 && i != 0) {
//                v++;
//            }
//            producto.setIdSede(v);
//            producto.getTipoProducto().setIdTipoProducto(v);
//            producto.getMarca().setIdMarca(v);
//            producto.setSku("SKU" + i.toString());
//            producto.setNombre("nombre del producto " + i.toString());
//            producto.setDescripcion("Esta es la descripcion del producto " + i.toString());
//            producto.setPrecio(15.0 + i);
//            producto.setCantidad(10);
//            producto.setPrecioProveedor(5.0);
//            productoBO.insertar(producto);
//        }
//        tipoProd.setIdTipoProducto(4);
//        marca.setIdMarca(3);
//        
//        producto.setIdSede(3);
//        producto.setTipoProducto(tipoProd);
//        producto.setMarca(marca);
//        producto.setSku("SKU41");
//        producto.setNombre("nombre del producto 30");
//        producto.setDescripcion("Esta es la descripcion del producto 30");
//        producto.setPrecio(56.0);
//        producto.setCantidad(5);
//        producto.setPrecioProveedor(20.0);
//        producto.setImagen(imagenBytes);
//        
//        ArrayList<Producto> prodMiembro = new ArrayList<Producto>();
//        Producto productoAux = new Producto();
//        
//        productoAux.setIdProducto(10);
//        productoAux.setCantidad(3);
//        prodMiembro.add(productoAux);
//        
//        productoAux.setIdProducto(20);
//        productoAux.setCantidad(2);
//        prodMiembro.add(productoAux);
//        
//        productoAux.setIdProducto(30);
//        productoAux.setCantidad(1);
//        prodMiembro.add(productoAux);
//        
//        producto.setProductosMiembros(prodMiembro);
        productoBO.insertar(producto);

        int cont = 1;

        ArrayList<TipoProducto> tiposProducto = tipoProdBO.listarTodos();
        ArrayList<Marca> marcas = marcaBO.listarTodos();
        ArrayList<Sede> sedes = sedeBO.listarTodos();
        ArrayList<Proveedor> proveedores = proveedorBO.listarTodos();
        ArrayList<Producto> productos = productoBO.listarTodos();
        ArrayList<Producto> stock = sedeBO.listarProductosSede(1);

        System.out.println("LISTADO DE TIPOS DE PRODUCTO: ");
        for (TipoProducto tp : tiposProducto) {
            System.out.println(cont + ". ID: " + tp.getIdTipoProducto() + " TIPO: " + tp.getTipo());
            cont++;
        }
        cont = 1;
        System.out.println("================================================================================");
        System.out.println("LISTADO DE MARCAS: ");
        for (Marca m : marcas) {
            System.out.println(cont + ". ID: " + m.getIdMarca() + " NOMBRE: "
                    + m.getNombre() + " ID_PROVEEDOR: " + m.getProveedor().getIdProveedor()
                    + " PROVEEDOR: " + m.getProveedor().getRazonSocial());
            cont++;
        }
        cont = 1;
        System.out.println("================================================================================");
        System.out.println("LISTADO DE SEDES: ");
        for (Sede s : sedes) {
            System.out.println(cont + ". ID: " + s.getIdSede() + " NOMBRE: " + s.getNombre() + " DESCRIPCION: "
                    + s.getDescripcion() + " TELEFONO: " + s.getTelefono() + " HORARIO DE APERTURA: "
                    + s.getHorarioApertura() + " HORARIO DE CIERRE: " + s.getHorarioCierre());
            cont++;
        }
        cont = 1;
        System.out.println("================================================================================");
        System.out.println("LISTADO DE PROVEEDORES: ");
        for (Proveedor pv : proveedores) {
            System.out.println(cont + ". ID: " + pv.getIdProveedor() + " RUC: "
                    + pv.getRuc() + " RAZON SOCIAL: " + pv.getRazonSocial() + " NOMBRE DE CONTACTO: "
                    + pv.getNombreContacto() + " CORREO: " + pv.getCorreo() + " TELEFONO: " + pv.getTelefono()
                    + " DIRECCION: " + pv.getDireccion() + " DESCRIPCION: " + pv.getDescripcion());
            cont++;
        }
        cont = 1;
        System.out.println("================================================================================");
        System.out.println("LISTADO DE PRODUCTOS: ");
        for (Producto p : productos) {
            System.out.println(cont + ". ID: " + p.getIdProducto() + " SKU: " + p.getSku()
                    + " NOMBRE: " + p.getNombre() + " DESCRIPCION: " + p.getDescripcion()
                    + " PRECIO DE VENTA: " + p.getPrecio() + " PRECIO DE COMPRA: " + p.getPrecioProveedor()
                    + " ID DE MARCA: " + p.getMarca().getIdMarca() + " MARCA: " + p.getMarca().getNombre()
                    + " ID DE TIPO DE PRODUCTO: " + p.getTipoProducto().getIdTipoProducto() + " TIPO: " + p.getTipoProducto().getTipo());
            if (!p.getProductosMiembros().isEmpty()) {
                System.out.println('\t' + "CONTIENE: ");
                for (Producto pm : p.getProductosMiembros()) {
                    System.out.println('\t' + "SKU: " + pm.getSku() + " NOMBRE: " + pm.getNombre() + " DESCRIPCION: " + pm.getDescripcion());
                }
            }
            cont++;
        }
        cont = 1;
        System.out.println("================================================================================");
        System.out.println("LISTADO DE STOCK POR SEDE: ");        
        for (Producto stockProducto : stock) {
            System.out.println(cont + ". SKU: " + stockProducto.getSku() + " NOMBRE: " + stockProducto.getNombre() + 
                               " DESCRIPCION: " + stockProducto.getDescripcion() + " PRECIO DE VENTA: " + 
                               stockProducto.getPrecio() + " MARCA: " + stockProducto.getMarca().getNombre() + 
                               " TIPO: " + stockProducto.getTipoProducto().getTipo() + " STOCK: " + stockProducto.getCantidad());
            cont++;
        }

    }

}
