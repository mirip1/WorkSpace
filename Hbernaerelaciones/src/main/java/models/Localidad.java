 package models;



import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "localidad")
public class Localidad {

    @Id
    @Column(name = "cod_localidad", nullable = false)
    private int codLocalidad;

    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "localidad")
    @JoinColumn(name = "restaurante")
    Set<Restaurante> restaurante;

    // Constructor vacío y con parámetros, Getters y Setters
    public Localidad() {}

    public Localidad(int codLocalidad, String nombre) {
        this.codLocalidad = codLocalidad;
        this.nombre = nombre;
    }

    public int getCodLocalidad() {
        return codLocalidad;
    }

    public void setCodLocalidad(int codLocalidad) {
        this.codLocalidad = codLocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
