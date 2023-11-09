/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 177685
 */
public class DataBase {

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private Connection conexion = null;

    public Connection conectar(String url, String user, String password) throws DataBaseException {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new DataBaseException("Imposible conectar a la base de Datos", ex);
        }
        return conexion;
    }

    public void desconectar() throws DataBaseException {
        try {
            conexion.close();
        } catch (SQLException ex) {
            throw new DataBaseException("Imposible cerrar a la base de Datos", ex);
        }
    }
}
