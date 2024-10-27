
public class B03ej13 {
  public static void main(String[] args) {
    
    System.out.println("NUMEROS DEL 1 AL 100");
    for (int i = 1; i!=101; i++) {
      System.out.print(i + "  ");
      if (i%10==0) {
        System.out.println(" ");
      }     
      if (i<10) {
        System.out.print(" ");
      }
    
    }
  } 
}