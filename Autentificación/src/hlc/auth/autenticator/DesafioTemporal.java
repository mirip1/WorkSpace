package hlc.auth.autenticator;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import hlc.auth.otp.GeneradorTOTP;

public class DesafioTemporal {
    private String usuario;
    private byte[] claveSecreta;

    public DesafioTemporal(String usuario, byte[] claveSecreta) {
        this.usuario = usuario;
        this.claveSecreta = claveSecreta;
    }
    
    public String generarCodigo() throws NoSuchAlgorithmException, InvalidKeyException {
        return GeneradorTOTP.generarTOTP(claveSecreta);
    }
}

