package dao;

import java.util.List;

import model.Genero;

/**
 * Clase interfaz EmpleadoDaoInt
 */
public interface GeneroDaoInt extends CommonDaoInt<Genero> {

	/**
	 * Devuelve los usuarios que tienen ese nombre en la base de datos
	 * 
	 * @param name Nombre de los usuarios que queremos obtener de la base de datos
	 * @return Usuarios que contienen ese nombre
	 */
	public List<Genero> searchByNombre(final String nombre);
}
