package prog.unidad07.ejercicio01;

/**
 * Clase que representa a cualquier figura
 */
public abstract class Figura {

  /**
   * Obtiene el área de la figura
   * @return Área de la figura
   */
  public abstract double getArea();
  
  /**
   * Obtiene el perímetro de la figura
   * @return Perímetro de la figura
   */
  public abstract double getPerimetro();
  
  /**
   * Determina si la figura es regular o no. Una figura es regular si todos sus lados son iguales
   * @return true si la figura es regular. false en caso contrario
   */
  public abstract boolean isRegular();
}
