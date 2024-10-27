package prog.unidad04.actividad402.ejercicio06;

public class Circulo {
  private Punto centro;
  private double radio;
  
  public Circulo (Punto centro, double radio) {
    this.centro = centro;
    this.radio = radio;
  }
  
  public double area() {
    return radio*radio*Math.PI;
  }
  
  public double perimetro() {
    return 2*radio*Math.PI;
  }
  
}
