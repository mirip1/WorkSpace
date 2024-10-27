package prog.unidad07.ejercicio01;

/**
 * Triángulo
 */
public class Triangulo extends Figura {

  // Constantes
  // Tolerancia de error en los cálculos
  private static final double TOLERANCIA = 1e-3;
  
  // Atributos
  // Coordenadas de los tres vertices
  Punto vertice1;
  Punto vertice2;
  Punto vertice3;
  
  /**
   * Constructor
   * @param vertice1 Primer vértice del triángulo
   * @param vertice2 Segundo vértice del triángulo
   * @param vertice3 Tercer vértice del triángulo
   * @throws IllegalArgumentException Si los tres puntos forman una ĺinea
   */
  public Triangulo(Punto vertice1, Punto vertice2, Punto vertice3) {
    if (!puntosAlineados(vertice1, vertice2, vertice3)) {
      this.vertice1 = vertice1;
      this.vertice2 = vertice2;
      this.vertice3 = vertice3;
    } else {
      throw new IllegalArgumentException("Los vértices están alineados");
    }
  }

  @Override
  public double getArea() {
    
    // Calculamos las longitudes de los lados
    double a = vertice1.distanciaA(vertice2);
    double b = vertice2.distanciaA(vertice3);
    double c = vertice3.distanciaA(vertice1);
    // Calculamos el semiperimetro
    
    double s = (a + b + c) / 2;
    return Math.sqrt(s * (s - a) * (s - b) * (s - c));
  }

  @Override
  public double getPerimetro() {
    // Calculamos las longitudes de los lados
    double a = vertice1.distanciaA(vertice2);
    double b = vertice2.distanciaA(vertice3);
    double c = vertice3.distanciaA(vertice1);
    
    // Las sumamos y las devolvemos
    return a + b + c;
  }

  @Override
  public boolean isRegular() {
    // Calculamos las longitudes de los lados
    double a = vertice1.distanciaA(vertice2);
    double b = vertice2.distanciaA(vertice3);
    double c = vertice3.distanciaA(vertice1);

    // Devolvemos si las diferencias entre las longitudes es menor de 1 milesima
    return Math.abs(a - b) < TOLERANCIA && Math.abs(b - c) < TOLERANCIA && Math.abs(c - a) < TOLERANCIA;
  }

  /**
   * Determina si los tres puntos están alineados
   * @param punto1 Primer punto a comprobar
   * @param punto2 Segundo punto
   * @param punto3 Tercer punto
   * @return true si los tres puntos están alineados. false si no lo están
   */
  private boolean puntosAlineados(Punto punto1, Punto punto2, Punto punto3) {
    // Calculamos la ecuación de la recta que pasa por los puntos 1 y 2
    double pendiente = (punto2.getY() - punto1.getY()) / (punto2.getX() - punto1.getX());
    double corte = punto1.getY() - (pendiente * punto1.getX());
    // Si el tercero también pertenece devuelve true, si no false
    // Suponemos un error de 1 milesima
    return Math.abs(punto3.getY() - (punto3.getX() * pendiente + corte)) < TOLERANCIA;
  }

}
