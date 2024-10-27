package prog.unidad07.ejercicio01;

/**
 * Rectángulo
 */
public class Rectangulo extends Figura {

  // Constantes
  // Tolerancia en los cálculos
  private static final double TOLERANCIA = 1e-3;
  
  // Atributos
  // Esquinas opuestas del rectángulo
  private Punto esquina1;
  private Punto esquina2;
  
  /**
   * Constructor a partir de las esquinas del rectángulo
   * @param esquina1 Esquina del rectángulo
   * @param esquina2 Esquina opuesta del rectángulo
   */
  public Rectangulo(Punto esquina1, Punto esquina2) {
    this.esquina1 = esquina1;
    this.esquina2 = esquina2;
  }
  
  @Override
  public double getArea() {
    // Calculamos los lados
    double a = Math.abs(esquina1.getX() - esquina2.getX());
    double b = Math.abs(esquina1.getY() - esquina2.getY());
    
    // Devuelve el producto de los lados
    return a * b;
  }

  @Override
  public double getPerimetro() {
    // Calculamos los lados
    double a = Math.abs(esquina1.getX() - esquina2.getX());
    double b = Math.abs(esquina1.getY() - esquina2.getY());
    
    // Devuelve la suma de los dobles de los lados
    return 2 * a + 2 * b;
  }

  @Override
  public boolean isRegular() {
    // Calculamos los lados
    double a = Math.abs(esquina1.getX() - esquina2.getX());
    double b = Math.abs(esquina1.getY() - esquina2.getY());
    
    // Devuelve si la diferencia entre las longitudes es menor que la tolerancia
    return Math.abs(a - b) < TOLERANCIA;
  }

}
