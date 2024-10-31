package hash;

import java.io.FileInputStream;
import java.security.MessageDigest;

public class HashFichero {
  
  public HashFichero() {

  }

  public byte[] hashFichero(String fichero) {
    // Cifrado deseado
    String codigo = "SHA-256";
    byte[] resultado = null;

    try (FileInputStream in = new FileInputStream(fichero)) {
      MessageDigest encriptar = MessageDigest.getInstance(codigo);

      byte[] buffer = new byte[4096];
      int leidos;
      while ((leidos = in.read(buffer)) != -1) {
        encriptar.update(buffer, 0, leidos);
      }

      byte[] bytes = encriptar.digest();
      StringBuilder sb = new StringBuilder();
//     for (byte b : bytes) {
//       sb.append(String.format("%02x", b));
//     }
//
      resultado = bytes;
      


    } catch (Exception e) {
      e.printStackTrace();
    }
    return resultado;
  }
}
