package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import utils.Utils;

  public class ValidaCamposApp {

      public static void main(String[] args) {
          // Ruta del archivo de datos
          String rutaArchivo = "/home/miguel/Documentos/Pedro/validaciones/datos.txt";  // Puede modificarse para leer de otro archivo

          // Leer el archivo
          Map<String, String> datos = leerArchivo(rutaArchivo);

          // Validar los datos
          validarDatos(datos);
      }

      // Función para leer el archivo y almacenar los datos en un mapa
      public static Map<String, String> leerArchivo(String ruta) {
          Map<String, String> datos = new HashMap<>();
          try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
              String linea;
              while ((linea = br.readLine()) != null) {
                  String[] partes = linea.split("=");
                  if (partes.length == 2) {
                      datos.put(partes[0].trim(), partes[1].trim());
                  }
              }
          } catch (IOException e) {
              System.out.println("Error al leer el archivo: " + e.getMessage());
          }
          return datos;
      }

      // Función para validar los datos y mostrar el resumen de validación
      public static void validarDatos(Map<String, String> datos) {
          boolean valido = true;

          // Validaciones
          if (!Utils.validarNombreApellidos(datos.get("nombreApellidos"))) {
              System.out.println("Nombre y Apellidos: Inválido");
              valido = false;
          }
          if (!Utils.validarFechaNacimiento(datos.get("fechaNacimiento"))) {
              System.out.println("Fecha de Nacimiento: Inválido");
              valido = false;
          }
          if (!Utils.validarTelefonoFijo(datos.get("telefonoFijo"))) {
              System.out.println("Teléfono Fijo: Inválido");
              valido = false;
          }
          if (!Utils.validarTelefonoMovil(datos.get("telefonoMovil"))) {
              System.out.println("Teléfono Móvil: Inválido");
              valido = false;
          }
          if (!Utils.validarNumeroHijos(datos.get("numeroHijos"))) {
              System.out.println("Número de Hijos: Inválido");
              valido = false;
          }
          if (!Utils.validarComunidad(datos.get("comunidad"))) {
              System.out.println("Comunidad Autónoma: Inválido");
              valido = false;
          }
          if (!Utils.validarLocalidad(datos.get("localidad"))) {
              System.out.println("Localidad: Inválido");
              valido = false;
          }
          if (!Utils.validarIntereses(datos.get("intereses"))) {
              System.out.println("Intereses: Inválido");
              valido = false;
          }

          // Resumen de validación
          if (valido) {
              System.out.println("\nResumen: Todos los datos son válidos.");
          } else {
              System.out.println("\nResumen: Algunos datos son inválidos.");
          }
      }
  }



