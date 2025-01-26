package psp.ud03.practica02;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Cliente para la transferencia de archivos.
 */
public class MainFileClientApp {
    // Constantes
    private static final String DEFAULT_SERVER_HOST = "localhost";
    private static final int DEFAULT_SERVER_PORT = 4321;
    
    private String serverHost;
    private int serverPort;
    private Scanner scanner;

    public MainFileClientApp(String[] args) {
        processParameters(args);
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        MainFileClientApp client = new MainFileClientApp(args);
        client.run();
    }

    /**
     * Procesa los parámetros de entrada
     */
    private void processParameters(String[] args) {
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
    }

    /**
     * Método que ejecuta la aplicación
     */
    private void run() {
        try {
            String filePath;
            do {
                System.out.print("Introduce la ruta del archivo a solicitar (vacío para terminar): ");
                filePath = scanner.nextLine();

                if (!filePath.isEmpty()) {
                    requestFile(filePath);
                }
            } while (!filePath.isEmpty());

            System.out.println("Cliente terminado.");
        } catch (Exception e) {
            System.err.println("Error en la ejecución del cliente: " + e.getMessage());
        }
    }

    /**
     * Solicita un archivo al servidor y lo guarda localmente.
     */
    private void requestFile(String filePath) {
        try (Socket socket = new Socket(serverHost, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             InputStream in = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            // Enviar la ruta del archivo al servidor
            out.println(filePath);

            // Leer la respuesta del servidor
            String response = reader.readLine();

            if ("OK".equals(response)) {
                // Recibir y guardar el archivo
                String fileName = new File(filePath).getName();
                try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        fileOut.write(buffer, 0, bytesRead);
                    }
                    System.out.println("Archivo recibido y guardado como: " + fileName);
                }
            } else {
                System.out.println("El archivo no existe en el servidor.");
            }
        } catch (IOException e) {
            System.err.println("Error en la comunicación con el servidor: " + e.getMessage());
        }
    }
}
