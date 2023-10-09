package s02p02operacionesbasicas;

public class Comida {
    String Nombre;
    int Precio;

    public Comida() {
        this.Nombre = "";
        this.Precio = 0;
    }

    public Comida(String Nombre, int Precio) {
        this.Nombre = Nombre;
        this.Precio = Precio;
    }
}