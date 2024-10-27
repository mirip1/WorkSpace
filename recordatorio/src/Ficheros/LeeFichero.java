package Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class LeeFichero {
  public static void main(String[] arg) {
    File archivo = null;
    FileReader reader = null;
    FileWriter writer = null;
    BufferedReader buffer = null;
    BufferedWriter bufferW = null;
    archivo = new File("tonto.txt");
    try {
      
      reader = new FileReader(archivo);
      buffer = new BufferedReader(reader);
      String linea;
      while ((linea = buffer.readLine()) != null) {
        System.out.println(linea);
      }
    } catch (Exception e) {
      System.out.println("No se ha encontrado el archivo");
    } finally {
      try {
        if (null != buffer) {
          buffer.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    try {
      writer = new FileWriter(archivo);
      bufferW = new BufferedWriter(writer);
      for(int i = 0; i != 9; i++) {
        bufferW.write("Gohan");
        bufferW.newLine();
        
      }
      
    } catch (Exception e) {
      // TODO: handle exception
    }finally {
      try {
        bufferW.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      }
    
  }
}