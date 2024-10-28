package psp.unidad01.actividad07.apartado2;

import java.io.PrintWriter;

/** Proceso sumador */
public class SumadorProcess {

  /**
   * Método principal. Suma de forma acumulativa los dos números obtenidos mediante argumentos
   * 
   * @param args Argumentos. Se presupone que la llegada de parámetros es correcta
   */
  public static void main(String[] args) {

    int lowerNum = Integer.parseInt(args[0]);
    int upperNum = Integer.parseInt(args[1]);

    int result = 0;

    for (int i = lowerNum; i <= upperNum; i++) {
      result += i;
    }

    PrintWriter pw = new PrintWriter(System.out);
    pw.print(result + "\n");
    pw.flush();

    pw.close();
  }

}
