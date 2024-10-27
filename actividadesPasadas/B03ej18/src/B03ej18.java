import java.util.Scanner;

public class B03ej18 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("cuantos numeros deseas introducir");
    int num = 0;
    int num2 = 0;
    int a = 0;
    do {
      try {
        num2 = Integer.parseInt(scan.nextLine());
        a++;

      } catch (NumberFormatException e) {
        System.out.println("Te he dicho que pongas un puto numero pedazo de desgraciado");

      }
    } while (a==0);
    
   while (num2!=0) {
       try {
         System.out.println("Introduzca un numero");
         num = Integer.parseInt(scan.nextLine());
         
         num2--;

       } catch (NumberFormatException e) {
         System.out.println("Te he dicho que pongas un puto numero pedazo de desgraciado");

       }
   }
  }
}
