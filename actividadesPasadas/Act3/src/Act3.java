
public class Act3 {
  public static void main(String[] args) {
    Lapiz lapiz = new Lapiz();

    
    
    lapiz.baja();
    lapiz.desplaza(5);
    lapiz.gira(90);
    lapiz.desplaza(5);
    lapiz.gira(90);
    lapiz.desplaza(5);
    lapiz.gira(90);
    lapiz.desplaza(5);
    lapiz.gira(90);
    lapiz.sube();
    lapiz.reinicia();
    System.out.println(lapiz.getTrazo(0).getInicio());

    Linea linea1 = new Linea(punto1, punto2);
    Linea linea2 = new Linea(punto2, punto3);
    Linea linea3 = new Linea(punto3, punto4);
    Linea linea4 = new Linea(punto4, punto1);


    
    
  }
}
