package dao;

import java.util.List;

import model.Etiqueta;

/**
 * Clase interfaz EmpleadoDaoInt
 */
public interface EtiquetaDaoInt extends CommonDaoInt<Etiqueta> {

	/**
	 * Devuelve los usuarios que tienen ese nombre en la base de datos
	 * 
	 * @param name Nombre de los usuarios que queremos obtener de la base de datos
	 * @return Usuarios que contienen ese nombre
	 */
	public List<Etiqueta> searchByNombre(final String nombre);
}
