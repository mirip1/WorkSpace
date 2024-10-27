package prog.unidad04.actividad402;

import java.util.Random;

public class Persona {
  private String nombre;
  private int edad;
  private String DNI;
  private char sexo;
  private double peso ;
  private double altura ;
  /**
   * UwU1
   */
  public Persona(){
    this.nombre = "";
    this.edad = 0;
    this.peso = 0;
    this.altura = 0;
    this.DNI = generarDNI();
    this.sexo = comprobarSexo(sexo);
  }
  /**
   * UWU2
   */
  public Persona(String nombre, int edad, char sexo){
    this.nombre = nombre;
    this.edad = edad;
    this.sexo = comprobarSexo(sexo);
    this.peso = 0;
    this.altura = 0;
    this.DNI = generarDNI();
    
  }
  public Persona(String nombre, int edad, char sexo,double peso,double altura){
    this.nombre = nombre;
    this.edad = edad;
    this.sexo = comprobarSexo(sexo);
    this.altura = altura;
    this.peso = peso;
    this.DNI = generarDNI();
    
  }
  /**
   * UwU3
   */
  public double getIMC() {
    if (altura ==0) {
      return 0;
    }else {
      return (peso/altura*altura);
    }
  }
  
  public double getPesoCorrecto() {
    if (getIMC()<20) {
      return -1;
    }else if ((getIMC()>=20)&&(getIMC()<=25)) {
      return 0;
    }else {
      return 1;
    }
  }
  
  public boolean esMayorDeEdad() {
    return edad>=18;
  }
  
  public String obtenerCadena(){
    return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + DNI +
        "\nSexo: " + sexo + "\nPeso: " + peso + "\nAltura: " + altura;
  }
  /**
   * 
   * ahhhhhhhhhhh
   * ahhhhhhhhhhhh2
   * ahhhhhhhhh3
   * 1212121
   */
  private String generarDNI() { 
    Random random = new Random();
    int num = random.nextInt(90000000) + 10000000;
    String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    char letra = letras.charAt(num % 23);
    return String.valueOf(num) + letra;
}
  private char comprobarSexo(char sexo) {
    if (sexo == 'H' || sexo == 'M') {
        return sexo;
    } else {
        return 'M'; // Sexo por defecto
    }
  }
}
