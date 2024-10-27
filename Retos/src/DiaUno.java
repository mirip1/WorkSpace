import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DiaUno {
    public static void main(String[] args) {
        // Ruta del archivo de calibración
        String filePath = "C:\\Users\\mivel\\eclipse-workspace\\Retos\\src\\Advent1.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int sum = 0;
            String line;

            // Lee cada línea del archivo
            while ((line = br.readLine()) != null) {
                // Extrae el primer y último dígito
                int asccii;
                boolean dos=false;
                int firstDigit=0;
                int lastDigit=0;
                for (int i=0; i!=line.length();i++ ) {
                  asccii = (int)line.charAt(i);
                  
                  if (asccii >= 48 && asccii <=59 && dos==false) {
                    firstDigit = Character.getNumericValue(line.charAt(i));
                    dos=true;
  
                  }else if (asccii >= 48 && asccii <=59 && dos==true) {
                    lastDigit = Character.getNumericValue(line.charAt(i));
                  }
                  
                
                }
                
                

                // Forma el número de dos dígitos y suma al total
                int calibrationValue = firstDigit * 10 + lastDigit;
              
                System.out.println(calibrationValue);
                sum += calibrationValue;
            }

            // Imprime la suma total de los valores de calibración
            System.out.println("Suma de los valores de calibración: " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



