/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import Juegos.Puntaje;
import Juegos.Puntajes;
import Usuarios.TipoDeUsuario;
import Usuarios.Usuario;
import Usuarios.Usuarios;
import Usuarios.UsuariosException;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.TableModel;

/**
 *
 * @author 177685
 */
public class Inicio extends javax.swing.JFrame {

    Usuarios usuarios;
    Puntajes puntajes = new Puntajes();
    Usuario usuario_seleccionado;

    /*
    
    Juego: 4F1P
    
     */
    String[] palabras = {"texocotl", "conetl", "itzcuintli", "pitzahua"};
    int currentQuestion = 0;
    int Juego4F1PPuntaje = 0;

    /*
    Juego Sopa de Letras
     */
    JLabel[][] letra;
    JLabel[] word;
    int[] iniciox, inicioy;
    boolean win, direccion[];
    //private final Jugador jugador;//hace la relacion de la clase jugador que contiene el array
    int casilla = 0;//en este se guardara el numero que genere el dado y lo va ir incrementando
    int turnos = 0;

    // Trivia
    String preguntas[] = {"¿Cuál es el origen de la lengua Náhuatl?", "¿Cuál es la familia de lenguas a la que pertenece el náhuatl?", "¿En qué siglo se estima que surgió la lengua Náhuatl?", "¿Qué civilización impulsó la expansión de la lengua Náhuatl en Mesoamérica?", "¿Cuál es la palabra náhuatl para <<agua>>?", "¿Cómo se dice <<sol>> en náhuatl?", "¿Cómo se dice <<luna>> en náhuatl?", "¿Cómo se dice <<niño>> en náhuatl?", "¿Cómo se dice <<mujer>> en náhuatl?", "¿Cómo se dice <<hombre>> en náhuatl?", "¿Cómo se dice <<fuego> en náhuatl?", "¿Cómo se dice <<tierra>> en náhuatl?", "¿Cómo se dice <<cielo>> en náhuatl?", "¿Cómo se dice <<flor>> en náhuatl?", "¿Cómo se dice <<casa>> en náhuatl?"};
    String opciones[][] = {{"Europa", "Asia", "África", "América"}, {" Indo-europea", " Sino-tibetana", "Uto-azteca", "Afroasiática"}, {"Siglo I", "Siglo III", "Siglo V", " Siglo VII"}, {"Maya", "Inca", "Tolteca", "Azteca"}, {"Tlaloc", "Atl", "Teotl", "Tlilli"}, {"Xochitl", "Tonatiuh", "Tlaloc", "Quetzalcoatl"}, {"Metztli", "Xochitl", "Tlaloc", "Quetzalcoatl"}, {"Tlilli", "Tlaloc", "Pilli", "Xochitl"}, {"Cihuatl", "Xochitl", "Tlaloc", "Quetzalcoatl"}, {"Tlilli", "Tlaloc", "Pilli", "Tlacaélel"}, {"Tletl", "Xochitl", "Tlaloc", "Quetzalcoatl"}, {"Tlilli", "Tlaloc", "Pilli", "Xochitl"}, {"Ilhuicatl", "Xochitl", "Tlaloc", "Quetzalcoatl"}, {"Tlilli", "Tlaloc", "Pilli", "Xochitl"}, {"Calli", "Xochitl", "Tlaloc", "Quetzalcoatl"}};
    int respuesta[] = {3, 2, 2, 3, 1, 1, 0, 2, 0, 3, 0, 0, 0, 3, 0};
    int seleccionada;
    int current;
    int puntos = 0;

    // Traductor
    String original[] = {
        "Amaj iuan nochipa ma mitsuanti tlauilpakilistli",
        "Ika miak tlasotlalistli xikonselli ni pilmentsin nemaktli",
        "Kani tiwalaj, ma titlajtokan totlajtol nochipa",
        "Quen otimotlanextilih notlazohtzin",
        "Amaj iuan nochipa tonalli nelia xiyolpakto",
        "Ximeua, ximijyoti, xiixuetska, uan xijnemilli xinejnemi",
        "Xijtemiki, ximonekilli, xichiua",
        "Nimitztlazohtla nochi noyollo",
        "Nochipa ipan noyoltsin",
        "Amaj iuan nochipa nijneki ma mitspano nochi tlen kualli"
    };

