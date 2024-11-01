package utils;

import java.awt.TextArea;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import models.Usuario;
import models.Usuario;

/**
 * Clase creada para el manejo de multiples usuarios
 */
public class ManejoUsuario {

  private Map<String, Usuario> usuarios;

  public ManejoUsuario() {
    super();

    usuarios = new HashMap<>();
  }

  
  /**
   * metodo que devuelve un usuario
   * @param email
   * @return
   */
  public Usuario devuelveUsuario(String email) {
    return usuarios.get(email);
  }
  
  
  /**
   * Da de alta a un Usuario
   * 
   * @param Usuario
   */
  public void altaUsuario(Usuario Usuario) {

    if (usuarios.get(Usuario.getEmail()) == null) {

      usuarios.put(Usuario.getEmail(), Usuario);

    } else {
      throw new IllegalCallerException();
    }

  }

  /**
   * metodo que devuelve si existe el usuario
   * 
   * @param email
   * @return
   */
  public boolean existeUsuario(String email) {

    return !(usuarios.get(email) == null);

  }

  /**
   * metodo que comprueba si es la contraseña del usuario
   * 
   * @param email
   * @param cont
   * @return
   */
  public boolean coincideCont(String email, String cont) {

    return usuarios.get(email).getCont().equals(cont);
  }

  /**
   * Metodo para dar de baja a un Usuario
   * 
   * @param email
   */
  public void bajaUsuario(String email) {
    if (usuarios.get(email) != null) {

      usuarios.remove(email);

    } else {
      throw new IllegalCallerException();
    }

  }

  /**
   * método que muestra Usuario
   */
  public void mostrarUsuario() {

    List<Usuario> listausuarios = usuarios.values().stream().collect(Collectors.toList());
    listausuarios.forEach(System.out::println);

  }

  /**
   * método que muestra Usuario en un textArea
   */
  public void mostrarUsuarioTextArea(TextArea textArea) {

    List<Usuario> listausuarios = usuarios.values().stream().collect(Collectors.toList());
    for (Usuario Usuario : listausuarios) {
      textArea.append(Usuario.toString() + "\n");

    }

  }

  /**
   * método que pasa una lista de usuarios
   */
  public List<Usuario> pasarALista() {

    List<Usuario> listausuarios = usuarios.values().stream().collect(Collectors.toList());
    return listausuarios;

  }

}
