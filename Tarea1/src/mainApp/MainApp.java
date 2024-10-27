package mainApp;

import java.util.ArrayList;
import java.util.List;

import models.Empleado;
import utils.UtilsFicheroArray;

public class MainApp {

  static final String URLTXT = "fichero.txt";
  static final String URLBIN = "fichero2.txt";

  public static void main(String[] args) {
    
    UtilsFicheroArray utils = new UtilsFicheroArray();
    

    // Crear una lista de empleados
    List<Empleado> empleados = new ArrayList<>();
    empleados.add(new Empleado("Ayuntamiento de Gijón/Xixón", 17, 1));
    empleados.add(new Empleado("Ayuntamiento de Gijón/Xixón", 19, 1));
    empleados.add(new Empleado("Ayuntamiento de Gijón/Xixón", 21, 2));
    empleados.add(new Empleado("Microsoft", 22, 2));

    //escribe la lista de empleados en un archivo de texto
    utils.toArchivoTexto(empleados, URLTXT);

    //lee empleados desde el archivo texto y los imprime
    System.out.println("Empleados leídos desde el archivo de texto: \n");
    utils.leer_Empleados(URLTXT);

    //escribe la lista de empleados en un archivo de binario
    utils.toArchivoBinarioInverso(empleados, URLBIN);

    //lee empleados desde el archivo binario y los imprime
    System.out.println("\nEmpleados leídos desde el archivo binario: \n");
    utils.leer_Empleados_b(URLBIN);

    
  }

}
