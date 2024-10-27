package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelos.Cliente;
import utils.ManejoCliente;

public class AltaCliente extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JTextField textNombre;
  private JTextField textApellidos;
  private JTextField textEdad;
  private ManejoCliente clientes;
  private PantallaPrincipal pantallaPrincipal;
  private JComboBox<String> comboBox;

  /**
   * Create the dialog.
   */
  public AltaCliente(ManejoCliente clientes, PantallaPrincipal pantallaPrincipal) {
    setTitle("Alta Cliente");

    this.clientes = clientes;
    this.pantallaPrincipal = pantallaPrincipal;

    setModal(true);

    setBounds(100, 100, 527, 358);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(new BorderLayout(0, 0));
    {
      JLabel lblAltaClientes = new JLabel("Alta Clientes");
      lblAltaClientes.setHorizontalAlignment(SwingConstants.CENTER);
      lblAltaClientes.setFont(new Font("Tahoma", Font.BOLD, 15));
      contentPanel.add(lblAltaClientes, BorderLayout.NORTH);
    }
    {
      JPanel panel = new JPanel();
      contentPanel.add(panel, BorderLayout.CENTER);
      panel.setLayout(null);

      textNombre = new JTextField();
      textNombre.setBounds(246, 40, 139, 24);
      panel.add(textNombre);
      textNombre.setColumns(10);

      textApellidos = new JTextField();
      textApellidos.setColumns(10);
      textApellidos.setBounds(246, 87, 139, 24);
      panel.add(textApellidos);

      textEdad = new JTextField();
      textEdad.setColumns(10);
      textEdad.setBounds(246, 142, 139, 24);
      panel.add(textEdad);

      JLabel lblNombre = new JLabel("Nombre:");
      lblNombre.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
      lblNombre.setBounds(129, 44, 107, 13);
      panel.add(lblNombre);

      JLabel lblApellidos = new JLabel("Apellidos:");
      lblApellidos.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
      lblApellidos.setBounds(129, 91, 107, 13);
      panel.add(lblApellidos);

      JLabel lblEdad = new JLabel("Edad:");
      lblEdad.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
      lblEdad.setBounds(129, 146, 107, 13);
      panel.add(lblEdad);

      JLabel lblProvincia = new JLabel("Provincia:");
      lblProvincia.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
      lblProvincia.setBounds(129, 201, 107, 13);
      panel.add(lblProvincia);

      comboBox = new JComboBox<String>();
      comboBox.setBackground(new Color(255, 255, 255));
      comboBox.setForeground(new Color(0, 0, 0));
      comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
      comboBox.setModel(new DefaultComboBoxModel<String>(
          new String[] { "Almería", "Cádiz", "Córdoba", "Granada", "Huelva", "Jaén", "Málaga", "Sevilla" }));
      comboBox.setBounds(246, 197, 139, 21);
      panel.add(comboBox);
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            crearCliente();
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
            pantallaPrincipal.setEnabled(true);
            dispose();
          }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }

  }

  /**
   * Metodo para crear un cliente con los datos de los JText
   */
  private void crearCliente() {

    try {
      String nombre = textNombre.getText();
      String apellidos = textApellidos.getText();
      int edad = Integer.parseInt(textEdad.getText());
      String provincia = comboBox.getSelectedItem().toString();
      Cliente cliente = new Cliente(nombre, apellidos, edad, provincia);
      clientes.altaCliente(cliente);
      pantallaPrincipal.recargarTextArea();
      dispose();

    }catch (IllegalCallerException e2) {
      JOptionPane.showMessageDialog(null, "El cliente ya existe");
      
    }catch (IllegalArgumentException e) {
      JOptionPane.showMessageDialog(null, "Rellene todos los campos, Edad tiene que ser un entero");
      
    } 

  }
}
