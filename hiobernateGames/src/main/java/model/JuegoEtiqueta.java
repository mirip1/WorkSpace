package model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "juego_etiqueta")
public class JuegoEtiqueta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_juego", nullable = false)
    private VideoJuego juego;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_etiqueta", nullable = false)
    private Etiqueta etiqueta;

    public JuegoEtiqueta() {
    }

    public JuegoEtiqueta(VideoJuego juego, Etiqueta etiqueta) {
        this.juego = juego;
        this.etiqueta = etiqueta;
    }

    public VideoJuego getJuego() {
        return juego;
    }

    public void setJuego(VideoJuego juego) {
        this.juego = juego;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }
}