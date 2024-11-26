package models;

import java.sql.Date;
import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Empleado implements java.io.Serializable {

  @Id
  @Column(name="dni_empleado")
  private String dniEmpleado;
  @Column
  private String nombre;
  @Column
  private String domicilio;
  @Column(name="fecha_nacimiento")
  private Date fechaNacimiento;
  
  @OneToMany(mappedBy="empleado",cascade= CascadeType.ALL)
  private Set<RestEmpleado> restEmpleados = new HashSet<RestEmpleado>(0);

  public Empleado() {
  }

  public Empleado(String dniEmpleado, String nombre, Date fechaNacimiento) {
    this.dniEmpleado = dniEmpleado;
    this.nombre = nombre;
    this.fechaNacimiento = fechaNacimiento;
  }

  public Empleado(String dniEmpleado, String nombre, String domicilio, Date fechaNacimiento, Set<RestEmpleado> restEmpleados) {
    this.dniEmpleado = dniEmpleado;
    this.nombre = nombre;
    this.domicilio = domicilio;
    this.fechaNacimiento = fechaNacimiento;
    this.restEmpleados = restEmpleados;
  }

  public String getDni_empleado() {
    return this.dniEmpleado;
  }

  public void setDni_empleado(String dniEmpleado) {
    this.dniEmpleado = dniEmpleado;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDomicilio() {
    return this.domicilio;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  public Date getFechaNacimiento() {
    return this.fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public Set getRestEmpleados() {
    return this.restEmpleados;
  }

  public void setRestEmpleados(Set <RestEmpleado>restEmpleados) {
    this.restEmpleados = restEmpleados;
  }

}
