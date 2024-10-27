import java.util.Scanner;

public class Cuatro1 {
  public static void main(String[] args) {
    //Pido un numerom por pantalla
    Scanner sc = new Scanner(System.in);
    System.out.println("Escribe un numero: ");
    //Aqui digo si es par o impar
    int numero = Integer.parseInt(sc.nextLine());
    System.out.println("El numero es par(true) o impar(False)"(numero%2)==0);
  }
}
