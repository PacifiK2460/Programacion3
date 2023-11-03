/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectolabo;

/**
 *
 * @author 177685
 */
public class Pregunta {
    String titulo;
    String[] opciones;
    int opcion_correcta;
    
    public Pregunta(String titulo, String[] opciones, int opcion_correcta){
        this.titulo = titulo;
        this.opciones = opciones;
        this.opcion_correcta = opcion_correcta;
    }
    
}
