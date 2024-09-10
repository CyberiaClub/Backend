package pe.edu.pucp.inventario;

public class TipoProducto {

    private static Integer idTipoProducto = 0;
    private String tipo;

    public TipoProducto(String tipo) {
        this.tipo = tipo;
        this.idTipoProducto++;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
