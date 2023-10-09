/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen.pkg2;

import java.util.Scanner;

/**
 *
 * @author 177685
 */
public class Examen2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Partido partido = new Partido();

        partido.setLocal(input.nextLine());
        partido.setVisitante(input.nextLine());

        for (int Equipo = 0; Equipo < 2; Equipo++) {
            int[] puntos = new int[4];
            for (int Partido = 0; Partido < 4; Partido++) {
                puntos[Partido] = input.nextInt();
            }
            partido.setPuntos(puntos, Equipo);
        }

        String[] _equipo = {"Local", "Visitante"};
        for (int Equipo = 0; Equipo < 2; Equipo++) {
            System.out.println("Resumen del equipo " + _equipo[Equipo]);
            System.out.print("Nombre: ");
            int otro;
            if (Equipo == 0) {
                System.out.println(partido.getLocal());
                otro = 1;
            } else {
                System.out.println(partido.getVisitante());
                otro = 0;
            }

            int[][] puntos = partido.getPuntos();
            int index = 0;
            for (int Puntos : puntos[Equipo]) {
                if (Puntos > puntos[otro][index]) {
                    System.out.println("Gano el partio " + index + " con " + Puntos + " pts.");
                }
                index++;
            }
        }

    }

}
