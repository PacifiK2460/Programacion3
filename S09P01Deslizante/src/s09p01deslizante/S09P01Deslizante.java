/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s09p01deslizante;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author 177685
 */
public class S09P01Deslizante extends JFrame implements ChangeListener {

    JLabel label, label2;
    JTextField tf, tf2, tf3;
    JPanel panel, panel2;
    JSlider deslizante, deslizante2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        S09P01Deslizante marco = new S09P01Deslizante();
        marco.setSize(800, 600);
        marco.setTitle("Deslizante");
        marco.crearGUI();
        marco.setVisible(true);
    }

    private void crearGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container ventana = getContentPane();
        ventana.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 300));
        panel.setBackground(Color.WHITE);
        ventana.add(panel);

        label = new JLabel("Valor: ");
        ventana.add(label);

        tf = new JTextField(7);
        ventana.add(tf);

        deslizante = new JSlider(JSlider.HORIZONTAL, 10, 250, 120);
        ventana.add(deslizante);
        deslizante.addChangeListener(this);

        tf.setText(Integer.toString(deslizante.getValue()));

        panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(300, 300));
        panel2.setBackground(Color.WHITE);
        ventana.add(panel2);

        label2 = new JLabel("Valor 2: ");
        ventana.add(label2);

        tf2 = new JTextField(7);
        ventana.add(tf2);

        deslizante2 = new JSlider(JSlider.HORIZONTAL, 10, 250, 120);
        ventana.add(deslizante2);
        deslizante2.addChangeListener(this);

        tf2.setText(Integer.toString(deslizante2.getValue()));

        tf3 = new JTextField(7);
        ventana.add(tf3);
    }

    @Override
    public void stateChanged(ChangeEvent event) {
        tf.setText(Integer.toString(deslizante.getValue()));
        int n = deslizante.getValue();

        Graphics papel = panel.getGraphics();
        papel.setColor(Color.WHITE);
        papel.fillRect(0, 0, 300, 300);
        papel.setColor(Color.BLUE);
        papel.fillOval(5, 5, n, n);

        tf2.setText(Integer.toString(deslizante2.getValue()));
        int n2 = deslizante2.getValue();
        Graphics papel2 = panel2.getGraphics();
        papel2.setColor(Color.WHITE);
        papel2.fillRect(0, 0, 300, 300);
        papel2.setColor(Color.RED);
        papel2.fillOval(5, 5, n2, n2);

        if (n > n2) {
            tf3.setText("El azul es mayor");
        } else {
            tf3.setText("El rojo es mayor");
        }

        if (n == n2) {
            tf3.setText("Son iguales");
        }

    }
}
