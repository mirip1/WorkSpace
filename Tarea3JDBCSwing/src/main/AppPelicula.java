package main;

import java.util.List;

import models.Actor;
import models.Pelicula;
import utils.Conexion;

public class AppPelicula {

  public static void main(String[] args) {
    Conexion con = new Conexion();
    List<Pelicula> peliculas = con.pillaPeliculas();
    List<Actor> actores = con.mostrarActores(1);
    peliculas.forEach(System.out :: println);
//    actores.forEach(System.out :: println);º
    
   }

}
