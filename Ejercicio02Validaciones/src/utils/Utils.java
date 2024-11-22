package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
  
  // Valida que el nombre y apellidos tengan la primera letra de cada palabra en mayúscula.
  public static boolean validarNombreApellidos(String nombreApellidos) {
      if (nombreApellidos == null || nombreApellidos.isEmpty()) {
          return false;
      }
      
      String[] palabras = nombreApellidos.split(" ");
      for (String palabra : palabras) {
          if (!Character.isUpperCase(palabra.charAt(0))) {
              return false;
          }
      }
      return true;
  }

  // Valida que la fecha de nacimiento sea válida y anterior a la fecha actual.
  public static boolean validarFechaNacimiento(String fechaNacimiento) {
      try {
        
          SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
          Date fecha = formato.parse(fechaNacimiento);
          Date fechaActual = new Date();
          
          return fecha.before(fechaActual);
      } catch (Exception e) {
          return false;
      }
  }

  // Valida que el teléfono fijo tenga 9 dígitos y comience con 9.
  public static boolean validarTelefonoFijo(String telefonoFijo) {
      if (telefonoFijo.isEmpty()) {
          return true; 
      }
      Pattern pattern = Pattern.compile("^9\\d{8}$");
      Matcher matcher = pattern.matcher(telefonoFijo);
      return matcher.matches();
  }

  // Valida que el teléfono móvil sea válido (puede ser nacional o internacional).
  public static boolean validarTelefonoMovil(String telefonoMovil) {
      Pattern pattern = Pattern.compile("^\\+?\\d{1,3}?\\d{9,15}$");
      Matcher matcher = pattern.matcher(telefonoMovil);
      return matcher.matches();
  }

  // Valida que el número de hijos sea un entero mayor o igual a cero.
  public static boolean validarNumeroHijos(String numeroHijos) {
      try {
          int numHijos = Integer.parseInt(numeroHijos);
          return numHijos >= 0;
      } catch (NumberFormatException e) {
          return false;
      }
  }

  // Valida que la comunidad sea uno de los valores permitidos.
  public static boolean validarComunidad(String comunidad) {
      return comunidad.equals("Andalucia") || comunidad.equals("Extremadura") || comunidad.equals("Otra");
  }

  // Valida que la localidad esté entre 1 y 50 caracteres y la primera letra sea mayúscula.
  public static boolean validarLocalidad(String localidad) {
      if (localidad == null || localidad.length() < 1 || localidad.length() > 50) {
          return false;
      }
      return Character.isUpperCase(localidad.charAt(0));
  }

  // Valida que los intereses estén entre 1 y 5 elementos, sean únicos y estén dentro de los valores permitidos.
  public static boolean validarIntereses(String intereses) {
      String[] listaIntereses = intereses.split(",");
      if (listaIntereses.length < 1 || listaIntereses.length > 5) {
          return false;
      }

      // Intereses válidos
      String[] interesesValidos = {"Lectura", "Videojuegos", "Series", "Películas", "Actividades al aire libre", "deportes", "Tecnología", "Manualidades"};
      for (String interes : listaIntereses) {
          boolean valido = false;
          for (String i : interesesValidos) {
              if (i.equals(interes.trim())) {
                  valido = true;
                  break;
              }
          }
          if (!valido) {
              return false;
          }
      }

      // Verificar que no haya intereses repetidos
      for (int i = 0; i < listaIntereses.length; i++) {
          for (int j = i + 1; j < listaIntereses.length; j++) {
              if (listaIntereses[i].trim().equals(listaIntereses[j].trim())) {
                  return false;
              }
          }
      }

      return true;
  }
  

}
