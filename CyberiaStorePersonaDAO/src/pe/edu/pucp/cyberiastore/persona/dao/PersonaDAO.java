package pe.edu.pucp.cyberiastore.persona.dao;

import java.sql.Connection;
import java.util.ArrayList;
import pe.edu.pucp.cyberiastore.persona.model.Persona;

public interface PersonaDAO {

    public Integer insertar(Persona persona);

    public Integer insertar(Persona persona, Boolean usarTransaccion, Connection conexion);

    public Integer modificar(Persona persona);

    public Integer modificar(Persona persona, Boolean usarTransaccion, Connection conexion);

    public Integer eliminar(Persona persona);

    public Integer eliminar(Persona persona, Boolean usarTransaccion, Connection conexion);

    public ArrayList<Persona> listarTodos();

    public Persona obtenerPorDocumento(String documento);

    public Boolean existePersona(Persona persona);
}
