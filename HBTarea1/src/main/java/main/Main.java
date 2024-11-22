package main;

import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.Session;

import conexion.Utils;
import models.Superusuario;

public class Main {
  
  
  
  public static void main(String[] args) {
    Session session = Utils.getSession();

    session.getTransaction().begin();
    
    try {
      //Metemos los usuarios
      ArrayList<Superusuario> admins = Utils.leerFicheros("Alumnado_nuevo.txt");
      int cont = 0;
      for (Superusuario usu : admins) {
        
        usu = session.merge(usu);
        cont++;
        
        if(cont % 10 == 0 ){
          session.flush();
          session.clear();
        }else if (cont == admins.size()-1) {
          session.flush();
          session.clear();
        }
        
      }
      session.getTransaction().commit();
      
      // Cierro Session y SessionFactory
      Utils.closeSession();
      
      
      
      
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    
    
    
  }

}
