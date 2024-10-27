package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Actor;
import models.Pelicula;

/**
 * Clase qu maneja todo lo que es el jdbc
 */
public class Conexion {

  static final String URL = "jdbc:mysql://localhost:3306/sakila";
  static final String USER = "root";
  static final String PASSWORD = "yolo";
  private static Connection connection;

//  public static Connection conectarse() {
//    try {
//      System.out.println("Conexión a MySQL exitosa");
//      return connection = DriverManager.getConnection(URL, USER, PASSWORD);
//      
//      
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//    return null;
//    
//  }

  /**
   * metodo que devuelve una lista de todas las peliculas
   * 
   * @return
   */
  public List<Pelicula> pillaPeliculas() {

    List<Pelicula> peliculas = new ArrayList();
    String query = "select film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, rating, last_update from film;";
    try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        Integer id = rs.getInt(1);
        String title = rs.getString(2);
        String descp = rs.getString(3);
        String anyo = rs.getString(4);
        Integer lang = rs.getInt(5);
        Integer langOr = rs.getInt(6);
        Integer rentDur = rs.getInt(7);
        Double rentRati = rs.getDouble(8);
        Double duration = rs.getDouble(9);
        String puntuacion = rs.getString(10);
        String ultima = rs.getString(11);

        peliculas
            .add(new Pelicula(id, title, descp, anyo, lang, langOr, rentDur, rentRati, duration, puntuacion, ultima));

      }
      System.out.println("Esto furula");
      return peliculas;

    } catch (Exception e) {
      e.printStackTrace();

    }

    return null;
  }

  /**
   * metodo que devuelve una lista de los actores segun el id de la pelicula
   * 
   * @param idPelicula id de la pelicula
   * @return lista de los nombres de los actores que participan
   */
  public List<Actor> mostrarActores(int idPelicula) {

    List<Actor> actores = new ArrayList<>();
    String query = "SELECT a.actor_id ,a.first_name, a.last_name FROM actor a JOIN film_actor fa ON a.actor_id = fa.actor_id WHERE fa.film_id = "
        + idPelicula + ";";

    try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        Integer id = rs.getInt(1);
        String nombre = rs.getString(2);
        String apellidos = rs.getString(3);
        actores.add(new Actor(id, nombre, apellidos));

      }
      System.out.println("Esto furula");
      return actores;

    } catch (Exception e) {
      System.out.println("Esto no furula");
      e.printStackTrace();

    }
    System.out.println("Esto no furula");

    return null;

  }

  /**
   * Busca una pelicula de una lista dada
   * 
   * @param lista
   * @param id
   * @return
   */
  public Pelicula buscarPelicula(List<Pelicula> lista, int id) {

    for (Pelicula pelicula : lista) {
      if (pelicula.getId() == id) {
        return pelicula;

      }
    }

    System.out.println("No existe pelicula con este ID");
    return null;
  }

  public void insertarPelícula(String titulo, String descripcion, String anyo, int idioma,
      int idiomaOri, int duracion, double ratio, double duracionReal, String puntuacion,
      String ultimaActualizacion) {
      
    try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);){
      PreparedStatement stmt = con.prepareStatement(
          "INSERT INTO film "
          + "(title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, rating, last_update)"
          + "VALUES "
          + "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
          );
      stmt.setString(1, titulo);
      stmt.setString(2, descripcion);
      stmt.setString(3, anyo);
      stmt.setInt(4, idioma);
      stmt.setInt(5, idiomaOri);
      stmt.setInt(6, duracion);
      stmt.setDouble(7, ratio);
      stmt.setDouble(8, duracionReal);
      stmt.setString(9, puntuacion);
      stmt.setString(10, ultimaActualizacion);
      stmt.executeUpdate();
      
    } catch (Exception e) {
      System.err.println("El campo puntuacion debe ser ('G','PG','PG-13','R','NC-17')");
      System.err.println("La fecha tiene que ser el formato: 2006-02-15 05:03:42");
    }
    
    
    
  }

  /**
   * @return the connection
   */
  public static Connection getConnection() {
    return connection;
  }

}
