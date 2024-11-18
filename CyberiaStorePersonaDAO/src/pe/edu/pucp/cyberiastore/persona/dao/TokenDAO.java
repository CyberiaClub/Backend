package pe.edu.pucp.cyberiastore.persona.dao;

import pe.edu.pucp.cyberiastore.persona.model.Token;

public interface TokenDAO {
    
    public Integer insertar(Token token);
    
    public Integer eliminar(Token token);
    
    public Boolean existeToken(Token token);
    
    public Boolean existeToken(Token token, Boolean abreConexion);
    
    public Token buscarTokenPorValor(Token token);
    
}
