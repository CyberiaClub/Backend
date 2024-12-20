package pe.edu.pucp.cyberiastore.inventario.dao;

import java.util.ArrayList;
import java.util.HashMap;
import pe.edu.pucp.cyberiastore.inventario.model.Producto;

public interface ProductoDAO {

    public Integer insertar(Producto producto);

    public Integer modificar(Producto producto);

    public Integer eliminar(Producto producto);

    public ArrayList<Producto> listarTodos();

    public Producto obtenerPorId(Integer idProducto);

    public Boolean existeProducto(Producto producto);

    public Producto buscar_sku(String sku, Integer idSede);

    public Integer aumentarStock(Integer idProducto, Integer idSede, Integer cantidad);

    public ArrayList<Producto> lineasPedido(Integer idPedido);
}
