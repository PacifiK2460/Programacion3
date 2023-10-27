/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboproyecto;

/**
 *
 * @author 177685
 */
public class Usuario {

    private int id;
    private String user_name;
    private double saldo;

    public Usuario(int id, String user_name, double saldo) {
        this.id = id;
        this.user_name = user_name;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return user_name;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setId(int nuevo_id) {
        id = nuevo_id;
    }

    public void setUserName(String nuevo_user_name) {
        user_name = nuevo_user_name;
    }

    public void setSaldo(double nuevo_saldo) {
        saldo = nuevo_saldo;
    }
}
