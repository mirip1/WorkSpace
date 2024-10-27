import java.util.Scanner;

public class B03ej8 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    long acum = 1;

    System.out.println("Escribe el numero mayor que 0");
    long num = Integer.parseInt(scan.nextLine());
    while (num <= 0) {
      System.out.println("Error el numero de inicio debe ser mayor que 0");
      System.out.println("Escribe el numero mayor que 0");
      num = Integer.parseInt(scan.nextLine());
    }

    for (int i = 1; i <= num; i++) {

      acum = acum * i;

    }
    System.out.println("El factorial de " + num + " Es " + acum);

  }
}