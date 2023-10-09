/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s03p02encapsulacion;

/**
 *
 * @author 177685
 */
public class S03P02Encapsulacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matraca matraca = new Matraca("Nissan", "Sentra", 200000);
        System.out.println(matraca.getMarca());
        System.out.println(matraca.getModelo());
        System.out.println(matraca.getPrecio());
        matraca.setMarca("Ford");
        matraca.setModelo("Fiesta");
        matraca.setPrecio(150000);
        System.out.println(matraca.getMarca());
        System.out.println(matraca.getModelo());
        System.out.println(matraca.getPrecio());
        matraca.setModelo("F");
        matraca.setPrecio(-100);
        System.out.println(matraca.getMarca());
        System.out.println(matraca.getModelo());
        System.out.println(matraca.getPrecio());
    }
    
}
