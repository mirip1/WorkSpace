package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import jakarta.persistence.Query;
import model.Comentario;
import model.Usuario;
import model.VideoJuego;

public class ComentarioDaoImpl extends CommonDaoImpl<Comentario> implements ComentarioDaoInt {
	// Session de la base de datos
	private Session session;

	/**
	 * Constructor Empleado DAO
	 * 
	 * @param session Session de la base de datos
	 */
	public ComentarioDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Comentario> searchByIdUsuario(int id) {
		// Verificación de sesión abierta
		if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}
		// Consulta con parámetros y uso de TypedQuery
		Usuario usuario = session.get(Usuario.class, id);
		// Obtener el objeto Usuario por su id
		Query query = session.createQuery("FROM Comentario WHERE usuario = :usuario", Comentario.class);
		query.setParameter("usuario", usuario);
		return query.getResultList();
	}

	@Override
	public List<Comentario> searchByIdJuego(int juego) {
		// Verificación de sesión abierta
		if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		} // Consulta con parámetros y uso de TypedQuery
		VideoJuego videojuego = session.get(VideoJuego.class, juego);
		// Obtener el objeto VideoJuego por su id
		Query query = session.createQuery("FROM Comentario WHERE juego = :juego", Comentario.class);
		query.setParameter("juego", videojuego);
		return query.getResultList();
	}

}
