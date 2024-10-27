package Util;

import java.io.FileInputStream;
import java.security.MessageDigest;

public class HashCont {

  public HashCont() {
  }

  public static String cifraMensaje(String mensaje) {
    try {

      MessageDigest encriptar = MessageDigest.getInstance("SHA-256");
      byte[] buffer = mensaje.getBytes();
      encriptar.update(buffer);

      byte[] bytes = encriptar.digest();
      StringBuilder sb = new StringBuilder();
      
      for (byte b : bytes) {
        sb.append(String.format("%02x", b));
      }
      
//      System.out.println(sb.toString());
      
      return sb.toString();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
    
  }
}
