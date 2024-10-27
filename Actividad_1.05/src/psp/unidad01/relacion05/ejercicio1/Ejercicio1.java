package psp.unidad01.relacion05.ejercicio1;

import java.io.IOException;

public class Ejercicio1 {

  public static void main(String[] args) {
    
    String[] comando = {"cmd", "/c", "xcopy", "C:\\Windows\\explorer.exe", "."};    
    
    ProcessBuilder constructor = new ProcessBuilder(comando);
    try {
      Process proceso = constructor.start();
      
      
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    

    
    
  }

}
