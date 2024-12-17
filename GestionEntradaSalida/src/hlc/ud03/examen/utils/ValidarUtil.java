package hlc.ud03.examen.utils;

import java.util.HashMap;
import java.util.Map;

import hlc.ud03.examen.datos.BloqueDatosEnFichero;

/**
 * Clase que maneja la logica de las validaciones del fichero
 */
public class ValidarUtil {

  /**
   * Objeto BloqueEnFIchero para capturar los datos
   */
  private BloqueDatosEnFichero datos;

  /**
   * Mapa con relacion "nombre de campo" como key y el patron como value
   */
  private static final Map<String, String> CAMPOS_PATRONES = new HashMap<>() {
    {
      put("referencia", "\\d{13}");
      put("nombre", "[A-ZÑ][\\w+\\s]{0,199}");
      put("precio", "[^0]\\d+(\\.\\d{1,2})");
      put("marca", "[A-ZÑ][\\p{L}+]{0,99}");
      put("puntuacion", "[0-5](\\.\\d)?");
      put("fecha_inicio_venta", "(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}");
      put("dominio", "([A-Za-z][A-Za-z-\\d]{1,61}[A-Za-z]\\.)+[A-Za-z\\d]{2,6}");
      put("url", "(https)|(http)?://[A-Za-z\\-]+(.[A-Za-z\\-]+)*(/([A-Za-z_\\-]*)|(\\.\\.?))+");
      put("correo_pedidos", "([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)");
      put("puntos_fuertes", ".+");
      put("puntos_debiles", ".+");
    }
  };

  /**
   * Constructor vacio
   */
  public ValidarUtil() {

  }

  /**
   * Comprueba si el contenido del archivo es válido
   * 
   */
  public void validarArchivoEntero(String rutaArchivo) {
    datos = new BloqueDatosEnFichero(rutaArchivo);
    int errores = 0;
    for (String key : CAMPOS_PATRONES.keySet()) {

      errores += checkCampo(key, CAMPOS_PATRONES.get(key)) ? 0 : 1;

    }

    if (errores == 0) {
      System.out.println("No se encontraron errores");
    } else {
      System.err.println("Se encontraron " + errores + " errores");
    }

  }

  /**
   * Metodo que comprueba un campo
   * 
   * @param key     nombre del campo a comprobar
   * @param pattern patron que se le pasa para validarlo
   * @return true si es correcto
   */
  private boolean checkCampo(String key, String pattern) {

    boolean esOpcional = key.equals("marca") || key.equals("fecha_inicio_venta") || key.equals("puntos_fuertes")
        || key.equals("puntos_debiles");

    if (!datos.contieneDato(key) && !esOpcional) {
      System.err.println("ERROR en el campo " + key + " obligatorio no encontrado");
      return false;
    }
    String dato = datos.getDato(key);

    if (!dato.matches(pattern)) {

      System.err.println("ERROR en el campo " + key + " no tiene el formato correcto”");
      return false;
    }
    // Si el campo es referencia comprueba que los primeros dos digitos sean un
    // numero entre el 34 y el 67
    if (key.equals("referencia")) {
      int numeroValido = Integer.parseInt(dato.substring(0, 2));
      if (!(numeroValido >= 34 && numeroValido <= 67)) {
        System.err.println("ERROR en el campo " + key + " valor: " + dato + ", " + numeroValido);
        return false;

      }

    }

    if (key.equals("puntos_fuertes") || key.equals("puntos_debiles")) {
      String[] palabras = dato.split(",");
      if (palabras.length > 5) {
        System.err.println("ERROR en el campo " + key + " no tiene el formato correcto");
        return false;
      }
      for (String palabra : palabras) {

        if (!compruebaPalabra(palabra)) {
          System.err.println("ERROR en el campo " + key + " no tiene el formato correcto");
          return false;

        }

      }

    }

    return true;

  }

  /**
   * Metodo que comprueba si un String es uno de las cadenas validas para puntos
   * debiles of fuerte
   * 
   * @param palabra
   * @return true si, si coincide con alguna de las palabras válidas
   */
  private boolean compruebaPalabra(String palabra) {

    return palabra.equals("Precio") || palabra.equals("Tecnologia") || palabra.equals("Durabilidad")
        || palabra.equals("Disponibilidad") || palabra.equals("Marca") || palabra.equals("Sostenible")
        || palabra.equals("Calidad") || palabra.equals("Tamaño");

  }

}
