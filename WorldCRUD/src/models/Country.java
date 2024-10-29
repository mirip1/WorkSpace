package models;

/**
 * clase que representa un Pais
 */
public class Country {

  private String code;
  private String name;
  private String continent;
  private String region;
  private double surface;
  private int population;
  private String localName;
  private String govermentForm;
  private String code2;

  /**
   * Constructor de pais
   * 
   * @param code
   * @param name
   * @param continent
   * @param region
   * @param surface
   * @param population
   * @param localName
   * @param govermentForm
   * @param code2
   */
  public Country(String code, String name, String continent, String region, double surface, int population,
      String localName, String govermentForm, String code2) {
    super();
    this.code = code;
    this.name = name;
    this.continent = continent;
    this.region = region;
    this.surface = surface;
    this.population = population;
    this.localName = localName;
    this.govermentForm = govermentForm;
    this.code2 = code2;
  }

  public Country() {
    super();
  }

  public Country(String name, String continent, String region, double surface, int population, String localName,
      String govermentForm, String code2) {
    super();
    this.name = name;
    this.continent = continent;
    this.region = region;
    this.surface = surface;
    this.population = population;
    this.localName = localName;
    this.govermentForm = govermentForm;
    this.code2 = code2;
  }

  /**
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the continent
   */
  public String getContinent() {
    return continent;
  }

  /**
   * @param continent the continent to set
   */
  public void setContinent(String continent) {
    this.continent = continent;
  }

  /**
   * @return the region
   */
  public String getRegion() {
    return region;
  }

  /**
   * @param region the region to set
   */
  public void setRegion(String region) {
    this.region = region;
  }

  /**
   * @return the surface
   */
  public double getSurface() {
    return surface;
  }

  /**
   * @param surface the surface to set
   */
  public void setSurface(double surface) {
    this.surface = surface;
  }

  /**
   * @return the population
   */
  public int getPopulation() {
    return population;
  }

  /**
   * @param population the population to set
   */
  public void setPopulation(int population) {
    this.population = population;
  }

  /**
   * @return the localName
   */
  public String getLocalName() {
    return localName;
  }

  /**
   * @param localName the localName to set
   */
  public void setLocalName(String localName) {
    this.localName = localName;
  }

  /**
   * @return the govermentForm
   */
  public String getGovermentForm() {
    return govermentForm;
  }

  /**
   * @param govermentForm the govermentForm to set
   */
  public void setGovermentForm(String govermentForm) {
    this.govermentForm = govermentForm;
  }

  /**
   * @return the code2
   */
  public String getCode2() {
    return code2;
  }

  /**
   * @param code2 the code2 to set
   */
  public void setCode2(String code2) {
    this.code2 = code2;
  }

  @Override
  public String toString() {
    return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", region=" + region + ", surface="
        + surface + ", population=" + population + ", localName=" + localName + ", govermentForm=" + govermentForm
        + ", code2=" + code2 + "]";
  }

}
