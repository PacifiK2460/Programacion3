package s03p03estructurasbasicas;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public String toString() {
        String mensaje = "Nombre: " + this.nombre + " es un ";
        
        if(this.edad <= 12){
            mensaje += "niño";
        } else if(this.edad <= 45){
            mensaje += "joven";
        } else {
            mensaje += "adulto";
        }
        
        return mensaje;
    }

}
