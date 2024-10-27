package prog.unidad05.gestionclientes.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import prog.unidad05.gestionclientes.core.Cliente;
import prog.unidad05.gestionclientes.core.ProveedorAlmacenamientoClientes;
import prog.unidad05.gestionclientes.core.ProveedorAlmacenamientoClientesException;

/**
 * Proveedor de almacenamiento de clientes que almacena los datos de los
 * clientes en un fichero en disco. Si el fichero no existe se crea la primera
 * vez que se guarde y devuelve una colección vacía de clientes al leer.
 */
public class ProveedorAlmacenamientoClientesFichero implements ProveedorAlmacenamientoClientes {

  // Ruta del fichero a emplear
  private String rutaFichero;

  /**
   * Constructor con ruta
   * 
   * @param rutaFichero Ruta al fichero a emplear para leer y almacenar los
   *                    clientes
   * @throws NullPointerException Si la ruta es nula
   */
  public ProveedorAlmacenamientoClientesFichero(String rutaFichero) {
    this.rutaFichero = rutaFichero;

  }

  /**
   * Obtiene todos los clientes almacenados
   * 
   * @return Array de Cliente con todos los clientes. Puede estar vacío si aún no
   *         hay clientes
   */
  public Cliente[] getAll() throws ProveedorAlmacenamientoClientesException {
    try (BufferedReader flujoTexto2 = new BufferedReader(new FileReader(rutaFichero))) {

      List<Cliente> clientes = new ArrayList<>();
      String linea;
      while ((linea = flujoTexto2.readLine()) != null) {

        // dividimos la cadena por los ";"
        String[] partes = linea.split(";");

        // creamos un cliente y lo añadimos a la lista
        Cliente cliente = new Cliente(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]),
            Double.parseDouble(partes[4].replace(',', '.')), Boolean.parseBoolean(partes[5]));
        clientes.add(cliente);

      }

      // utilizo la misma conversion de la clase Clientes solo que en vez de mapa a
      // Array, de Lista a Array
      return clientes.toArray(new Cliente[0]);

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      throw new ProveedorAlmacenamientoClientesException();

    } catch (IOException e) {
      e.printStackTrace();
      throw new ProveedorAlmacenamientoClientesException();

    }

  }

  /**
   * Almacena todos los clientes en almacenamiento secundario Los clientes
   * previamente existentes se sustituyen por los que se proporcionan aqui
   * 
   * @param clientes Clientes a almacenar. Puede ser vacío pero no null
   */
  public void saveAll(Cliente[] clientes) throws ProveedorAlmacenamientoClientesException {
    try (PrintWriter flujoSalida = new PrintWriter(new FileWriter(rutaFichero))) {

      for (int i = 0; i < clientes.length; i++) {

        flujoSalida.printf("%s;%s;%s;%d;%.2f;%s%n", clientes[i].getNif(), clientes[i].getApellidos(),
            clientes[i].getNombre(), clientes[i].getEmpleados(), clientes[i].getFacturacion(),
            clientes[i].isNacionalUe());

      }

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      throw new ProveedorAlmacenamientoClientesException();
    }

  }

}
