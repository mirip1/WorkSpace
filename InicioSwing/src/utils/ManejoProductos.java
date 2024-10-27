package utils;

import java.awt.TextArea;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import modelos.Producto;

/**
 * Clase creada para el manejo de multiples productos
 */
public class ManejoProductos {

  private Map<String, Producto> productos;

  public ManejoProductos() {
    super();

    productos = new HashMap<>();
  }

  /**
   * Da de alta a un producto
   * 
   * @param nombre
   * @param apellidos
   * @param edad
   * @param provincia
   */
  public void altaproducto(Producto producto) {

    productos.put(producto.getNombre(), producto);

  }

  /**
   * Metodo para dar de baja a un producto
   * 
   * @param nombre
   * @param apellidos
   */
  public void bajaproducto(String nombre) {
    if (productos.get(nombre) != null) {

      productos.remove(nombre);

    } else {
      throw new IllegalAccessError();
    }

  }

  /**
   * método que muestra producto
   */
  public void mostrarproducto() {

    List<Producto> listaproductos = productos.values().stream().collect(Collectors.toList());
    listaproductos.forEach(System.out::println);

  }

  /**
   * Método que muestra la lista de productos en un textArea
   * 
   * @param textArea
   */
  public void mostrarProductosTextArea(TextArea textArea) {

    List<Producto> listaProducto = productos.values().stream().collect(Collectors.toList());
    for (Producto p : listaProducto) {
      textArea.append(p.toString() + "\n");

    }
  }

}
