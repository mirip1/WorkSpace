package prog.unidad04.practica406.libreria;

/**
 * Motocicleta
 */
public class Motocicleta extends Vehiculo implements ConvertibleATexto {

  /**
   * Cilindrada de la motocicleta
   */
  protected int cilindrada;
  
  
  /**
   * Constructor 
   * @param matricula Matrícula del vehiculo. Debe tener un formato válido NNNN AAA donde NNNN son 4 dígitos y AAA son tres letras MAYÚSCULAS. Entre ellas puede haber cuantos espacios se quiera (incluido ninguno)
   * @param fechaMatriculacion Fecha de matriculación del vehiculo. No puede ser null
   * @param cilindrada Cilindrada de la motocicleta (debe ser superior o igual a 50)
   * @throws IllegalArgumentException Si alguno de los parametros no es válido
   */
  public Motocicleta(String matricula, Fecha fechaMatriculacion, int cilindrada) {
    super(matricula, fechaMatriculacion);

    if (comprobarCilindrada(cilindrada)) {
      this.cilindrada = cilindrada;
    }else {
      throw new IllegalArgumentException();

    }
  
  }


  /**
   * Obtiene una representación en texto del automóvil El formato es Matricula: MMMM, Fecha Matriculacion: FFFF, Color: CCCC, Num. Plazas: PPPPP donde MMMM es la matricula, FFFF es la fecha de matriculacion, CCCC es el color, PPPP es el número de plazas
   * @return Cadena con la información del objeto en formato texto
   * 
   */
  public String aTexto() {
    return "Matricula: " + getMatricula() + ", Fecha Matriculacion: " + fechaMatriculacion.aTexto() + ", cilindrada: " + getCilindrada();
  }


  /**
   * Obtiene la cilindrada de la motocicleta
   * @return Cilindrada de la motocicleta
   */
  public int getCilindrada() {
    return cilindrada;
  }
  
  // Comprueba si la cilindrada es superior o igual a 50
  private boolean comprobarCilindrada(int cilindrada) {
    return cilindrada>=50;
  }
  
  
}
