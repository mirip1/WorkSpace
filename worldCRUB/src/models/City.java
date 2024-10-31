package models;

/**
 * Clase que representa una ciudad
 */
public class City {

  private int id;
  private String name;
  private String countryCode;
  private String district;
  private int population;

  public City() {
    super();
  }

  public City(String name, String countryCode, String district, int population) {
    super();
    this.name = name;
    this.countryCode = countryCode;
    this.district = district;
    this.population = population;
  }

  /**
   * Constructor de Ciudad
   * 
   * @param id          id de la ciudad
   * @param name        nombre de la ciudad
   * @param countryCode condigo de pais de la ciudad
   * @param district    numero de distrito
   * @param population  numero de poblacion
   */
  public City(int id, String name, String countryCode, String district, int population) {
    super();
    this.id = id;
    this.name = name;
    this.countryCode = countryCode;
    this.district = district;
    this.population = population;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the countryCode
   */
  public String getCountryCode() {
    return countryCode;
  }

  /**
   * @return the district
   */
  public String getDistrict() {
    return district;
  }

  /**
   * @return the population
   */
  public int getPopulation() {
    return population;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @param countryCode the countryCode to set
   */
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  /**
   * @param district the district to set
   */
  public void setDistrict(String district) {
    this.district = district;
  }

  /**
   * @param population the population to set
   */
  public void setPopulation(int population) {
    this.population = population;
  }

  @Override
  public String toString() {
    return "City [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", district=" + district
        + ", population=" + population + "]";
  }

}
