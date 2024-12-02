package models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="rest_empleado")
public class RestEmpleado implements java.io.Serializable {

	@EmbeddedId
	private RestEmpleadoId id;
	@ManyToOne
	@JoinColumn(name="dni_empleado", columnDefinition = "char", nullable = false, insertable = false, updatable = false)
	private Empleado empleado;
	
	@Column
	private String funcion;
	
	@ManyToOne
	@JoinColumn(name="cod_rest" , columnDefinition = "char", nullable = false, insertable = false, updatable = false)
	private Restaurante restaurante;

	public RestEmpleado() {
	}

	public RestEmpleado(RestEmpleadoId id, Empleado empleado, Restaurante restaurante) {
		this.id = id;
		this.empleado = empleado;
		this.restaurante = restaurante;
	}

	public RestEmpleado(RestEmpleadoId id, Empleado empleado, String funcion, Restaurante restaurante) {
		this.id = id;
		this.empleado = empleado;
		this.funcion = funcion;
		this.restaurante = restaurante;
	}

	public RestEmpleadoId getId() {
		return this.id;
	}

	public void setId(RestEmpleadoId id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public Restaurante getRestaurante() {
		return this.restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

  @Override
  public String toString() {
    return "RestEmpleado [id=" + id + ", empleado=" + empleado + ", funcion=" + funcion + ", restaurante=" + restaurante
        + "]";
  }

}
