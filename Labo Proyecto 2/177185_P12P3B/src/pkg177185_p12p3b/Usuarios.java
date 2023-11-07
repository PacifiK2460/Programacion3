/* Universidad Politecnica de San Luis Potosi
 * Practica 8 Practica Integradora Parte 1
 * 180408 / Marlen Victoria Silva Castillo
 * Grupo: A     Horario: 4:00-6:00
 * Fecha: 16/10/23
 */
package pkg177185_p12p3b;

import java.util.ArrayList;
import javax.swing.JFrame;

public class Usuarios{
    private ArrayList<Usuarios> usuariosList = new ArrayList<>();
    private int id; 
    private String user_name;
    private double saldo;

    //Constructor
    public Usuarios(int id, String user_name, double saldo) {
        this.id = id;
        this.user_name = user_name;
        this.saldo = saldo;
    }
    
    //Encapsulamiento
    public int getId() 
    {
        return id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    
    public double getSaldo() 
    {
        return saldo;
    }
    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    public String getUser_name() 
    {
        return user_name;
    }
    
    public void setUser_name(String user_name) 
    {
        this.user_name = user_name;
    }
    
    public ArrayList<Usuarios> getUsuariosList() 
    {
        return usuariosList;
    }
}
