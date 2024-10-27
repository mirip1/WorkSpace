import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.*;

public class comparadorApp {

  public static void main(String[] args) {


    String filePathFollowers = "C:\\Users\\mivel\\OneDrive\\Documents\\instagram-el_miguel_vf-2024-10-01-HTTKTFcf\\connections\\followers_and_following\\followers_1.json";
    String filePathFollowing = "C:\\Users\\mivel\\OneDrive\\Documents\\instagram-el_miguel_vf-2024-10-01-HTTKTFcf\\connections\\followers_and_following\\following.json";
   
    try {
      List<String> values = JsonExtractor.extractValues(filePathFollowers);
      List<String> values2 = JsonExtractor.extractFollowingValues(filePathFollowing);

      // Imprimir los valores extraídos
      for (String value : values2) {
        if(!(values.contains(value))) {
          System.out.println(value);
        }
        
      }
      

    } catch (IOException e) {
      System.out.println("Error al leer el archivo: " + e.getMessage());
    }

  }

}
