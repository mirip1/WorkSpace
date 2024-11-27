package models;

import java.io.Serializable;
import java.util.Date;

public class Juego implements Serializable{
   
  private static final long serialVersionUID = 1L;
  private int idJuego;
  private String titulo;
  private String descripcion;
  private Date fechaLanzamiento;
  private double puntuacionMetacritic;
  private String imagen;
  
  /**
   * Constructor vacio
   */
  public Juego() {
    
  }

  /**
   * Constructor de Juego
   * @param idJuego id del juego
   * @param titulo titulo del juego 
   * @param descripcion Descripcion del juego
   * @param fechaLanzamiento Fecha en la que se lanzo el Juego
   * @param puntuacionMetacritic Puntuacion Metacritic
   * @param imagen Imagen del juego
   */
  public Juego(int idJuego, String titulo, String descripcion, Date fechaLanzamiento, double puntuacionMetacritic,
      String imagen) {
    super();
    this.idJuego = idJuego;
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.fechaLanzamiento = fechaLanzamiento;
    this.puntuacionMetacritic = puntuacionMetacritic;
    this.imagen = imagen;
  }

  /**
   * @return the idJuego
   */
  public int getIdJuego() {
    return idJuego;
  }

  /**
   * @param idJuego the idJuego to set
   */
  public void setIdJuego(int idJuego) {
    this.idJuego = idJuego;
  }

  /**
   * @return the titulo
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * @param titulo the titulo to set
   */
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  /**
   * @return the descripcion
   */
  public String getDescripcion() {
    return descripcion;
  }

  /**
   * @param descripcion the descripcion to set
   */
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   * @return the fechaLanzamiento
   */
  public Date getFechaLanzamiento() {
    return fechaLanzamiento;
  }

  /**
   * @param fechaLanzamiento the fechaLanzamiento to set
   */
  public void setFechaLanzamiento(Date fechaLanzamiento) {
    this.fechaLanzamiento = fechaLanzamiento;
  }

  /**
   * @return the puntuacionMetacritic
   */
  public double getPuntuacionMetacritic() {
    return puntuacionMetacritic;
  }

  /**
   * @param puntuacionMetacritic the puntuacionMetacritic to set
   */
  public void setPuntuacionMetacritic(double puntuacionMetacritic) {
    this.puntuacionMetacritic = puntuacionMetacritic;
  }

  /**
   * @return the imagen
   */
  public String getImagen() {
    return imagen;
  }

  /**
   * @param imagen the imagen to set
   */
  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  @Override
  public String toString() {
    return "titulo=" + titulo + " descrip: "+ descripcion +"]";
  }
  
  
  
  
  
  
  

}
