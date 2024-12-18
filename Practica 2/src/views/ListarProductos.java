package views;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import modelos.Producto;
import utils.ManejoProductos;

public class ListarProductos extends JPanel {

  private static final long serialVersionUID = 1L;
  private ManejoProductos productos;
  private JTable table;
  private DefaultTableModel model;

  /**
   * Create the panel.
   */
  public ListarProductos(ManejoProductos productos ) {
    this.productos = productos;
    
    JLabel lblListarProductos = new JLabel("LISTAR PRODUCTOS");
    lblListarProductos.setHorizontalAlignment(SwingConstants.CENTER);
    lblListarProductos.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
    
    JScrollPane scrollPane = new JScrollPane();
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
          .addContainerGap(78, Short.MAX_VALUE)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(32)
              .addComponent(lblListarProductos, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE))
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE))
          .addGap(60))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(34)
          .addComponent(lblListarProductos, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(51, Short.MAX_VALUE))
    );
    
    table = new JTable();
    table.setBackground(Color.WHITE);
    table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
    table.setEnabled(false);
    
    model = new DefaultTableModel();
    table.setModel(model);
    model.addColumn("Nombre");
    model.addColumn("Precio(€)");
    model.addColumn("Caduca?");



    scrollPane.setViewportView(table);
    setLayout(groupLayout);
    
    llenarTabla(productos.pasarALista());
    
    
    
    
    
  }

  /**
   * Metodo que rellena una tabla al pasarle una lista
   * @param productos
   */
  private void llenarTabla(List<Producto> productos) {
    model.setRowCount(0);

    for (Producto p : productos) {
      Object[] fila = new Object[3];
      fila[0] = p.getNombre();
      fila[1] = p.getPrecioUnidad();
      fila[2] = p.isPerecedero();


      model.addRow(fila);
    
    }
    
    
  }
}
