package mainApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import models.Alumno;
import utils.HibernateUtil;



public class MainApp {

	public static void main(String[] args) {
      Session session = HibernateUtil.getSession();
		
    
    	
    	// Inicio transacci�n
    	session.getTransaction().begin();
    	
    	// Creaci�n de objetos simples
    	Alumno alumno1 = new Alumno();
    	alumno1.setNombre("Nacho");
    	alumno1.setApellido("Lorenzo");
    	alumno1.setEdad(44);
    	    	
    	Alumno alumno2 = new Alumno("Pepe", "Perez", 44);
    	
    	
    	
    	// Guardar objetos en BBDD (insert)
    	// me lo traigo porque luego voy a hacer update de alumno1
    	alumno1 = session.merge(alumno1);
    	alumno2 = session.merge(alumno2);
    	
    	// Guardar objetos en BBDD (update)
    	alumno1.setEdad(33);
    	session.merge(alumno1);
    	
    	
    	
    	
    	String hql = "FROM Alumno";
    	Query<Alumno> query = session.createQuery(hql, Alumno.class);
    	
    	List<Alumno> alumnos = query.getResultList();
    	
    	alumnos.forEach(System.out::println);
    	
    	
    	// Commit transacci�n
    	session.getTransaction().commit();
    	
    	// Cierro Session y SessionFactory
    	HibernateUtil.closeSession();
	
	}

}
