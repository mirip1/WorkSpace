package psp.unidad01.relacion03;

import java.util.Scanner;

public class EchoCommandLine {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Escribe un parametro: ");
    String p1 = sc.nextLine();
    System.out.println("Este es tu párametro" + p1);

  }
}
