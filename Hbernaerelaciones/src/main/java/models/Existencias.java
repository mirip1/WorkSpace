package models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="existencias")
public class Existencias implements java.io.Serializable {

	@Id
	@Column(name="cod_articulo", columnDefinition = "char")
	private String codArticulo;
	@ManyToOne
	@JoinColumn(name="cod_rest", columnDefinition = "char")
	private Restaurante restaurante;
	@Column
	private String nombre;
	@Column
	private int cantidad;
	@Column
	private BigDecimal precio;

	public Existencias() {
	}

	public Existencias(String codArticulo, String nombre, int cantidad, BigDecimal precio) {
		this.codArticulo = codArticulo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Existencias(String codArticulo, Restaurante restaurante, String nombre, int cantidad, BigDecimal precio) {
		this.codArticulo = codArticulo;
		this.restaurante = restaurante;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getCodArticulo() {
		return this.codArticulo;
	}

	public void setCodArticulo(String codArticulo) {
		this.codArticulo = codArticulo;
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

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

  @Override
  public String toString() {
    return "Existencias [codArticulo=" + codArticulo + ", restaurante=" + restaurante + ", nombre=" + nombre
        + ", cantidad=" + cantidad + ", precio=" + precio + "]";
  }

}
