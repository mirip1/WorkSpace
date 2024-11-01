package utils;

import java.util.ArrayList;
import java.util.List;

import models.Clase;

public class ManejoClase {
  List<Clase> clases = new ArrayList<>();

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

}
