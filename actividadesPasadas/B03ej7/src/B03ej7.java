import java.util.Scanner;

public class B03ej7 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Escribe el numero mayor que 0");
    int num = Integer.parseInt(scan.nextLine());
    int numDivisibles = 0;
    while (num <= 0) {
      System.out.println("Error el numero de inicio debe ser mayor que 0");
      System.out.println("Escribe el numero mayor que 0");
      num = Integer.parseInt(scan.nextLine());
    }
    for (int i = 2; i < num; i++) {
      if ((num % i) == 0) {
        numDivisibles++;
      }

    }
    if (numDivisibles == 0) {
      System.out.println("El numero es primo");
    } else {
      System.out.println("El numero no es primo");
    }

  }
}
