package pe.edu.pucp.sede;

import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.inventario.Producto;


public class StockSede {
    private Sede sede;
    private Map<Producto, Integer> stock;

    public StockSede(Sede sede) {
        this.sede = sede;
        this.stock = new HashMap<>();
    }

    public Sede getSede() {
        return sede;
    }
    
    
    
}
