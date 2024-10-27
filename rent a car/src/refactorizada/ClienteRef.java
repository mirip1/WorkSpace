package refactorizada;

import java.util.ArrayList;
import java.util.List;

import refactorizada.AlquilerRef;

public class ClienteRef {

  private String nombre;
  private List<AlquilerRef> alquileres;

  public ClienteRef(String nombre) {
      this.nombre = nombre;
      this.alquileres = new ArrayList<>();
  }

  public void addAlquiler(AlquilerRef alquiler) {
      alquileres.add(alquiler);
  }

  public String cuenta() {
      StringBuilder resultado = new StringBuilder();
      double precioTotal = calcularPrecioTotal(resultado);
      int puntosFidelidad = calcularPuntosFidelidad();

      resultado.append("Importe total ").append(precioTotal).append("\n");
      resultado.append("Has ganado ").append(puntosFidelidad).append(" puntos de fidelidad");

      return resultado.toString();
  }

  private double calcularPrecioTotal(StringBuilder resultado) {
      resultado.append("Registro de alquiler para ").append(nombre).append("\n");
      double precioTotal = 0;

      for (AlquilerRef alquiler : alquileres) {
          double precioAlquiler = alquiler.calcularPrecio();
          resultado.append("\t").append(alquiler.getVehiculo().getMatricula()).append("\t").append(precioAlquiler).append("\n");
          precioTotal += precioAlquiler;
      }

      return precioTotal;
  }

  private int calcularPuntosFidelidad() {
      int puntosFidelidad = 0;

      for (AlquilerRef alquiler : alquileres) {
          puntosFidelidad += alquiler.calcularPuntosFidelidad();
      }

      return puntosFidelidad;
  }
  
}
 
