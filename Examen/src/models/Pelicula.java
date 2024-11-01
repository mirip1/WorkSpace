package models;

import java.io.Serializable;

public class Pelicula implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private int id;
  private String title;
  private String description;
  private int release_year;
  private int language_id;
  private double length;
  private String rating;
  
  /**
   * Constructor
   * @param id
   * @param title
   * @param description
   * @param release_year
   * @param language_id
   * @param length
   * @param rating
   */
  public Pelicula(int id, String title, String description, int release_year, int language_id, double length,
      String rating) {
    super();
    this.id = id;
    this.title = title;
    this.description = description;
    this.release_year = release_year;
    this.language_id = language_id;
    this.length = length;
    this.rating = rating;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the release_year
   */
  public int getRelease_year() {
    return release_year;
  }

  /**
   * @param release_year the release_year to set
   */
  public void setRelease_year(int release_year) {
    this.release_year = release_year;
  }

  /**
   * @return the language_id
   */
  public int getLanguage_id() {
    return language_id;
  }

  /**
   * @param language_id the language_id to set
   */
  public void setLanguage_id(int language_id) {
    this.language_id = language_id;
  }

  /**
   * @return the length
   */
  public double getLength() {
    return length;
  }

  /**
   * @param length the length to set
   */
  public void setLength(double length) {
    this.length = length;
  }

  /**
   * @return the rating
   */
  public String getRating() {
    return rating;
  }

  /**
   * @param rating the rating to set
   */
  public void setRating(String rating) {
    this.rating = rating;
  }
  
  
  
  
  

}
