/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s06p01herencia;

/**
 *
 * @author 177685
 */
public class Here extends Sockeye {
    public Here(String nombre, int largo){
        super(nombre, largo);
    }
    
    public void saludar(){
        super.saludar();
        System.out.println("Soy Heredado del salmon Sockeye");
    }
}
