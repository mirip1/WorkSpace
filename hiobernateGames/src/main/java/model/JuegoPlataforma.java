package model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "juego_plataforma")
public class JuegoPlataforma implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private JuegoPlataformaId id;

    @ManyToOne
    @MapsId("idJuego")
    @JoinColumn(name = "id_juego", nullable = false)
    private VideoJuego juego;

    @ManyToOne
    @MapsId("idPlataforma")
    @JoinColumn(name = "id_plataforma", nullable = false)
    private Plataforma plataforma;

    public JuegoPlataforma() {
    }

    public JuegoPlataforma(VideoJuego juego, Plataforma plataforma) {
        this.juego = juego;
        this.plataforma = plataforma;
        this.id = new JuegoPlataformaId(juego.getId(), plataforma.getId());
    }

    public JuegoPlataformaId getId() {
        return id;
    }

    public void setId(JuegoPlataformaId id) {
        this.id = id;
    }

    public VideoJuego getJuego() {
        return juego;
    }

    public void setJuego(VideoJuego juego) {
        this.juego = juego;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }
}