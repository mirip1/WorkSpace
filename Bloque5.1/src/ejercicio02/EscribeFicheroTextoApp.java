package ejercicio02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscribeFicheroTextoApp {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean anyadir = true;
    String ruta = "hola.txt";
   
    try (PrintWriter flujoSalida = new PrintWriter(new FileWriter(ruta, anyadir))){
       
      for (int i = 0 ; i != 99; i++) {
        flujoSalida.printf("%d%n", -i);
      }
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.print("ERROR");
    }
    
  }
}
