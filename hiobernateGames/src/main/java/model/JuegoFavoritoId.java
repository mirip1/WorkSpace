package model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JuegoFavoritoId implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idUsuario;
    private int idJuego;

    public JuegoFavoritoId() {
    }

    public JuegoFavoritoId(int idUsuario, int idJuego) {
        this.idUsuario = idUsuario;
        this.idJuego = idJuego;
    }

    // Getters and Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JuegoFavoritoId that = (JuegoFavoritoId) o;
        return idUsuario == that.idUsuario && idJuego == that.idJuego;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idJuego);
    }
}
