/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s13p01hilos;

/**
 *
 * Hilos (Threads):
 *
 * Implementa el concepto de multiporgramación en Java, ya que permite que dos o
 * mas bloques de codigo se ejecuten simultaneamente:
 *
 * - El programa principal de hecho ya se un thread. - Un thread se maneja como
 * un ciclo de vida e inicia al llamar su metodo "run". - Metodo run debe
 * sobreescribirse en una clase que extienda de thread. - Para iniciar un hilo
 * se llama el metodo start que realiza una serie de preparaciones para ejecutar
 * el hilo y finalmente manda llamar a run. - No se debe llamar mas de una vez
 * el metodo start de un hilo. - Se debe programar siempre un metodo para que el
 * hilo termine, ya sea algun ciclo o una condicion.
 *
 * @author 177685
 */
public class S13P01Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        MiHilo h0 = new MiHilo();
        MiHilo h1 = new MiHilo();
        MiHilo h2 = new MiHilo();
        MiHilo h3 = new MiHilo();
        
        h0.start();
        h1.start();
        h2.start();
        h3.start();
    }

}
