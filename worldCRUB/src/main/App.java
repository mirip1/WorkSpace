package main;

import java.util.List;

import dao.CityDAO;
import dao.CityDaoImp;
import models.City;

public class App {

  public static void main(String[] args) {

    CityDAO dao = CityDaoImp.getInstance();
    City city = new City("algeciras", "ESP", "Malaga", 7000);

    try {
      //Probamos la insercion
      int result = dao.add(city);
      System.out.println("Numero de registros actualizados" + result);
      
      //Probamos las consulta
      List<City> cities = dao.getAll();
//      cities.forEach(System.out::println);
      
      
      System.out.println(dao.getById(1));
      
      //Borramos la ciudad
      dao.delete(12);
      
      //la modificamos
      dao.update(city);
      
      
      
    } catch (Exception e) {
      // TODO: handle exception
    }

  }

}
