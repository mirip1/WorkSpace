package Fichero2Ej1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GeneraPrimosTextoApp {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean anyadir = false;
//    String ruta = "C:\\Users\\mivel\\OneDrive\\Escritorio\\crearFichero\\ficher.txt";

    try (PrintWriter flujoSalida = new PrintWriter(new FileWriter("ficheroDePrimos2323.txt", anyadir))) {

      for (int i = 1; i != 500; i++) {

        if (primeNumber(i)) {
          flujoSalida.printf("%d%n", i);
        }

      }

    } catch (IOException e) {

      e.printStackTrace();
      System.out.print("ERROR");
    }

  }

  public static boolean primeNumber(int num) {
    boolean prime = true;
    for (int i = 2; i < num; i++) {
      if (num % i == 0) {
        prime = false;
        break;
      }
    }
    if (prime)
      return true;
    else
      return false;
  }

}
