package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Memorama extends JFrame implements ActionListener {

    private List<String> palabras;
    private List<JButton> botones;
    private JButton primerBoton;
    private int intentos;
    private int paresCorrectos;
    private JTextField textCorrectos;
    private JTextField textErrores;

    public Memorama() {
        setTitle("Memorama en Náhuatl");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(4, 4));
        this.setLocationRelativeTo(null);

        palabras = new ArrayList<>();
        palabras.add("Tonatiuh");
        palabras.add("Sol");
        palabras.add("Metztli");
        palabras.add("Luna");
        palabras.add("Citlalin");
        palabras.add("Estrella");
        palabras.add("Mixtli");
        palabras.add("Nube");
        palabras.add("Atlahua");
        palabras.add("Lluvia");
        palabras.add("Cuitlapilli");
        palabras.add("Arco iris");
        palabras.add("Cuauhtli");
        palabras.add("Árbol");
        palabras.add("Xochitl");
        palabras.add("Flor");
        palabras.add("Amoxtli");
        palabras.add("Hoja");
        palabras.add("Atl");
        palabras.add("Agua");
        palabras.add("Tletl");
        palabras.add("Fuego");
        palabras.add("Tlalli");
        palabras.add("Tierra");
        palabras.add("Tetl");
        palabras.add("Piedra");
        palabras.add("Apan");
        palabras.add("Río");
        palabras.add("Tepetl");
        palabras.add("Montaña");
        palabras.add("Cipactli");
        palabras.add("Mar");
        palabras.add("Pilli");
        palabras.add("Niño");
        palabras.add("Cihuatl");
        palabras.add("Mujer");
        palabras.add("Tlacaélel");
        palabras.add("Hombre");
        palabras.add("Calli");
        palabras.add("Casa");

        botones = new ArrayList<>();
        for (int i = 0; i < palabras.size(); i++) {
            JButton boton = new JButton();
            boton.addActionListener(this);
            botones.add(boton);
            add(boton);
        }

        textCorrectos = new JTextField();
        textCorrectos.setEditable(false);
        add(textCorrectos);

        textErrores = new JTextField();
        textErrores.setEditable(false);
        add(textErrores);

        iniciarJuego();
    }

    private void iniciarJuego() {
        Collections.shuffle(palabras);
        for (int i = 0; i < palabras.size(); i++) {
            botones.get(i).setText(palabras.get(i));
            botones.get(i).setEnabled(true);
        }

        primerBoton = null;
        intentos = 0;
        paresCorrectos = 0;
        textCorrectos.setText("Correctos: " + paresCorrectos);
        textErrores.setText("Incorrectos: " + intentos);
    }

    private void bloquearBotones() {
        for (JButton boton : botones) {
            boton.setEnabled(false);
        }
    }

    private void comprobarPares(JButton segundoBoton) {
        String palabra1 = primerBoton.getText();
        String palabra2 = segundoBoton.getText();

        if (palabra1.equals(palabra2)) {
            primerBoton.setBackground(Color.GREEN);
            segundoBoton.setBackground(Color.GREEN);
            paresCorrectos++;

            if (paresCorrectos == 6) {
                JOptionPane.showMessageDialog(this, "Has completado todos los pares.");
                //Lectura Ex = new Lectura();
                //Ex.setVisible(true);
                //this.setVisible(false);

                // Tu codigo con el que vas a terminar el juego
            }
        } else {
            primerBoton.setBackground(null);
            segundoBoton.setBackground(null);
            intentos++;

            if (intentos == 3) {
                bloquearBotones();
                int opcion = JOptionPane.showConfirmDialog(this, "Has alcanzado 3 errores. ¿Jugar de nuevo?", "Reiniciar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    iniciarJuego();
                } else {
                    return;
                }
            }
        }

        primerBoton = null;
        textCorrectos.setText("Correctos: " + paresCorrectos);
        textErrores.setText("Incorrectos: " + intentos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        if (primerBoton == null) {
            primerBoton = boton;
            boton.setEnabled(false);
        } else {
            boton.setEnabled(false);
            comprobarPares(boton);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Memorama memorama = new Memorama();
                memorama.setVisible(true);
            }
        });
    }
}
