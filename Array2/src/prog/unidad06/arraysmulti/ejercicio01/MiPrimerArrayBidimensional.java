package prog.unidad06.arraysmulti.ejercicio01;

public class MiPrimerArrayBidimensional {

  public static void main(String[] args) {
    Integer[][] tabla = new Integer[3][6];
    tabla[0][0]=35;
    tabla[0][2]=64;
    tabla[0][3]=69;
    tabla[0][5]=93;
    tabla[1][1]=12;
    tabla[1][4]=92;
    tabla[1][5]=97;
    tabla[2][0]=13;
    tabla[2][2]=33;
    tabla[2][4]=52;

    //Mostrar Array por pantalla
    System.out.println("MI PRIMER ARRAY BIDIMENSIONAL");
    System.out.println("------------------------------");
    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        int valor = (tabla[i][j] != null) ? tabla[i][j] : 0;
        System.out.print(String.format("%5d", valor));

      }
      System.out.println();

    }
    System.out.println("------------------------------");

    
  }

}
