package selenium.wiki;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


class SeleniumPruebas {

  // Ejercicio1
  @Test
  void buscaJava() {
    WebDriver driver = new ChromeDriver();
    try {

      driver.get("https://es.wikipedia.org/");
      driver.findElement(By.id("searchInput")).sendKeys("Java\n");

      Thread.sleep(1000);
      String tituloWeb = driver.findElement(By.xpath("//*[@id=\"firstHeading\"]/span")).getText();
      assertEquals(tituloWeb, "Java");

    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("HA FALLADO");
    } finally {
      driver.quit();
    }
  }

  // Ejercicio2
  @Test
  void registroUsuario() {
    WebDriver driver = new ChromeDriver();
    try {

      driver.get("https://www.odoo.com/es_ES");
      driver.findElement(By.xpath("//*[@id=\"top_menu\"]/ul[1]/li[4]/a")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div[1]/div[2]/div/div[1]/div[1]/div[1]/label[1]/div"))
          .click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div[1]/div[2]/div/div[1]/div[2]/div/div/button  "))
          .click();
      driver.findElement(By.id("username")).sendKeys("Miguel");
      driver.findElement(By.id("email")).sendKeys("mivelfer5@gmail.com");
      driver.findElement(By.id("company-name")).sendKeys("miCompañia");
      driver.findElement(By.id("phone")).sendKeys("644893245");
      Thread.sleep(1000);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("HA FALLADO");
    } finally {
      driver.quit();
    }
  }

  // Ejercicio3
  @Test
  void fotoPabloPicasso() {
    WebDriver driver = new ChromeDriver();
    try {

      String src;
      driver.get("https://en.wikipedia.org/wiki/Pablo_Picasso");
      src = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[2]/td/span/a/img"))
          .getAttribute("src");
      Thread.sleep(1000);
      assertEquals(src,
          "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Portrait_de_Picasso%2C_1908.jpg/220px-Portrait_de_Picasso%2C_1908.jpg");

    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("HA FALLADO");
    } finally {
      driver.quit();
    }
  }

  // Ejercicio4
  @Test
  void paginaIESPabloPicasso() {
    WebDriver driver = new ChromeDriver();
    try {

      driver.get("https://en.wikipedia.org/wiki/Pablo_Picasso");
      driver.findElement(By.id("searchInput")).sendKeys("IES Pablo Picasso\n");
      Thread.sleep(1000);
      String tituloWeb = driver.findElement(By.id("firstHeading")).getText();
      assertEquals(tituloWeb, "Search results");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("HA FALLADO");
    } finally {
      driver.quit();
    }
  }

  

}
