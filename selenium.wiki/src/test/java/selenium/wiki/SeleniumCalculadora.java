package selenium.wiki;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class SeleniumCalculadora {

//Bateria de pruebas Calculadora
  
 //Suma
 @ParameterizedTest
 @CsvSource({ 
   "1,2,3",
   "-2,-3,-5",
   "-3,4,1",
   })
 void TestSuma(String num1, String num2, String result) {
   WebDriver driver = new ChromeDriver();
   try {
     
     driver.get("https://testsheepnz.github.io/BasicCalculator.html");
     Thread.sleep(1000);
     driver.findElement(By.id("number1Field")).sendKeys(num1);
     driver.findElement(By.id("number2Field")).sendKeys(num2);
     driver.findElement(By.id("calculateButton")).click();
     Thread.sleep(1000);
     String resultado = driver.findElement(By.id("numberAnswerField")).getAttribute("value");
     
     assertEquals(result, resultado);
     
   } catch (Exception e) {
     System.out.println(e.getMessage());
     System.out.println("HA FALLADO");
   } finally {
     driver.quit();
   }
   
 }

 //Resta
 @ParameterizedTest
 @CsvSource({
   "1,2,-1",
   "-2,-3,1",
   "-3,4,-7",
   })
 void TestResta(String num1, String num2, String result) {
   WebDriver driver = new ChromeDriver();
   
   try {
     
     driver.get("https://testsheepnz.github.io/BasicCalculator.html");
     Thread.sleep(1000);
     driver.findElement(By.id("number1Field")).sendKeys(num1);
     driver.findElement(By.id("number2Field")).sendKeys(num2);
     Select seleccion = new Select(driver.findElement(By.id("selectOperationDropdown")));
     seleccion.selectByValue("1");
     driver.findElement(By.id("calculateButton")).click();
     Thread.sleep(1000);
     String resultado = driver.findElement(By.id("numberAnswerField")).getAttribute("value");

     assertEquals(result, resultado);

   } catch (Exception e) {
     System.out.println(e.getMessage());
     System.out.println("HA FALLADO");
   } finally {
     driver.quit();
   }

 }
 
 //Multiplicacion
 @ParameterizedTest
 @CsvSource({
   "1,2,2",
   "-2,-3,6",
   "-3,4,-12",
 })
 void TestMultiplicacion(String num1, String num2, String result) {
   WebDriver driver = new ChromeDriver();
   
   try {
     
     driver.get("https://testsheepnz.github.io/BasicCalculator.html");
     Thread.sleep(1000);
     driver.findElement(By.id("number1Field")).sendKeys(num1);
     driver.findElement(By.id("number2Field")).sendKeys(num2);
     Select seleccion = new Select(driver.findElement(By.id("selectOperationDropdown")));
     seleccion.selectByValue("2");
     driver.findElement(By.id("calculateButton")).click();
     Thread.sleep(1000);
     String resultado = driver.findElement(By.id("numberAnswerField")).getAttribute("value");
     
     assertEquals(result, resultado);
     
   } catch (Exception e) {
     System.out.println(e.getMessage());
     System.out.println("HA FALLADO");
   } finally {
     driver.quit();
   }
   
 }
 
 //Division
 @ParameterizedTest
 @CsvSource({
   "4,2,2",
   "-12,-3,4",
   "-16,4,-4",
 })
 void TestDivision(String num1, String num2, String result) {
   WebDriver driver = new ChromeDriver();
   
   try {
     
     driver.get("https://testsheepnz.github.io/BasicCalculator.html");
     Thread.sleep(1000);
     driver.findElement(By.id("number1Field")).sendKeys(num1);
     driver.findElement(By.id("number2Field")).sendKeys(num2);
     Select seleccion = new Select(driver.findElement(By.id("selectOperationDropdown")));
     seleccion.selectByValue("3");
     driver.findElement(By.id("calculateButton")).click();
     Thread.sleep(1000);
     String resultado = driver.findElement(By.id("numberAnswerField")).getAttribute("value");
     
     assertEquals(result, resultado);
     
   } catch (Exception e) {
     System.out.println(e.getMessage());
     System.out.println("HA FALLADO");
   } finally {
     driver.quit();
   }
   
 }
 
 //Concatenar
 @ParameterizedTest
 @CsvSource({
   "4,2,42",
   "-12,-3,-12-3",
   "-16,4,-164",
 })
 void TestConcatenacion(String num1, String num2, String result) {
   WebDriver driver = new ChromeDriver();
   
   try {
     
     driver.get("https://testsheepnz.github.io/BasicCalculator.html");
     Thread.sleep(1000);
     driver.findElement(By.id("number1Field")).sendKeys(num1);
     driver.findElement(By.id("number2Field")).sendKeys(num2);
     Select seleccion = new Select(driver.findElement(By.id("selectOperationDropdown")));
     seleccion.selectByValue("4");
     driver.findElement(By.id("calculateButton")).click();
     Thread.sleep(1000);
     String resultado = driver.findElement(By.id("numberAnswerField")).getAttribute("value");
     
     assertEquals(result, resultado);
     
   } catch (Exception e) {
     System.out.println(e.getMessage());
     System.out.println("HA FALLADO");
   } finally {
     driver.quit();
   }
   
 }
 
 //Division por Cero
 @ParameterizedTest
 @CsvSource({
   "0,2,0",
   "-12,0,0",
   "0,0,0",
   })
 void TestDivisionCero(String num1, String num2, String result) {
   WebDriver driver = new ChromeDriver();
   
   try {
     
     driver.get("https://testsheepnz.github.io/BasicCalculator.html");
     Thread.sleep(1000);
     driver.findElement(By.id("number1Field")).sendKeys(num1);
     driver.findElement(By.id("number2Field")).sendKeys(num2);
     Select seleccion = new Select(driver.findElement(By.id("selectOperationDropdown")));
     seleccion.selectByValue("3");
     driver.findElement(By.id("calculateButton")).click();
     Thread.sleep(1000);
     int numero2entero = Integer.parseInt(num2);
     if (numero2entero != 0) {
       String resultado = driver.findElement(By.id("numberAnswerField")).getAttribute("value");
       assertEquals(result, resultado);
     }else {
       String error = driver.findElement(By.id("errorMsgField")).getText();
       assertEquals("Divide by zero error!", error);
     }
     

   } catch (Exception e) {
     System.out.println(e.getMessage());
     System.out.println("HA FALLADO");
   } finally {
     driver.quit();
   }

 }

}
