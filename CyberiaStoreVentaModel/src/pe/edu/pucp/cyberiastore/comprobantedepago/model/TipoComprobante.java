package pe.edu.pucp.cyberiastore.comprobantedepago.model;

public class TipoComprobante {
    private Integer idTipoComprobante;
    private String secuencial;
    private String tipoComprobante;
    private Boolean activo;
    
    public TipoComprobante(){
        this.tipoComprobante = null;
        this.secuencial = null;
        this.tipoComprobante = null;
        this.activo = true;
    }
    
    public TipoComprobante(Integer idTipoComprobante, String secuencial, String tipoComprobante, Boolean activo){
        this.idTipoComprobante = idTipoComprobante;
        this.secuencial = secuencial;
        this.tipoComprobante = tipoComprobante;
        this.activo = (activo == null) ? true:activo;
    }
    
    public Integer getIdTipoComprobante() {
        return idTipoComprobante;
    }
    
    public void setIdTipoComprobante(Integer idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }
    
    public String getSecuencial() {
        return secuencial;
    }
    
    public void setSecuencial(String secuencial) {
        this.secuencial = secuencial;
    }
    
    public String getTipoComprobante() {
        return tipoComprobante;
    }
    
    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }
    
    public Boolean getActivo() {
        return activo;
    }
    
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
