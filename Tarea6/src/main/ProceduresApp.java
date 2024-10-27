package main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProceduresApp {
  private static final String URL = "jdbc:mysql://localhost:3306/bd_neptuno2";
  private static final String USER = "root";
  private static final String PASSWORD = "yolo";
  private static final String QUERY = "{call getContacto (?, ?)}";
  
  public static void main(String[] args) {
    
    try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        CallableStatement stmt = conn.prepareCall(QUERY);
     ) {         

        stmt.setInt(1, 2);  
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        
        stmt.execute();
        
        String empName = stmt.getString(2);
        System.out.println("El contacto con ID = 2 is " + empName);
     } catch (SQLException e) {
        e.printStackTrace();
     } 
    
  }

}
