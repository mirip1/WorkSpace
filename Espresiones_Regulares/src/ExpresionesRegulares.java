import java.util.Scanner;

public class ExpresionesRegulares {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String pattern = "([_a-zA-Z]/w+)";
    String mensaje;

    // Ejercicio1
    pattern = "[a]b*";
    mensaje = "abbb";
    System.out.println("Ejercicio1: " + mensaje.matches(pattern));

    // Ejercicio2
    pattern = "[a]b+";
    mensaje = "ab";
    System.out.println("Ejercicio2: " + mensaje.matches(pattern));

    // Ejercicio3
    pattern = "[a]b{3}";
    mensaje = "abbb";
    System.out.println("Ejercicio3: " + mensaje.matches(pattern));

    // Ejercicio4
    pattern = "[a]b{2,3}";
    mensaje = "abb";
    System.out.println("Ejercicio4: " + mensaje.matches(pattern));

    // Ejercicio5
    pattern = "([a-z]_?)+";
    mensaje = "a_b_g";
    System.out.println("Ejercicio5: " + mensaje.matches(pattern));

    // Ejercicio6
    pattern = "[A-Z][a-z]+";
    mensaje = "Asss";
    System.out.println("Ejercicio6: " + mensaje.matches(pattern));

    // Ejercicio7
    pattern = "[A-Za-z]+\\s";
    mensaje = "Hola ";
    System.out.println("Ejercicio7: " + mensaje.matches(pattern));

    // Ejercicio8
    pattern = "(.+\\s[A-Za-z]+[.,;]?)";
    mensaje = "ghewq21321 Adios";
    System.out.println("Ejercicio8: " + mensaje.matches(pattern));

    // Ejercicio9
    pattern = "\\w*[z]\\w*";
    mensaje = "arroz";
    System.out.println("Ejercicio9: " + mensaje.matches(pattern));

    // Ejercicio10
    pattern = "\\d{1,3}[.]\\d{1,3}[.]\\d{1,3}[.]\\d{1,3}";
    mensaje = "192.168.1.1";
    System.out.println("Ejercicio10: " + mensaje.matches(pattern));

    // Ejercicio11
    pattern = "\\d{4}[-]\\d{2}[-]\\d{2}";
    mensaje = "2005-07-11";
    System.out.println("Ejercicio11: " + mensaje.matches(pattern));

    // Ejercicio12
    pattern = "[+-]?\\d+[,]?\\d*";
    mensaje = "-2,2";
    System.out.println("Ejercicio12: " + mensaje.matches(pattern));

    // Ejercicio13
    pattern = "[+-]?\\d+[,]?\\d*";
    mensaje = "-2,2";
    System.out.println("Ejercicio13: " + mensaje.matches(pattern));

    // Ejercicio14
    pattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    mensaje = "mivelfer@gmail.com";
    System.out.println("Ejercicio14: " + mensaje.matches(pattern));

    // Ejercicio15
    pattern = "\\+\\d{1,3}\\s?\\d{4,14}(\\s\\d{2,5})?$";
    mensaje = "+34 555555";
    System.out.println("Ejercicio15: " + mensaje.matches(pattern));

  }

}
