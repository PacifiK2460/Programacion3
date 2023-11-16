/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juegos;

import Usuarios.Usuario;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author chago
 */
public class Puntajes {

    public ArrayList<Puntaje> PuntajeDeSopaDeLetras = new ArrayList<>();
    public ArrayList<Puntaje> PuntajeDeTrivia = new ArrayList<>();
    public ArrayList<Puntaje> PuntajeDeTablero = new ArrayList<>();
    public ArrayList<Puntaje> PuntajeDe4P1F = new ArrayList<>();
    public ArrayList<Puntaje> PuntajeDeTraduccion = new ArrayList<>();
    public ArrayList<Puntaje> PuntajeDeMemorama = new ArrayList<>();

    public Puntaje[] getPuntajeDeSopaDeLetras() {
        return (Puntaje[]) this.PuntajeDe4P1F.toArray();
    }

    public void addSopaDeLetras(Puntaje p) {
        PuntajeDeSopaDeLetras.add(p);
    }

    public Optional<Puntaje> getMaxSopaDeLetras() {
        return PuntajeDeSopaDeLetras.stream().max(Comparator.comparing(Puntaje::getPuntaje));
    }

    public Puntaje[] getPuntajeDeTrivia() {
        return (Puntaje[]) this.PuntajeDeTrivia.toArray();
    }

    public void addTrivia(Puntaje p) {
        PuntajeDeTrivia.add(p);
    }

    public Optional<Puntaje> getMaxTrivia() {
        return PuntajeDeTrivia.stream().max(Comparator.comparing(Puntaje::getPuntaje));
    }

    public Puntaje[] getPuntajeDeTablero() {
        return (Puntaje[]) this.PuntajeDeTablero.toArray();
    }

    public void addTablero(Puntaje p) {
        PuntajeDeTrivia.add(p);
    }

    public Optional<Puntaje> getMaxTablero() {
        return PuntajeDeTablero.stream().max(Comparator.comparing(Puntaje::getPuntaje));
    }

    public Puntaje[] getPuntajeDe4F1P() {
        return (Puntaje[]) this.PuntajeDe4P1F.toArray();
    }

    public void add4F1P(Puntaje p) {
        PuntajeDe4P1F.add(p);
    }

    public Optional<Puntaje> getMax4F1P() {
        return PuntajeDe4P1F.stream().max(Comparator.comparing(Puntaje::getPuntaje));
    }

    public Puntaje[] getPuntajeDeTraduccion() {
        return (Puntaje[]) this.PuntajeDeTraduccion.toArray();
    }

    public void addTraduccion(Puntaje p) {
        PuntajeDeTraduccion.add(p);
    }

    public Optional<Puntaje> getMaxTraduccion() {
        return PuntajeDeTraduccion.stream().max(Comparator.comparing(Puntaje::getPuntaje));
    }

    public Puntaje[] getPuntajeDeMemorama() {
        return (Puntaje[]) this.PuntajeDeMemorama.toArray();
    }

    public void addMemorama(Puntaje p) {
        PuntajeDeMemorama.add(p);
    }

    public Optional<Puntaje> getMaxMemorama() {
        return PuntajeDeMemorama.stream().max(Comparator.comparing(Puntaje::getPuntaje));
    }

}
