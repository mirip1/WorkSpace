package psp.unidad01.relacion03;

import java.util.Iterator;
import java.util.Scanner;

public class EchoCommandLineMandatory {
  public static void main(String[] args) {
    
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Escribe dos parametros: ");
    String cadena = "";
    
    for (int i=2; i != 0; i--) {
      System.out.println("Te quedan " + i + " parametro/s por escribir");
      String p1 = sc.nextLine();
      
      if (!p1.isEmpty()) {
        cadena += " " + p1;
      }else {
        i++;
        System.err.println("Tienes que escribir 2 parametros");
      }
      
    }
    
    System.out.println("Este son tus parametros: " + cadena);
    
    
    
  }
}
