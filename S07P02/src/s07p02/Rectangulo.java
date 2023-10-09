/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s07p02;

/**
 *
 * @author 177685
 */
public class Rectangulo extends Figura {

    private float base, altura;

    public Rectangulo(String color, int lados, float base, float altura) {
        super(color, lados);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public float area() {
        return base*altura;
    }
}
