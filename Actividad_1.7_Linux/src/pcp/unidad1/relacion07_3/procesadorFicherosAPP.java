package pcp.unidad1.relacion07_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class procesadorFicherosAPP {

  private static final String fichero1 = "informatica.txt";
  private static final String fichero2 = "gerencia.txt";
  private static final String fichero3 = "contabilidad.txt";
  private static final String fichero4 = "comercio.txt";
  private static final String fichero5 = "rrhh.txt";

  public static void main(String[] args) {

    List<String> ficheros = List.of(fichero1, fichero2, fichero3, fichero4, fichero5);

    // coger el numero de núcleos disponibles
    int numNucleos = Runtime.getRuntime().availableProcessors();

    ExecutorService executor = Executors.newFixedThreadPool(numNucleos);
    List<Future<Integer>> futuros = new ArrayList<>();
    List<Thread> hilos = new ArrayList<>();
    List<SumarFichero> sumadores = new ArrayList<>();

    // Crear y lanzar un hilo para cada fichero
    for (String fichero : ficheros) {
      SumarFichero sumador = new SumarFichero(fichero);
      sumadores.add(sumador);
      Thread hilo = new Thread(() -> sumador.sumar());
      hilos.add(hilo);
      hilo.start();
    }

    // Esperar a que todos los hilos terminen
    for (Thread hilo : hilos) {
      try {
        hilo.join();
      } catch (InterruptedException e) {
        System.err.println("El hilo fue interrumpido: " + e.getMessage());
      }
    }

    // Sumar los totales de cada SumarFichero
    int totalGlobal = 0;
    for (SumarFichero sumador : sumadores) {
      totalGlobal += sumador.getTotal();
    }

    System.out.println("Suma total de todos los ficheros: " + totalGlobal);
  }

}
