package hlc.auth.seguridad;

import java.security.InvalidKeyException;

import java.security.NoSuchAlgorithmException;

import hlc.auth.otp.GeneradorTOTP;


public class SistemaSeguridadTemporal {
  /**
   * Devuelve si el Pin introducido es correcto
   * @param usuario nombre de usaurio
   * @param Piun pasado por el usere
   * @param claveSecreta  clave secreta del user para generar su PIN
   * @return true si validacion se completa correctamente
   * @throws NoSuchAlgorithmException
   * @throws InvalidKeyException
   */
  public boolean autenticar(String usuario, String codigo, byte[] claveSecreta) throws NoSuchAlgorithmException, InvalidKeyException {
      String codigoGenerado = GeneradorTOTP.generarTOTP(claveSecreta);
      return codigoGenerado.equals(codigo);
  }
}