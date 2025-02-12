package psp.unidad1.relacion06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Esclavo {
  public static void main(String[] args) {
    
    BufferedReader entradaMaestro = new BufferedReader(new InputStreamReader(System.in));
    Random random = new Random();

    String texto;
    try {
      while ((texto = entradaMaestro.readLine()) != null) {
          int operacion = random.nextInt(3);
          String resultado;
          switch (operacion) {
              case 0:
                  resultado = texto.toUpperCase();
                  break;
              case 1:
                  resultado = texto.toLowerCase();
                  break;
              case 2:
                  resultado = capitalizar(texto);
                  break;
              default:
                  resultado = texto;
          }
          System.out.println(resultado);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    
    
    
    
  }
  private static String capitalizar(String valor) {
    if (valor == null || valor.isEmpty()) {
      return valor;
  } else {       
      return  valor.toUpperCase().charAt(0) + valor.substring(1, valor.length()).toLowerCase();
  }
}

}
