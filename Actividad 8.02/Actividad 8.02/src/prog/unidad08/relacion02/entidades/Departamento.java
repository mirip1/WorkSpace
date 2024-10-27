package prog.unidad08.relacion02.entidades;

public class Departamento {
  private int codigoCentro;
  private Integer codigo;
  private String direccion;
  private int codigoDirector;
  private double presupuesto;
  private Integer codigoDepartamentoSuperior;
  private String nombre;
  
  
  public Departamento (Integer codigo, String nombre, int codigoCentro,  String direccion,int codigoDirector, double presupuesto, Integer departamentoSuperior) 
  {
   
    
    this.codigo = codigo;
    this.nombre = nombre;
    this.codigoCentro = codigoCentro;
    this.direccion = direccion;
    this.codigoDirector = codigoDirector;
    this.presupuesto = presupuesto;
    this.codigoDepartamentoSuperior = departamentoSuperior;
    
    
  }


  public Integer getCodigoDepartamentoSuperior() {
    return codigoDepartamentoSuperior;
  }


  public int getCodigo() {
    return codigoCentro;
  }


  public String getDireccion() {
    return direccion;
  }


  public int getCodigoDirector() {
    return codigoDirector;
  }


  public double getPresupuesto() {
    return presupuesto;
  }


  public Integer getCodigoCentro() {
    return codigo;
  }


  public String getNombre() {
    return nombre;
  }

}
