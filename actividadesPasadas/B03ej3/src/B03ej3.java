import java.util.Scanner;

public class B03ej3 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    System.out.println("¿Cuantos numeros deseas introducir?");
    int listaNum =  Integer.parseInt(scan.nextLine());
    double num;
    System.out.println("Introduce el numero 1" );
    num = Double.parseDouble(scan.nextLine());

    double numMayor= num;
    double numMenor=num ;
    double numMedia = 0;
    double acum = num;


    
    for (int i=1; i!= listaNum;i++ ) {
      System.out.println("Introduce el numero " + (i+1));
      num = Double.parseDouble(scan.nextLine());
      if (num>numMayor) {
        numMayor = num;
      }else if (num<numMenor){
        numMenor = num;
      }
      acum= num + acum;

    }

    numMedia = acum / listaNum;
    System.out.println("Num Mayor "+ numMayor);
    System.out.println("Num Menor "+ numMenor);
    System.out.println("Media total "+ numMedia);

  }

}
