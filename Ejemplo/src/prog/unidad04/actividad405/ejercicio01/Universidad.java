package prog.unidad04.actividad405.ejercicio01;

import prog.unidad04.actividad405.comun.Persona;
import prog.unidad04.actividad405.comun.Alumno;
import prog.unidad04.actividad405.comun.Profesor;
import prog.unidad04.actividad405.comun.Becario;

/**
 * Clase de utilidades para la universidad
 */
public class Universidad {

  /**
   * Imprime la información de una persona
   * @param persona Persona cuya información se quiere imprimir
   */
  public static void imprimir(Persona persona) {
    
    // Nombre y DNI se pueden imprimir siempre
    System.out.println("Nombre: " + persona.getNombre());
    System.out.println("DNI: " + persona.getDNI());
    // Es un alumno?
    if (persona instanceof Alumno) {
      // Convertimos la persona en alumno
      Alumno alumno = (Alumno)persona;
      // E imprimimos sus datos
      System.out.println("Matricula: " + alumno.getMatricula());
      // Si el alumno es becario
      if (alumno instanceof Becario) {
        // Obtenemos una referencia a Becario
        Becario becario = (Becario)alumno;
        // Imprimimos la cuenta corriente
        System.out.println("Cuenta Corriente: " + becario.getCuentaCorriente());
      }
    } else {
      // Es Profesor?
      if (persona instanceof Profesor) {
        // Obtenemos referencia a profesor
        Profesor profesor = (Profesor)persona;
        // Y accedemos a la titulacion
        System.out.println("Titulacion: " + profesor.getTitulacion());
      }
    }
  }
  
  public static void matricular(Object objeto, String matricula) {
    // Si es una instancia de alumno
    if (objeto instanceof Alumno) {
      // Obtenemos referencia a alumno
      Alumno alumno = (Alumno)objeto;
      // Y lo matricula
      alumno.matricula(matricula);
      System.out.println("Matriculado");
    } else {
      System.out.println("No se puede matricular");
    }
  }
}
