package psp.unidad01.relacion05.ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Generador {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String arhivo = "Archivo.txt";
    String cont = "Hola amigos me llamo ruben.";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(arhivo))) {
      writer.write(cont);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
