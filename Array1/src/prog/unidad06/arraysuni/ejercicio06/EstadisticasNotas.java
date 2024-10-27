package prog.unidad06.arraysuni.ejercicio06;

public class EstadisticasNotas {
  private int[] calificaciones;
  private int contador = 0;
  
  public EstadisticasNotas() {
   calificaciones = new int[10];
  }
  public void addCalificacion(int calificacion) {
    if (calificacion >= 0 && calificacion <= 10) {
      calificaciones[contador] = calificacion;
      contador++;
    }else {
      throw new IllegalArgumentException();
    }
    
  }
  
  public double calificacionMedia() {
     if(contador>0) {
      double suma = 0;
      for (int i = 0; i != calificaciones.length; i++) {
        suma += calificaciones[i];
      }
      return suma/ contador;
     }else {
       return 0;
     }
     
     
  }
  
  public int calificacionModa() throws EstadisticasNotasException {
    if (contador>0) {
      int maximoNumRepeticiones= 0;
      int moda= calificaciones[0];
  
      for(int i=0; i<contador; i++)
      {
          int numRepeticiones= 0;
          for(int j=0; j<contador; j++)
          {
              if(calificaciones[i]==calificaciones[j])
              {
                  numRepeticiones++;
              }   
              if(numRepeticiones>maximoNumRepeticiones)
              {
                  moda= calificaciones[i];
                  maximoNumRepeticiones= numRepeticiones;
              }   
          }
      }   
      
      return moda;
    }else {
      throw new EstadisticasNotasException();

    }
  }
  

  
}
