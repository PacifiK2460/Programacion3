/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.pkg2;

/**
 *
 * @author 177685
 */
public class Partido {

    private String EquipoLocal;
    private String EquipoVisitante;
    private int[][] Puntos;

    public Partido() {
        this.Puntos = new int[2][4];
    }

    public void setVisitante(String nombre) {
        this.EquipoVisitante = nombre;
    }

    public void setLocal(String nombre) {
        this.EquipoLocal = nombre;
    }

    public String getLocal() {
        return this.EquipoLocal;
    }

    public String getVisitante() {
        return this.EquipoVisitante;
    }

    public void setPuntos(int[] puntos, int Equipo) {
        this.Puntos[Equipo] = puntos;
    }
    
    public int[][] getPuntos(){
        return this.Puntos;
    }
}