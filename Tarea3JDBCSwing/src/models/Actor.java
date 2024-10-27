package models;

public class Actor {
  
  private int id;
  private String nombre;
  private String Apellidos;
  
  /**
   * Constructor de actores
   * @param id id del actor
   * @param nombre nombre del actor
   * @param apellidos apellido del actor
   */
  public Actor(int id, String nombre, String apellidos) {
    super();
    this.id = id;
    this.nombre = nombre;
    Apellidos = apellidos;
  }

  
  
  
  
  @Override
  public String toString() {
    return "Actor [id=" + id + ", nombre=" + nombre + ", Apellidos=" + Apellidos + "]";
  }





  /**
   * @return the id
   */
  public int getId() {
    return id;
  }





  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }





  /**
   * @return the apellidos
   */
  public String getApellidos() {
    return Apellidos;
  }

  
  
  
}
