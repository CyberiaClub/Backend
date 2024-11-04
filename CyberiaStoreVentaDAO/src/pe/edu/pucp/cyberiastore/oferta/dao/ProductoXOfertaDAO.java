/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.cyberiastore.oferta.dao;

import java.sql.Connection;

public interface ProductoXOfertaDAO {
    
    public Integer insertar(Integer idProducto, Integer idOferta);

    public Integer insertar(Integer idProducto, Integer idOferta, Boolean usarTransaccion, Connection conexion);
}
