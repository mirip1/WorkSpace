package prog.unidad06.arraysuni.ejercicio02;

import java.util.Random;

public class UtilidadesArrays {
  public static int[] generaArrayEnteroAleatorio(int longitud, int valorMinimo, int valorMaximo) {
    if (longitud>0) {
      Random enteroAleatorio = new Random();
      int[] array = new int[longitud];
      for (int i = 0; i != array.length; i++) {
        array[i] = enteroAleatorio.nextInt(valorMinimo, valorMaximo);
      }
      return array;
    }else {
      throw new IllegalArgumentException();
    }
  }

}
