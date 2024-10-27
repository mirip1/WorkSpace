package r01e23;
import java.util.Scanner;

public class ventitres {
  public static void main(String[] args) {
    
    final double RESISTENCIA = 4;
    
    Scanner scan = new Scanner(System.in);

    System.out.println("CALCULO DE POTENCIA ELÉCTRICA");
    System.out.println("-----------------------------");
    System.out.print("Introduce el voltaje de la fuente (en voltios): ");
    double voltaje  = Double.parseDouble(scan.nextLine());
    double intensidad = voltaje / RESISTENCIA;
    double potencia = voltaje * intensidad;

    System.out.println("La potencia consumida por el circuito es de " + potencia + "W");
  }

}
