package clases;

public class Tomas {
  private String nombre;
  private String apellidos;
  private int edad;
  private char sexo;
  private boolean discapacidad;
  
  public Tomas(String nombre, String apellidos, int edad, char sexo, boolean discapacidad) {
    if(comprobarNombre(nombre) && comprobarApellidos(apellidos) && comprobarEdad(edad) && comprobarSexo(sexo)) {
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.edad = edad;
      this.sexo = sexo;
      this.discapacidad = discapacidad;
    } else {
      throw new IllegalArgumentException();
    }
  }
  
  private boolean comprobarApellidos(String apellidos) {
    if (apellidos == null || apellidos.isEmpty()) {
      return false;
    }        
    return true;
  }
  
  private boolean comprobarNombre(String nombre) {
    if (nombre == null || nombre.isEmpty()) {
      return false;
    }   
    return true;
  }
  
  private boolean comprobarEdad(int edad) {
    return edad > 0;
  }
  
  private boolean comprobarSexo(char sexo) {
    return sexo == 'h' || sexo == 'm';
  }
}
