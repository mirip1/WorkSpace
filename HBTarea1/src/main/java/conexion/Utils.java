package conexion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;

import models.Superusuario;

public class Utils {
  private static SessionFactory sessionFactory;
  private static Session session;

  public static String crearUser(String nombre, String apellidos) {

    String X = nombre.substring(1, 2);
    String Y = apellidos.substring(0, 1);

    return "2DAM" +Y + X; 

  }
  public static Session getSession() {
    if (sessionFactory == null) {
      session = getSessionFactory().openSession();
    }
        
    return session;
  }


  /**
   * M�todo que cierra el objeto Session de HibernateUtil
   */
  public static void closeSession() {
    Session session = ThreadLocalSessionContext.unbind(sessionFactory);
    if (session != null) {
      session.close();
    }
    closeSessionFactory();
  }
  
  private static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
//      StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
//      sessionFactory = new MetadataSources(sr).buildMetadata().buildSessionFactory();
      
      
          sessionFactory = new Configuration()
                  .configure("hibernate.cfg.xml") // Cargar la configuraci�n desde el archivo
                  .buildSessionFactory();
      
      
    }
    return sessionFactory;
  }

  private static void closeSessionFactory() {
    if ((sessionFactory != null) && (sessionFactory.isClosed() == false)) {
      sessionFactory.close();
    }
  }
  
  
//Leer fichero y pasarlo a un ArrayList.
  public static ArrayList<Superusuario> leerFicheros(String archivo) throws IOException {
      ArrayList<Superusuario> listado = new ArrayList<Superusuario>();

      try {
        // Leo el archivo.
          BufferedReader lector = new BufferedReader(new FileReader(archivo));

          // Leo las l�neas del fichero y los a�ado al arrayList.
          String linea = lector.readLine();
          
          while (linea != null) {
              String partes[] = linea.split(",");
              listado.add(new Superusuario(partes[1],partes[0]));
              
              
              linea = lector.readLine();
          }
          
          lector.close();
      }catch (Exception e) {
          System.out.println("El fichero no existe");
      }   
      return listado;
  }
  
  
  
}





