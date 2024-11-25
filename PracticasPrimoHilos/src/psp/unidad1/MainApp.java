package psp.unidad1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainApp {
  static final int NUCLEOS_SISTEMA = Runtime.getRuntime().availableProcessors();

  public static void main(String[] args) {
    int numHilos = 0;

    // Control de parámetros de entrada
    if (!(args.length >= 2)) {
      System.out.println("Se le deben pasar al menos 2 parámetros");
      return;
    }

    numHilos = NUCLEOS_SISTEMA;

    int num1 = 0;
    int num2 = 0;

    // Validación de parámetros
    try {
      num1 = Integer.parseInt(args[0]);
      num2 = Integer.parseInt(args[1]);
      if (num1 < 2 || num1 > 2147483647 || num2 < 2 || num2 > 2147483647 || numHilos > NUCLEOS_SISTEMA) {
        throw new IllegalArgumentException();
      }
    } catch (Exception e) {
      System.out.println("Los números deben ser enteros válidos entre el 2 y el 2.147.483.647, y "
          + "el número de hilos no puede ser mayor que los núcleos disponibles (Su equipo tiene " + NUCLEOS_SISTEMA
          + ")");
      return;
    }

    if (num1 > num2) {
      int auxiliar = num2;
      num2 = num1;
      num1 = auxiliar;
    }

    // División del rango
    int rango = num2 - num1 + 1;
    int rangoPorHilo = rango / numHilos;
    int resto = rango % numHilos;

    // Lista concurrente para almacenar resultados
    List<Integer> primosEncontrados = Collections.synchronizedList(new ArrayList<>());
    ExecutorService executor = Executors.newFixedThreadPool(numHilos);
    List<Future<?>> futures = new ArrayList<>();

    int inicio = num1;
    long startTime = System.nanoTime();

    try {
      // Crear y ejecutar los hilos
      for (int i = 0; i < numHilos; i++) {
        int fin = inicio + rangoPorHilo - 1;
        if (i < resto) {
          fin++;
        }

        // Rango para cada hilo
        int rangoInicio = inicio;
        int rangoFin = fin;

        Future<?> future = executor.submit(() -> {
          HiloPrimo hiloPrimo = new HiloPrimo(rangoInicio, rangoFin);
          hiloPrimo.run();
          primosEncontrados.addAll(hiloPrimo.getPrimosEncontrados());
        });
        futures.add(future);

        inicio = fin + 1;
      }

      // Esperar a que todos los hilos terminen
      for (Future<?> future : futures) {
        future.get(); // Bloquea hasta que el hilo termine
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      executor.shutdown();
    }

    long endTime = System.nanoTime();
    long duracionTotal = (endTime - startTime) / 1_000_000;
    Collections.sort(primosEncontrados);

    // Resultados finales
    System.out.println("\nResultados finales:");
    System.out.println("Total de primos encontrados: " + primosEncontrados.size());
    System.out.println("Total de números analizados: " + rango);
    System.out.println("Duración total: " + duracionTotal + " ms");
    System.out.println("Lista de números primos:");
    System.out.println(primosEncontrados);
  }
}
