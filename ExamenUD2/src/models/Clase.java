package models;

public class Clase {

  private String nombreClase;
  private String profesor;
  private String turno;

  /**
   * Constructor
   * 
   * @param nombreClase
   * @param profesor
   * @param turno
   */
  public Clase(String nombreClase, String profesor, String turno) {
    if (!nombreClase.isEmpty() && !profesor.isEmpty() && !turno.isEmpty()) {
      this.nombreClase = nombreClase;
      this.profesor = profesor;
      this.turno = turno;
    } else {

      throw new IllegalArgumentException();
    }
  }

  /**
   * @return the nombreClase
   */
  public String getNombreClase() {
    return nombreClase;
  }

  /**
   * @param nombreClase the nombreClase to set
   */
  public void setNombreClase(String nombreClase) {
    this.nombreClase = nombreClase;
  }

  /**
   * @return the profesor
   */
  public String getProfesor() {
    return profesor;
  }

  /**
   * @param profesor the profesor to set
   */
  public void setProfesor(String profesor) {
    this.profesor = profesor;
  }

  /**
   * @return the turno
   */
  public String getTurno() {
    return turno;
  }

  /**
   * @param turno the turno to set
   */
  public void setTurno(String turno) {
    this.turno = turno;
  }

}
