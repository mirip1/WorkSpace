package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.Cliente;
import clases.Motocicleta;

public class ProveedorAlmacenamientoTienda {
  public static final String JDBC_URL = "jdbc:sqlite:";
  private String dataBasePath;

  public ProveedorAlmacenamientoTienda(String rutaDB) {
    if (!rutaDB.isBlank() && !rutaDB.equals(null)) {
      this.dataBasePath = rutaDB;
    } else {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Coje todas las motos
   * 
   * @return lista todas las motos
   */
  private List<Motocicleta> getMotocicletaAll() {
    String sql = "Select * from MOTOCICLETA";

    Motocicleta nuevaMoto;
    List<Motocicleta> motos = new ArrayList();
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement(sql);) {

      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          nuevaMoto = new Motocicleta(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
          motos.add(nuevaMoto);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    return motos;
  }

  /**
   * Coje todos los nif de clientes
   * 
   * @return lista de todos los nif de clientes
   */
  private List<String> getNIFClienteAll() {
    String sql = "Select * from CLIENTE";

    List<String> Nifs = new ArrayList();
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement(sql);) {

      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          Nifs.add(rs.getString(1));
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    return Nifs;
  }

  /**
   * comprueba si la referencia existe en la base de datos
   * 
   * @param referencia
   * @return
   */
  public boolean compruebaRef(String referencia) {
    List<Motocicleta> motos = getMotocicletaAll();
    boolean contiene = false;
    for (Motocicleta i : motos) {
      if (i.getReferencia().equals(referencia)) {
        contiene = true;
      }

    }
    return contiene;

  }

  /**
   * comprueba si la referencia existe en la base de datos
   * 
   * @param referencia
   * @return
   */
  public boolean compruebaNif(String nif) {
    List<String> Nifs = getNIFClienteAll();
    boolean contiene = false;
    for (String i : Nifs) {
      if (i.equals(nif)) {
        contiene = true;
      }

    }
    return contiene;

  }

  /**
   * Registrqa una venta
   * 
   * @param nif        de cliente que registrar
   * @param referencia de moto que registrar
   * @return
   */
  public void addVenta(String nif, String referencia) {
    Motocicleta nuevaMoto = null;
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn
            .prepareStatement("insert into VENTA( nif_cliente, referencia_motocicleta, fecha) VALUES (?,?,?)");) {
      stmt.setString(1, nif);
      stmt.setString(2, referencia);

      LocalDate fecha = LocalDate.now();
      String fecha1 = fecha.toString();
      stmt.setString(3, fecha1);

      if (!compruebaRef(referencia)) {

        throw new IllegalArgumentException();
      }
      if (!compruebaNif(nif)) {

        throw new IllegalArgumentException();
      }

      stmt.executeUpdate();
    } catch (SQLException e) {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Añadir moto
   * 
   * @param Motocicleta a añadir
   * @return
   */
  public void addMotocicleta(Motocicleta moto) {
    Motocicleta nuevaMoto = null;
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement(
            "insert into MOTOCICLETA(referencia, cilindrada, tipo, precio, fabricante) VALUES (?,?,?,?,?)");) {
      stmt.setString(1, moto.getReferencia());
      stmt.setInt(2, moto.getCilindrada());
      stmt.setString(3, moto.getTipo());
      stmt.setDouble(4, moto.getPrecio());
      stmt.setString(5, moto.getFabricante());

      if (compruebaRef(moto.getReferencia())) {
        System.err.print("No se puede almacenar una referencia existente");
        throw new IllegalArgumentException();
      }

      stmt.executeUpdate();
    } catch (SQLException e) {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Lista los datos importantes de VENTA (Lo hace muuy feo)
   */
  public void listarTodo() {
    String sql = "Select nif, apellidos, nombre, referencia, fabricante, cilindrada, precio, fecha from CLIENTE INNER join VENTA on nif_cliente = nif INNER join MOTOCICLETA on referencia_motocicleta = referencia;";

    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement(sql);) {

      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          System.out.printf("%2s %2s %2s %2s %2s %2d %10.2f %2s", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDouble(7), rs.getString(8));
//          System.out.println(rs.getString(1) + " " + rs.getString(2) +" " + rs.getString(3) +" " + rs.getString(4) +" " + rs.getString(5) +" " + rs.getInt(6) +" " + rs.getDouble(7) +" " + rs.getString(8));
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

  }

  /**
   * Modifica un cliente
   * 
   * @param cliente
   */
  public void updateCliente(Cliente cliente) {

    Cliente nuevoCliente = null;
    String sql = "update CLIENTE set nombre = ?, apellidos = ?, direccion = ?,nif_recomendado = ? WHERE nif = ?";
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, cliente.getNombre());
      stmt.setString(2, cliente.getApellidos());
      stmt.setString(3, cliente.getDireccion());
      stmt.setString(5, cliente.getNif());

      if (cliente.getNif_recomendados() != null) {
        stmt.setString(4, cliente.getNif_recomendados());
      } else {
        stmt.setNull(4, Types.INTEGER);
      }

      int comprobar = stmt.executeUpdate();
      if (comprobar != 1) {
        throw new IllegalArgumentException();
      }
    } catch (SQLException e) {
      throw new IllegalArgumentException();
    }

  }

}
