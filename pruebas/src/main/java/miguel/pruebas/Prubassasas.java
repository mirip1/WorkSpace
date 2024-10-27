package miguel.pruebas;

public class Prubassasas {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
  }
  public static int sacarNumerosDni(String dni) {
    int numerosDni = Integer.parseInt(dni.substring(0, 8));
    int resto = numerosDni % 23;
    return resto;
  }
  
  public static String validarLetraDni(String dni) {
    String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

    return "a";
  }
}
