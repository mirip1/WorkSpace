package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "etiqueta")
public class Etiqueta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etiqueta")
    private int id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "etiqueta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JuegoEtiqueta> juegos = new HashSet<>();

    public Etiqueta() {
    }

    public Etiqueta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<JuegoEtiqueta> getJuegos() {
        return juegos;
    }

    public void setJuegos(Set<JuegoEtiqueta> juegos) {
        this.juegos = juegos;
    }
}