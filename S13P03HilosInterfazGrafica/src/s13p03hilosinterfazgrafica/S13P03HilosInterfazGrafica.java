/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s13p03hilosinterfazgrafica;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * Programe: Una interfaz grafica con: - Un panel de 100x100 - Un boton "Iniciar
 * 1" - Un boton "Detener 1"
 *
 * - Un panel de 100x100 - Un boton "Iniciar 2" - Un boton "Detener 2"
 *
 * @author 177685
 */
public class S13P03HilosInterfazGrafica extends JFrame {

    JPanel panel1 = new JPanel();
    JButton iniciar1 = new JButton("Iniciar 1");
    JButton parar1 = new JButton("Detener 1");

    JPanel panel2 = new JPanel();
    JButton iniciar2 = new JButton("Iniciar 2");
    JButton parar2 = new JButton("Detener 2");

    PelotaHilo hilo1;
    PelotaHilo hilo2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        S13P03HilosInterfazGrafica ventana = new S13P03HilosInterfazGrafica();
        ventana.setSize(200, 400);
        ventana.setTitle("Ventana");
        ventana.crearGUI();
        ventana.setVisible(true);

    }

    private void crearGUI() {
        parar1.setEnabled(false);
        parar2.setEnabled(false);

        iniciar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!hilo1.isAlive()) {
                    hilo1.start();
                    iniciar1.setEnabled(false);
                    parar1.setEnabled(true);

                }
            }
        });
        iniciar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!hilo2.isAlive()) {
                    hilo2.start();
                    iniciar2.setEnabled(false);
                    parar2.setEnabled(true);

                }
            }
        });
        parar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hilo1.isAlive()) {
                    hilo1.detener();
                    hilo1 = new PelotaHilo(panel1);
                    iniciar1.setEnabled(true);
                    parar1.setEnabled(false);

                }
            }
        });
        parar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hilo2.isAlive()) {
                    hilo2.detener();
                    hilo2 = new PelotaHilo(panel2);
                    iniciar2.setEnabled(true);
                    parar2.setEnabled(false);

                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(new FlowLayout());

        panel1.setPreferredSize(new Dimension(100, 100));
        panel1.setBackground(Color.WHITE);

        panel2.setPreferredSize(new Dimension(100, 100));
        panel2.setBackground(Color.WHITE);

        ventana.add(panel1);
        ventana.add(iniciar1);
        ventana.add(parar1);
        ventana.add(panel2);
        ventana.add(iniciar2);
        ventana.add(parar2);

        hilo1 = new PelotaHilo(panel1);
        hilo2 = new PelotaHilo(panel2);
    }

}
