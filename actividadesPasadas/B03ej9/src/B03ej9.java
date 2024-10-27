import java.util.Scanner;

public class B03ej9 {
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Escribe el numero entero ");
    int num = Integer.parseInt(scan.nextLine());
    int num2= num;
    do {
      System.out.println("Escribe el numero mayor que "+ num);
      num2=num;
      num = Integer.parseInt(scan.nextLine());

      
    }while (num>num2) ;
    
  }
}
