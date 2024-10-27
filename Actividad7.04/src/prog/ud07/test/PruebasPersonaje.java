package prog.ud07.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import prog.ud07.juego.Arquero;
import prog.ud07.juego.Guerrero;
import prog.ud07.juego.Sacerdote;
import prog.ud07.juego.Sanador;

class PruebasPersonaje {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @Test
  void pruebaUno() {
    Guerrero guerrero = new Guerrero("Jose", 100, true, 1);

    guerrero.ganaVida(10);

    // Esta vivo
    assertEquals(true, guerrero.isEstaVivo());

    // Con armadura
    assertEquals(true, guerrero.isTieneArmadura());

    // Tiene vida actual
    assertEquals(100, guerrero.getVidaActual());

    // ataque
    assertEquals(50, guerrero.ataca());

    // Curacion
    assertEquals(0, guerrero.cura());

  }

  @Test
  void pruebaDos() {
    Guerrero guerrero = new Guerrero("Jose", 100, false, 1);

    guerrero.pierdeVida(50);
    ;

    // vivo
    assertEquals(true, guerrero.isEstaVivo());

    // armadura
    assertEquals(false, guerrero.isTieneArmadura());

    // Tiene vida actual
    assertEquals(50, guerrero.getVidaActual());

    // ataque
    assertEquals(25, guerrero.ataca());

    // Curacion
    assertEquals(0, guerrero.cura());

  }

  @Test
  void pruebaTres() {
    Guerrero guerrero = new Guerrero("Jose", 100, true, 1);

    // Pierde 200
    guerrero.pierdeVida(200);

    // Esta muerto
    assertEquals(false, guerrero.isEstaVivo());

    // armadura
    assertEquals(false, guerrero.isTieneArmadura());

    // Tiene vida actual
    assertEquals(0, guerrero.getVidaActual());

    // ataque
    assertEquals(0, guerrero.ataca());

    // Curacion
    assertEquals(0, guerrero.cura());

  }

  @Test
  void pruebaCuatro() {
    Guerrero guerrero = new Guerrero("Jose", 100, false, 2);

    // Pierde 50
    guerrero.pierdeVida(50);

    guerrero.ganaVida(10);

    // Vivo
    assertEquals(true, guerrero.isEstaVivo());

    // armadura
    assertEquals(false, guerrero.isTieneArmadura());

    // Tiene vida actual
    assertEquals(70, guerrero.getVidaActual());

    // ataque
    assertEquals(70, guerrero.ataca());

    // Curacion
    assertEquals(0, guerrero.cura());

  }

  @Test
  void pruebaCinco() {
    Arquero arquero = new Arquero("Jose", 100, 2, false);

    // Pierde 50
    arquero.pierdeVida(50);

    arquero.ganaVida(60);

    // Vivo
    assertEquals(true, arquero.isEstaVivo());

    // armadura
    assertEquals(false, arquero.isTieneArmadura());

    // Tiene vida actual
    assertEquals(100, arquero.getVidaActual());

    // ataque
    assertEquals(33, arquero.ataca());

    // Curacion
    assertEquals(0, arquero.cura());

  }

  @Test
  void pruebaSeis() {
    Arquero arquero = new Arquero("Jose", 100, 1, true);

    // Pierde 50
    arquero.pierdeVida(50);

    // Vivo
    assertEquals(true, arquero.isEstaVivo());

    // armadura
    assertEquals(false, arquero.isTieneArmadura());

    // Tiene vida actual
    assertEquals(75, arquero.getVidaActual());

    // ataque
    assertEquals(15, arquero.ataca());

    // Curacion
    assertEquals(0, arquero.cura());

  }

  @Test
  void pruebaSiete() {
    Arquero arquero = new Arquero("Jose", 100, 1, true);

    arquero.pierdeVida(50);

    arquero.consigueArmadura();

    arquero.pierdeVida(50);

    // Vivo
    assertEquals(true, arquero.isEstaVivo());

    // armadura
    assertEquals(false, arquero.isTieneArmadura());

    // Tiene vida actual
    assertEquals(50, arquero.getVidaActual());

    // ataque
    assertEquals(10, arquero.ataca());

    // Curacion
    assertEquals(0, arquero.cura());

  }

