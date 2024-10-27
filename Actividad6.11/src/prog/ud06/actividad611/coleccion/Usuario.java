package prog.ud06.actividad611.coleccion;

import java.util.List;

/**
 * Clase que representa a un Usuario Un Usuario tiene un identificador único, un
 * nombre completo, una tarjeta de claves y una lista de clientes
 */
public class Usuario {

  /**
   * Nombre de usuario único del usuario. No puede ser null y debe tener entre 2 y
   * 8 caracteres alfanuméricos, siendo el primero una letra.
   */
  private String nombreUsuario;

  /**
   * Nombre y apellidos. No puede ser null ni vacío.
   */
  private String nombreCompleto;

  /**
   * Tarjeta de claves del usuario. No puede ser null
   */
  private TarjetaClaves tarjeta;

  /**
   * Si alguno de los parámetros no es correcto
   */
  private List<Cliente> clientes;

  /**
   * Crea un usuario
   * 
   * @param nombreUsuario  Nombre de usuario único del usuario. No puede ser null
   *                       y debe tener entre 2 y 8 caracteres alfanuméricos,
   *                       siendo el primero una letra.
   * @param nombreCompleto Nombre y apellidos. No puede ser null ni vacío.
   * @param tarjeta        Tarjeta de claves del usuario. No puede ser null
   * @param clientes       Lista de clientes del usuario. No puede ser null aunque
   *                       puede estar vacía.
   * @throws IllegalArgumentException Si alguno de los parámetros no es correcto
   */
  public Usuario(String nombreUsuario, String nombreCompleto, TarjetaClaves tarjeta, List<Cliente> clientes) {
    if (validarClientes(clientes) && validarNombre(nombreCompleto) && validarTarjeta(tarjeta)
        && validarUsuario(nombreUsuario)) {
      this.nombreUsuario = nombreUsuario;
      this.nombreCompleto = nombreCompleto;
      this.tarjeta = tarjeta;
      this.clientes = clientes;

    } else {
      throw new IllegalArgumentException();
    }

  }

  /**
   * @return Nombre de Usuario del usuario
   */
  public String getNombreUsuario() {
    return nombreUsuario;
  }

  /**
   * @return Nombre y apellidos del usuario
   */
  public String getNombreCompleto() {
    return nombreCompleto;
  }

  /**
   * @return Tarjeta de coordenadas del usuario
   */
  public TarjetaClaves getTarjeta() {
    return tarjeta;
  }

  /**
   * @return Lista de clientes del usuario
   */
  public List<Cliente> getClientes() {
    return clientes;
  }

  // Comprueba que el Usuario no sea null sea entre 2 y 8 carácteres
  private boolean validarUsuario(String nombreUsuario) {
    return nombreUsuario != null && nombreUsuario.length() >= 2 && nombreUsuario.length() <= 8
        && nombreUsuario.matches("^[a-zA-Z][a-zA-Z0-9]*$");
  }

  // Comprueba que el nombre no sea null ni este en blanco
  private boolean validarNombre(String nombreCompleto) {
    return nombreCompleto != null && !nombreCompleto.isBlank();
  }

  // Comprueba que la tarjeta no sea null
  private boolean validarTarjeta(TarjetaClaves tarjeta) {
    return tarjeta != null;
  }

  // Comprueba que los clientes no sean null
  private boolean validarClientes(List<Cliente> clientes) {
    return clientes != null;
  }

}
