package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import excepciones.EmailNoValidoException;
import modelos.Producto;
import utils.ManejoProductos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaProducto extends JPanel {

  private static final long serialVersionUID = 1L;
  private JTextField textNombre;
  private JTextField textPrecio;
  private ManejoProductos productos;
  private JCheckBox chckbx;

  /**
   * Create the panel.
   */
  public AltaProducto(ManejoProductos productos) {
    
    this.productos = productos;
    JLabel lblNombre = new JLabel("Nombre:");
    lblNombre.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
    
    textNombre = new JTextField();
    textNombre.setColumns(10);
    
    JLabel lblEdad = new JLabel("Precio:");
    lblEdad.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
    
    textPrecio = new JTextField();
    textPrecio.setColumns(10);
    
    JButton btnAñadir = new JButton("AÑADIR");
    btnAñadir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        crearProducto();
        
      }
    });
    btnAñadir.setFont(new Font("Verdana Pro Black", Font.BOLD, 18));
    btnAñadir.setBackground(Color.WHITE);
    
    JLabel lblTitulo = new JLabel("ALTA PRODUCTOS");
    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitulo.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
    
    JLabel lblPerecedero = new JLabel("Perecedero:");
    lblPerecedero.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
    
    chckbx = new JCheckBox("");
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(39)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                  .addGap(10)
                  .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                  .addGap(59)
                  .addComponent(lblEdad, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                  .addGap(10)
                  .addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createSequentialGroup()
                  .addGap(217)
                  .addComponent(btnAñadir, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))))
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap()
              .addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(229)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addGap(88)
                  .addComponent(chckbx, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                .addComponent(lblPerecedero, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))))
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.TRAILING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(4)
              .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
            .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(4)
              .addComponent(lblEdad, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
            .addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
          .addGap(46)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(chckbx, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPerecedero))
          .addGap(110)
          .addComponent(btnAñadir, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
          .addGap(41))
    );
    setLayout(groupLayout);
    
    
    

  }
  private void crearProducto() {

    try {
      String nombre = textNombre.getText();
      Double precio = Double.parseDouble(textPrecio.getText());
      boolean perecedero = chckbx.isSelected();
      Producto pro = new Producto(nombre, precio, perecedero);
      productos.altaproducto(pro);



    } catch (IllegalCallerException e2) {
      JOptionPane.showMessageDialog(null, "El producto ya existe");
      
    }catch (IllegalArgumentException e3) {
      JOptionPane.showMessageDialog(null, "Rellene todos los campos, precio tiene que ser un double");
      
    } 

  }
  
  
}
