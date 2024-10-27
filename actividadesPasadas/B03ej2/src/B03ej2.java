import java.util.Scanner;

public class B03ej2 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("¿Cuantos numeros deseas introducir?");
    int listaNum =  Integer.parseInt(scan.nextLine());
    int i = 0;
    int num;
    int numPar;
    int numImp;
    numPar = 0;
    numImp = 0;
    while (i != listaNum) {
      System.out.println("Introduce el numero " + (i+1));

      num = Integer.parseInt(scan.nextLine());
      if (num % 2 == 0) {
        numPar++;
      } else {
        numImp++;
      }
      i++;

    }
    System.out.println("Has introducido " + numPar + " numeros pares y " + numImp + " Numeros impares");
    
  }
}
