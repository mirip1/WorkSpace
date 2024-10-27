package pcp.unidad1.relacion07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CuentaLetraAPP {
  private static final String ARCHIVO = "RESULTADO.txt";

  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Se necesita una vocal como argumento.");
      System.exit(1);
    }

    String vocal = args[0];
    String archivo = "texto.txt";
    int contador = 0;

    // Leemos el archivo buscando la letra que nos han dado por argumento
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
      String linea;
      while ((linea = br.readLine()) != null) {
        for (char c : linea.toCharArray()) {
          if (String.valueOf(c).equalsIgnoreCase(vocal)) {
            contador++;
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Escribimos el contador en un archivo texto
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
      writer.write(contador + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
