package clases;
import opAux.ClaseAuxiliar;

public class clasesAProbar {

  public boolean esMultiplo(int n1, int n2) {
    if (n1 % n2 == 0)
      return true;
    else
      return false;
  }

  public long binarioADecimal(String input) {
    long decimal = 0;

    long binario = Long.parseLong(input);

    int bits = ClaseAuxiliar.digitos(binario);

    for (int i = 0; i < bits; i++) {
      decimal += ClaseAuxiliar.digitoN(binario, bits - i - 1) * ClaseAuxiliar.potencia(2, i);
    }

    return decimal;
  }

  public int[] rotar(int[] array) {
    try {

      int aux = array[3];
      for (int i = 3; i > 0; i--) {
        array[i] = array[i - 1];
      }
      array[0] = aux;

      return array;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

}
