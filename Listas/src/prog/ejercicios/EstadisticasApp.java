package prog.ejercicios;

import java.util.List;

public class EstadisticasApp {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ListaEnterosUtils lista = new ListaEnterosUtils();
    List<Integer> lista2 = new List();
    lista.generaListaEnterosAleatorios(10, 20, 0, 100);
    System.out.println("La lista generada es: ");
    lista.generaCadena(lista);

  }

}
