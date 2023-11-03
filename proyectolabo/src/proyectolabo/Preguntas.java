/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectolabo;

import java.util.ArrayList;

/**
 *
 * @author 177685
 */
public class Preguntas {

    ArrayList<Pregunta> preguntas = new ArrayList<>();

    public void agregarPregunta(String titulo, String[] opciones, int opcion_correcta) {
        Pregunta nueva_pregunta = new Pregunta(titulo, opciones, opcion_correcta);
        preguntas.add(nueva_pregunta);
    }

    public void setPreguntas() {
        agregarPregunta("¿Cuál es la capital de Francia?", new String[]{"Madrid", "Roma", "París", "Berlín"}, 2);
        agregarPregunta("¿Quién escribió 'Cien años de soledad'?", new String[]{"Gabriel García Márquez", "Mario Vargas Llosa", "Julio Cortázar", "Carlos Fuentes"}, 0);
        agregarPregunta("¿Cuál es el río más largo del mundo?", new String[]{"Nilo", "Amazonas", "Yangtsé", "Misisipi"}, 1);
        agregarPregunta("¿Cuál es el planeta más grande del sistema solar?", new String[]{"Tierra", "Marte", "Júpiter", "Venus"}, 2);
        agregarPregunta("¿Quién pintó la Mona Lisa?", new String[]{"Vincent Van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"}, 2);
        agregarPregunta("¿Cuál es el elemento químico con el símbolo 'O'?", new String[]{"Oro", "Osmio", "Oxígeno", "Olitio"}, 2);
        agregarPregunta("¿Cuál es la montaña más alta del mundo?", new String[]{"K2", "Everest", "Kilimanjaro", "Aconcagua"}, 1);
        agregarPregunta("¿Quién es el autor de la Teoría de la Relatividad?", new String[]{"Isaac Newton", "Nikola Tesla", "Albert Einstein", "Marie Curie"}, 2);
        agregarPregunta("¿Cuál es el océano más grande del mundo?", new String[]{"Atlántico", "Índico", "Ártico", "Pacífico"}, 3);
        agregarPregunta("¿Cuál es el país con la población más grande del mundo?", new String[]{"India", "China", "Estados Unidos", "Indonesia"}, 1);
        agregarPregunta("¿Cuál es el idioma más hablado en el mundo?", new String[]{"Inglés", "Mandarín", "Español", "Hindi"}, 1);
        agregarPregunta("¿Cuál es el animal terrestre más rápido del mundo?", new String[]{"Leopardo", "Guepardo", "León", "Tigre"}, 1);
        agregarPregunta("¿Cuál es el continente más grande del mundo?", new String[]{"África", "América", "Europa", "Asia"}, 3);
        agregarPregunta("¿Quién es el autor de 'Don Quijote de la Mancha'?", new String[]{"Miguel de Cervantes", "Lope de Vega", "Federico García Lorca", "Jorge Luis Borges"}, 0);
        agregarPregunta("¿Cuál es el país con más países fronterizos?", new String[]{"China", "Rusia", "Estados Unidos", "Brasil"}, 1);
        agregarPregunta("¿Cuál es el planeta más cercano al sol?", new String[]{"Venus", "Mercurio", "Marte", "Tierra"}, 1);
        agregarPregunta("¿Cuál es el libro sagrado del Islam?", new String[]{"Biblia", "Torá", "Vedas", "Corán"}, 3);
        agregarPregunta("¿Cuál es el país más pequeño del mundo?", new String[]{"Mónaco", "Maldivas", "San Marino", "Ciudad del Vaticano"}, 3);
        agregarPregunta("¿Cuál es el órgano más grande del cuerpo humano?", new String[]{"Corazón", "Estómago", "Hígado", "Piel"}, 3);
        agregarPregunta("¿Cuál es el país con más idiomas hablados?", new String[]{"India", "China", "Papúa Nueva Guinea", "Indonesia"}, 2);
    }

    public Pregunta get(int i){
        return preguntas.get(i);
    }
    
    public int size(){
        return preguntas.size();
    }
    
}
