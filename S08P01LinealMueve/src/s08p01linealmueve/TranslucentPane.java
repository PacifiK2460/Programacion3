/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s08p01linealmueve;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author 177685
 */
public class TranslucentPane extends JPanel {

    public TranslucentPane() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphicshics g) {
        super.paintComponent(g);
        Color color = getBackground();
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 32);
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
