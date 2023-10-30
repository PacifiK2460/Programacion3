/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s13p02ejersiciohilos;

/**
 *
 * @author 177685
 */
public class Tejedora extends Thread {

    private int n;

    public Tejedora(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        if (n == 1) {
            n = 1;
        } else if (n == 2) {
            n = 2;
        }

        for (int i = n; i <= 200; i += 2) {
            System.out.println(i);
        }

    }
}
