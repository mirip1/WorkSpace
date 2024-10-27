package prog.ud06.actividad611.coleccion;

/**
 * Tarjeta de clave de un usuario Una tarjeta de claves contiene una tabla con
 * claves numéricas enteras
 */
public class TarjetaClaves {
  // Numero de filas de la tarjeta
  private int filas;

  // Numero de columnas de la tarjeta
  private int columnas;

  // tarjeta
  private int[][] tarjeta;

  /**
   * Crea una tarjeta de claves con las filas y columnas indicadas Inicialmente
   * las claves son todas 000
   * 
   * @param filas    Número de filas de la tarjeta. Debe ser mayor que cero
   * @param columnas Número de columnas de la tarjeta. Debe ser mayor que cero
   * @throws IllegalArgumentException Si filas o columnas o ambos no son mayores
   *                                  que cero
   */
  public TarjetaClaves(int filas, int columnas) {
    if (filas > 0 && columnas > 0) {
      this.filas = filas;
      this.columnas = columnas;
      this.tarjeta = new int[filas+1][columnas+1];
    } else {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Obtiene el número de filas que tiene la tabla de claves de la tarjeta
   * 
   * @return Número de filas de la tabla de claves
   */
  public int getFilas() {
    return filas;
  }

  /**
   * Obtiene el numero de columnas que tiene la tabla de claves de la tarjeta
   * 
   * @return Número de columnas de la tabla de claves
   */
  public int getColumnas() {
    return columnas;
  }

  /**
   * Modifica el valor de una clave
   * 
   * @param fila    Fila donde está la clave. Debe valer entre 1 y el total de
   *                filas de la tarjeta
   * @param columna Columna donde está la clave. Debe valer entre 1 y el total de
   *                columnas de la tarjeta
   * @param clave   Nuevo valor de la clave. Debe estar comprendido entre 0 y 999,
   *                ambos incluidos
   * @throws IllegalArgumentException Si fila, columna o clave son incorrectos
   */
  public void setClave(int fila, int columna, int clave) {
    if (fila > 0 && fila < tarjeta.length && columna > 0 && columna < tarjeta[fila].length && clave >= 0
        && clave <= 999) {
      tarjeta[fila][columna] = clave;
      
    } else {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Valida que la clave es correcta
   * 
   * @param Número  de fila de la clave. Debe valer desde 1 hasta el número de
   *                filas de la tarjeta
   * @param columna Número de columna de la clave. Debe valer desde 1 hasta el
   *                número de columnas de la tarjeta
   * @param clave   Valor de clave a validar
   * @return true si la clave es válida. false si no lo es
   */
  public boolean validarClave(int fila, int columna, int clave) {

    return tarjeta[fila][columna] == clave;
  }

}
