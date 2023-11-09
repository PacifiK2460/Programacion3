/*
 *  Universidad Politecnica de San Luis Potosi
 *  Programacion III java
 *  Programacion Orientada a Objetos
 */
package proyectovideojuego;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class Preguntas3 extends javax.swing.JFrame 
{
    private final Jugador jugador;
    String[] preguntas = {"Qué representa la palabra \"tlahtolli\" en náhuatl?"
            ,"¿Cuál es la traducción de la palabra \"tonalli\" en náhuatl?"
            ,"¿Qué significa la palabra \"chalchihuitl\" en náhuatl?"};
    //el último elemento es la respuesta correcta
    //comprobaremos la respuesta seleccionada del usuario con el último elemento
    String[][] respuestas = {{"Guerrero","Sol","Agua","Lengua o palabra"}
            ,{"Sol","Mar","Luna","Montaña"}
            ,{"Serpiente emplumada","Joya de jade"," Guerrero valiente","Dios del maíz"}};
    int index = 0;
    int correct = 0;

    ButtonGroup bg = new ButtonGroup();
    
    public Preguntas3(Jugador jugador)
    {
        this.jugador = jugador; 
        initComponents();
        this.setLocationRelativeTo(this);
        bg.add(txtRespuesta1);
        bg.add(txtRespuesta2);
        bg.add(txtRespuesta3);
        bg.add(txtRespuesta4);
        
        //this.setLocationRelativeTo(this);
        btnBotonOpcionesActionPerformed(null);
    }

    public void getSelectedOPtion(JRadioButton rbtn)
    {
        //obtener el valor seleccionado de la radioButton
        System.out.println(rbtn.getText());
        System.out.println(respuestas[index][2]);
        //Compruebe si el usuario seleccionó la respuesta correcta.
        if(rbtn.getText().equals(respuestas[index][2]))
        {
            correct++;       
        }
        
        //incrementar el índice
        index++;
        
        //deshabilitar el radioButtons
        enableRbuttons(false);
    }
    // enable/ disable radioButton
    public void enableRbuttons(boolean yes_or_no)
    {
        txtRespuesta1.setEnabled(yes_or_no);
        txtRespuesta2.setEnabled(yes_or_no);
        txtRespuesta3.setEnabled(yes_or_no);
        txtRespuesta4.setEnabled(yes_or_no);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBotonOpciones = new javax.swing.JButton();
        txtRespuesta1 = new javax.swing.JRadioButton();
        txtRespuesta2 = new javax.swing.JRadioButton();
        txtRespuesta3 = new javax.swing.JRadioButton();
        txtRespuesta4 = new javax.swing.JRadioButton();
        PanelPregunta = new javax.swing.JPanel();
        txtPregunta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        btnBotonOpciones.setBackground(new java.awt.Color(153, 255, 255));
        btnBotonOpciones.setFont(new java.awt.Font("Chalkduster", 0, 14)); // NOI18N
        btnBotonOpciones.setText("Next");
        btnBotonOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBotonOpcionesActionPerformed(evt);
            }
        });

        txtRespuesta1.setFont(new java.awt.Font("Chalkduster", 0, 14)); // NOI18N
        txtRespuesta1.setForeground(new java.awt.Color(51, 51, 255));
        txtRespuesta1.setText("jRadioButton1");
        txtRespuesta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuesta1ActionPerformed(evt);
            }
        });

        txtRespuesta2.setFont(new java.awt.Font("Chalkduster", 0, 14)); // NOI18N
        txtRespuesta2.setForeground(new java.awt.Color(0, 0, 255));
        txtRespuesta2.setText("jRadioButton2");
        txtRespuesta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuesta2ActionPerformed(evt);
            }
        });

        txtRespuesta3.setFont(new java.awt.Font("Chalkduster", 0, 14)); // NOI18N
        txtRespuesta3.setForeground(new java.awt.Color(0, 0, 255));
        txtRespuesta3.setText("jRadioButton3");
        txtRespuesta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuesta3ActionPerformed(evt);
            }
        });

        txtRespuesta4.setFont(new java.awt.Font("Chalkduster", 0, 14)); // NOI18N
        txtRespuesta4.setForeground(new java.awt.Color(0, 0, 255));
        txtRespuesta4.setText("jRadioButton4");
        txtRespuesta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuesta4ActionPerformed(evt);
            }
        });

        PanelPregunta.setBackground(new java.awt.Color(255, 204, 102));

        txtPregunta.setBackground(new java.awt.Color(0, 51, 255));
        txtPregunta.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout PanelPreguntaLayout = new javax.swing.GroupLayout(PanelPregunta);
        PanelPregunta.setLayout(PanelPreguntaLayout);
        PanelPreguntaLayout.setHorizontalGroup(
            PanelPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPreguntaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelPreguntaLayout.setVerticalGroup(
            PanelPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPreguntaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtRespuesta2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRespuesta1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRespuesta4, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRespuesta3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(btnBotonOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(txtRespuesta1)
                .addGap(18, 18, 18)
                .addComponent(txtRespuesta2)
                .addGap(18, 18, 18)
                .addComponent(txtRespuesta3)
                .addGap(18, 18, 18)
                .addComponent(txtRespuesta4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBotonOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBotonOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotonOpcionesActionPerformed
        if(btnBotonOpciones.getText().equals("Regresar"))
        {
            // Terminar el cuestionario
            jugador.puntos(correct);
            //cierra 
            this.setVisible(false);
        }
        
        if(index == preguntas.length)
        {
            // muestra los puntos
            txtPregunta.setText("Puntos optenidos: " + correct + " / " + preguntas.length);
            btnBotonOpciones.setText("Regresar");
        }
        
        else{
             enableRbuttons(true);
             // sig pregunta
             txtPregunta.setText(preguntas[index]);
             txtRespuesta1.setText(respuestas[index][0]);
             txtRespuesta2.setText(respuestas[index][1]);
             txtRespuesta3.setText(respuestas[index][2]);
             txtRespuesta4.setText(respuestas[index][3]);
             
             if(index == preguntas.length-1)
             {
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

    public static void main(String args[]) 
    {

        java.awt.EventQueue.invokeLater(() -> 
        {
            Jugador jugador = new Jugador();
                new Preguntas3(jugador).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPregunta;
    private javax.swing.JButton btnBotonOpciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtPregunta;
    private javax.swing.JRadioButton txtRespuesta1;
    private javax.swing.JRadioButton txtRespuesta2;
    private javax.swing.JRadioButton txtRespuesta3;
    private javax.swing.JRadioButton txtRespuesta4;
    // End of variables declaration//GEN-END:variables
}
