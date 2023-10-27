/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboproyecto;

import java.util.ArrayList;

/**
 *
 * @author 177685
 */
public class Pregunta {

    private String pregunta;
    private ArrayList<String> opciones;
    private int index_respuesta_correcta;

    public Pregunta(String pregunta, ArrayList<String> opciones, int index_respuesta_correcta) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.index_respuesta_correcta = index_respuesta_correcta;
    }

    public String getPregunta() {
        return this.pregunta;
    }

    public ArrayList<String> getOpciones() {
        return this.opciones;
    }

    public int getIndexRespuestaCorrecta() {
        return this.index_respuesta_correcta;
    }
}
