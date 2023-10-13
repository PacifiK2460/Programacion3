/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2.pkg2;

/**
 *
 * @author 177685
 */
public class Deportivo extends Auto implements Transporte {

    public Deportivo(String modelo, double price){
        super(modelo, price);
    }
    
    public void rendimiento(double km, double gas){
        System.out.println(km/gas);
    }
    
    @Override
    public void bienvenida(){
        System.out.println("Aca bien depo");
    }
    
    @Override
    public void acelerar() {
        System.out.println("Aca bien acelerado");
    }

    @Override
    public void abordar() {
        System.out.println("Subido");
    }

    @Override
    public void descender() {
        System.out.println("Bajado");
    }
    
}
