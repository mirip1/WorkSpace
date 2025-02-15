package prueba1;

public class Cliente implements Comparable<Cliente>{
  private String nombre;
  private String apellidos;
  private int edad;
  private double salario;

  public Cliente() {
  }

  public Cliente(String nombre, String apellidos, int edad, double salario) {
    
    if (validarTodo(edad, nombre, salario)) {
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.edad = edad;
      this.salario = salario;
    }else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @return the apellidos
   */
  public String getApellidos() {
    return apellidos;
  }

  /**
   * @return the edad
   */
  public int getEdad() {
    return edad;
  }

  /**
   * @return the salario
   */
  public double getSalario() {
    return salario;
  }

  @Override
  public String toString() {
    return "Nombre: " + nombre + ", Apellidos: " + apellidos + ", Edad: " + edad + ", Salario: " + salario;
  }
  
  private boolean nombreValido(String nombre) {
    return Character.isUpperCase(nombre.charAt(0)); 
    
  }
  
  private boolean validarEdad(int edad) {
    return edad>=18;
  }
  
  private boolean validarSalario(double salario) {
    return salario>=0;
  }
  
  private boolean validarTodo(int edad, String nombre, double salario) {
    return validarEdad(edad) && nombreValido(nombre) && validarSalario(salario);
  }

  @Override
  public int compareTo(Cliente o) {
    if (edad>o.getEdad()) {
      return 1;
    }else if (edad<o.getEdad()) {
      return -1;
    }else {
      return 0;
      
    }
    
  }
  
}
