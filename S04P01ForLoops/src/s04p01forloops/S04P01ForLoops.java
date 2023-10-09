/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s04p01forloops;
import java.util.Scanner;

/**
 *
 * @author 177685
 */
public class S04P01ForLoops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String matricula;
        matricula = scanner.nextLine();
        
        float promedio = 0;
        
        for(char numero: matricula.toCharArray()){
            promedio += (numero - '0');
        }
        
        
        
        System.out.print(promedio / matricula.length());
    }

}
