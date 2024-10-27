package server;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SHHClient {
  public static void main(String[] args) {
    String user = "mivel"; // Usuario del servidor Ubuntu
    String host = "185.209.228.107"; // Dirección IP del servidor
    int port = 22; // Puerto SSH (por defecto es 22)
    String password = "yolo123"; // Contraseña del usuario

    try {
      // Crear una instancia de JSch
      JSch jsch = new JSch();

      // Iniciar la sesión SSH
      Session session = jsch.getSession(user, host, port);
      session.setPassword(password);

      // Evitar verificar la clave del host (esto es inseguro para producción)
      session.setConfig("StrictHostKeyChecking", "no");

      // Conectar
      System.out.println("Conectando al servidor...");
      session.connect();

      // Abrir un canal para ejecutar comandos
      Channel channel = session.openChannel("exec");
      ((ChannelExec) channel).setCommand("screen -r"); // Comando para reanudar sesiones de screen

      // Obtener la salida del comando
      channel.setInputStream(null);
      ((ChannelExec) channel).setErrStream(System.err);

      InputStream input = channel.getInputStream();
      channel.connect();

      // Leer la salida del comando
      byte[] tmp = new byte[1024];
      while (true) {
        while (input.available() > 0) {
          int i = input.read(tmp, 0, 1024);
          if (i < 0)
            break;
          System.out.print(new String(tmp, 0, i));
        }
        if (channel.isClosed()) {
          System.out.println("Comando terminado con estado: " + channel.getExitStatus());
          break;
        }
        try {
          Thread.sleep(1000);
        } catch (Exception ee) {
          ee.printStackTrace();
        }
      }

      // Cerrar el canal y la sesión
      channel.disconnect();
      session.disconnect();
      System.out.println("Desconectado del servidor.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
