import java.util.Scanner;

public class EJDoce {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Calculador de volumen de un cono");
    System.out.println("Escribe lo que mide la base del cono");
    double base = Double.parseDouble(scan.nextLine());
    System.out.println("Escribe la altura del cono");
    double altura = Double.parseDouble(scan.nextLine());
    double volumen = ((3.14159*base*base*altura)/3);
    System.out.println("El volumen del cono es: "+volumen);
    
  }
  
}
