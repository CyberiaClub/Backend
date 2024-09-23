package pe.edu.pucp.cyberiastore.trabajador.daoImpl;

import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.cyberiastore.trabajador.dao.TrabajadorDAO;
import pe.edu.pucp.cyberiastore.trabajador.model.Trabajador;

//Mencion de la Tabla

public class TrabajadorDAOImpl implements TrabajadorDAO{

    private Connection conexion;
    private Statement statement;
    private ResultSet resultSet;
    
    @Override
    public Integer insertar(Trabajador trabajador) {
        Integer resultado=0;
        try{
            this.conexion= DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql="insert into Trabajador (sueldo, fechaDeIngreso, fechaDeSalida) values (";
            sql=sql.concat("'" + trabajador.getSueldo() + "'");
            sql=sql.concat(",");
            sql=sql.concat("'" + trabajador.getFechaDeIngreso()+ "'");
            sql=sql.concat(",");
            sql=sql.concat("'" + trabajador.getFechaDeSalida()+ "'");
            sql=sql.concat(")");
            this.statement=this.conexion.createStatement();
            resultado=this.statement.executeUpdate(sql);
            this.conexion.commit();
        
        } catch (SQLException ex) {
            try {
                if (this.conexion != null)
                    this.conexion.rollback();
                Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally{
            if (this.conexion != null)
                try {
                    this.conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(TrabajadorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public Integer modificar(Trabajador trabajador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Trabajador trabajador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Trabajador> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Trabajador obtenerPorId(Integer trabajador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
