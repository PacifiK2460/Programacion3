/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import DataBase.*;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.sql.Connection;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author 177685
 */
public class Usuarios {

    private static DataBase conexion = new DataBase();
    private ArrayList<Usuario> usuarios;

    public Usuarios(Component rootPane) throws SQLException, AssertionError {
        this.usuarios = new ArrayList<>();

        String query = "SELECT * FROM usuarios";
        java.sql.Statement st = null;
        try {
            st = conexion.conectar("jdbc:mysql://localhost:3306/juego", "java", "java").createStatement();
        } catch (DataBaseException ex) {
            throw new SQLException("Imposible conectar a la base de Datos", query, ex);
        }

        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            throw new SQLException("Imposible leer resultados", query, ex);
        }

        while (rs.next()) {
            TipoDeUsuario tipo;

            switch (rs.getString("nivel")) {
                case "admin":
                    tipo = TipoDeUsuario.ADMINISTRADOR;
                    break;
                case "jugador":
                    tipo = TipoDeUsuario.JUGADOR;
                    break;
                default:
                    throw new AssertionError("Tipo de jugador desconocido.");
            }

            usuarios.add(new Usuario(rs.getString("user"), rs.getString("password"), tipo));
        }
    }

    public Usuarios() {
        this.usuarios = new ArrayList<>();
    }

    public Usuario login(String nombre_de_usuario, String password) throws UsuariosException {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreDeUsuario().equals(nombre_de_usuario) && usuarios.get(i).getPassword().equals(password)) {
                return usuarios.get(i);
            } else if (usuarios.get(i).getNombreDeUsuario().equals(nombre_de_usuario) && !usuarios.get(i).getPassword().equals(password)) {
                throw new UsuariosException("Contraseña incorrecta");
            }
        }

        throw new UsuariosException("Usuario no encontrado");
    }

    public void agregarUsuario(Usuario nuevo_usuario) throws UsuariosException {
        if (!usuarios.add(nuevo_usuario)) {
            throw new UsuariosException("Imposible agregar usuario");
        }

        try {
            String consulta = "IINSERT INTO `usuarios`(`user`, `password`, `nivel`) VALUES ('" + nuevo_usuario.getNombreDeUsuario() + "','" + nuevo_usuario.getPassword() + "','" + ((nuevo_usuario.getTipoDeUsuario() == TipoDeUsuario.ADMINISTRADOR) ? "admin" : "jugador") + "')";
            //PreparedStatement ps = (PreparedStatement) conexion.PreparedStatement(consulta);
            //ps.excuteUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el guardado de los datos" + e);
        }
    }

    public void editarUsuario(Usuario usuario_a_editar, String nuevo_nombre, String nueva_contra, TipoDeUsuario nuevo_tipo) {
        int index_de_usuario = usuarios.indexOf(usuario_a_editar);

        usuario_a_editar.setNombre(nuevo_nombre);
        usuario_a_editar.setPass(nueva_contra);
        usuario_a_editar.setTipo(nuevo_tipo);

        // TODO: Demas modificaciones en base de datos
        usuarios.set(index_de_usuario, usuario_a_editar);

    }

    public TableModel toTableModel() {
        // Create a 2D array to hold the data
        Object[][] data = new Object[usuarios.size()][2];

        // Fill the array with data from the ArrayList
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario user = usuarios.get(i);
            data[i][0] = user.getNombreDeUsuario();
            data[i][1] = user.getPassword();
        }

        // Create the TableModel
        TableModel tableModel = new javax.swing.table.DefaultTableModel(
                data,
                new String[]{
                    "Nombre de Usuario", "Contraseña"
                }
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return true;
            }

            public void setValueAt(Object object, int row, int col) {
                super.setValueAt(object, row, col);

                int index_del_usuario_a_modificar = row;
                Usuario usuario_a_modificar = usuarios.get(index_del_usuario_a_modificar);

                String nuevo_nombre = usuario_a_modificar.getNombreDeUsuario(), nueva_pass = usuario_a_modificar.getPassword();

                switch (col) {
                    case 0:
                        nuevo_nombre = object.toString();
                        break;
                    case 1:
                        nueva_pass = object.toString();
                        break;
                    default:
                        return;
                }

                editarUsuario(usuario_a_modificar, nuevo_nombre, nueva_pass, usuario_a_modificar.getTipoDeUsuario());

            }
        };

        return tableModel;
    }

    public void eliminarUsuario(String nombre) throws UsuariosException {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreDeUsuario().equals(nombre)) {
                usuarios.remove(i);
            }
        }
        
        throw new UsuariosException("Usuario no encontrado");
    }
}
