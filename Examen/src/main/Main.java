package main;

import utils.Utils;

public class Main {
  public static void main(String[] args) {
    Utils conexion = new Utils();
//    conexion.crearTablaPeliculas();
    conexion.peliculasToFichero("English", false);
    conexion.cargarPeliculaBinario("peliculas_lang_English.dat");
        
        
  }
  
}
