package utils;

import java.awt.TextArea;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import modelos.Cliente;
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
    if (productos.get(producto.getNombre()) == null) {
      productos.put(producto.getNombre(), producto);
    }else {
      throw new IllegalCallerException();
    }

  }

  /**
   * Metodo para dar de baja a un product
   * 
   * @param nombre
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
  

  /**
   * método que pasa una lista de productos
   */
  public List<Producto> pasarALista() {

    List<Producto> listaproductos = productos.values().stream().collect(Collectors.toList());
    return listaproductos;

  }

}
