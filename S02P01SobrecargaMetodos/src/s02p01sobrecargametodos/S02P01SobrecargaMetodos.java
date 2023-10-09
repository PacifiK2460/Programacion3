/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s02p01sobrecargametodos;

/**
 *
 * @author 177685
 */
public class S02P01SobrecargaMetodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tacos taco1 = new Tacos("Carne", "Tortilla");
        Tacos taco2 = new Tacos("Carne", "Tortilla", "Salsa");
        Tacos taco3 = new Tacos("Carne", "Tortilla", "Salsa", "Cebolla");
        Tacos taco4 = new Tacos("Carne", "Tortilla", "Salsa", "Cebolla", new String[]{"Limón", "Sal", "Salsa"});

        System.out.println(taco1);
        System.out.println(taco2);
        System.out.println(taco3);
        System.out.println(taco4);
    }
    
}
