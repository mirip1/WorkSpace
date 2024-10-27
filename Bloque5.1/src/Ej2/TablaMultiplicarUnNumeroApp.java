package Ej2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TablaMultiplicarUnNumeroApp {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);
    String ruta = "C:\\Users\\mivel\\OneDrive\\Escritorio\\crearFichero\\ficher.txt";
    if (args.length != 0) {
      ruta = args[0];
    }else {
      System.out.println("Especifique la ruta de archivo: ");
      ruta = scan.nextLine();
    }
    //Intentamos encontrar el archivo
    try (BufferedReader flujoTexto = new BufferedReader(new FileReader(ruta))){
      
      String linea = null;
      do {
        linea = flujoTexto.readLine();
        if (linea != null) {
          System.out.println(linea);
        }
        
      }while (linea != null);
      
      
      
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("error");

    }catch (IOException e) {
      e.printStackTrace();
      System.out.println("error");

    }
    
    
    
  }

}
