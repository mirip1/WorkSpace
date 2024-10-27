
public class TablaMultiplicar {

  private int num;
  
  public TablaMultiplicar (int num) {
    this.num = num;
    
  }
  
  public void imprimirTabla() {
    System.out.println("Tabla multiplicar del : " + num);
    for (int i = 1; i != 10; i++) {
     System.out.printf("%2d x %2d = %2d%n", num, i, (num*i));
      
    }
    
  }
  
}
