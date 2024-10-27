
public class Ej3 {
 /* public static void main(String[] args) {
    Persona persona = new Persona();
    Persona persona2 = new Persona();
    persona.edad= 33;
    persona.numeroHijos=1;
    persona.peso=80.43;
    persona2=persona;
    persona2.peso=79.65;
    boolean var1 = persona == persona2;
    System.out.println("Las variables apuntan al mismo objeto: "+var1);

    */
 
  public static void main(String[] args) {
    Persona persona = new Persona();
    Persona persona2 = new Persona();
    Persona persona3 = new Persona();
    persona.edad= 25;
    persona.peso=40;
    persona2.edad=35;
    persona2.peso=55.6;
    persona2.edad=40;
    persona3=persona2;
    persona3 = null; 
    System.out.println("Edad persona1= "+persona.edad);
    System.out.println("Edad persona2= "+persona2.edad);
    System.out.println("Edad persona2= "+persona3.edad);



    
  }

}
