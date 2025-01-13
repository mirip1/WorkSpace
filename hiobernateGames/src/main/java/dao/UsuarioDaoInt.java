package dao;

import java.util.List;

import model.Usuario;


/**
 * Clase interfaz EmpleadoDaoInt
 */
public interface UsuarioDaoInt extends CommonDaoInt<Usuario> {

	/**
	 * Devuelve los usuarios que tienen ese nombre en la base de datos
	 * 
	 * @param name Nombre de los usuarios que queremos obtener de la base de datos
	 * @return Usuarios que contienen ese nombre
	 */
	public List<Usuario> searchByNombre(final String nombre);


	public Usuario searchByCorreo(final String correo);

}
