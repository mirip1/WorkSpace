import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class poblaciones {
  
  private static final String URL = "jdbc:sqlite:db/poblaciones.db";

  public static void main(String[] args) {
    
    try (Connection conexion = DriverManager.getConnection(URL);){
      PreparedStatement sentencia = conexion.prepareStatement("Select * from pueblos;");
      ResultSet rs = sentencia.executeQuery();
      
      List<String> lista = new ArrayList<>();
      while(rs.next()) {
        lista.add(rs.getString("nombre"));
        
      }
      for (String i : lista) {
       if(i.charAt(0) == 'A') {
         System.out.println(i);
       }
        
      }
      
     // Creamos el SQL para la sentencia
    
     // Y la ejecutamos
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   }
  }


