package psp.unidad01.actividad07.apartado2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/** Proceso maestro. Distribuye la suma entre varios procesos hijos */
public class MaestroSumadorApp {

  /** Comando para llamar al proceso esclavo */
  private static final String PROCESS_COMMAND = "java -cp /home/jmbellido/Escritorio/dev/scv/insti/PSP/ud01/actividad107/bin psp.unidad01.actividad07.apartado2.SumadorProcess %d %d";

  /** Límite del primer intervalo del proceso */
  private static final int LIMIT_FIRST_INTERVAL = 25;

  /** Límite del primer intervalo del proceso */
  private static final int LIMIT_SECOND_INTERVAL = 101;

  /**
   * Método principal. Distribuye la suma acumulativa entre varios procesos hijos en función de los números aportados y
   * los núcleos disponibles del ordenador
   * 
   * @param args Argumentos. Debe tener 2 valores numéricos
   */
  public static void main(String[] args) {

    long startTime = System.nanoTime();

    try {

      int[] numbers = getNumbers(args);
      int lowerNum = numbers[0];
      int upperNum = numbers[1];

      int result = getSum(lowerNum, upperNum);
      System.out.println("El resultado de la suma es: " + result);

    } catch (NumberFormatException e) {
      System.err.println("Los argumentos o los datos obtenidos de los subprocesos no son números enteros.");

    } catch (IllegalArgumentException | IOException | InterruptedException e) {
      System.err.println(e.getMessage());

    }

    long endTime = System.nanoTime();
    System.out.println(String.format("El tiempo total de ejecución es de: %dms", (endTime - startTime) / 1_000_000));
  }

  /**
   * Método que obtiene los números necesarios para la aplicación
   * 
   * @param args Array de argumentos
   * @return int[] - Array con los 2 números, siendo el primero el número inferior y el segundo el superior
   * @throws IllegalArgumentException En caso no haya suficientes parámetros
   * @throws NumberFormatException    Si los argumentos no son numéricos enteros
   */
  private static int[] getNumbers(String[] args) {

    // Verificación de argumentos
    if (args.length < 2) {
      throw new IllegalArgumentException(
          "Número de argumentos insuficiente. Son necesarios dos valores numéricos enteros");
    }

    int lowerNum = Integer.parseInt(args[0]);
    int upperNum = Integer.parseInt(args[1]);

    // Comprobación del orden correcto de argumentos
    if (upperNum < lowerNum) {
      int aux = upperNum;
      upperNum = lowerNum;
      lowerNum = aux;
    }

    return new int[] { lowerNum, upperNum };

  }

  /**
   * Obtiene la suma acumulativa entre ambos números
   * 
   * @param lowerNum Número inferior del intervalo
   * @param upperNum Número superior del intervalo
   * @return int - Suma acumulativa total
   * @throws IOException          En caso de que ocurra algún problema durante la ejecución de los procesos
   * @throws InterruptedException Si ocurre algún error al parar los procesos en espera
   */
  private static int getSum(int lowerNum, int upperNum) throws IOException, InterruptedException {

    int result = 0;
    int numberDifference = upperNum - lowerNum;
    int numProcess = 1;

    List<CompletableFuture<Integer>> asyncProcesses = new ArrayList<>();

    // Un solo proceso para el primer intervalo
    if (numberDifference < LIMIT_FIRST_INTERVAL) {
      result += executeProcess(lowerNum, upperNum);

      // Dos procesos para el segundo intervalo
    } else if (numberDifference < LIMIT_SECOND_INTERVAL) {

      int intermediateNumber = numberDifference / 2;

      asyncProcesses.add(getAsyngProcess(lowerNum, intermediateNumber));
      asyncProcesses.add(getAsyngProcess(intermediateNumber + 1, upperNum));

      // Tantos procesos como núcleos haya disponibles en el ordenador para el tercer intervalo
    } else {
      int avaiableCores = Runtime.getRuntime().availableProcessors();
      int intervalNumber = numberDifference / avaiableCores;

      for (int i = 0; i < avaiableCores; i++) {

        int start = lowerNum + i * intervalNumber;
        int end = i == avaiableCores - 1 ? upperNum : start + intervalNumber - 1;

        System.out.println("Lanzando el proceso nº " + numProcess);
        asyncProcesses.add(getAsyngProcess(start, end));

        numProcess++;
      }

    }

    for (CompletableFuture<Integer> asyncProcess : asyncProcesses) {
      try {
        result += asyncProcess.get();

      } catch (InterruptedException | ExecutionException e) {
        System.err.println(e.getMessage());
      }
    }

    return result;
  }

  /**
   * Obtiene el proceso de suma entre los números aportados
   * 
   * @param start Número inferior de la suma
   * @param end   Número superior de la suma
   * @return CompletableFuture(Integer)
   */
  private static CompletableFuture<Integer> getAsyngProcess(int start, int end) {

    return CompletableFuture.supplyAsync(() -> {
      try {
        return executeProcess(start, end);

      } catch (IOException | InterruptedException e) {
        System.err.println(String.format("Error durante el proceso entre los números %d y %d%n", start, end));
        return -1;
      }
    });
  }

  /**
   * Método que ejecuta un proceso con los números aportados
   * 
   * @param lowerNum Número inferior
   * @param upperNum Número superior
   * @return int - Suma acumulativa de los números
   * @throws IOException           En caso de que exista algún problema en el proceso
   * @throws InterruptedException  Si ocurre un error al interrumpir el proceso
   * @throws NumberFormatException Si la conversión de datos no es correcta
   */
  private static int executeProcess(int lowerNum, int upperNum) throws IOException, InterruptedException {

    long startTime = System.nanoTime();

    ProcessBuilder pb = new ProcessBuilder(String.format(PROCESS_COMMAND, lowerNum, upperNum).split(" "));
    Process process = pb.start();
    process.waitFor();

    BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line = br.readLine();
    int sum = Integer.parseInt(line);

    br.close();

    long endTime = System.nanoTime();
    System.out
        .printf("El resultado de la suma entre %d y %d es de: %d. El tiempo de ejecución es: %dms%n", lowerNum,
            upperNum, sum, (endTime - startTime) / 1_000_000);

    return sum;

  }

}
