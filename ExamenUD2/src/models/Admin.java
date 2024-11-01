package models;

import java.util.Date;

public class Admin extends Usuario {

  public Admin(String nombre, String apellidos, Date fechaNacimiento, String email, String cont) {
    super(nombre, apellidos, fechaNacimiento, email, cont);
    this.cliente = false;
    // TODO Auto-generated constructor stub
  }

  @Override
  public String getNombre() {
    // TODO Auto-generated method stub
    return super.getNombre();
  }

  @Override
  public void setNombre(String nombre) {
    // TODO Auto-generated method stub
    super.setNombre(nombre);
  }

  @Override
  public String getApellidos() {
    // TODO Auto-generated method stub
    return super.getApellidos();
  }

  @Override
  public void setApellidos(String apellidos) {
    // TODO Auto-generated method stub
    super.setApellidos(apellidos);
  }

  @Override
  public Date getFechaNacimiento() {
    // TODO Auto-generated method stub
    return super.getFechaNacimiento();
  }

  @Override
  public void setFechaNacimiento(Date fechaNacimiento) {
    // TODO Auto-generated method stub
    super.setFechaNacimiento(fechaNacimiento);
  }

  @Override
  public String getEmail() {
    // TODO Auto-generated method stub
    return super.getEmail();
  }

  @Override
  public void setEmail(String email) {
    // TODO Auto-generated method stub
    super.setEmail(email);
  }

  @Override
  public String getCont() {
    // TODO Auto-generated method stub
    return super.getCont();
  }

  @Override
  public void setCont(String cont) {
    // TODO Auto-generated method stub
    super.setCont(cont);
  }
  
  @Override
  public boolean isCliente() {
    return cliente;
  }


  
  


  

}
