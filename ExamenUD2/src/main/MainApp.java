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
    
    ManejoUsuario usuarios = new ManejoUsuario();
    ManejoClase clases = new ManejoClase();
    

    Login login = new Login(usuarios, clases);
    login.setVisible(true);

  }

}
