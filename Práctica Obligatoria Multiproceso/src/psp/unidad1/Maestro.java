package psp.unidad1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Maestro {

  public static void main(String[] args) {

    try {
      ProcessBuilder pb = new ProcessBuilder("java", "-jar","Esclavo.jar");
      Process process = pb.start();

      System.out.println("2");
      System.out.println("10");
      
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
        String line;
        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
