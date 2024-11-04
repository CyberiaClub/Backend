package pe.edu.pucp.cyberiastore.trabajador.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.cyberiastore.trabajador.model.Vendedor;
import pe.edu.pucp.cyberiastore.trabajador.dao.VendedorDAO;
import pe.edu.pucp.cyberiastore.trabajador.daoImpl.VendedorDAOImpl;
import pe.edu.pucp.cyberiastore.usuario.model.TipoDocumento;


public class VendedorBO {
    private VendedorDAO vendedorDAO;
    
    public VendedorBO(){
        this.vendedorDAO = new VendedorDAOImpl();
    }
    
    public Integer insertar(String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaDeNacimiento, String correo,
            String direccion, String contrasena, String nacionalidad, TipoDocumento tipoDeDocumento, Double sueldo, Date fechaDeIngreso, Integer idSede) {
        Vendedor vendedor = new Vendedor(documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, direccion, contrasena, nacionalidad, tipoDeDocumento, sueldo, fechaDeIngreso, idSede);
        return this.vendedorDAO.insertar(vendedor);
    }

    public Integer modificar(Integer idVendedor,Integer idTrabajador, Double sueldo, Date fechaDeIngreso, Integer idUsuario, String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaDeNacimiento, String correo, Boolean activo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        Vendedor vendedor = new Vendedor(idVendedor,idTrabajador, sueldo, fechaDeIngreso, idUsuario, documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, activo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        return this.vendedorDAO.modificar(vendedor);
    }

    public Vendedor obtenerPorId(Integer idVendedor) {
        return this.vendedorDAO.obtenerPorId(idVendedor);
    }

    public ArrayList<Vendedor> listarTodos() {
        return this.vendedorDAO.listarTodos();
    }
}
