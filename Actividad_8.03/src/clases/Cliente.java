package clases;

/*
 * Representa un cliente
 */
public class Cliente {

  // nif identificador del cliente
  private String nif;

  // nombre del cliente
  private String nombre;

  // apellido del cliente
  private String apellidos;

  // direccion del cliente
  private String direccion;

  // identificador del otro cliente que ha recomendado
  private String nif_recomendados;

  /**
   * Constructor
   * 
   * @param nif              identificador del cliente
   * @param nombre           nombre del cliente
   * @param apellidos        apellido del cliente
   * @param direccion        direccion del cliente
   * @param nif_recomendados identificador del otro cliente que ha recomendado
   */
  public Cliente(String nif, String nombre, String apellidos, String direccion, String nif_recomendados) {

    this.nif = nif;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.direccion = direccion;
    this.nif_recomendados = nif_recomendados;
  }

  /**
   * @return the nif
   */
  public String getNif() {
    return nif;
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
   * @return the direccion
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * @return the nif_recomendados
   */
  public String getNif_recomendados() {
    return nif_recomendados;
  }

}
