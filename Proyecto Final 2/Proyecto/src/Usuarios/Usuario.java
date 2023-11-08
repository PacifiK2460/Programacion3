/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

/**
 *
 * @author 177685
 */
public class Usuario {

    private String nombre_de_usuario;
    private String password;
    private TipoDeUsuario tipoDeUsuario;

    public Usuario(String nombre_de_usuario, String password, TipoDeUsuario tipoDeUsuario) {
        this.nombre_de_usuario = nombre_de_usuario;
        this.password = password;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getNombreDeUsuario() {
        return this.nombre_de_usuario;
    }

    public String getPassword() {
        return this.password;
    }

    public TipoDeUsuario getTipoDeUsuario() {
        return this.tipoDeUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre_de_usuario = nombre;
    }

    public void setPass(String contra) {
        this.password = contra;
    }

    public void setTipo(TipoDeUsuario tipo) {
        this.tipoDeUsuario = tipo;
    }

}
