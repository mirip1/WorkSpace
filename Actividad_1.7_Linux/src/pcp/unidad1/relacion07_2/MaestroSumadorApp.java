package pcp.unidad1.relacion07_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MaestroSumadorApp {

  private static String RUTA = "/home/miguel/WorkSpace/Actividad_1.7_Linux/src";

  public static void main(String[] args) {

    if (args.length != 2) {
      System.err.println("Se deben introducir dos argumentos");
      return;
    }
    if (!isNumero(args[0]) || !isNumero(args[1])) {
      System.err.println("Los parametros introducidos deben ser de tipo entero");
      return;
    }

    int numero1 = Integer.parseInt(args[0]);
    int numero2 = Integer.parseInt(args[1]);
    int diferencia = Math.abs(numero1 - numero2);
    int sumaTotal = 0;

    List<Process> processes = new ArrayList<>();

    try {
      if (diferencia < 25) {
        processes.add(lanzarProceso(numero1, numero2));
      } else if (diferencia >= 25 && diferencia <= 100) {
        processes.add(lanzarProceso(numero1, numero2));
        processes.add(lanzarProceso(numero1, numero2));
      } else {
        int numProcesadores = Runtime.getRuntime().availableProcessors();
        int rango = (diferencia + 1) / numProcesadores;

        for (int i = 0; i < numProcesadores; i++) {
          int inicio = Math.min(numero1, numero2) + i * rango;
          int fin = (i == numProcesadores - 1) ? Math.max(numero1, numero2) : inicio + rango - 1;
          processes.add(lanzarProceso(inicio, fin));
        }
      }

      for (Process process : processes) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
          String linea;
          while ((linea = reader.readLine()) != null) {
            sumaTotal += Integer.parseInt(linea);
          }
        }
        process.waitFor();
      }

      System.out.println("Suma Total: " + sumaTotal);

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static Process lanzarProceso(int numero1, int numero2) {
    ProcessBuilder pb = new ProcessBuilder("java", "-cp", RUTA, "pcp.unidad1.relacion07_2.SumadorProdess",
        String.valueOf(numero1), String.valueOf(numero2));
    try {
      return pb.start();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public static boolean isNumero(String cadena) {
    try {
      Integer.parseInt(cadena);
      return true;
    } catch (NumberFormatException excepcion) {
      return false;
    }

  }
}
