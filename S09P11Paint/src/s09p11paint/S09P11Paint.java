/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s09p11paint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author 177685
 */
public class S09P11Paint extends JFrame implements ActionListener {

    JPanel panel;
    JRadioButton bttnBlanco, bttnNegro, bttnRojo, bttnVerde, bttnAzul, btnReset;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        S09P11Paint marco = new S09P11Paint();
        marco.setSize(500, 500);
        marco.setTitle("Paint");
        marco.crearGUI();
        marco.setVisible(true);
    }

    private void crearGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBackground(Color.WHITE);
        ventana.add(panel);

        bttnBlanco = new JRadioButton("Blanco", false);
        bttnBlanco.addActionListener(this);

        bttnNegro = new JRadioButton("Negro", false);
        bttnNegro.addActionListener(this);

        bttnRojo = new JRadioButton("Rojo", false);
        bttnRojo.addActionListener(this);

        bttnVerde = new JRadioButton("Verde", false);
        bttnVerde.addActionListener(this);

        bttnAzul = new JRadioButton("Azul", false);
        bttnAzul.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
