/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s06p01herencia;

/**
 *
 * @author 177685
 */
public class Masu extends Salmon {
    public Masu(String nombre, int largo){
        super(nombre, largo);
    }
    
    public void saludar(){
        super.saludar();
        System.out.println("Mi nombre cientifico es: Oncorhynchus masou (Brevoort, 1856)");
    }
}
