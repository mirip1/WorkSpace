package main;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.Conexion;

public class CargarDatos {
  

  private static final String URL = "jdbc:mysql://localhost:3306/ejemplo";
  private static final String USER = "root";
  private static final String PASSWORD = "yolo";

  public static void main(String[] args) {
    String archivo = "src/archivo.txt";
    Conexion manejo = new Conexion();

    try (Connection cn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      cn.setAutoCommit(false);

      try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        int idProfesor = 0;

        while ((linea = br.readLine()) != null) {

          String[] partes = linea.split(";");

          if (partes[0].equals("Profesor")) {
            idProfesor = manejo.insertarProfesor(cn, partes);
          } else if (partes[0].equals("Asignatura") && idProfesor != 0) {
            manejo.insertarAsignatura(cn, partes, idProfesor);
          }
        }
        cn.commit();
      } catch (Exception e) {
        cn.rollback();
        e.printStackTrace();
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
