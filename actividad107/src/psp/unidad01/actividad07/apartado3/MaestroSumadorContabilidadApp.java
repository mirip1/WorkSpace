package psp.unidad01.actividad07.apartado3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/** Proceso maestro - Sumador de contabilidad de departamentos */
public class MaestroSumadorContabilidadApp {

  /** Comando para lanzar un proceso hijo o esclavo */
  private static final String SUMA_CONTABILIDAD_COMMAND = "java psp.unidad01.actividad07.apartado3.SumaContabilidad %s";

  /** Lista de ficheros que contienen la contabilidad */
  private static final List<String> FILE_URLS = List
      .of("informatica.txt", "gerencia.txt", "contabilidad.txt", "comercio.txt", "rrhh.txt");

  /**
   * Método main. Lanza los procesos esclavos de suma de datos
   * 
   * @param args Argumentos
   */
  public static void main(String[] args) {

    long startTime = System.nanoTime();

    int result = getSumFromProcesses();

    long endTime = System.nanoTime();
    System.out
        .printf("La suma total de los datos es de: %d. El tiempo de ejecución es: %dms%n", result,
            (endTime - startTime) / 1_000_000);

  }

  /**
   * Método que obtiene la suma desde los procesos lanzados
   * 
   * @return int
   */
  private static int getSumFromProcesses() {

    int result = 0;
    List<CompletableFuture<Integer>> asyncProcesses = new ArrayList<>();

    for (String fileUrl : FILE_URLS) {
      CompletableFuture<Integer> asyncProcess = CompletableFuture.supplyAsync(() -> {
        try {
          return executeProcess(fileUrl);

        } catch (IOException | InterruptedException e) {
          System.err.println(String.format("Error durante el proceso de conteo del fichero %s", fileUrl));
          return -1;
        }
      });
      asyncProcesses.add(asyncProcess);
    }

    for (CompletableFuture<Integer> asyncProcess : asyncProcesses) {
      try {
        result += asyncProcess.get();

      } catch (ExecutionException | InterruptedException e) {
        System.err.println(e.getMessage());
      }
    }

    return result;
  }

  /**
   * 
   * @param fileUrl
   * @return
   * @throws IOException
   * @throws InterruptedException
   */
  private static Integer executeProcess(String fileUrl) throws IOException, InterruptedException {

    long startTime = System.nanoTime();

    // Lanzamiento del proceso
    ProcessBuilder pb = new ProcessBuilder(String.format(SUMA_CONTABILIDAD_COMMAND, fileUrl).split(" "));
    Process process = pb.start();
    process.waitFor();

    // Lectura del resultado
    BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line = br.readLine();
    int count = -1;
    try {
      count = Integer.parseInt(line);
    } catch (NumberFormatException e) {
      System.err.println(e.getMessage());
    }

    br.close();

    // Cálculo del tiempo y return
    long endTime = System.nanoTime();
    System.out
        .printf("El resultado del conteo del fichero %s es %d. El tiempo de ejecución es: %dms%n", fileUrl, count,
            (endTime - startTime) / 1_000_000);

    return count;
  }

}
