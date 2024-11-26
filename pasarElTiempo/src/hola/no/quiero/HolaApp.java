package hola.no.quiero;

public class HolaApp {

  public static void mostrarPrimeryUtilmoCaracter(String cadena) {

    char primer = cadena.charAt(0);
    char ultimo = cadena.charAt(cadena.length() - 1);
    System.out.println("Primer " + primer + " ultimo " + ultimo);

  }

  public static double precio(double precio, boolean opcion) {

    double devaluePorAno = 0.93;

    double acum = precio;
    for (int i = 0; i != 5; i++) {

      acum = acum * devaluePorAno;

    }
    acum = acum * 100;
    int precioReal = (int) acum;
    double precioRealDouble = ((double) precioReal) / 100;

    if (opcion) {
      return precioRealDouble;
      
    } else {
      return Math.round(acum ) / 100.0;

    }
  }

  public static void main(String[] args) {

    String HolA = "HolA";
    System.out.println(HolA.substring(HolA.length() - 1));

    System.out.println(precio(350, false));

  }

}
