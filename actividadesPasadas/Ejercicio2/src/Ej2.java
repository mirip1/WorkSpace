
public class Ej2 {
  public static void main(String[] args) {
    Persona persona = new Persona();
    persona.edad= 25;
    persona.numeroHijos=0;
    persona.peso=75.4;
    Persona persona2 = new Persona();
    persona2.edad= 65;
    persona2.numeroHijos=3;
    persona2.peso=65;
    boolean var1 = persona == persona2;
    System.out.println("Las variables apuntan al mismo objeto: "+var1);
    //System.out.println("La primera persona tiene: "+persona.edad);

    

    
    
  }

}
