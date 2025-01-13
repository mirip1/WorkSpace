package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import jakarta.persistence.Query;
import model.Usuario;


public class UsuarioDaoImpl extends CommonDaoImpl<Usuario> implements UsuarioDaoInt {
	// Session de la base de datos
	private Session session;

	/**
	 * Constructor Empleado DAO
	 * 
	 * @param session Session de la base de datos
	 */
	public UsuarioDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	/**
	 * Devuelve los Usuarios que tienen ese nombre en la base de datos
	 *
	 * @param nombre Nombre del usuario
	 * @return Lista de Usuarios con ese nombre
	 */
	public List<Usuario> searchByNombre(final String nombre) {
	    // Verificación de sesión abierta
	    if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
	        session.getTransaction().begin();
	    }

	    // Consulta con parámetros y uso de TypedQuery
	    Query query = session.createQuery("FROM Usuario WHERE nombreUsuario = :nombre", Usuario.class);
	    query.setParameter("nombre", nombre);

	    return query.getResultList();
	}




	/**
	 * Devuelve el usuario que tenga el correo informado
	 */
	public Usuario searchByCorreo(final String correo) {
	    // Verificación de sesión abierta
	    if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
	        session.getTransaction().begin();
	    }

	    // Consulta con parámetro
	    return session.createQuery("FROM Usuario WHERE correoElectronico = :correo", Usuario.class)
	                  .setParameter("correo", correo)
	                  .uniqueResult();
	}



}
