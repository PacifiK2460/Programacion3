/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s13p01hilos;

/**
 *
 * @author 177685
 */
public class MiHilo extends Thread {
    
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println(this.getName() + 1);
        }
    }
    
}
