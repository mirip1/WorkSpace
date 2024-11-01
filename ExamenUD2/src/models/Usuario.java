package models;

import java.util.Date;

/**
 * Clase usuario
 */
public abstract class Usuario {
  
  private String nombre;
  private String apellidos;
  private Date fechaNacimiento;
  private String email;
  private String cont ;
  protected boolean cliente;
  
  
  /**
   * Constructor
   * @param nombre del Usuario
   * @param apellidos del usuario
   * @param fechaNacimiento del usuario
   * @param email del usuario
   * @param cont del usuario
   */
  public Usuario(String nombre, String apellidos, Date fechaNacimiento, String email, String cont) {
    super();
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.fechaNacimiento = fechaNacimiento;
    this.email = email;
    this.cont = cont;
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
   * @return the fechaNacimiento
   */
  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }
  /**
   * @param fechaNacimiento the fechaNacimiento to set
   */
  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * @return the cont
   */
  public String getCont() {
    return cont;
  }
  /**
   * @param cont the cont to set
   */
  public void setCont(String cont) {
    this.cont = cont;
  }
  
  
  public boolean isCliente() {
    return cliente;
  }
  
  
  

}
