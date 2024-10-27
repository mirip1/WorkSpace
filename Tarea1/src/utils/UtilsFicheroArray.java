package utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import models.Empleado;

/**
 * Clase que implementa los metodos necesarios para el manejo de ficheros
 */
public class UtilsFicheroArray {
//  private ArrayList<Empleado> lista;

  /**
   * Constructor vacio
   */
  public UtilsFicheroArray() {
    super();

  }

  /**
   * Método que lee el fichero y lo devuelve en una lista
   * <
   * @param url ruta del fichero
   * @return la lista con los empleados
   */
  public List<Empleado> leerFichero(String url) {

    List<Empleado> lista = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(url))) {

//      System.out.println(br.readLine());
      String linea = br.readLine();

      // mientras linea no sea null seguir leyendo
      while ((linea = br.readLine()) != null) {

        String[] partes = linea.replaceAll("\"", "").split(",");
        Empleado e = new Empleado(partes[0], Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
        lista.add(e);

      }
      return lista;

    } catch (IOException e1) {
      e1.printStackTrace();
    }

    return null;

  }

  /**
   * Método que almacena todos los Empleados de un Array o ArrayList en un archivo
   * de texto
   * 
   * @param list lista de empleados
   * @param url  ruta del fichero
   */
  public void toArchivoTexto(List<Empleado> list, String url) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(url))) {
      for (Empleado i : list) {
        writer.write("\"" + i.getEmpresa() + "\"," + i.getEdad() + "," + i.getNumeroEmpleados() + "\n");
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Método que almacena todos los Empleados del Array o ArrayList en un archivo
   * binario, de forma inversa, empezando por el último.
   * 
   * @param list Lista de empleados
   * @param url  ruta del fichero
   */
  public void toArchivoBinarioInverso(List<Empleado> list, String url) {

    try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(url)))) {
      for (int i = list.size() - 1; i >= 0; i--) {
        oos.writeObject(list.get(i));
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Método que lee empleados de un archivo de texto y los imprime por pantalla.
   * 
   * @param archivo ruta del fichero
   */
  public void leer_Empleados(String archivo) {
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

      System.out.println(br.readLine());
      String linea;

      // Mientras linea no sea null seguir leyendo
      while ((linea = br.readLine()) != null) {
        System.out.println(linea);

      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Método que lee empleados de un archivo de texto binario y los imprime por pantalla.
   * 
   * @param archivo ruta del fichero binario
   */
  public void leer_Empleados_b(String archivo) {
    try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(archivo)))) {
      while (true) {
        
        try {
          Empleado empleado = (Empleado) ois.readObject();
          System.out.println(empleado);
          System.out.println("");
          
        } catch (IOException e) {
          break; 
        }
      }
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

}
