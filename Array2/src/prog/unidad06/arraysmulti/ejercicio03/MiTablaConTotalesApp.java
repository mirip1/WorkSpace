package prog.unidad06.arraysmulti.ejercicio03;

import java.util.Scanner;

import prog.unidad06.arraysmulti.ejercicio02.TablaEnteraConTotales;

public class MiTablaConTotalesApp {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int num = 0;
    TablaEnteraConTotales lista = new TablaEnteraConTotales(4,5);
    for (int i = 0; i != 4 ; i++) {
      
      for (int j = 0; j != 5 ; j++) {
        System.out.println("Introduzca el número correspondiente a la casilla: ("+ i + "," + j +")");
        num = Integer.parseInt(scan.nextLine());
        lista.setCasilla(i, j, num);
      }
    } 
    System.out.println("------------------------------");
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.print(String.format("%5d", lista.getCasilla(i, j)));

      }
      System.out.print(String.format("%5d", lista.getTotalFila(i)));

      System.out.println();

    }
    for (int j = 0; j < 4; j++) {
      System.out.print(String.format("%5d", lista.getTotalColumna(j)));

    }
    System.out.print(String.format("%5d", lista.getTotalTabla()));

    System.out.println("------------------------------");

    
    
  }

} 
