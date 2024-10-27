package prog.unidad04.actividad402.ejercicio04;

public class Lavadora {
  private double precio;
  private String color;
  private char consumo;
  private double peso;
  private double carga;
  
  public Lavadora() {
    this.precio = 200;
    this.color = "blanco";
    this.consumo = comprobarConsumo(consumo);
    this.peso = 15;
    this.carga = 5;
    
  }
  public Lavadora(double precio, double peso) {
    this.precio = precio;
    this.peso = peso;
    this.color = "blanco";
    this.consumo = comprobarConsumo(consumo);
    this.carga = 5;
  }
  public Lavadora(double precio,String color, char consumo, double peso, double carga) {
    this.precio = precio;
    this.peso = peso;
    this.consumo = comprobarConsumo(consumo);
    this.color = color;
    this.carga = carga;
    
  }
  public double getPrecioBase() {
    return precio;
  }
  public String getColor() {
    return color;
  }
  public char getConsumoEnergetico() {
    return consumo;
  }
  public double getPeso() {
    return peso;
  }
  public double getCarga() {
    return carga;
  }
  public double getPrecioFinal() {
    double acum1 = 0;
    double acum2 = 0;
    double acum3 = 0;
    if (consumo=='F') {
      acum1 = 10;
    }else if (consumo=='A') {
      acum1 = 100;
    }else if (consumo=='B') {
      acum1 = 80;
    }else if (consumo=='C') {
      acum1 = 60;
    }else if (consumo=='D') {
      acum1 = 50;
    }else if (consumo=='E'){
      acum1 = 30;
    }
    if (peso>=0 && peso<=20) {
      acum2 = 10;
    }else if (peso>20 && peso<=50) {
      acum2 = 50;
    }else if (peso>50 && peso<=80) {
      acum2 = 80;
    }else if (peso>80) {
      acum2 = 100;
    }
    if (carga>30) {
      acum3 = 50;
     }
     return precio+acum1+acum2+acum3;
  }
  
  private char comprobarConsumo(char consumo) {
    if (consumo == 'F' || consumo == 'A'|| consumo == 'B' || consumo == 'C' || consumo == 'D' || consumo == 'E') {
      return consumo;
  } else {
      return 'F'; // Sexo por defecto
    }
  }

}
