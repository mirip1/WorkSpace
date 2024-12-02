package models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class RestEmpleadoId implements java.io.Serializable {

//	@ManyToOne
//	@JoinColumn(name="dni_empleado")
//	private Empleado empleado;
//	@ManyToOne
//	@JoinColumn(name="cod_rest")
//	private Restaurante restaurante;
	
	@Column(name="cod_rest", columnDefinition = "char")
	private String codRest;
	@Column(name="dni_empleado", columnDefinition = "char")
	private String dniEmpleado;

	public RestEmpleadoId() {
	}

	public RestEmpleadoId(String codRest, String dniEmpleado) {
		this.codRest = codRest;
		this.dniEmpleado = dniEmpleado;
	}

	public String getCodRest() {
		return this.codRest;
	}

	public void setCodRest(String codRest) {
		this.codRest = codRest;
	}

	public String getDniEmpleado() {
		return this.dniEmpleado;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RestEmpleadoId))
			return false;
		RestEmpleadoId castOther = (RestEmpleadoId) other;

		return ((this.getCodRest() == castOther.getCodRest()) || (this.getCodRest() != null
				&& castOther.getCodRest() != null && this.getCodRest().equals(castOther.getCodRest())))
				&& ((this.getDniEmpleado() == castOther.getDniEmpleado())
						|| (this.getDniEmpleado() != null && castOther.getDniEmpleado() != null
								&& this.getDniEmpleado().equals(castOther.getDniEmpleado())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCodRest() == null ? 0 : this.getCodRest().hashCode());
		result = 37 * result + (getDniEmpleado() == null ? 0 : this.getDniEmpleado().hashCode());
		
		return result;
	}

  @Override
  public String toString() {
    return "RestEmpleadoId [codRest=" + codRest + ", dniEmpleado=" + dniEmpleado + "]";
  }

}
