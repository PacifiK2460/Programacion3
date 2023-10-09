/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen.pkg1;
import java.util.Scanner;

/**
 *
 * @author 177685
 */
public class Examen1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Scanner input = new Scanner(System.in);
           Conversion conversiones = new Conversion();
           
           conversiones.setCelsius(input.nextFloat());
           conversiones.convertCelsiusToFarenheit();
           conversiones.convertCelsiusToKelvin();
           
           System.out.println("Celsius: " + conversiones.getCelsius());
           System.out.println("Farenheit: " + conversiones.getFarenheit());
           System.out.println("Kelvin: " + conversiones.getKelvin());
    }
    
}
