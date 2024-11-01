package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.Admin;
import models.Clase;
import models.Cliente;
import utils.ManejoClase;
import utils.ManejoUsuario;
import views.Login;

public class MainApp {

  public static void main(String[] args) {

    
    String fechaString = "2005-11-07";
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    Date fecha = null;
    try {
      fecha = formato.parse(fechaString);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    ManejoUsuario usuarios = new ManejoUsuario();
    ManejoClase clases = new ManejoClase();
    
    usuarios.altaUsuario(new Admin("Miguel", "Velasco", fecha, "m@m.com", "m"));
    usuarios.altaUsuario(new Cliente("Miguel", "Velasco", fecha, "m2@m.com", "m"));
    usuarios.altaUsuario(new Cliente("Juan", "Pérez", fecha, "juan.perez@example.com", "contraseña123"));
    usuarios.altaUsuario(new Cliente("Maria", "FDa", fecha, "anr.perez@example.com", "contraseña123"));
    usuarios.altaUsuario(new Cliente("ADfdfa", "Pédasdrez", fecha, "asd.perez@example.com", "contraseña123"));
    usuarios.altaUsuario(new Cliente("JADnid", "123123", fecha, "dsad.perez@example.com", "contraseña123"));
    usuarios.altaUsuario(new Cliente("dasdsd", "dasdasfas", fecha, "dasds.perez@example.com", "contraseña123"));
    
    clases.addClase(new Clase("Spinning", "antonio", "Mañana"));
    clases.addClase(new Clase("Spinning", "antonio", "Tarde"));
    clases.addClase(new Clase("Yoga", "antonio", "Mañana"));
    clases.addClase(new Clase("Pilates", "antonio", "Tarde"));


    Login login = new Login(usuarios, clases);
    login.setVisible(true);

  }

}
