package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="titular")
public class Titular implements java.io.Serializable {

	@Id
	@Column(name="dni_titular", columnDefinition = "char")
	private String dniTitular;
	@ManyToOne
	@JoinColumn(name="cod_rest")
	private Restaurante restaurante;
	@Column
	private String nombre;
	@Column
	private String domicilio;

	public Titular() {
	}

	public Titular(String dniTitular, String nombre) {
		this.dniTitular = dniTitular;
		this.nombre = nombre;
	}

	public Titular(String dniTitular, Restaurante restaurante, String nombre, String domicilio) {
		this.dniTitular = dniTitular;
		this.restaurante = restaurante;
		this.nombre = nombre;
		this.domicilio = domicilio;
	}

	public String getDniTitular() {
		return this.dniTitular;
	}

	public void setDniTitular(String dniTitular) {
		this.dniTitular = dniTitular;
	}

	public Restaurante getRestaurante() {
		return this.restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
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

  @Override
  public String toString() {
    return "Titular [dniTitular=" + dniTitular + ", restaurante=" + restaurante + ", nombre=" + nombre + ", domicilio="
        + domicilio + "]";
  }

}
