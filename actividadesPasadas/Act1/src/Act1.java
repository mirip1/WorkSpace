
public class Act1 {
  public static void main(String[] args) {
    CuentaCorriente cuentaCorriente = new CuentaCorriente("1111");
    cuentaCorriente.ingresar(1000);
    cuentaCorriente.ingresar(350);
    //cuentaCorriente.retirar(1100);
    cuentaCorriente.retirar(900);
    cuentaCorriente.retirar(400);
    cuentaCorriente.retirar(100);
    System.out.println(cuentaCorriente.getSaldo());
    System.out.println(cuentaCorriente.getNumero());
    
    
  }
}
