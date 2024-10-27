package prog.unidad08.relacion02.proveedor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class prueba {

  public static void main(String[] args) {
   List <String > lista = new ArrayList();
   List <String > lista2 = new ArrayList();
   lista.add("z");
   lista.add ("n");
   lista.add("a");
   Collections.sort(lista);
   System.out.println(lista.get(0));
  }

}
