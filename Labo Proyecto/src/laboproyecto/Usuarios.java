/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboproyecto;

import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

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
        Usuarios.last_id = 100;
        usuarios = new ArrayList<>();
    }

    public boolean addUser() {
        // TODO: Generate user data

        int id = last_id + 1;
        String user_name = "usuario";
        double saldo = 0;

        Usuario new_user = new Usuario(id, user_name, saldo);
        boolean add = usuarios.add(new_user);

        return add;
    }

    public boolean deleteUser(int id) {
        int len = usuarios.size();
        for (int user = 0; user < len; user++) {
            if (usuarios.get(user).id == id) {
                usuarios.remove(user);
                return true;
            }
        }
        return false;
    }

    public TableModel toTableModel() {

        TableModel data = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    usuarios.stream().map(u -> u.id).collect(Collectors.toList()),
                    {null, null, null},
                    {null, null, null}
                },
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

        return data;
    }

}