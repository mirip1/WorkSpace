package recordatorio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hola {

  public static void main(String[] args) throws IOException {
    List<String> hola = new ArrayList<>();
    hola.add("hola");
    hola.add("holas");
    hola.add("holass");
    hola.add("holasss");
    hola.add("holasssss");
    for (String string : hola) {
      System.out.println(string.toUpperCase());
    }
    
    
//    // TODO Auto-generated method stub
//    File archivo = new File("tonto.txt");
//    FileReader reader;
//    try {
//      BufferedReader lector =   new BufferedReader ( reader = new FileReader(archivo));
//      System.out.println(lector.readLine());
//      
//    } catch (FileNotFoundException e) {
//
//      e.printStackTrace();
//    }
//    for(int i =0; i != 10; i++  ) {
//      System.out.println("Hola"+i);
//      
//    }
  }

}
