package prog.unidad04.practica406.libreria;

/**
 * Clase que representa un automovil. Es un vehiculo de cuatro ruedas con un
 * color y un número de plazas
 */
public class Automovil extends Vehiculo implements ConvertibleATexto {

  /**
   * Color del coche
   */
  protected String color;

  /**
   * Color Azul
   */
  public static final String COLOR_AZUL = "azul";

  /**
   * Color Blanco
   */
  public static final String COLOR_BLANCO = "blanco";
  /**
   * Color negro
   */
  public static final String COLOR_NEGRO = "negro";

  /**
   * Plazas del coche
   */
  protected int plazas;

  /**
   * Constructor
   * 
   * @param matricula          Matrícula del vehiculo. Debe tener un formato
   *                           válido NNNN AAA donde NNNN son 4 dígitos y AAA son
   *                           tres letras MAYÚSCULAS. Entre ellas puede haber
   *                           cuantos espacios se quiera (incluido ninguno)
   * @param fechaMatriculacion Fecha de matriculación del vehiculo. No puede ser
   *                           null
   * @param color              Color del vehículo. Sólo se permite uno de
   *                           COLOR_BLANCO, COLOR_NEGRO, COLOR_AZUL
   * @param plazas             Número de plazas del vehiculo. Debe ser mayor que 0
   *                           (por lo menos tiene que tener una para el conductor
   * @throws IllegalArgumentException Si alguno de los parametros no es válido
   */
  public Automovil(String matricula, Fecha fechaMatriculacion, String color, int plazas) {
    super(matricula, fechaMatriculacion);

    if (comprobarPlazas(plazas) && comprobarColor(color)) {
      this.color = color;
      this.plazas = plazas;

    } else {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Obtiene una representación en texto del automóvil El formato es Matricula:
   * MMMM, Fecha Matriculacion: FFFF, Color: CCCC, Num. Plazas: PPPPP donde MMMM
   * es la matricula, FFFF es la fecha de matriculacion, CCCC es el color, PPPP es
   * el número de plazas
   * 
   * @return Cadena con la información del objeto en formato texto
   * 
   */
  public String aTexto() {
    return "Matricula: " + getMatricula() + ", Fecha Matriculacion: " + fechaMatriculacion.aTexto() + ", color: "
        + getColor() + ", Num. Plazas: " + getPlazas();

  }

  /**
   * Obtiene el color del automovil
   * 
   * @return Color del automovil
   * 
   */
  public String getColor() {
    return color;
  }

  /**
   * Obtiene el número de plazas del automóvil
   * 
   * @return Número de plazas del automóvilolor del automovil
   * 
   */
  public int getPlazas() {
    return plazas;
  }

  // Comprueba si se el numero de plazas es 1 o mas
  private boolean comprobarPlazas(int plazas) {
    return plazas >= 1;

  }

  // comprueba si el color introducido es válido
  private boolean comprobarColor(String color) {
    if (color.equals(COLOR_AZUL) || color.equals(COLOR_BLANCO) || color.equals(COLOR_NEGRO)) {
      return true;

    } else {
      return false;
    }
  }

}
