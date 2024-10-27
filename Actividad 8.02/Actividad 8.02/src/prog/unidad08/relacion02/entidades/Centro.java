package prog.unidad08.relacion02.entidades;

public class Centro {
  private int codigo;
  private String nombre;

  public Centro(int codigo, String nombre) {
    if (nombre.equals(null)) {
      throw new NullPointerException();
    }
    if (nombre.isBlank()) {
      throw new IllegalArgumentException();
    }
    this.codigo = codigo;
    this.nombre = nombre;
  }

  public int getCodigo() {
    return codigo;
  }

  public String getNombre() {
    return nombre;
  }

}
