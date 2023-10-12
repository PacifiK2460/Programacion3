/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s10p04textarea;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.util.Collections;

/**
 *
 * @author 177685
 */
public class S10P04TextArea extends JFrame implements ActionListener {

    JButton boton;
    JTextArea text;

    ArrayList<String> Lista = new ArrayList();
    
    int rows = 5;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        S10P04TextArea marco = new S10P04TextArea();
        marco.setSize(500, 500);
        marco.setTitle("Text Area");
        marco.crearGUI();
        marco.setVisible(true);
    }

    private void crearGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(new FlowLayout());
        
        boton = new JButton("accion");
        boton.addActionListener(this);
        
        text = new JTextArea("", rows, 1);
        
        ventana.add(boton);
        ventana.add(text);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for(int i = 0; i < rows; i++){
            Object input = JOptionPane.showInputDialog("Mensaje");
            Lista.add(input.toString() + "\n");
        }
        
        Collections.sort(Lista);
        
        for(int i = 0; i  < rows; i++){
            text.append(this. Lista.get(i).toString());
        }

    }

}
