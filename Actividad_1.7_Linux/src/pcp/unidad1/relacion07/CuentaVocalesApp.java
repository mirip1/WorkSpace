package pcp.unidad1.relacion07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class CuentaVocalesApp {

  public static void main(String[] args) {
    String RUTA = "/home/miguel/WorkSpace/Actividad_1.7_Linux/src";
    String ARCHIVO = "RESULTADO.txt";
    
    long startTime = System.nanoTime();

    String[] vocales = { "A", "E", "I", "O", "U" };
    try {
      // Limpiar el archivo de resultados antes de empezar
      new FileWriter(ARCHIVO, false).close();

      for (String vocal : vocales) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", RUTA, "pcp.unidad1.relacion07.CuentaLetraAPP", vocal);
        Process process = pb.start();
        process.waitFor(); // Esperar a que el proceso termine antes de lanzar el siguientew
      }

      // Sumar todos los resultados
      int totalVocales = 0;
      int cont = 0;
      try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
        String linea;
        while ((linea = br.readLine()) != null) {
          System.out.println("la letra " + vocales[cont] + " se repite: " + linea +  " veces");
          totalVocales += Integer.parseInt(linea);
          cont++;
        }
      }

      // Mostrar el resultado total
      System.out.println("Total de vocales: " + totalVocales);
      long endTime = System.nanoTime();
      long duration = (endTime - startTime) / 1000000; // Convertir de nanosegundos a milisegundos

      System.out.println("Duración: " + duration + " ms");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
