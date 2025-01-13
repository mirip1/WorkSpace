package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "juego_favorito")
public class JuegoFavorito implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private JuegoFavoritoId id;

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @MapsId("idJuego")
    @JoinColumn(name = "id_juego", nullable = false)
    private VideoJuego juego;

    @Column(name = "fecha_agregado", nullable = false)
    private Date fechaAgregado;

    public JuegoFavorito() {
    }

    public JuegoFavorito(Usuario usuario, VideoJuego juego, Date fechaAgregado) {
        this.usuario = usuario;
        this.juego = juego;
        this.fechaAgregado = fechaAgregado;
        this.id = new JuegoFavoritoId(usuario.getId(), juego.getId());
    }

    // Getters and Setters
    public JuegoFavoritoId getId() {
        return id;
    }

    public void setId(JuegoFavoritoId id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public VideoJuego getJuego() {
        return juego;
    }

    public void setJuego(VideoJuego juego) {
        this.juego = juego;
    }

    public Date getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(Date fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }
}