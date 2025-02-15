package modelos;

import java.util.Date;

import excepciones.EmailNoValidoException;

/**
 * Calse que simula un cliente
 */
public class Cliente {
  

  private String email;
  private String nombre;
  private String apellidos;
  private int edad;
  private String provincia;
  private Date fechaAlta;
  
  
  /**
   * Constructor
   * @param email Email del cliente
   * @param nombre Nombre del cliente
   * @param apellidos Apellidos del Cliente
   * @param edad Edad del Cliente
   * @param provincia Provincia de la cual es el cliente
   */
  public Cliente(String email,  String nombre, String apellidos, int edad, String provincia, Date fechaAlta) {
    super();
    if (comprobarEmail(email)) {
      this.email = email;
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.edad = edad;
      this.provincia = provincia;
      this.fechaAlta = fechaAlta;
      
    }else {
      throw new EmailNoValidoException();
      
    }
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
    return apellidos;
  }


  /**
   * @return the edad
   */
  public int getEdad() {
    return edad;
  }


  /**
   * @return the provincia
   */
  public String getProvincia() {
    return provincia;
  }


  @Override
  public String toString() {
    return nombre + " " + apellidos + " tiene " + edad + " años y es de " + provincia;
  }


  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
  
  private boolean comprobarEmail(String email) {
    String SIMPLE_EMAIL_PATTERN = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
    return email.matches(SIMPLE_EMAIL_PATTERN);
    
    
  }


  /**
   * @return the fechaAlta
   */
  public Date getFechaAlta() {
    return fechaAlta;
  }
  
  
  

  
  
}
