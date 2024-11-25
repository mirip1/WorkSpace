package psp.unidad1;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Hilo
 */
public class HiloPrimo implements Runnable {

  private int num1;
  private int num2;
  private int duration;
  private int totalAnalizados;
  private final List<Integer> primosEncontrados;

  // Constructor de la clase
  public HiloPrimo(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
    this.duration = 0;
    totalAnalizados = 0;
    this.primosEncontrados = new ArrayList<>();
  }

  @Override
  public void run() {
    long startTime = System.nanoTime();
    System.out.println("Hilo furulando intervalo: " + num1 + " - " + num2);

    for (int i = num1; i <= num2; i++) {
      if (esPrimo(i)) {
        primosEncontrados.add(i);

      }
      totalAnalizados++;
    }

    long endTime = System.nanoTime();
    duration = (int) ((endTime - startTime) / 1000000); // Convertir de nanosegundos a milisegundos

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

  /**
   * @return the duration
   */
  public int getDuration() {
    return duration;
  }

  /**
   * @return the totalAnalizados
   */
  public int getTotalAnalizados() {
    return totalAnalizados;
  }

  /**
   * @return the primosEncontrados
   */
  public List<Integer> getPrimosEncontrados() {
    return primosEncontrados;
  }

}
