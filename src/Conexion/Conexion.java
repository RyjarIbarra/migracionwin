package Conexion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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
public class Conexion {
    public static String instancia = "";
    public static String conexionfull = "";
    public static String conexionorivar = "";
    public static String conexiondesvar = "";
    public static Connection GetConnection(){
        Connection conexion = null;   
        Connection conexionori = null;
        Connection conexiondes = null;
        String url = "";
        String url2 = "";
        String url3 = "";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
             instancia = instancia.replaceAll(" ", "");
            if(instancia.length()>0){
                instancia = "//"+instancia;
                url = "jdbc:sqlserver:" + instancia + ";databaseName=master;user=adm;password=admadm;";
                url2 = "jdbc:sqlserver:" + instancia + ";databaseName="+ conexionorivar +";user=adm;password=admadm;";
                url3 = "jdbc:sqlserver:" + instancia + ";databaseName="+ conexiondesvar +";user=adm;password=admadm;";
            }            
           // url = "jdbc:sqlserver://localhost;databaseName=JavaComercial;user=sa;password=1;";
            conexion = DriverManager.getConnection(url);
            conexionori = DriverManager.getConnection(url2);
            conexiondes = DriverManager.getConnection(url3);
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        finally{           
            return conexion;
        }
    }
    static Statement createStatement() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    static PreparedStatement reparedStatement(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
