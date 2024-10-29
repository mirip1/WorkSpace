package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.City;

public class CityDaoImp implements CityDAO {

  private static final String URL = "jdbc:mysql://localhost:3306/world";
  private static final String USER = "root";
  private static final String PASSWORD = "yolo";

  private static CityDaoImp instance;

  static {
    instance = new CityDaoImp();
  }

  private CityDaoImp() {
  };

  public static CityDaoImp getInstance() {
    return instance;
  }

  @Override
  public int add(City city) throws SQLException {
    String sql = """
                 insert into city ( Name, CountryCode, District, Population)
                 VALUES ( ?, ?, ?, ?);
        """;
    int result;

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setString(1, city.getName());
      ps.setString(2, city.getCountryCode());
      ps.setString(3, city.getDistrict());
      ps.setInt(4, city.getPopulation());

      result = ps.executeUpdate();

    }

    return result;
  }

  @Override
  public City getById(int id) throws SQLException {

//    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//        PreparedStatement ps = conn.prepareStatement(sql)) {
//      
//      
//      
//      
//    }
//    

    return null;
  }

  @Override
  public List<City> getAll() throws SQLException {

    String sql = "Select * from city;";
    List<City> result = new ArrayList<City>();
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {

      City city;

      while (rs.next()) {
        city = new City(rs.getInt("ID"), rs.getString("Name"), rs.getString("CountryCode"), rs.getString("District"),
            rs.getInt("Population"));
        result.add(city);
        
      }
    }

    return result;
  }

  @Override
  public int update(City city) throws SQLException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void delete(int id) throws SQLException {
    // TODO Auto-generated method stub

  }

}