import java.util.Scanner;

public class CalculoVertical {
  // Declaro las constantes
  public static final double GRAVEDAD = 9.8;
  public static final double PIESPORMETRO = 3.28;

  public static void main(String[] args) {
    // Pongo el titulo y mi nombre
    Scanner scan = new Scanner(System.in);
    System.out.println("EXAMEN DE Miguel Velasco Fernandez. CALCULO DE LANZAMIENTO VERTICAL");

    // Pido la velocidad inicial por pantalla
    System.out.print("Introduzca la velocidad inicial del objeto (en m/s): ");

    // Declaro las variables
    double velocidadInicial = Double.parseDouble(scan.nextLine());
    double tiempo = (velocidadInicial / GRAVEDAD);
    double alturaMax = (velocidadInicial * tiempo) - ((GRAVEDAD * tiempo * tiempo) / 2);
    double alturaPies = (alturaMax * PIESPORMETRO);

    // Realizamos la conversion de tipo forzada
    int alturaPiesRedond = (int) alturaPies;

    // Imprimo por pantalla los Datos
    System.out.println("La altura máxima en metros es de: " + alturaMax);
    System.out.println("Esta altura equivale a: " + alturaPiesRedond + " pies");
    System.out.println("Esta altura equivale a: " + tiempo + " segundos");
  }

}
