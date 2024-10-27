package Test;

import pk_SuperBuscaMinas.BotonMina;
import pk_SuperBuscaMinas.BotonMina.Estado;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BotonMinaTest {
  
  @BeforeAll
  public static void empieza() {
    System.out.println("*************** Inicio Prueba BotonMina ***************");
  }
  
  @AfterAll
  public static void termina() {
    System.out.println("*************** Fin Prueba BotonMina ***************");
  }
  
  @ParameterizedTest
  @CsvSource({  
   "BANDERA, BANDERA",
   "BOTON, BOTON",
   "PULSADO, PULSADO",
   "MINA, MINA",
   "NUMERO, NUMERO",
   })
  public void TestEstado(Estado num1, Estado result) {
    

    BotonMina boton = new BotonMina();
    System.out.println("Botón Inicial:     "+ boton.toString());
    System.out.println("Nuevo Estado:       "+ num1);
    
    boton.cambiarAspecto(num1);
    System.out.println("Botón Final:       "+ boton.toString());
    System.out.println("");

    assertEquals(result, boton.getEstado());
    
    
  }
  
  
}
