package prog.ud06.actividad611.test;

import java.util.List;

import prog.ud06.actividad611.coleccion.Cliente;
import prog.ud06.actividad611.coleccion.Usuarios;
import prog.ud06.actividad611.proveedores.ProveedorUsuariosArchivoXML;

public class pruebaPocha {

  public static void main(String[] args) {
    
    ProveedorUsuariosArchivoXML proveedor = new ProveedorUsuariosArchivoXML("biblioteca.xml");
    System.out.println(proveedor.obtieneUsuarios().getUsuarioPorNombreUsuario("paco").getTarjeta().validarClave(1, 1, 345));

    
//    for (int i = 0 ; i!=clientesLista.size();i++) {
//      System.out.println("\"" + clientesLista.get(i).getNombre() + "\"");
//
//    }
    
    
  }

}
