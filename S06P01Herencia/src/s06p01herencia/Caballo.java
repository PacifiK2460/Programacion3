/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s06p01herencia;

/**
 *
 * @author 177685
 */
public class Caballo extends Animal {
    private String color;
    
    public Caballo(String color, String nombre, String raza){
        super(nombre, raza);
        this.color = color;
    }
    
    public void comer(){
        super.comer();
        System.out.println("Ademas soy un caballo");
    }
}
