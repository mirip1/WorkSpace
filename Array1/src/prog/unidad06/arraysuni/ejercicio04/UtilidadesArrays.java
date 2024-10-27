package prog.unidad06.arraysuni.ejercicio04;

import java.util.Random;

public class UtilidadesArrays {
  public static int[] generaArrayEnteroAleatorio(int longitud, int valorMinimo, int valorMaximo) {
    if (longitud>0) {
      Random enteroAleatorio = new Random();
      int[] array1 = new int[longitud];
      for (int i = 0; i != array1.length; i++) {
        array1[i] = enteroAleatorio.nextInt(valorMinimo, valorMaximo);
      }
      return array1;
    }else {
      throw new IllegalArgumentException();
    }
  }
  
  public static int getMinimoArrayEntero(int[] array) {
    try {
      if ((array.length>0) && (array != null)) {
  
        int minimo = array[0] ;
        for (int i = 0; i != array.length; i++) {
          if (array[i]<minimo) {
            minimo = array[i];
          }
        }
        return minimo;
      }else {
        throw new IllegalArgumentException();
      }
    }catch (NullPointerException e) {
      throw new IllegalArgumentException();
    }
  }
  
  public static int getMaximoArrayEntero(int[] array) {
    try {

      if (array.length>0 && array != null) {
    
        int maximo = array[0] ;
        for (int i = 0; i != array.length; i++) {
          if (array[i]>maximo) {
            maximo = array[i];
          }
        }
        return maximo;
      }else {
        throw new IllegalArgumentException();
      }
    }catch (NullPointerException e) {
      throw new IllegalArgumentException();
    }
  }
  
  public static int enteroApareceEnArrayEntero(int[] array, int valor) {
    int contador=0;
    if (array != null) {
      for (int i = 0; i != array.length; i++) {
        if(array[i] == valor) {
          contador++; 
        }
      }
      return contador;
    }else {
      return 0;
    }
    
  }
  

}
