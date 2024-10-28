package psp.unidad01.actividad07.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/** Clase de utilidades para el acceso de información a ficheros */
public class FileUtils {

  /** Método privado para evitar inicialización de clase */
  private FileUtils() {
  }

  /**
   * Lee el número almacenado en un fichero
   * 
   * @param file Fichero del cual extraer la información
   * @return int
   * @throws IOException           En caso de que haya un problema durante el acceso al fichero
   * @throws FileNotFoundException Si el fichero no existe
   * @throws NumberFormatException En caso que los datos almacenados en el fichero no sean correctos
   */
  public static int readNumber(File file) throws FileNotFoundException, IOException {

    try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
      return Integer.parseInt(fr.readLine());
    }
  }

  /**
   * Escribe el número en un fichero dado
   * 
   * @param number Número a escribir
   * @param file   Fichero en el cual escribir
   * @throws IOException En caso de que haya un problema durante el acceso al fichero
   */
  public static void writeNumber(int number, File file) throws IOException {

    try (PrintWriter fr = new PrintWriter(new FileWriter(file))) {
      fr.print(number);
    }
  }

  /**
   * Método que cuenta todas las coincidencias de letras del fichero
   * 
   * @param letter Letra a contar
   * @param file   Fichero en el cual buscar
   * @return int
   * @throws IOException En caso de que haya un problema durante el acceso al fichero
   */
  public static int countLetterFromFile(char letter, File file) throws IOException {

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {

      String line;
      int counter = 0;
      letter = Character.toLowerCase(letter);

      // Lectura y suma de contador al coincidir
      while ((line = br.readLine()) != null) {

        line = line.toLowerCase();
        char[] splittedLine = line.toCharArray();

        for (char character : splittedLine) {
          if (character == letter) {
            counter++;
          }
        }
      }

      return counter;
    }
  }

  /**
   * Método que suma todos los números de un fichero
   * 
   * @param file Fichero en el cual se encuentra la información
   * @return int
   * @throws IOException           En caso de que haya un problema durante el acceso al fichero
   * @throws NumberFormatException En caso que alguno de los datos del fichero no sea numérico
   */
  public static int sumNumbersFromFile(File file) throws IOException {

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      int sum = 0;

      // Lectura y suma de contador al coincidir
      while ((line = br.readLine()) != null) {
        sum += Integer.parseInt(line);
      }

      return sum;
    }
  }

}
