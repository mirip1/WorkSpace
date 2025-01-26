package hlc.auth.otp;

import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import hlc.auth.hash.AlgoritmoHashSHA1;

/**
 * Generador de clases TOP basada en RFC 6338
 * @author mmontoro
 *
 */
public class GeneradorTOTP {
    //Tiempo en el que el PIN es válido
    private static final int INTERVALO_SEGUNDOS = 30;
    
    // dígitos que se van a generar
    private static final int DIGITOS = 6;
    
    // Algoritmo Hash a usar
    private static final AlgoritmoHashSHA1 algoritmoHash = new AlgoritmoHashSHA1();

    /**
     * Metodo que obtiene el tiempo actual para calcular el tiempo de validez del PIN valido actual
     * @param PIN
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String generarTOTP(byte[] claveSecreta) throws NoSuchAlgorithmException, InvalidKeyException {
        long tiempoActual = Instant.now().getEpochSecond();
        long contador = tiempoActual / INTERVALO_SEGUNDOS;
        
        return generarHOTP(claveSecreta, contador);
    }

    /**
     * Genera el PIN a partir del contador y la clave secreta
     * @param claveSecreta
     * @param contador
     * @return PIN
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    private static String generarHOTP(byte[] claveSecreta, long contador) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] contadorBytes = ByteBuffer.allocate(8).putLong(contador).array();
        
        byte[] hash = algoritmoHash.resume(claveSecreta, contadorBytes);
        
        int offset = hash[hash.length - 1] & 0xF;
        int binCode = ((hash[offset] & 0x7F) << 24) |
                      ((hash[offset + 1] & 0xFF) << 16) |
                      ((hash[offset + 2] & 0xFF) << 8) |
                      (hash[offset + 3] & 0xFF);
        
        int otp = binCode % (int) Math.pow(10, DIGITOS);
        
        return String.format("%0" + DIGITOS + "d", otp);
    }
}