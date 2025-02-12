package prog.ud07.juego;

/**
 * Personaje que simula un Sacerdote
 */
public class Sacerdote extends Personaje {

  // Booleano que indica si tiene o no la reliquia
  private boolean tieneReliquia;

  /**
   * Constructor Si la vida del personaje no es mayor que 0 se lanza Exception
   * 
   * @param nombre        Nombre del personaje
   * @param vidaInicial   Vida inicial del personaje
   * @param tieneReliquia Booleano que indica si tiene o no la reliquia
   * @throws IllegalArgumentException si algun dato esta mal
   */
  public Sacerdote(String nombre, int vidaInicial, boolean tieneReliquia) {
    super(nombre, vidaInicial);
    this.tieneReliquia = tieneReliquia;
  }

  @Override
  public void pierdeVida(int puntosPerdidos) {
    // Si tiene la reliquia no pierde vida pero a cambio pierde la reliquia
    if (tieneReliquia) {
      super.pierdeVida(0);
      tieneReliquia = false;
    } else {
      super.pierdeVida(puntosPerdidos);
    }
  }

  @Override
  public int cura() {
    // Si tiene reliquia cura igual que su vida actual, si no, la mitad
    if (isEstaVivo()) {
      if (isTieneReliquia()) {
        return getVidaActual();
      } else {
        return getVidaActual() / 2;

      }

    }
    return super.cura();
  }

  /**
   * @return the tieneReliquia
   */
  public boolean isTieneReliquia() {
    return tieneReliquia;
  }

}
