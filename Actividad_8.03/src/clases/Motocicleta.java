package clases;

public class Motocicleta {

  // referencia de la moto
  private String referencia;

  // cilindrada en CC de la moto
  private int cilindrada;

  // tipo de moto
  private String tipo;

  // precio tasado de la moto
  private double precio;

  // Fabricante de la moto
  private String fabricante;

  /**
   * Constructor de motocicleta
   * 
   * @param referencia de la moto
   * @param cilindrada cilindrada en CC de la moto
   * @param tipo       tipo de moto
   * @param precio     precio tasado de la moto
   * @param fabricante Fabricante de la moto
   */
  public Motocicleta(String referencia, int cilindrada, String tipo, double precio, String fabricante) {

    
    if (validarMotocicleta(referencia, cilindrada, tipo, precio , fabricante)) {
      this.referencia = referencia;
      this.cilindrada = cilindrada;
      this.tipo = tipo;
      this.precio = precio;
      this.fabricante = fabricante;
    }else {
      throw new IllegalArgumentException();
    }
  }
  
  private boolean validarMotocicleta(String referencia, int cilindrada, String tipo, double precio, String fabricante){
    
    
    return cilindrada >= 0 && !fabricante.isBlank() && !fabricante.isEmpty() && !tipo.isBlank() && !tipo.isEmpty() && precio>=0;
    
    
  }

  /**
   * @return the referencia
   */
  public String getReferencia() {
    return referencia;
  }

  /**
   * @return the cilindrada
   */
  public int getCilindrada() {
    return cilindrada;
  }

  /**
   * @return the tipo
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * @return the precio
   */
  public double getPrecio() {
    return precio;
  }

  /**
   * @return the fabricante
   */
  public String getFabricante() {
    return fabricante;
  }

}
