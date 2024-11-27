package pe.edu.pucp.cyberiastore.persona.model;

import java.util.UUID;

public class Token {

    private Integer idToken;
    private String valor;
    private Boolean activo;
    private Integer idPersona;

    public Token() {

    }

    public Integer getIdToken() {
        return idToken;
    }

    public void setIdToken(Integer idToken) {
        this.idToken = idToken;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public void generarToken() {
        this.valor = UUID.randomUUID().toString();
    }

}
