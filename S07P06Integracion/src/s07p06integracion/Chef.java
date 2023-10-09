/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s07p06integracion;

/**
 *
 * @author 177685
 */
public abstract class Chef {
    private String nombre;
    
    public Chef(String nombre){
        this.nombre = nombre;
    }
    
    public void Presentarse(){
        System.out.println("Mi nombre es " + this.nombre);
    }
    
    abstract public void cocinar();
    abstract public void limpiar();
}
