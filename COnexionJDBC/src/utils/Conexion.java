package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
  
  static final String URL = "jdbc:mysql://localhost:3306/bd_neptuno2";
  static final String USER = "root";
  static final String PASSWORD = "yolo";
  private Connection connection;
  
  public Connection conectarse() {
    try {
      System.out.println("Conexión a MySQL exitosa");
      return connection = DriverManager.getConnection(URL, USER, PASSWORD);
      
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
    
  }
  
  public  void cerrarse() {
    try {
      connection.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * @return the connection
   */
  public Connection getConnection() {
    return connection;
  }
  
  

}
