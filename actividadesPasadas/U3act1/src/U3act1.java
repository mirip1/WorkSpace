import java.util.Scanner;
import java.lang.Math;


public class U3act1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Introduce tu peso en kg: ");
    double peso = Double.parseDouble(scan.nextLine());
    System.out.println("Introduce tu altura en m: ");
    double altura = Double.parseDouble(scan.nextLine());
    double imc = (peso / (altura * altura));
    System.out.println("Tu IMC es de : " + Math.round(imc));

    if (imc < 16) {
      System.out.println("<16");
    } else if (imc >= 16 && imc < 17) {
      System.out.println("entre 16 y 17");
    } else if (imc >= 17 && imc < 18) {
      System.out.println("entre 17 y 18");
    } else if (imc >= 18 && imc < 25) {
      System.out.println("entre 18 y 25");
    } else if (imc >= 25 && imc < 30) {
      System.out.println("entre 25 y 30");
    } else if (imc >= 30 && imc < 35) {
      System.out.println("entre 30 y 35");
    } else if (imc >= 35 && imc <= 40) {
      System.out.println("entre 35 y 40");
    } else if (imc > 40) {
      System.out.println("mayor que 40");
    }
  }
}