    String traduccion[] = {
        "Que hoy y siempre la luz de la alegría te acompañe",
        "Para ti este pequeño detallito con mucho amor",
        "Donde vayamos, hablemos siempre nuestra lengua",
        "¿Cómo amaneciste, amor mío?",
        "Hoy en este día y siempre serás muy feliz",
        "Levántate, respira, sonríe y sigue adelante",
        "Suéñalo, deséalo, hazlo",
        "Te amo con todo mi corazón",
        "Siempre en mi corazón",
        "Hoy y siempre te deseo lo mejor"
    };

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        try {
            this.usuarios = new Usuarios(rootPane);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Imposible realizar conexión con base de datos, continuando con información temporal: " + ex);
            try {
                this.usuarios = new Usuarios();
                usuarios.agregarUsuario(new Usuario("admin", "admin", TipoDeUsuario.ADMINISTRADOR, 1));
                usuarios.agregarUsuario(new Usuario("jugador", "jugador", TipoDeUsuario.JUGADOR, 2));
            } catch (UsuariosException ex1) {
                JOptionPane.showMessageDialog(rootPane, "Imposible generar información de prueba, terminando.");
                System.exit(0);
            }
        } catch (AssertionError ex) {
            JOptionPane.showMessageDialog(rootPane, "Información no esperada en base de datos: " + ex);
            System.exit(0);
        }

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IniciarSesion = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        NombreDeUsuarioTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ContrasenaDelUsuarioTextField = new javax.swing.JPasswordField();
        IniciarSesionBoton = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        Registrarse = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        NombreDelNuevoDeUsuarioTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ContrasenaDelNuevoUsuarioTextField = new javax.swing.JPasswordField();
        RegistrarUsuarioBoton = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        TipoDeNuevoUsuarioComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        EditarPerfil = new javax.swing.JFrame();
        GuardarEdicion = new javax.swing.JToggleButton();
        jSeparator4 = new javax.swing.JSeparator();
        EditarContrasenaTextField = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        EditarNombdeDeUsuarioTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        CancelarEdicion = new javax.swing.JButton();
        EditarTipoDeUsuarioComboBox = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        MenuPrincipalUsuario = new javax.swing.JFrame();
        jLabel6 = new javax.swing.JLabel();
        NombreDeUsuarioLabel = new javax.swing.JLabel();
        IdiomaComboBox = new javax.swing.JComboBox<>();
        DificultadComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Iniciar4F1PBoton = new javax.swing.JButton();
        IniciarSopaDeLetrasBoton = new javax.swing.JButton();
        IniciarTablero = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        IniciarTrivia = new javax.swing.JButton();
        EditarPerfilBoton = new javax.swing.JButton();
        IniciarMemorama = new javax.swing.JButton();
        IniciarTraduccion = new javax.swing.JButton();
        MenuPrincipalAdministrador = new javax.swing.JFrame();
        TriviaTabla = new javax.swing.JTabbedPane();
        Herramientas = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDeUsuarios = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        EliminarUsuarioBoton = new javax.swing.JButton();
        EliminarUsuarioTextField = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        EstadisticasSopaDeLetras = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        SopaDeLetrasUsuario = new javax.swing.JLabel();
        SopaDeLetrasPuntaje = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SopaDeLetrasTabla = new javax.swing.JTable();
        EstadisticasTrivia = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        triviaTabla = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        TriviaPuntaje = new javax.swing.JLabel();
        TriviaUsuario = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        EstadisticasTablero = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableroTabla = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        TableroPuntos = new javax.swing.JLabel();
        TableroUsuario = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        Estadisticas4F1P = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        J4G1PPuntos = new javax.swing.JLabel();
        J4F1PUsuario = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TraduccionTabla = new javax.swing.JTable();
        jLabel48 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        TraduccionPuntos = new javax.swing.JLabel();
        TraduccionUsuario = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        MemoramaTabla = new javax.swing.JTable();
        jLabel74 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        MemoramaPuntos = new javax.swing.JLabel();
        MemoramaUsuario = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        JuegoTablero = new javax.swing.JFrame();
        PanelPrincipal7 = new javax.swing.JPanel();
        panel31 = new javax.swing.JPanel();
        jugador1 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        panel32 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jugador3 = new javax.swing.JLabel();
        panel33 = new javax.swing.JPanel();
        jugador4 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        panel34 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jugador5 = new javax.swing.JLabel();
        panel35 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jugador2 = new javax.swing.JLabel();
        panel36 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jugador6 = new javax.swing.JLabel();
        panel8 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jugador8 = new javax.swing.JLabel();
        panel9 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jugador9 = new javax.swing.JLabel();
        panel10 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jugador10 = new javax.swing.JLabel();
        panel11 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jugador11 = new javax.swing.JLabel();
        panel13 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jugador12 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jugador13 = new javax.swing.JLabel();
        panel14 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jugador14 = new javax.swing.JLabel();
        panel15 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jugador15 = new javax.swing.JLabel();
        panel16 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jugador16 = new javax.swing.JLabel();
        panel17 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jugador17 = new javax.swing.JLabel();
        panel18 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jugador18 = new javax.swing.JLabel();
        panel19 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jugador19 = new javax.swing.JLabel();
        panel20 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jugador20 = new javax.swing.JLabel();
        panel21 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jugador21 = new javax.swing.JLabel();
        panel22 = new javax.swing.JPanel();
        jugador22 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        panel23 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jugador23 = new javax.swing.JLabel();
        panel24 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jugador24 = new javax.swing.JLabel();
        panel25 = new javax.swing.JPanel();
        jugador25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnDado = new javax.swing.JButton();
        txt1 = new javax.swing.JTextField();
        jPanel48 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        panel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jugador7 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtJugador = new javax.swing.JTextField();
        txtPuntos = new javax.swing.JTextField();
        JuegoTrivia = new javax.swing.JFrame();
        TituloDeLaVentana = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        TituloDeLaPregunta = new javax.swing.JLabel();
        JugadorLabel = new javax.swing.JLabel();
        Respuesta1 = new javax.swing.JButton();
        Respuesta2 = new javax.swing.JButton();
        Respuesta3 = new javax.swing.JButton();
        Respuesta4 = new javax.swing.JButton();
        SiguientePregunta = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        ResultadoDeLaPregunta = new javax.swing.JLabel();
        R1 = new javax.swing.JLabel();
        R2 = new javax.swing.JLabel();
        R3 = new javax.swing.JLabel();
        R4 = new javax.swing.JLabel();
        Res = new javax.swing.JLabel();
        JuegoSopaDeLetras = new javax.swing.JFrame();
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
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        Juego4F1P = new javax.swing.JFrame();
        ImagenDelJuego = new javax.swing.JLabel();
        answerField = new javax.swing.JTextField();
        checkButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        LenguaLabel = new javax.swing.JTextField();
        DificultadLabel = new javax.swing.JTextField();
        Trad = new javax.swing.JFrame();
        jLabel18 = new javax.swing.JLabel();
        oracion = new javax.swing.JLabel();
        Respuesta = new javax.swing.JTextField();
        Comprobar = new javax.swing.JButton();
        LoginFondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        IrARegistrarseBoton = new javax.swing.JButton();
        IrAIniciarSesionBoton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        IniciarSesion.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        IniciarSesion.setMinimumSize(new java.awt.Dimension(339, 330));
        IniciarSesion.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                IniciarSesionWindowClosing(evt);
            }
        });

        jLabel2.setText("Nombre de Usuario");

        NombreDeUsuarioTextField.setToolTipText("NOmbre del usuario");

        jLabel3.setText("Contraseña");
        jLabel3.setToolTipText("");

        ContrasenaDelUsuarioTextField.setToolTipText("Contraseña del usuario");

        IniciarSesionBoton.setText("Iniciar Sesión");
        IniciarSesionBoton.setToolTipText("Haz click para iniciar sesión");
        IniciarSesionBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IniciarSesionBotonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout IniciarSesionLayout = new javax.swing.GroupLayout(IniciarSesion.getContentPane());
        IniciarSesion.getContentPane().setLayout(IniciarSesionLayout);
        IniciarSesionLayout.setHorizontalGroup(
            IniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IniciarSesionBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(IniciarSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(NombreDeUsuarioTextField)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ContrasenaDelUsuarioTextField)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        IniciarSesionLayout.setVerticalGroup(
            IniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IniciarSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NombreDeUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContrasenaDelUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IniciarSesionBoton)
                .addContainerGap())
        );

        Registrarse.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Registrarse.setMinimumSize(new java.awt.Dimension(339, 330));
        Registrarse.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                RegistrarseWindowClosing(evt);
            }
        });

        jLabel4.setText("Nombre de Usuario");

        NombreDelNuevoDeUsuarioTextField.setToolTipText("NOmbre del usuario");

        jLabel5.setText("Contraseña");
        jLabel5.setToolTipText("");

        ContrasenaDelNuevoUsuarioTextField.setToolTipText("Contraseña del usuario");

        RegistrarUsuarioBoton.setText("Registrar Usuario");
        RegistrarUsuarioBoton.setToolTipText("Haz click para registrar usuario");
        RegistrarUsuarioBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistrarUsuarioBotonMouseClicked(evt);
            }
        });

        TipoDeNuevoUsuarioComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jugador", "Administrador" }));

        jLabel9.setText("Tipo de Usuario");
        jLabel9.setToolTipText("");

        javax.swing.GroupLayout RegistrarseLayout = new javax.swing.GroupLayout(Registrarse.getContentPane());
        Registrarse.getContentPane().setLayout(RegistrarseLayout);
        RegistrarseLayout.setHorizontalGroup(
            RegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RegistrarUsuarioBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(RegistrarseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(NombreDelNuevoDeUsuarioTextField)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ContrasenaDelNuevoUsuarioTextField)
                    .addComponent(TipoDeNuevoUsuarioComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        RegistrarseLayout.setVerticalGroup(
            RegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NombreDelNuevoDeUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContrasenaDelNuevoUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TipoDeNuevoUsuarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RegistrarUsuarioBoton)
                .addContainerGap())
        );

        EditarPerfil.setMinimumSize(new java.awt.Dimension(339, 330));

        GuardarEdicion.setText("Guardar Cambios");
        GuardarEdicion.setToolTipText("Haz click para iniciar sesión");
        GuardarEdicion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GuardarEdicionMouseClicked(evt);
            }
        });

        EditarContrasenaTextField.setToolTipText("Contraseña del usuario");

        jLabel12.setText("Editar Contraseña");
        jLabel12.setToolTipText("");

        EditarNombdeDeUsuarioTextField.setToolTipText("NOmbre del usuario");

        jLabel13.setText("Editar Nombre de Usuario");

        CancelarEdicion.setText("Cancelar");
        CancelarEdicion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelarEdicionMouseClicked(evt);
            }
        });

        EditarTipoDeUsuarioComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jugador", "Administrador" }));

        jLabel14.setText("Editar Tipo de Usuario");
        jLabel14.setToolTipText("");

        javax.swing.GroupLayout EditarPerfilLayout = new javax.swing.GroupLayout(EditarPerfil.getContentPane());
        EditarPerfil.getContentPane().setLayout(EditarPerfilLayout);
        EditarPerfilLayout.setHorizontalGroup(
            EditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditarPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(EditarNombdeDeUsuarioTextField)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditarContrasenaTextField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditarPerfilLayout.createSequentialGroup()
                        .addComponent(CancelarEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GuardarEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EditarTipoDeUsuarioComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        EditarPerfilLayout.setVerticalGroup(
            EditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditarPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarNombdeDeUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarContrasenaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(9, 9, 9)
                .addComponent(EditarTipoDeUsuarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarEdicion)
                    .addComponent(CancelarEdicion))
                .addContainerGap())
        );

        MenuPrincipalUsuario.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        MenuPrincipalUsuario.setBackground(new java.awt.Color(234, 217, 181));
        MenuPrincipalUsuario.setMinimumSize(new java.awt.Dimension(339, 330));
        MenuPrincipalUsuario.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                MenuPrincipalUsuarioWindowClosing(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Bienvenido");

        NombreDeUsuarioLabel.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        NombreDeUsuarioLabel.setText("<Nombre de Usuario>");

        IdiomaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Náhuatl", "Huasteco" }));

        DificultadComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facil", "Dificil" }));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Idioma a Jugar");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Dificultad del Juego");

        Iniciar4F1PBoton.setText("Iniciar 4F1P");
        Iniciar4F1PBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Iniciar4F1PBotonMouseClicked(evt);
            }
        });

        IniciarSopaDeLetrasBoton.setText("Iniciar Sopa de Letras");
        IniciarSopaDeLetrasBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IniciarSopaDeLetrasBotonMouseClicked(evt);
            }
        });

        IniciarTablero.setText("Iniciar Tablero");
        IniciarTablero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IniciarTableroMouseClicked(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel11.setIconTextGap(2);

        IniciarTrivia.setText("Iniciar Trivia");
        IniciarTrivia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IniciarTriviaMouseClicked(evt);
            }
        });

        EditarPerfilBoton.setText("Editar Perfil");
        EditarPerfilBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditarPerfilBotonMouseClicked(evt);
            }
        });

        IniciarMemorama.setText("Iniciar Memorama");
        IniciarMemorama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IniciarMemoramaMouseClicked(evt);
            }
        });

        IniciarTraduccion.setText("Iniciar prueba de Traducción");
        IniciarTraduccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IniciarTraduccionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuPrincipalUsuarioLayout = new javax.swing.GroupLayout(MenuPrincipalUsuario.getContentPane());
        MenuPrincipalUsuario.getContentPane().setLayout(MenuPrincipalUsuarioLayout);
        MenuPrincipalUsuarioLayout.setHorizontalGroup(
            MenuPrincipalUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPrincipalUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuPrincipalUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPrincipalUsuarioLayout.createSequentialGroup()
                        .addGroup(MenuPrincipalUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(IniciarMemorama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IniciarTablero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IniciarSopaDeLetrasBoton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Iniciar4F1PBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MenuPrincipalUsuarioLayout.createSequentialGroup()
                                .addGroup(MenuPrincipalUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DificultadComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                .addGap(49, 49, 49)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MenuPrincipalUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IdiomaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(IniciarTrivia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(MenuPrincipalUsuarioLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(NombreDeUsuarioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EditarPerfilBoton))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IniciarTraduccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        MenuPrincipalUsuarioLayout.setVerticalGroup(
            MenuPrincipalUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPrincipalUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MenuPrincipalUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreDeUsuarioLabel)
                    .addComponent(EditarPerfilBoton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MenuPrincipalUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPrincipalUsuarioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DificultadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuPrincipalUsuarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MenuPrincipalUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPrincipalUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IdiomaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(IniciarTablero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IniciarTrivia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IniciarSopaDeLetrasBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Iniciar4F1PBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IniciarMemorama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IniciarTraduccion)
                .addContainerGap())
        );

        MenuPrincipalAdministrador.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        MenuPrincipalAdministrador.setMinimumSize(new java.awt.Dimension(339, 330));
        MenuPrincipalAdministrador.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                MenuPrincipalAdministradorWindowClosing(evt);
            }
        });

        jLabel29.setText("Listado de Usuarios ");

        TablaDeUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre de Usuario", "Contraseña"
            }
        ));
        TablaDeUsuarios.setAutoscrolls(false);
        TablaDeUsuarios.setCellSelectionEnabled(true);
        TablaDeUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDeUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDeUsuarios);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel30.setText("*Puede editar ambos valores haciendo doble click");

        EliminarUsuarioBoton.setText("Eliminar Usuario");
        EliminarUsuarioBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarUsuarioBotonMouseClicked(evt);
            }
        });

        EliminarUsuarioTextField.setText("Busca el usuario a eliminar");

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout HerramientasLayout = new javax.swing.GroupLayout(Herramientas);
        Herramientas.setLayout(HerramientasLayout);
        HerramientasLayout.setHorizontalGroup(
            HerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HerramientasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(HerramientasLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EliminarUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EliminarUsuarioBoton))
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        HerramientasLayout.setVerticalGroup(
            HerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HerramientasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(HerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(EliminarUsuarioBoton)
                        .addComponent(EliminarUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addContainerGap())
        );

        TriviaTabla.addTab("Herramientas", Herramientas);

        jLabel36.setText("Usuario con mayor puntaje: ");

        SopaDeLetrasUsuario.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        SopaDeLetrasUsuario.setText("<Usuario>");

        SopaDeLetrasPuntaje.setText("<Puntos> puntos");

        jLabel20.setText("Registro Historico:");

        SopaDeLetrasTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Usuario", "Puntaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(SopaDeLetrasTabla);

        javax.swing.GroupLayout EstadisticasSopaDeLetrasLayout = new javax.swing.GroupLayout(EstadisticasSopaDeLetras);
        EstadisticasSopaDeLetras.setLayout(EstadisticasSopaDeLetrasLayout);
        EstadisticasSopaDeLetrasLayout.setHorizontalGroup(
            EstadisticasSopaDeLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EstadisticasSopaDeLetrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstadisticasSopaDeLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                    .addComponent(SopaDeLetrasUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SopaDeLetrasPuntaje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        EstadisticasSopaDeLetrasLayout.setVerticalGroup(
            EstadisticasSopaDeLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasSopaDeLetrasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SopaDeLetrasUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SopaDeLetrasPuntaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        TriviaTabla.addTab("Estadisticas Sopa de Letras", EstadisticasSopaDeLetras);

        triviaTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Usuario", "Puntaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(triviaTabla);

        jLabel21.setText("Registro Historico:");

        TriviaPuntaje.setText("<Puntos> puntos");

        TriviaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TriviaUsuario.setText("<Usuario>");

        jLabel38.setText("Usuario con mayor puntaje: ");

        javax.swing.GroupLayout EstadisticasTriviaLayout = new javax.swing.GroupLayout(EstadisticasTrivia);
        EstadisticasTrivia.setLayout(EstadisticasTriviaLayout);
        EstadisticasTriviaLayout.setHorizontalGroup(
            EstadisticasTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EstadisticasTriviaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstadisticasTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                    .addComponent(TriviaUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TriviaPuntaje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        EstadisticasTriviaLayout.setVerticalGroup(
            EstadisticasTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasTriviaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TriviaUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TriviaPuntaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        TriviaTabla.addTab("Estadisticas Trivia", EstadisticasTrivia);

        tableroTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Usuario", "Puntaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableroTabla);

        jLabel31.setText("Registro Historico:");

        TableroPuntos.setText("<Puntos> puntos");

        TableroUsuario.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TableroUsuario.setText("<Usuario>");

        jLabel39.setText("Usuario con mayor puntaje: ");

        javax.swing.GroupLayout EstadisticasTableroLayout = new javax.swing.GroupLayout(EstadisticasTablero);
        EstadisticasTablero.setLayout(EstadisticasTableroLayout);
        EstadisticasTableroLayout.setHorizontalGroup(
            EstadisticasTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EstadisticasTableroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstadisticasTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                    .addComponent(TableroUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TableroPuntos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        EstadisticasTableroLayout.setVerticalGroup(
            EstadisticasTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasTableroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TableroUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TableroPuntos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        TriviaTabla.addTab("Estadisticas Tablero", EstadisticasTablero);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Usuario", "Puntaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable);

        jLabel40.setText("Registro Historico:");

        J4G1PPuntos.setText("<Puntos> puntos");

        J4F1PUsuario.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        J4F1PUsuario.setText("<Usuario>");

        jLabel43.setText("Usuario con mayor puntaje: ");

        javax.swing.GroupLayout Estadisticas4F1PLayout = new javax.swing.GroupLayout(Estadisticas4F1P);
        Estadisticas4F1P.setLayout(Estadisticas4F1PLayout);
        Estadisticas4F1PLayout.setHorizontalGroup(
            Estadisticas4F1PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Estadisticas4F1PLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Estadisticas4F1PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                    .addComponent(J4F1PUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(J4G1PPuntos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Estadisticas4F1PLayout.setVerticalGroup(
            Estadisticas4F1PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Estadisticas4F1PLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(J4F1PUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(J4G1PPuntos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        TriviaTabla.addTab("Estadisticas 4F1P", Estadisticas4F1P);

        TraduccionTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Usuario", "Puntaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(TraduccionTabla);

        jLabel48.setText("Registro Historico:");

        TraduccionPuntos.setText("<Puntos> puntos");

        TraduccionUsuario.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TraduccionUsuario.setText("<Usuario>");

        jLabel73.setText("Usuario con mayor puntaje: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7)
                    .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                    .addComponent(TraduccionUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TraduccionPuntos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TraduccionUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TraduccionPuntos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        TriviaTabla.addTab("Estadisticas Traducción", jPanel1);

        MemoramaTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Usuario", "Puntaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(MemoramaTabla);

        jLabel74.setText("Registro Historico:");

        MemoramaPuntos.setText("<Puntos> puntos");

        MemoramaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        MemoramaUsuario.setText("<Usuario>");

        jLabel77.setText("Usuario con mayor puntaje: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8)
                    .addComponent(jLabel77, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                    .addComponent(MemoramaUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MemoramaPuntos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MemoramaUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MemoramaPuntos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        TriviaTabla.addTab("Estadisticas Memorama", jPanel3);

        javax.swing.GroupLayout MenuPrincipalAdministradorLayout = new javax.swing.GroupLayout(MenuPrincipalAdministrador.getContentPane());
        MenuPrincipalAdministrador.getContentPane().setLayout(MenuPrincipalAdministradorLayout);
        MenuPrincipalAdministradorLayout.setHorizontalGroup(
            MenuPrincipalAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TriviaTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );
        MenuPrincipalAdministradorLayout.setVerticalGroup(
            MenuPrincipalAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TriviaTabla)
        );

        JuegoTablero.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        JuegoTablero.setMinimumSize(new java.awt.Dimension(339, 330));
        JuegoTablero.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                JuegoTableroWindowClosing(evt);
            }
        });

        PanelPrincipal7.setBackground(new java.awt.Color(102, 204, 255));

        panel31.setBackground(new java.awt.Color(204, 255, 255));
        panel31.setPreferredSize(new java.awt.Dimension(66, 66));

        jugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro1 - copia.png"))); // NOI18N
        jugador1.setText("jugador1");

        jLabel51.setText("1");

        javax.swing.GroupLayout panel31Layout = new javax.swing.GroupLayout(panel31);
        panel31.setLayout(panel31Layout);
        panel31Layout.setHorizontalGroup(
            panel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel31Layout.createSequentialGroup()
                .addGroup(panel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel31Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel31Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panel31Layout.setVerticalGroup(
            panel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel32.setBackground(new java.awt.Color(204, 255, 255));
        panel32.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel52.setText("3");

        jugador3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pregunta.png"))); // NOI18N
        jugador3.setText("jugador3");

        javax.swing.GroupLayout panel32Layout = new javax.swing.GroupLayout(panel32);
        panel32.setLayout(panel32Layout);
        panel32Layout.setHorizontalGroup(
            panel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel32Layout.createSequentialGroup()
                .addGroup(panel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel32Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel32Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panel32Layout.setVerticalGroup(
            panel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel52))
        );

        panel33.setBackground(new java.awt.Color(204, 255, 255));
        panel33.setPreferredSize(new java.awt.Dimension(66, 66));

        jugador4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro1 - copia.png"))); // NOI18N
        jugador4.setText("jugador4");

        jLabel53.setText("4");

        javax.swing.GroupLayout panel33Layout = new javax.swing.GroupLayout(panel33);
        panel33.setLayout(panel33Layout);
        panel33Layout.setHorizontalGroup(
            panel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panel33Layout.setVerticalGroup(
            panel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel33Layout.createSequentialGroup()
                .addComponent(jugador4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel34.setBackground(new java.awt.Color(204, 255, 255));
        panel34.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel54.setText("5");

        jugador5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tablero.png"))); // NOI18N
        jugador5.setText("jugador5");

        javax.swing.GroupLayout panel34Layout = new javax.swing.GroupLayout(panel34);
        panel34.setLayout(panel34Layout);
        panel34Layout.setHorizontalGroup(
            panel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panel34Layout.setVerticalGroup(
            panel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel54)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel35.setBackground(new java.awt.Color(204, 255, 255));
        panel35.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel55.setText("2");

        jugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro1 - copia.png"))); // NOI18N
        jugador2.setText("jugador2");

        javax.swing.GroupLayout panel35Layout = new javax.swing.GroupLayout(panel35);
        panel35.setLayout(panel35Layout);
        panel35Layout.setHorizontalGroup(
            panel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel35Layout.createSequentialGroup()
                .addGroup(panel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel35Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel35Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panel35Layout.setVerticalGroup(
            panel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel55))
        );

        panel36.setBackground(new java.awt.Color(204, 255, 255));
        panel36.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel56.setText("6");

        jugador6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sorpresa1.png"))); // NOI18N
        jugador6.setText("jugador6");

        javax.swing.GroupLayout panel36Layout = new javax.swing.GroupLayout(panel36);
        panel36.setLayout(panel36Layout);
        panel36Layout.setHorizontalGroup(
            panel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panel36Layout.createSequentialGroup()
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel36Layout.setVerticalGroup(
            panel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel56))
        );

        panel8.setBackground(new java.awt.Color(204, 255, 255));
        panel8.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel57.setText("8");

        jugador8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tablero.png"))); // NOI18N
        jugador8.setText("jugador8");

        javax.swing.GroupLayout panel8Layout = new javax.swing.GroupLayout(panel8);
        panel8.setLayout(panel8Layout);
        panel8Layout.setHorizontalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel8Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jugador8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel8Layout.setVerticalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel57))
        );

        panel9.setBackground(new java.awt.Color(204, 255, 255));
        panel9.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel58.setText("9");

        jugador9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro1 - copia.png"))); // NOI18N
        jugador9.setText("jugador9");

        javax.swing.GroupLayout panel9Layout = new javax.swing.GroupLayout(panel9);
        panel9.setLayout(panel9Layout);
        panel9Layout.setHorizontalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panel9Layout.setVerticalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                .addComponent(jugador9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel10.setBackground(new java.awt.Color(204, 255, 255));
        panel10.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel59.setText("10");

        jugador10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pregunta.png"))); // NOI18N
        jugador10.setText("jugador10");

        javax.swing.GroupLayout panel10Layout = new javax.swing.GroupLayout(panel10);
        panel10.setLayout(panel10Layout);
        panel10Layout.setHorizontalGroup(
            panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jugador10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panel10Layout.setVerticalGroup(
            panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel59))
        );

        panel11.setBackground(new java.awt.Color(204, 255, 255));
        panel11.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel60.setText("11");

        jugador11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tablero.png"))); // NOI18N
        jugador11.setText("jugador11");

        javax.swing.GroupLayout panel11Layout = new javax.swing.GroupLayout(panel11);
        panel11.setLayout(panel11Layout);
        panel11Layout.setHorizontalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel11Layout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jugador11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel11Layout.setVerticalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel60))
        );

        panel13.setBackground(new java.awt.Color(204, 255, 255));
        panel13.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel61.setText("12");

        jugador12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro1 - copia.png"))); // NOI18N
        jugador12.setText("jugador12");

        javax.swing.GroupLayout panel13Layout = new javax.swing.GroupLayout(panel13);
        panel13.setLayout(panel13Layout);
        panel13Layout.setHorizontalGroup(
            panel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador12, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panel13Layout.setVerticalGroup(
            panel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel13Layout.createSequentialGroup()
                .addComponent(jugador12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel29.setBackground(new java.awt.Color(204, 255, 255));
        jPanel29.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel62.setText("13");

        jugador13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/premio.png"))); // NOI18N
        jugador13.setText("jugador13");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel62))
        );

        panel14.setBackground(new java.awt.Color(204, 255, 255));
        panel14.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel63.setText("14");

        jugador14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sorpresa1.png"))); // NOI18N
        jugador14.setText("jugador14");

        javax.swing.GroupLayout panel14Layout = new javax.swing.GroupLayout(panel14);
        panel14.setLayout(panel14Layout);
        panel14Layout.setHorizontalGroup(
            panel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel14Layout.createSequentialGroup()
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jugador14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel14Layout.setVerticalGroup(
            panel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel63))
        );

        panel15.setBackground(new java.awt.Color(204, 255, 255));
        panel15.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel64.setText("15");

        jugador15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pregunta.png"))); // NOI18N
        jugador15.setText("jugador15");

        javax.swing.GroupLayout panel15Layout = new javax.swing.GroupLayout(panel15);
        panel15.setLayout(panel15Layout);
        panel15Layout.setHorizontalGroup(
            panel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel15Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jugador15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel15Layout.setVerticalGroup(
            panel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jugador15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel64))
        );

        panel16.setBackground(new java.awt.Color(204, 255, 255));
        panel16.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel65.setText("16");

        jugador16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro1 - copia.png"))); // NOI18N
        jugador16.setText("jugador16");

        javax.swing.GroupLayout panel16Layout = new javax.swing.GroupLayout(panel16);
        panel16.setLayout(panel16Layout);
        panel16Layout.setHorizontalGroup(
            panel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panel16Layout.setVerticalGroup(
            panel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel16Layout.createSequentialGroup()
                .addComponent(jugador16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel65)
                .addContainerGap())
        );

        panel17.setBackground(new java.awt.Color(204, 255, 255));
        panel17.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel66.setText("17");

        jugador17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro1 - copia.png"))); // NOI18N
        jugador17.setText("jugador17");

        javax.swing.GroupLayout panel17Layout = new javax.swing.GroupLayout(panel17);
        panel17.setLayout(panel17Layout);
        panel17Layout.setHorizontalGroup(
            panel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addComponent(jugador17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panel17Layout.setVerticalGroup(
            panel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel17Layout.createSequentialGroup()
                .addComponent(jugador17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel66))
        );

        panel18.setBackground(new java.awt.Color(204, 255, 255));
        panel18.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel67.setText("18");

        jugador18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sorpresa1.png"))); // NOI18N
        jugador18.setText("jugador18");

        javax.swing.GroupLayout panel18Layout = new javax.swing.GroupLayout(panel18);
        panel18.setLayout(panel18Layout);
        panel18Layout.setHorizontalGroup(
            panel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel18Layout.createSequentialGroup()
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jugador18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel18Layout.setVerticalGroup(
            panel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel67))
        );

        panel19.setBackground(new java.awt.Color(204, 255, 255));
        panel19.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel68.setText("19");

        jugador19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro1 - copia.png"))); // NOI18N
        jugador19.setText("jugador19");

        javax.swing.GroupLayout panel19Layout = new javax.swing.GroupLayout(panel19);
        panel19.setLayout(panel19Layout);
        panel19Layout.setHorizontalGroup(
            panel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panel19Layout.setVerticalGroup(
            panel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel19Layout.createSequentialGroup()
                .addComponent(jugador19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel68))
        );

        panel20.setBackground(new java.awt.Color(204, 255, 255));
        panel20.setPreferredSize(new java.awt.Dimension(67, 67));

        jLabel69.setText("20");

        jugador20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tablero.png"))); // NOI18N
        jugador20.setText("jugador20");

        javax.swing.GroupLayout panel20Layout = new javax.swing.GroupLayout(panel20);
        panel20.setLayout(panel20Layout);
        panel20Layout.setHorizontalGroup(
            panel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel20Layout.createSequentialGroup()
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(jugador20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel20Layout.setVerticalGroup(
            panel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel69))
        );

        panel21.setBackground(new java.awt.Color(204, 255, 255));
        panel21.setPreferredSize(new java.awt.Dimension(67, 67));

        jLabel70.setText("21");

        jugador21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sorpresa1.png"))); // NOI18N
        jugador21.setText("jugador21");

        javax.swing.GroupLayout panel21Layout = new javax.swing.GroupLayout(panel21);
        panel21.setLayout(panel21Layout);
        panel21Layout.setHorizontalGroup(
            panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel21Layout.createSequentialGroup()
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(jugador21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel21Layout.setVerticalGroup(
            panel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador21, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel70))
        );

        panel22.setBackground(new java.awt.Color(204, 255, 255));
        panel22.setPreferredSize(new java.awt.Dimension(67, 67));

        jugador22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro1 - copia.png"))); // NOI18N
        jugador22.setText("jugador22");

        jLabel71.setText("22");

        javax.swing.GroupLayout panel22Layout = new javax.swing.GroupLayout(panel22);
        panel22.setLayout(panel22Layout);
        panel22Layout.setHorizontalGroup(
            panel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panel22Layout.setVerticalGroup(
            panel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel22Layout.createSequentialGroup()
                .addComponent(jugador22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel23.setBackground(new java.awt.Color(204, 255, 255));
        panel23.setPreferredSize(new java.awt.Dimension(67, 67));

        jLabel24.setText("23");

        jugador23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pregunta.png"))); // NOI18N
        jugador23.setText("jugador23");

        javax.swing.GroupLayout panel23Layout = new javax.swing.GroupLayout(panel23);
        panel23.setLayout(panel23Layout);
        panel23Layout.setHorizontalGroup(
            panel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel23Layout.createSequentialGroup()
                .addGroup(panel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel23Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jugador23, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panel23Layout.setVerticalGroup(
            panel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24))
        );

        panel24.setBackground(new java.awt.Color(204, 255, 255));
        panel24.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel25.setText("24");

        jugador24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/premio.png"))); // NOI18N
        jugador24.setText("jugador24");

        javax.swing.GroupLayout panel24Layout = new javax.swing.GroupLayout(panel24);
        panel24.setLayout(panel24Layout);
        panel24Layout.setHorizontalGroup(
            panel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panel24Layout.setVerticalGroup(
            panel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador24, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel25))
        );

        panel25.setBackground(new java.awt.Color(204, 255, 255));
        panel25.setPreferredSize(new java.awt.Dimension(66, 66));

        jugador25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro1 - copia.png"))); // NOI18N
        jugador25.setText("jugador25");

        jLabel26.setText("25");

        javax.swing.GroupLayout panel25Layout = new javax.swing.GroupLayout(panel25);
        panel25.setLayout(panel25Layout);
        panel25Layout.setHorizontalGroup(
            panel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugador25, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel25Layout.setVerticalGroup(
            panel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panel25Layout.createSequentialGroup()
                .addComponent(jugador25)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        btnDado.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnDado.setForeground(new java.awt.Color(0, 0, 255));
        btnDado.setText("DADO");
        btnDado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadoActionPerformed(evt);
            }
        });

        txt1.setEditable(false);
        txt1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N

        jPanel48.setBackground(new java.awt.Color(153, 204, 255));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(0, 102, 255));
        jTextField4.setFont(new java.awt.Font("Chalkboard", 3, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(153, 255, 255));
        jTextField4.setText("TABLERO");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro1.png"))); // NOI18N

        panel7.setBackground(new java.awt.Color(204, 255, 255));
        panel7.setPreferredSize(new java.awt.Dimension(66, 66));

        jLabel27.setText("7");

        jugador7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro1 - copia.png"))); // NOI18N
        jugador7.setText("jugador6");

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jugador7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel28.setBackground(new java.awt.Color(0, 255, 0));
        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 51));
        jLabel28.setText("HAS GANADOOO!");

        txtJugador.setBackground(new java.awt.Color(153, 204, 255));
        txtJugador.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        txtJugador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPuntos.setBackground(new java.awt.Color(153, 204, 255));
        txtPuntos.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        txtPuntos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout PanelPrincipal7Layout = new javax.swing.GroupLayout(PanelPrincipal7);
        PanelPrincipal7.setLayout(PanelPrincipal7Layout);
        PanelPrincipal7Layout.setHorizontalGroup(
            PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                .addGroup(PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(txtJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnDado, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel28)))
                .addGap(2, 2, 2)
                .addGroup(PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                                .addComponent(panel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                                    .addComponent(panel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(panel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(panel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(panel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(panel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                                        .addComponent(panel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)
                                        .addComponent(panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(panel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(panel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                                        .addComponent(panel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                                        .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(37, 37, 37))
                    .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        PanelPrincipal7Layout.setVerticalGroup(
            PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(txtJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipal7Layout.createSequentialGroup()
                .addGroup(PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipal7Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelPrincipal7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout JuegoTableroLayout = new javax.swing.GroupLayout(JuegoTablero.getContentPane());
        JuegoTablero.getContentPane().setLayout(JuegoTableroLayout);
        JuegoTableroLayout.setHorizontalGroup(
            JuegoTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JuegoTableroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPrincipal7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JuegoTableroLayout.setVerticalGroup(
            JuegoTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JuegoTrivia.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        JuegoTrivia.setMinimumSize(new java.awt.Dimension(339, 330));
        JuegoTrivia.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                JuegoTriviaWindowClosing(evt);
            }
        });

        TituloDeLaVentana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloDeLaVentana.setText("Juego de Preguntas y Respuestas");

        TituloDeLaPregunta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloDeLaPregunta.setText("<Titulo>");

        JugadorLabel.setText("Usuario: <Nombre de Usuario>");

        Respuesta1.setText("A");
        Respuesta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Respuesta1MouseClicked(evt);
            }
        });

        Respuesta2.setText("B");
        Respuesta2.setToolTipText("");
        Respuesta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Respuesta2MouseClicked(evt);
            }
        });

        Respuesta3.setText("C");
        Respuesta3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Respuesta3MouseClicked(evt);
            }
        });

        Respuesta4.setText("D");
        Respuesta4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Respuesta4MouseClicked(evt);
            }
        });

        SiguientePregunta.setText("Siguiente Pregunta");
        SiguientePregunta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SiguientePreguntaMouseClicked(evt);
            }
        });

        R1.setText("jLabel18");

        R2.setText("jLabel18");

        R3.setText("jLabel18");

        R4.setText("jLabel18");

        Res.setText("Respuesta: ");

        javax.swing.GroupLayout JuegoTriviaLayout = new javax.swing.GroupLayout(JuegoTrivia.getContentPane());
        JuegoTrivia.getContentPane().setLayout(JuegoTriviaLayout);
        JuegoTriviaLayout.setHorizontalGroup(
            JuegoTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JuegoTriviaLayout.createSequentialGroup()
                .addGroup(JuegoTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JuegoTriviaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JuegoTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TituloDeLaVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator5)))
                    .addGroup(JuegoTriviaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(TituloDeLaPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JuegoTriviaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JuegoTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JuegoTriviaLayout.createSequentialGroup()
                                .addComponent(ResultadoDeLaPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 175, Short.MAX_VALUE))
                            .addComponent(Res, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SiguientePregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JuegoTriviaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator7))
                    .addComponent(JugadorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JuegoTriviaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JuegoTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Respuesta4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Respuesta3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Respuesta2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Respuesta1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JuegoTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(R1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(R2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(R3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(R4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        JuegoTriviaLayout.setVerticalGroup(
            JuegoTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JuegoTriviaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloDeLaVentana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JugadorLabel)
                .addGap(18, 18, 18)
                .addComponent(TituloDeLaPregunta)
                .addGap(18, 18, 18)
                .addGroup(JuegoTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Respuesta1)
                    .addComponent(R1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JuegoTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Respuesta2)
                    .addComponent(R2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JuegoTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Respuesta3)
                    .addComponent(R3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JuegoTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Respuesta4)
                    .addComponent(R4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(JuegoTriviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SiguientePregunta)
                    .addComponent(ResultadoDeLaPregunta)
                    .addComponent(Res))
                .addContainerGap())
        );

        JuegoSopaDeLetras.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        JuegoSopaDeLetras.setMinimumSize(new java.awt.Dimension(339, 330));
        JuegoSopaDeLetras.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                JuegoSopaDeLetrasWindowClosing(evt);
            }
        });

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
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("SOPA DE LETRAS");

        jLabel17.setText("NAHUATL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Reset");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        JuegoSopaDeLetras.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout JuegoSopaDeLetrasLayout = new javax.swing.GroupLayout(JuegoSopaDeLetras.getContentPane());
        JuegoSopaDeLetras.getContentPane().setLayout(JuegoSopaDeLetrasLayout);
        JuegoSopaDeLetrasLayout.setHorizontalGroup(
            JuegoSopaDeLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JuegoSopaDeLetrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JuegoSopaDeLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JuegoSopaDeLetrasLayout.createSequentialGroup()
                        .addComponent(sup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        JuegoSopaDeLetrasLayout.setVerticalGroup(
            JuegoSopaDeLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JuegoSopaDeLetrasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JuegoSopaDeLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JuegoSopaDeLetrasLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(sup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Juego4F1P.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Juego4F1P.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                Juego4F1PWindowClosing(evt);
            }
        });

        ImagenDelJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/texocotl.jpg"))); // NOI18N

        answerField.setBackground(new java.awt.Color(255, 204, 102));
        answerField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        answerField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));
        answerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerFieldActionPerformed(evt);
            }
        });

        checkButton.setBackground(new java.awt.Color(102, 153, 255));
        checkButton.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        checkButton.setText("COMPROBAR");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonjButtonVerificarActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("4 FOTOS 1 PALABRA");

        jTextField1.setBackground(new java.awt.Color(204, 255, 102));
        jTextField1.setFont(new java.awt.Font("Segoe UI Black", 3, 12)); // NOI18N
        jTextField1.setText("Dificultad");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(255, 255, 102));
        jTextField2.setFont(new java.awt.Font("Segoe UI Black", 3, 12)); // NOI18N
        jTextField2.setText("Lengua:");

        javax.swing.GroupLayout Juego4F1PLayout = new javax.swing.GroupLayout(Juego4F1P.getContentPane());
        Juego4F1P.getContentPane().setLayout(Juego4F1PLayout);
        Juego4F1PLayout.setHorizontalGroup(
            Juego4F1PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Juego4F1PLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Juego4F1PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Juego4F1PLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DificultadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LenguaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Juego4F1PLayout.createSequentialGroup()
                        .addComponent(ImagenDelJuego)
                        .addGap(18, 18, 18)
                        .addGroup(Juego4F1PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(answerField, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(checkButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Juego4F1PLayout.setVerticalGroup(
            Juego4F1PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Juego4F1PLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(Juego4F1PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DificultadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LenguaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(Juego4F1PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Juego4F1PLayout.createSequentialGroup()
                        .addComponent(answerField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ImagenDelJuego))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Trad.setMinimumSize(new java.awt.Dimension(400, 125));
        Trad.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                TradWindowClosing(evt);
            }
        });

        jLabel18.setText("Traduce la siguiente oración:");

        oracion.setText("<Oración>");

        Respuesta.setText("Respuesta");

        Comprobar.setText("Comprobar");
        Comprobar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComprobarMouseClicked(evt);
            }
        });
        Comprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprobarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TradLayout = new javax.swing.GroupLayout(Trad.getContentPane());
        Trad.getContentPane().setLayout(TradLayout);
        TradLayout.setHorizontalGroup(
            TradLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TradLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TradLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(oracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Respuesta)
                    .addComponent(Comprobar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TradLayout.setVerticalGroup(
            TradLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TradLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(oracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Respuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Comprobar)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(339, 330));

        LoginFondo.setBackground(new java.awt.Color(234, 217, 181));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido");

        IrARegistrarseBoton.setText("Registrarse");
        IrARegistrarseBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IrARegistrarseBotonMouseClicked(evt);
            }
        });

        IrAIniciarSesionBoton.setText("Iniciar Sesión");
        IrAIniciarSesionBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IrAIniciarSesionBotonMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel10.setIconTextGap(2);

        javax.swing.GroupLayout LoginFondoLayout = new javax.swing.GroupLayout(LoginFondo);
        LoginFondo.setLayout(LoginFondoLayout);
        LoginFondoLayout.setHorizontalGroup(
            LoginFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IrARegistrarseBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IrAIniciarSesionBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                .addContainerGap())
        );
        LoginFondoLayout.setVerticalGroup(
            LoginFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IrAIniciarSesionBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IrARegistrarseBoton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IrAIniciarSesionBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IrAIniciarSesionBotonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        IniciarSesion.setVisible(true);
    }//GEN-LAST:event_IrAIniciarSesionBotonMouseClicked

    private void IrARegistrarseBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IrARegistrarseBotonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Registrarse.setVisible(true);
    }//GEN-LAST:event_IrARegistrarseBotonMouseClicked

    private void IniciarSesionBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniciarSesionBotonMouseClicked
        // TODO add your handling code here:
        String nombre_de_usuario = NombreDeUsuarioTextField.getText();
        String password = String.valueOf(ContrasenaDelUsuarioTextField.getPassword());

        if (nombre_de_usuario.isBlank() || nombre_de_usuario.isEmpty() || password.isBlank() || password.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor llena todos los campos");
            return;
        }

        try {
            usuario_seleccionado = usuarios.login(nombre_de_usuario, password);
            IniciarSesion.setVisible(false);

            switch (usuario_seleccionado.getTipoDeUsuario()) {
                case ADMINISTRADOR:

                    TablaDeUsuarios.removeAll();
                    TablaDeUsuarios.setModel(usuarios.toTableModel(rootPane));
                    Optional<Puntaje> _p_sopa = puntajes.getMaxSopaDeLetras();
                    Optional<Puntaje> _p_trivia = puntajes.getMaxTrivia();
                    Optional<Puntaje> _p_tablero = puntajes.getMaxTablero();
                    Optional<Puntaje> _p_j4f1p = puntajes.getMax4F1P();
                    Optional<Puntaje> _P_trad = puntajes.getMaxTraduccion();
                    Optional<Puntaje> _p_memo = puntajes.getMaxMemorama();

                    if (_p_sopa.isPresent()) {
                        Puntaje p_sopa = _p_sopa.get();

                        Usuario sopaDeLetras = usuarios.getUsuarioById(p_sopa.getId());
                        // Sopa de Letras
                        SopaDeLetrasUsuario.setText(sopaDeLetras.getNombreDeUsuario());
                        SopaDeLetrasPuntaje.setText(p_sopa.getPuntaje() + "puntos");

                        Object[][] data = new Object[puntajes.PuntajeDeSopaDeLetras.size()][2];

                        // Fill the array with data from the ArrayList
                        for (int i = 0; i < puntajes.PuntajeDeSopaDeLetras.size(); i++) {
                            Puntaje p = puntajes.PuntajeDeSopaDeLetras.get(i);
                            data[i][0] = usuarios.getUsuarioById(p.getId()).getNombreDeUsuario();
                            data[i][1] = p.getPuntaje();
                        }

                        // Create the TableModel
                        TableModel sopaDeLetrasModel = new javax.swing.table.DefaultTableModel(
                                data,
                                new String[]{
                                    "Nombre de Usuario", "Puntaje"
                                }
                        ) {

                        };

                        SopaDeLetrasTabla.setModel(sopaDeLetrasModel);
                    }

                    // Trivia
                    if (_p_trivia.isPresent()) {
                        Puntaje p_trivia = _p_trivia.get();
                        Usuario trivia = usuarios.getUsuarioById(p_trivia.getId());
                        TriviaUsuario.setText(trivia.getNombreDeUsuario());
                        TriviaPuntaje.setText(p_trivia.getPuntaje() + "puntos");

                        Object[][] data = new Object[puntajes.PuntajeDeTrivia.size()][2];

                        // Fill the array with data from the ArrayList
                        for (int i = 0; i < puntajes.PuntajeDeTrivia.size(); i++) {
                            Puntaje p = puntajes.PuntajeDeTrivia.get(i);
                            data[i][0] = usuarios.getUsuarioById(p.getId()).getNombreDeUsuario();
                            data[i][1] = p.getPuntaje();
                        }

                        // Create the TableModel
                        TableModel triviaModel = new javax.swing.table.DefaultTableModel(
                                data,
                                new String[]{
                                    "Nombre de Usuario", "Puntaje"
                                }
                        ) {

                        };

                        triviaTabla.setModel(triviaModel);
                    }

                    // Tablero
                    if (_p_tablero.isPresent()) {
                        Puntaje p_tablero = _p_tablero.get();
                        Usuario tablero = usuarios.getUsuarioById(p_tablero.getId());
                        TableroUsuario.setText(tablero.getNombreDeUsuario());
                        TableroPuntos.setText(p_tablero.getPuntaje() + "puntos");

                        Object[][] data = new Object[puntajes.PuntajeDeTablero.size()][2];

                        // Fill the array with data from the ArrayList
                        for (int i = 0; i < puntajes.PuntajeDeTablero.size(); i++) {
                            Puntaje p = puntajes.PuntajeDeTablero.get(i);
                            data[i][0] = usuarios.getUsuarioById(p.getId()).getNombreDeUsuario();
                            data[i][1] = p.getPuntaje();
                        }

                        // Create the TableModel
                        TableModel tableroModel = new javax.swing.table.DefaultTableModel(
                                data,
                                new String[]{
                                    "Nombre de Usuario", "Puntaje"
                                }
                        ) {

                        };

                        tableroTabla.setModel(tableroModel);
                    }

                    // 4F1P
                    if (_p_j4f1p.isPresent()) {
                        Puntaje p_j4f1p = _p_j4f1p.get();
                        Usuario j4f1p = usuarios.getUsuarioById(p_j4f1p.getId());
                        J4F1PUsuario.setText(j4f1p.getNombreDeUsuario());
                        J4G1PPuntos.setText(p_j4f1p.getPuntaje() + "puntos");

                        Object[][] data = new Object[puntajes.PuntajeDe4P1F.size()][2];

                        // Fill the array with data from the ArrayList
                        for (int i = 0; i < puntajes.PuntajeDe4P1F.size(); i++) {
                            Puntaje p = puntajes.PuntajeDe4P1F.get(i);
                            data[i][0] = usuarios.getUsuarioById(p.getId()).getNombreDeUsuario();
                            data[i][1] = p.getPuntaje();
                        }

                        // Create the TableModel
                        TableModel jModel = new javax.swing.table.DefaultTableModel(
                                data,
                                new String[]{
                                    "Nombre de Usuario", "Puntaje"
                                }
                        ) {

                        };

                        jTable.setModel(jModel);
                    }

                    // Traduccion
                    if (_P_trad.isPresent()) {
                        Puntaje P_trad = _P_trad.get();
                        Usuario traduccion = usuarios.getUsuarioById(P_trad.getId());
                        TraduccionUsuario.setText(traduccion.getNombreDeUsuario());
                        TraduccionPuntos.setText(P_trad.getPuntaje() + "puntos");

                        Object[][] data = new Object[puntajes.PuntajeDeTraduccion.size()][2];

                        // Fill the array with data from the ArrayList
                        for (int i = 0; i < puntajes.PuntajeDeTraduccion.size(); i++) {
                            Puntaje p = puntajes.PuntajeDeTraduccion.get(i);
                            data[i][0] = usuarios.getUsuarioById(p.getId()).getNombreDeUsuario();
                            data[i][1] = p.getPuntaje();
                        }

                        // Create the TableModel
                        TableModel tradModel = new javax.swing.table.DefaultTableModel(
                                data,
                                new String[]{
                                    "Nombre de Usuario", "Puntaje"
                                }
                        ) {

                        };

                        TraduccionTabla.setModel(tradModel);
                    }

                    // Memorama
                    if (_p_memo.isPresent()) {
                        Puntaje p_memo = _p_memo.get();
                        Usuario memorama = usuarios.getUsuarioById(p_memo.getId());
                        MemoramaUsuario.setText(memorama.getNombreDeUsuario());
                        MemoramaPuntos.setText(p_memo.getPuntaje() + "puntos");

                        Object[][] data = new Object[puntajes.PuntajeDeMemorama.size()][2];

                        // Fill the array with data from the ArrayList
                        for (int i = 0; i < puntajes.PuntajeDeMemorama.size(); i++) {
                            Puntaje p = puntajes.PuntajeDeMemorama.get(i);
                            data[i][0] = usuarios.getUsuarioById(p.getId()).getNombreDeUsuario();
                            data[i][1] = p.getPuntaje();
                        }

                        // Create the TableModel
                        TableModel MemoModel = new javax.swing.table.DefaultTableModel(
                                data,
                                new String[]{
                                    "Nombre de Usuario", "Puntaje"
                                }
                        ) {

                        };

                        MemoramaTabla.setModel(MemoModel);
                    }

                    MenuPrincipalAdministrador.setVisible(true);
                    break;

                case JUGADOR:
                    NombreDeUsuarioLabel.setText(usuario_seleccionado.getNombreDeUsuario());

                    MenuPrincipalUsuario.setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(rootPane, "Tipo de usuario desconocido");
                    this.setVisible(true);
            }

        } catch (UsuariosException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al iniciar sesión: " + ex);
        }

    }//GEN-LAST:event_IniciarSesionBotonMouseClicked

    private void RegistrarUsuarioBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarUsuarioBotonMouseClicked
        // TODO add your handling code here:
        String nombre_de_usuario = NombreDelNuevoDeUsuarioTextField.getText();
        String password = String.valueOf(ContrasenaDelNuevoUsuarioTextField.getPassword());
        TipoDeUsuario TipoDeUsurio;

        if (nombre_de_usuario.isBlank() || nombre_de_usuario.isEmpty() || password.isBlank() || password.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor llena todos los campos");
            return;
        }

        switch (TipoDeNuevoUsuarioComboBox.getSelectedItem().toString()) {
            case "Jugador":
                TipoDeUsurio = TipoDeUsuario.JUGADOR;
                break;

            case "Administrador":
                TipoDeUsurio = TipoDeUsuario.ADMINISTRADOR;
                break;

            default:
                JOptionPane.showMessageDialog(rootPane, "Opción Invalida");
                return;
        }

        Usuario nuevo_usuario = new Usuario(nombre_de_usuario, password, TipoDeUsurio, usuarios.getUsuario(usuarios.size()).getId() + 1);

        try {
            usuarios.agregarUsuario(nuevo_usuario);
        } catch (UsuariosException ex) {
            JOptionPane.showMessageDialog(rootPane, "Imposible de agregar usuario: " + ex);
        }

    }//GEN-LAST:event_RegistrarUsuarioBotonMouseClicked

    private void GuardarEdicionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarEdicionMouseClicked
        // TODO add your handling code here:
        String nuevo_nombre_de_usuario = EditarNombdeDeUsuarioTextField.getText();
        String nueva_contrasena = String.valueOf(EditarContrasenaTextField.getPassword());
        String _tipo = EditarTipoDeUsuarioComboBox.getSelectedItem().toString();
        TipoDeUsuario tipo;

        switch (_tipo) {
            case "Jugador":
                tipo = TipoDeUsuario.JUGADOR;
                break;
            case "Administrador":
                tipo = TipoDeUsuario.ADMINISTRADOR;
                break;
            default:
                JOptionPane.showMessageDialog(rootPane, "Tipo de usuario invalido");
                return;
        }

        if (nuevo_nombre_de_usuario.isBlank() || nuevo_nombre_de_usuario.isEmpty() || nueva_contrasena.isBlank() || nueva_contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No puedes tener un nombre de usuario ni contraseña en blanco");
            return;
        }

        try {
            usuarios.editarUsuario(usuario_seleccionado, nueva_contrasena, nueva_contrasena, tipo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Imposible editar usuario: " + ex);
        }

        EditarPerfil.setVisible(false);
        MenuPrincipalUsuario.setVisible(true);
    }//GEN-LAST:event_GuardarEdicionMouseClicked

    private void EditarPerfilBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditarPerfilBotonMouseClicked
        // TODO add your handling code here:
        MenuPrincipalUsuario.setVisible(false);
        EditarPerfil.setVisible(true);
    }//GEN-LAST:event_EditarPerfilBotonMouseClicked

    private void CancelarEdicionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarEdicionMouseClicked
        // TODO add your handling code here:
        EditarPerfil.setVisible(false);
        MenuPrincipalUsuario.setVisible(true);
    }//GEN-LAST:event_CancelarEdicionMouseClicked

    private void Iniciar4F1PBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Iniciar4F1PBotonMouseClicked
        // TODO add your handling code here:

        MenuPrincipalUsuario.setVisible(false);

        DificultadLabel.setText(DificultadComboBox.getSelectedItem().toString());
        LenguaLabel.setText(IdiomaComboBox.getSelectedItem().toString());

        Juego4F1P.setVisible(true);
    }//GEN-LAST:event_Iniciar4F1PBotonMouseClicked

    public void loadQuestion() {
        ImagenDelJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/" + palabras[currentQuestion] + ".jpg")));
        answerField.setText("");
    }

    private void answerFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerFieldActionPerformed
        String userAnswer = answerField.getText().trim().toLowerCase();
        String correctAnswer = palabras[currentQuestion];

        if (userAnswer.equals(correctAnswer)) {
            JOptionPane.showMessageDialog(this, "¡Correcto!");
            Juego4F1PPuntaje++;
            currentQuestion++; // Avanzar al siguiente nivel de juego
            loadQuestion(); // Cargar la nueva pregunta
        } else {
            JOptionPane.showMessageDialog(this, "Respuesta incorrecta. Intenta de nuevo.");
        }
        answerField.setText(""); // Limpiar el campo de respuesta
    }//GEN-LAST:event_answerFieldActionPerformed

    private void checkButtonjButtonVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonjButtonVerificarActionPerformed
        String userAnswer = answerField.getText().trim().toLowerCase();
        String correctAnswer = palabras[currentQuestion];

        if (userAnswer.equals(correctAnswer)) {
            JOptionPane.showMessageDialog(this, "¡Correcto!");
            Juego4F1PPuntaje++;
            currentQuestion++; // Avanzar al siguiente nivel de juego
            loadQuestion(); // Cargar la nueva pregunta
        } else {
            JOptionPane.showMessageDialog(this, "Respuesta incorrecta. Intenta de nuevo.");
        }
        answerField.setText(""); // Limpiar el camp

        if (currentQuestion == palabras.length) {
            JOptionPane.showMessageDialog(this, "Juego terminado. Felicidades.");
            Juego4F1P.setVisible(false);
            MenuPrincipalUsuario.setVisible(true);
        }
    }//GEN-LAST:event_checkButtonjButtonVerificarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void IniciarSopaDeLetrasBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniciarSopaDeLetrasBotonMouseClicked
        // TODO add your handling code here:
        txtJugador.setText(usuario_seleccionado.getNombreDeUsuario());

        word = new JLabel[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};
        load();

        MenuPrincipalUsuario.setVisible(false);
        JuegoSopaDeLetras.setVisible(true);
    }//GEN-LAST:event_IniciarSopaDeLetrasBotonMouseClicked

    private void btnDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadoActionPerformed
        turnos++;
        int x;
        x = (int) (Math.random() * (7 - 1) + 1);//genera numeros aleatorios del 1 al 6 para indicar el valor del dado y por ende el avance del jugador
        txt1.setText("" + x);//muestra el numero del dado que salio S

        JLabel Jugadores[] = {jugador1, jugador2, jugador3, jugador4, jugador5, jugador6, jugador7, jugador8, jugador9, jugador10, jugador11, jugador12, jugador13, jugador14, jugador15, jugador16, jugador17, jugador18, jugador19, jugador20, jugador21, jugador22, jugador23, jugador24, jugador25};

        /*
            No mamen, quien vergas hizo esto:
        
            Al chile no entendi ni madres que chingados quisieron hacer aqui, voy a remplazar por un 42
            y ver que jetas hace
         */
        int ju = 0;//(int) jugador.getJugador().size() - 1;//toma el tamaño del array es decir los datos guardados y le resta uno para localizar el ultimo jugador guardado ya que es el que actualmente esta jugando
        //segun la linea anterior se coloca el puntaje en el text field para que siempre aparezca segun se obtengan los puntos, al momento de aplanar el boton del dado
        txtPuntos.setText("" + ju);//"" + (int) jugador.getJugador().get(ju).get(2));
        /*Permanecera oculta la imagen jugador mientras no sea menor a 0
        cada que se genere un numero aleatorio en el dado se compara en este switch para ocultar la
        imagen del jugador actual y pasar a la siguiente casilla*/
        if (casilla > 0) {
            Jugadores[casilla - 1].setVisible(false);
        }
        /*'casilla' suma el numero que sale del dado (x) a la casilla donde se encuentra colocado el jugador,
        con esto ira en aumento y avanzando el jugador casilla a casilla encontrandose en ellas acertijos o
        castigos*/
        casilla += x;
        switch (casilla) {
            case 1 -> {
            }
            case 2 -> {
            }
            case 3 -> {
                //muestra un mensaje de pregunta y muestra la ventana de preguntas para generar puntos
                JOptionPane.showMessageDialog(this, "Casilla de pregunta");
                //abre la ventana de la pregunta
                Preguntas0 pantalla = new Preguntas0();
                pantalla.setVisible(true);
            }
            case 4 -> {
            }
            case 5 -> {
                //mensaje y posiciona en la casilla donde se indica
                JOptionPane.showMessageDialog(this, "Casilla especial, avanza 2");
                //le da nuevo valor a la casilla para incrementar cuando se lance el dado y lo posiciona en la nueva casilla.
                casilla = 7;
                jugador7.setVisible(true);
            }
            case 6 -> {
                JOptionPane.showMessageDialog(this, "Casilla de castigo, regresas 2 casillas");
                casilla = 4;
            }
            case 7 -> {
                jugador7.setVisible(true);
            }
            case 8 -> {
                jugador8.setVisible(true);
                JOptionPane.showMessageDialog(this, "Casilla especial, avanza 2");
                casilla = 10;
                jugador10.setVisible(true);
                jugador8.setVisible(false);
            }
            case 9 -> {
                jugador9.setVisible(true);
            }
            case 10 -> {
                jugador10.setVisible(true);
                JOptionPane.showMessageDialog(this, "Casilla de pregunta");
                Preguntas1 pantalla = new Preguntas1();
                pantalla.setVisible(true);
            }
            case 11 -> {
                jugador11.setVisible(true);
                JOptionPane.showMessageDialog(this, "Casilla especial, avanza 2");
                casilla = 13;
                jugador13.setVisible(true);
                jugador11.setVisible(false);
            }
            case 12 -> {
                jugador12.setVisible(true);
            }
            case 13 -> {
                jugador13.setVisible(true);
                JOptionPane.showMessageDialog(this, "Felicidades, casilla recompenza");
                int correcto = 5;
                txtPuntos.setText("" + ju);
                //jugador.puntos(correcto);
            }
            case 14 -> {
                jugador14.setVisible(true);
                JOptionPane.showMessageDialog(this, "Casilla de castigo, regresas 2 casillas");
                casilla = 12;
                jugador12.setVisible(true);
                jugador14.setVisible(false);
            }
            case 15 -> {
                jugador15.setVisible(true);
                JOptionPane.showMessageDialog(this, "Casilla de pregunta");
                Preguntas2 pantalla = new Preguntas2();
                pantalla.setVisible(true);
            }
            case 16 -> {
                jugador16.setVisible(true);
            }
            case 17 -> {
                jugador17.setVisible(true);
            }
            case 18 -> {
                jugador18.setVisible(true);
                JOptionPane.showMessageDialog(this, "Casilla de castigo, regresas 2 casillas");
                casilla = 16;
                jugador16.setVisible(true);
                jugador18.setVisible(false);
            }
            case 19 -> {
                jugador19.setVisible(true);
            }
            case 20 -> {
                jugador20.setVisible(true);
                JOptionPane.showMessageDialog(this, "Casilla especial, avanza 2");
                casilla = 22;
                jugador22.setVisible(true);
                jugador20.setVisible(false);
            }
            case 21 -> {
                jugador21.setVisible(true);
                JOptionPane.showMessageDialog(this, "Casilla de castigo, regresas 2 casillas");
                casilla = 19;
                jugador19.setVisible(true);
                jugador21.setVisible(false);
            }
            case 22 -> {
                jugador22.setVisible(true);
            }
            case 23 -> {
                jugador23.setVisible(true);
                JOptionPane.showMessageDialog(this, "Casilla de pregunta");
                Preguntas3 pantalla = new Preguntas3();
                pantalla.setVisible(true);
            }
            case 24 -> {
                jugador24.setVisible(true);
                JOptionPane.showMessageDialog(this, "Felicidades, casilla recompenza");
                int correcto = 5;
                ju += 5;
                txtPuntos.setText("" + ju);
                //jugador.puntos(correcto);
            }
            case 25 -> {
                jugador25.setVisible(true);
            }
        }
        //Al obtener el valor 25 en la casilla se hace la condicion donde genera el fin del juego al ocultar o mostrar mensajes e imagenes en especifico
        if (casilla == 25) {
            int correcto = 2;
            ju += 2;
            //jugador.puntos(correcto);
            btnDado.setVisible(false);
            jLabel28.setVisible(true);
            jugador25.setVisible(true);
            JOptionPane.showMessageDialog(this, "+2");
        } else if (casilla > 25) {
            //en caso de pasarse del numero de casillas es decir de 26 a mas se reiniciara el juego como castigo
            JOptionPane.showMessageDialog(this, "Te pasaste de la casilla!!\nPIERDES TUS PUNTOS!!!!!");
            casilla = 1;
            ju = 0;
            //sjugador.getJugador().get(ju).set(2, 0);
            //borra los puntos y se reinicia el tablero
            txtPuntos.setText("" + ju);
        }
    }//GEN-LAST:event_btnDadoActionPerformed

    private void IniciarTableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniciarTableroMouseClicked
        // TODO add your handling code here:
        MenuPrincipalUsuario.setVisible(false);
        JuegoTablero.setVisible(true);
    }//GEN-LAST:event_IniciarTableroMouseClicked

    public void checar() {
        JLabel res[] = {R1, R2, R3, R4};
        for (int i = 0; i < res.length; i++) {
            res[i].setEnabled(false);
        }

        if (seleccionada == respuesta[current]) {
            Res.setText("Respuesta: Correcta, +5");
            puntos += 5;
        } else {
            Res.setText("Respuesta: Incorrecta, -5");
            puntos -= 5;
        }

        SiguientePregunta.setEnabled(true);
    }

    private void Respuesta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Respuesta1MouseClicked
        // TODO add your handling code here:
        if (Respuesta1.isEnabled()) {
            seleccionada = 0;
            //opcion_seleccionada = 0;
            checar();
        }
    }//GEN-LAST:event_Respuesta1MouseClicked

    private void Respuesta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Respuesta2MouseClicked
        // TODO add your handling code here:
        if (Respuesta2.isEnabled()) {
            seleccionada = 1;
            //opcion_seleccionada = 1;
            checar();
        }
    }//GEN-LAST:event_Respuesta2MouseClicked

    private void Respuesta3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Respuesta3MouseClicked
        // TODO add your handling code here:
        if (Respuesta3.isEnabled()) {
            seleccionada = 2;
            //opcion_seleccionada = 2;
            checar();
        }
    }//GEN-LAST:event_Respuesta3MouseClicked

    private void Respuesta4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Respuesta4MouseClicked
        // TODO add your handling code here:
        if (Respuesta4.isEnabled()) {
            seleccionada = 3;
            //opcion_seleccionada = 3;
            checar();
        }
    }//GEN-LAST:event_Respuesta4MouseClicked

    private void SiguientePreguntaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiguientePreguntaMouseClicked
        // TODO add your handling code here:
        if (SiguientePregunta.isEnabled()) {
            if (1/*preguntas.getPreguntasRespondidas()*/ < 10) {
                //setPreguntaIntoForm();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Juego Terminado");
                // usuarios.editUser(usuario_seleccionado.getId(), usuario_seleccionado);
                this.setVisible(true);
                //Juego.setVisible(false);
            }
        }
    }//GEN-LAST:event_SiguientePreguntaMouseClicked

    void ponerTrivia(int index) {
        JugadorLabel.setText("Jugador: " + usuario_seleccionado.getNombreDeUsuario());
        TituloDeLaPregunta.setText(preguntas[index]);

        JLabel res[] = {R1, R2, R3, R4};
        for (int i = 0; i < res.length; i++) {
            res[i].setText(opciones[index][i]);
            res[i].setEnabled(true);
        }

        Res.setText("Respuesta: ");
        SiguientePregunta.setEnabled(false);

    }

    private void IniciarTriviaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniciarTriviaMouseClicked
        // TODO add your handling code here:
        MenuPrincipalUsuario.setVisible(false);

        Random rn = new Random();
        // Escogemos una pregunta al azar
        int index = rn.nextInt(preguntas.length - 0 + 1) + 0;
        current = index;
        ponerTrivia(index);
        puntos = 0;

        JuegoTrivia.setVisible(false);
    }//GEN-LAST:event_IniciarTriviaMouseClicked

    private void TablaDeUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDeUsuariosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaDeUsuariosMouseClicked

    private void EliminarUsuarioBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarUsuarioBotonMouseClicked
        // TODO add your handling code here:

        if (EliminarUsuarioTextField.getText().isBlank() || EliminarUsuarioTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor introduce un nombre");
            return;
        }

        try {
            usuarios.eliminarUsuario(EliminarUsuarioTextField.getText());
        } catch (UsuariosException ex) {
            JOptionPane.showMessageDialog(rootPane, "Usuario no encontrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Imposible elimnar usuario: " + ex);
        }

    }//GEN-LAST:event_EliminarUsuarioBotonMouseClicked

    private void IniciarSesionWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_IniciarSesionWindowClosing
        // TODO add your handling code here:
        IniciarSesion.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_IniciarSesionWindowClosing

    private void RegistrarseWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_RegistrarseWindowClosing
        // TODO add your handling code here:
        Registrarse.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_RegistrarseWindowClosing

    private void MenuPrincipalUsuarioWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_MenuPrincipalUsuarioWindowClosing
        // TODO add your handling code here:
        MenuPrincipalUsuario.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_MenuPrincipalUsuarioWindowClosing

    private void MenuPrincipalAdministradorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_MenuPrincipalAdministradorWindowClosing
        // TODO add your handling code here:
        MenuPrincipalAdministrador.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_MenuPrincipalAdministradorWindowClosing

    private void JuegoTableroWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_JuegoTableroWindowClosing
        // TODO add your handling code here:
        JuegoTablero.setVisible(false);

        // Lectura de puntos
        int puntos = Integer.parseInt(txtPuntos.getText());
        JOptionPane.showMessageDialog(rootPane, "Obtuviste un total de " + puntos);

        puntajes.addTablero(new Puntaje(usuario_seleccionado.getId(), puntos));

        MenuPrincipalUsuario.setVisible(true);
    }//GEN-LAST:event_JuegoTableroWindowClosing

    private void JuegoTriviaWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_JuegoTriviaWindowClosing
        // TODO add your handling code here:
        JuegoTrivia.setVisible(false);

        puntajes.addTrivia(new Puntaje(usuario_seleccionado.getId(), puntos));

        MenuPrincipalUsuario.setVisible(true);
    }//GEN-LAST:event_JuegoTriviaWindowClosing

    private void JuegoSopaDeLetrasWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_JuegoSopaDeLetrasWindowClosing
        // TODO add your handling code here:
        JuegoSopaDeLetras.setVisible(false);
        MenuPrincipalUsuario.setVisible(true);
    }//GEN-LAST:event_JuegoSopaDeLetrasWindowClosing

    private void Juego4F1PWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_Juego4F1PWindowClosing
        // TODO add your handling code here:
        Juego4F1P.setVisible(false);
        MenuPrincipalUsuario.setVisible(true);
    }//GEN-LAST:event_Juego4F1PWindowClosing

    private void IniciarMemoramaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniciarMemoramaMouseClicked
        // TODO add your handling code here:

        // MEMORAMA
        Memorama mem = new Memorama();
        mem.setVisible(true);
    }//GEN-LAST:event_IniciarMemoramaMouseClicked

    private void IniciarTraduccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniciarTraduccionMouseClicked
        // TODO add your handling code here:
        Random rn = new Random();
        // Escogemos una pregunta al azar
        current = rn.nextInt(original.length - 0 + 1) + 0;
        puntos = 0;

        ponerTrad();
        this.setVisible(false);
        Trad.setVisible(true);
    }//GEN-LAST:event_IniciarTraduccionMouseClicked

    private void ComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprobarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComprobarActionPerformed

    void ponerTrad() {
        Random rn = new Random();
        // Escogemos una pregunta al azar
        current = rn.nextInt(original.length - 0 + 1) + 0;
        oracion.setText(original[current]);
    }

    private void ComprobarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComprobarMouseClicked
        // TODO add your handling code here:

        if (Respuesta.getText().isBlank() || Respuesta.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor responde la actividad");
            return;
        }

        if (Respuesta.getText().equals(traduccion[current])) {
            JOptionPane.showMessageDialog(rootPane, "¡Respuesta correcta! +10");
            puntos += 10;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Respuesta incorrecta :( -1");
            puntos -= 1;
        }

        ponerTrad();


    }//GEN-LAST:event_ComprobarMouseClicked

    private void TradWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_TradWindowClosing
        // TODO add your handling code here:
        Trad.setVisible(false);
        MenuPrincipalUsuario.setVisible(true);

        puntajes.addTraduccion(new Puntaje(usuario_seleccionado.getId(), puntos));

        this.setVisible(false);
    }//GEN-LAST:event_TradWindowClosing

    public void load() {
        win = false;
        iniciox = new int[10];
        inicioy = new int[10];
        direccion = new boolean[10];
        celdas();
        colocarpalabras();
        emptyspaces();
    }

    public void celdas() {
        letra = new JLabel[10][14];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                letra[i][j] = new JLabel("", javax.swing.SwingConstants.CENTER);
                letra[i][j].setName("");
                letra[i][j].setBackground(Color.WHITE);
                letra[i][j].setFont(new java.awt.Font("Segoe UI Symbol", 1, 14));
                letra[i][j].setForeground(new java.awt.Color(0, 5, 2));
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

    public void pressclick(java.awt.event.MouseEvent event) {
        if (!win) {
            if (event.getComponent().getBackground().equals(Color.WHITE)) {
                event.getComponent().setBackground(new java.awt.Color(51, 51, 255));
                cross();
            }
        } else if (event.getComponent().getName().equals("")) {
            event.getComponent().setBackground(Color.WHITE);
        }
    }

    public void cross() {
        for (int i = 0; i < 10; i++) {
            if (!word[i].getText().substring(0, 1).equals("<")) {
                if (crossletra(iniciox[i], inicioy[i], word[i].getText().length(), direccion[i])) {
                    word[i].setText("<html><body><s>" + word[i].getText() + "</s></body><htmil>");
                    break;
                }
            }
        }
        boolean aux = true;
        for (int i = 0; i < letra.length; i++) {
            if (!word[i].getText().substring(0, 1).equals("<")) {
                aux = false;
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

    public boolean crossletra(int x, int y, int size, boolean dir) {
        boolean answ = true;
        if (dir) {
            for (int i = y; i < size + y; i++) {
                if (letra[x][i].getBackground().equals(Color.WHITE)) {
                    answ = false;
                    break;
                }
            }
        } else {
            for (int j = y; j < y - size; j--) {
                if (letra[x][j].getBackground().equals(Color.WHITE)) {
                    answ = false;
                    break;
                }
            }
        }
        return answ;
    }

    public void colocarpalabras() {
        String palabra[] = {p1.getText(), p2.getText(), p3.getText(), p4.getText(), p5.getText(), p6.getText(), p7.getText(), p8.getText(), p9.getText(), p10.getText()};
        Random r = new Random();
        int startx = 0, starty;
        int[] unico = norepeticiones(10);
        iniciox = unico;

        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i].length() < 14) {
                startx = unico[i];
                starty = (int) (r.nextDouble() * 14 - 1);
                int ext = 0;
                if (starty + palabra[i].length() < 14) {
                    for (int j = starty; j < starty + palabra[i].length(); j++) {
                        letra[startx][j].setText(palabra[i].substring(ext, ext + 1));
                        letra[startx][j].setName("l");
                        ext++;
                        inicioy[i] = starty;
                        direccion[i] = true;
                    }
                } else if (starty - palabra[i].length() > 0) {
                    for (int j = starty; j > starty - palabra[i].length(); j--) {
                        letra[startx][j].setText(palabra[i].substring(ext, ext + 1));
                        letra[startx][j].setName("1");
                        ext++;
                        inicioy[i] = starty;
                        direccion[i] = false;
                    }
                }
            }
        }
    }

    public int[] norepeticiones(int n) {
        int[] numeros = new int[n];
        for (int i = 0; i < n; i++) {
            numeros[i] = -1;
        }
        Random r = new Random();
        boolean aux;
        int num = 0;
        for (int x = 0; x < n; x++) {
            aux = true;
            while (aux) {
                aux = false;
                num = (int) (r.nextDouble() * 11 - 1);
                for (int j = 0; j < numeros.length; j++) {
                    if (numeros[j] == num) {
                        aux = true;
                        break;
                    }
                }
            }
            numeros[x] = num;
        }
        return numeros;
    }

    public void emptyspaces() {
        String[] abc = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                if (letra[i][j].getText().equals("")) {
                    letra[i][j].setText(abc[r.nextInt(25 + 1 - 1) + 1]);
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarEdicion;
    private javax.swing.JButton Comprobar;
    private javax.swing.JPasswordField ContrasenaDelNuevoUsuarioTextField;
    private javax.swing.JPasswordField ContrasenaDelUsuarioTextField;
    private javax.swing.JComboBox<String> DificultadComboBox;
    private javax.swing.JTextField DificultadLabel;
    private javax.swing.JPasswordField EditarContrasenaTextField;
    private javax.swing.JTextField EditarNombdeDeUsuarioTextField;
    private javax.swing.JFrame EditarPerfil;
    private javax.swing.JButton EditarPerfilBoton;
    private javax.swing.JComboBox<String> EditarTipoDeUsuarioComboBox;
    private javax.swing.JButton EliminarUsuarioBoton;
    private javax.swing.JTextField EliminarUsuarioTextField;
    private javax.swing.JPanel Estadisticas4F1P;
    private javax.swing.JPanel EstadisticasSopaDeLetras;
    private javax.swing.JPanel EstadisticasTablero;
    private javax.swing.JPanel EstadisticasTrivia;
    private javax.swing.JToggleButton GuardarEdicion;
    private javax.swing.JPanel Herramientas;
    private javax.swing.JComboBox<String> IdiomaComboBox;
    private javax.swing.JLabel ImagenDelJuego;
    private javax.swing.JButton Iniciar4F1PBoton;
    private javax.swing.JButton IniciarMemorama;
    private javax.swing.JFrame IniciarSesion;
    private javax.swing.JToggleButton IniciarSesionBoton;
    private javax.swing.JButton IniciarSopaDeLetrasBoton;
    private javax.swing.JButton IniciarTablero;
    private javax.swing.JButton IniciarTraduccion;
    private javax.swing.JButton IniciarTrivia;
    private javax.swing.JButton IrAIniciarSesionBoton;
    private javax.swing.JButton IrARegistrarseBoton;
    private javax.swing.JLabel J4F1PUsuario;
    private javax.swing.JLabel J4G1PPuntos;
    private javax.swing.JFrame Juego4F1P;
    private javax.swing.JFrame JuegoSopaDeLetras;
    private javax.swing.JFrame JuegoTablero;
    private javax.swing.JFrame JuegoTrivia;
    private javax.swing.JLabel JugadorLabel;
    private javax.swing.JTextField LenguaLabel;
    private javax.swing.JPanel LoginFondo;
    private javax.swing.JLabel MemoramaPuntos;
    private javax.swing.JTable MemoramaTabla;
    private javax.swing.JLabel MemoramaUsuario;
    private javax.swing.JFrame MenuPrincipalAdministrador;
    private javax.swing.JFrame MenuPrincipalUsuario;
    private javax.swing.JLabel NombreDeUsuarioLabel;
    private javax.swing.JTextField NombreDeUsuarioTextField;
    private javax.swing.JTextField NombreDelNuevoDeUsuarioTextField;
    private javax.swing.JPanel PanelPrincipal7;
    private javax.swing.JLabel R1;
    private javax.swing.JLabel R2;
    private javax.swing.JLabel R3;
    private javax.swing.JLabel R4;
    private javax.swing.JToggleButton RegistrarUsuarioBoton;
    private javax.swing.JFrame Registrarse;
    private javax.swing.JLabel Res;
    private javax.swing.JTextField Respuesta;
    private javax.swing.JButton Respuesta1;
    private javax.swing.JButton Respuesta2;
    private javax.swing.JButton Respuesta3;
    private javax.swing.JButton Respuesta4;
    private javax.swing.JLabel ResultadoDeLaPregunta;
    private javax.swing.JButton SiguientePregunta;
    private javax.swing.JLabel SopaDeLetrasPuntaje;
    private javax.swing.JTable SopaDeLetrasTabla;
    private javax.swing.JLabel SopaDeLetrasUsuario;
    private javax.swing.JTable TablaDeUsuarios;
    private javax.swing.JLabel TableroPuntos;
    private javax.swing.JLabel TableroUsuario;
    private javax.swing.JComboBox<String> TipoDeNuevoUsuarioComboBox;
    private javax.swing.JLabel TituloDeLaPregunta;
    private javax.swing.JLabel TituloDeLaVentana;
    private javax.swing.JFrame Trad;
    private javax.swing.JLabel TraduccionPuntos;
    private javax.swing.JTable TraduccionTabla;
    private javax.swing.JLabel TraduccionUsuario;
    private javax.swing.JLabel TriviaPuntaje;
    private javax.swing.JTabbedPane TriviaTabla;
    private javax.swing.JLabel TriviaUsuario;
    private javax.swing.JTextField answerField;
    private javax.swing.JButton btnDado;
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel jugador1;
    private javax.swing.JLabel jugador10;
    private javax.swing.JLabel jugador11;
    private javax.swing.JLabel jugador12;
    private javax.swing.JLabel jugador13;
    private javax.swing.JLabel jugador14;
    private javax.swing.JLabel jugador15;
    private javax.swing.JLabel jugador16;
    private javax.swing.JLabel jugador17;
    private javax.swing.JLabel jugador18;
    private javax.swing.JLabel jugador19;
    private javax.swing.JLabel jugador2;
    private javax.swing.JLabel jugador20;
    private javax.swing.JLabel jugador21;
    private javax.swing.JLabel jugador22;
    private javax.swing.JLabel jugador23;
    private javax.swing.JLabel jugador24;
    private javax.swing.JLabel jugador25;
    private javax.swing.JLabel jugador3;
    private javax.swing.JLabel jugador4;
    private javax.swing.JLabel jugador5;
    private javax.swing.JLabel jugador6;
    private javax.swing.JLabel jugador7;
    private javax.swing.JLabel jugador8;
    private javax.swing.JLabel jugador9;
    private javax.swing.JLabel oracion;
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
    private javax.swing.JPanel panel10;
    private javax.swing.JPanel panel11;
    private javax.swing.JPanel panel13;
    private javax.swing.JPanel panel14;
    private javax.swing.JPanel panel15;
    private javax.swing.JPanel panel16;
    private javax.swing.JPanel panel17;
    private javax.swing.JPanel panel18;
    private javax.swing.JPanel panel19;
    private javax.swing.JPanel panel20;
    private javax.swing.JPanel panel21;
    private javax.swing.JPanel panel22;
    private javax.swing.JPanel panel23;
    private javax.swing.JPanel panel24;
    private javax.swing.JPanel panel25;
    private javax.swing.JPanel panel31;
    private javax.swing.JPanel panel32;
    private javax.swing.JPanel panel33;
    private javax.swing.JPanel panel34;
    private javax.swing.JPanel panel35;
    private javax.swing.JPanel panel36;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel panel8;
    private javax.swing.JPanel panel9;
    private javax.swing.JPanel sup;
    private javax.swing.JTable tableroTabla;
    private javax.swing.JTable triviaTabla;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txtJugador;
    private javax.swing.JTextField txtPuntos;
    // End of variables declaration//GEN-END:variables
}
