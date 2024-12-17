package models;

import java.io.Serializable;

import conexion.Utils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Superusuario implements Serializable{
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idUser;
  
  @Column
  private String nombre;
  
  @Column
  private String apellidos;
  
  @Column
  private String user;

  /**
   * Constructor
   * @param idUser id del usuario
   * @param nombre nombre del usuario
   * @param apellidos Apellidos del usuario

   * 
   */
  public Superusuario( String nombre, String apellidos) {
    super();
    
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.user = Utils.crearUser(nombre, apellidos);
    
  }

  public Superusuario() {
    super();
  }

  /**
   * @return the idUser
   */
  public int getIdUser() {
    return idUser;
  }

  /**
   * @param idUser the idUser to set
   */
  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the apellidos
   */
  public String getApellidos() {
    return apellidos;
  }

  /**
   * @param apellidos the apellidos to set
   */
  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  /**
   * @return the user
   */
  public String getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(String user) {
    this.user = Utils.crearUser(nombre, apellidos);
  }

  @Override
  public String toString() {
    return "Superusuario [idUser=" + idUser + ", nombre=" + nombre + ", apellidos=" + apellidos + ", user=" + user
        + "]";
  }
  
  
  
  
  
  

}
