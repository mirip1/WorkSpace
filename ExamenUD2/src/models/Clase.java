package models;

public class Clase {

  private String nombreClase;
  private String profesor;
  private String turno;
  private boolean reservada;


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
      this.reservada = false;
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
  
  public boolean isReservada() {
    return reservada;
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

  /**
   * @param reservada the reservada to set
   */
  public void setReservada(boolean reservada) {
    this.reservada = reservada;
  }

}
