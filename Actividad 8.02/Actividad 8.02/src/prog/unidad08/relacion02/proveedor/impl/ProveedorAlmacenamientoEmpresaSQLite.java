package prog.unidad08.relacion02.proveedor.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import prog.unidad08.relacion02.entidades.Centro;
import prog.unidad08.relacion02.entidades.Departamento;
import prog.unidad08.relacion02.entidades.Empleado;
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresa;
import prog.unidad08.relacion02.proveedor.ProveedorAlmacenamientoEmpresaException;

public class ProveedorAlmacenamientoEmpresaSQLite implements ProveedorAlmacenamientoEmpresa{
  public static final String JDBC_URL = "jdbc:sqlite:";
  private String dataBasePath;
  public ProveedorAlmacenamientoEmpresaSQLite(String rutaDB)
  {
    if (!rutaDB.isBlank() && !rutaDB.equals(null))
    {
      this.dataBasePath = rutaDB;
    }else {
      throw new ProveedorAlmacenamientoEmpresaException();
    }
  }
  @Override
  public Centro getCentroByCodigo(int codigo) {
      Centro nuevoCentro = null;
      String sql = "SELECT * FROM centro WHERE numce = ?";
      try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
           PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setInt(1, codigo);
          try (ResultSet rs = stmt.executeQuery()) {
              if (rs.next()) {
                  nuevoCentro = new Centro(rs.getInt(1), rs.getString(2));
              }
          }
      } catch (SQLException e) {
        throw new ProveedorAlmacenamientoEmpresaException();
      }
      return nuevoCentro;
  }

     
    
    
    
  

  @Override
  public List<Centro> getAllCentro(boolean ordenarPorNombre) {
    String sql = "Select * from centro";
    String sql2 = "Select * from centro order by nomce asc";
    Centro nuevoCentro;
    List<Centro> almacen = new ArrayList();
    if (!ordenarPorNombre)
    {
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement(sql) ;) {


     try (ResultSet rs = stmt.executeQuery()) {
       while (rs.next()) {
           nuevoCentro = new Centro(rs.getInt(1), rs.getString(2));
           almacen.add(nuevoCentro);
       }
   }
       
       
   } catch (SQLException e) {
     throw new ProveedorAlmacenamientoEmpresaException();
   }
    }else {
      try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
          PreparedStatement stmt = conn.prepareStatement(sql2) ;) {
       
    
       try (ResultSet rs = stmt.executeQuery()) {
         while (rs.next()) {
             nuevoCentro = new Centro(rs.getInt(1), rs.getString(2));
             almacen.add(nuevoCentro);
         }
     }
         
         
     } catch (SQLException e) {
       throw new ProveedorAlmacenamientoEmpresaException();
     
    }


    }
    return almacen;
  }


  @Override
  public Centro addCentro(Centro centro) {
    Centro nuevoCentro = null;
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        Statement stmt = conn.createStatement();) {
      
       String sql = String.format("INSERT INTO centro (nomce)"
                       + " VALUES ('%s')",
               centro.getNombre());
      int comprobar =  stmt.executeUpdate(sql);
      ResultSet generado = stmt.getGeneratedKeys();
      if (comprobar == 1)
      {
        centro = new Centro (generado.getInt(1),centro.getNombre());
      }
    } catch (SQLException e) {
        throw new ProveedorAlmacenamientoEmpresaException();
    }
    
   
    return centro;
}
  

  @Override
  public void updateCentro(Centro centro) {
    
        Centro nuevoCentro = null;
        String sql = "update centro set nomce = ? WHERE numce = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, centro.getNombre());
            stmt.setInt(2, centro.getCodigo());
            int comprobar = stmt.executeUpdate();
            if (comprobar != 1)
            {
              throw new ProveedorAlmacenamientoEmpresaException();
            }
        } catch (SQLException e) {
          throw new ProveedorAlmacenamientoEmpresaException();
        }
        
  }
    
    
    
  

  @Override
  public void deleteCentroByCodigo(int codigo) {
    Centro nuevoCentro = null;
    String sql = "delete FROM centro WHERE numce = ?";
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, codigo);
        
        int comprobar = stmt.executeUpdate();
        if (comprobar != 1)
        {
          throw new ProveedorAlmacenamientoEmpresaException();
        }
    } catch (SQLException e) {
      throw new ProveedorAlmacenamientoEmpresaException();
    }
    
    
  }
  @Override
  public List<Departamento> getDepartamentoAll(boolean ordenarPorNombre) {
    String sql = "Select * from departamento";
    String sql2 = "Select * from departamento order by nomde asc";
    Departamento nuevoDepartamento;
    List<Departamento> almacen = new ArrayList();
    if (!ordenarPorNombre)
    {
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement(sql) ;) {


     try (ResultSet rs = stmt.executeQuery()) {
       while (rs.next()) {
           nuevoDepartamento = new Departamento(rs.getInt(2),rs.getString(7),rs.getInt(1),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getInt(6));
           almacen.add(nuevoDepartamento);
       }
   }
       
       
   } catch (SQLException e) {
     throw new ProveedorAlmacenamientoEmpresaException();
   }
    }else {
      try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
          PreparedStatement stmt = conn.prepareStatement(sql2) ;) {
       
    
       try (ResultSet rs = stmt.executeQuery()) {
         while (rs.next()) {
           nuevoDepartamento = new Departamento(rs.getInt(2),rs.getString(7),rs.getInt(1),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getInt(6));
             almacen.add(nuevoDepartamento);
         }
     }
         
         
     } catch (SQLException e) {
       throw new ProveedorAlmacenamientoEmpresaException();
     
    }


    }
    return almacen;
  }
  @Override
  public Departamento getDepartamentoByCodigo(int codigo) {
    Departamento nuevoCentro = null;
    String sql = "SELECT * FROM departamento WHERE numde = ?";
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, codigo);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
              Integer valor1 = rs.getInt(2);
              String valor2 = rs.getString(7);
              int valor3 = rs.getInt(1);
              String valor4 = rs.getString(3);
              int valor5 = rs.getInt(4);
              double valor6 = rs.getDouble(5);
              Integer valor7 = rs.getInt(6);
              
               
                if (rs.wasNull())
                {
                  valor7 = null;
                }
                nuevoCentro =new Departamento(valor1,valor2,valor3,valor4,valor5,valor6,valor7);
            }
        }
    } catch (SQLException e) {
      throw new ProveedorAlmacenamientoEmpresaException();
    }
    return nuevoCentro;
    
  }
  @Override
  public void addDepartamento(Departamento departamento) {
    Departamento nuevoCentro = null;
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement("insert into departamento(numce, direc, tidir, presu, depde, nomde) VALUES (?,?,?,?,?,?)");) {
        stmt.setInt(1, departamento.getCodigo());
        stmt.setString(2, departamento.getDireccion());
        stmt.setInt(3, departamento.getCodigoDirector());
        stmt.setDouble(4, departamento.getPresupuesto());
        if (departamento.getCodigoDepartamentoSuperior() != null)
        {
          stmt.setInt(5, departamento.getCodigoDepartamentoSuperior());
        }else {
          stmt.setNull(5, Types.INTEGER);
        }
      stmt.setString(6, departamento.getNombre());
      stmt.executeUpdate();
    } catch (SQLException e) {
        throw new ProveedorAlmacenamientoEmpresaException();
    }
   
  }
  @Override
  public void updateDepartamento(Departamento departamento) {
    Centro nuevoCentro = null;
    String sql = "update departamento set numce = ?,direc = ?, tidir = ?, presu = ?,depde = ?,nomde = ? WHERE numde = ?";
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, departamento.getCodigo());
      stmt.setString(2, departamento.getDireccion());
      stmt.setInt(3, departamento.getCodigoDirector());
      stmt.setDouble(4, departamento.getPresupuesto());
      if (departamento.getCodigoDepartamentoSuperior() != null)
      {
        stmt.setInt(5, departamento.getCodigoDepartamentoSuperior());
      }else {
        stmt.setNull(5, Types.INTEGER);
      }
    stmt.setString(6, departamento.getNombre());
    stmt.setInt(7, departamento.getCodigoCentro());
        int comprobar = stmt.executeUpdate();
        if (comprobar != 1)
        {
          throw new ProveedorAlmacenamientoEmpresaException();
        }
    } catch (SQLException e) {
      throw new ProveedorAlmacenamientoEmpresaException();
    }
    
  }
  @Override
  public void deleteDepartamentoByCodigo(int codigo) {
    String sql = "delete FROM departamento WHERE numde = ?";
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, codigo);
        
        int comprobar = stmt.executeUpdate();
        if (comprobar != 1)
        {
          throw new ProveedorAlmacenamientoEmpresaException();
        }
    } catch (SQLException e) {
      throw new ProveedorAlmacenamientoEmpresaException();
    }
    
  }
  @Override
  public Empleado getEmpleadoByCodigo(int codigo) {
    Empleado nuevoEmpleado = null;
    String sql = "SELECT * FROM empleado WHERE numem = ?";
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, codigo);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                nuevoEmpleado = new Empleado(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getInt(8),rs.getString(9));
            }
        }
    } catch (SQLException e) {
      throw new ProveedorAlmacenamientoEmpresaException();
    }
    return nuevoEmpleado;
  }
}
