/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s10p05polimorfismoconherencia;

/**
 *
 * @author 177685
 */
public class S10P05PolimorfismoConHerencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Abuelo a = new Abuelo();
        a.cocinar();
        System.out.println("---");

        Padre p = new Padre();
        p.cocinar();
        p.redesSociales();
        System.out.println("---");

        Hijo h = new Hijo();
        h.cocinar();
        h.redesSociales();
        h.programar();
        System.out.println("---");

        a = new Padre();
        a.cocinar();
        System.out.println("---");

        a = new Hijo();
        a.cocinar();
        System.out.println("---");

        // Con el objeto del Padre, haga que actue cono hijo ejecute los metodos sobrescritos
        p = new Hijo();
        p.cocinar();
        p.redesSociales();
        System.out.println("---");
     }

}
