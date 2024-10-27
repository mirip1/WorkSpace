package prog.ud07.juego;

/**
 * Representa un Personaje tipo Guerrero
 */
public class Guerrero extends Personaje {

  // Tipo de arma espada
  private static final int ESPADA = 1;

  // Tipo de arma maza
  private static final int MAZA = 2;

  // Boleeano que define si tiene Armadura o no
  private boolean tieneArmadura;

  // Integer que define que arma tiene
  private int arma;

  /**
   * Constructor
   * 
   * @param nombre        Nombre del personaje
   * @param vidaInicial   Vida inicial del personaje
   * @param tieneArmadura Boleeano que define si tiene Armadura o no
   * @param armaInteger   que define que arma tiene solo puede ser 1 (Esapada) o
   *                      2(Maza)
   * @throws IllegalArgumentException si algun dato esta mal
   */
  public Guerrero(String nombre, int vidaInicial, boolean tieneArmadura, int arma) {
    super(nombre, vidaInicial);

    if (compruebaArma(arma)) {
      this.tieneArmadura = tieneArmadura;
      this.arma = arma;
    } else {
      throw new IllegalArgumentException();

    }

  }

  /**
   * Cambia de arma si el arma es valida
   * 
   * @param arma
   * @throws IllegalArgumentException si algun dato esta mal
   */
  public void cambiarArma(int arma) {
    if (compruebaArma(arma)) {
      this.arma = arma;
    } else {
      throw new IllegalArgumentException();

    }

  }

  // Comprueba que el arma sea valida
  private boolean compruebaArma(int arma) {
    return arma == ESPADA || arma == MAZA;
  }

  @Override
  public void ganaVida(int puntosGanados) {

    super.ganaVida(puntosGanados * 2);
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
   * Metodo que simula que consiga armadura
   */
  public void consigueArmadura() {
    tieneArmadura = true;
  }

  @Override
  public int ataca() {

    if (isEstaVivo()) {

      if (arma == ESPADA) {
        return getVidaActual() / 2;
      } else if (arma == MAZA) {
        return getVidaActual();

      }
    }
    return super.ataca();

  }

  /**
   * @return the tieneArmadura
   */
  public boolean isTieneArmadura() {
    return tieneArmadura;
  }

  /**
   * @return the arma
   */
  public int getArma() {
    return arma;
  }

}
