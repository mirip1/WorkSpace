package psp.unidad01.relacion05.ejercicio2;

public class LlamaGenerador {

  public static void main(String[] args) {
    String[] comando = {"cmd","/c" ,"javac", ".//src//psp//unidad01//relacion05//ejercicio2//Generador.java"};
    String[] comando2 = {"cmd", "/c" ,"java", ".//src//psp//unidad01//relacion05//ejercicio2//Generador.java"};
    
    try {
      //primero hacemos un proec
      ProcessBuilder constructor = new ProcessBuilder(comando);
      Process proceso = constructor.start();
      //ejecutamos el .class
      ProcessBuilder constructor2 = new ProcessBuilder(comando2);
      Process proceso2 = constructor2.start();
      
      
    }catch (Exception e) {
      
    }
    
  }

}
