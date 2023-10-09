/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s07p05interfaces;

/**
 *
 * @author 177685
 */
public class Celular implements Telefono {
    @Override
    public void marcarNumero(int numero){
        System.out.println("Marcando al número " + numero);
    }

    @Override
    public void llamadaEnProgreso() {
        System.out.println("Llamada en progreso");
    }
}
