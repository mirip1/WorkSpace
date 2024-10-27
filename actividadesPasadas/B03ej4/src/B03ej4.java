import java.util.Scanner;

public class B03ej4 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("¿Cuantos numeros deseas introducir?");
    int listaNumPar = Integer.parseInt(scan.nextLine());
    int i = 0;
    int numPar = listaNumPar;
    int num = 0;
    while (i != listaNumPar) {
      System.out.println("Introduzca un entero: ");
      num = Integer.parseInt(scan.nextLine());
      if (num % 2 == 0) {
        numPar--;
        if (numPar == 0) {
          System.out.println("Felicidades !!!");

        } else {
          System.out.println("te quedan " + numPar + " numeros pares");
        }
        i++;
      }
    }

  }
}
