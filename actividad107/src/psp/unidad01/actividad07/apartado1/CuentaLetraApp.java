package psp.unidad01.actividad07.apartado1;

import java.io.File;
import java.io.IOException;

import psp.unidad01.actividad07.utils.FileUtils;

/** Clase de conteo de letras */
public class CuentaLetraApp {

  /** Ruta hacia el fichero de lectura */
  private static final String TEXT_URL = "text.txt";

  /** Archivo base donde se almacenan los datos del conteo */
  private static final String COUNT_FILE_URL = "fichero-%s.txt";

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

    char letter = args[0].charAt(0);
    int counter = FileUtils.countLetterFromFile(letter, new File(TEXT_URL));
    FileUtils.writeNumber(counter, new File(String.format(COUNT_FILE_URL, letter)));
  }

}
