/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.pkg1;

/**
 *
 * @author 177685
 */
public class Conversion {

    private double celsius;
    private double farenheit;
    private double kelvin;

    public double getCelsius() {
        return this.celsius;
    }

    public double getFarenheit() {
        return this.farenheit;
    }

    public double getKelvin() {
        return this.kelvin;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public void setFarenheit(double farenheit) {
        this.farenheit = farenheit;
    }

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }

    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }

    public void setFarenheit(float farenheit) {
        this.farenheit = farenheit;
    }

    public void setKelvin(float kelvin) {
        this.kelvin = kelvin;
    }

    public void convertCelsiusToFarenheit() {
        this.farenheit = (this.celsius * (9 / 5)) + 32;
    }

    public void convertCelsiusToKelvin() {
        this.kelvin = this.celsius + 273.15;
    }
}
