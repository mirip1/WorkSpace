import java.util.Scanner;

public class Dos {
  //Declaro constante
  public static final double VALOPESETA = 166.386;
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce un numero de euros que pasaras a pesetas");
    
    //Declaro la variable euro y la pido por pantalla
    int euro = Integer.parseInt(sc.nextLine());
    
    System.out.println(euro+" euros son "+ euro*VALOPESETA+" pesetas");
    
    
    
  }
    

}
