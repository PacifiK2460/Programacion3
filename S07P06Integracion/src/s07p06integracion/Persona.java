/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s07p06integracion;

/**
 *
 * @author 177685
 */
public class Persona extends Chef implements Trabajar {
    public Persona(String nombre){
        super(nombre);
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando aca bien master chef");
    }

    @Override
    public void limpiar() {
        System.out.println("Limpiando aca bien limpio");
    }

    public void trabajar() {
        System.out.println("Trabajando aca bien chambeador");
    }

    public void quejarse() {
        System.out.println("Quejando aca bien quejoso");
    }

    public void cobrar() {
        System.out.println("Cobrando aca bien millionario");
    }
    
}
