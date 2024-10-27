package Apps;

import java.util.Scanner;

import Util.Factoria;

public class DescifraApp {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    String mensaje = "mensaje de prueba";
    String password = "pas123";

    String mensajeCifrado= Factoria.encrypt(mensaje, Factoria.generateKey(password, "Hola"));
    System.out.println(Factoria.decrypt(mensajeCifrado, Factoria.generateKey(password, "Hola")));
    

  }

}
