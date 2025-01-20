package psp.ud03.practica01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que se ocupa del Lado del servidor
 */
public class MainDNSServerApp {
    // Constantes
  
    // Puerto por defecto en el que se escucha
    private static final int DEFAULT_PORT = 2222;
    
    // Longitud del buffer de recepción
    private static final int BUFFER_LENGTH = 1024;
    private static final String ARCHIVO_DNS = "dns.properties";

    // Puerto en el que escucha el servidor
    private int port;
    private Map<String, String> dnsMap;

    public MainDNSServerApp(String[] args) {
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            port = DEFAULT_PORT;
        }
        dnsMap = cargarDNS(ARCHIVO_DNS);
    }

    /**
     * El main
     * @param args
     */
    public static void main(String[] args) {
        // Crea una instancia de la clase y la ejecuta
        MainDNSServerApp app = new MainDNSServerApp(args);
        app.run();
    }
    
    /**
     * Metodo que "maqueta" y ejecuta la aplicación
     */
    private void run() {
        // Creamos el socket con el puerto en el que escuchamos
        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Servidor DNS iniciado en el puerto " + port);
            
            // Esperamos conexiones una detrás de otra (Si se produce un error, se termina)
            DatagramPacket receivedPacket = new DatagramPacket(new byte[BUFFER_LENGTH], BUFFER_LENGTH);
            for(;;) {
                // Recibir paquete del cliente
                socket.receive(receivedPacket);
                String nombreConsultado = new String(receivedPacket.getData(), receivedPacket.getOffset(), receivedPacket.getLength());
                System.out.println("Consulta recibida: " + nombreConsultado);

                // Buscar la IP en el mapa
                String respuesta = dnsMap.getOrDefault(nombreConsultado, "El nombre no se encuentra");

                // Creamos el mensaje de respuesta y lo enviamos al cliente
                byte[] responseBytes = respuesta.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, receivedPacket.getAddress(), receivedPacket.getPort());
                socket.send(responsePacket);
                System.out.println("Respuesta enviada: " + respuesta);
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
    
    /**
     * Metodo que lee y guarda los contenidos del archivo .properties
     * @param ruta dela rchivo
     * @return mapa con la informacion de archivo el nombre y la Ip
     */
    private Map<String, String> cargarDNS(String archivo) {
        Map<String, String> dnsMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty() && linea.contains("=")) {
                    String[] partes = linea.split("=", 2);
                    dnsMap.put(partes[0].trim(), partes[1].trim());
                }
            }
//            System.out.println("Archivo DNS cargado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + archivo + ": " + e.getMessage());
        }
        return dnsMap;
    }
}
