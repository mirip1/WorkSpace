package app;

import java.util.Scanner;

import clases.Cliente;
import clases.Motocicleta;
import sql.ProveedorAlmacenamientoTienda;

public class GestionTiendaApp {

  private static final String RUTA_DB = "db/tienda_orig.db";

  private static final int OPT_SALIR = 0;
  private static final int OPT_CREAR_MOTO = 1;
  private static final int OPT_REGISTRO_VENTA = 2;
  private static final int OPT_LISTADO_VENTAS = 3;
  private static final int OPT_ACTUALIZAR_CLIENTE = 4;
  private static final int OPT_ELIMINAR_DEPARTAMENTO = 5;

  private ProveedorAlmacenamientoTienda proveedorAlmacenamiento;
  private Scanner scanner;

  public GestionTiendaApp(ProveedorAlmacenamientoTienda servicioAlmacenamiento, Scanner scanner) {
    this.proveedorAlmacenamiento = servicioAlmacenamiento;
    this.scanner = scanner;
  }

  public static void main(String[] args) {
    GestionTiendaApp app = new GestionTiendaApp(new ProveedorAlmacenamientoTienda(RUTA_DB), new Scanner(System.in));
    app.run();
  }

  private void run() {
    int opcion;
    do {
      // Muestra el menu y solicita la opción al usuario
      opcion = muestraMenu();
      // Dependiendo de la opción
      switch (opcion) {
      case OPT_CREAR_MOTO:
        creacionMotocicleta();
        break;
      case OPT_REGISTRO_VENTA:
        registroDeVenta();
        break;
      case OPT_LISTADO_VENTAS:
        listadoVentas();
        break;
      case OPT_ACTUALIZAR_CLIENTE:
        actualizarCliente();
        break;
      case OPT_ELIMINAR_DEPARTAMENTO:
//          eliminarMotocicleta();
        break;
      case OPT_SALIR:
        break;
      default:
        System.err.println("Opción elegida incorrecta. Inténtelo de nuevo");
        break;
      }
    } while (opcion != OPT_SALIR);
  }

  private void actualizarCliente() {
    // Cabecera
    System.out.println();
    System.out.println("MODIFICAR CLIENTE");
    System.out.println("----------------------");

    // Solicita el código del departamento para recuperarlo
    System.out.print("Introduzca el NIF del cliente (debe ser igual al de un cliente ya existente):");
    String nif = scanner.nextLine();

    // Comprobamos que existe un cliente con ese nif
    if (!proveedorAlmacenamiento.compruebaNif(nif)) {
      System.err.println("No existe ningun cliente con ese NIF");
      throw new IllegalArgumentException();
    }

    // Si se encontro

    // Solicita la información del nuevo departamento (excepto el código)
    System.out.print("Introduzca el nuevo nombre del cliente :");
    String nombre = scanner.nextLine();
    System.out.print("Introduzca los nuevos apellidos del cliente :");
    String apellidos = scanner.nextLine();
    System.out.print("Introduzca la nueva dirección del cliente :");
    String direccion = scanner.nextLine();
    System.out.print("Introduzca nuevo NIF del cliente que recomendó a este del cliente :");
    String nif_recomendado = scanner.nextLine();
   
    // Almacenamos los cambios
    try {
      proveedorAlmacenamiento.updateCliente(new Cliente(nif ,nombre, apellidos,
          direccion, nif_recomendado));
    } catch (IllegalArgumentException e) {
      // Error
      System.err.println("No se pudieron almacenar los cambios.");
    }

  }

  private void listadoVentas() {
    // TODO Auto-generated method stub

    // Cabecera
    System.out.println();
    System.out.println("LISTADO DE VENTAS");
    System.out.println("---------------------");
    proveedorAlmacenamiento.listarTodo();

  }

  private void registroDeVenta() {
    // Cabecera
    System.out.println();
    System.out.println("NUEVA VENTA");
    System.out.println("------------------");

    // Solicita la información del nuevo departamento (excepto el código)
    System.out.print("Introduzca el NIF del cliente (debe ser igual al de un cliente ya existente: ");
    String nif = scanner.nextLine();

    System.out
        .print("Introduzca la referencia de la motocicleta (debe ser igual a la de una motocicleta ya existente:");
    String referencia = scanner.nextLine();

    // Y lo insertamos
    try {
      proveedorAlmacenamiento.addVenta(nif, referencia);
    } catch (IllegalArgumentException e) {
      System.err.println(
          "No se pudo realizar la venta porque no existe cliente con el NIF proporcionado o no existe motocicleta con la referencia proporcionada");
    }

  }

  private void creacionMotocicleta() {
    // Cabecera
    System.out.println();
    System.out.println("NUEVA MOTOCICLETA");
    System.out.println("------------------");

    // Solicita la información del nuevo departamento (excepto el código)
    System.out.print("Introduzca la referencia de la moto (no puede ser igual a una motocicleta ya existente): ");
    String referencia = scanner.nextLine();

    System.out.print("Introduzca la cilindrada de la motocicleta, en CC (debe ser mayor o igual a cero): ");
    int cilindrada = Integer.parseInt(scanner.nextLine());

    System.out.print("Introduzca el tipo de la motocicleta (no puede dejarse vacío o contener sólo blancos)");
    String tipo = scanner.nextLine();

    System.out
        .print("Introduzca el precio de la motocicleta (usar . para separar parte entera y decimal. No negativo) ");
    double precio = Double.parseDouble(scanner.nextLine());

    System.out.print("Introduzca el fabricante de la motocicleta (no puede dejarse vacío o contener sólo blancos):");
    String fabricante = scanner.nextLine();

    // Creamos el objeto departamento
    Motocicleta moto = new Motocicleta(referencia, cilindrada, tipo, precio, fabricante);
    // Y lo insertamos
    try {
      proveedorAlmacenamiento.addMotocicleta(moto);
    } catch (IllegalArgumentException e) {
      System.err.println("Ocurrió un error almacenando la motocicleta");
    }

  }

  private int muestraMenu() {
    // Muestra el menu
    System.out.println();
    System.out.println("GESTION DE TIENDA");
    System.out.println("------------------------");
    System.out.println("0.- Salir de la aplicación");
    System.out.println("1.- Crear motocicleta");
    System.out.println("2.- Registrar Venta");
    System.out.println("3.- Listado de Ventas");
    System.out.println("4.- Actualizar Cliente");
    System.out.println("5.- Eliminar departamento");

    // Iniciamos la opcion a un valor incorrecto
    int opcion = -1;
    do {
      // Solicitamos la opción. Capturamos la excepción para el caso de que se
      // introduzca algo que no sea un entero
      System.out.print("Elija su opción (0-5): ");
      try {
        opcion = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        // Si se introduce algo que no es entero asignamos un valor no vaĺido para
        // volver a solicitarlo
        opcion = -1;
      }
      // Si la opción no es válida
      if (opcion < 0 || opcion > 5) {
        // Error
        System.err.println("Opción incorrecta. Inténtelo de nuevo");
      }
    } while (opcion < 0 || opcion > 5);
    // Se devuelve la opción seleccionada
    return opcion;
  }

}
