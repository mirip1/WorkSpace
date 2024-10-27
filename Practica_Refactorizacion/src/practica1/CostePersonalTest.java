package practica1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CostePersonalTest {

  @Test
  public void testCalcularCoste_Director() {
    Trabajador[] trabajadores = {
        new Trabajador(TipoTrabajador.DIRECTOR.getNombre(), 5000, 0),
        new Trabajador(TipoTrabajador.SUBDIRECTOR.getNombre(), 4000, 0)
    };
    float costeEsperado = 9000; // 5000 + 4000
    assertEquals(costeEsperado, CostePersonal.costeDelPersonal(trabajadores));
  }
  
  @Test
  public void testCalcularCoste_EmpleadoConHorasExtras() {
    Trabajador[] trabajadores = {
        new Trabajador("empleado", 2000, 10),
        new Trabajador("empleado", 2500, 5)
    };
    float costeEsperado = 4800; // (2000 + (10 * 20)) + (2500 + (5 * 20))
    assertEquals(costeEsperado, CostePersonal.costeDelPersonal(trabajadores));
  }
  
  @Test
  public void testCalcularCoste_EmpleadoSinHorasExtras() {
    Trabajador[] trabajadores = {
        new Trabajador("empleado", 3000, 0),
        new Trabajador("empleado", 3500, 0)
    };
    float costeEsperado = 6500; // 3000 + 3500
    assertEquals(costeEsperado, CostePersonal.costeDelPersonal(trabajadores));
  }
  @Test
  public void testCalcularCosteRefact_Director() {
      Trabajador[] trabajadores = {
          new Trabajador(TipoTrabajador.DIRECTOR.getNombre(), 5000, 0),
          new Trabajador(TipoTrabajador.SUBDIRECTOR.getNombre(), 4000, 0)
      };
      float costeEsperado = 9000; // 5000 + 4000
      assertEquals(costeEsperado, CostePersonalRefactorizado.costeDelPersonal(trabajadores));
  }

  @Test
  public void testCalcularCosteRefact_EmpleadoConHorasExtras() {
      Trabajador[] trabajadores = {
          new Trabajador("empleado", 2000, 10),
          new Trabajador("empleado", 2500, 5)
      };
      float costeEsperado = 4800; // (2000 + (10 * 20)) + (2500 + (5 * 20))
      assertEquals(costeEsperado, CostePersonalRefactorizado.costeDelPersonal(trabajadores));
  }

  @Test
  public void testCalcularCosteRefact_EmpleadoSinHorasExtras() {
      Trabajador[] trabajadores = {
          new Trabajador("empleado", 3000, 0),
          new Trabajador("empleado", 3500, 0)
      };
      float costeEsperado = 6500; // 3000 + 3500
      assertEquals(costeEsperado, CostePersonalRefactorizado.costeDelPersonal(trabajadores));
  }
  
  
  
  
  
  
  
}
