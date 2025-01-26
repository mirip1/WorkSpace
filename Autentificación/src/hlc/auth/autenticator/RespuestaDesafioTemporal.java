package hlc.auth.autenticator;

import java.security.InvalidKeyException;
import hlc.auth.seguridad.*;

import java.security.NoSuchAlgorithmException;

public class RespuestaDesafioTemporal {
    private String usuario;
    private String codigo;
    
    public RespuestaDesafioTemporal(String usuario, String codigo) {
        this.usuario = usuario;
        this.codigo = codigo;
    }
    /**
     * Comprueba si el PIN es correcto a parit del sistemaTemp y la clave secreta
     * @param sistema 
     * @param claveSecreta
     * @return true si es valido false si no
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public boolean validar(SistemaSeguridadTemporal sistema, byte[] claveSecreta) throws NoSuchAlgorithmException, InvalidKeyException {
        return sistema.autenticar(usuario, codigo, claveSecreta);
    }
}
