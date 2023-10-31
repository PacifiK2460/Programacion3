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
    private int y = 2, cambioy = 7;
    private int diametro = 10;
    private final int ancho = 100, alto = 100;
    
    public PelotaHilo(){
        
    }
}
