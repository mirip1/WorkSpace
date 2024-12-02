package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import models.Empleado;
import models.Localidad;
import utils.HibernateUtil;

public class ConsultasApp {

  public static void main(String[] args) {

    Session sesion = HibernateUtil.getSession();
    sesion.getTransaction().begin();

    Query<Localidad> queryLocalidad = sesion.createQuery("From localidad", Localidad.class);
    List<Localidad> lista = queryLocalidad.list();

    lista.forEach(System.out::println);

    System.out.println("----------------------------");

    Query<Empleado> empleadosQuery = sesion.createQuery("FROM empleado", Empleado.class);
    List<Empleado> empleados = empleadosQuery.list();
    empleados.forEach(System.out::println);

    System.out.println("----------------------------");

    Query<Localidad> localidadesQuery = sesion.createQuery("FROM localidad WHERE nombre = 'Málaga'", Localidad.class);
    List<Localidad> localidades = localidadesQuery.list();
    localidades.forEach(System.out::println);

    System.out.println("----------------------------");

    Query<String> titularRestauranteQuery = sesion
        .createQuery("Select t.nombre from titular t join t.restaurante r where r.nombre = :nombre", String.class);
    titularRestauranteQuery.setParameter("nombre", "Málaga querida 2");
    List<String> empleadosRestaurantes = titularRestauranteQuery.getResultList();
    for (String string : empleadosRestaurantes) {
      System.out.println(string);
    }

    System.out.println("----------------------------");

    Query<Object[]> existenciasPorRestauranteQuery = sesion
        .createQuery("SELECT r.nombre, COUNT(ex.codArticulo) FROM restaurante r "
            + "JOIN existencias ex ON r.codRest = ex.restaurante " + "GROUP BY r.codRest", Object[].class);
    List<Object[]> existenciasPorRestaurante = existenciasPorRestauranteQuery.list();
    existenciasPorRestaurante.forEach(row -> System.out.println("Restaurante: " + row[0] + ", Artículos: " + row[1]));

    sesion.getTransaction().commit();

    HibernateUtil.closeSession();
  }

}
