package s01p02primerasclases;

public class Lara_Persona {
    public String nombre;
    public String apellido;
    public int edad;

    public Lara_Persona(String nombre, String apellido, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public void saludar(){
        System.out.println("Hola, mi nombre es " + this.nombre + " " + this.apellido + " y tengo " + this.edad + " años.");
    }

    public void despedirse(){
        System.out.println("Adios, mi nombre es " + this.nombre + " " + this.apellido + " y tengo " + this.edad + " años.");
    }
}
