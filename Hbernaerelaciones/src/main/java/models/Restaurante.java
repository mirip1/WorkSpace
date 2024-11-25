package models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "restaurante")
public class Restaurante implements Serializable{

    @Id
    @Column(name = "cod_rest", nullable = false)
    private String codRest;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "licencia_fiscal", nullable = false)
    private String licenciaFiscal;

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "fecha_apertura")
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;

    @Column(name = "horario", nullable = false)
    private String horario;

    @ManyToOne
    @JoinColumn(name = "cod_localidad")
    private Localidad localidad;

    
    public Restaurante() {}

  public Restaurante(String codRest, String nombre, String licenciaFiscal, String domicilio, java.sql.Date fechaApertura, String horario, Localidad localidad) {
      this.codRest = codRest;
      this.nombre = nombre;
      this.licenciaFiscal = licenciaFiscal;
      this.domicilio = domicilio;
      this.fechaApertura = fechaApertura;
      this.horario = horario;
      this.localidad = localidad;
  }

  public String getCodRest() {
      return codRest;
  }

  public void setCodRest(String codRest) {
      this.codRest = codRest;
  }

  public String getNombre() {
      return nombre;
  }

  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  public String getLicenciaFiscal() {
      return licenciaFiscal;
  }

  public void setLicenciaFiscal(String licenciaFiscal) {
      this.licenciaFiscal = licenciaFiscal;
  }

  public String getDomicilio() {
      return domicilio;
  }

  public void setDomicilio(String domicilio) {
      this.domicilio = domicilio;
  }

  public java.sql.Date getFechaApertura() {
      return fechaApertura;
  }

  public void setFechaApertura(java.sql.Date fechaApertura) {
      this.fechaApertura = fechaApertura;
  }

  public String getHorario() {
      return horario;
  }

  public void setHorario(String horario) {
      this.horario = horario;
  }

  public Localidad getCodLocalidad() {
      return localidad;
  }

  public void setCodLocalidad(Localidad localidad) {
      this.localidad = localidad;
  }
}
