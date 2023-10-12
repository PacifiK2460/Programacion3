/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s10p05polimorfismoconherencia;

/**
 *
 * @author 177685
 */
public class Hijo extends Padre {
    
    @Override
    public void cocinar(){
        System.out.println("Uber eats");
    }
    
    @Override
    public void redesSociales(){
        System.out.println("TikTok");
    }
    
    public void programar(){
        System.out.println("Java");
    }
    
}
