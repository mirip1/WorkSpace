package psp.unidad01.actividad07.apartado3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import psp.unidad01.actividad07.utils.FileUtils;

/** Clase de suma de datos de contabilidad desde fichero */
public class SumaContabilidad {

  /**
   * Método principal. Lee la letra a contabilizar desde argumentos y cuenta sus repeticiones
   * 
   * @param args Argumentos
   * @throws IOException Error en el tratamiento con ficheros
   */
  public static void main(String[] args) throws IOException {

    // Comprobación de argumentos
    if (args.length == 0) {
      throw new IllegalArgumentException("Es necesario aportar como mínimo una vocal.");
    }

    // Suma y envío de información al proceso maestro
    int result = FileUtils.sumNumbersFromFile(new File(args[0]));

    PrintWriter pw = new PrintWriter(System.out);
    pw.println(result);
    pw.flush();

    pw.close();
  }

}
