package prog.unidad06.arraysmulti.ejercicio02;

public class TablaEnteraConTotales {
  
  private int[][] array;
//  private int filaCont;
//  private int columnaCont;
  
  public TablaEnteraConTotales(int filas,int columnas) {
    if (filas>0 && columnas>0) {
      this.array =new int[filas][columnas];
    }else {
      throw new IllegalArgumentException();
    }
    
  }
  public void setCasilla(int fila,int columna, int valor) {
    array[fila][columna]=valor;
    
  }

  
  public int getCasilla(int fila,int columna) {
    return array[fila][columna];
  }
  
  public int getTotalFila(int fila) {
    int suma = 0;
    for (int i = 0; i != array.length+1 ; i++) {
      suma += array[fila][i];
    }
    return suma;
  }
  
 public int getTotalColumna(int columna) {
   int suma = 0;
   for (int i = 0; i != array[columna].length+1 ; i++) {
     suma += array[i][columna];
   }
   return suma;
 }
 
 public int getTotalTabla() {
   int suma = 0;
   for (int i = 0 ; i < array.length; i++) {
     for (int j = 0; j < array[i].length; j++) {
       suma += array[i][j];
     }
   }
   return suma; 
 }

  
  
}
