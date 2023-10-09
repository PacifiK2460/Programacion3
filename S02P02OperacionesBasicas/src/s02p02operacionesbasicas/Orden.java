package s02p02operacionesbasicas;

public class Orden{
    Comida Comida[];

    public Orden() {
        this.Comida = new Comida[0];
    }

    public Orden(Comida[] Comida) {
        this.Comida = Comida;
    }

    public void RestarUltimo() {
        Comida[] Comida = new Comida[this.Comida.length - 1];
        for (int i = 0; i < Comida.length; i++) {
            Comida[i] = this.Comida[i];
        }
        this.Comida = Comida;
    }

    public void AgregarComida(Comida Comida) {
        Comida[] Comida = new Comida[this.Comida.length + 1];
        for (int i = 0; i < this.Comida.length; i++) {
            Comida[i] = this.Comida[i];
        }
        Comida[Comida.length - 1] = Comida;
        this.Comida = Comida;
    }

    public Orden[] DividirComida(int nOrdenes, Comida[] comida){
        Orden[] ordenes = new Orden[nOrdenes];
        for(int i = 0; i < nOrdenes; i++){
            ordenes[i] = comida[i];
        }

        return ordenes;
    }

    public void MultiplicarComida(int nOrdenes){
        // Se regresa un arreglo de la misma orden multiplicado por nOrdenes
        Comida[] comida = new Comida[this.Comida.length * nOrdenes];
        for(int i = 0; i < nOrdenes; i++){
            for(int j = 0; j < this.Comida.length; j++){
                comida[i * this.Comida.length + j] = this.Comida[j];
            }
        }

        this.Comida = comida;
    }

}