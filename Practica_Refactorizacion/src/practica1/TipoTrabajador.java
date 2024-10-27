package practica1;

public enum TipoTrabajador {
  SUBDIRECTOR("Subdirector"),
  DIRECTOR("Director");

  private String nombre;

  TipoTrabajador(String nombre) {
      this.nombre = nombre;
  }

  public String getNombre() {
      return nombre;
  }

}
