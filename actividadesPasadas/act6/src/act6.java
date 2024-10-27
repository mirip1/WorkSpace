
import java.util.Scanner;

public class act6 {
  public static void main(String[] args) {
    //Pedimos por pantalla
    Scanner scan = new Scanner(System.in);
    System.out.println("Escribe la primera cadena: ");
    String cadena1 = scan.nextLine();
    System.out.println("Escribe la segunda cadena: ");
    String cadena2 = scan.nextLine();
    
    //Imprimimos por pantalla
    System.out.println("La longitud de la cadena1 es:"+ cadena1.length() +" y de la cadena2: "+cadena2.length());
    System.out.println("La cadena1 es vacia¿?:"+ cadena1.isEmpty() +" y la cadena2¿?: "+cadena2.isEmpty());
    System.out.println("La cadena1 es espacio en blanco¿?:"+ cadena1.isBlank() +" y la cadena2¿?: "+cadena2.isBlank());
    //Concatenamos
    System.out.println("Concatenamos las dos cadenas: "+ (cadena1+cadena2));
    System.out.println("Son iguales?: "+ cadena1.equals(cadena2));
    System.out.println("Son iguales?: "+ cadena1.equalsIgnoreCase(cadena2));
    System.out.println("empiezan por: "+ cadena1.startsWith("a")+" y "+ cadena2.startsWith("a"));
    System.out.println("empiezan por: "+ cadena1.trim());
    
    
  }
  
}
