package s04p02arregloobjetos;

public class Alumno {
    private String matricula;
    private float[] calificacion;

    public Alumno(String matricula, float[] calificacion){
        this.matricula = matricula;
        this.calificacion = calificacion;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public float getPromedio(){
        float total = this.calificacion[0] + this.calificacion[1] + this.calificacion[2];
        return total;
    }
}
