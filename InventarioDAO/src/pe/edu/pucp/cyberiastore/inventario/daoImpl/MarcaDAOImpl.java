package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import pe.edu.pucp.cyberiastore.inventario.model.Marca;
import pe.edu.pucp.cyberiastore.inventario.dao.MarcaDAO;
import pe.edu.pucp.cyberiastore.db.DAOImpl;

public class MarcaDAOImpl extends DAOImpl implements MarcaDAO {

    private Marca marca;

    public MarcaDAOImpl() {
        super("MARCA");
        this.marca = null;
    }

    @Override
    public Integer insertar(Marca marca) {
        this.marca = marca;
        Integer id = this.insertar();
        this.marca.setIdMarca(id);
        return id;
    }

    @Override
    public Integer modificar(Marca marca) {
        this.marca = marca;
        return this.modificar();
    }

    @Override
    public Integer eliminar(Marca marca) {
        this.marca = marca;
        return this.eliminar();
    }

    @Override
    protected String obtenerListaAtributos() {
        return "NOMBRE, ACTIVO";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String valores="";
        
        valores=valores.concat("'"+marca.getNombre()+"'");
        valores=valores.concat(", ");
        valores=valores.concat("'"+marca.getActivo()+"'");
        return valores;
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        String mod="NOMBRE = ";
        
        mod=mod.concat("'"+marca.getNombre()+"'");
        
        return mod;
    }

    @Override
    protected String obtenerCondicionPorId() {
        String id = "ID_MARCA = ";
        id = id.concat("'"+this.marca.getIdMarca().toString()+"'");
        
        return id;
    }

    @Override
    public ArrayList<Marca> listar(String listado) {
        ArrayList<Marca> listaMarcas = new ArrayList();
        try{
            this.abrirConexion();
            this.ejecutarConsultaEnBD(listado);
            while(this.resultSet.next()){
                Marca plantillaMarca = new Marca(this.resultSet.getString("NOMBRE"));
                listaMarcas.add(plantillaMarca);
            }
        }catch(SQLException ex){
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                this.cerrarConexion();
            }catch(SQLException ex){
                Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaMarcas;
    }

    @Override
    public ArrayList<Marca> listarTodos() {
        String listado = this.obtenerListaValoresParaSeleccionar();
        return this.listar(listado);
    }

    @Override
    public Marca obtenerPorId(String idMarca) {
        String sql = this.obtenerListaValoresParaSeleccionar();
        sql = sql.concat(" and ID_MARCA = '" + idMarca + "'");
        return this.listar(sql).getFirst();
    }
    
    @Override
    public Integer obtenerId(Marca marca) {
        this.marca = marca;
        try {
            Integer id = this.retornarUltimoAutogenerado();
            this.marca.setIdMarca(id);
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public String imprimirId(){
        return "" + this.marca.getIdMarca();
    }
}
