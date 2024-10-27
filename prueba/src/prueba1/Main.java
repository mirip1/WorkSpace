package prueba1;

import java.util.Collections;

public class Main {

  public static void main(String[] args) {
    Clientes lista = new Clientes();
    
    lista.addCliente(new Cliente("Miguel", "Velasco", 18, 2050.50));
    lista.addCliente(new Cliente("Antonio", "Perez", 23, 1000.50));
    lista.addCliente(new Cliente("Paco", "Ruiz", 35, 3000));
    lista.addCliente(new Cliente("Lucia", "Fernandez", 20, 2450.50));
    
    System.out.println("Buscamosa a Paco");
    System.out.println(lista.buscarNombre("Paco").toString());
    System.out.println("\nAhora imprimimos todos los clientes");
    lista.imprimirClientes();
    
    System.out.println("\nAhora lo ordenamos por edad");
    lista.ordenarEdad();
    lista.imprimirClientes();
    
    System.out.println("\nAhora lo ordenamos por salario");
    lista.ordenarSalario();
    lista.imprimirClientes();

  }

}
