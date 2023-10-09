public class Matraca {
    private String marca;
    private String modelo;
    private float precio;

    public Matraca(String marca, String modelo, float precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        if (modelo.length() > 3) {
            this.modelo = modelo;
        } else {
            System.out.println("El modelo debe tener al menos 3 caracteres");
        }
    }

    public void setPrecio(float precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.out.println("El precio debe ser mayor a 0");
        }
    }
}
