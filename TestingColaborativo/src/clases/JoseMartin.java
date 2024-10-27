package clases;

public class JoseMartin {
  /**
   * Expresión regular para la comprobación de nombres.
   */
  private static final String NOMBRE_REGEX = "[A-ZÑÁÉÍÓÚ][a-zñáéíóú]*";

  /**
   * Expresión regular para la separación del nombre
   */
  private static final String SEPARADOR_REGEX = "[\\s-]+";
  
  /**
   * Cadena de caracteres con todas las letras minúsculas para recorrerlo
   */
  private static final String CARACTERES_MINUSCULA = "abcdefghijklmnñopqrstuvwxyz";
  
  /**
   * Número de caracteres para la clave a partir de la cual comienza de nuevo el bucle de letras
   */
  private static final int NUMERO_CARACTERES = 27;
  
  /**
   * Método estático que verifica si un nombre aportado es válido
   * @param nombre Nombre aportado al método. Debe tener una longitud de entre 2 y 50 caracteres
   * y podrá estar separado únicamente por espacios o guiones. 
   * Se admitirán únicamente letras españolas (alfabeto con ñ y acentos usados en el español) y cada 
   * parte del nombre deberá comenzar por mayúscula
   * @return true si el nombre es correcto, false en caso contrario
   */
  public static boolean compruebaNombre(String nombre) {
    
    // Se verifica la longitud
    if (nombre.length() >= 2 && nombre.length() <= 50) {
      
      // Se parte el nombre por espacios y guiones
      String[] partes = nombre.split(SEPARADOR_REGEX);
      
      // Se comprueba cada parte con la expresión regular.
      for (String parteNombre : partes) {
        if (!parteNombre.matches(NOMBRE_REGEX)) {
          return false;
        }
      }
    
    } else {
      return false;
    }
    
    // Si el programa llega hasta aquí, el nombre es correcto
    return true;
  }
  
  
  /**
   * Método que realiza un cifrado denominado César. Éste cifra el mensaje a partir de una clave 
   * (número entero) dada, haciendo que cada carácter se transforme en otro saltando dicho número de
   * veces dentro del abecedario (se usará por simplificación el alfabeto español sin acentos y en 
   * minúsculas, constando de los siguientes caracteres: abcdefghijklmnñopqrstuvwxyz. Las mayúsculas
   * y letras con acento se transformarán en ellas mismas.
   * Como ejemplo, el texto "hola" con una clave o salto de 2, se convertiría en "jqnc".
   * @param mensaje Mensaje a cifrar con clave César
   * @param clave Clave a usar para transformar el mensaje. Se puede ver como el número de saltos
   * en el abecedario que debe realizar cada carácter para su conversión. Debe ser menor a la cantidad
   * de caracteres usados (27). Si se usa una clave negativa, se recorrerá el abecedario en 
   * sentido contrario para el cifrado.
   * @return El mensaje ya cifrado
   * @throws IllegalArgumentException En caso de que la clave no sea válida
   */
  public String cifraCesar(String mensaje, int clave) {
      
    if (clave < -NUMERO_CARACTERES || clave > NUMERO_CARACTERES) {
      throw new IllegalArgumentException();
    }
  
    String cifrado = "";
    
    for (int i = 0; i < mensaje.length(); i++) {
      // Trato la letra como substring para poder usar funciones de String con ella más adelante. 
      // Otra opción es letra = "" + mensaje.charAt(i)
      String letra = mensaje.substring(i,i+1);
      
      // Para cifrar el mensaje, las mayúsculas, espacios y símbolos quedan como están y la minúscula varía según la clave 
      if (!CARACTERES_MINUSCULA.contains(letra)) {
        cifrado += letra;
      
      } else {
        // Buscamos el número que corresponde a la letra minúscula
        int numAsignado = CARACTERES_MINUSCULA.indexOf(letra);
        
        //Le sumamos el número clave, pero puede pasar que sea menor que cero. Contemplamos los casos 
        numAsignado = (numAsignado + clave < 0)? (numAsignado + clave + NUMERO_CARACTERES) % NUMERO_CARACTERES 
                                                 : (numAsignado + clave) % NUMERO_CARACTERES ;
        // Sacamos el caracter y lo añadimos al String final
        letra = CARACTERES_MINUSCULA.substring(numAsignado,numAsignado+1);
        cifrado += letra;        
      }      
    }   
    return cifrado;
  }

}
