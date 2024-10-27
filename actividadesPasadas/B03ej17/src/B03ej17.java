import java.util.Scanner;

public class B03ej17 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // Declaramos las variables
    int num;
    int numDivisibles;
    // Pedimos los numeros por pantalla
    do {
      System.out.println("Introduce u numero entero mayor que 1 para descomponerlo en factores primos ");
      num = Integer.parseInt(scan.nextLine());
    } while (num < 1);

    for (int i = 2; i < num; i++) {
      numDivisibles = 0;
      for (int j = 2; j != i; j++) {
        if ((i % j) == 0) {
          numDivisibles++;
        }
      }
      if (numDivisibles == 0) {
        if (num%i==0) {
          System.out.println(i+" Es factor primo");
        }
      }

    }

  }
}
