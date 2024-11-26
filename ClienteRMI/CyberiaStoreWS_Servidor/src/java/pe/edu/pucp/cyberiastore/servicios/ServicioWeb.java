package pe.edu.pucp.cyberiastore.servicios;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.comprobantepago.model.ComprobantePago;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.oferta.model.Oferta;
import pe.edu.pucp.cyberiastore.persona.model.Persona;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;
import pe.edu.pucp.cyberiastore.inventario.model.Proveedor;
import pe.edu.pucp.cyberiastore.inventario.model.Sede;
import pe.edu.pucp.cyberiastore.comprobantepago.model.TipoComprobante;
import pe.edu.pucp.cyberiastore.persona.model.TipoPersona;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
import pe.edu.pucp.cyberiastore.rmi.interfaces.ComprobantePagoBO;
import pe.edu.pucp.cyberiastore.rmi.interfaces.MarcaBO;
import pe.edu.pucp.cyberiastore.rmi.interfaces.OfertaBO;
import pe.edu.pucp.cyberiastore.rmi.interfaces.PersonaBO;
import pe.edu.pucp.cyberiastore.rmi.interfaces.ProductoBO;
import pe.edu.pucp.cyberiastore.rmi.interfaces.ProveedorBO;
import pe.edu.pucp.cyberiastore.rmi.interfaces.SedeBO;
import pe.edu.pucp.cyberiastore.rmi.interfaces.TipoComprobanteBO;
import pe.edu.pucp.cyberiastore.rmi.interfaces.TipoPersonaBO;
import pe.edu.pucp.cyberiastore.rmi.interfaces.TipoProductoBO;

