package prog.unidad04.practica406.libreria;

/**
 * Clase que representa a un vehiculo
 */
public class Vehiculo {
  
  /**
   * Fecha de matriculación del vehiculo
   */
  protected Fecha fechaMatriculacion;
  
  /**
   * Matricula del vehiculo
   */
  protected String matricula;
  
  /**
   * Número de vehiculos matriculados hasta el momento
   */
  protected static int vehiculosMatriculados = 0;

  /**
   * Constructor protegido para que no pueda usarse para crear objetos desde
   * clases que no hereden de esta
   * 
   * @param fechaMatriculacion    Fecha de matriculación del vehiculo
   * @param matricula             Matricula del vehiculo
   * @param vehiculosMatriculados Número de vehiculos matriculados hasta el
   *                              momento
   * @throws IllegalArgumentException
   */
  protected Vehiculo(String matricula, Fecha fechaMatriculacion) {
    if (comprobarMatricula(matricula) && (comprobarFechaMatriculacion(fechaMatriculacion))) {
      this.matricula = matricula;
      this.fechaMatriculacion = fechaMatriculacion;
      vehiculosMatriculados += 1; // Incrementa el contador al crear un nuevo vehículo
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Obtiene la fecha de matriculación del vehículo
   * 
   * @return Fecha de matriculacion del vehículo
   */
  public Fecha getFechaMatriculacion() {
    return fechaMatriculacion;
  }

  /**
   * Obtiene la matricula del vehículo
   * 
   * @return Matrícula del vehículo
   */
  public String getMatricula() {
    return matricula;
  }

  /**
   * Obtiene la cantidad de vehículos matriculados hasta el momento
   * 
   * @return Cantidad de vehículos matriculados hasta el momento
   */
  public static int getVehiculosMatriculados() {
    return vehiculosMatriculados;
  }

  // Comprueba si la matricula se ha introducido correctamente
  private boolean comprobarMatricula(String matricula) {
    if (matricula.matches("^[0-9]{4}\\s*[A-ZÑ]{3}$")) {
      return true;
    } else {
      return false;

    }
  }


  // Comprueba si la Fecha no es null
  private boolean comprobarFechaMatriculacion(Fecha fechaMatriculacion) {
    return fechaMatriculacion != null;

  }
}
