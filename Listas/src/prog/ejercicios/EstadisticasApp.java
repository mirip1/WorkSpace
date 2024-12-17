package prog.ejercicios;

import java.util.List;

public class EstadisticasApp {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    List<Integer> lista2 = ListaEnterosUtils.generaListaEnterosAleatorios(10, 20, 0, 100);
    
    System.out.println("La lista generada es: "+ ListaEnterosUtils.generaCadena(lista2));
    
    lista2.replaceAll(n -> n+=1);
    
    System.out.println("La lista generada es: "+ lista2);

  }

}
