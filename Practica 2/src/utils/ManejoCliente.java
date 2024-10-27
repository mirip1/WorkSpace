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
   * @param cliente
   */
  public void altaCliente(Cliente cliente) {

    if (clientes.get(cliente.getEmail()) == null) {

      clientes.put(cliente.getEmail(), cliente);

    } else {
      throw new IllegalCallerException();
    }

  }

  /**
   * Metodo para dar de baja a un cliente
   * 
   * @param email
   */
  public void bajaCliente(String email) {
    if (clientes.get(email) != null) {

      clientes.remove(email);

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
  
  /**
   * método que pasa una lista de clientes
   */
  public List<Cliente> pasarALista() {

    List<Cliente> listaClientes = clientes.values().stream().collect(Collectors.toList());
    return listaClientes;

  }

}
