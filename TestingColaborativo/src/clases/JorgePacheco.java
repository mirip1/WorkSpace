package clases;

import java.util.Random;

public class JorgePacheco {

  /**
   * Método que genera un array de números enteros (aleatorios dentro de un rango)
   * @param longitud Longitud del array. Debe ser mayor que cero
   * @param valorMinimo Valor mínimo del array a generar. Debe ser menor que el valor máximo
   * @param valorMaximo Valor máximo del array a generar. Debe ser mayor que el valor mínimo
   * @return Array de valores aleatorios (de tipo entero) con la longitud especificada
   * @throws IllegalArgumentException Si la longitud es menor que cero o el valor máximo es menor o igual al mínimo
   */
  public static int[] generaArrayEnteroAleatorio(int longitud, int valorMinimo, int valorMaximo) {

    if (longitud <= 0 || valorMaximo <= valorMinimo) {
      throw new IllegalArgumentException();
    }

    int[] array = new int[longitud];
    Random aleatorio = new Random();
    for (int i = 0; i < longitud; i++) {
      int numAleatorio = aleatorio.nextInt(valorMinimo, valorMaximo);
      array[i] = numAleatorio;
    }

    return array;
  }

  /**
   * Método que encuentra y devuelve el valor mínimo en un array de enteros
   * @param array Array de enteros del que se quiere encontrar el valor mínimo
   *              No puede ser null y debe tener al menos un elemento
   * @return El valor mínimo encontrado en el array
   * @throws IllegalArgumentException Si el array es null o está vacío
   */
  public static int getMinimoArrayEntero(int[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException();
    }

    int numMinimo = array[0];
    for (int numerosArray : array) {
      if (numMinimo > numerosArray) {
        numMinimo = numerosArray;
      }
    }

    return numMinimo;
  }

  /**
   * Método que encuentra y devuelve el valor máximo en un array de enteros
   * @param array Array de enteros del que se quiere encontrar el valor máximo
   *              No puede ser null y debe tener al menos un elemento
   * @return El valor máximo encontrado en el array
   * @throws IllegalArgumentException Si el array es null o está vacío
   */
  public static int getMaximoArrayEntero(int[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException();
    }

    int numMaximo = array[0];
    for (int numerosArray : array) {
      if (numMaximo < numerosArray) {
        numMaximo = numerosArray;
      }
    }
    return numMaximo;
  }

  /**
   * Método que cuenta y devuelve el número de veces que un entero específico aparece en un array de enteros
   * @param array Array de enteros en el que se buscará el número. No puede ser null y debe tener al menos un elemento
   * @param numero El número entero que se buscará en el array
   * @return Número de veces que el entero especificado aparece en el array. Si el array es null o está vacío, devuelve 0.
   */
  public static int enteroApareceEnArrayEntero(int[] array, int numero) {
    if (array == null || array.length == 0) {
      return 0;
    }

    int contadorValores = 0;

    for (int valor : array) {
      if (valor == numero) {
        contadorValores++;
      }
    }

    return contadorValores;
  }
}
