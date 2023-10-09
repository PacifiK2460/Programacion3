/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s06p01herencia;

/**
 *
 * @author 177685
 */
public class Animal {
    private String nombre;
    private String raza;
    
    public Animal(String nombre, String raza){
        this.nombre = nombre;
        this.raza = raza;
    }
    
    public void comer(){
        System.out.println("Genericamente como");
    }
}
