package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    String url= "jdbc:mysql://localhost:3306/Login";
    String user= "root";
    String password= "Twice1$ua2";
    String driver= "com.mysql.cj.jdbc.Driver";
    Connection cx=null;   
   
//    Sobre carga del metodo para la base de datos
    public ConexionBD(){   
    }
//    Proceso de conexion a la base de datos 
    public Connection conectar(){
            try {
                Class.forName(driver);
                cx=DriverManager.getConnection(url,user,password);
                System.out.println("Conectado a la base de datos: ");
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("No se conecto a la base de datos: ");
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return cx;   
    }
//    proceso de desconectar la base de datos
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }    

    public PreparedStatement PreparedStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}