/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s12p03excepcionespropiasgraficas;

/**
 *
 * @author 177685
 */
public class Estudiante {

    private String matricula;
    private double[] calificaciones;

    public Estudiante(String matricula, double calificacion1, double calificacion2, double calificacion3) throws Exception {
        if (matricula.length() != 6) {
            throw new Exception("Matricula invalida.");
        }

        if (calificacion1 < 0 || calificacion1 > 10 || calificacion2 < 0 || calificacion2 > 10 || calificacion3 < 0 || calificacion3 > 10) {
            throw new Exception("Calificación(es) invalida(s).");
        }

        this.matricula = matricula;
        this.calificaciones = new double[3];
        calificaciones = [calificacion1 , calificacion2, calificacion3];
    }
}
