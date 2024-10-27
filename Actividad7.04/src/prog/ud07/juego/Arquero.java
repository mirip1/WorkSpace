package prog.ud07.juego;

/**
 * Personaje que simula un arquero
 */
public class Arquero extends Personaje {

  // Tipo de Maestria arco NOVATO
  private static final int NOVATO = 1;

  // Tipo de Maestria arco MEDIO
  private static final int MEDIO = 2;

  // Tipo de Maestria arco EXPERTO
  private static final int EXPERTO = 3;

  // Nivel de Maestria del arquero
  private int nivelMaestria;

  // Boleeano que define si tiene Armadura o no
  private boolean tieneArmadura;

  /**
   * Constructor
   * 
   * @param nombre        Nombre del personaje
   * @param vidaInicial   Vida inicial del personaje
   * @param tieneArmadura Boleeano que define si tiene Armadura o no
   * @param nivelMaestria Nivel de Maestria del arquero
   * @throws IllegalArgumentException si algun dato no es valido
   */
  public Arquero(String nombre, int vidaInicial, int nivelMaestria, boolean tieneArmadura) {
    super(nombre, vidaInicial);
    if (compruebaMaestria(nivelMaestria)) {
      this.nivelMaestria = nivelMaestria;
      this.tieneArmadura = tieneArmadura;
    } else {
      throw new IllegalArgumentException();
    }

  }

  // Comprueba que la maestria sea valida
  private boolean compruebaMaestria(int nivelMaestria) {
    return nivelMaestria == NOVATO || nivelMaestria == MEDIO || nivelMaestria == EXPERTO;
  }

  /**
   * Metodo que simula que consiga armadura
   */
  public void consigueArmadura() {
    tieneArmadura = true;
  }

  /**
   * Sube de nivel de maestria
   */
  public void subirNivelMaestria() {
    if (isEstaVivo() && nivelMaestria < 3) {
      nivelMaestria++;
    }

  }

  @Override
  public int ataca() {
    if (isEstaVivo()) {

      // Quita vida segun su nivel de maestria
      if (nivelMaestria == EXPERTO) {
        return getVidaActual() / 2;
      } else if (nivelMaestria == MEDIO) {
        return getVidaActual() / 3;

      } else if (nivelMaestria == NOVATO) {
        return getVidaActual() / 5;
      }
    }
    return super.ataca();
  }

  @Override
  public void pierdeVida(int puntosPerdidos) {
    // TODO Auto-generated method stub
    // Metodo que simula que pierda vida si tiene armadura los puntos perdidos se
    // reduciran a la mitad y perderá la armadura
    if (tieneArmadura) {
      super.pierdeVida(puntosPerdidos / 2);
      tieneArmadura = false;
    } else {
      super.pierdeVida(puntosPerdidos);
    }
  }

  /**
   * @return the nivelMaestria
   */
  public int getNivelMaestria() {
    return nivelMaestria;
  }

  /**
   * @return the tieneArmadura
   */
  public boolean isTieneArmadura() {
    return tieneArmadura;
  }

}
