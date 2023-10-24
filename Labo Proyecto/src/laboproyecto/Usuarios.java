/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboproyecto;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 177685
 */
public class Usuarios {

    // Keep track of ids
    private static int last_id;

    private class Usuario {

        private final int id;
        private final String user_name;
        private final double saldo;

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
        int len = usuarios.size();
        for (int user = 0; user < len; user++) {
            if (usuarios.get(user).id == id) {
                Usuario deleted = usuarios.remove(user);

                // TODO! Donar el 10% del saldo al usuario mas bajo.
                return true;
            }
        }

        return false;
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
