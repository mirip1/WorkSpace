package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "videojuego")
public class VideoJuego implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private int id;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;

    @Column(name = "puntuacion_metacritic")
    private double puntuacionMetacritic;

    @Column(name = "imagen_principal", length = 255)
    private String imagenPrincipal;

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comentario> comentarios = new HashSet<>();

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BibliotecaVideojuego> biblioteca = new HashSet<>();

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JuegoEtiqueta> etiquetas = new HashSet<>();

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JuegoFavorito> usuariosFavoritos = new HashSet<>();

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JuegoGenero> generos = new HashSet<>();

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JuegoPlataforma> plataformas = new HashSet<>();

    public VideoJuego() {
    }

    public VideoJuego(int id, String titulo, String descripcion, Date fechaLanzamiento, double puntuacionMetacritic, String imagenPrincipal) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.puntuacionMetacritic = puntuacionMetacritic;
        this.imagenPrincipal = imagenPrincipal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public double getPuntuacionMetacritic() {
        return puntuacionMetacritic;
    }

    public void setPuntuacionMetacritic(double puntuacionMetacritic) {
        this.puntuacionMetacritic = puntuacionMetacritic;
    }

    public String getImagenPrincipal() {
        return imagenPrincipal;
    }

    public void setImagenPrincipal(String imagenPrincipal) {
        this.imagenPrincipal = imagenPrincipal;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Set<BibliotecaVideojuego> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Set<BibliotecaVideojuego> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Set<JuegoEtiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Set<JuegoEtiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Set<JuegoFavorito> getUsuariosFavoritos() {
        return usuariosFavoritos;
    }

    public void setUsuariosFavoritos(Set<JuegoFavorito> usuariosFavoritos) {
        this.usuariosFavoritos = usuariosFavoritos;
    }

    public Set<JuegoGenero> getGeneros() {
        return generos;
    }

    public void setGeneros(Set<JuegoGenero> generos) {
        this.generos = generos;
    }

    public Set<JuegoPlataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(Set<JuegoPlataforma> plataformas) {
        this.plataformas = plataformas;
    }
}