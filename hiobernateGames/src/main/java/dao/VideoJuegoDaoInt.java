package dao;

import java.util.List;


import model.VideoJuego;

/**
 * Clase interfaz EmpleadoDaoInt
 */
public interface VideoJuegoDaoInt extends CommonDaoInt<VideoJuego> {

	/**
	 * Devuelve los usuarios que tienen ese nombre en la base de datos
	 * 
	 * @param name Nombre de los usuarios que queremos obtener de la base de datos
	 * @return Usuarios que contienen ese nombre
	 */
	public List<VideoJuego> searchByTitulo(final String nombre);
}
