package prog.unidad05.gestionclientes.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Almacen de Cliente(s)
 */
public class Clientes {

  private Map<String, Cliente> mapaClientes;
  private ArrayList<Cliente> listaClientes;

  // Proveedor de almacenamiento a emplear para leer y escribir los clientes desde
  // o hacia almacenamiento secundario
  private ProveedorAlmacenamientoClientes proveedorAlmacenamiento;

  /**
   * Constructor
   * 
   * @param proveedorAlmacenamiento Proveedor de almacenamiento a emplear para
   *                                leer y escribir los clientes desde o hacia
   *                                almacenamiento secundario
   * @throws NullPointerException Si proveedorAlmacenamiento es null
   * @throws ClientesException    Si hay algún error al acceder al almacenamiento
   */
  public Clientes(ProveedorAlmacenamientoClientes proveedorAlmacenamiento) {
    mapaClientes = new HashMap<>();
    listaClientes = new ArrayList<>();
    try {
      proveedorAlmacenamiento.getAll();
      this.proveedorAlmacenamiento = proveedorAlmacenamiento;
    } catch (ProveedorAlmacenamientoClientesException e) {
      throw new ClientesException();
    }
  }

  /**
   * Añade un nuevo cliente. El cliente se almacena en almacenamiento secundario
   * inmediatamente
   * 
   * @param cliente Nuevo cliente a añadir. No puede ser null ni su NIF coincidir
   *                con el NIF de un cliente ya almacenado
   * @throws NullPointerException Si cliente es null
   * @throws ClientesException    Si ya hay un cliente con el mismo NIF o hay
   *                              problemas con el almacenamiento
   */
  public void addCliente(Cliente cliente) {
    // almacenamos los clientes en un mapa e inmediatamente en
    // proveedorAlmacenamiento
    // pasamos de mapa a Array
    if (!existeNif(cliente.getNif())) {
      mapaClientes.put(cliente.getNif(), cliente);
      Cliente[] clientes = mapaClientes.values().toArray(new Cliente[0]);
      proveedorAlmacenamiento.saveAll(clientes);

    } else {
      throw new ClientesException();
    }
  }

  /**
   * Actualiza un cliente ya existente. El cliente se actualiza inmediatamente en
   * el almacenamiento secundario
   * 
   * @param cliente Cliente a almacenar. No puede ser null y su NIF debe coincidir
   *                con el de algún cliente ya almacenado.
   * @throws ClientesException Si no existe en el almacén ningún cliente con el
   *                           mismo NIF que el cliente proporcionado o no se
   *                           puede almacenar en almacenamiento secundario
   */
  public void updateCliente(Cliente cliente) {
    // utilizamos el .replace de la clase HashMap para actualizar el cliente con ese
    // nif
    // pasamos de mapa a Array
    if (existeNif(cliente.getNif())) {
      mapaClientes.replace(cliente.getNif(), cliente);
      Cliente[] clientes = mapaClientes.values().toArray(new Cliente[0]);
      proveedorAlmacenamiento.saveAll(clientes);

    } else {
      throw new ClientesException();
    }

  }

  /**
   * Elimina un cliente del almacén. El cliente se eliminará inmediatamente del
   * almacenamiento secundario
   * 
   * @param nif NIF del cliente a eliminar
   * @throws ClientesException    Si no hay ningún cliente con el NIF
   *                              proporcionado o ocurre un error con el
   *                              almacenamiento secundario
   * @throws NullPointerException Si el nif es null
   */
  public void removeCliente(String nif) {
    // utilizamos el .remove de la clase HashMap para borrar el cliente con ese nif
    // pasamos de mapa a Array
    if (nif == null) {
      throw new NullPointerException();
    }
    if (existeNif(nif)) {
      mapaClientes.remove(nif);
      Cliente[] clientes = mapaClientes.values().toArray(new Cliente[0]);
      proveedorAlmacenamiento.saveAll(clientes);
    } else {
      throw new ClientesException();
    }

  }

  /**
   * Obtiene un cliente por su nif
   * 
   * @param nif NIF del cliente
   * @return Cliente con el NIF especificado, si se encuentra. null si no se
   *         encuentra
   */
  public Cliente getByNif(String nif) {
    return mapaClientes.get(nif);
  }

  /**
   * Proporciona un visitador para recorrer los clientes almacenados
   * 
   * @param visitador Visitador al que se llamará con cada uno de los clientes
   *                  almacenados. No puede ser null
   * @throws NullPointerException Si el visitador es nulo
   */
  public void visita(VisitadorClientes visitador) {
    // por cada cliente que contenga, el bucle da una "vuelta"
    for (Cliente cliente : mapaClientes.values()) {
      visitador.visita(cliente);
    }

  }

  public Cliente[] deClientesAArray() {
    Cliente[] clientes = mapaClientes.values().toArray(new Cliente[0]);
    return clientes;

  }

  /**
   * Comprueba si el NIF ya esta creado
   * 
   * @param NIF
   * @return true si existe ya
   */
  private boolean existeNif(String nif) {
    // Como es un mapa utilizando el NIF como Key buscamos si existe ya el NIF.
    if (mapaClientes.get(nif) == null) {
      return false;
    } else {
      return true;
    }
  }

}
