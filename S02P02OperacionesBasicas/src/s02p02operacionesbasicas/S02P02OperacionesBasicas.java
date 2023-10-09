/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s02p02operacionesbasicas;

/**
 *
 * @author 177685
 */
public class S02P02OperacionesBasicas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Orden orden = new Orden();
        Comida comida = new Comida("Pizza", 100);
        orden.AgregarComida(comida);
        orden.AgregarComida(comida);
        orden.AgregarComida(comida);
        orden.AgregarComida(comida);

        System.out.println("Orden: ");
        for (int i = 0; i < orden.Comida.length; i++) {
            System.out.println(orden.Comida[i].Nombre + " " + orden.Comida[i].Precio);
        }

        orden.RestarUltimo();
        System.out.println("Orden: ");
        for (int i = 0; i < orden.Comida.length; i++) {
            System.out.println(orden.Comida[i].Nombre + " " + orden.Comida[i].Precio);
        }

        orden.MultiplicarComida(2);
        System.out.println("Orden: ");
        for (int i = 0; i < orden.Comida.length; i++) {
            System.out.println(orden.Comida[i].Nombre + " " + orden.Comida[i].Precio);
        }

        Orden[] ordenes = orden.DividirComida(2, orden.Comida);
        System.out.println("Ordenes: ");
        for (int i = 0; i < ordenes.length; i++) {
            System.out.println("Orden " + i + ": ");
            for (int j = 0; j < ordenes[i].Comida.length; j++) {
                System.out.println(ordenes[i].Comida[j].Nombre + " " + ordenes[i].Comida[j].Precio);
            }
        }

        
    }
    
}
