import java.util.Scanner;

public class tres {
//Declaro constante
  public static final double IVA = 1.21;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduce un precio sin el IVA añadido");
    // Declaro la variable euro y la pido por pantalla
    double base = Integer.parseInt(sc.nextLine());
    System.out.println("el precio con IVA seria: "+base*IVA+"€");

  }

}
