package sopaletras;

import java.awt.Color;
import javax.swing.JLabel;
import java.util.Random;

public class soup extends javax.swing.JFrame {
    JLabel[][] letra;
    JLabel[] word;
    int[] iniciox, inicioy;
    boolean win, direccion[];
    
    public soup() {
        initComponents();
        word= new JLabel[]{p1,p2,p3,p4,p5,p6,p7,p8, p9, p10};
        this.setLocationRelativeTo(null);
        load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sup = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        p1 = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        p3 = new javax.swing.JLabel();
        p4 = new javax.swing.JLabel();
        p5 = new javax.swing.JLabel();
        p6 = new javax.swing.JLabel();
        p7 = new javax.swing.JLabel();
        p8 = new javax.swing.JLabel();
        p16 = new javax.swing.JLabel();
        p15 = new javax.swing.JLabel();
        p9 = new javax.swing.JLabel();
        p10 = new javax.swing.JLabel();
        p11 = new javax.swing.JLabel();
        p12 = new javax.swing.JLabel();
        p13 = new javax.swing.JLabel();
        p14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sup.setBackground(new java.awt.Color(204, 204, 204));
        sup.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sup.setLayout(new java.awt.GridLayout(14, 10));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        p1.setBackground(new java.awt.Color(255, 255, 255));
        p1.setForeground(new java.awt.Color(255, 255, 255));
        p1.setText("AHUCATL");

        p2.setText("METATL");

        p3.setText("CHICTLI");

        p4.setText("XITOMATL");

        p5.setText("EXOTL");

        p6.setText("AGUACATE");

        p7.setText("METATE");

        p8.setText("CHICLE");

        p16.setText("JITOMATE");

        p15.setText("EJOTE");

        p9.setText("TZINTZUNI");

        p10.setText("COLIBRI");

        p11.setText("CORUNDAS");

        p12.setText("TAMALES");

        p13.setText("PIREKUAS");

        p14.setText("CANCIONES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(p1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(p8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(p2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(p3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(p4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(p5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(p6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(p14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(p7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p15)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p1)
                    .addComponent(p9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p2)
                    .addComponent(p10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p3)
                    .addComponent(p11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p4)
                    .addComponent(p12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p5)
                    .addComponent(p13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p6)
                    .addComponent(p14))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p7)
                    .addComponent(p15))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p8)
                    .addComponent(p16))
                .addContainerGap(228, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SOPA DE LETRAS");

        jLabel2.setText("NAHUATL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Reset");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(sup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    public void load(){
        win=false;
        iniciox=new int[10];
        inicioy=new int[10];
        direccion=new boolean[10];
        celdas();
        colocarpalabras();
        emptyspaces(); 
    }
    
    public void celdas(){
        letra = new JLabel[10][14];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                letra[i][j]=new JLabel("",javax.swing.SwingConstants.CENTER);
                letra[i][j].setName("");
                letra[i][j].setBackground(Color.WHITE);
                letra[i][j].setFont(new java.awt.Font("Segoe UI Symbol", 1,14));
                letra[i][j].setForeground(new java.awt.Color(0,5,2));
                letra[i][j].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                letra[i][j].setOpaque(true);
                letra[i][j].setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
                letra[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
                    
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent event) {
                        pressclick(event);
                    }
                    });
                
                sup.add(letra[i][j]); 
            }
        }
    }
    
    public void pressclick(java.awt.event.MouseEvent event){
        if(!win){
            if(event.getComponent().getBackground().equals(Color.WHITE)){
                event.getComponent().setBackground(new java.awt.Color(51,51,255));
                cross();
            }
        }else if(event.getComponent().getName().equals("")){
            event.getComponent().setBackground(Color.WHITE);
        }
    }
    
    public void cross(){
        for (int i = 0; i < 10; i++) {
            if(!word[i].getText().substring(0,1).equals("<")){
                if(crossletra(iniciox[i],inicioy[i],word[i].getText().length(),direccion[i])){
                    word[i].setText("<html><body><s>"+word[i].getText()+"</s></body><htmil>");
                    break;
                }
            }
        }
        boolean aux=true;
        for (int i = 0; i < letra.length; i++) {
            if(!word[i].getText().substring(0,1).equals("<")){
                aux=false;
                break;
            }
        }
        /*
        if(aux){
            if(!(fin instanceof Final)){
                fin= new Final();
                win=true;
            }
            Centrarventana(fin);
        }*/
    }
    
    public boolean crossletra(int x, int y, int size,boolean dir){
        boolean answ=true;
        if(dir){
            for (int i = y; i < size+y; i++) {
                if(letra[x][i].getBackground().equals(Color.WHITE)){
                    answ=false;
                    break;
                }
            }
        }else{
            for (int j = y; j <y-size; j--) {
                if(letra[x][j].getBackground().equals(Color.WHITE)){
                    answ=false;
                    break;
                }
            }
        }
        return answ;
    }
    
    public void colocarpalabras(){
        String palabra[]={p1.getText(),p2.getText(),p3.getText(),p4.getText(),p5.getText(),p6.getText(),p7.getText(),p8.getText(),p9.getText(),p10.getText()};
        Random r = new Random();
        int startx=0, starty;
        int[] unico= norepeticiones(10);
        iniciox=unico;
        
        for (int i = 0; i < palabra.length; i++) {
            if(palabra[i].length()<14){
                startx=unico[i];
                starty=(int)(r.nextDouble()*14-1);
                int ext=0;
                if(starty+palabra[i].length()<14){
                    for (int j = starty; j <starty+palabra[i].length(); j++) {
                        letra[startx][j].setText(palabra[i].substring(ext, ext+1));
                        letra[startx][j].setName("l");
                        ext++;
                        inicioy[i]=starty;
                        direccion[i]=true;
                    }
                }else if(starty-palabra[i].length()>0){
                    for (int j = starty; j >starty-palabra[i].length(); j--) {
                        letra[startx][j].setText(palabra[i].substring(ext,ext+1));
                        letra[startx][j].setName("1");
                        ext++;
                        inicioy[i]=starty;
                        direccion[i]=false;
                    }
                }
            }
        }
    }
    
    public int[] norepeticiones(int n){
        int[] numeros = new int[n];
        for (int i = 0; i < n; i++) {
            numeros[i]=-1;
        }
        Random r = new Random();
        boolean aux;
        int num=0;
        for (int x = 0; x < n; x++) {
            aux=true;
            while(aux){
                aux=false;
                num= (int)(r.nextDouble()*11-1);
                for (int j = 0; j < numeros.length; j++) {
                    if(numeros[j]==num){
                        aux=true;
                        break;
                    }
                }
            }
            numeros[x]=num;
        }
        return numeros;
    }
    
    public void emptyspaces(){
        String[] abc = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                if(letra[i][j].getText().equals("")){
                    letra[i][j].setText(abc[r.nextInt(25+1-1)+1]);
                }
            }
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(soup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(soup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(soup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(soup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new soup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel p1;
    private javax.swing.JLabel p10;
    private javax.swing.JLabel p11;
    private javax.swing.JLabel p12;
    private javax.swing.JLabel p13;
    private javax.swing.JLabel p14;
    private javax.swing.JLabel p15;
    private javax.swing.JLabel p16;
    private javax.swing.JLabel p2;
    private javax.swing.JLabel p3;
    private javax.swing.JLabel p4;
    private javax.swing.JLabel p5;
    private javax.swing.JLabel p6;
    private javax.swing.JLabel p7;
    private javax.swing.JLabel p8;
    private javax.swing.JLabel p9;
    private javax.swing.JPanel sup;
    // End of variables declaration//GEN-END:variables
}
