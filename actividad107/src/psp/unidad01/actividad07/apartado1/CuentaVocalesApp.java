package psp.unidad01.actividad07.apartado1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import psp.unidad01.actividad07.utils.FileUtils;

/** Proceso maestro - Contador de vocales */
public class CuentaVocalesApp {

  /** Comando para lanzar un proceso hijo o esclavo */
  private static final String CUENTA_LETRA_COMMAND = "java psp.unidad01.actividad07.apartado1.CuentaLetraApp %s";

  /** Lista de vocales a buscar */
  private static final List<String> VOCALS = List.of("a", "e", "i", "o", "u");

  /** Archivo base donde se almacenan los datos del conteo */
  private static final String COUNT_FILE_URL = "fichero-%s.txt";

  /**
   * Método main. Lanza los procesos esclavos de conteo de vocales
   * 
   * @param args Argumentos
   */
  public static void main(String[] args) {

    long startTime = System.nanoTime();

    List<CompletableFuture<Integer>> asyncProcesses = new ArrayList<>();

    // Se lanza el proceso por cada vocal
    int counter = 0;

    try {
      for (String vocal : VOCALS) {

        asyncProcesses.add(CompletableFuture.supplyAsync(() -> {
          try {
            return executeProcess(vocal);

          } catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
            return -1;
          }
        }));
      }

      for (CompletableFuture<Integer> asyncProcess : asyncProcesses) {
        int counterLetter = asyncProcess.get();
        counter += counterLetter;
      }

    } catch (InterruptedException | ExecutionException e) {
      System.err.println(e.getMessage());
    }

    long endTime = System.nanoTime();
    System.out.println("El número total de vocales es: " + counter);
    System.out
        .println(String.format("El tiempo total de ejecución ha sido de: %dms", (endTime - startTime) / 1_000_000));

  }

  /**
   * Ejecuta el proceso y obtiene el número resultante del proceso
   * 
   * @param vocal Vocal a contar
   * @return Número de repeticiones de la vocal
   * @throws IOException          En caso de que existe un error durante el acceso al archivo
   * @throws InterruptedException En caso de que ocurra un error durante la espera del proceso
   */
  private static int executeProcess(String vocal) throws IOException, InterruptedException {

    long startTime = System.nanoTime();

    // Ejecución del proceso
    ProcessBuilder pb = new ProcessBuilder(String.format(CUENTA_LETRA_COMMAND ,vocal).split(" "));

    Process process = pb.start();
    process.waitFor();

    // Resultado
    int result = FileUtils.readNumber(new File(String.format(COUNT_FILE_URL, vocal)));
    long finalTime = System.nanoTime();

    System.out
        .println(String
            .format("El número de vocales '%s' es: %d. El tiempo de ejecución ha sido: %dms", vocal, result,
                (finalTime - startTime) / 1_000_000));

    return result;

  }
}
