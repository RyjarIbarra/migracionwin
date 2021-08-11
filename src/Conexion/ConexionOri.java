/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ADRIAN
 */
public class ConexionOri {
    public static Connection GetConnection(){
        Connection conexionori = null;
        String url = "";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            url = "jdbc:sqlserver:" + Conexion.instancia + ";databaseName="+ Conexion.conexionorivar +";user=adm;password=admadm;";
            conexionori = DriverManager.getConnection(url);
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexionori=null;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexionori=null;
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexionori=null;
        }
        finally{           
            return conexionori;
        }
    }
    static Statement createStatement() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    static PreparedStatement reparedStatement(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }    
}
