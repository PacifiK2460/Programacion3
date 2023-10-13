/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2.pkg2;

/**
 *
 * @author 177685
 */
public abstract class Auto {
    private String modelo;
    private double price;
    
    public Auto(String modelo, double price){
        this.modelo = modelo;
        this.price = price;
    }
    
    public abstract void acelerar();
    
    public void bienvenida(){
        System.out.println("Hola, te habla tu carro");
    }
}
