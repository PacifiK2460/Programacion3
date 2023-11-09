/*
 *  Universidad Politecnica de San Luis Potosi
 *  Programacion III java
 *  Programacion Orientada a Objetos
 */
package proyectovideojuego;
import java.util.ArrayList;
/**
 *
 */
public class Jugador 
{
    //crear array para guardar tanto a los jugadores como a los puntos que estos obtengan a lo largo de sus juegos
    private ArrayList <ArrayList<Object>> jugador = new ArrayList< >();
    
    //metodo para guardar al jugador
    public void ingresa(String nombre, int clave){
        int j=0;
        for(int i=0; i<getJugador().size(); i++){//compara la informacion introducida por el jugador con la guardada en el array dependiendo del tamaño de este 
            if(clave != (int)getJugador().get(i).get(1)){//use una clave para el jugador por dos razones
                j+=1;                                               //1.- para que se guardara sin repetirse la informacion y se gurdaran en orden
            }                                                       //2.- para indentificar mas facil al jugador al momento de guardar el puntaje
        }
        //se guarda el nombre y la clave del jugador en la posicion donde se queda el contador de j 
        getJugador().add(new ArrayList<>());
        getJugador().get(j).add(nombre);
        getJugador().get(j).add(clave);
        //se guardan cero puntos para el posterior metodo donde se guarden los puntos que vaya ganando
        getJugador().get(j).add(0);        
    }
    
    //metodo que guarda los puntos que gana el jugador
    public void puntos(int correcto){   //se usa la variable de punto para incrementar los puntos en la posicion donde se encuentra el jugador
        int j=(int)getJugador().size() - 1;//toma el tamaño del array es decir los datos guardados y le resta uno para localizar el ultimo jugador guardado ya que es el que actualmente esta jugando
        int c = (int)getJugador().get(j).get(2) + correcto;     //y lo guarda en j para indentificar la posicion en la que se guardaran los puntos
        //hace la suma de lo guardado en los puntos mas lo que se gana de mas
        getJugador().get(j).set(2, (int)c); //lo guarda en la posicion
    }

    public ArrayList <ArrayList<Object>> getJugador() 
    {
        return jugador;
    }
    
    public void setJugador(ArrayList <ArrayList<Object>> jugador) 
    {
        this.jugador = jugador;
    }
}
