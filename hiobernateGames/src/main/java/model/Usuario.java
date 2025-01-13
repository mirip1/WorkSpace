package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @Column(name = "correo_electronico", nullable = false, length = 255)
    private String correoElectronico;

    @Column(name = "nombre_usuario", nullable = false, length = 100)
    private String nombreUsuario;

    @Column(name = "contraseña", nullable = false, length = 255)
    private String contrasenia;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsuarioGeneroFavorito> generosFavoritos = new HashSet<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comentario> comentarios = new HashSet<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BibliotecaVideojuego> biblioteca = new HashSet<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JuegoFavorito> juegosFavoritos = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String correoElectronico, String nombreUsuario, String contrasenia) {
      
      this.correoElectronico = correoElectronico;
      this.nombreUsuario = nombreUsuario;
      this.contrasenia = contrasenia;
    }
    

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Set<UsuarioGeneroFavorito> getGenerosFavoritos() {
        return generosFavoritos;
    }

    public void setGenerosFavoritos(Set<UsuarioGeneroFavorito> generosFavoritos) {
        this.generosFavoritos = generosFavoritos;
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

    public Set<JuegoFavorito> getJuegosFavoritos() {
        return juegosFavoritos;
    }

    public void setJuegosFavoritos(Set<JuegoFavorito> juegosFavoritos) {
        this.juegosFavoritos = juegosFavoritos;
    }

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", correoElectronico=" + correoElectronico + ", nombreUsuario=" + nombreUsuario
				+ ", contrasenia=" + contrasenia + "]";
	}
    
    
}