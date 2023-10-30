/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package laboproyecto;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 177685
 */
public class Preguntas {

    // Keep track of number of asked questions
    private static int preguntas_respondidas = 0;
    
    private static int last_id = 99;

    private static ArrayList<Pregunta> preguntas = new ArrayList<>();

    public boolean addPregunta(String Pregunta, int index_respuesta_correcta, ArrayList<String> opciones) {
        Pregunta nueva = new Pregunta(Pregunta, opciones, index_respuesta_correcta);
        return preguntas.add(nueva);
    }

    public Pregunta getPregunta() {
        this.preguntas_respondidas++;
        return this.preguntas.get(ThreadLocalRandom.current().nextInt(0, preguntas.size() + 1));
    }

    public int getPreguntasRespondidas() {
        return this.preguntas_respondidas;
    }
}
