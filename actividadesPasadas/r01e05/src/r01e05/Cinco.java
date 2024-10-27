package r01e05;

import java.util.Scanner;

public class Cinco {

  public static void main(String[] args) {
    
    final double PESETASPOREURO = 166.386;

    Scanner scan = new Scanner(System.in);

    System.out.println("CONVERSOR DE PESETAS A EUROS");
    System.out.println("----------------------------");
    System.out.print("Introduce una cantidad de dinero en pesetas: ");
    double pesetas = Double.parseDouble(scan.nextLine());

    double euros = pesetas / PESETASPOREURO;

    System.out.println(pesetas + " pesetas equivalen a " +  euros + " euros");
  }
}
