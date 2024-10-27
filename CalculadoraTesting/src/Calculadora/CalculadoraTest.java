package Calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class CalculadoraTest {
  
  @ParameterizedTest
  @CsvSource({
   "1,2,3",
   "-2,-3,-5",
   "-3,4,1",
   })
  public void TestSuma(int num1, int num2, int result) {
 
    assertEquals(result, Calculadora.suma(num1, num2));
  }

  @ParameterizedTest
  @CsvSource({
   "1,2,-1",
   "-2,-3,1",
   "-3,4,-7",
   })
  public void TestResta(int num1, int num2, int result) {
    assertEquals(result, Calculadora.resta(num1, num2));
  }
  
  
  @ParameterizedTest
  @CsvSource({
   "1,2,2",
   "-2,-3,6",
   "-3,4,-12",
   })
  public void TestMultiplicar(int num1, int num2, int result) {
    
    assertEquals(result, Calculadora.multiplicar(num1, num2));
    
    
  }
  
  
  @ParameterizedTest
  @CsvSource({
   "4,2,2",
   "-12,-3,4",
   "-16,4,-4",
   })
  public void TestDividir(int num1, int num2, int result) {
    
    assertEquals(result, Calculadora.dividir(num1, num2));
    
    
  }
  
  @Test
  public void TestDividirCero() {
      
    assertThrows(ArithmeticException.class,()->{int resultado = Calculadora.dividir(200,0);});
    
    
  }
  
  @ParameterizedTest
  @CsvSource({
   "1",
   "11",
   "2",
   })
  public void TestEsPositivoTrue(int num) {
    
    boolean resultado = Calculadora.esPositivo(num);
    boolean esperado = true;
    
    assertEquals(resultado, esperado);
    
    
  }
  @ParameterizedTest
  @CsvSource({
   "-6",
   "-21",
   "-231",
   })
  public void TestEsPositivoFalse(int num) {
    
    boolean resultado = Calculadora.esPositivo(num);
    boolean esperado = false;
    
    assertEquals(resultado, esperado);
    
    
  }
  
  
  @ParameterizedTest
  @CsvSource({
   "1",
   "11",
   "2",
   })
  public void TestEsPrimoTrue(int num) {
    
    boolean resultado = Calculadora.esPrimo(num);
    boolean esperado = true;
    
    assertEquals(resultado, esperado);
    
    
  }
  @ParameterizedTest
  @CsvSource({
   "6",
   "21",
   "231",
   })
  public void TestEsPrimoFalse(int num) {
    
    boolean resultado = Calculadora.esPrimo(num);
    boolean esperado = false;

    assertEquals(resultado, esperado);
    
    
  }
 
  
  
  
}
