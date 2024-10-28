package pcp.unidad1.relacion07_2;

public class SumadorProdess {

  public static void main(String[] args) {
    
    if (args.length != 2) {
      System.err.println("Se deben introducir dos argumentos");
    } 
    
    int numero1 = Integer.parseInt(args[0]);
    int numero2 = Integer.parseInt(args[1]);
    int mayor;
    int menor;
    int acum = 0;
    
    if(numero1 > numero2) {
      mayor = numero1;
      menor = numero2;
    }else {
      mayor = numero2;
      menor = numero1;
    }
    
    
    for(int i = menor; i <= mayor ; i++) {
      acum += i;
    }
    
    System.out.println(acum);

    
    
    
    
  }
}
