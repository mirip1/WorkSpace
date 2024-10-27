package prog.ud06.actividad611.coleccion;

import prog.ud06.actividad611.coleccion.diccionario.Diccionario;

/**
 * Contenedor de los usuarios del sistema
 * La clase Usuarios se encarga de almacenar y recuperar los usuarios que forman el sistema
 */
public class Usuarios {
  
  Diccionario<Usuario> almacenamiento ;
  
  /**
   * Constructor. Inicializa el contenedor
   */
  public Usuarios() {
    almacenamiento = new Diccionario();
  }
  
  /**
   * Añade un nuevo usuario al contenedor.
   * Falla si ya hay un usuario con el mismo nombre de usuario
   * @param usuario Usuario a añadir. No puede ser null
   * @throws IllegalArgumentException Si el usuario es null
   * @throws UsuariosException Si ya existe un usuario en el contenedor con el mismo nombre de usuario que el que se está intentando añadir
   */
  public void addUsuario(Usuario usuario) {
  
    if (usuario != null && !almacenamiento.contieneNombre(usuario.getNombreUsuario())) {
      almacenamiento.add(usuario.getNombreUsuario(), usuario);
    } else if (almacenamiento.contieneNombre(usuario.getNombreUsuario())) {
      throw new UsuariosException();
    }
    else {
      throw new IllegalArgumentException();
    }
    
  }
  
  /**
   * Localiza un usuario por su nombre de usuario
   * @param nombreUsuario Nombre de usuario del usuario a localizar
   * @return usuario si se encontró. null si no se encontró
   */
  public Usuario getUsuarioPorNombreUsuario(String nombreUsuario) {
    
    return almacenamiento.getEntrada(nombreUsuario);
    
  } 
  
  
  
  

}
