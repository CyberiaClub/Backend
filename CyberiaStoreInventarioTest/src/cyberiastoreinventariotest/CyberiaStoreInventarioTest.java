package cyberiastoreinventariotest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.sede.dao.SedeDAO;
import pe.edu.pucp.cyberiastore.sede.daoImpl.SedeDAOImpl;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
import pe.edu.pucp.cyberiastore.proveedor.dao.ProveedorDAO;
import pe.edu.pucp.cyberiastore.proveedor.daoImpl.ProveedorDAOImpl;
import pe.edu.pucp.cyberiastore.proveedor.model.Proveedor;
import pe.edu.pucp.cyberiastore.inventario.dao.MarcaDAO;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.MarcaDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.dao.TipoProductoDAO;
import pe.edu.pucp.cyberiastore.inventario.daoImpl.TipoProductoDAOImpl;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;

public class CyberiaStoreInventarioTest {

    public static void main(String[] args) {
        Integer id = 0;
        String cadena;
        Sede sede = new Sede();
        SedeDAO sedeDAO = new SedeDAOImpl();
        Proveedor proveedor = new Proveedor();
        ProveedorDAO proveedorDAO = new ProveedorDAOImpl();
        Marca marca = new Marca();
        MarcaDAO marcaDAO = new MarcaDAOImpl();
        TipoProducto tipoProducto = new TipoProducto();
        TipoProductoDAO tipoProdDAO = new TipoProductoDAOImpl();

        for (int i = 0; i < 3; i++) {
            sede.setNombre("SEDE0" + (i + 1));
             sede.setDescripcion("NUEVA_SEDE_0" + (i + 1));

            id = sedeDAO.insertar(sede);
        }
        sede.setIdSede(id);
        sede.setNombre("NOMBRE_SEDE_MODIF03");
        sede.setDescripcion("DESCRIPCION_SEDE_MODIF03");
        sedeDAO.modificar(sede);
        ArrayList<Sede> sedes = sedeDAO.listarTodos();

        for (int i = 0; i < 5; i++) {
            proveedor.setRuc("RUC0" + (i + 1));
            proveedor.setRazonSocial("RAZON_SOCIAL0" + (i + 1));
            proveedor.setNombreContacto("NOMBRE_CONTACTO0" + (i + 1));
            proveedor.setCorreo("CORREO0" + (i + 1));
            proveedor.setTelefono("TELEF0" + (i + 1));
            proveedor.setDireccion("DIRECCION0" + (i + 1));
            proveedor.setDescripcion("DESCRIPCION0" + (i + 1));
            id = proveedorDAO.insertar(proveedor);
        }

        proveedor.setIdProveedor(id);
        proveedor.setRuc("MODIF_RUC05");
        proveedor.setRazonSocial("MODIF_PROVEEDOR_RAZON_SOCIAL05");
        proveedor.setNombreContacto("MODIF_PROVEEDOR_NOMBRE_CONTACTO05");
        proveedor.setCorreo("MODIF_PROVEEDOR_CORREO05");
        proveedor.setTelefono("MOD_TEL05");
        proveedor.setDireccion("MODIF_PROVEEDOR_DIRECCION05");
        proveedor.setDescripcion("MODIF_PROVEEDOR_DESCRIPCION05");
        proveedorDAO.modificar(proveedor);
        proveedorDAO.eliminar(proveedor);
        ArrayList<Proveedor> proveedores = proveedorDAO.listarTodos();

        for (int i = 0; i < 5; i++) {
            marca.setNombre("MARCA0"+(i+1));
            id = marcaDAO.insertar(marca);
        }
        marca.setIdMarca(id);
        marca.setNombre("MODIF_MARCA05");
        marcaDAO.modificar(marca);
        marcaDAO.eliminar(marca);
        ArrayList<Marca> marcas = marcaDAO.listarTodos();

        for (int i = 0; i < 5; i++) {
            tipoProducto.setTipo("TIPO0"+(i+1));
            id = tipoProdDAO.insertar(tipoProducto);
        }
        tipoProducto.setIdTipoProducto(id);
        tipoProducto.setTipo("MODIF_TIPO5");
        tipoProdDAO.modificar(tipoProducto);
        tipoProdDAO.eliminar(tipoProducto);
        ArrayList<TipoProducto> tipoProductos = tipoProdDAO.listarTodos();
        
        for (Sede sedeListar : sedes) {
            cadena = "";
            cadena = cadena.concat(sedeListar.getIdSede().toString());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(sedeListar.getNombre());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(sedeListar.getDescripcion());
            System.out.println(cadena);
        }

        System.out.println();
        
        for (Proveedor proveedorListar : proveedores) {
            cadena = "";
            cadena = cadena.concat(proveedorListar.getIdProveedor().toString());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(proveedorListar.getRuc());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(proveedorListar.getRazonSocial());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(proveedorListar.getNombreContacto());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(proveedorListar.getCorreo());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(proveedorListar.getTelefono());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(proveedorListar.getDireccion());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(proveedorListar.getDescripcion());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(proveedorListar.getActivo().toString());

            System.out.println(cadena);
        }

        System.out.println();
        
        for (Marca marcaListar : marcas) {
            cadena = "";
            cadena = cadena.concat(marcaListar.getIdMarca().toString());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(marcaListar.getNombre());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(marcaListar.getActivo().toString());
            System.out.println(cadena);
        }

        System.out.println();
        
        for (TipoProducto tipoProductoListar : tipoProductos) {
            cadena = "";
            cadena = cadena.concat(tipoProductoListar.getIdTipoProducto().toString());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(tipoProductoListar.getTipo());
            cadena = cadena.concat(", ");
            cadena = cadena.concat(tipoProductoListar.getActivo().toString());
            System.out.println(cadena);
        }
    }

}
