package prog.unidad04.practica406.principal;
import java.util.Calendar;
import java.util.Scanner;

import prog.unidad04.practica406.libreria.ConvertibleATexto;
import prog.unidad04.practica406.libreria.Automovil;
import prog.unidad04.practica406.libreria.Vehiculo;
import prog.unidad04.practica406.libreria.Fecha;
import prog.unidad04.practica406.libreria.FechaException;
import prog.unidad04.practica406.libreria.Motocicleta;


public class VehiculosApp {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    //     double pesetas = Double.parseDouble(scan.nextLine());
    

    System.out.println("PRÁCTICA DE Miguel Velasco. GESTIÓN DE VEHÍCULOS");
    
    //Intentamos crear el Automovil
    Automovil automovil = null;
    Fecha fechaMatriculacionAutomovil = null;
    boolean datosCorrectos = false;
    boolean fechaCorrecta = false;

    while (!datosCorrectos) {

      try {
  
        //Introducimos la matrícula
        System.out.println("Introduce la matrícula del automóvil (4 números, 0 ó más espacios y tres letras mayúsculas):");
        String matriculaAutomovil = scan.nextLine();
        
        //Introducimos la Fecha 
        //Dias
        System.out.println("Introduzca el día de la fecha de matriculación del automóvil: ");
        int diaAutomovil = Integer.parseInt(scan.nextLine());
        //Mes
        System.out.println("Introduzca el mes de la fecha de matriculación del automóvil: ");
        int mesAutomovil = Integer.parseInt(scan.nextLine());
        //año
        System.out.println("Introduzca el año de la fecha de matriculación del automóvil: ");
        int anyoAutomovil = Integer.parseInt(scan.nextLine());
        
        //Introducimos el color
        System.out.println("Introduzca el color del automóvil (blanco, negro o azul): ");
        String colorAutomovil= scan.nextLine();
        
        //Introducimos el Num. Plazas
        System.out.println("Introduzca el número de plazas del vehículo (1 ó mas): ");
        int PlazaAutomovil = Integer.parseInt(scan.nextLine());
        
        //
        fechaMatriculacionAutomovil = new Fecha(diaAutomovil, mesAutomovil, anyoAutomovil);
        fechaCorrecta = fechaMatriculacionAutomovil.comprobarFecha(diaAutomovil, mesAutomovil, anyoAutomovil);
        automovil = new Automovil(matriculaAutomovil, fechaMatriculacionAutomovil, colorAutomovil , PlazaAutomovil );
        
        datosCorrectos = true;

        
      }  catch (IllegalArgumentException e) {
          if (fechaCorrecta) {
            System.out.println("No se pudo crear el automóvil. Revise los datos para comprobar que todos son correctos.");
  
          }else {
            System.out.println("La fecha no es una fecha válida. Revise los valores e inténtelo de nuevo: ");

        }
      }
    }
    
    //Creamos el Motocicleta
    
    Motocicleta motocicleta = null;
    datosCorrectos = false;
    fechaCorrecta = false;
    Fecha fechaMatriculacionMotocicleta = null;
    
    while (!datosCorrectos) {
      try {
        //Introducimos la matrícula
        System.out.println("Introduce la matrícula de la motocicleta (4 números, 0 ó más espacios y tres letras mayúsculas):");
        String matriculaMotocicleta = scan.nextLine();
        
        //Introducimos la Fecha 
        //Dias
        System.out.println("Introduzca el día de la fecha de matriculación del Motocicleta: ");
        int diaMotocicleta = Integer.parseInt(scan.nextLine());
        //Mes
        System.out.println("Introduzca el mes de la fecha de matriculación del Motocicleta: ");
        int mesMotocicleta = Integer.parseInt(scan.nextLine());
        //año
        System.out.println("Introduzca el año de la fecha de matriculación del Motocicleta: ");
        int anyoMotocicleta = Integer.parseInt(scan.nextLine());
        
        //Introducimos la cilindrada
        System.out.println("Introduzca la cilindrada de la motocicleta (50 ó mas): ");
        int cilindradaMotocicleta = Integer.parseInt(scan.nextLine());
        
        fechaMatriculacionMotocicleta = new Fecha(diaMotocicleta, mesMotocicleta, anyoMotocicleta);
        fechaCorrecta = fechaMatriculacionMotocicleta.comprobarFecha(diaMotocicleta, mesMotocicleta, anyoMotocicleta);
        motocicleta = new Motocicleta(matriculaMotocicleta, fechaMatriculacionMotocicleta, cilindradaMotocicleta );
        
        datosCorrectos = true;
        
      } catch (IllegalArgumentException e) {
        if(fechaCorrecta) {
          System.out.println("No se pudo crear la motocicleta. Revise los datos para comprobar que todos son correctos.");
        }else {
          System.out.println("La fecha no es una fecha válida. Revise los valores e inténtelo de nuevo: ");
        }
      }
    }
    
    
    
    //Fecha actual
    Calendar calendario = Calendar.getInstance();
 // Obtener el día, mes y año actuales del calendario
    int diaActual = calendario.get(Calendar.DATE);
    int mesActual = calendario.get(Calendar.MONTH)+1;
    int anyoActual = calendario.get(Calendar.YEAR);

    // Crear la instancia de Fecha con los valores obtenidos
    Fecha fechaActual = new Fecha(diaActual, mesActual, anyoActual);
    
    
    //Imprimos los datos por pantalla
    //Datos del Automovil
    System.out.println("Datos de Automóvil: " + automovil.aTexto() );
    
    //Datos de la motocicleta
    System.out.println("Datos de Motocicleta: " + motocicleta.aTexto() );
   
    //Datos del Automovil
    System.out.println("El automóvil lleva matriculado " + fechaMatriculacionAutomovil.diasEntre(fechaActual) + " dias");
  
    //Datos de la motocicleta
    System.out.println("La motocicleta lleva matriculada " + fechaMatriculacionMotocicleta.diasEntre(fechaActual) + " dias");
    
    //Cual se matriculo antes
    if (fechaMatriculacionAutomovil.compara(fechaMatriculacionMotocicleta)<0) {
      System.out.println("El automóvil se matriculó antes que la motocicleta ");
    }else if (fechaMatriculacionAutomovil.compara(fechaMatriculacionMotocicleta)>0) {
      System.out.println("La motocicleta se matriculó antes que el automóvil ");
    }else {
      System.out.println("Fueron matriculados el mismo dia ");
      
    }
    
    //Numero de vehículos matriculados
    System.out.println("Número de vehículos matriculados: " + Vehiculo.getVehiculosMatriculados());
    
    
    
    
    
  }

}
