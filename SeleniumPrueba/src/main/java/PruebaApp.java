import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class PruebaApp {

  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
   
    try {
      driver.get("file:///C:/Users/mivel/Downloads/index%20(2).html");
      driver.findElement(By.id("mostrarAlert")).click();
      driver.findElement(By.id("botonLogin")).click();
      Thread.sleep(4000);
      Alert alert = driver.switchTo().alert();
      alert.accept();

      Thread.sleep(4000);

    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      driver.quit();
    }
    
  }

}
