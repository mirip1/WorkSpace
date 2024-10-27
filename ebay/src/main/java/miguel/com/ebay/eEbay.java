package miguel.com.ebay;


import java.lang.reflect.Array;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class eEbay {

  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    try {

      driver.get("https://www.ebay.es/");
      driver.findElement(By.id("gh-ac")).sendKeys("Play Station 5\n");
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[62]/div[2]/span/span/nav/ol/li[2]/a")).click();
      Thread.sleep(1000);
      String titulo = driver.findElements(By.className("s-item__title")).get(2).getText();
      
      Thread.sleep(1000);
      System.out.println("Título del tercer elemento: " + titulo);
      driver.findElements(By.className("s-item__image")).get(3).click();
      Thread.sleep(4000);
      Set<String> pestanyas = driver.getWindowHandles();
      Object[] ventanas = pestanyas.toArray();
      driver.switchTo().window(ventanas[1].toString());
      try {
        driver.findElements(By.name("Añadir a la cesta"));
        System.out.println("Existe el boton añadir a la cesta");

      } catch (Exception e) {
        System.out.println("No existe el boton añadir a la cesta");

      }


    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("HA FALLADO");
    } finally {
      driver.quit();
    }
  }

}
