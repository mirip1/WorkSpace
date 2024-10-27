package prog.unidad05.gestionclientes.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import prog.unidad05.gestionclientes.core.Cliente;
import prog.unidad05.gestionclientes.core.Clientes;
import prog.unidad05.gestionclientes.core.ProveedorAlmacenamientoClientesException;
import prog.unidad05.gestionclientes.impl.ProveedorAlmacenamientoClientesFichero;

public class GestionClientesConsolaApp {
  private Scanner sc;
  private ProveedorAlmacenamientoClientesFichero archivo;

  public static void main(String[] args) {
    try {
      GestionClientesConsolaApp app = new GestionClientesConsolaApp();

      app.run();
    } catch (ProveedorAlmacenamientoClientesException e) {
      System.out.println("Error. No se puede acceder al archivo. Terminando");

    }
  }

  /**
   * Método principal del interfaz
   */
  private void run() {

    sc = new Scanner(System.in);
    archivo = new ProveedorAlmacenamientoClientesFichero("clientes.dat");

    // Muestra el menú repetidamente hasta que se elija la opción Salir
    int opcionElegida = 0;
    do {
      // Muestra el menú y obtiene una elección
      opcionElegida = mostrarMenu();
      // Según la opción elegida
      switch (opcionElegida) {
      case 1:
        comandoListarClientes();
        break;
      case 2:
        comandoNuevoCliente();
        break;
      case 3:
        comandoActualizarCliente();
        break;
      case 4:
        comandoEliminarCliente();
        break;
      case 0:
        System.out.println("Saliendo del programa");
        break;
      default:
        // No se debe llegar aqui
        System.out.println("Error. Opción incorrecta.");
      }
    } while (opcionElegida != 0);

  }

  private void comandoEliminarCliente() {
    System.out.println("\nELIMINAR CLIENTE");
    System.out.println("---------------");
    System.out.print("Introduzca el NIF del cliente a eliminar: ");
    String nif = sc.nextLine();
    // Pillamos los clientes existentes
    Cliente[] clientesExistentes = archivo.getAll();
    Clientes lista = new Clientes(archivo);
    // rellenamos la lista con los clientes existentes
    for (int i = 0; i != clientesExistentes.length; i++) {
      lista.addCliente(clientesExistentes[i]);
    }
    if (lista.getByNif(nif) != null) {
      lista.removeCliente(nif);
      System.out.println("\nOperación realizada con éxito");

    } else {
      System.out.println("\nNo existe cliente con el NIF " + nif + ". Abortando");
    }

  }

  private void comandoActualizarCliente() {
    try {
      System.out.println("\nACTUALIZAR CLIENTE");
      System.out.println("---------------");
      System.out.print("Introduzca el NIF del cliente a modificar: ");
      String nif = sc.nextLine();
      // Pillamos los clientes existentes
      Cliente[] clientesExistentes = archivo.getAll();
      Clientes lista = new Clientes(archivo);
      // rellenamos la lista con los clientes existentes
      for (int i = 0; i != clientesExistentes.length; i++) {
        lista.addCliente(clientesExistentes[i]);
      }
      if (lista.getByNif(nif) != null) {
        // Añadimos nombre
        System.out.print(
            "Nombre (La letra inicial de cada palabra en mayúsculas. En blanco para mantener el nombre \"Paqui\"): ");
        String nombre = sc.nextLine();

        // Añadimos apellidos
        System.out.print("Apellidos (Igual que Nombre. En blanco para mantener el valor \"Makaki\"):");
        String apellidos = sc.nextLine();

        // Añadimos Empleados
        System.out.print("Número de empleados (entero mayor que cero. En blanco para mantener el valor 12):");
        int numEmpleados = Integer.parseInt(sc.nextLine());

        // Añadimos facturacion
        System.out.print("Facturación (valor real superior a cero. En blanco para mantener el valor 5678,900000):");
        double facturacion = Double.parseDouble(sc.nextLine());

        // Añadimos esNacionalUe
        System.out.print("¿Es nacional de la UE? (true/false): ");
        boolean esNacionalUE = Boolean.parseBoolean(sc.nextLine());

        Cliente clienteActualizado = new Cliente(nif, apellidos, nombre, numEmpleados, facturacion, esNacionalUE);
        lista.updateCliente(clienteActualizado);
        System.out.println("\nOperación realizada con éxito");

      } else {
        System.out.println("\nNo existe cliente con el NIF " + nif + ". Abortando");
      }
    } catch (Exception e) {
      System.out.println("Error al introducir los datos");
    }

  }

