package hlc.auth.app;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import hlc.auth.autenticator.DesafioTemporal;
import hlc.auth.autenticator.RespuestaDesafioTemporal;
import hlc.auth.seguridad.SistemaSeguridadTemporal;

public class MainApp {
    private static final Map<String, String> usuarios = new HashMap<>();

    public static void main(String[] args) {
        // Simulación de la base de datos
        usuarios.put("usuario1", "6a542e818715b34b");
        usuarios.put("usuario2", "e20800dba48808a0");
        usuarios.put("usuario3", "c689d2c62e9b9709");
        usuarios.put("usuario4", "6c6517ad350003bc");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca el identificador del usuario: ");
        String usuario = scanner.nextLine();

        if (!usuarios.containsKey(usuario)) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Introduzca ahora el PIN actual del usuario (6 cifras): ");
        String pinIngresado = scanner.nextLine();

        try {
            // Convertir la clave secreta de HEX a bytes
            byte[] claveSecreta = hexStringToByteArray(usuarios.get(usuario));

//            DesafioTemporal desafio = new DesafioTemporal(usuario, claveSecreta);
//            String pinGenerado = desafio.generarCodigo();

            // Crear la respuesta el PIN ingresado
            RespuestaDesafioTemporal respuesta = new RespuestaDesafioTemporal(usuario, pinIngresado);

            // Verificar la autenticación con el sistema de seguridad
            SistemaSeguridadTemporal sistemaSeguridad = new SistemaSeguridadTemporal();
            boolean autenticado = respuesta.validar(sistemaSeguridad, claveSecreta);

            if (autenticado) {
                System.out.println("\nMENU PRINCIPAL");
                System.out.println("--------------");
                System.out.println("1.- Nuevo cliente");
                System.out.println("2.- Modificar cliente");
                System.out.println("3.- Eliminar cliente");
                System.out.println("4.- Listar clientes");
                System.out.println("0.- Salir de la aplicación");
                System.out.print("Elija una opción (0-4): ");
                System.err.println("OJO: LA APLICACIÓN NO FUNCIONA, EL MENÚ ES SOLO VISUAL PARA CONFIRMAR LA AUTENTICACIÓN");
            } else {
                System.out.println("PIN incorrecto. Acceso denegado.");
            }
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            System.out.println("Error en la autenticación: " + e.getMessage());
        }
    }

    /**
     * Método para convertir una clave secreta en formato hexadecimal a un array de bytes.
     * @param hex clave secreta en formato HEX.
     * @return array de bytes.
     */
    private static byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                                 + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
}
