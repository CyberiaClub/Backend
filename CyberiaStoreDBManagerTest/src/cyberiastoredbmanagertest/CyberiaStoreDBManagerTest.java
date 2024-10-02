package cyberiastoredbmanagertest;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.Trabajador.trabajador.bo.AdministradorBO;
import pe.edu.pucp.Trabajador.trabajador.bo.AlmaceneroBO;
import pe.edu.pucp.Trabajador.trabajador.bo.TrabajadorBO;
import pe.edu.pucp.Trabajador.trabajador.bo.VendedorBO;
import pe.edu.pucp.Trabajador.trabajador.model.Administrador;
import pe.edu.pucp.Trabajador.trabajador.model.Almacenero;
import pe.edu.pucp.Trabajador.trabajador.model.Trabajador;
import pe.edu.pucp.Trabajador.trabajador.model.Vendedor;
import pe.edu.pucp.cyberiastore.config.DBManager;
import pe.edu.pucp.cyberiastore.inventario.bo.ProductoBO;
import pe.edu.pucp.cyberiastore.inventario.bo.MarcaBO;
import pe.edu.pucp.cyberiastore.inventario.bo.TipoProductoBO;
import pe.edu.pucp.cyberiastore.metodopago.bo.BoletaBO;
import pe.edu.pucp.cyberiastore.metodopago.dao.MetodoDePagoDAO;
import pe.edu.pucp.cyberiastore.metodopago.daoImpl.MetodoDePagoDAOImpl;
import pe.edu.pucp.cyberiastore.metodopago.model.Boleta;
import pe.edu.pucp.cyberiastore.metodopago.model.MetodoDePago;
import pe.edu.pucp.cyberiastore.oferta.bo.OfertaBO;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;
import pe.edu.pucp.cyberiastore.pedido.bo.PedidoBO;
import pe.edu.pucp.cyberiastore.pedido.model.EstadoPedido;
import pe.edu.pucp.cyberiastore.pedido.model.Pedido;
import pe.edu.pucp.cyberiastore.proveedor.bo.ProveedorBO;
import pe.edu.pucp.cyberiastore.sede.bo.SedeBO;
import pe.edu.pucp.cyberiastore.sede.model.Sede;
import pe.edu.pucp.cyberiastore.usuario.bo.ClienteBO;
import pe.edu.pucp.cyberiastore.usuario.bo.UsuarioBO;
import pe.edu.pucp.cyberiastore.usuario.model.Cliente;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;

public class CyberiaStoreDBManagerTest {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Pedido pedido = new Pedido();
        
        PedidoBO pedidobo = new PedidoBO();
        pedidobo.insertar(pedido);
        
        Oferta oferta = new Oferta();
        oferta.setPorcentaje(20);
        try {
            oferta.setFechaDeInicio(sdf.parse("02-10-2024"));
        } catch (ParseException ex) {
            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oferta.setFechaDeFin(sdf.parse("12-10-2024"));
        } catch (ParseException ex) {
            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        OfertaBO ofertabo = new OfertaBO();
        ofertabo.insertar(oferta);
        
        Boleta boleta = new Boleta();
        try {
            boleta.setFecha(sdf.parse("02-10-2024"));
        } catch (ParseException ex) {
            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        boleta.setIdPedido(pedido.getIdPedido());
        boleta.setTotal(500.00);
        boleta.setSubtotal(90.00);
        boleta.setDescuentoAplicado(10.00);
        boleta.setNumeroDeBoleta("1231235");
        
        BoletaBO boletaBO = new BoletaBO();
        boletaBO.insertar(boleta);
        
        
        
        
//        Sede sede = new Sede();
//        sede.setNombre("SEDE05");
//        sede.setDescripcion("ESTA ES LA SEDE01 QUE QUEDA QUIEN SABE DONDE");
//        SedeBO sedebo = new SedeBO();
//        Integer idsede = sedebo.insertar(sede);
//        
//        Almacenero almacenero = new Almacenero();
//        almacenero.setDocumento("6");
//        almacenero.setTelefono("987654321");
//        almacenero.setNombre("Jesus");
//        almacenero.setApellidoPaterno("Huayhua");
//        almacenero.setApellidoMaterno("Flores");
//        try {
//            almacenero.setFechaDeNacimiento(sdf.parse("20-05-2001"));
//        } catch (ParseException ex) {
//            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        almacenero.setCorreo("jmhuayhua@pucp.edu.pe");
//        almacenero.setDireccion("No tengo ayuda");
//        almacenero.setContrasena("contrasena");
//        almacenero.setNacionalidad("PERUANO");
//        almacenero.setTipoDeDocumento(TipoDocumento.DNI);
//        almacenero.setSueldo(900.00);
//        try {
//            almacenero.setFechaDeIngreso(sdf.parse("20-05-2020"));
//        } catch (ParseException ex) {
//            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        almacenero.setIdSede(idsede);
//        
//        AlmaceneroBO adminBO = new AlmaceneroBO();
//        Integer id = adminBO.insertar(almacenero);
//        System.out.println(id.toString());
        
//        Vendedor vendedor = new Vendedor();
//        vendedor.setDocumento("1");
//        vendedor.setTelefono("987654321");
//        vendedor.setNombre("Jesus");
//        vendedor.setApellidoPaterno("Huayhua");
//        vendedor.setApellidoMaterno("Flores");
//        try {
//            vendedor.setFechaDeNacimiento(sdf.parse("20-05-2001"));
//        } catch (ParseException ex) {
//            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        vendedor.setCorreo("jmhuayhua@pucp.edu.pe");
//        vendedor.setDireccion("No tengo ayuda");
//        vendedor.setContrasena("contrasena");
//        vendedor.setNacionalidad("PERUANO");
//        vendedor.setTipoDeDocumento(TipoDocumento.DNI);
//        vendedor.setSueldo(900.00);
//        try {
//            vendedor.setFechaDeIngreso(sdf.parse("20-05-2020"));
//        } catch (ParseException ex) {
//            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        VendedorBO adminBO = new VendedorBO();
//        Integer id = adminBO.insertar(vendedor);
//        System.out.println(id.toString());
        
        
        
//        Administrador administrador = new Administrador();
//        administrador.setDocumento("12221");
//        administrador.setTelefono("987654321");
//        administrador.setNombre("Jesus");
//        administrador.setApellidoPaterno("Huayhua");
//        administrador.setApellidoMaterno("Flores");
//        try {
//            administrador.setFechaDeNacimiento(sdf.parse("20-05-2001"));
//        } catch (ParseException ex) {
//            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        administrador.setCorreo("jmhuayhua@pucp.edu.pe");
//        administrador.setDireccion("No tengo ayuda");
//        administrador.setContrasena("contrasena");
//        administrador.setNacionalidad("PERUANO");
//        administrador.setTipoDeDocumento(TipoDocumento.DNI);
//        administrador.setSueldo(900.00);
//        try {
//            administrador.setFechaDeIngreso(sdf.parse("20-05-2020"));
//        } catch (ParseException ex) {
//            Logger.getLogger(CyberiaStoreDBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        AdministradorBO adminBO = new AdministradorBO();
//        Integer id = adminBO.insertar(administrador);
//        System.out.println(id.toString());
    }
}
