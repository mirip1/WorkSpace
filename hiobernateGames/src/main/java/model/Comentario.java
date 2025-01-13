package model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "comentario")
public class Comentario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_juego", nullable = false)
    private VideoJuego juego;

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "puntuacion_personal",columnDefinition = "DECIMAL", nullable = false)
    private double puntuacionPersonal;

    public Comentario() {
    }

    public Comentario(int id, Usuario usuario, VideoJuego juego, String comentario, double puntuacionPersonal) {
        this.id = id;
        this.usuario = usuario;
        this.juego = juego;
        this.comentario = comentario;
        this.puntuacionPersonal = puntuacionPersonal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getPuntuacionPersonal() {
        return puntuacionPersonal;
    }

    public void setPuntuacionPersonal(double puntuacionPersonal) {
        this.puntuacionPersonal = puntuacionPersonal;
    }
}