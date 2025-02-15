package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import excepciones.EmailNoValidoException;
import excepciones.FechaVaciaException;
import modelos.Cliente;
import utils.ManejoCliente;

public class AltaClientes extends JPanel {

  private static final long serialVersionUID = 1L;
  private JTextField textNombre;
  private JTextField textApellidos;
  private JTextField textEdad;
  private JTextField textEmail;
  private JComboBox<String> comboBox;
  private ManejoCliente clientes;
  private JDateChooser dateChooser;


  /**
   * Create the panel.
   */
  public AltaClientes(ManejoCliente clientes) {
    this.clientes = clientes;
    
    JLabel lblNombre = new JLabel("Nombre:");
    lblNombre.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
    
    textNombre = new JTextField();
    textNombre.setColumns(10);
    
    textApellidos = new JTextField();
    textApellidos.setColumns(10);
    
    JLabel lblApellidos = new JLabel("Apellidos:");
    lblApellidos.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
    
    JLabel lblEdad = new JLabel("Edad:");
    lblEdad.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
    
    textEdad = new JTextField();
    textEdad.setColumns(10);
    
    comboBox = new JComboBox<String>();
    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Almería", "Cádiz", "Córdoba", "Granada", "Huelva", "Jaén", "Málaga", "Sevilla"}));
    comboBox.setForeground(Color.BLACK);
    comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    comboBox.setBackground(Color.WHITE);
    
    JLabel lblProvincia = new JLabel("Provincia:");
    lblProvincia.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
    
    JLabel lblEmail = new JLabel("Email:");
    lblEmail.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
    
    textEmail = new JTextField();
    textEmail.setColumns(10);
    
    JButton btnAñadir = new JButton("AÑADIR");
    btnAñadir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        crearCliente();
      }
    });
    btnAñadir.setBackground(Color.WHITE);
    btnAñadir.setFont(new Font("Verdana Pro Black", Font.BOLD, 18));
    
    JLabel lblTitulo = new JLabel("ALTA CLIENTES");
    lblTitulo.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    
    dateChooser = new JDateChooser();
    
    JLabel lblFechaDeHoy = new JLabel("Fecha de hoy:");
    lblFechaDeHoy.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 13));
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(42)
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                  .addGap(10)
                  .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(lblApellidos, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                  .addGap(10)
                  .addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
              .addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(lblEdad, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(textEdad, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createSequentialGroup()
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addGroup(groupLayout.createSequentialGroup()
                      .addComponent(lblProvincia, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                      .addGap(18))
                    .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                      .addComponent(lblFechaDeHoy, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(ComponentPlacement.UNRELATED)))
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
              .addPreferredGap(ComponentPlacement.RELATED))
            .addGroup(groupLayout.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED, 217, GroupLayout.PREFERRED_SIZE)
              .addComponent(btnAñadir)
              .addGap(231)))
          .addGap(57))
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(62)
          .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(384, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
          .addGap(35)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(4)
              .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblEdad)
                .addComponent(textEdad, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addGap(4)
                  .addComponent(lblNombre))
                .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
              .addGap(23)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addGap(4)
                  .addComponent(lblApellidos))
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                  .addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                  .addComponent(lblProvincia)
                  .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
          .addGap(38)
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
              .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
              .addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
              .addComponent(lblFechaDeHoy, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
            .addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
          .addComponent(btnAñadir)
          .addGap(47))
    );
    setLayout(groupLayout);

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
      String email = textEmail.getText();
      Date fechaSeleccionada = dateChooser.getDate();
      
      if (fechaSeleccionada != null) {
          System.out.println("Fecha seleccionada: " + fechaSeleccionada);
      } else {
          throw new FechaVaciaException();
      }
      
      
      Cliente cliente = new Cliente(email, nombre, apellidos, edad, provincia, fechaSeleccionada);
      clientes.altaCliente(cliente);


    }catch (EmailNoValidoException e1) {
      JOptionPane.showMessageDialog(null, "El email debe tener un formato valido ej:\"miguel@gmail.com  \" ");
      
    } catch (FechaVaciaException u) {
      JOptionPane.showMessageDialog(null, "La fecha esta Vacia");
      
    }catch (IllegalCallerException e2) {
      JOptionPane.showMessageDialog(null, "El cliente ya existe");
      
    }catch (IllegalArgumentException e3) {
      JOptionPane.showMessageDialog(null, "Rellene todos los campos, Edad tiene que ser un entero");
      
    } 

  }
}
