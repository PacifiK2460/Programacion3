/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s08p05operaciones;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author 177685
 */
public class S08P05Operaciones extends JFrame implements ActionListener {

    JLabel LabelNumero1, LabelNumero2, LabelResultado;
    JTextField TextNumero1, TextNumero2, TextResultado;
    JButton ButtonSumar, ButtonRestar, ButtonMultiplicar, ButtonDividir;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        S08P05Operaciones marco = new S08P05Operaciones();
        marco.setSize(225, 400);
        marco.setTitle("Operaciones Aritmeticas");
        marco.crearGUI();
        marco.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        double Numero1, Numero2;
        Numero1 = Double.parseDouble(TextNumero1.getText());
        Numero2 = Double.parseDouble(TextNumero2.getText());

        System.out.println(event.getSource().getClass());
        System.out.println(ButtonSumar.getClass());
        
        
    }

    public void crearGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(new FlowLayout());

        LabelNumero1 = new JLabel("Numero 1: ");
        ventana.add(LabelNumero1);

        TextNumero1 = new JTextField("Escribe el numero 1", 10);
        ventana.add(TextNumero1);

        LabelNumero2 = new JLabel("Numero 2: ");
        ventana.add(LabelNumero2);

        TextNumero2 = new JTextField("Escribe el numero 2", 10);
        ventana.add(TextNumero2);

        ButtonSumar = new JButton("Sumar");
        ButtonSumar.addActionListener(this);
        ventana.add(ButtonSumar);

        ButtonRestar = new JButton("Restar");
        ButtonRestar.addActionListener(this);
        ventana.add(ButtonRestar);

        ButtonDividir = new JButton("Dividir");
        ButtonDividir.addActionListener(this);
        ventana.add(ButtonDividir);

        ButtonMultiplicar = new JButton("Multiplicar");
        ButtonMultiplicar.addActionListener(this);
        ventana.add(ButtonMultiplicar);

        LabelResultado = new JLabel("Resultado: ");
        ventana.add(LabelResultado);

        TextResultado = new JTextField("Resultado", 10);
        ventana.add(TextResultado);
    }

}
