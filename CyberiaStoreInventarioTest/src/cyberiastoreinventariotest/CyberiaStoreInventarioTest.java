package cyberiastoreinventariotest;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO;

public class CyberiaStoreInventarioTest {

    public static void main(String[] args) {

        ProductoBO productoBO = new ProductoBO();
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
        //Producto p = new Producto();
                productoBO.insertar("010101", "Producto01", "Este es un producto01", 5.0, null,imagenBytes);
        //        productoBO.insertar("020202", "Producto02", "Este es un producto02", 5.0, null);
        //        productoBO.insertar("030303", "Producto03", "Este es un producto03", 5.0, null);
        //        productoBO.insertar("040404", "Producto04", "Este es un producto04", 5.0, null);
        //        ArrayList<Producto> productosmiembros = new ArrayList<Producto>();
        //        Producto p = new Producto();
        //        p.setIdProducto(1);
        //        p.setCantidad(10);
        //        productosmiembros.add(p);
        //        Producto q = new Producto();
        //        q.setIdProducto(2);
        //        q.setCantidad(10);
        //        productosmiembros.add(q);
        //        productoBO.insertar("99999", "Producto010", "Este es un producto010", 10.0, productosmiembros);
        //        ArrayList<Producto> productos = productoBO.listarTodos();
        //        for (Producto producto : productos) {
        //            System.out.print(producto.getIdProducto().toString());
        //            System.out.print(producto.getSku());
        //            System.out.print(producto.getNombre());
        //            System.out.println(producto.getDescripcion());
        //        }
        //        Integer id = 0;
        //        String cadena;
        //        Sede sede = new Sede();
        //        SedeDAO sedeDAO = new SedeDAOImpl();
        //        Proveedor proveedor = new Proveedor();
        //        ProveedorDAO proveedorDAO = new ProveedorDAOImpl();
        //        Marca marca = new Marca();
        //        MarcaDAO marcaDAO = new MarcaDAOImpl();
        //        TipoProducto tipoProducto = new TipoProducto();
        //        TipoProductoDAO tipoProdDAO = new TipoProductoDAOImpl();
        //
        //        for (int i = 0; i < 3; i++) {
        //            sede.setNombre("SEDE0" + (i + 1));
        //             sede.setDescripcion("NUEVA_SEDE_0" + (i + 1));
        //
        //            id = sedeDAO.insertar(sede);
        //        }
        //        sede.setIdSede(id);
        //        sede.setNombre("NOMBRE_SEDE_MODIF03");
        //        sede.setDescripcion("DESCRIPCION_SEDE_MODIF03");
        //        sedeDAO.modificar(sede);
        //        ArrayList<Sede> sedes = sedeDAO.listarTodos();
        //
        //        for (int i = 0; i < 5; i++) {
        //            proveedor.setRuc("RUC0" + (i + 1));
        //            proveedor.setRazonSocial("RAZON_SOCIAL0" + (i + 1));
        //            proveedor.setNombreContacto("NOMBRE_CONTACTO0" + (i + 1));
        //            proveedor.setCorreo("CORREO0" + (i + 1));
        //            proveedor.setTelefono("TELEF0" + (i + 1));
        //            proveedor.setDireccion("DIRECCION0" + (i + 1));
        //            proveedor.setDescripcion("DESCRIPCION0" + (i + 1));
        //            id = proveedorDAO.insertar(proveedor);
        //        }
        //
        //        proveedor.setIdProveedor(id);
        //        proveedor.setRuc("MODIF_RUC05");
        //        proveedor.setRazonSocial("MODIF_PROVEEDOR_RAZON_SOCIAL05");
        //        proveedor.setNombreContacto("MODIF_PROVEEDOR_NOMBRE_CONTACTO05");
        //        proveedor.setCorreo("MODIF_PROVEEDOR_CORREO05");
        //        proveedor.setTelefono("MOD_TEL05");
        //        proveedor.setDireccion("MODIF_PROVEEDOR_DIRECCION05");
        //        proveedor.setDescripcion("MODIF_PROVEEDOR_DESCRIPCION05");
        //        proveedorDAO.modificar(proveedor);
        //        proveedorDAO.eliminar(proveedor);
        //        ArrayList<Proveedor> proveedores = proveedorDAO.listarTodos();
        //
        //        for (int i = 0; i < 5; i++) {
        //            marca.setNombre("MARCA0"+(i+1));
        //            id = marcaDAO.insertar(marca);
        //        }
        //        marca.setIdMarca(id);
        //        marca.setNombre("MODIF_MARCA05");
        //        marcaDAO.modificar(marca);
        //        marcaDAO.eliminar(marca);
        //        ArrayList<Marca> marcas = marcaDAO.listarTodos();
        //
        //        for (int i = 0; i < 5; i++) {
        //            tipoProducto.setTipo("TIPO0"+(i+1));
        //            id = tipoProdDAO.insertar(tipoProducto);
        //        }
        //        tipoProducto.setIdTipoProducto(id);
        //        tipoProducto.setTipo("MODIF_TIPO5");
        //        tipoProdDAO.modificar(tipoProducto);
        //        tipoProdDAO.eliminar(tipoProducto);
        //        ArrayList<TipoProducto> tipoProductos = tipoProdDAO.listarTodos();
        //
        //        for (Sede sedeListar : sedes) {
        //            cadena = "";
        //            cadena = cadena.concat(sedeListar.getIdSede().toString());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(sedeListar.getNombre());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(sedeListar.getDescripcion());
        //            System.out.println(cadena);
        //        }
        //
        //        System.out.println();
        //
        //        for (Proveedor proveedorListar : proveedores) {
        //            cadena = "";
        //            cadena = cadena.concat(proveedorListar.getIdProveedor().toString());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(proveedorListar.getRuc());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(proveedorListar.getRazonSocial());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(proveedorListar.getNombreContacto());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(proveedorListar.getCorreo());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(proveedorListar.getTelefono());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(proveedorListar.getDireccion());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(proveedorListar.getDescripcion());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(proveedorListar.getActivo().toString());
        //
        //            System.out.println(cadena);
        //        }
        //
        //        System.out.println();
        //
        //        for (Marca marcaListar : marcas) {
        //            cadena = "";
        //            cadena = cadena.concat(marcaListar.getIdMarca().toString());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(marcaListar.getNombre());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(marcaListar.getActivo().toString());
        //            System.out.println(cadena);
        //        }
        //
        //        System.out.println();
        //
        //        for (TipoProducto tipoProductoListar : tipoProductos) {
        //            cadena = "";
        //            cadena = cadena.concat(tipoProductoListar.getIdTipoProducto().toString());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(tipoProductoListar.getTipo());
        //            cadena = cadena.concat(", ");
        //            cadena = cadena.concat(tipoProductoListar.getActivo().toString());
        //            System.out.println(cadena);
        //        }
//        marca.setNombre("MARCA1");
//        System.out.println(marcaDAO.buscarIdPorNombre(marca, true));
//        tipoProducto.setTipo("Arte");
//        
//        System.out.println(proveedorDAO.buscarIdPorNombre(proveedor, true));
//        proveedor.setRazonSocial("RAZON_SOCIAL1");
//        
//        System.out.println(sedeDAO.buscarIdPorNombre(sede, true));
//        sede.setNombre("SEDE1");
//        
//        System.out.println(tipoProdDAO.buscarIdPorTipo(tipoProducto, true));
    }

}
