/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg177185_p12p3b;

/*
 * Garcia Sanchez Jared Jair - 177185 
 * Practica 12: Practica Integradora 1
 * Grupo B / 14:00 - 16:00 hrs / 19/10/2023
 * Utilizando la Interfaz se genera un menú de opciones para desarrollarlas durante 
 * las próximas sesiones. Para esta sesión, la interfaz incluirá alta y baja de usuarios.
 */

public class Main 
{
    public static void main(String[] args) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Menu().setVisible(true);
            }
        });
    }
}
