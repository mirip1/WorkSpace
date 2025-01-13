package model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_genero_favorito")
public class UsuarioGeneroFavorito implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    public UsuarioGeneroFavorito() {
    }

    public UsuarioGeneroFavorito(Usuario usuario, Genero genero) {
        this.usuario = usuario;
        this.genero = genero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}