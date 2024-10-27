
import java.util.Scanner;
import paquete1.Fraccion;

public class act5 {
  public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
    //Primer Num

    System.out.println("Escriba el numerador de la fraccion: ");
    int Num = Integer.parseInt(scan.nextLine());
    System.out.println("Escriba el denominador de la fraccion: ");
    int Den = Integer.parseInt(scan.nextLine());
    paquete1.Fraccion fraccion1 = new paquete1.Fraccion(Num, Den);
    
    //Segundo Num
    System.out.println("Escriba el numerador de la fraccion: ");
    int Num2 = Integer.parseInt(scan.nextLine());
    System.out.println("Escriba el denominador de la fraccion: ");
    int Den2 = Integer.parseInt(scan.nextLine());
    paquete1.Fraccion fraccion2 = new paquete1.Fraccion(Num2, Den2);
    
    //Operaciones
    paquete1.Fraccion sumar = fraccion1.suma(fraccion2);
    paquete1.Fraccion dividir = fraccion1.division(fraccion2);
    paquete1.Fraccion restar = fraccion1.resta(fraccion2);
    paquete1.Fraccion multiplicar = fraccion1.producto(fraccion2);
    
    //Simplificamos
    paquete2.Fraccion simplificar = new paquete2.Fraccion(sumar.getNumerador(), sumar.getDenominador()).simplifica();
    paquete2.Fraccion simplificar2 = new paquete2.Fraccion(dividir.getNumerador(), dividir.getDenominador()).simplifica();
    paquete2.Fraccion simplificar3 = new paquete2.Fraccion(restar.getNumerador(), restar.getDenominador()).simplifica();
    paquete2.Fraccion simplificar4 = new paquete2.Fraccion(multiplicar.getNumerador(), multiplicar.getDenominador()).simplifica();

    //Imprimimos2
    System.out.println("La suma de las dos fracciones ess: "+simplificar.getNum()+"/"+simplificar.getDen());
    System.out.println("La division de las dos fracciones ess: "+simplificar2.getNum()+"/"+simplificar2.getDen());
    System.out.println("La resta de las dos fracciones ess: "+simplificar3.getNum()+"/"+simplificar3.getDen());
    System.out.println("La multiplicacion de las dos pollos ess: "+simplificar4.getNum()+"/"+simplificar4.getDen());
    
   
    
    

    
    
  }

  }

