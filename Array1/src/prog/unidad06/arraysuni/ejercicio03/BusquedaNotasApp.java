package prog.unidad06.arraysuni.ejercicio03;

import java.util.Scanner;

import prog.unidad06.arraysuni.ejercicio02.UtilidadesArrays;

public class BusquedaNotasApp {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("BÚSQUEDA DE CALIFICACIONES");
    int[] calificaciones = UtilidadesArrays.generaArrayEnteroAleatorio(30, 0, 10);
    int nota;
    int suma; 
    
    do {
      suma = 0;
      System.out.println("Introduzca la calificación a buscar (0 a 10, negativa para terminar):");
      nota = Integer.parseInt(scan.nextLine());
      for (int i = 0; i != calificaciones.length; i++) {
        if(calificaciones[i] == nota) {
          suma++; 
        }
      }
      System.out.println("Con la calificacion "+ nota + " se han encontrado "+ suma +" alumnos");
      
    }while (nota >= 0);
    System.out.println("FIN DEL PROGRAMA");

  }

}
