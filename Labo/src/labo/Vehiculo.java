/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labo;

/**
 *
 * @author 177685
 */
public class Vehiculo {
    private String marca;
    private int anioDeFabricacion;
    
    public Vehiculo(String marca, int anioDeFabricacion){
        this.marca = marca;
        this.anioDeFabricacion = anioDeFabricacion;
    }
    
    public int getPrecioMensual(){
        return 1;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public int getAnioDeFabricacion(){
        return this.anioDeFabricacion;
    }
    
    public void ticket(){
        System.out.println("Este carro " + this.marca + " ( " + this.anioDeFabricacion + " )");
        System.out.println("Tenra un precio de: $" + this.getPrecioMensual());
    }
}
