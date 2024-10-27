package practica1;

public class CostePersonal {

  static float costeDelPersonal(Trabajador trabajadores[]) {
    float costeFinal = 0;
    Trabajador trabajador;
    for(int i = 0; i<trabajadores.length;i++) {
      trabajador = trabajadores[i];
        
      if (trabajador.trab() == TipoTrabajador.DIRECTOR.getNombre() || trabajador.trab() ==  TipoTrabajador.SUBDIRECTOR.getNombre()) {
        costeFinal += trabajador.getNom();
         
      }
      else {
        costeFinal += trabajador.getNom() + (trabajador.masTrab() * 20);
      }
      
      
    }
    return costeFinal;
  }
  
}
