package prog.actividad.uno;

import java.util.Scanner;

public class Uno {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);
    System.out.println("Escribe una cadena que cumpla la expresion");
    for (int i=0 ; i!=100; i++) {
      String cadena1 = "1223";
      
      String cadena2 = "\\d*";
  //    String cadena2 = scan.nextLine();
      System.out.println(cadena1.matches(cadena2));

    } 
  }

}
