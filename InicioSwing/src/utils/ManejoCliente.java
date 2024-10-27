package utils;

import java.awt.TextArea;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import modelos.Cliente;

/**
 * Clase creada para el manejo de multiples clientes
 */
public class ManejoCliente {

  private Map<String, Cliente> clientes;

  public ManejoCliente() {
    super();

    clientes = new HashMap<>();
  }

  /**
   * Da de alta a un cliente
   * 
   * @param nombre
   * @param apellidos
   * @param edad
   * @param provincia
   */
  public void altaCliente(Cliente cliente) {
    
    if (clientes.get(cliente.getNombre() + cliente.getApellidos()) == null) {
      
      clientes.put(cliente.getNombre() + cliente.getApellidos(), cliente);

    } else {
      throw new IllegalCallerException();
    }
    
  }

  /**
   * Metodo para dar de baja a un cliente
   * 
   * @param nombre
   * @param apellidos
   */
  public void bajaCliente(String nombre, String apellidos) {
    if (clientes.get(nombre + apellidos) != null) {

      clientes.remove(nombre + apellidos);

    } else {
      throw new IllegalCallerException();
    }

  }

  /**
   * método que muestra cliente
   */
  public void mostrarCliente() {

    List<Cliente> listaClientes = clientes.values().stream().collect(Collectors.toList());
    listaClientes.forEach(System.out::println);

  }

  /**
   * método que muestra cliente en un textArea
   */
  public void mostrarClienteTextArea(TextArea textArea) {

    List<Cliente> listaClientes = clientes.values().stream().collect(Collectors.toList());
    for (Cliente cliente : listaClientes) {
      textArea.append(cliente.toString() + "\n");

    }

  }

}