  private void comandoNuevoCliente() {

    try {
      System.out.println("\nNUEVO CLIENTE ");
      System.out.println("--------------- ");
      // Añadimos el nif
      System.out.print("Ingrese el NIF del cliente: ");
      String nif = sc.nextLine();

      // Añadimos nombre
      System.out.print(
          "Nombre (La letra inicial de cada palabra en mayúsculas. En blanco para mantener el nombre \"Paqui\"): ");
      String nombre = sc.nextLine();

      // Añadimos apellidos
      System.out.print("Apellidos (Igual que Nombre. En blanco para mantener el valor \"Makaki\"):");
      String apellidos = sc.nextLine();

      // Añadimos Empleados
      System.out.print("Número de empleados (entero mayor que cero. En blanco para mantener el valor 12):");

      // Si lo dejamos en blanco el valor es 12
      String numEmpleadosCadena = sc.nextLine();
      int numEmpleados;
      if (numEmpleadosCadena.equals("")) {
        numEmpleados = 12;
      } else {
        numEmpleados = Integer.parseInt(numEmpleadosCadena);
      }

      // Añadimos facturacion
      System.out.print("Facturación (valor real superior a cero. En blanco para mantener el valor 5678,900000):");
      double facturacion = Double.parseDouble(sc.nextLine());

      // Añadimos esNacionalUe
      System.out.print("¿Es nacional de la UE? (true/false): ");
      boolean esNacionalUE = Boolean.parseBoolean(sc.nextLine());

      Cliente nuevoCliente = new Cliente(nif, apellidos, nombre, numEmpleados, facturacion, esNacionalUE);
      Cliente[] clientesExistentes = archivo.getAll();
      List<Cliente> listaClientes = new ArrayList<>(Arrays.asList(clientesExistentes));
      listaClientes.add(nuevoCliente);
      archivo.saveAll(listaClientes.toArray(new Cliente[0]));
      System.out.println("\nOperación realizada con éxito");

    } catch (Exception e) {
      System.out.println("Introduzca datos correctos");
    }

  }

  private void comandoListarClientes() {
    System.out.println("\nLISTAR CLIENTES ");
    System.out.println("--------------- ");
    List lista = new ArrayList();

    // Guardamos los datos en una lista
    Cliente[] array = archivo.getAll();
    for (int i = 0; i != array.length; i++) {
      lista.add(i, array[i].aTexto());
    }
    // Y la mostramos
    for (int i = 0; i != lista.size(); i++) {
      System.out.println(lista.get(i));
    }

  }

  private int mostrarMenu() {
    // Inicializamos la opción elegida a un valor invalido
    int opcion = -1;
    // Mientras no se elija una opción correcta
    for (;;) {
      // Mostramos el menu
      System.out.println();
      System.out.println("MENU PRINCIPAL");
      System.out.println("--------------");
      System.out.println("0. Salir del programa");
      System.out.println("1. Listar clientes");
      System.out.println("2. Nuevo cliente");
      System.out.println("3. Actualizar Cliente");
      System.out.println("4. Elimininar Cliente");
      System.out.print("Introduzca la opción seleccionada (0-4):");
      try {
        opcion = Integer.parseInt(sc.nextLine());
        // Si la opción está en rango se devuelve. Si no se muestra error y se da otra
        // vuelta
        if (opcion >= 0 && opcion <= 4) {
          return opcion;
        } else {
          System.out.println("Opción elegida incorrecta. Debe introducir un número entre 0 y 4");
        }
      } catch (NumberFormatException e) {
        System.out.println("Opción elegida incorrecta. Debe introducir un número entre 0 y 4");

      }
    }
  }

}