  @Test
  void pruebaOcho() {
    Arquero arquero = new Arquero("Jose", 100, 1, true);

    // Pierde 50
    arquero.pierdeVida(50);

    // Vivo
    assertEquals(true, arquero.isEstaVivo());

    // armadura
    assertEquals(false, arquero.isTieneArmadura());

    // Tiene vida actual
    assertEquals(75, arquero.getVidaActual());

    // ataque
    assertEquals(15, arquero.ataca());

    // Curacion
    assertEquals(0, arquero.cura());

  }

  @Test
  void pruebaNueve() {
    Sanador sanador = new Sanador("Jose", 100);

    sanador.pierdeVida(200);

    // Muerto
    assertEquals(false, sanador.isEstaVivo());

    // Tiene vida actual
    assertEquals(0, sanador.getVidaActual());

    // ataque
    assertEquals(0, sanador.ataca());

    // Curacion
    assertEquals(0, sanador.cura());

  }

  @Test
  void pruebaDiez() {
    Sanador sanador = new Sanador("Jose", 100);

    sanador.pierdeVida(50);
    sanador.pierdeVida(50);

    // Muerto
    assertEquals(false, sanador.isEstaVivo());

    // Tiene vida actual
    assertEquals(0, sanador.getVidaActual());

    // ataque
    assertEquals(0, sanador.ataca());

    // Curacion
    assertEquals(0, sanador.cura());

  }

  @Test
  void pruebaOnce() {
    Sanador sanador = new Sanador("Jose", 100);

    sanador.ganaVida(10);

    // VIvo
    assertEquals(true, sanador.isEstaVivo());

    // Tiene vida actual
    assertEquals(100, sanador.getVidaActual());

    // ataque
    assertEquals(0, sanador.ataca());

    // Curacion
    assertEquals(50, sanador.cura());

  }

  @Test
  void pruebaDoce() {
    Sanador sanador = new Sanador("Jose", 100);

    sanador.pierdeVida(50);

    sanador.ganaVida(10);

    // Vivo
    assertEquals(true, sanador.isEstaVivo());

    // Tiene vida actual
    assertEquals(63, sanador.getVidaActual());

    // ataque
    assertEquals(0, sanador.ataca());

    // Curacion
    assertEquals(31, sanador.cura());

  }

  @Test
  void pruebaTrece() {
    Sacerdote sacerdote = new Sacerdote("Jose", 100, true);

    sacerdote.pierdeVida(200);

    // Vivo
    assertEquals(true, sacerdote.isEstaVivo());

    // Reliquia
    assertEquals(false, sacerdote.isTieneReliquia());

    // Tiene vida actual
    assertEquals(100, sacerdote.getVidaActual());

    // ataque
    assertEquals(0, sacerdote.ataca());

    // Curacion
    assertEquals(50, sacerdote.cura());

  }

  @Test
  void pruebaCatorce() {
    Sacerdote sacerdote = new Sacerdote("Jose", 100, false);

    sacerdote.pierdeVida(200);

    sacerdote.ganaVida(50);

    // Muerto
    assertEquals(false, sacerdote.isEstaVivo());

    // Reliquia
    assertEquals(false, sacerdote.isTieneReliquia());

    // Tiene vida actual
    assertEquals(0, sacerdote.getVidaActual());

    // ataque
    assertEquals(0, sacerdote.ataca());

    // Curacion
    assertEquals(0, sacerdote.cura());

  }

  @Test
  void pruebaQuince() {
    Sacerdote sacerdote = new Sacerdote("Jose", 100, false);

    sacerdote.pierdeVida(50);

    // Muerto
    assertEquals(true, sacerdote.isEstaVivo());

    // Reliquia
    assertEquals(false, sacerdote.isTieneReliquia());

    // Tiene vida actual
    assertEquals(50, sacerdote.getVidaActual());

    // ataque
    assertEquals(0, sacerdote.ataca());

    // Curacion
    assertEquals(25, sacerdote.cura());

  }

  @Test
  void pruebaDieciseis() {
    Sacerdote sacerdote = new Sacerdote("Jose", 100, true);

    sacerdote.pierdeVida(200);

    // Muerto
    assertEquals(true, sacerdote.isEstaVivo());

    // Reliquia
    assertEquals(false, sacerdote.isTieneReliquia());

    // Tiene vida actual
    assertEquals(100, sacerdote.getVidaActual());

    // ataque
    assertEquals(0, sacerdote.ataca());

    // Curacion
    assertEquals(50, sacerdote.cura());

  }

}
