package pe.edu.pucp.cyberiastore.rmi.servidor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.rmi.interfaces.ComprobantePagoBO;
import pe.edu.pucp.cyberiastore.rmi.interfacesImpl.ComprobantePagoBOImpl;
import pe.edu.pucp.cyberiastore.rmi.interfaces.MarcaBO;
import pe.edu.pucp.cyberiastore.rmi.interfacesImpl.MarcaBOImpl;
import pe.edu.pucp.cyberiastore.rmi.interfaces.OfertaBO;
import pe.edu.pucp.cyberiastore.rmi.interfacesImpl.OfertaBOImpl;
import pe.edu.pucp.cyberiastore.rmi.interfaces.PersonaBO;
import pe.edu.pucp.cyberiastore.rmi.interfacesImpl.PersonaBOImpl;
import pe.edu.pucp.cyberiastore.rmi.interfaces.ProductoBO;
import pe.edu.pucp.cyberiastore.rmi.interfacesImpl.ProductoBOImpl;
import pe.edu.pucp.cyberiastore.rmi.interfaces.ProveedorBO;
import pe.edu.pucp.cyberiastore.rmi.interfacesImpl.ProveedorBOImpl;
import pe.edu.pucp.cyberiastore.rmi.interfaces.SedeBO;
import pe.edu.pucp.cyberiastore.rmi.interfacesImpl.SedeBOImpl;
import pe.edu.pucp.cyberiastore.rmi.interfaces.TipoComprobanteBO;
import pe.edu.pucp.cyberiastore.rmi.interfacesImpl.TipoComprobanteBOImpl;
import pe.edu.pucp.cyberiastore.rmi.interfaces.TipoPersonaBO;
import pe.edu.pucp.cyberiastore.rmi.interfacesImpl.TipoPersonaBOImpl;
import pe.edu.pucp.cyberiastore.rmi.interfaces.TipoProductoBO;
import pe.edu.pucp.cyberiastore.rmi.interfacesImpl.TipoProductoBOImpl;

public class CyberiaStore_RMI_Servidor {

    private static final String ARCHIVO_CONFIGURACION = "rmi.properties";
    private static String IP;
    private static Integer puerto;
    
    public static void main(String[] args) {
        try {
            leer_archivo_de_propiedades();
            
            LocateRegistry.createRegistry(puerto);
            
            ComprobantePagoBO comprobantePagoBO = new ComprobantePagoBOImpl(puerto);
            MarcaBO marcaBO = new MarcaBOImpl(puerto);
            OfertaBO ofertaBO = new OfertaBOImpl(puerto);
            PersonaBO personaBO = new PersonaBOImpl(puerto);
            ProductoBO productoBO = new ProductoBOImpl(puerto);
            ProveedorBO proveedorBO = new ProveedorBOImpl(puerto);
            SedeBO sedeBO = new SedeBOImpl(puerto);
            TipoComprobanteBO tipoComprobanteBO = new TipoComprobanteBOImpl(puerto);
            TipoPersonaBO tipoPersonaBO = new TipoPersonaBOImpl(puerto);
            TipoProductoBO tipoProductoBO = new TipoProductoBOImpl(puerto);
            
            String nombreServicio = retornaNombreDelServicio("comprobantePagoBO");
            Naming.rebind(nombreServicio, comprobantePagoBO);
            
            nombreServicio = retornaNombreDelServicio("marcaBO");
            Naming.rebind(nombreServicio, marcaBO);
            
            nombreServicio = retornaNombreDelServicio("ofertaBO");
            Naming.rebind(nombreServicio, ofertaBO);
            
            nombreServicio = retornaNombreDelServicio("personaBO");
            Naming.rebind(nombreServicio, personaBO);
            
            nombreServicio = retornaNombreDelServicio("productoBO");
            Naming.rebind(nombreServicio, productoBO);
            
            nombreServicio = retornaNombreDelServicio("proveedorBO");
            Naming.rebind(nombreServicio, proveedorBO);
            
            nombreServicio = retornaNombreDelServicio("sedeBO");
            System.out.println("nombreServicio " + nombreServicio);
            Naming.rebind(nombreServicio, sedeBO);
            
            nombreServicio = retornaNombreDelServicio("tipoComprobanteBO");
            Naming.rebind(nombreServicio, tipoComprobanteBO);
            
            nombreServicio = retornaNombreDelServicio("tipoPersonaBO");
            Naming.rebind(nombreServicio, tipoPersonaBO);
            
            nombreServicio = retornaNombreDelServicio("tipoProductoBO");
            Naming.rebind(nombreServicio, tipoProductoBO);
            
            System.out.println("Servidor RMI registrado correctamente...");
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(CyberiaStore_RMI_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void leer_archivo_de_propiedades() {
        Properties properties = new Properties();
        try {            
            String nmArchivoConf = "C:\\glassfish-7.0.18\\glassfish7\\glassfish\\resources" + "\\" + ARCHIVO_CONFIGURACION;
            
            properties.load(new FileInputStream(new File(nmArchivoConf)));
            IP = properties.getProperty("ip");
            puerto = Integer.valueOf(properties.getProperty("puerto"));
        } catch (FileNotFoundException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        }
    }

    public static String retornaNombreDelServicio(String nombreObjetoRemoto) {
        return "//" + IP + ":" + puerto + "/" + nombreObjetoRemoto;
    }
}
