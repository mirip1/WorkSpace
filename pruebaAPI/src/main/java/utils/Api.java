package utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import models.Juego;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Api {
  
  private static final String API_KEY = "fe156ceb087044149bc6d86b572bcf13";
  private static OkHttpClient client;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Escriba el nombre del juego a buscar");
    String nombreJuego = sc.nextLine();

    // URL de la API
    String apiUrl = "https://api.rawg.io/api/games?key=" + API_KEY + "&search=" + nombreJuego;

    // Crear cliente OkHttp
     client = new OkHttpClient();

    // Crear solicitud
    Request request = new Request.Builder().url(apiUrl).get().build();

    try {
      // Obtener la lista de juegos
      List<Juego> juegos = fetchJuegos(apiUrl);

      // Mostrar los juegos obtenidos
      for (Juego juego : juegos) {
          System.out.println(juego);
      }
  } catch (IOException e) {
      e.printStackTrace();
  }
}

/**
* Obtener la lista de juegos desde la API principal.
*
* @param apiUrl la URL de la API
* @return lista de objetos Juego
* @throws IOException en caso de error de red
*/
private static List<Juego> fetchJuegos(String apiUrl) throws IOException {
  List<Juego> juegos = new ArrayList<>();
  Gson gson = new Gson();

  // Crear solicitud a la API
  Request request = new Request.Builder()
          .url(apiUrl)
          .get()
          .build();

  try (Response response = client.newCall(request).execute()) {
      if (response.isSuccessful() && response.body() != null) {
          // Parsear JSON
          String jsonResponse = response.body().string();
          JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
          JsonArray results = jsonObject.getAsJsonArray("results");

          // Formateador de fechas
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

          for (JsonElement element : results) {
              JsonObject gameObject = element.getAsJsonObject();

              try {
                  // Extraer campos principales
                  int idJuego = gameObject.get("id").getAsInt();
                  String titulo = gameObject.get("name").getAsString();
                  String fechaLanzamientoStr = gameObject.has("released") && !gameObject.get("released").isJsonNull()
                          ? gameObject.get("released").getAsString() : null;
                  double puntuacionMetacritic = gameObject.has("metacritic") && !gameObject.get("metacritic").isJsonNull()
                          ? gameObject.get("metacritic").getAsDouble() : 0.0;
                  String imagen = gameObject.get("background_image").getAsString();

                  // Convertir fecha
                  Date fechaLanzamiento = fechaLanzamientoStr != null ? dateFormat.parse(fechaLanzamientoStr) : null;

                  // Obtener descripción desde la API de detalles
                  String descripcion = fetchDescripcionJuego(idJuego);

                  // Crear objeto Juego
                  Juego juego = new Juego(idJuego, titulo, descripcion, fechaLanzamiento, puntuacionMetacritic, imagen);
                  juegos.add(juego);
              } catch (ParseException e) {
                  System.err.println("Error al parsear la fecha de lanzamiento: " + e.getMessage());
              }
          }
      } else {
          System.err.println("Error al obtener la lista de juegos: Código HTTP " + response.code());
      }
  }

  return juegos;
}

/**
* Obtener la descripción detallada de un juego desde la API.
*
* @param idJuego el ID del juego
* @return la descripción del juego
* @throws IOException en caso de error de red
*/
private static String fetchDescripcionJuego(int idJuego) throws IOException {
  // URL de la API para obtener detalles del juego
  String detailUrl = "https://api.rawg.io/api/games/" + idJuego + "?key=" + API_KEY;

  // Crear solicitud
  Request request = new Request.Builder()
          .url(detailUrl)
          .get()
          .build();

  try (Response response = client.newCall(request).execute()) {
      if (response.isSuccessful() && response.body() != null) {
          // Parsear JSON de detalles
          String jsonResponse = response.body().string();
          JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

          // Extraer descripción
          return jsonObject.has("description_raw") && !jsonObject.get("description_raw").isJsonNull()
                  ? jsonObject.get("description_raw").getAsString() : "Sin descripción";
      } else {
          System.err.println("Error al obtener detalles del juego con ID " + idJuego + ": Código HTTP " + response.code());
      }
  }

  return "Sin descripción";
}
}