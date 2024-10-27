package prog.unidad04.actividad402.ejercicio06;

public class Triangulo {
  private Punto vertice1;
  private Punto vertice2;
  private Punto vertice3;
  
  public Triangulo(Punto vertice1,Punto vertice2,Punto vertice3){
    this.vertice1=vertice1;
    this.vertice2=vertice2;
    this.vertice3=vertice3;
    
  }
  
  public double area() {
    double distancia1;
    double distancia2;
    double distancia3;
    
    
    distancia1 = distancia(vertice1, vertice2);
    distancia2 = distancia(vertice2, vertice3);
    distancia3 = distancia(vertice3, vertice1);
    
    double s = ((distancia1 + distancia2 + distancia3 )/2);
    
    return Math.sqrt(s*(s-distancia1)*(s-distancia2)*(s-distancia3));
    
  }
  public double perimetro() {
    double distancia1;
    double distancia2;
    double distancia3;
   
    distancia1 = distancia(vertice1, vertice2);
    distancia2 = distancia(vertice2, vertice3);
    distancia3 = distancia(vertice3, vertice1);
   
    
    double perimetroTriangulo = (distancia1 + distancia2 + distancia3 );
    
    return perimetroTriangulo;
    
  }
  private double distancia(Punto a,Punto b) {
      
    double x1 = (a.getX() - b.getX())*(a.getX() - b.getX());
    double y1 = (a.getY() - b.getY())*(a.getY() - b.getY());
    return Math.sqrt((x1+y1));
    
  }
  
}
