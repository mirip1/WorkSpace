package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JuegoGeneroId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id_juego")
    private int idJuego;

    @Column(name = "id_genero")
    private int idGenero;

    public JuegoGeneroId() {
    }

    public JuegoGeneroId(int idJuego, int idGenero) {
        this.idJuego = idJuego;
        this.idGenero = idGenero;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JuegoGeneroId that = (JuegoGeneroId) o;
        return idJuego == that.idJuego && idGenero == that.idGenero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJuego, idGenero);
    }
}