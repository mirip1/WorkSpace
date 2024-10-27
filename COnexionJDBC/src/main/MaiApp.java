package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.Conexion;

public class MaiApp {

  public static void main(String[] args) {

    Conexion con = new Conexion();
    
    Connection conn = con.conectarse();
    
    if (conn != null) {
        try {
            // Crear una declaración
            Statement stmt = con.getConnection().createStatement();
            
            // Ejecutar una consulta
            String query = "SELECT * FROM categorias";
            ResultSet rs = stmt.executeQuery(query);
            
            // Procesar los resultados
            while (rs.next()) {
                // Suponiendo que tu tabla tiene una columna llamada 'columna1'
                String columna1 = rs.getString("categoria");
                System.out.println("categoria: " + columna1);
            }
            
            con.cerrarse();
        }catch (Exception e) {
          e.printStackTrace();
        }
        }
    
    
  }

}
