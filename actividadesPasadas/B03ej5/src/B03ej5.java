import java.util.Scanner;

public class B03ej5 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in); 
    System.out.println("Escribe numero que quieras saber la tabla de multiplicar");
    int num = Integer.parseInt(scan.nextLine());
    for (int i = 1; i != 11 ; i++) {
      System.out.println(num +" X "+i+" = "+ num*i);
   
    }
  
  }

}
