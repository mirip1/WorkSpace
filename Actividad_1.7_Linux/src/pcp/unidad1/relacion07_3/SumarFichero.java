package pcp.unidad1.relacion07_3;

import java.io.BufferedReader;
import java.io.FileReader;

public class SumarFichero {
  private String nombreFichero;
  private int total;

  public SumarFichero(String nombreFichero) {
    this.nombreFichero = nombreFichero;
    this.total = 0;
  }

  // Método para sumar los números del fichero
  public void sumar() {
    try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
      String linea;
      while ((linea = br.readLine()) != null) {
        try {
          total += Integer.parseInt(linea.trim());
        } catch (NumberFormatException e) {
          System.err.println("Error al convertir la línea: " + linea + " en el archivo " + nombreFichero);
        }
      }
    } catch (Exception e) {
      System.err.println("Error al leer el archivo: " + nombreFichero + " - " + e.getMessage());
    }

  }

  public int getTotal() {
    return total;
  }
}
