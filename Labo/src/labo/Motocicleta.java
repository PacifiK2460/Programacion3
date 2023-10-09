/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labo;

/**
 *
 * @author 177685
 */
public class Motocicleta extends Vehiculo {

    private int cilindraje;

    public Motocicleta(String marca, int anioDeFabricacion, int cilindraje) {
        super(marca, anioDeFabricacion);
        this.cilindraje = cilindraje;
    }

    @Override
    public int getPrecioMensual() {
        return 5;
    }

    @Override
    public void ticket() {
        System.out.println("Esta motocicleta " + this.getMarca() + " ( " + this.getAnioDeFabricacion() + " ): " + this.cilindraje + "CC");
        System.out.println("Tenra un precio de: $" + this.getPrecioMensual());
    }
}
