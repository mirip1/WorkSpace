package prog.unidad04.actividad402.ejercicio06;

public class Rectangulo {
  private Punto esquina1;
  private Punto esquina2;
  
  public Rectangulo(Punto esquina1, Punto  esquina2) {
    this.esquina1 = esquina1;
    this.esquina2 = esquina2;
  }

  public double area() {
    double base;
    double altura;
    base = esquina2.getX()-esquina1.getX();
    altura = esquina2.getY() - esquina1.getY();
    return base * altura;
  }
  
  public double perimetro() {
    double base;
    double altura;
    base = esquina2.getX()-esquina1.getX();
    altura = esquina2.getY() - esquina1.getY();
    return 2*base + 2*altura;
  }
  
  public boolean esCuadrado() {
    double base;
    double altura;
    base = esquina2.getX()-esquina1.getX();
    altura = esquina2.getY() - esquina1.getY();
    return base == altura;
  }
  
  
}
