import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaCamposApp {

  public static void main(String[] args) {
    
    Pattern patternNombreApellidos = Pattern.compile("[A-Z].*\\s[A-Z].*");
    Matcher mensaje = patternNombreApellidos.matcher("Paco Lopez");
    System.out.println(mensaje.matches());
    
    LocalDate fechaActual = LocalDate.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String fecha = fechaActual.format(formato);
    
    
    
    
    

  }

}
