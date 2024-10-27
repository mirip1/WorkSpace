package examenU03;

//importamos scanner
import java.util.Scanner;

public class SuperEstadisticaApp {
  public static void main(String[] args) {
    System.out.println("EXAMEN UNIDAD 3 MIGUEL VELASCO FERNANDEZ");

    Scanner scan = new Scanner(System.in);
    // Declaramos las variables
    int num = 1;
    double acum = 0;
    int cont = 0;
    
    // hacemos un do while que pida numeros hasta que se introduzca 0
    do {
      // utilizamos el try catch para que siga pidiendo numeros aunque no se
      // introduzcan enteros válidos

      try {
        System.out.println("Introduzca números enteros (Introduzca 0 si deseas terminar) ");
        num = Integer.parseInt(scan.nextLine());

        if (num != 0) {
          // realizamos condiciones para los diferentes casos negativo/positivo par/impar

          if (num < 0) {
            System.out.println("El numero es negativo");
          } else if (num > 0) {
            System.out.println("El numero es positivo");

          }
          if (num % 2 == 0) {
            System.out.println("El numero es par");
          }
          // la media
          else {
            System.out.println("El numero es impar");
            if ((num > -11) && (num < 20)) {

            } else {
              acum = num + acum;
              cont++;
            }
            if ((num == -1) || (num == 3)) {
              acum = num + acum;
              cont++;
            }

          }
        } else {
          // imprimimos por pantalla
          if (cont != 0) {
            System.out.println("La media vale: " + (acum / cont) + " y se han introducido: " + cont + " numeros");
          } else {
            System.out.println("La media vale: 0 y se han introducido 0 numeros");

          }
        }

      } catch (NumberFormatException e) {
        System.out.println("El dato introducido no es un número entero válido");

      }

    } while (num != 0);

  }

}
