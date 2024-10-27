package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Log {
  private final static String RUTA = "log_csv.txt";
  private LocalDate fecha;
  private LocalTime hora;
  DateTimeFormatter formato;
  
  public Log() {
    super();
  
  }
  
  /**
   * Hace un log que almaena cada metodo, fichero de entrad y de salida
   * @param metodo metodo que se utiliza
   * @param entrada fichero de entrada
   * @param salida fichero de salida
   */
  public  void hacerLog(String metodo, String entrada, String salida) {
  
    
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA , true))) {
      
        bw.write(logBuilder(metodo, entrada, salida));
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  /**
   * metodo utlizado para crearel "formato" del log
   * @param metodo metodo que se utiliza
   * @param entrada fichero de entrada
   * @param salida fichero de salida
   * @return
   */
  private  String logBuilder(String metodo, String entrada, String salida) {
    fecha = LocalDate.now();
    hora = LocalTime.now();
    formato = DateTimeFormatter.ofPattern("HH:mm");
    return "[" + fecha + " " + hora.format(formato) + "] metodo utilizado: "+ metodo + "; fichero entrada: " + entrada + "; fichero salida : " + salida + "\n";
    
  }
  
  
  

}
