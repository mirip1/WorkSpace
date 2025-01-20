package psp.ud03.practica01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Clase que se ocupa del Lado del cliente
 */
public class MainDNSClientApp {

  // Constantes

  // Puerto por defecto en el que escucha este cliente
  private static final int MY_DEFAULT_PORT = 1235;
  // Dirección por defectodel servidor
  private static final String DEFAULT_SERVER_HOST = "localhost";
  // Puerto por defecto del servidor
  private static final int DEFAULT_SERVER_PORT = 2222;
  // Longitud del buffer de envío / recepción
  private static final int BUFFER_LENGTH = 1024;

  // Puerto en el que escucha este cliente
  private int port;
  // Host del servidor
  private String serverHost;
  // Puerto del Servidor
  private int serverPort;

  // Scanner para leer desde teclado
  private Scanner sc;

  public MainDNSClientApp(String[] args) {
    // Procesa los parámetros
    processParameters(args);
    sc = new Scanner(System.in);
  }

  public static void main(String[] args) {
    MainDNSClientApp app = new MainDNSClientApp(args);
    app.run();
  }

  /**
   * Metodo que procesa los parametros de entrada
   * 
   * @param args parametros de entrada
   */
  private void processParameters(String[] args) {
    // En todos funciona igual
    // Se trata de extraer el parámetro del array de argumentos
    // Si se puede, se toma y si ocurre algún error se toma el valor por defecto
    // correspondiente
    try {
      serverHost = args[0];
    } catch (Exception e) {
      serverHost = DEFAULT_SERVER_HOST;
    }
    try {
      serverPort = Integer.parseInt(args[1]);
    } catch (Exception e) {
      serverPort = DEFAULT_SERVER_PORT;
    }
    try {
      port = Integer.parseInt(args[2]);
    } catch (Exception e) {
      port = MY_DEFAULT_PORT;
    }
  }

  /**
   * Metodo que "maqueta" y ejecuta la aplicación
   */
  private void run() {
    // Creamos el socket para enviar y recibir
    // Lo creamos con try con recursos para que se cierre al terminar
    try (DatagramSocket socket = new DatagramSocket(port)) {
      // Mientras no se introduzca la cadena vacía
      String nombreConsulta;
      do {
        // Lee el mensaje desde teclado

        System.out.print("Introduce el nombre a consultar (vacío para terminar): ");
        nombreConsulta = sc.nextLine();

        if (nombreConsulta.length() > 0) {
          byte[] consultaBytes = nombreConsulta.getBytes();
          DatagramPacket consultaPacket = new DatagramPacket(consultaBytes, consultaBytes.length,
              InetAddress.getByName(serverHost), serverPort);

          socket.send(consultaPacket);
          // Recibe la respuesta

          DatagramPacket respuestaPacket = new DatagramPacket(new byte[BUFFER_LENGTH], BUFFER_LENGTH);
          socket.receive(respuestaPacket);

          String respuesta = new String(respuestaPacket.getData(), respuestaPacket.getOffset(),
              respuestaPacket.getLength());
          // Y la imprime
          System.out.println("Respuesta recibida: " + respuesta);
        }
      } while (nombreConsulta.length() > 0);

      System.out.println("Terminando cliente...");
    } catch (IOException e) {
      System.err.println("Error en la comunicación con el servidor.");
      e.printStackTrace();
    }
  }
}
