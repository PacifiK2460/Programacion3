/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s11p01excepciones;
import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import java.util.Arrays;
/**
 *EXCEPCIONES - Situaciones que salen de la regla.
 * Comprobadas (Checked): Es obligatorio programarlas
 * No Comprobadas (UnChecked): Normalmente son en 
 * tiempo y ejecucion y NO es "obligatorio" atraparlo
 * 
 * ***Para "atrapar" una excepcion:
 * try{
 *  //Las lineas de codigo que pueden lanzar
 *  //La excepcion
 * }catch (La excepcion a atrapar){
 *      puede haber tantos "catch" como se deseo
 *      o incluso no haber, pero si no hay, SE BEDE
 *      programar un bloque "finally"
 * }finally{
 *      Lo que se coloca aqui se ejecuta "Si o si"
 *      puede no ponerse
 * }
 * 
 * @author 177199
 */
public class S11P01Excepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          Scanner entrada = new Scanner(System.in);

          int []a = new int[5];
          
    try{
        System.out.println("Dame un numero: ");
        int x = entrada.nextInt();
        System.out.println("Dame otro numero: ");
        int y = entrada.nextInt();
        System.out.println("La suma es: "+(x+y));
        System.out.println("La division es:"+(x/y));
    }catch(InputMismatchException e){
        JOptionPane.showMessageDialog(null, "se lanzo una excepcion"+e);
    }catch(ArithmeticException e){
        System.out.println("Se lanzo una excepcion");
    }catch(Exception e){
        System.out.println("Algo fallo"+e);
    }

    finally{   
        System.out.println("Esto se ejecuta si o si");
    }
    
  } 
    
}





