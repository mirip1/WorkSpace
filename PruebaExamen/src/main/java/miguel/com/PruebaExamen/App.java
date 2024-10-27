package miguel.com.PruebaExamen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    
    driver.get("https://stackoverflow.com/questions/69466279/java-selenium-unable-to-find-an-exact-match-for-cdp-version-94-so-returning");
    
  }
}
