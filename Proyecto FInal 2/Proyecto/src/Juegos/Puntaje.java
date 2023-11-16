/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juegos;

/**
 *
 * @author chago
 */
public class Puntaje {
    private final int idJugador;
    private int puntaje;
    
    public Puntaje(int id, int puntaje){
        this.idJugador = id;
        this.puntaje = puntaje;
    }
    
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    
    public int getPuntaje(){
        return this.puntaje;
    }
    
    public int getId(){
        return this.idJugador;
    }
}
