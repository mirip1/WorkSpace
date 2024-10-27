import java.util.Scanner;

public class Veinisiete {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Inserta tu edad");
    int edad = Integer.parseInt(scan.nextLine());
    System.out.println("Puedes conducir?(False No,True Si)"+(edad>=18));
  }
}
