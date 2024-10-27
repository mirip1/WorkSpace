package prog.unidad06.arraysuni.ejercicio05;

import prog.unidad06.arraysuni.ejercicio04.UtilidadesArrays;

public class ProcesaAleatorios {
  
  public static void main(String[] args) {
    System.out.println("CREAMOS UN ARRAY DE 150 ELEMENTOS ALEATORIOS CON VALORES DESDE EL 1 AL 300");
    int[] prueba = UtilidadesArrays.generaArrayEnteroAleatorio(150, 1, 300);
    System.out.println("El valor mayor es : "+ UtilidadesArrays.getMaximoArrayEntero(prueba));
    System.out.println("El valor minimo es : "+ UtilidadesArrays.getMinimoArrayEntero(prueba));
    System.out.println("El valor mayor aparece : "+ UtilidadesArrays.enteroApareceEnArrayEntero(prueba, UtilidadesArrays.getMaximoArrayEntero(prueba))+" veces") ;
    System.out.println("El valor minimo aparece : "+ UtilidadesArrays.enteroApareceEnArrayEntero(prueba, UtilidadesArrays.getMinimoArrayEntero(prueba))+" veces") ;
    
    
  }

  
}
