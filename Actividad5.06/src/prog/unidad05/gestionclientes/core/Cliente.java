package prog.unidad05.gestionclientes.core;

/**
 * Un cliente de una empresa
 */

public class Cliente {

  // NIF del cliente. Debe constar de 8 números y una letra mayúscula que debe ser
  // la que le corresponde según el algoritmo del gobierno
  private String nif;

  // Apellidos del cliente. No puede estar vacío o contener sólo blancos y la
  // primera letra de cada palabra debe ser mayúscula
  private String apellidos;

  // Nombre del cliente. Mismas restricciones que apellido
  private String nombre;

  // Número de empleados. Debe ser superior a cero
  private int empleados;

  // Facturación anual del cliente. Debe ser superior a cero
  private double facturacion;

  // true si el cliente es nacional de un pais de la UE. false si no lo es
  private boolean nacionalUe;

  /**
   * Constructor con toda la información Ningún parámetro puede ser null
   * 
   * @param nif         NIF del cliente. Debe constar de 8 números y una letra
   *                    mayúscula que debe ser la que le corresponde según el
   *                    algoritmo del gobierno
   * @param apellidos   Apellidos del cliente. No puede estar vacío o contener
   *                    sólo blancos y la primera letra de cada palabra debe ser
   *                    mayúscula
   * @param nombre      Nombre del cliente. Mismas restricciones que apellido
   * @param empleados   Número de empleados. Debe ser superior a cero
   * @param facturacion Facturación anual del cliente. Debe ser superior a cero
   * @param nacionalUe  true si el cliente es nacional de un pais de la UE. false
   *                    si no lo es
   * @throws IllegalArgumentException Si alguno de los parámetros no es válido
   */
  public Cliente(String nif, String apellidos, String nombre, int empleados, double facturacion, boolean nacionalUe) {

    if (nombreYApellidosValido(nombre) && nombreYApellidosValido(apellidos) && nifValido(nif)
        && facturacionValida(facturacion) && empleadosValido(empleados)) {
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.nif = nif;
      this.empleados = empleados;
      this.facturacion = facturacion;
      this.nacionalUe = nacionalUe;

    } else {
      throw new IllegalArgumentException();
    }

  }

  /**
   * describe al cliente
   * 
   * @return una cadena con los datos del cliente
   */
  public String aTexto() {
    return String.format("%s: %s %s", nif, apellidos, nombre);
  }

  /**
   * Devuelve el NIF del cliente
   * 
   * @return Devuelve el NIF del cliente
   */
  public String getNif() {
    return nif;
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
   * Obtiene el nombre del cliente
   * 
   * @return Nombre del cliente
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene el número de empleados del cliente
   * 
   * @return Número de empleados del cliente
   */
  public int getEmpleados() {
    return empleados;
  }

  /**
   * Obtiene la facturación del cliente
   * 
   * @return Facturacion del cliente, en euros
   */
  public double getFacturacion() {
    return facturacion;
  }

  /**
   * Obtiene si el cliente es nacional de un pais de la UE o no
   * 
   * @return true si el cliente es nacional de un pais de la UE, false si no lo es
   */
  public boolean isNacionalUe() {
    return nacionalUe;
  }


//  
//  // Comprueba que ninguno de los valores sean nulos
//  private boolean noNulos(String nif, String apellidos, String nombre) {
//    
//    return nif!=null && apellidos!=null && nombre!=null ;
//    
//  }
  // Comprueba que el nombre y apellidos no estan vacion ni son solo espacios,
  // ademas de comprobar con la clase Character si la primera letra es mayuscula
  private boolean nombreYApellidosValido(String nombre) {
    // comprueba si el nif es null
    if (nombre == null) {
      return false;
    }
    return !nombre.isEmpty() && !nombre.isBlank() && comprobarMayus(nombre);

  }

  // Comprueba que la cadena tenga las primeras Letras en mayusculas
  private boolean comprobarMayus(String nombre) {
    boolean todoCorrecto = true;
    if (Character.isUpperCase(nombre.charAt(0))) {
      for (int i = 1; i != nombre.length(); i++) {
        if (nombre.charAt(i) == ' ') {
          todoCorrecto = Character.isUpperCase(nombre.charAt(i + 1));
        }
      }
    } else {
      todoCorrecto = false;
    }
    return todoCorrecto;

  }

  // Comprueba que empleados es mayor a 0
  private boolean empleadosValido(int empleados) {
    return empleados > 0;

  }

  // Comprueba que empleados es mayor a 0
  private boolean facturacionValida(double facturacion) {
    return facturacion > 0;

  }

  // Comprueba que el nif es valido
  private boolean nifValido(String nif) {
    // comprueba si el nif es null
    if (nif == null) {
      return false;
    }

    String patronnif = ("[0-9]{8}[A-Z]");
    String nulo = null;
    String ordenUltimaLetra = ("TRWAGMYFPDXBNJZSQVHLCKE");

    // El primer metodo booleano le pasa el Patron que debe seguir un nif (8 numero
    // seguido de una Letra mayuscula)
    // El segundo metodo booleano hace que se situe en el octavo caracter del nif y
    // le resta la letra, ahora sin la letra lo pasa a entero
    // y habiendolo pasado de tipo a entero lo divide entre 23 y coje el resto y
    // comprueba que esta en la posicion correcta de la cadena letra Ultima letra
    return nif.matches(patronnif) && !(nif.equals(nulo))
        && nif.charAt(8) == ordenUltimaLetra.charAt(Integer.parseInt(nif.substring(0, 8)) % 23);
  }

}
