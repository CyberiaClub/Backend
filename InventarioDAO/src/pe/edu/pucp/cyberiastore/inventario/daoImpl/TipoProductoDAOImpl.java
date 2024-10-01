package pe.edu.pucp.cyberiastore.inventario.daoImpl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import pe.edu.pucp.cyberiastore.inventario.model.TipoProducto;
import pe.edu.pucp.cyberiastore.db.DAOImpl;
import pe.edu.pucp.cyberiastore.inventario.dao.TipoProductoDAO;

public class TipoProductoDAOImpl extends DAOImpl implements TipoProductoDAO {

    private TipoProducto tipoProducto;

    public TipoProductoDAOImpl(){
        super("TIPOPRODUCTO");
        this.tipoProducto = null;
    }

    @Override
    public Integer insertar(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        Integer id = this.insertar();
        this.tipoProducto.setIdTipoProducto(id);
        return id;
    }

    @Override
    public Integer modificar(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this.modificar();
    }

    @Override
    public Integer eliminar(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this.eliminar();
    }

    @Override
    protected String obtenerListaAtributos() {
        return "ID, NOMBRE, ACTIVO";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        String valores = "";
        valores = valores.concat("'"+tipoProducto.getTipo()+"'");
        valores = valores.concat(", ");
        valores = valores.concat("'"+tipoProducto.getActivo()+"'");
        return valores;
    }

    @Override
    protected String obtenerListaValoresParaModificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String obtenerCondicionPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TipoProducto> listar(String listado) {
        ArrayList<TipoProducto> listadoTipoProducto = new ArrayList();
        try{
            this.abrirConexion();
            this.ejecutarConsultaEnBD(listado);
            while(this.resultSet.next()){
                TipoProducto PlantilaTipoProd = new TipoProducto(
                this.resultSet.getString("TIPO")
                );
                listadoTipoProducto.add(PlantilaTipoProd);
            }
        }catch(SQLException ex){
            Logger.getLogger(TipoProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                this.cerrarConexion();
            }catch(SQLException ex){
                Logger.getLogger(TipoProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listadoTipoProducto;
    }

    @Override
    public ArrayList<TipoProducto> listarTodos() {
        String listado = this.obtenerListaValoresParaSeleccionar();
        return this.listar(listado);
    }

    @Override
    public TipoProducto obtenerPorId(String idTipoProducto) {
        String valores = this.obtenerListaValoresParaSeleccionar();
        valores = valores.concat(" and ID_TIPO_PRODUCTO = '" + idTipoProducto + "'");
        return this.listar(valores).getFirst();
    }
    
    @Override
    public Integer obtenerId(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        try {
            Integer id = this.retornarUltimoAutogenerado();
            this.tipoProducto.setIdTipoProducto(id);
        } catch (SQLException ex) {
            Logger.getLogger(TipoProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public String imprimirId(){
        return "" + this.tipoProducto.getIdTipoProducto();
    }
}
