/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s13p02ejersiciohilos;

/**
 *
 * Realiza: - Un hilo que si recibe un 1, imprima los nones, o pare si recibe un
 * 2, del 1 al 200.
 *
 * - Cree 4 objetos de la clase que contiene el hilo y ejecute.
 *
 * @author 177685
 */
public class S13P02EjersicioHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tejedora h0 = new Tejedora(1);
        Tejedora h1 = new Tejedora(2);
        Tejedora h2 = new Tejedora(2);
        Tejedora h3 = new Tejedora(1);

        h0.start();
        h1.start();
        h2.start();
        h3.start();
    }

}
