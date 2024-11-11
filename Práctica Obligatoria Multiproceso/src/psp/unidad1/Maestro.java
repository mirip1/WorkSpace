package psp.unidad1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

public class Maestro {
  static final int NUCLEOS_SISTEMA = Runtime.getRuntime().availableProcessors();

  public static void main(String[] args) {
    int numNucleos = 0;

    // Controlamos los parametros de entrada
    if (!(args.length >= 2)) {
      System.out.println("Se le deben pasar almenos 2 parametros");
      return;
    }
    if (args.length > 2) {
      numNucleos = Integer.parseInt(args[2]);
    } else {
      numNucleos = NUCLEOS_SISTEMA;
    }

    int num1 = 0;
    int num2 = 0;

    // Validamos los parámetros de entreda
    try {
      num1 = Integer.parseInt(args[0]);
      num2 = Integer.parseInt(args[1]);
      if (num1 < 2 || num1 > 2147483647 || num2 < 2 || num2 > 2147483647 || numNucleos > NUCLEOS_SISTEMA) {
        throw new IllegalArgumentException();
      }

    } catch (Exception e) {
      System.out.println("Los numeros deben ser enteros válidos entre el 2 y el 2.147.483.647, y "
          + "el numero de procesos a lanzar no puede ser mayor que núcleos tiene el sistema (Su equipo tiene "
          + NUCLEOS_SISTEMA + ")");
      return;
    }

    if (num1 > num2) {
      int auxiliar = num2;
      num2 = num1;
      num1 = auxiliar;

    }

    // Calculamos el tamaño de cada rango de los procesos Esclavo (todavía no lo he
    // hecho de forma equitativa)
    int rango = num2 - num1 + 1;
    int rangoPorProceso = rango / numNucleos;
    int resto = rango % numNucleos;

    List<Integer> primosEncontrados = new ArrayList<>();
    List<Process> procesos = new ArrayList<>();
    int inicio = num1;
    int totalPrimos = 0;
    long startTime = System.nanoTime();

    try {

      // Lanzamos los procesos Esclavo con su rango correspondiente
      for (int i = 0; i < numNucleos; i++) {
        int fin = inicio + rangoPorProceso - 1;

        // Si la division no tiene resto 0, se repartiran un numero al rango
        // conforme vaya sucediendo
        if (i < resto) {
          fin++;
        }

        int rangoInicio = inicio;
        int rangoFin = fin;
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "Esclavo.jar");
        Process process = pb.start();
        procesos.add(process);

        // Le mandamos los parametros al esclavo
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(process.getOutputStream()))) {
          writer.println(rangoInicio);
          writer.println(rangoFin);
          writer.flush();
        }

        inicio = fin + 1;
      }
      int numProceso = 0;

      // Bcle que por cada proceso lee la salida
      for (Process process : procesos) {
        numProceso++;
        System.out.println("Proceso " + numProceso);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
          String linea;
          while ((linea = reader.readLine()) != null) {
            try {
              int primo = Integer.parseInt(linea);
              primosEncontrados.add(primo);
              totalPrimos++;
            } catch (NumberFormatException e) {

              if (linea.contains("Numero Primos")) {
                System.out.println(linea);
              } else if (linea.contains("Numeros Analizados")) {
                System.out.println(linea);
              } else if (linea.contains("Y ha tardado")) {
                System.out.println(linea);
              }
            }
          }
        }

        System.out.println("");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    long endTime = System.nanoTime();
    long duracionTotal = (endTime - startTime) / 1000000;

    // Finalmente imprimimos los datos por pantalla
    System.out.println("\nResultados finales:");
    System.out.println("Total de primos encontrados: " + totalPrimos);
    System.out.println("Total de numeros analizados: " + rango);
    System.out.println("Duración total: " + duracionTotal + " ms");
    System.out.println("Lista de números primos:");


    String listaPrimos = "";

    // Imprimimos la lista de todos los primos
    for (Integer primo : primosEncontrados) {
      listaPrimos += primo + ",";

    }
    listaPrimos = "[" + listaPrimos + " ] ";
    System.out.println(listaPrimos);

  }
}