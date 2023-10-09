/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s09p03radioboton;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author 177685
 */
public class S09P03RadioBoton extends JFrame implements ActionListener {

    JPanel panel;
    JRadioButton btnLinea, btnCirculo, btnRectangulo;

    /**
     * @param args the command line arguments
     */
    public static void main() {
        // TODO code application logic here
        S09P03RadioBoton marco = new S09P03RadioBoton();
        marco.setSize(370, 400);
        marco.setTitle("Radio Boton");
        marco.crearGUI();
        marco.setVisible(true);
    }

    private void crearGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container ventana = getContentPane();
        ventana.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 250));
        panel.setBackground(Color.WHITE);
        ventana.add(panel);

        btnLinea = new JRadioButton("Linea", false);
        ventana.add(btnLinea);
        btnLinea.addActionListener(this);

        btnCirculo = new JRadioButton("Circulo", false);
        ventana.add(btnCirculo);
        btnCirculo.addActionListener(this);

        btnRectangulo = new JRadioButton("Rectangulo", false);
        ventana.add(btnRectangulo);
        btnRectangulo.addActionListener(this);
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(btnCirculo);
        grupo.add(btnLinea);
        grupo.add(btnRectangulo);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        Graphics papel = panel.getGraphics();
        papel.setColor(Color.WHITE);
        papel.fillRect(0,0,300,300);
        
        papel.setColor(Color.RED);
        
        if(btnLinea.isSelected()){
            papel.drawLine(50, 50, 250, 250);
        }
        
        if(btnCirculo.isSelected()){
            papel.fillOval(70, 70, 150, 150);
        }
        
        if(btnRectangulo.isSelected()){
            papel.fillRect(70, 70, 150, 150);
        }
    }

}
