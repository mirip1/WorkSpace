import java.util.Scanner;
import java.util.Random;

public class ParalelogramosApp {
  

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    
    System.out.println("Introduzca la longitud de los lados horizontales: ");
    double longitudHorizontal = Double.parseDouble(scan.nextLine());
  
    
    System.out.println("Introduzca el límite mínimo de los posibles valores de la longitud del lado vertical: ");
    double minimo = Double.parseDouble(scan.nextLine());
    
    System.out.println("Introduzca el límite máximo de los posibles valores de la longitud del lado vertical: ");
    double maximo = Double.parseDouble(scan.nextLine());
    
    Random numRandom1 = new Random();
    double longitudVertical=numRandom1.nextDouble(minimo, maximo);
    
    System.out.println(longitudVertical);
    
    //creamos el paralelogramo con los datos que tenemos
    Paralelogramo paralelogramo1 = new Paralelogramo(longitudHorizontal, longitudVertical);
    Paralelo
    
    //Imprimimos y Calculamos el área del perimetro
    
    System.out.println("El perimetro del paralelogramo es:" + paralelogramo1. );

  }

}
