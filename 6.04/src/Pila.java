import java.util.EmptyStackException;

public class Pila <T> {
  private int cont;
  private int posicion;
  private String pila="";
  private T elementoActual;
  private String elementoActual2;
  
  
  public Pila() {
    this.cont=0;
    this.posicion=0;
  }
  public void Push(T elemento) {
    cont++;
    posicion++;
    elementoActual = elemento;
    elementoActual2 = (String) elemento;
    pila+=elemento;
    
  }
  public T pop() {
    if (!esVacia()) {
      posicion--;
      
      pila=pila.replace(elementoActual2,"" );
      return elementoActual;
      
      
      
      
      
      
      
      
    }else {
      throw new EmptyStackException();
    }

  }
  public boolean esVacia() {
    return posicion==0;
  }
  
  public int getNumeroElementos() {
    return posicion;
  }
}
