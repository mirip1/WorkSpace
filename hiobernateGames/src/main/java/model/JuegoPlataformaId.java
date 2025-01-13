package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JuegoPlataformaId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id_juego")
    private int idJuego;

    @Column(name = "id_plataforma")
    private int idPlataforma;

    public JuegoPlataformaId() {
    }

    public JuegoPlataformaId(int idJuego, int idPlataforma) {
        this.idJuego = idJuego;
        this.idPlataforma = idPlataforma;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public int getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(int idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JuegoPlataformaId that = (JuegoPlataformaId) o;
        return idJuego == that.idJuego && idPlataforma == that.idPlataforma;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJuego, idPlataforma);
    }
}