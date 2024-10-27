
public class Libro {
  private String titulo;
  private String autor;
  private String anoPubli;
  
  public Libro (String titulo, String autor, String anoPubli) {
    this.anoPubli = anoPubli;
    this.titulo = titulo;
    this.autor = autor;
    
    
  }

  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public String getAnoPubli() {
    return anoPubli;
  }
  
  
  
    
  
}
