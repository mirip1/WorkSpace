package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.ManejoCliente;

public class BajaCliente extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JTextField textNombre;
  private JTextField textApellidos;
  private ManejoCliente clientes;
  private PantallaPrincipal pantallaPrincipal;

  /**
   * Create the dialog.
   */
  public BajaCliente(ManejoCliente clientes, PantallaPrincipal pantallaPrincipal) {
    setTitle("Baja Clientes");

    setModal(true);

    setBounds(100, 100, 527, 358);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(new BorderLayout(0, 0));
    {
      JLabel lblBajaClientes = new JLabel("Baja Clientes");
      lblBajaClientes.setHorizontalAlignment(SwingConstants.CENTER);
      lblBajaClientes.setFont(new Font("Tahoma", Font.BOLD, 15));
      contentPanel.add(lblBajaClientes, BorderLayout.NORTH);
    }
    {
      JPanel panel = new JPanel();
      contentPanel.add(panel, BorderLayout.CENTER);
      panel.setLayout(null);

      textNombre = new JTextField();
      textNombre.setBounds(227, 62, 139, 24);
      panel.add(textNombre);
      textNombre.setColumns(10);

      textApellidos = new JTextField();
      textApellidos.setColumns(10);
      textApellidos.setBounds(227, 109, 139, 24);
      panel.add(textApellidos);

      JLabel lblNombre = new JLabel("Nombre:");
      lblNombre.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 12));
      lblNombre.setBounds(139, 66, 72, 13);
      panel.add(lblNombre);

      JLabel lblApellidos = new JLabel("Apellidos:");
      lblApellidos.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 12));
      lblApellidos.setBounds(139, 114, 72, 13);
      panel.add(lblApellidos);
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            bajaCliente();
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
   * metodo para dar de alta un producto
   */
  private void bajaCliente() {
    try {
      clientes.bajaCliente(textNombre.getText(), textApellidos.getText());
      pantallaPrincipal.recargarTextArea();
      dispose();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Illo no existe el cliente");

    }

  }

}
