package hash;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash_SHA256 {
    public static void main(String[] args) {
        String codigo = "SHA-256";
        if (args.length == 0 || args.length > 2) {
            throw new IllegalArgumentException("illo son 1 o 2 parámetros");
        } else if (args.length == 2) {
            codigo = args[1];
        }

        try (FileInputStream in = new FileInputStream(args[0])) {
            MessageDigest encriptar = MessageDigest.getInstance(codigo);

            byte[] buffer = new byte[4096];
            int leidos;
            while ((leidos = in.read(buffer)) != -1) {
                encriptar.update(buffer, 0, leidos);
            }

            byte[] bytes = encriptar.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }

            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
