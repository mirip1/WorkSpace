package Util;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;


public class Factoria {

  
  
  public static Key generateKey(String password, String salt) {
    char[] pass =   password.toCharArray();
    byte[] saltBytes =   salt.getBytes();
    SecretKeyFactory keyFactory;
    SecretKey secretKey = null;
    Key key=null;
    try {
      keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
      PBEKeySpec keySpec = new PBEKeySpec(pass, saltBytes, 10, 256);
      
      secretKey = keyFactory.generateSecret(keySpec);
      key= new SecretKeySpec(secretKey.getEncoded(), "AES");
      
      
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return  key; 
  }
  
  public static String encrypt(String message, Key key) {
    try {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
  
  public static String decrypt(String message, Key key) {
    try {
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.DECRYPT_MODE, key);
      byte[] mensajeEncriptado = Base64.getDecoder().decode(message);
      byte[] mensajeDesecnriptado = cipher.doFinal(mensajeEncriptado);
      String resultado = new String(mensajeDesecnriptado);
      return resultado;
  } catch (Exception e) {
      e.printStackTrace();
  }
  return null;
    
  }
}

