/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s12p02excepcionespropias;

/**
 *
 * @author 177685
 */
public class MisExcepciones {

    public void validarCalificacion(int calificacion) throws Exception {
        // throw new Exception
        // Solo la lanzo si sucede lo que amerita la excepcion, por ejemplo: un error.
        
        if(calificacion < 0 || calificacion > 10){
            // Lanzo una excepcion ya que no se permiten estas calificaciones.
            throw new Exception();
        }
    }
    
    // Función que pidio que agreguemos. Lee el apartado "Agregue"
    public void validarEdad(int edad) throws Exception {
        if(edad < 70){
            // Podemos agregar un mensaje el cual se le puede mostrar al usuario.
            throw new Exception("Aun no puede reclamar su beca, es menor de edad.");
        }
    }

}
