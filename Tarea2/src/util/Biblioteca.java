package util;

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
import java.util.Collections;
import java.util.List;

public class Biblioteca {
private Log log = new Log() ;
//  private String url;

  // Constructor
  public Biblioteca() {

  }

  /**
   * Método que almacena todos los Empleados de un Array o ArrayList en un archivo
   * de texto
   * 
   * @param list lista de empleados
   * @param url  ruta del fichero
   */
  public void ficheroCSVToBinario(String url) {
    // comprobamos que existe el fichero y que es .csv

    String urlNueva = url;
    if (url.endsWith(".csv")) {
      // ahora le cambiamos la extension
      urlNueva = urlNueva.replace(".csv", ".dat");
      System.out.println(urlNueva);
      // Primero lee el archivo
      try (BufferedReader br = new BufferedReader(new FileReader(url));
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(urlNueva))) {
        String linea = "";

        // Mientras linea no sea null seguir leyendo
        while ((linea = br.readLine()) != null) {
          System.out.println(linea);
          // escribimos en el fichero
          oos.writeObject(linea);

        }
        log.hacerLog("ficheroCSVToBinario", url, urlNueva);
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    } else {
      System.out.print("El archivo no es un .csv");
    }

  }
  
  /**
   * Metodo que crea un archivo binario a uno .csv
   * @param url ruta del archivo .dat
   */
  public void ficheroBinarioToCSV(String url) {
    // comprobamos que existe el fichero y que es .dat
//    File archivo = new File(url);
    String urlNueva = url;
    if (url.endsWith(".dat")) {
      // ahora le cambiamos la extension
      urlNueva = urlNueva.replace(".dat", ".csv");
      System.out.println(urlNueva);
      // Primero lee el archivo
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(url));
          BufferedWriter writer = new BufferedWriter(new FileWriter(urlNueva))) {
        // Y escribimos el archivo
        while (true) {

          try {
            String linea = (String) ois.readObject() + "\n";
            writer.write(linea);
          } catch (Exception e) {
            break;
          }

        }
        log.hacerLog("ficheroBinarioToCSV", url, urlNueva);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

  }

  /**
   * Método que a partir de uun archivo csv crea otro archivo csv pero ordenado alfabéticamente
   * @param url ruta del archivo
   */
  public void ordenarArchivoCSV(String url) {
    // comprobamos que existe el fichero y que es .csv
    String urlNueva = url.replace(".csv", "_ord.csv");
    if (url.endsWith(".csv")) {
      // creamos una lista
      List<String> lineas = new ArrayList<>();
      // leemos el archivo .csv y guardamos sus lineas en una lista
      try (BufferedReader br = new BufferedReader(new FileReader(url))) {
        String linea;
        while ((linea = br.readLine()) != null) {
          lineas.add(linea);
        }

      }catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      //ordenamos
      Collections.sort(lineas);
      
      //Escribimos en el nuevo fichero
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(urlNueva))) {
        for (String linea : lineas) {
          bw.write(linea + "\n");
        }

      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      log.hacerLog("ordenarArchivoCSV", url, urlNueva);

      
    }else {
      System.out.println("la extensión del archivo no es .csv");
    }
    
  }
  
  /**
   * Método que a partir de un archivo dat crea otro archivo dat pero ordenado alfabéticamente
   * @param url ruta del archivo
   */
  public void ordenarArchivoBinario(String url) {
    String urlNueva = url.replace(".dat", "_ord.dat");
    if (url.endsWith(".dat")) {
      List<String> lineas = new ArrayList<>();

      // leemos el archivo .dat y guardamos sus líneas en una lista
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(url))) {
        while (true) {
          try {
            String linea = (String) ois.readObject();
            lineas.add(linea);
          } catch (Exception e) {
            break;
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

      // ordenamos la lista
      Collections.sort(lineas);

      // escribimos en el nuevo fichero
      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(urlNueva))) {
        for (String linea : lineas) {
          oos.writeObject(linea);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      log.hacerLog("ordenarArchivoBinario", url, urlNueva);


    } else {
      System.out.println("la extensión del archivo no es .dat");
    }
  }
  
  
  public void ficheroBinarioToCSVOrdenado(String url) {
    String urlNueva = url.replace(".dat", "_ord.csv");
    if (url.endsWith(".dat")) {
      
      List<String> lineas = new ArrayList<>();
   // leemos el archivo .dat y guardamos sus líneas en una lista
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(url))) {
        while (true) {
          try {
            String linea = (String) ois.readObject();
            lineas.add(linea);
          } catch (Exception e) {
            break;
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      Collections.sort(lineas);
      
      // escribimos en el nuevo fichero .csv
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(urlNueva))) {
        for (String linea : lineas) {
          bw.write(linea + "\n");
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      log.hacerLog("ficheroBinarioToCSVOrdenado", url, urlNueva);

    } else {
      System.out.println("El archivo no es un .dat");
    }
      
      
      
    }
  
  
  
}