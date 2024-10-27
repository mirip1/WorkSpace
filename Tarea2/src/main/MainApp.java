package main;

import util.Biblioteca;

public class MainApp {

  public static void main(String[] args) {

    String ruta2 = "Hoa.dat";
    String ruta1 = "hola.csv";
    Biblioteca util = new Biblioteca();
    util.ficheroCSVToBinario(ruta1);
    util.ficheroBinarioToCSV(ruta2);
    util.ordenarArchivoCSV(ruta1);
    util.ordenarArchivoBinario(ruta2);
    util.ficheroBinarioToCSVOrdenado(ruta2);
    
    
  }

}
