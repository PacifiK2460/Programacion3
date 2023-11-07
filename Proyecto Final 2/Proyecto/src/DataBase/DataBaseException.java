/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

/**
 *
 * @author 177685
 */
public class DataBaseException extends Exception {

    public DataBaseException() {
    }

    public DataBaseException(String mensaje) {
        super(mensaje);
    }

    public DataBaseException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }
}
