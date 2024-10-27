package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelos.Producto;
import utils.ManejoProductos;

public class AltaProducto extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JTextField textNombre;
  private JTextField textPrecio;
  private ManejoProductos productos;
  private JCheckBox chckbx;

  /**
   * Create the dialog.
   */
  public AltaProducto(ManejoProductos productos) {
    setTitle("Alta Clientes");

    this.productos = productos;

    setModal(true);

    setBounds(100, 100, 527, 358);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(new BorderLayout(0, 0));
    {
      JLabel lblAltaClientes = new JLabel("Alta Productos");
      lblAltaClientes.setHorizontalAlignment(SwingConstants.CENTER);
      lblAltaClientes.setFont(new Font("Tahoma", Font.BOLD, 15));
      contentPanel.add(lblAltaClientes, BorderLayout.NORTH);
    }
    {
      JPanel panel = new JPanel();
      contentPanel.add(panel, BorderLayout.CENTER);
      panel.setLayout(null);

      textNombre = new JTextField();
      textNombre.setBounds(219, 41, 139, 24);
      panel.add(textNombre);
      textNombre.setColumns(10);

      textPrecio = new JTextField();
      textPrecio.setColumns(10);
      textPrecio.setBounds(219, 88, 139, 24);
      panel.add(textPrecio);

      JLabel lblNombre = new JLabel("Nombre:");
      lblNombre.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
      lblNombre.setBounds(131, 45, 72, 13);
      panel.add(lblNombre);

      JLabel lblPrecioUnidad = new JLabel("Precio:");
      lblPrecioUnidad.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
      lblPrecioUnidad.setBounds(131, 93, 72, 13);
      panel.add(lblPrecioUnidad);

      JLabel lblPerecedero = new JLabel("Perecedero:");
      lblPerecedero.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
      lblPerecedero.setBounds(131, 138, 92, 13);
      panel.add(lblPerecedero);

      chckbx = new JCheckBox("");
      chckbx.setBounds(219, 138, 93, 13);
      panel.add(chckbx);
      
      JLabel lblPrecioUnidad_1 = new JLabel("€");
      lblPrecioUnidad_1.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 16));
      lblPrecioUnidad_1.setBounds(362, 88, 80, 24);
      panel.add(lblPrecioUnidad_1);
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            altaProducto();
          }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
      }
      {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            dispose();
          }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }
  }

  /**
   * Metodo que sirve para dar de alta un producto
   */
  private void altaProducto() {
    try {
      productos.altaproducto(
          new Producto(textNombre.getText(), Double.parseDouble(textPrecio.getText()), chckbx.isSelected()));
      dispose();

    } catch (Exception e) {

      JOptionPane.showMessageDialog(null, "Rellene todos los campos, Precio tiene que ser númerico");

    }

  }
}
