import java.util.Scanner;

public class Act2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Primer num complejo
    System.out.println("Ingresa el primer numero: ");
    System.out.println("Ingresa la parte real por pantalla: ");
    Double parteR = Double.parseDouble(scan.nextLine());
    System.out.println("Ingresa la parte imaginaria por pantalla: ");
    Double parteI = Double.parseDouble(scan.nextLine());
    Complejo complejo = new Complejo(parteR, parteI);

    // Segundo num complejo
    System.out.println("Ingresa el segundo numero");
    System.out.println("Ingresa la parte real por pantalla: ");
    Double parteR2 = Double.parseDouble(scan.nextLine());
    System.out.println("Ingresa la parte imaginaria por pantalla: ");
    Double parteI2 = Double.parseDouble(scan.nextLine());
    Complejo complejo2 = new Complejo(parteR2, parteI2);

    // Operaciones

    Complejo suma = new Complejo(0, 0);
    suma = complejo.sumar(complejo2);

    System.out.println("la suma es: " + suma.getParteReal() + " y " + suma.getParteImaginaria());

    Complejo resta = new Complejo(0, 0);
    resta = complejo.restar(complejo2);

    System.out.println("la suma es: " + resta.getParteReal() + " y " + resta.getParteImaginaria());

    Complejo multiplica = new Complejo(0, 0);
    multiplica = complejo.multiplicar(complejo2);

    System.out.println("la suma es: " + multiplica.getParteReal() + " y " + multiplica.getParteImaginaria());

    Complejo dividi = new Complejo(0, 0);
    dividi = complejo.dividir(complejo2);

    System.out.println("la suma es: " + dividi.getParteReal() + " y " + dividi.getParteImaginaria());

  }

}
