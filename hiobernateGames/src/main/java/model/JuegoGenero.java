package model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "juego_genero")
public class JuegoGenero implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private JuegoGeneroId id;

    @ManyToOne
    @MapsId("idJuego")
    @JoinColumn(name = "id_juego", nullable = false)
    private VideoJuego juego;

    @ManyToOne
    @MapsId("idGenero")
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    public JuegoGenero() {
    }

    public JuegoGenero(VideoJuego juego, Genero genero) {
        this.juego = juego;
        this.genero = genero;
        this.id = new JuegoGeneroId(juego.getId(), genero.getId());
    }

    public JuegoGeneroId getId() {
        return id;
    }

    public void setId(JuegoGeneroId id) {
        this.id = id;
    }

    public VideoJuego getJuego() {
        return juego;
    }

    public void setJuego(VideoJuego juego) {
        this.juego = juego;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}