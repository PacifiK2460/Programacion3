/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import java.util.ArrayList;

/**
 *
 * @author 177685
 */
public class Usuarios {

    private ArrayList<Usuario> usuarios;

    public Usuarios() {
        this.usuarios = new ArrayList<>();

        // TODO, lectura de usuarios en base de datos
        // Por ahora solo metemos usuarios al azar
        usuarios.add(new Usuario("admin", "admin", TipoDeUsuario.ADMINISTRADOR));
        usuarios.add(new Usuario("jugador", "jugador", TipoDeUsuario.JUGADOR));
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
    }

    public void editarUsuario(Usuario usuario_a_editar, String nuevo_nombre, String nueva_contra, TipoDeUsuario nuevo_tipo) {
        int index_de_usuario = usuarios.indexOf(usuario_a_editar);

        usuario_a_editar.setNombre(nuevo_nombre);
        usuario_a_editar.setPass(nueva_contra);
        usuario_a_editar.setTipo(nuevo_tipo);

        // TODO: Demas modificaciones en base de datos
        usuarios.set(index_de_usuario, usuario_a_editar);

    }
}
