/* Universidad Politecnica de San Luis Potosi
 * Practica 8 Practica Integradora Parte 1
 * 180408 / Marlen Victoria Silva Castillo
 * Grupo: A     Horario: 4:00-6:00
 * Fecha: 16/10/23
 */
package pkg177185_p12p3b;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;

public class Usuarios {

    private ArrayList<Usuario> usuariosList = new ArrayList<>();
    private static int last_id = 99;

    public ArrayList<Usuario> getUsuariosList() {
        return usuariosList;
    }

    public void addUsuario() {
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
        usuariosList.add(new_user);
    }

    public Usuario get(int i) {
        return usuariosList.get(i);
    }

    public int size() {
        return usuariosList.size();
    }

    public void remove(Usuario u) {
        usuariosList.remove(u);
    }

    public Usuario get(String name) {
        for (Usuario user : usuariosList) {
            if (user.getUser_name().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void set(Usuario old) {
        int index = -1;
        for (int i = 0; i < usuariosList.size(); i++) {
            if (usuariosList.get(i).getId() == old.getId()) {
                index = i;
            }
        }

        if (index == -1) {
            return;
        }

        usuariosList.set(index, old);
    }

}
