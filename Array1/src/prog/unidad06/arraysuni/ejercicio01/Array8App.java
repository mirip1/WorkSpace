package prog.unidad06.arraysuni.ejercicio01;

import java.util.Scanner;

public class Array8App {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("OPERACIONES VARIAS SOBRE UN ARRAY DE 8 ELEMENTOS");
    System.out.println("A continuación se van a solicitar 8 números reales");
    
    double[] numeros = new double[8];
    double total = 0;
    double mayores = 0;
    int cantidad = 0;
    int cantidad2 = 0;
    int media = 0;
    
    for (int i = 0; i != numeros.length; i++) {
      System.out.println("Introduce el numero "+ (i+1));
      numeros[i] = Double.parseDouble(scan.nextLine());
      total+=numeros[i];
      if (numeros[i]>36) {
        mayores+=numeros[i];
      }
      if (numeros[i]>50) {
        cantidad++;
      }
      if (numeros[i]>=10 && numeros[i]<=30) {
        cantidad2++;
        media+=numeros[i];
        
      }
      
    }
    System.out.println("La suma de todos los elementos vale "+ total);
    System.out.println("La suma de los elementos mayores de 36 vale "+ mayores);
    System.out.println("La cantidad de elementos mayores a 50 es de "+ cantidad);
    System.out.println("La media de los 1 elementos comprendidos entre 10 y 30 vale "+ (media/cantidad2));

    
  }

}
