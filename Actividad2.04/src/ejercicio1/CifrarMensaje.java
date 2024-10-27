package ejercicio1;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.crypto.Cipher;

public class CifrarMensaje {
  public static String cifrarMensaje(String mensaje, String alias, String keyStorePath, char[] keyStorePassword) {
    try {
      // Cargar el KeyStore
      KeyStore almacen = KeyStore.getInstance(KeyStore.getDefaultType());
      try (FileInputStream fis = new FileInputStream(keyStorePath)) {
        almacen.load(fis, keyStorePassword);
      }

      // Obtener la clave pública
      Certificate cert = almacen.getCertificate(alias);
      if (cert == null) {
        throw new Exception("Alias no encontrado: " + alias);
      }
      PublicKey publicKey = cert.getPublicKey();

      // Cifrar el mensaje
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(Cipher.ENCRYPT_MODE, publicKey);
      byte[] encryptedBytes = cipher.doFinal(mensaje.getBytes());

      // Convertir a base64
      return Base64.getEncoder().encodeToString(encryptedBytes);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  

  public static String descifrarMensaje(String mensajeCifrado, String alias, String keyStorePath, char[] keyStorePassword) {
    try {
      // Cargar el KeyStore
      KeyStore almacen = KeyStore.getInstance(KeyStore.getDefaultType());
      try (FileInputStream fis = new FileInputStream(keyStorePath)) {
        almacen.load(fis, keyStorePassword);
      }
      // Obtener la clave privada
      KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) almacen.getEntry(alias, new KeyStore.PasswordProtection(keyStorePassword));
      if (privateKeyEntry == null) {
        throw new Exception("Alias no encontrado: " + alias);
      }
      PrivateKey privateKey = privateKeyEntry.getPrivateKey();
      // Descifrar el mensaje
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(Cipher.DECRYPT_MODE, privateKey);
      byte[] decodedBytes = Base64.getDecoder().decode(mensajeCifrado);
      byte[] decryptedBytes = cipher.doFinal(decodedBytes);
      return new String(decryptedBytes);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
