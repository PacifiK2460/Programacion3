/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labo;

/**
 *
 * @author 177685
 */
public class Automovil extends Vehiculo {
    private String tipoDeCarroceria;
    
    public Automovil(String marca, int anioDeFabricacion, String tipoDeCarroceria){
        super(marca, anioDeFabricacion);
        this.tipoDeCarroceria = tipoDeCarroceria;
    }
    
   @Override
   public int getPrecioMensual(){
       return 10;
   }
   
   @Override
   public void ticket(){
        System.out.println("Este " + this.getMarca() + " ( " + this.getAnioDeFabricacion() + " ): " + this.tipoDeCarroceria);
        System.out.println("Tenra un precio de: $" + this.getPrecioMensual());
   }
}
