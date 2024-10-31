package dao;

import java.sql.SQLException;

import java.util.List;

import models.Country;

public interface CountryDAO {
  
  String add(Country country) throws SQLException;
  
  Country getByCod(String cod) throws SQLException;
  
  List<Country> getAll() throws SQLException;
  
  int update(Country country) throws SQLException;
  
  void delete(String cod) throws SQLException;
  

}
