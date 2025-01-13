package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import jakarta.persistence.Query;
import model.Etiqueta;

public class EtiquetaDaoImpl extends CommonDaoImpl<Etiqueta> implements EtiquetaDaoInt {
	// Session de la base de datos
	private Session session;

	/**
	 * Constructor Empleado DAO
	 * 
	 * @param session Session de la base de datos
	 */
	public EtiquetaDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	/**
	 * Devuelve los Usuarios que tienen ese nombre en la base de datos
	 *
	 * @param nombre Nombre del usuario
	 * @return Lista de Usuarios con ese nombre
	 */
	public List<Etiqueta> searchByNombre(final String nombre) {
	    // Verificación de sesión abierta
	    if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
	        session.getTransaction().begin();
	    }

	    // Consulta con parámetros y uso de TypedQuery
	    Query query = session.createQuery("FROM Etiqueta WHERE nombre = :nombre", Etiqueta.class);
	    query.setParameter("nombre", nombre);

	    return query.getResultList();
	}
}
