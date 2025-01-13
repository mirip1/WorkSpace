package main;

import java.security.MessageDigest;

public class PruebaMetodo {

  public static void main(String[] args) {
    
    System.out.println(cifraContrasenia("hola"));
    
    
    
    
  }
  
  private static String cifraContrasenia(String pass) {

    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");

      byte[] byteArray = pass.getBytes();
      digest.update(byteArray);

      byte[] bytes = digest.digest();
      StringBuilder sb = new StringBuilder();

      for (byte b : bytes) {
        sb.append(String.format("%02x", b));
      }
      return sb.toString();

    } catch (Exception e) {
      System.err.println("Erros haciendo el hash de la password: " + e.getMessage());
    }
    return "";
  }

}
