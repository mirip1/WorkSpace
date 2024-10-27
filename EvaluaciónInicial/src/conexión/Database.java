package conexión;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Clase que controla las conexiones a la base de datos 
public class Database {
  
  private static final String URL = "jdbc:mysql://localhost/login";
  private Connection conn = null;
  public Database() {
    super();
  }
  
  //metodo para conectarse a la base de datos con sus respectivas credenciales
  public void conectarse(){
    try {
      conn = DriverManager.getConnection(URL, "root", "yolo");
      System.out.println("Se ha conectado correctamente a la BD");
    } catch (Exception e) {
//      e.printStackTrace();
      System.err.println("no e ha podido conectar a la BD");
    } ;
  }
  
  public boolean comprobador(String nombre, String contrasena) {
    String sent = "";
    try {
      Statement sentencia = conn.createStatement();
      sent = "select * from usuarios where nombre ='"+ nombre+"' and contraseña ='"+contrasena+"';";
//      System.out.println(sentencia.execute(sent));
      sentencia.execute(sent);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return false;
    
  }

}
