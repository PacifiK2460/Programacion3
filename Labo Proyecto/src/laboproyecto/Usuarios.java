/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package laboproyecto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;

/**
 *
 * @author 177685
 */
public class Usuarios {

    // Keep track of ids
    private static int last_id = 99;
    private static int preguntas_respondidas = 0;

    private static ArrayList<Usuario> usuarios = new ArrayList<>();

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

        double saldo = ThreadLocalRandom.current().nextInt(100, 800 + 1);

        Usuario new_user = new Usuario(id, user_name, saldo);
        boolean add = usuarios.add(new_user);

        return add;
    }

    public boolean deleteUser(int id) {

        Optional<Usuario> _usuario_a_eliminar = usuarios.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst();

        if (_usuario_a_eliminar.isEmpty()) {
            return false;
        }

        Optional<Usuario> _usuario_con_menor_saldo = usuarios.stream().min(Comparator.comparing(Usuario::getSaldo));

        if (_usuario_con_menor_saldo.isEmpty()) {
            return false;
        }

        Usuario usuario_a_eliminar = _usuario_a_eliminar.get();
        Usuario usuario_con_menor_saldo = _usuario_con_menor_saldo.get();
        int index_usuario_con_menor_saldo = usuarios.indexOf(usuario_con_menor_saldo);

        usuario_con_menor_saldo.setSaldo(usuario_con_menor_saldo.getSaldo() + ( usuario_a_eliminar.getSaldo() * 0.1));

        usuarios.set(index_usuario_con_menor_saldo, usuario_con_menor_saldo);
        return usuarios.remove(usuario_a_eliminar);
    }

    public Usuario getUser(int index) {
        return usuarios.get(index);
    }

    public boolean isEmpty() {
        return usuarios.isEmpty();
    }

    public TableModel toTableModel() {
        // Create a 2D array to hold the data
        Object[][] data = new Object[usuarios.size()][3];

        // Fill the array with data from the ArrayList
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario user = usuarios.get(i);
            data[i][0] = user.getId();
            data[i][1] = user.getUserName();
            data[i][2] = user.getSaldo();
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

    public ComboBoxModel toComboBoxModel() {
        Object[] UserNames = usuarios.stream().map(Usuario::getUserName).collect(Collectors.toList()).toArray();
        ComboBoxModel comboBoxModel = new DefaultComboBoxModel(UserNames);
        return comboBoxModel;
    }

}
