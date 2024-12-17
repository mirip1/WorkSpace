package hlc.ud03.examen.main;

import java.util.ArrayList;
import java.util.List;

import hlc.ud03.examen.datos.BloqueDatosException;
import hlc.ud03.examen.utils.ValidarUtil;

/**
 * Esta clase es el main
 */
public class ValidacionesApp {

  public static void main(String[] args) {
    if(args.length != 1) {
      System.err.println("Se le debe pasar 1 parametro con la ruta del archivo a analizar");
      return;
    }
    
    String rutaCorrecta = args[0];
  
    
    ValidarUtil validar = new ValidarUtil();
    
    try {
      validar.validarArchivoEntero(rutaCorrecta);
      
    } catch (BloqueDatosException e) {
      System.err.println("Pasa una ruta correcta");
      
    }



    

  }
  
  
  

}
