package models;

/**
 * Clase que simula una pelicula
 */
public class Pelicula {
  
  
  private int id;
  private String titulo;
  private String anyo;
  private int idIdioma;
  private int idIOridioma;
  private int durationRent;
  private double ratioRent;
  private double duracion;
  private String puntuacion;
  private String ultimaActualizacion;
  
  
  
  public Pelicula(int id, String titulo, String description, String anyo, int idIdioma, int idIOridioma, int durationRent,
      double ratioRent, double duracion, String puntuacion, String ultimaActualizacion) {
    super();
    this.id = id;
    this.titulo = titulo;
    this.description = description;
    this.anyo = anyo;
    this.idIdioma = idIdioma;
    this.idIOridioma = idIOridioma;
    this.durationRent = durationRent;
    this.ratioRent = ratioRent;
    this.duracion = duracion;
    this.puntuacion = puntuacion;
    this.ultimaActualizacion = ultimaActualizacion;
  }
//  /**
//   * Constructor
//   * @param id id de la pelicula
//   * @param titulo titulo de la pelicula
//   * @param año año de lanzamiento de la pelicula
//   */
//  public Pelicula(int id, String titulo, int anyo) {
//    super();
//    this.id = id;
//    this.titulo = titulo;
//    this.anyo = anyo;
//  }


  
  private String description;

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @return the titulo
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * @return the año
   */
  public String getAnyo() {
    return anyo;
  }

  @Override
  public String toString() {
    return "Pelicula [id=" + id + ", titulo=" + titulo + ", anyo=" + anyo + ", idIdioma=" + idIdioma + ", idIOridioma="
        + idIOridioma + ", durationRent=" + durationRent + ", ratioRent=" + ratioRent + ", duracion=" + duracion
        + ", puntuacion=" + puntuacion + ", ultimaActualizacion=" + ultimaActualizacion + ", description=" + description
        + "]";
  }

  /**
   * @return the idIdioma
   */
  public int getIdIdioma() {
    return idIdioma;
  }

  /**
   * @return the idIOridioma
   */
  public int getIdIOridioma() {
    return idIOridioma;
  }

  /**
   * @return the durationRent
   */
  public int getDurationRent() {
    return durationRent;
  }

  /**
   * @return the ratioRent
   */
  public double getRatioRent() {
    return ratioRent;
  }

  /**
   * @return the duracion
   */
  public double getDuracion() {
    return duracion;
  }

  /**
   * @return the puntuacion
   */
  public String getPuntuacion() {
    return puntuacion;
  }

  /**
   * @return the ultimaActualizacion
   */
  public String getUltimaActualizacion() {
    return ultimaActualizacion;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }
  
  
  
  
  
  
  
  

}
