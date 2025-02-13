package prog.ud06.actividad611.proveedores;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import prog.ud06.actividad611.coleccion.Cliente;
import prog.ud06.actividad611.coleccion.ProveedorUsuarios;
import prog.ud06.actividad611.coleccion.ProveedorUsuariosException;
import prog.ud06.actividad611.coleccion.TarjetaClaves;
import prog.ud06.actividad611.coleccion.Usuario;
import prog.ud06.actividad611.coleccion.Usuarios;
import prog.ud06.actividad611.coleccion.diccionario.Diccionario;

/**
 * Implementación de ProveedorUsuarios que obtiene la información desde un
 * archivo XML
 */
public class ProveedorUsuariosArchivoXML implements ProveedorUsuarios {

  /**
   * Donde vamos a almacenar nuestros Usuarios
   */
  private Usuarios almacenUsuarios;

  /**
   * Constructor
   * 
   * @param archivo Ruta al archivo XML que contiene la información de los
   *                usuarios
   */
  public ProveedorUsuariosArchivoXML(String archivo) {
    iniciaDesdeFicheroXML(archivo);
 
  }

  private void iniciaDesdeFicheroXML(String archivo) {

    try {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document documento = builder.parse(archivo);

 
      // Incializamos almacenUsuarios
      almacenUsuarios = new Usuarios();

      // Hacemos un bucle el cual recorra todo el archivo rellenando almacen de
      // Usuarios en el proceso
      NodeList usuariosList = documento.getElementsByTagName("usuario");
      for (int i = 0; i < usuariosList.getLength(); i++) {

        // Empezamos recogiendo los datos "Básicos" de los Usuarios
        Element usuarioElement = (Element) usuariosList.item(i);
        String usuarioId = usuarioElement.getAttribute("id");
        String nombreCompleto = usuarioElement.getAttribute("nombre");

        // Para recoger la Lista de clientes de cada Usuario vamos ha hacer un bucle que
        // recorra los elementos clienttes del XML
        List<Cliente> clientesLista = new ArrayList<>();
        NodeList clientesList = documento.getElementsByTagName("cliente");
        for (int j = 0; j < clientesList.getLength(); j++) {

          // "Localizamos" el cliente
          Element clienteElement = (Element) clientesList.item(j);

          // Solo cojemos los clientes de cada Usuario para esto hacemos un condición
          if (clienteElement.getAttribute("usuario").equals(usuarioId)) {
            String clienteDni = clienteElement.getElementsByTagName("dni").item(0).getTextContent();
            String clienteNombre = clienteElement.getElementsByTagName("nombre").item(0).getTextContent();
            String clienteApellidos = clienteElement.getElementsByTagName("apellidos").item(0).getTextContent();
            int clienteEdad = Integer.parseInt(clienteElement.getElementsByTagName("edad").item(0).getTextContent());
            Cliente persona = new Cliente(clienteNombre, clienteApellidos, clienteDni, clienteEdad);
            clientesLista.add(persona);
          }
        }

        // Hacemos un bucle que recorra las tarjetas
        NodeList tarjetasList = documento.getElementsByTagName("tarjeta");
        TarjetaClaves tabla = new TarjetaClaves(2, 2);
        for (int k = 0; k < tarjetasList.getLength(); k++) {

          Element tarjetaElement = (Element) tarjetasList.item(k);
          if (tarjetaElement.getAttribute("usuario").equals(usuarioId)) {
            NodeList filaList = tarjetaElement.getElementsByTagName("fila");

            // Contamos el número de filas para determinar el número de filas en la tarjeta
            int numFilas = filaList.getLength();

            // Tomamos la primera fila para determinar el número de columnas
            Element primeraFila = (Element) filaList.item(0);
            NodeList celdaList = primeraFila.getElementsByTagName("celda");

            // Contamos el número de columnas para determinar el número de columnas en la
            // tarjeta
            int numColumnas = celdaList.getLength();

            // Creamos la tarjeta de claves con el número de filas y columnas determinado
            tabla = new TarjetaClaves(numFilas, numColumnas);

            // hacemos un bucle que se recorra cada fila guardando el valor de las celdas
            for (int l = 0; l < filaList.getLength(); l++) {
              Element filaElement = (Element) filaList.item(l);
              celdaList = filaElement.getElementsByTagName("celda");
              for (int m = 0; m < celdaList.getLength(); m++) {
                Element celdaElement = (Element) celdaList.item(m);
                int clave = Integer.parseInt(celdaElement.getTextContent());
                // Ajustamos los índices de fila y columna para comenzar desde 1
                tabla.setClave(l + 1, m + 1, clave);
              }
            }
          }

        }

        // Al final de cada "vuelta" del bucle creamos los Usuarios con la imformación
        // recogida y los almacenamos.
        Usuario personaUsuario = new Usuario(usuarioId, nombreCompleto, tabla, clientesLista);
        almacenUsuarios.addUsuario(personaUsuario);
      }
    } catch (Exception e) {
      // Lanza nuestra excepcion
      throw new ProveedorUsuariosException();
    }

  }

  public Usuarios obtieneUsuarios() throws ProveedorUsuariosException {
    return almacenUsuarios;
  }

}
