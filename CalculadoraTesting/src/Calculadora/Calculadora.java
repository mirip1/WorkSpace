package Calculadora;

public class Calculadora {
  
    //Es una calculadora de numeros enteros 
  
    public static int suma(int a, int b){
      return a+b;
    }
    
    public static int resta(int a, int b){
      return a-b;
    }
    
    public static int multiplicar(int a, int b){
      return a*b;
    }
    
    public static int dividir(int a, int b){
      return a/b;
    }
    
    public static boolean esPositivo(int a){
      return a>=0;
    }
    
    public static boolean esPrimo(int a){
      boolean primo = true; 
      for(int i = 2; i < a; i++) {
        if (a % i == 0) {
          primo = false;
          break;
          }
      }
      return primo;
    }


}
