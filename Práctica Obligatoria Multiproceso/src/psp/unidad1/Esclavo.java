package psp.unidad1;

import java.util.Scanner;

public class Esclavo {

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    
    Scanner scanner = new Scanner(System.in);
    

    int num1 = scanner.nextInt();
    int num2 = scanner.nextInt();
    
    int  totalPrimos = 0;
    int  totalAnalizados= 0;

    for (int i = num1; i <= num2; i++) {
      if (esPrimo(i)) {
        System.out.println(i);
        totalPrimos++;
      }
      totalAnalizados++;
    }
    
    
    long endTime = System.nanoTime();
    int duration = (int) ((endTime - startTime) / 1000000); // Convertir de nanosegundos a milisegundos
    
    System.out.println("El programa a analizado: \nNumero Primos: " + totalPrimos + "\nNumeros Analizados: " + totalAnalizados + "\nY ha tardado: " + duration + "ms");
    scanner.close();
    
  }

  /**
   * Metodo que comrpueva si un numero es primo
   * 
   * @param n numero que queremos comprobar
   * @return true si es primo false si no lo es
   */
  static boolean esPrimo(int n) {
    if (n == 2) {
      return true;
    }

    if (n % 2 == 0) {
      return false;
    }

    // Este for solo analiza los numeros impares ya que nos hemos quitado los
    // numeros pares con el anterior bloque de código
    for (int i = 3; i * i <= n; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

}
