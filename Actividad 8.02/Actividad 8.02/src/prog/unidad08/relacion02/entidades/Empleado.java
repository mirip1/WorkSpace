package prog.unidad08.relacion02.entidades;

public class Empleado {
  private int numeroDeEmpleado;
  private int numeroDeDepartamento;
  private String extel;
  private String fechaDeNacimiento;
  private String fechaDeInicio;
  private double salario;
  private double comision;
  private int numeroDeHijos;
  private String empleadoNombre;
  
  public Empleado (int numeroDeEmpleados, int numeroDeDepartamento, String extel,  String fechaDeNacimiento,  String fechaDeInicio, double salario, double comision, int numeroDeHijos, String empleadoNombre){
    this.numeroDeEmpleado = numeroDeEmpleados;
    this.numeroDeDepartamento = numeroDeDepartamento;
    this.extel = extel;
    this.fechaDeNacimiento = fechaDeNacimiento;
    this.fechaDeInicio = fechaDeInicio;
    this.salario = salario;
    this.comision = comision;
    this.numeroDeHijos = numeroDeHijos;
    this.empleadoNombre = empleadoNombre;
  }

  public int getNumeroDeEmpleado() {
    return numeroDeEmpleado;
  }

  public int getNumeroDeDepartamento() {
    return numeroDeDepartamento;
  }

  public String getExtel() {
    return extel;
  }

  public String getFechaDeNacimiento() {
    return fechaDeNacimiento;
  }

  public String getFechaDeInicio() {
    return fechaDeInicio;
  }

  public double getSalario() {
    return salario;
  }

  public double getComision() {
    return comision;
  }

  public int getNumeroDeHijos() {
    return numeroDeHijos;
  }

  public String getNombre() {
    return empleadoNombre;
  }

  
  
}
