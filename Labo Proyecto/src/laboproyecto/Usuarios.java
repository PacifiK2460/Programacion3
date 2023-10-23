/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboproyecto;

import java.util.ArrayList;
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

    private class UsuariosTableModel implements TableModel {

        @Override
        public int getRowCount() {
            return usuarios.size();
        }

        @Override
        public int getColumnCount() {
            return usuarios.getClass().getDeclaredFields().length;
        }

        @Override
        public String getColumnName(int i) {
            return usuarios.getClass().getDeclaredFields()[i].toString();
        }

        @Override
        public Class<?> getColumnClass(int i) {
            return usuarios.getClass().getDeclaredFields()[i].getClass();
        }

        @Override
        public boolean isCellEditable(int i, int i1) {
            return false;
        }

        @Override
        public Object getValueAt(int i, int i1) {
            Usuario user = usuarios.get(i);

            switch (i1) {
                case 0 -> {
                    return user.id;
                }
                case 1 -> {
                    return user.user_name;
                }
                case 2 -> {
                    return user.saldo;
                }
                default -> {
                    return null;
                }
            }
        }

        @Override
        public void setValueAt(Object o, int i, int i1) {
            usuarios.set(i, element);
            
        }

        @Override
        public void addTableModelListener(TableModelListener tl) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void removeTableModelListener(TableModelListener tl) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

    public TableModel toTableModel() {
        TableModel data = new MyTableModel();
    }

}
