/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s03p03estructurasbasicas;

/**
 *
 * @author 177685
 */
public class S03P03EstructurasBasicas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", 10);
        Persona persona2 = new Persona("Pedro", 20);
        Persona persona3 = new Persona("Maria", 30);
        Persona persona4 = new Persona("Jose", 40);
        Persona persona5 = new Persona("Luis", 50);

        System.out.println(persona1.toString());
        System.out.println(persona2.toString());
        System.out.println(persona3.toString());
        System.out.println(persona4.toString());
        System.out.println(persona5.toString());

        Numero.imprimirNonesHasta(50);

    }
    
}
