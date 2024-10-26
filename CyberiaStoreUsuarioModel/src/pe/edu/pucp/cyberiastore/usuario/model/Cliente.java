package pe.edu.pucp.cyberiastore.usuario.model;

import java.util.Date;

public class Cliente extends Usuario {

    private Integer idCliente;
    private Boolean verificado;

    /*Constructor vacio*/
    public Cliente() {
        this.verificado = false;
        this.setActivo(true);
    }

    public Cliente(String documento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaDeNacimiento, String correo, String contrasena, String nacionalidad, String direccion, TipoDocumento tipoDeDocumento) {
        super(documento, telefono, nombre, apellidoPaterno, apellidoMaterno, fechaDeNacimiento, correo, contrasena, nacionalidad, direccion, tipoDeDocumento);
        this.verificado = false;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public Integer getVerificadoAsInt() {
        if (this.verificado) {
            return 1;
        } else {
            return 0;
        }
    }
}
