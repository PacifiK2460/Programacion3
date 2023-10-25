/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboproyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author 177685
 */
public class Usuarios {

    // Keep track of ids
    private static int last_id;

    private class Usuario implements Comparable<Usuario> {

        private final int id;
        private final String user_name;
        private double saldo;

        public Usuario(int id, String user_name, double saldo) {
            this.id = id;
            this.user_name = user_name;
            this.saldo = saldo;
        }

        public int getId() {
            return id;
        }

        public String getUserName() {
            return user_name;
        }

        public double getSaldo() {
            return saldo;
        }

        @Override
        public int compareTo(Usuario t) {
            if (this.saldo < t.saldo) {
                return -1;
            } else if (this.saldo == t.saldo) {
                return 0;
            } else {
                return 1;
            }
        }

    }

    private static ArrayList<Usuario> usuarios;

    public Usuarios() {
        Usuarios.last_id = 99;
        usuarios = new ArrayList<>();
    }

    public boolean addUser() {
        last_id += 1;
        int id = last_id;

        String user_name = new String();

        char CaracteresEspeciales[] = {'¡', '#', '$', '&', '/', '?', '¿', '!', '.', '_'};

        user_name += (char) ThreadLocalRandom.current().nextInt('A', 'Z' + 1);
        user_name += (char) ThreadLocalRandom.current().nextInt('a', 'z' + 1);
        user_name += (char) ThreadLocalRandom.current().nextInt('a', 'z' + 1);
        user_name += (char) ThreadLocalRandom.current().nextInt('a', 'z' + 1);
        user_name += ThreadLocalRandom.current().nextInt(0, 9 + 1);
        user_name += ThreadLocalRandom.current().nextInt(0, 9 + 1);
        user_name += ThreadLocalRandom.current().nextInt(0, 9 + 1);
        user_name += (char) CaracteresEspeciales[ThreadLocalRandom.current().nextInt(0, CaracteresEspeciales.length + 1)];
        user_name += (char) ThreadLocalRandom.current().nextInt('A', 'Z' + 1);

        double saldo = ThreadLocalRandom.current().nextInt(100, 800 + 1);;

        Usuario new_user = new Usuario(id, user_name, saldo);
        boolean add = usuarios.add(new_user);

        return add;
    }

    public boolean deleteUser(int id) {

        Optional<Usuario> _usuario_a_eliminar = usuarios.stream()
                .filter(usuario -> usuario.id == id)
                .findFirst();

        if (_usuario_a_eliminar.isEmpty()) {
            return false;
        }

        Optional<Usuario> _usuario_con_menor_saldo = usuarios.stream().min(Comparator.comparing(Usuario::getSaldo));

        if (_usuario_con_menor_saldo.isEmpty()) {
            return false;
        }

        Usuario usuario_a_eliminar = _usuario_a_eliminar.get();
        int index_usuario_a_eliminar = usuarios.indexOf(usuario_a_eliminar);
        Usuario usuario_con_menor_saldo = _usuario_con_menor_saldo.get();
        int index_usuario_con_menor_saldo = usuarios.indexOf(usuario_con_menor_saldo);

        usuario_con_menor_saldo.saldo += usuario_a_eliminar.saldo * 0.1;

        usuarios.set(index_usuario_con_menor_saldo, usuario_con_menor_saldo);
        return usuarios.remove(usuario_a_eliminar);
    }

    public TableModel toTableModel() {
        // Create a 2D array to hold the data
        Object[][] data = new Object[usuarios.size()][3];

        // Fill the array with data from the ArrayList
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario user = usuarios.get(i);
            data[i][0] = user.id;
            data[i][1] = user.user_name;
            data[i][2] = user.saldo;
        }

        // Create the TableModel
        TableModel tableModel = new javax.swing.table.DefaultTableModel(
                data,
                new String[]{
                    "ID", "Usuario", "Saldo"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        return tableModel;
    }

}
