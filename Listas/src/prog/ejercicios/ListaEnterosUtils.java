package prog.ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ListaEnterosUtils {

  public ListaEnterosUtils() {

  }

  public static List<Integer> generaListaEnterosAleatorios(int longitudMin, int longitudMax, int valorMin,
      int valorMax) {

    // Generador de números aleatorios
    Random random = new Random();

    // Si la longitud es correcta
    if (longitudMin >= 0 && longitudMin <= longitudMax) {
      // La calcula
      int longitud = random.nextInt(longitudMin, longitudMax + 1);
      // Si el rango de valores es correcto
      if (valorMin <= valorMax) {
        // Creamos la lista
        List<Integer> resultado = new ArrayList<>();
        // Mientras no lleguemos a la longitud
        for (int i = 0; i < longitud; i++) {
          // Generamos un valor aleatorio
          int valor = random.nextInt(valorMin, valorMax + 1);
          // Y lo añadimos a la lista
          resultado.add(valor);
        }
        // Devolvemos el resultado
        return resultado;
      } else {
        // El rango indicado no es correcto
        throw new IllegalArgumentException();
      }
    } else {
      // El rango de la longitud no es correcto
      throw new IllegalArgumentException();
    }
  }

  public static String generaCadena(List<Integer> lista) {
    String salida = "";
    // Si el parámetro no es null
    if (lista != null) {
      // Genera el paréntesis de apertura
      salida += "(";
      // Flag para generar o no comas
      boolean coma = false;
      // Para cada elemento de la lista
      for (int valor : lista) {
        // Si se debe generar la coma
        if (coma) {
          // Se genera
          salida += ", ";
        } else {
          // En esta iteración no se genera pero en la siguiente si
          coma = true;
        }
        // Genera el valor
        salida += valor;
      }
      // Se genera el paréntesis de cierre
      salida += ")";
    }
    return salida;
  }
}
