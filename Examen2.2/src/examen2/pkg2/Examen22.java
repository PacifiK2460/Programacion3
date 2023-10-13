/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2.pkg2;

/**
 * Crea una clase "Auto" que tenga las variables de instancia "modelo" y
 * "precio", además del método abstracto "acelerar" y un método concreto que
 * imprima un mensaje de bienvenida.
 *
 * Programe una interfaz que se llame "Transporte" con mètodos "abordar" y
 * "descender".
 *
 * Crea una clase llamada "Deportivo" que herede de "Auto" y programe
 * "Transporte" , además sobre escriba el método saludo. Programe también un
 * método "rendimiento" para que reciba la cantidad de kilometros recorridos y
 * los litros de gasolina, para que le indique al usuario su consumo de gasolina
 * en km / l .
 *
 * Finalmente, cree un objeto de la clase y pruebe todos los métodos. (40%)
 *
 * --------
 *
 * RECUERDE que este contenedor es el único medio de entrega de este examen y se
 * cerrará al minuto 53 de la hora.
 *
 * @author 177685
 */
public class Examen22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Deportivo auto = new Deportivo("Audi", 1000000);
        auto.bienvenida();
        auto.acelerar();
        auto.rendimiento(500, 25);
        auto.acelerar();
        auto.abordar();
        auto.descender();
    }

}
