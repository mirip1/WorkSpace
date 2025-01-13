package dao;

import java.util.List;

import model.Comentario;
import model.Usuario;


/**
 * Clase interfaz EmpleadoDaoInt
 */
public interface ComentarioDaoInt extends CommonDaoInt<Comentario> {

	/**
	 * Devuelve los usuarios que tienen ese nombre en la base de datos
	 * 
	 * @param name Nombre de los usuarios que queremos obtener de la base de datos
	 * @return Usuarios que contienen ese nombre
	 */
	public List<Comentario> searchByIdUsuario(final int usuario);


	public List<Comentario> searchByIdJuego(final int juego);

}
