/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s03p01string;

// Example file for String methods

/**
 *
 * @author 177685
 */
public class S03P01String {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "Hello World";
        
        System.out.println("Cadena: " + str);
        System.out.println("Largo:" + str.length());
        System.out.println("Caracter No 3:" + str.charAt(2));

        String str2 = "hello world";
        System.out.println("Cadena 2: " + str2);
        System.out.println("Comparacion con Case: " + str.equals(str2));
        System.out.println("Comparacion sin Case: " + str.equalsIgnoreCase(str2));
        System.out.println("Cadena a Bytes: " + str.getBytes());
        System.out.println("Hash de la cadena: " + str.hashCode());
        System.out.println("Index de la subcadena World: " + str.indexOf("World"));
        System.out.println("Cadenas juntadas: " + str.concat(str2));
        System.out.println("Cadena en minusculas: " + str.toLowerCase());
        System.out.println("Cadena en mayusculas: " + str.toUpperCase());
        System.out.println("Cadena sin espacios: " + str.trim());
        System.out.println("Cadena reemplazada: " + str.replace("World", "Mundo"));
        System.out.println("Cadena dividida: " + str.split(" "));        
    }
    
}
