/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s06p01herencia;

/**
 *
 * @author 177685
 */
public class Sockeye extends Salmon {
    public Sockeye(String nombre, int largo) {
        super(nombre, largo);
    }
    
    public void saludar(){
        super.saludar();
        System.out.println("Mi nombre cientifico es Oncorhynchus nerka (Walbaum, 1792)");
    }
}
