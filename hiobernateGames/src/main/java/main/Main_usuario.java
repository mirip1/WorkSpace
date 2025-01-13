package main;

import org.hibernate.Session;

import dao.ComentarioDaoImpl;
import dao.EtiquetaDaoImpl;
import dao.GeneroDaoImpl;
import dao.UsuarioDaoImpl;
import dao.VideoJuegoDaoImpl;
import model.Usuario;

public class Main_usuario {
    public static void main(String[] args) {
        // Abro sesión
        Session session = HibernateUtil.getSession();

        try {
            // Crear instancia del DAO de Usuario
            UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl(session);
            EtiquetaDaoImpl etiquetaDao = new EtiquetaDaoImpl(session);
            ComentarioDaoImpl comentarioDao	= new ComentarioDaoImpl(session);
            GeneroDaoImpl generoDao = new GeneroDaoImpl(session);
            VideoJuegoDaoImpl videoJuegoDao = new VideoJuegoDaoImpl(session);
            
//            // Realizar búsqueda por nombre
//            String nombreBusqueda = "Juan";
//            List<VideoJuego> etiquetasEncontrados = videoJuegoDao.searchByTitulo("CSGO");
//
//            // Mostrar resultados
//            for (VideoJuego usuario : etiquetasEncontrados) {
//                	System.out.println("Etiqueta encontrado por el ID 1");
//                    System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.getTitulo());
//            }
//            String correo = "juan@gmail.com";
//            System.out.println(usuarioDao.searchByCorreo(correo).toString());
        
//            Usuario usu2 = new Usuario("antonia@gmail.com", "antonio", "1234");
//            usuarioDao.insert(usu);
            Usuario usu = usuarioDao.searchByCorreo("juana");
            System.out.println(usu);
            usuarioDao.delete(usu);
//            usuarioDao.update(usu);
//            usuarioDao.insert(usu2);

            
//            session.getTransaction().commit();
            		
        } catch (Exception e) {
            System.err.println("Error durante la ejecución: " + e.getMessage());
//            HibernateUtil.closeSession();
        } finally {
            // Cerrar sesión
            HibernateUtil.closeSession();
        }
    }
}
