package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainApp {
  private static final String URL = "jdbc:mysql://localhost:3306/bd_neptuno2";
  private static final String USER = "root";
  private static final String PASSWORD = "yolo";

  public static void main(String[] args) {

    try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
      Statement stmt = con.createStatement();
      String sql;

   // Sentencias INSERT corregidas con 11 valores
      sql = "INSERT INTO Clientes (codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) " +
            "VALUES ('FAMSI', 'Fabrica de Sillas', 'Fernando Simón', 'Gerente', 'Calle Falsa 123', 'Madrid', 'Madrid', '28080', 'España', '915-123456', '915-654321');";
      stmt.addBatch(sql);

      sql = "INSERT INTO Clientes (codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) " +
            "VALUES ('SUPLI', 'Supermercados Linares', 'Luis Linares', 'Director', 'Avenida Principal 12', 'Sevilla', 'Andalucía', '41012', 'España', '954-678901', '954-876543');";
      stmt.addBatch(sql);

      sql = "INSERT INTO Clientes (codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) " +
            "VALUES ('PAPES', 'Papelería España', 'Ana López', 'Propietaria', 'Calle Larga 45', 'Valencia', 'Comunidad Valenciana', '46010', 'España', '963-111222', '963-333444');";
      stmt.addBatch(sql);
 
      sql = "INSERT INTO Clientes (codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) " +
            "VALUES ('COLSA', 'Colchones Salva', 'María Salvatierra', 'Administradora', 'Calle del Sueño 78', 'Granada', 'Andalucía', '18008', 'España', '958-987654', '958-123987');";
      stmt.addBatch(sql);

      sql = "INSERT INTO Clientes (codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) " +
            "VALUES ('ELECT', 'Electrodomésticos Torres', 'Pedro Torres', 'Gerente General', 'Calle Circuito 25', 'Barcelona', 'Cataluña', '08020', 'España', '933-567890', '933-765432');";
      stmt.addBatch(sql);
      
      stmt.executeBatch();
      stmt.clearBatch();
      
      sql = "INSERT INTO Clientes (codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) " +
            "VALUES ('PEREZ', 'Pérez e Hijos', 'Carlos Pérez', 'Dueño', 'Calle Familiar 9', 'Murcia', 'Murcia', '30007', 'España', '968-112233', '968-445566');";
      stmt.addBatch(sql);

      sql = "INSERT INTO Clientes (codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) " +
            "VALUES ('TECMI', 'Tecnología Micro', 'Miguel Rodríguez', 'Gerente de Ventas', 'Parque Empresarial 34', 'Bilbao', 'País Vasco', '48002', 'España', '944-556677', '944-778899');";
      stmt.addBatch(sql);

      sql = "INSERT INTO Clientes (codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) " +
            "VALUES ('MODSA', 'Moda Salvatore', 'Roberto Salvatore', 'Propietario', 'Paseo de la Moda 1', 'Málaga', 'Andalucía', '29015', 'España', '952-334455', '952-778899');";
      stmt.addBatch(sql);

      sql = "INSERT INTO Clientes (codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) " +
            "VALUES ('VIDRI', 'Vidrierías del Sur', 'Laura Jiménez', 'Jefa de Compras', 'Camino del Cristal 67', 'Vigo', 'Galicia', '36204', 'España', '986-223344', '986-556677');";
      stmt.addBatch(sql);

      sql = "INSERT INTO Clientes (codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) " +
            "VALUES ('FLOSA', 'Floristería Salvia', 'Lucía Ramos', 'Gerente de Marketing', 'Calle de las Flores 10', 'Córdoba', 'Andalucía', '14012', 'España', '957-665544', '957-887766');";
      stmt.addBatch(sql);

      stmt.executeBatch();
      stmt.clearBatch();
      
      // Sentencias UPDATE
      sql = "UPDATE Clientes SET empresa = 'Fabrica de Sillas Modernas', contacto = 'Fernando Martínez' WHERE codigo = 'FAMSI';";
      stmt.addBatch(sql);

      sql = "UPDATE Clientes SET direccion = 'Avenida Principal 15', cp = '41014' WHERE codigo = 'SUPLI';";
      stmt.addBatch(sql);

      sql = "UPDATE Clientes SET telefono = '963-222333', fax = '963-444555' WHERE codigo = 'PAPES';";
      stmt.addBatch(sql);

      sql = "UPDATE Clientes SET contacto = 'María del Carmen Salvatierra', cargo_contacto = 'Gerente General' WHERE codigo = 'COLSA';";
      stmt.addBatch(sql);

      sql = "UPDATE Clientes SET ciudad = 'Terrassa', telefono = '937-456789' WHERE codigo = 'ELECT';";
      stmt.addBatch(sql);
      
      stmt.executeBatch();
      stmt.clearBatch();

      sql = "UPDATE Clientes SET contacto = 'Carlos Pérez Jr.', cargo_contacto = 'Director General' WHERE codigo = 'PEREZ';";
      stmt.addBatch(sql);

      sql = "UPDATE Clientes SET telefono = '944-667788', fax = '944-889900' WHERE codigo = 'TECMI';";
      stmt.addBatch(sql);

      sql = "UPDATE Clientes SET direccion = 'Paseo de la Moda 2', cp = '29016' WHERE codigo = 'MODSA';";
      stmt.addBatch(sql);

      sql = "UPDATE Clientes SET empresa = 'Vidrierías del Norte', ciudad = 'Santiago de Compostela' WHERE codigo = 'VIDRI';";
      stmt.addBatch(sql);

      sql = "UPDATE Clientes SET contacto = 'Lucía García', cargo_contacto = 'Gerente de Operaciones' WHERE codigo = 'FLOSA';";
      stmt.addBatch(sql);
      
      int[] count = stmt.executeBatch();

      con.commit();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
