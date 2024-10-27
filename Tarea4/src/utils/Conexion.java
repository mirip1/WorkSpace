package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que maneja las insercciones a la BBDD
 */
public class Conexion {

  /**
   * Metodo para insertar los datos de un profesor en su tabla
   * @param cn conexion de la BBDD
   * @param datos del profesor
   * @return el id del profesor
   */
  public int insertarProfesor(Connection cn, String[] datos) {

    String sql = "INSERT INTO Profesor (NIF, Nombre, Especialidad, Telefono) VALUES (?, ?, ?, ?)";
    try (PreparedStatement stm = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
      stm.setString(1, datos[1]);
      stm.setString(2, datos[2]);
      stm.setString(3, datos[3]);
      stm.setString(4, datos[4]);
      stm.executeUpdate();

      try (ResultSet rs = stm.getGeneratedKeys()) {
        if (rs.next()) {
          return rs.getInt(1);

        } else {
          throw new IllegalArgumentException("Error al obtener el ID del profesor.");
        }
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } catch (Exception e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    return 0;
  }

  
  /**
   * Metodo para insertar los datos de una asignatura en su tabla
   * @param cn conexion de la BBDD
   * @param datos de la adignatura
   * @param idProfesor id del profesor
   */
  public void insertarAsignatura(Connection cn, String[] datos, int idProfesor) {

    String sql = "INSERT INTO Asignatura (CodAsignatura, Nombre, IdProfesor) VALUES (?, ?, ?)";
    try (PreparedStatement stm = cn.prepareStatement(sql)) {
      stm.setString(1, datos[1]);
      stm.setString(2, datos[2]);
      stm.setInt(3, idProfesor);
      stm.executeUpdate();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