@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

    private static final String ARCHIVO_CONFIGURACION = "rmi.properties";
    private String IP;
    private Integer puerto;

    private ComprobantePagoBO comprobantePagoBO;
    private MarcaBO marcaBO;
    private OfertaBO ofertaBO;
    private PersonaBO personaBO;
    private ProductoBO productoBO;
    private ProveedorBO proveedorBO;
    private SedeBO sedeBO;
    private TipoComprobanteBO tipoComprobanteBO;
    private TipoPersonaBO tipoPersonaBO;
    private TipoProductoBO tipoProductoBO;

    public ServicioWeb() {
        try {
            this.leer_archivo_de_propiedades();
            System.out.println("IP" + IP);
            System.out.println("puerto" + puerto);

            String nombreServicio = this.retornaNombreDelServicio("comprobantePagoBO");
            this.comprobantePagoBO = (ComprobantePagoBO) Naming.lookup(nombreServicio);

            nombreServicio = this.retornaNombreDelServicio("marcaBO");
            this.marcaBO = (MarcaBO) Naming.lookup(nombreServicio);

            nombreServicio = this.retornaNombreDelServicio("ofertaBO");
            this.ofertaBO = (OfertaBO) Naming.lookup(nombreServicio);

            nombreServicio = this.retornaNombreDelServicio("personaBO");
            this.personaBO = (PersonaBO) Naming.lookup(nombreServicio);

            nombreServicio = this.retornaNombreDelServicio("productoBO");
            this.productoBO = (ProductoBO) Naming.lookup(nombreServicio);

            nombreServicio = this.retornaNombreDelServicio("proveedorBO");
            this.proveedorBO = (ProveedorBO) Naming.lookup(nombreServicio);

            nombreServicio = this.retornaNombreDelServicio("sedeBO");
            this.sedeBO = (SedeBO) Naming.lookup(nombreServicio);

            nombreServicio = this.retornaNombreDelServicio("tipoComprobanteBO");
            this.tipoComprobanteBO = (TipoComprobanteBO) Naming.lookup(nombreServicio);

            nombreServicio = this.retornaNombreDelServicio("tipoPersonaBO");
            this.tipoPersonaBO = (TipoPersonaBO) Naming.lookup(nombreServicio);

            nombreServicio = this.retornaNombreDelServicio("tipoProductoBO");
            this.tipoProductoBO = (TipoProductoBO) Naming.lookup(nombreServicio);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void leer_archivo_de_propiedades() {
        Properties properties = new Properties();
        try {
            String nmArchivoConf = "C:\\Properties" + "\\" + ARCHIVO_CONFIGURACION;

            properties.load(new FileInputStream(new File(nmArchivoConf)));
            IP = properties.getProperty("ip");
            puerto = Integer.valueOf(properties.getProperty("puerto"));
        } catch (FileNotFoundException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        }
    }

    public String retornaNombreDelServicio(String nombreObjetoRemoto) {
        return "//" + IP + ":" + puerto + "/" + nombreObjetoRemoto;
    }

    /**
     * *************************************************************************
     * WEB SERVICE MARCA
    ***************************************************************************
     */
    @WebMethod(operationName = "marca_insertar")
    public Integer marca_insertar(@WebParam(name = "marca") Marca marca) {
        Integer retorno = null;
        try {
            retorno = marcaBO.insertar(marca);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "marca_listar")
    public ArrayList<Marca> marca_listar() {
        ArrayList retorno = null;
        try {
            retorno = marcaBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "marca_eliminar")
    public Integer marca_eliminar(@WebParam(name = "marca") Marca marca) {
        Integer retorno = null;
        try {
            retorno = marcaBO.eliminar(marca);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    /**
     * *************************************************************************
     * WEB SERVICE PRODUCTO
    ***************************************************************************
     */
    @WebMethod(operationName = "producto_insertar")
    public Integer producto_insertar(@WebParam(name = "producto") Producto producto) {
        Integer retorno = null;
        try {
            retorno = productoBO.insertar(producto);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "producto_modificar")
    public Integer producto_modificar(@WebParam(name = "producto") Producto producto) {
        Integer retorno = null;
        try {
            retorno = productoBO.modificar(producto);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "producto_listar")
    public ArrayList<Producto> producto_listar() {
        ArrayList retorno = null;
        try {
            retorno = productoBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "producto_buscar_sku")
    public Producto producto_buscar_sku(@WebParam(name = "sku") String sku, @WebParam(name = "idSede") Integer idSede) {
        Producto retorno = null;
        try {
            retorno = productoBO.buscar_sku(sku, idSede);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "producto_aumentar_stock")
    public Integer producto_aumentar_stock(@WebParam(name = "idProducto") Integer idProducto, @WebParam(name = "idSede") Integer idSede, @WebParam(name = "cantidad") Integer cantidad) {
        Integer retorno = null;
        try {
            retorno = productoBO.aumentarStock(idProducto, idSede, cantidad);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "producto_lineas_pedido")
    public ArrayList<Producto> producto_lineas_pedido(@WebParam(name = "idPedido") Integer idPedido) {
        ArrayList retorno = null;
        try {
            retorno = productoBO.lineasPedido(idPedido);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    /**
     * *************************************************************************
     * WEB SERVICE PROVEEDOR
    ***************************************************************************
     */
    @WebMethod(operationName = "proveedor_insertar")
    public Integer proveedor_insertar(@WebParam(name = "proveedor") Proveedor proveedor) {
        Integer retorno = null;
        try {
            retorno = proveedorBO.insertar(proveedor);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "proveedor_modificar")
    public Integer proveedor_modificar(@WebParam(name = "proveedor") Proveedor proveedor) {
        Integer retorno = null;
        try {
            retorno = proveedorBO.modificar(proveedor);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "proveedor_listar")
    public ArrayList<Proveedor> proveedor_listar() {
        ArrayList retorno = null;
        try {
            retorno = proveedorBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "proveedor_eliminar")
    public Integer proveedor_eliminar(@WebParam(name = "proveedor") Proveedor proveedor) {
        Integer retorno = null;
        try {
            retorno = proveedorBO.eliminar(proveedor);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    /**
     * *************************************************************************
     * WEB SERVICE SEDE
    ***************************************************************************
     */
    @WebMethod(operationName = "sede_insertar")
    public Integer sede_insertar(@WebParam(name = "sede") Sede sede) {
        Integer retorno = null;
        try {
            retorno = sedeBO.insertar(sede);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "sede_modificar")
    public Integer sede_modificar(@WebParam(name = "sede") Sede sede) {
        Integer retorno = null;
        try {
            retorno = sedeBO.modificar(sede);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "sede_listar")
    public ArrayList<Sede> sede_listar() {
        ArrayList retorno = null;
        try {
            retorno = sedeBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    /**
     * *************************************************************************
     * WEB SERVICE TIPO PRODUCTO
    ***************************************************************************
     */
    @WebMethod(operationName = "tipoProducto_insertar")
    public Integer tipoProducto_insertar(@WebParam(name = "TipoProducto") TipoProducto tipoProducto) {
        Integer retorno = null;
        try {
            retorno = tipoProductoBO.insertar(tipoProducto);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "tipoProducto_modificar")
    public Integer tipoProducto_modificar(@WebParam(name = "TipoProducto") TipoProducto tipoProducto) {
        Integer retorno = null;
        try {
            retorno = tipoProductoBO.modificar(tipoProducto);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "tipoProducto_listar")
    public ArrayList<TipoProducto> tipoProducto_listar() {
        ArrayList retorno = null;
        try {
            retorno = tipoProductoBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "tipoProducto_eliminar")
    public Integer tipoProducto_eliminar(@WebParam(name = "TipoProducto") TipoProducto tipoProducto) {
        Integer retorno = null;
        try {
            retorno = tipoProductoBO.eliminar(tipoProducto);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    /**
     * *************************************************************************
     * WEB SERVICE PERSONA
    ***************************************************************************
     */
    @WebMethod(operationName = "persona_insertar")
    public Integer persona_insertar(@WebParam(name = "persona") Persona persona) {
        Integer retorno = null;
        try {
            retorno = personaBO.insertar(persona);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "persona_modificar")
    public Integer persona_modificar(@WebParam(name = "persona") Persona persona) {
        Integer retorno = null;
        try {
            retorno = personaBO.modificar(persona);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "persona_buscar_por_documento")
    public Persona persona_buscar_por_documento(@WebParam(name = "documento") String documento) {
        Persona retorno = null;
        try {
            retorno = personaBO.obtenerPorDocumento(documento);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "persona_enviar_correo_verificacion")
    public Boolean persona_enviar_correo_verificacion(@WebParam(name = "correo") String correo, @WebParam(name = "valorToken") String valorToken) {
        Boolean retorno = null;
        try {
            retorno = personaBO.enviarCorreoVerificacion(correo, valorToken);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "persona_verificar_correo")
    public Integer persona_verificar_correo(@WebParam(name = "valorToken") String valorToken) {
        Integer retorno = null;
        try {
            retorno = personaBO.marcarVerificado(valorToken);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "persona_loguearse")
    public Persona persona_loguearse(@WebParam(name = "correo") String correo, @WebParam(name = "contrasena") String contrasena) {
        Persona retorno = null;
        try {
            retorno = personaBO.verificarPersona(correo, contrasena);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    /**
     * *************************************************************************
     * WEB SERVICE TIPO PERSONA
    ***************************************************************************
     */
    @WebMethod(operationName = "tipopersona_listar_roles_trabajadores")
    public ArrayList<TipoPersona> tipopersona_listar_roles_trabajadores() {
        ArrayList retorno = null;
        try {
            retorno = this.tipoPersonaBO.listarRolesDeTrabajadores();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "tipopersona_listar_paginas")
    public TipoPersona tipopersona_listar_paginas(@WebParam(name = "tipo_persona") String tipo_persona) {
        TipoPersona retorno = null;
        try {
            retorno = this.tipoPersonaBO.listarPaginas(tipo_persona);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    /**
     * *************************************************************************
     * WEB SERVICE COMPROBANTE DE PAGO
    ***************************************************************************
     */
    @WebMethod(operationName = "comprobante_pago_listar")
    public ArrayList<ComprobantePago> comprobante_pago_listar() {
        ArrayList retorno = null;
        try {
            retorno = comprobantePagoBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "comprobante_pago_listar_cliente")
    public ArrayList<ComprobantePago> comprobante_pago_listar_cliente(@WebParam(name = "id_cliente") Integer idCliente) {
        ArrayList retorno = null;
        try {
            retorno = comprobantePagoBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "comprobante_pago_obtener_por_id")
    public ComprobantePago comprobante_pago_obtener_por_id(@WebParam(name = "id_comprobante_pago") Integer idComprobantePago) {
        ComprobantePago retorno = null;
        try {
            retorno = comprobantePagoBO.obtenerPorId(idComprobantePago);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "comprobante_pago_insertar")
    public Integer comprobante_pago_insertar(@WebParam(name = "comprobante_pago") ComprobantePago comprobante_pago) {
        Integer retorno = null;
        try {
            retorno = comprobantePagoBO.insertar(comprobante_pago);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "comprobante_pago_modificar")
    public Integer comprobante_pago_modificar(@WebParam(name = "comprobante_pago") ComprobantePago comprobante_pago) {
        Integer retorno = null;
        try {
            retorno = comprobantePagoBO.modificar(comprobante_pago);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "comprobante_buscar_usuario")
    public ArrayList<ComprobantePago> comprobante_buscar_usuario(@WebParam(name = "id_persona") Integer idPersona) {
        ArrayList retorno = null;
        try {
            retorno = comprobantePagoBO.buscarPersona(idPersona);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "comprobante_buscar_sede")
    public ArrayList<ComprobantePago> comprobante_buscar_sede(@WebParam(name = "id_sede") Integer idSede) {
        ArrayList retorno = null;
        try {
            retorno = comprobantePagoBO.buscarSede(idSede);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    /**
     * *************************************************************************
     * WEB SERVICE OFERTA
    ***************************************************************************
     */
    @WebMethod(operationName = "oferta_insertar")
    public Integer oferta_insertar(@WebParam(name = "oferta") Oferta oferta, @WebParam(name = "productosOferta") ArrayList<Producto> productosOferta) {
        oferta.setProductos(productosOferta);
        Integer retorno = null;
        try {
            retorno = ofertaBO.insertar(oferta);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "oferta_modificar")
    public Integer oferta_modificar(@WebParam(name = "oferta") Oferta oferta) {
        Integer retorno = null;
        try {
            retorno = ofertaBO.modificar(oferta);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @WebMethod(operationName = "oferta_listar")
    public ArrayList<Oferta> oferta_listar() {
        ArrayList retorno = null;
        try {
            retorno = ofertaBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    /**
     * *************************************************************************
     * WEB SERVICE TIPO COMPROBANTE
    ***************************************************************************
     */
    @WebMethod(operationName = "tipo_comprobante_listar")
    public ArrayList<TipoComprobante> tipo_comprobante_listar() {
        ArrayList retorno = null;
        try {
            retorno = tipoComprobanteBO.listarTodos();
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
