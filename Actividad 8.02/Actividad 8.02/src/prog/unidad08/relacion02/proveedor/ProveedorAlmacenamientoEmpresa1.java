package prog.unidad08.relacion02.proveedor;

import java.util.ArrayList;
import java.util.List;


import prog.unidad08.relacion02.entidades.Centro;

public class ProveedorAlmacenamientoEmpresa1 {
  private  List<Centro> almacen =  new ArrayList();
  private int generadorDeCodigos = almacen.size();
  Centro getCentroByCodigo (int codigo)
  {
    Centro nuevoCentro = null;
    boolean bandera = false;
   for (int i = 0; i<almacen.size();i++ ) {
     
     if (codigo == almacen.get(i).getCodigo())
     {
        nuevoCentro = almacen.get(i);
        bandera = true;
     }
   }
   if (!bandera)
   {
     throw new ProveedorAlmacenamientoEmpresaException();
   }
   return nuevoCentro;
  
  }
  

 
  List<Centro> getAllCentro(boolean ordenarPorNombre)
  {
    if (!ordenarPorNombre)
    {
     
      return almacen;
      
    }else {
      
    }
    List<Centro> paco = new ArrayList();
    return  paco;

  }
  Centro addCentro(Centro centro)
  {
    Centro centroAAñadir = new Centro (generadorDeCodigos +1 ,centro.getNombre());
    almacen.add(centroAAñadir);
    return almacen.get(generadorDeCodigos -1); 
  }
  
  void deleteCentroByCodigo (int codigo)
  {
    almacen.remove(codigo);
  }
}
