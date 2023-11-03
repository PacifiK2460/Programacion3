package proyectolabo;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 176453
 */
public class Usuarios {

    private static int ult_Id;
    ArrayList<Usuario> usuarios = new ArrayList();

    public Usuarios() {
        ult_Id = 99;
    }

    public void AgregarUsuario() {
        int nuevoID = ult_Id + 1;

        ult_Id = ult_Id + 1;

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

        Usuario nuevo_usuario = new Usuario(ult_Id, user_name, saldo);
        usuarios.add(nuevo_usuario);
    }

    public int size() {
        return usuarios.size();
    }

    public Usuario get(int i) {
        return usuarios.get(i);
    }
}
