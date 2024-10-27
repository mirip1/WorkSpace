package Fichero2Ej2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ListaPrimosTextoApp {
  public static void main(String[] args) {
    
 try (BufferedReader flujoTexto = new BufferedReader(new FileReader("ficheroDePrimos.txt"))){
      
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
