import java.util.Scanner;

public class B03ej10 {
public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Escribe el numero de intervalo de inicio");
    int numInicio =  Integer.parseInt(scan.nextLine());
    System.out.println("Escribe el numero de intervalo ultimo");
    int numTerminar =  Integer.parseInt(scan.nextLine());
    int acum = numInicio ;
    
    while (numInicio>numTerminar) {
      System.out.println("Error el numero de inicio debe ser menor que el otro");
      System.out.println("Escribe el numero de intervalo de inicio");
      numInicio =  Integer.parseInt(scan.nextLine());
      System.out.println("Escribe el numero de intervalo ultimo");
      numTerminar =  Integer.parseInt(scan.nextLine());
      }
    for (int i=numInicio+1; i<=numTerminar; i++ ) {
      acum = acum+i; 
      System.out.println(acum);

    }
    System.out.println("La suma de los numeros desde el "+ numInicio+" hasta el "+ numTerminar+" es "+ acum);

  }
  
  
}
