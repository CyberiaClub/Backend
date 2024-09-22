package pe.edu.pucp.cyberiastore.sede.model;

import java.util.ArrayList;

public class Empresa {
    private String razonSoial;
    private String RUC;
    private String direccion;
    private ArrayList<Sede> sedes;

    public Empresa(String razonSoial, String RUC, String direccion) {
        this.razonSoial = razonSoial;
        this.RUC = RUC;
        this.direccion = direccion;
    }

    /**
     * @return the razonSoial
     */
    public String getRazonSoial() {
        return razonSoial;
    }

    /**
     * @param razonSoial the razonSoial to set
     */
    public void setRazonSoial(String razonSoial) {
        this.razonSoial = razonSoial;
    }

    /**
     * @return the RUC
     */
    public String getRUC() {
        return RUC;
    }

    /**
     * @param RUC the RUC to set
     */
    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
s    
    
    
}
