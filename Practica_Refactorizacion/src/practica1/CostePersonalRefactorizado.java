package practica1;

public class CostePersonalRefactorizado {
  
  /**
   * Metodo que calcula el coste personal
   * @param trabajadores 
   * @return coste total de todos los trabajadores introducidos en el array
   */
  public static float costeDelPersonal(Trabajador[] trabajadores) {
    float costeFinal = 0;
    
    /**
     * bucle que recorre el array e identifica los tipos de los trabajadores
     */
    for (Trabajador trabajador : trabajadores) {
      
      if (trabajador.trab() == TipoTrabajador.DIRECTOR.getNombre() || trabajador.trab() == TipoTrabajador.SUBDIRECTOR.getNombre()) {
        costeFinal += trabajador.getNom();
      } else {
        costeFinal += trabajador.getNom() + (trabajador.masTrab() * 20);
      }
    }
    
    return costeFinal;
  }

}
