package models;

import java.util.Date;

public class Reserva {
  private Usuario cliente;
  private Clase clase;
  private String turno;
  private Date fecha;

  public Reserva(Usuario cliente, Clase clase, String turno, Date fecha) {
    this.cliente = cliente;
    this.clase = clase;
    this.turno = turno;
    this.fecha = fecha;
  }

  /**
   * @return the cliente
   */
  public Usuario getCliente() {
    return cliente;
  }

  /**
   * @param cliente the cliente to set
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * @return the clase
   */
  public Clase getClase() {
    return clase;
  }

  /**
   * @param clase the clase to set
   */
  public void setClase(Clase clase) {
    this.clase = clase;
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
   * @return the fecha
   */
  public Date getFecha() {
    return fecha;
  }

  /**
   * @param fecha the fecha to set
   */
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }
}
