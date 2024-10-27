package Fichero2Ej3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GeneraCremalleraTextoApp {

  public static void main(String[] args) {

    List<String> lista1 = new ArrayList();
    List<String> lista2 = new ArrayList();
    
    
    try (BufferedReader flujoTexto1 = new BufferedReader(new FileReader("actividad503c_prueba_entrada_1.txt"))) {
      
      String linea = null;
      do {
        linea = flujoTexto1.readLine();
        if (linea != null) {
          lista1.add(linea);
          System.out.println(linea);
        }
        
      } while (linea != null);
      
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("error");
      
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("error");
      
    }
    
    try (BufferedReader flujoTexto2 = new BufferedReader(new FileReader("actividad503c_prueba_entrada_2.txt"))) {

      String linea = null;
      do {
        linea = flujoTexto2.readLine();
        if (linea != null) {
          lista2.add(linea);
          System.out.println(linea);

        }

      } while (linea != null);

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("error");

    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("error");

    }
    
    try (PrintWriter escritor = new PrintWriter(new FileWriter("archivoCremallera.txt"))){
      for (int i = 0; i != (lista1.size()+lista2.size()); i++) {
        boolean primero = true;
        
        if (primero) {
          escritor.printf("%n",lista1.get(i) );
          primero=false;
        }else {
          escritor.printf("%n", lista2.get(i) );
        }
      }
      
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
