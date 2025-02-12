package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utils.ManejoProductos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaProductos extends JPanel {

  private static final long serialVersionUID = 1L;
  private JTextField textNombre;
  private ManejoProductos productos;
  /**
   * Create the panel.
   */
  public BajaProductos(ManejoProductos productos) {
    this.productos = productos;
    
    
    JButton btnEliminar = new JButton("ELIMINAR");
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        eliminarProducto();
      }
    });
    btnEliminar.setFont(new Font("Verdana Pro Black", Font.BOLD, 18));
    btnEliminar.setBackground(Color.WHITE);
    
    JLabel lblProducto = new JLabel("Nombre del producto:");
    lblProducto.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
    
    textNombre = new JTextField();
    textNombre.setColumns(10);
    
    JLabel lblBajaProducto = new JLabel("BAJA CLIENTES");
    lblBajaProducto.setHorizontalAlignment(SwingConstants.CENTER);
    lblBajaProducto.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(lblBajaProducto, GroupLayout.PREFERRED_SIZE, 609, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(132)
              .addComponent(lblProducto, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
              .addGap(10)
              .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(212)
              .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(40, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(30)
          .addGap(18)
          .addComponent(lblBajaProducto, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
          .addGap(77)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(1)
              .addComponent(lblProducto, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
            .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
          .addGap(69)
          .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(87, Short.MAX_VALUE))
    );
    setLayout(groupLayout);

  }
  
  private void eliminarProducto() {
    productos.bajaproducto(textNombre.getText());
    
  }

}
