package psp.ud03.practica02;

import java.io.*;
import java.net.*;

/**
 * Clase que se ocupa del Lado del servidor
 */
public class MainFileServerApp {
  // Constantes

  // Puerto por defecto en el que se escucha
  private static final int DEFAULT_PORT = 4321;
  private int port;

  public MainFileServerApp(String[] args) {
    try {
      port = Integer.parseInt(args[0]);
    } catch (Exception e) {
      port = DEFAULT_PORT;
    }
  }

  /**
   * El main
   * 
   * @param args
   */
  public static void main(String[] args) {
    MainFileServerApp app = new MainFileServerApp(args);
    app.run();
  }

  /**
   * Metodo que "maqueta" y ejecuta la aplicación
   */
  private void run() {
    try (ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("Servidor de archivos iniciado en el puerto " + port);

      for (;;) {
        Socket clientSocket = serverSocket.accept();
        System.out.println("Cliente conectado: " + clientSocket.getInetAddress());
        new Thread(new FileTransferHandler(clientSocket)).start();
      }
    } catch (IOException e) {
      System.err.println("Error en el servidor: " + e.getMessage());
    }
  }

  private class FileTransferHandler implements Runnable {
    private Socket socket;

    public FileTransferHandler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          OutputStream outputStream = socket.getOutputStream()) {

        String filePath = reader.readLine();
        System.out.println("Solicitud de archivo: " + filePath);

        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
          outputStream.write("OK\n\r".getBytes());
          try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
              outputStream.write(buffer, 0, bytesRead);
            }
          }
          System.out.println("Archivo enviado: " + filePath);
        } else {
          outputStream.write("KO\n\r".getBytes());
          System.out.println("Archivo no encontrado: " + filePath);
        }
      } catch (IOException e) {
        System.err.println("Error al manejar cliente: " + e.getMessage());
      } finally {
        try {
          socket.close();
        } catch (IOException e) {
          System.err.println("Error cerrando conexión: " + e.getMessage());
        }
      }
    }
  }

}
