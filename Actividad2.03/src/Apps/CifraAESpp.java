package Apps;

import java.util.Scanner;

import Util.Factoria;

public class CifraAESpp {

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Escribe un mensaje");
    String mensaje = scan.nextLine();
    if (mensaje.isEmpty()) {
      mensaje = "mensaje de prueba";
    };
    
    System.out.println("Escribe una contraseña");
    String password = scan.nextLine();
    if (password.isEmpty()) {
      password = "pas123";
    };
    
    
    System.out.println(Factoria.encrypt(password, Factoria.generateKey(mensaje,"Hola")));
    
    
    
    
    
    

  }

}
