package modelos;

/**
 * Clase que simula un producto
 */
public class Producto {
  private String Nombre;
  private Double precioUnidad;
  private boolean perecedero;

  /**
   * Constructor
   * 
   * @param nombre       Nombre del producto
   * @param precioUnidad precio por unidad de producto
   * @param perecedero   si caduca o no
   */
  public Producto(String nombre, Double precioUnidad, boolean perecedero) {
    super();
    if (!nombre.isBlank()) {
      Nombre = nombre;
      this.precioUnidad = precioUnidad;
      this.perecedero = perecedero;

    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return Nombre;
  }

  /**
   * @return the precioUnidad
   */
  public Double getPrecioUnidad() {
    return precioUnidad;
  }

  /**
   * @return the perecedero
   */
  public boolean isPerecedero() {
    return perecedero;
  }


  @Override
  public String toString() {
    if (!perecedero) {
      return Nombre + " cuesta: " + precioUnidad + "€, no caduca";

    }
    return Nombre + " cuesta: " + precioUnidad + "€, si caduca";

  }

}
