package prog.ud06.actividad611.coleccion;

/**
 * Un cliente de una empresa
 */
public class Cliente {

  // Nombre del cliente
  private String nombre;

  // Apellidos del cliente
  private String apellidos;

  // DNI del cliente
  private String dni;

  // Edad del cliente
  private int edad;

  /**
   * 
   * @param nombre    Nombre de pila de la persona. No puede ser null o vacío o
   *                  contener sólo espacios
   * @param apellidos Apellidos de la persona. No puede ser null o vacío o
   *                  contener sólo espacios
   * @param dni       DNI de la persona. No puede ser null y debe constar de 8
   *                  números y una letra. La letra debe ser mayúscula y válida
   *                  según las normas del DNI
   * @param edad      Edad de la persona. Debe ser 0 ó superior
   * @throws IllegalArgumentException Si alguno de los paarámetros no es correcto
   */
  public Cliente(String nombre, String apellidos, String dni, int edad) {

    if (nombreYApellidosValido(nombre,apellidos) && dniValido(dni) ) {
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.dni = dni;
      this.edad = edad;
    } else {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Obtiene el nombre del cliente
   * 
   * @return Nombre de pila del cliente
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene los apellidos del cliente
   * 
   * @return Apellidos del cliente
   */
  public String getApellidos() {
    return apellidos;
  }

  /**
   * Obtiene el DNI del cliente
   * 
   * @return DNI del cliente
   */
  public String getDni() {
    return dni;
  }

  /**
   * Obtiene edad del cliente
   * 
   * @return Edad del cliente
   */
  public int getEdad() {
    return edad;
  }

  /**
   * Compara el orden alfabético de dos clientes
   * 
   * @param o Otro cliente
   * 
   */
  public int compareTo(Cliente o) {

    return o.getApellidos().compareTo(apellidos);

  }

  // Comprueba que el nombre y apellidos no son nulls ni solo espacios
  private boolean nombreYApellidosValido(String nombre, String apellidos) {
    return nombre != null && !nombre.isBlank() && apellidos != null && !apellidos.isBlank();
  }

  // Comprueba que el DNI es valido
  private boolean dniValido(String dni) {
    //comprueba si el dni es null 
    if (dni == null) {
      return false;
    }
    
    String patronDni = ("[0-9]{8}[A-Z]");
    String nulo = null;
    String ordenUltimaLetra = ("TRWAGMYFPDXBNJZSQVHLCKE");

    // El primer metodo booleano le pasa el Patron que debe seguir un DNI (8 numero
    // seguido de una Letra mayuscula)
    // El segundo metodo booleano hace que se situe en el octavo caracter del DNI y
    // le resta la letra, ahora sin la letra lo pasa a entero
    // y habiendolo pasado de tipo a entero lo divide por 23 y coje el resto y
    // comprueba que esta en la posicion correcta de la cadena letra Ultima letra
    return dni.matches(patronDni) && !(dni.equals(nulo))
        && dni.charAt(8) == ordenUltimaLetra.charAt(Integer.parseInt(dni.substring(0, 8)) % 23);
  }

}
