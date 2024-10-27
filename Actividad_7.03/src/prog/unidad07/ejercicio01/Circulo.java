package prog.unidad07.ejercicio01;

/**
 * Circulo
 */
public class Circulo extends Figura{

  // Atributos
  // Centro
  private Punto centro;
  // Radio
  private double radio;

  /**
   * Constructor
   * @param centro Centro del círculo. No puede ser null
   * @param radio Radio del círculo. Debe ser positivo o cero
   * @throws NullPointerException si el centro es null
   * @throws InvalidArgumentException si el radio es negativo
   */
  public Circulo(Punto centro, double radio) {
    if (centro != null) {
      if (radio >= 0) {
        this.centro = centro;
        this.radio = radio;
      } else {
        throw new IllegalArgumentException("El radio es negativo");
      }
    } else {
      throw new NullPointerException("El centro es null");
    }
  }
  
  @Override
  public double getArea() {
    return Math.PI * Math.pow(radio, 2);
  }

  @Override
  public double getPerimetro() {
    return 2 * Math.PI * radio;
  }

  @Override
  public boolean isRegular() {
    return true;
  }

}
