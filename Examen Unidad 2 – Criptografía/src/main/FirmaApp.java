package main;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Base64;

import javax.crypto.Cipher;

import hash.HashFichero;

public class FirmaApp {

//  private static final String ARCHIVO = "prueba.txt";
  private static final String RUTAALMACEN = "examenclaves.jks"; 
  private static final String ALIAS = "examen"; 
//  private static final char[] PASS = { '1', '2', '3', '4', '5', '6', '7', '8' };

  public static void main(String[] args) {
    
    if (args.length < 2) {
      System.out.println("Se necesitan dos parámetros: ruta del archivo y la contraseña.");
      return;
    }
    
    String fichero = args[0];
    String pass = args[1];
    char[] passChar = pass.toCharArray();
    
    

    HashFichero hash = new HashFichero();
    byte[] ficheroHasheado = hash.hashFichero(fichero);
    
    
    try {
      // Cargar el almacén de claves
      KeyStore keyStore = KeyStore.getInstance("JKS");
      keyStore.load(new FileInputStream(RUTAALMACEN), passChar);

      //Obtener la clave privada
      PrivateKey privateKey = (PrivateKey) keyStore.getKey(ALIAS, passChar);

      // Cifrar el mensaje
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(Cipher.ENCRYPT_MODE, privateKey);
      byte[] mensajeCifrado = cipher.doFinal(ficheroHasheado);

      // Convertir a Base64
      String mensajeCifradoBase64 = Base64.getEncoder().encodeToString(mensajeCifrado);
      System.out.println("\nMensaje cifrado (Base64): " + mensajeCifradoBase64);
      
  } catch (Exception e) {
      e.printStackTrace();
  }
    
  }

}
