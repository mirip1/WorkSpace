import java.util.Scanner;

public class B03ej12 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int num ;
    do{
      System.out.println("Introduce un numero entero (0 para terminar)");
      num = Integer.parseInt(scan.nextLine());
      if (num<0) {
        System.out.println("El numero es negativo");
      }
      else if (num>0){
        System.out.println("El numero es positivo");

      }
    }while (num!=0);
  }
}
