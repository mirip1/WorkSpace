package prog.unidad07.ejercicio01;

/**
 * Punto en el plano
 */
public class Punto {

  // Atributos
  // Coordenada X del punto
  private double x;
  // Coordenada Y del punto
  private double y;

  /**
   * Constructor
   * @param x Coordenada X del punto
   * @param y Coordenada Y del punto
   */
  public Punto(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Obtiene la coordenada X del punto
   * @return Coordenada X del punto
   */
  public double getX() {
    return x;
  }

  /**
   * Modifica la coordenada X del punto
   * @param x Nueva coordenada X del punto
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Obtiene la coordenada Y del punto
   * @return Coordenada Y del punto
   */
  public double getY() {
    return y;
  }

  /**
   * Modifica la coordenada Y del punto
   * @param y Nueva coordenada Y del punto
   */
  public void setY(double y) {
    this.y = y;
  }

  /**
   * Obtiene la distancia desde este punto hasta otro
   * @param otro Otro punto
   * @return Distancia entre este punto y el otro
   */
  public double distanciaA(Punto otro) {
    return Math.sqrt(Math.pow(getX() - otro.getX(), 2) + Math.pow(getY() - otro.getY(), 2));
  }
  
}
