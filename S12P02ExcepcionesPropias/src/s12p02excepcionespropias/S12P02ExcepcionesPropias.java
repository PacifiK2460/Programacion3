/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s12p02excepcionespropias;

import java.util.Scanner;

/*
    Se mas cuidadosa Sai :)
*/

/**
 * Excepciones:
 *  Estas se generan al crear metodos que lanzan excepciones.
 *
 *  El metodo debe de llevar en el encabezado la palabra "throws" que avisa que
 *  el metodo puede regresar una excepcion.
 *
 *  Dentro de este metodo, se debe de colocar una instrucción "throw" que es la
 *  que lance la excepción.
 *
 * ---
 * 
 * Agregue:
 *  Una validación para que las personas INAPAN validen su edad porque les
 *  vamos a dar su beca.
 * 
 * @author 177685
 */
public class S12P02ExcepcionesPropias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        MisExcepciones Ex = new MisExcepciones();

        System.out.print("Calificación 1: ");
        int x = scanner.nextInt();

        /*
            Ex.validarCalificacion(x);
        
            Es erroneo por si solo, ya que "unreported exception Exception; must be caught or declared to be thrown".
            Ya que lanza excepciones pero no la estamos atrapando.
        
            Por ende tenemos que atraparla con un bloque try-catch:
         */
        try {
            Ex.validarCalificacion(x);
        } catch (Exception ex) {
            System.out.println("Calificación invalida");
            return;
        }

        System.out.print("Calificación 2: ");
        int y = scanner.nextInt();

        try {
            Ex.validarCalificacion(y);
        } catch (Exception ex) {
            System.out.println("Calificación invalida");
            return;
        }

        System.out.println("El promedio es: " + (x + y) / 2);
        
        int edad = scanner.nextInt();
        try{
            Ex.validarEdad(edad);
        }catch(Exception ex){
            // Se agrega el mensaje de la excepción 
           System.out.println("Edad invalida: " + ex);
        }
        System.out.println("Beca otorgada :)");
    }

}
