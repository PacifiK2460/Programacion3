/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s10p05polimorfismoconherencia;

/**
 *
 * @author 177685
 */
public class Padre extends Abuelo {
    @Override
    public void cocinar(){
        System.out.println("Con estufa de gas y microondas");
    }
    
    public void redesSociales(){
        System.out.println("Tengo feis");
    }
}
