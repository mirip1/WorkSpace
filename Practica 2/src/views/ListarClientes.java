package views;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import modelos.Cliente;
import utils.ManejoCliente;

public class ListarClientes extends JDialog {

  private static final long serialVersionUID = 1L;
  private JTable table;
  private ManejoCliente clientes;
  private DefaultTableModel model;
  private TableRowSorter sorter;

 
  public ListarClientes(ManejoCliente clientes) {
    
    this.clientes = clientes;

    setModal(true);
    clientes.mostrarCliente();
    
    JLabel lblListarClientes = new JLabel("LISTAR CLIENTES");
    lblListarClientes.setHorizontalAlignment(SwingConstants.CENTER);
    lblListarClientes.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
    
    JScrollPane scrollPane = new JScrollPane();
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap(58, Short.MAX_VALUE)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
              .addComponent(lblListarClientes, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE)
              .addGap(109))
            .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
              .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE)
              .addGap(80))))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(28)
          .addComponent(lblListarClientes)
          .addGap(18)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(57, Short.MAX_VALUE))
    );
    
    table = new JTable();
    table.setBackground(Color.WHITE);
    table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
    table.setEnabled(false);
    
    model = new DefaultTableModel();
    table.setModel(model);
    model.addColumn("Email");
    model.addColumn("Nombre");
    model.addColumn("Apellidos");
    model.addColumn("Provincia");
    model.addColumn("Edad");
    model.addColumn("Fecha Alta");

    table.getColumnModel().getColumn(0).setResizable(false);
    table.getColumnModel().getColumn(3).setPreferredWidth(85);
    scrollPane.setViewportView(table);
    setLayout(groupLayout);
    
    sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
    table.setRowSorter(sorter);
    
    llenarTabla(clientes.pasarALista());

  }
  
  
  /**
   * Metodo que rellena una tabla al pasarle una lista
   * @param clientes
   */
  private void llenarTabla(List<Cliente> clientes) {
    model.setRowCount(0);
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    for (Cliente c : clientes) {
      Object[] fila = new Object[6];
      fila[0] = c.getEmail();
      fila[1] = c.getNombre();
      fila[2] = c.getApellidos();
      fila[3] = c.getProvincia();
      fila[4] = c.getEdad();
      fila[5] = format.format(c.getFechaAlta());


      model.addRow(fila);
    }

  }
  
}
