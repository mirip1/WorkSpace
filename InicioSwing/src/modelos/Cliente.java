package modelos;

/**
 * Calse que simula un cliente
 */
public class Cliente {
  

  private String nombre;
  private String apellidos;
  private int edad;
  private String provincia;
  
  
  /**
   * Constructor
   * @param nombre Nombre del cliente
   * @param apellidos Apellidos del Cliente
   * @param edad Edad del Cliente
   * @param provincia Provincia de la cual es el cliente
   */
  public Cliente( String nombre, String apellidos, int edad, String provincia) {
    super();
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.edad = edad;
    this.provincia = provincia;
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
  
  
  

  
  
}
