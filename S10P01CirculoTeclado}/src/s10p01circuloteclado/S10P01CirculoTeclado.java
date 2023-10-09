/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s10p01circuloteclado;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author 177685
 */
public class S10P01CirculoTeclado  extends JFrame implements KeyListener {

    private int x = 200, y = 200;
    private int ancho = 50, alto = 50;
    JPanel panel;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private void crearGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        Graphics papel = panel.getGraphics();
        papel.setColor(Color.WHITE);
        papel.fillReact(0,0,700,700);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
