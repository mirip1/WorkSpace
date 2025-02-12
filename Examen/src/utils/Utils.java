package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Pelicula;

public class Utils {
  static final String URL = "jdbc:mysql://localhost:3306/sakila";
  static final String USER = "root";
  static final String PASSWORD = "yolo";

  /**
   * metodo quie crea una tabla y la rellena
   */
  public void crearTablaPeliculas() {

    try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

      String comandos = "create table if not exists PeliculasCortas (" + "film_id int primary key,"
          + "title varchar(128)," + "description text(30)," + "release_year year DEFAULT NULL,"
          + "language_id tinyint unsigned NOT NULL," + "length int DEFAULT NULL,"
          + "rating enum('G','PG','PG-13','R','NC-17') DEFAULT 'G'," + " KEY `idx_title` (`title`),"
          + "KEY `idx_fk_language_id` (`language_id`),"
          + "CONSTRAINT `fk_film_language2` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`) ON DELETE RESTRICT ON UPDATE CASCADE"
          + ");";

      try (Statement stmt = con.createStatement()) {

        stmt.execute(comandos);
        System.out.println("Tabla creada exitosamente.");
      } catch (Exception e) {
        e.printStackTrace();

      }
      String rellenar = "INSERT INTO PeliculasCortas"
          + "         SELECT film_id, title, description, release_year, language_id, length, rating"
          + "         FROM film;";
      try (Statement stmt = con.createStatement()) {

        stmt.execute(rellenar);
        System.out.println("Tabla rellenada exitosamente.");
      } catch (Exception e) {
        e.printStackTrace();

      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  /**
   * metodo que rellena una tabla a partir de un archivo .csv
   */
  public void cargarPeliculas(String ruta) {

    if (!ruta.endsWith(".csv")) {
      throw new IllegalArgumentException();
    }

    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
      String linea;
      int id = 0;
      String title = "";
      String description = "";
      int release_year = 0;
      int language_id = 0;
      double length = 0;
      String rating = "";

      int cont = 0;

      while ((linea = br.readLine()) != null) {

        String[] partes = linea.split(";");
        id = Integer.parseInt(partes[0]);
        title = partes[1];
        description = partes[2];
        release_year = Integer.parseInt(partes[3]);
        language_id = Integer.parseInt(partes[4]);
        length = Double.parseDouble(partes[5]);
        rating = partes[6];

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
          con.setAutoCommit(false);
          String sql = "INSERT INTO PeliculasCortas * VALUES (?, ?, ?, ?, ?, ?, ?)";
          try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, id);
            stm.setString(2, title);
            stm.setString(3, description);
            stm.setInt(4, release_year);
            stm.setInt(5, language_id);
            stm.setDouble(6, length);
            stm.setString(7, rating);

            stm.addBatch(sql);
            cont++;

            if (cont == 10) {
              stm.executeBatch();
              stm.clearBatch();
              cont = 0;
            }

          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            con.rollback();
          }
          con.commit();

        } catch (Exception e) {
          // TODO: handle exception
          e.printStackTrace();

        }

      }

    } catch (Exception e2) {
      // TODO Auto-generated catch block
      e2.printStackTrace();
    }
  }

  /**
   * @param language Nombre del idioma
   * @param texto si el archivo se va a escribir en csv o en binario
   */
  public void peliculasToFichero(String language, boolean texto) {
    List<Pelicula> peliculas = obtenerPeliculasPorIdioma(language); 

    if (texto) {
      
      String archivo = "peliculas_lang_" + language + ".csv";
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
        for (Pelicula pelicula : peliculas) {
          
          writer.write(pelicula.getId() + ";" + pelicula.getTitle() + ";" + pelicula.getDescription() + ";"
              + pelicula.getRelease_year() + ";" + pelicula.getLanguage_id() + ";" + pelicula.getLength() + ";"
              + pelicula.getRating() + "\n");
        }
        System.out.println("Archivo de texto creado: " + archivo);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      String archivo = "peliculas_lang_" + language + ".dat";
      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
        for (Pelicula pelicula : peliculas) {
          oos.writeObject(pelicula);
        }
        System.out.println("Archivo binario creado: " + archivo);
      } catch (IOException e) {
        e.printStackTrace();
      }
      
    }
  }

  /**
   * metodo para obtener las películas filtradas por idioma desde la base de
   * datos.
   * @param language Nombre del idioma
   * @return Lista de películas en el idioma especificado
   */
  private List<Pelicula> obtenerPeliculasPorIdioma(String language) {
    List<Pelicula> peliculas = new ArrayList<>();

    String sql = """
        select p.film_id, p.title, p.description, p.release_year, p.language_id, p.length, p.rating
        from PeliculasCortas p
        join language l ON p.language_id = l.language_id
        where l.name = ?
        """;

    try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement stmt = con.prepareStatement(sql)) {

      stmt.setString(1, language); 
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        
        
        Pelicula pelicula = new Pelicula(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"),
            rs.getInt("release_year"), rs.getInt("language_id"), rs.getDouble("length"), rs.getString("rating"));
        peliculas.add(pelicula);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return peliculas;
  }
  
  
  /**
   * 
   * @param fichero ruta de fichero.dat
   */
  public void cargarPeliculaBinario(String ruta) {

    if (!ruta.endsWith(".dat")) {
      throw new IllegalArgumentException();
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
      Pelicula pelicula;
      int id = 0;
      String title = "";
      String description = "";
      int release_year = 0;
      int language_id = 0;
      double length = 0;
      String rating = "";

      int cont = 0;

      while (true) {
        
        pelicula = (Pelicula) ois.readObject();
        
        
        
        id = pelicula.getId();
        title = pelicula.getTitle();
        description = pelicula.getDescription();
        release_year = pelicula.getRelease_year();
        language_id = pelicula.getLanguage_id();
        length = pelicula.getLength();
        rating = pelicula.getRating();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
          con.setAutoCommit(false);
          String sql = "insert into PeliculasCortas * values (?, ?, ?, ?, ?, ?, ?);";
          try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, id);
            stm.setString(2, title);
            stm.setString(3, description);
            stm.setInt(4, release_year);
            stm.setInt(5, language_id);
            stm.setDouble(6, length);
            stm.setString(7, rating);

            stm.addBatch(sql);
            cont++;

            if (cont == 5) {
              stm.executeBatch();
              stm.clearBatch();
              cont = 0;
            }

          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            con.rollback();
          }
          con.commit();

        } catch (Exception e) {
          // TODO: handle exception
          e.printStackTrace();

        }

      }

    } catch (Exception e2) {
      // TODO Auto-generated catch block
      e2.printStackTrace();
    }
    
    
  }

}
