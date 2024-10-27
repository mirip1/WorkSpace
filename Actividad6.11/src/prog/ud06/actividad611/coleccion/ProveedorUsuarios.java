package prog.ud06.actividad611.coleccion;

/**
 * Interface que implementan las clases que proveen (obtienen) la información de los usuarios desde una fuente externa (archivo, base de datos, etc.)
 */
public interface ProveedorUsuarios {

  /**
   * Añade un nuevo usuario al contenedor.
   * Falla si ya hay un usuario con el mismo nombre de usuario
   * @return usuario si se encontró. null si no se encontró
   * @throws ProveedorUsuariosException
   */
  Usuarios obtieneUsuarios() throws ProveedorUsuariosException ;
  
}
