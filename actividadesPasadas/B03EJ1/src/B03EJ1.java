import java.util.Scanner;

public class B03EJ1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Escribe el numero de intervalo de inicio");
    int numInicio =  Integer.parseInt(scan.nextLine());
    System.out.println("Escribe el numero de intervalo ultimo");
    int numTerminar =  Integer.parseInt(scan.nextLine());
    
    while (numInicio>numTerminar) {
      System.out.println("Error el numero de inicio debe ser menor que el otro");
      System.out.println("Escribe el numero de intervalo de inicio");
      numInicio =  Integer.parseInt(scan.nextLine());
      System.out.println("Escribe el numero de intervalo ultimo");
      numTerminar =  Integer.parseInt(scan.nextLine());
      }

    for (int i= numInicio; i<=numTerminar; i++) {
      if ( i % 2 == 0 )
      {
          System.out.println( i+"ES PAR" );
      }
      else
      {
          System.out.println(i+"ES IMPAR" );
      }
      
    }
  }
}
