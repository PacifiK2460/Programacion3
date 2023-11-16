/*
 *  Universidad Politecnica de San Luis Potosi
 *  Programacion III java
 *  Programacion Orientada a Objetos
 */
package proyecto;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class Preguntas2 extends javax.swing.JFrame {

    String[] preguntas = {"¿Cuál es la traducción de la palabra \"atl\" en náhuatl?",
         "¿Qué representa la palabra \"tecpatl\" en náhuatl?",
         "¿Cuál es el significado de la palabra \"quetzalli\" en náhuatl?"};
    //el último elemento es la respuesta correcta
    //comprobaremos la respuesta seleccionada del usuario con el último elemento
    String[][] respuesta = {{"Agua", "Fuego", "Viento", "Montaña"},
     {"Cuchillo", "Flor", "Guerrero", "Pájaro"},
     {"Serpiente emplumada", "Joya o piedra preciosa", "Templo sagrado", "Guerrero valiente"}};
    int index = 0;
    int correct = 0;

    ButtonGroup bg = new ButtonGroup();

    public Preguntas2() {
        initComponents();
        this.setLocationRelativeTo(this);
        bg.add(txtRespuesta1);
        bg.add(txtRespuesta2);
        bg.add(txtRespuesta3);
        bg.add(txtRespuesta4);

        //this.setLocationRelativeTo(this);
        btnBotonOpcionesActionPerformed(null);
    }

    public void getSelectedOPtion(JRadioButton rbtn) {
        //obtener el valor seleccionado de la radioButton
        System.out.println(rbtn.getText());
        System.out.println(respuesta[index][2]);
        //Compruebe si el usuario seleccionó la respuesta correcta.
        if (rbtn.getText().equals(respuesta[index][2])) {
            correct++;
        }

        //incrementar el índice
        index++;

        //deshabilitar el radioButtons
        enableRbuttons(false);
    }

    // enable/ disable radioButton
    public void enableRbuttons(boolean yes_or_no) {
        //se encarga de habilitar e inabilitarlos accesos derectos en el teclado 
        txtRespuesta1.setEnabled(yes_or_no);
        txtRespuesta2.setEnabled(yes_or_no);
        txtRespuesta3.setEnabled(yes_or_no);
        txtRespuesta4.setEnabled(yes_or_no);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPane1 = new javax.swing.JPanel();
        btnBotonOpciones = new javax.swing.JButton();
        txtRespuesta1 = new javax.swing.JRadioButton();
        txtRespuesta2 = new javax.swing.JRadioButton();
        txtRespuesta3 = new javax.swing.JRadioButton();
        txtRespuesta4 = new javax.swing.JRadioButton();
        PanelPregunta = new javax.swing.JPanel();
        txtPregunta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPane1.setBackground(new java.awt.Color(153, 255, 204));

        btnBotonOpciones.setBackground(new java.awt.Color(204, 255, 204));
        btnBotonOpciones.setFont(new java.awt.Font("Chalkduster", 0, 14)); // NOI18N
        btnBotonOpciones.setText("Next");
        btnBotonOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBotonOpcionesActionPerformed(evt);
            }
        });

        txtRespuesta1.setFont(new java.awt.Font("Chalkduster", 0, 14)); // NOI18N
        txtRespuesta1.setForeground(new java.awt.Color(0, 153, 153));
        txtRespuesta1.setText("jRadioButton1");
        txtRespuesta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuesta1ActionPerformed(evt);
            }
        });

        txtRespuesta2.setFont(new java.awt.Font("Chalkduster", 0, 14)); // NOI18N
        txtRespuesta2.setForeground(new java.awt.Color(0, 153, 153));
        txtRespuesta2.setText("jRadioButton2");
        txtRespuesta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuesta2ActionPerformed(evt);
            }
        });

        txtRespuesta3.setFont(new java.awt.Font("Chalkduster", 0, 14)); // NOI18N
        txtRespuesta3.setForeground(new java.awt.Color(0, 153, 153));
        txtRespuesta3.setText("jRadioButton3");
        txtRespuesta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuesta3ActionPerformed(evt);
            }
        });

        txtRespuesta4.setFont(new java.awt.Font("Chalkduster", 0, 14)); // NOI18N
        txtRespuesta4.setForeground(new java.awt.Color(0, 153, 153));
        txtRespuesta4.setText("jRadioButton4");
        txtRespuesta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuesta4ActionPerformed(evt);
            }
        });

        PanelPregunta.setBackground(new java.awt.Color(255, 255, 255));

        txtPregunta.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout PanelPreguntaLayout = new javax.swing.GroupLayout(PanelPregunta);
        PanelPregunta.setLayout(PanelPreguntaLayout);
        PanelPreguntaLayout.setHorizontalGroup(
            PanelPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPreguntaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPreguntaLayout.setVerticalGroup(
            PanelPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPreguntaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPane1Layout = new javax.swing.GroupLayout(jPane1);
        jPane1.setLayout(jPane1Layout);
        jPane1Layout.setHorizontalGroup(
            jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtRespuesta2, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                        .addComponent(txtRespuesta1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                        .addComponent(PanelPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtRespuesta3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRespuesta4, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBotonOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        jPane1Layout.setVerticalGroup(
            jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtRespuesta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRespuesta2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRespuesta3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRespuesta4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBotonOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBotonOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotonOpcionesActionPerformed
        if (btnBotonOpciones.getText().equals("Regresar")) {
            // Terminar el cuestionario
            //cierra 
            this.setVisible(false);
        }

        if (index == preguntas.length) {
            // muestra los puntos
            txtPregunta.setText("Puntos optenidos: " + correct + " / " + preguntas.length);
            btnBotonOpciones.setText("Regresar");
        } else {
            enableRbuttons(true);
            // sig pregunta
            txtPregunta.setText(preguntas[index]);
            txtRespuesta1.setText(respuesta[index][0]);
            txtRespuesta2.setText(respuesta[index][1]);
            txtRespuesta3.setText(respuesta[index][2]);
            txtRespuesta4.setText(respuesta[index][3]);

            if (index == preguntas.length - 1) {
                btnBotonOpciones.setText("Mostrar puntaje");
            }
        }
        // Limpiaa la seleccion
        bg.clearSelection();
    }//GEN-LAST:event_btnBotonOpcionesActionPerformed

    private void txtRespuesta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespuesta1ActionPerformed
        getSelectedOPtion(txtRespuesta1);
    }//GEN-LAST:event_txtRespuesta1ActionPerformed

    private void txtRespuesta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespuesta2ActionPerformed
        getSelectedOPtion(txtRespuesta2);
    }//GEN-LAST:event_txtRespuesta2ActionPerformed

    private void txtRespuesta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespuesta3ActionPerformed
        getSelectedOPtion(txtRespuesta3);
    }//GEN-LAST:event_txtRespuesta3ActionPerformed

    private void txtRespuesta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespuesta4ActionPerformed
        getSelectedOPtion(txtRespuesta4);
    }//GEN-LAST:event_txtRespuesta4ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(()
                -> {
            new Preguntas2().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPregunta;
    private javax.swing.JButton btnBotonOpciones;
    private javax.swing.JPanel jPane1;
    private javax.swing.JLabel txtPregunta;
    private javax.swing.JRadioButton txtRespuesta1;
    private javax.swing.JRadioButton txtRespuesta2;
    private javax.swing.JRadioButton txtRespuesta3;
    private javax.swing.JRadioButton txtRespuesta4;
    // End of variables declaration//GEN-END:variables
}
