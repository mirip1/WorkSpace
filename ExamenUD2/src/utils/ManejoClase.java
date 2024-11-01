package utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Clase;
import models.Reserva;
import models.Usuario;

public class ManejoClase {
  List<Clase> clases = new ArrayList<>();
  private List<Reserva> reservas = new ArrayList<>();

  public ManejoClase() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * añadir clases
   * 
   * @param clase
   */
  public void addClase(Clase clase) {
    clases.add(clase);
  }

  public void mostrarClases() {
    clases.forEach(System.out::println);
  }

  public List<Clase> getClases() {
    return clases;
  }

  public boolean reservarClase(String nombreClase, String turno, Usuario usuario, Date fecha) {
    for (Clase clase : clases) {
      if (clase.getNombreClase().equalsIgnoreCase(nombreClase) && clase.getTurno().equalsIgnoreCase(turno)) {
        if (!clase.isReservada()) {
          reservas.add(new Reserva(usuario, clase, turno, fecha));
          clase.setReservada(true);
          return true;
        } else {
          return false;
        }
      }
    }
    return false;
  }

  public List<Reserva> getReservas() {
    return reservas;
  }

}
