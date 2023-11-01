/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s13p03hilosinterfazgrafica;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author 177685
 */
public class PelotaHilo extends Thread {

    private JPanel panel;
    private boolean seguirRebotando;
    private int x = 7, cambioX = 2;
    private int y = 2, cambioY = 7;
    private int diametro = 10;
    private final int ancho = 100, alto = 100;

    public PelotaHilo(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void run() {
        seguirRebotando = true;
        while (seguirRebotando) {
            mover();
            rebotar();
            dibujar();
            retrasar();
            eliminar();
        }
    }

    private void mover() {
        x += cambioX;
        y += cambioY;
    }

    private void rebotar() {
        if (x <= 0 || x >= ancho) {
            cambioX *= -1;
        }

        if (y <= 0 || y >= alto) {
            cambioY *= -1;
        }
    }

    private void dibujar() {
        Graphics papel = panel.getGraphics();
        papel.setColor(Color.RED);
        papel.fillOval(x, y, diametro, diametro);
    }

    private void retrasar() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            System.err.println("Error: " + ex);
        }
    }

    private void eliminar() {
        Graphics papel = panel.getGraphics();
        papel.setColor(Color.WHITE);
        papel.fillOval(x, y, diametro, diametro);
    }
    
    public void detener(){
        seguirRebotando = false;
    }
}
