/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2.pkg1;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.Paper;
import javax.swing.*;

/**
 *
 * @author 177685
 */
public class Examen21 extends JFrame implements ActionListener {

    JLabel Materia1 = new JLabel("Materia 1"), Promedio1 = new JLabel("Promedio 1"), Materia2 = new JLabel("Materia 2"), Promedio2 = new JLabel("Promedio 2");
    JButton Calcular1 = new JButton("Calcular 1"), Calcular2 = new JButton("Calcular 2"), graficar = new JButton("Graficar");
    JTextField textField1 = new JTextField("10", 10), textField2 = new JTextField("10", 10);
    JPanel panel = new JPanel(new FlowLayout());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Examen21 marco = new Examen21();
        marco.setSize(100, 200);
        marco.setTitle("Examen 2.1");
        marco.crearGUI();
        marco.setVisible(true);
    }

    private void crearGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(new FlowLayout());

        panel.setPreferredSize(new Dimension(300, 250));
        panel.setBackground(Color.WHITE);

        Calcular1.addActionListener(this);
        Calcular2.addActionListener(this);
        graficar.addActionListener(this);

        ventana.add(Materia1);
        ventana.add(Calcular1);
        ventana.add(Promedio1);
        ventana.add(textField1);

        ventana.add(Materia2);
        ventana.add(Calcular2);
        ventana.add(Promedio2);
        ventana.add(textField2);

        ventana.add(graficar);
        ventana.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Calcular1) {
            double promedio = 0;
            for (int i = 0; i < 3; i++) {
                promedio += Double.parseDouble(JOptionPane.showInputDialog("Calificación " + (i + 1)));
            }
            promedio /= 3;
            textField1.setText(Double.toString(promedio));
        } else if (ae.getSource() == Calcular2) {
            double promedio = 0;
            for (int i = 0; i < 3; i++) {
                promedio += Double.parseDouble(JOptionPane.showInputDialog("Calificación " + (i + 1)));
            }
            promedio /= 3;
            textField2.setText(Double.toString(promedio));
        } else if (ae.getSource() == graficar) {
            System.out.println();

            Graphics papel = panel.getGraphics();
            papel.setColor(Color.WHITE);
            papel.fillRect(0, 0, 300, 300);

            papel.setColor(Color.BLUE);
            papel.fillRect(10, 10, Integer.parseInt(textField1.getText()) * 20, 50);

            papel.setColor(Color.RED);
            papel.fillRect(10, 100, Integer.parseInt(textField2.getText()) * 20, 50);

        }
    }

}
