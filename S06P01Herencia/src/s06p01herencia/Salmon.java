/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s06p01herencia;

/**
 *
 * @author 177685
 */
public class Salmon {

    private String nombre;
    private int largo;

    public Salmon(String nombre, int largo) {
        this.nombre = nombre;
        this.largo = largo;
    }

    public void saludar() {
        System.out.println("Salmon generico de nombre " + this.nombre + " y largo " + this.largo);
    }

}
