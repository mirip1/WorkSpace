package psp.unidad01.relacion04;

public class Ejercicio03 {

  public static void main(String[] args) {
    if (args.length >=1 ) {
      System.out.println("Estos son todos los parámetros convertidos a mayusculas: \n");
      for (String string : args) {
        System.out.print(string.toUpperCase());
      }
      
    }else {
      System.err.println("Error, se debe insertar al menos una cadena");
    }
    
    

  }

}
