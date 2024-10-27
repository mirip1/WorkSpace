package practica1;

public class Trabajador {
  private String tipo;
  private float nom;
  private float horasExtras;
  
  

  public Trabajador(String tipo, float nom, float horasExtras) {

    this.tipo = tipo;
    this.nom = nom;
    this.horasExtras = horasExtras;
  }

  public String trab() {
    
    
    return tipo;
  }
  
  public float getNom() {
    return nom;
  }
  
  public float masTrab() {
    return horasExtras;
  }

}
