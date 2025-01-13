package dao;

import org.hibernate.Session;

import org.hibernate.resource.transaction.spi.TransactionStatus;

import jakarta.persistence.Query;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Clase con el DAO generico, CommonDaoImpl
 * 
 */
public abstract class CommonDaoImpl<T> implements CommonDaoInt<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesion de conexion a BD */
	private Session session;

	/**
	 * Constructor de la clase
	 * 
	 * @param session Session de la base de datos
	 */
	@SuppressWarnings("unchecked")
	protected CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	/**
	 * Metodo insert, que inserta un objeto en la base de datos
	 */
	public void insert(final T paramT) {
	  if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
	    session.getTransaction().begin();
	  }
	  
	  session.merge(paramT);
	  session.flush();
	  session.getTransaction().commit();
	}
//	/**
//	 * Metodo insert, que inserta un objeto en la base de datos
//	 */
//	public void insertAll(final T paramT) {
//		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
//			session.getTransaction().begin();
//		}
//		
//		session.merge(paramT);
//		session.flush();
//		session.getTransaction().commit();
//	}


	
	public void update(final T paramT) {
    try {
        // Check if the transaction is active
        if (!session.getTransaction().isActive()) {
            session.beginTransaction();
        }

        // Merge the entity
        session.merge(paramT);

        // Commit the transaction
        session.getTransaction().commit();
    } catch (Exception e) {
        // Rollback the transaction on error
        if (session.getTransaction().isActive()) {
            session.getTransaction().rollback();
        }
        throw e; // Rethrow exception to notify the caller
    }
}
	/**
	 * Metodo que elimina un objeto de la base de datos
	 */
	public void delete(final T paramT) {
		if (!session.getTransaction().isActive()) {
      session.beginTransaction();
		}

		session.remove(paramT);
		session.getTransaction().commit();
	}

	/**
	 * Metodo que lista todos los objetos de la base de datos
	 */
	@SuppressWarnings("unchecked")
	public List<T> searchAll() {
		// if (!session.getTransaction().isActive()) {
		if (!session.getTransaction().isActive()) {
      session.beginTransaction();
		}

		// Devuelve todos los objetos
		return session.createQuery("FROM " + this.entityClass.getName(), entityClass).getResultList();
	}

	/**
	 * Método que lista el objeto con ese id
	 */
	@SuppressWarnings("unchecked")
	public T searchById(int id) {
		if (!session.getTransaction().isActive()) {
      session.beginTransaction();
		} // Crear la consulta y establecer el parámetro id
		Query query = session.createQuery("FROM " + this.entityClass.getName() + " WHERE id = :id", entityClass);
		query.setParameter("id", id);
		return (T) query.getSingleResult();
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
