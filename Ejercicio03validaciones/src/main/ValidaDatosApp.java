package main;

import java.util.List;


public class ValidaDatosApp {

  public static void main(String[] args) {
    if (args.length > 0) {
      ProcesadorArchivo procesador = new ProcesadorArchivo(args[0]);
        List<String> errores = procesador.procesarArchivo();
        // Si hubo errores
        if (!errores.isEmpty()) {
          System.out.println("Se encontraron los siguientes errores:");
          for (String error: errores) {
            System.out.println(error);
          }
        } else {
          System.out.println("No se encontraron errores");
        }
    } else {
      System.err.println("Error. Falta proporcionar a ruta al archivo de datos");
    }
  }

}
