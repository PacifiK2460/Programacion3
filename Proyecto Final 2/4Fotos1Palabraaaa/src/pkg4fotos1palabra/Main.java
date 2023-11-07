/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg4fotos1palabra;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Main extends JFrame {
    private JLabel imageLabel;
    private JTextField answerField;
    private JButton checkButton;
    private String[] palabras = {"texocotl", "conetl", "itzcuintli", "pitzahua"};
    private String[] imagenesPorPalabra = {
        "texocotl.jpg", "conetl.jpg", "itzcuintli.jpg", "pitzahua.jpg",
    };
    private int currentQuestion = 0;
    private int score = 0;
    private int attemptsRemaining = 5; // límite de intentos

    public Main() {
        setTitle("4 Fotos 1 Palabra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLayout(new FlowLayout());

        imageLabel = new JLabel();
        add(imageLabel);

        answerField = new JTextField(15);
        add(answerField);

        checkButton = new JButton("Comprobar");
        add(checkButton);

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userAnswer = answerField.getText().trim().toLowerCase();
                String correctAnswer = palabras[currentQuestion];

                if (userAnswer.equals(correctAnswer)) {
                    JOptionPane.showMessageDialog(null, "¡Correcto!");
                    score++;
                    if (currentQuestion < palabras.length - 1) {
                        currentQuestion++;
                        loadQuestion();
                    } else {
                        JOptionPane.showMessageDialog(null, "Juego terminado. Puntaje: " + score);
                        resetGame();
                    }
                } else {
                    attemptsRemaining--;

                    if (attemptsRemaining > 0) {
                        JOptionPane.showMessageDialog(null, "Respuesta incorrecta. Te quedan " + attemptsRemaining + " intentos.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Se te agotaron los intentos. La respuesta correcta era: " + correctAnswer);
                        if (currentQuestion < palabras.length - 1) {
                            currentQuestion++;
                            loadQuestion();
                        } else {
                            JOptionPane.showMessageDialog(null, "Juego terminado. Puntaje: " + score);
                            resetGame();
                        }
                    }
                }
            }
        });
       // Cambiamos la inicialización de currentQuestion a un valor aleatorio.
        Random random = new Random();
        currentQuestion = random.nextInt(palabras.length);

        // Llamamos a loadQuestion para cargar la primera palabra aleatoria.
        loadQuestion();  
        
        
    }

    private void loadQuestion() {
        String palabraActual = palabras[currentQuestion];
        String imagenPalabraActual = imagenesPorPalabra[currentQuestion];
        
        // Cargar y mostrar la imagen correspondiente a la palabra actual en la interfaz de usuario.
        ImageIcon imageIcon = createImageIcon(imagenPalabraActual);
        if (imageIcon != null) {
            imageLabel.setIcon(imageIcon);
        } else {
            imageLabel.setIcon(null); // Si no se encuentra la imagen, se muestra en blanco.
        }
        
        // Restablecer otros elementos de la interfaz, como el campo de texto de respuesta.
        answerField.setText("");
        attemptsRemaining = 5; // Reiniciar los intentos restantes
    }

    private ImageIcon createImageIcon(String imagePath) {
        // Cargar la imagen desde la carpeta "imagenes" en el directorio del proyecto.
        InputStream imageStream = getClass().getResourceAsStream("/imagenes/" + imagePath);
        if (imageStream != null) {
            try {
                return new ImageIcon(ImageIO.read(imageStream));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            // Si no se encuentra la imagen, devuelve null.
            return null;
        }
    }

    private void resetGame() {
        currentQuestion = 0;
        score = 0;
        loadQuestion();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main juego = new Main();
                juego.setVisible(true);
                juego.loadQuestion();
            }
        });
    }
}


