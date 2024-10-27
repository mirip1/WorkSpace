package prog.ud06.actividad611.coleccion.diccionario;

import java.util.HashMap;
import java.util.Map;

/**
 * * Clase que implementa un diccionario Un diccionario guarda cosas de un tipo
 * determinado (Tipo Genérico V) con un nombre (String)
 * 
 * @param <V> Tipo de los elementos a guardar
 */
public class Diccionario<V> {

  // crea un mapa llamado diccionario
  private Map<String, V> diccionario;

  /**
   * Crea un diccionario vacío
   */
  public Diccionario() {

    diccionario = new HashMap<>();
  }

  /**
   * Comprueba si existe una entrada en el diccionario con el nombre dado
   * 
   * @param nombre Nombre de la entrada a comprobar
   * @return true si existe en el diccionario una entrada con el nombre
   *         proporcionado. false si no existe
   */
  public boolean contieneNombre(String nombre) {

    if (diccionario.get(nombre) == null) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Añade una nueva entrada al diccionario
   * 
   * @param nombre Nombre de la entrada a añadir. No puede ser null ni coincidir
   *               con el nombre de una entrada ya existente en el diccionario
   * @param valor  Valor a almacenar en la entrada. No puede ser null
   * @throws DiccionarioException
   * @throws IllegalArgumentException
   */
  public void add(String nombre, V valor) throws DiccionarioException {

    if (contieneNombre(nombre)) {
      throw new DiccionarioException();
    } else if (!noNull(nombre, valor)) {
      throw new IllegalArgumentException();
    } else {
      diccionario.put(nombre, valor);
    }

  }

  /**
   * Obtiene el valor almacenado en una entrada del diccionario a partir de su
   * nombre
   * 
   * @param nombre Nombre de la entrada a recuperar.
   * @return Valor almacenado en la entrada con el nombre proporcionado. Si no
   *         existe una entrada con dicho nombre devuelve null
   */
  public V getEntrada(String nombre) {

    return diccionario.get(nombre);

  }

  /**
   * comprueba que ni el nombre ni el valor son null
   * 
   * @return True si no son nulos y false si lo son
   */
  private boolean noNull(String nombre, V valor) {

    return (nombre != null && valor != null);
  }

}
