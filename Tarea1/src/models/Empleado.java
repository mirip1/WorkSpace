package models;

import java.io.Serializable;

public class Empleado implements Serializable{
  
  //Interfaz que permite que los objetos puedan ser serializados
  private static final long serialVersionUID = 1L;
  
  //Empresa del empleado
  private String empresa;
  
  //edad del empleado
  private int edad;
  
  //numero de empleados a ccargo
  private int numeroEmpleados;
  
  /**
   * Constructor de Empleado
   * @param empresa Empresa a la que pertenece el Empleado
   * @param edad Edad del empleado
   * @param numeroEmpleados numero de Empleado
   */
  public Empleado(String empresa, int edad, int numeroEmpleados) {
    super();
    this.empresa = empresa;
    this.edad = edad;
    this.numeroEmpleados = numeroEmpleados;
  }
  
  /**
   * Constructor de empleado
   */
  public Empleado() {
    
  }

  /**
   * @return the empresa
   */
  public String getEmpresa() {
    return empresa;
  }

  /**
   * @param empresa the empresa to set
   */
  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }

  /**
   * @return the edad
   */
  public int getEdad() {
    return edad;
  }

  /**
   * @param edad the edad to set
   */
  public void setEdad(int edad) {
    this.edad = edad;
  }

  /**
   * @return the numeroEmpleados
   */
  public int getNumeroEmpleados() {
    return numeroEmpleados;
  }

  /**
   * @param numeroEmpleados the numeroEmpleados to set
   */
  public void setNumeroEmpleados(int numeroEmpleados) {
    this.numeroEmpleados = numeroEmpleados;
  }

  @Override
  public String toString() {
    return "Empresa: " + empresa + "\nEdad: " + edad + "\nNumero de Empleados: " + numeroEmpleados ;
  }
  
  
  
  

}
