import java.util.Scanner;

public class B03ej11 {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int numInicio;
    int numTerminar;
    do {
      System.out.println("Escribe el numero de intervalo de inicio");
      numInicio = Integer.parseInt(scan.nextLine());
      System.out.println("Escribe el numero de intervalo ultimo");
      numTerminar = Integer.parseInt(scan.nextLine());
      if (numInicio>=numTerminar) {
        System.out.println("Error el numero de inicio debe ser menor que el otro");
      }
      
    }while(numInicio>=numTerminar);
    int acum = numInicio;

    for (int i = numInicio + 1; i <= numTerminar; i++) {
      if (acum%2==0) {
      acum = acum + i;
      }
      else {
        acum++;
      }
     
    }
    System.out.println("La suma de los numeros desde el " + numInicio + " hasta el " + numTerminar + " es " + acum);

  }
}
