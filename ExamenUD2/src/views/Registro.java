package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;

import exception.EmailNoValidoException;
import exception.FechaVaciaException;
import models.Admin;
import models.Cliente;
import utils.ManejoUsuario;

public class Registro extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JLabel lblNombre;
  private JTextField textNombre;
  private JTextField textApellidos;
  private JTextField textEmail;
  private JTextField textCont;
  private JTextField textCont2;
  private JLabel lblNewLabel;
  private JButton okButton;
  private ManejoUsuario usuarios;
  private JComboBox comboBox;
  private JDateChooser dateChooser;



  /**
   * Create the dialog.
   */
  public Registro(ManejoUsuario usuarios) {
    this.usuarios = usuarios;
    
    setModal(true);

    
    
    setBounds(100, 100, 505, 603);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(new BorderLayout(0, 0));
    {
      JPanel panel = new JPanel();
      panel.setBackground(new Color(37, 182, 211));
      contentPanel.add(panel, BorderLayout.NORTH);
      {
        lblNewLabel = new JLabel("Registro de Usuario");
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 19));
        lblNewLabel.setForeground(new Color(255, 255, 255));
      }
      GroupLayout gl_panel = new GroupLayout(panel);
      gl_panel.setHorizontalGroup(
        gl_panel.createParallelGroup(Alignment.LEADING)
          .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
            .addContainerGap(124, Short.MAX_VALUE)
            .addComponent(lblNewLabel)
            .addGap(113))
      );
      gl_panel.setVerticalGroup(
        gl_panel.createParallelGroup(Alignment.LEADING)
          .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );
      panel.setLayout(gl_panel);
    }
    {
      JPanel panel = new JPanel();
      contentPanel.add(panel, BorderLayout.CENTER);
      {
        lblNombre = new JLabel("Nombre");
      }
      panel.setLayout(new FormLayout(new ColumnSpec[] {
          ColumnSpec.decode("59px"),
          ColumnSpec.decode("146px"),
          ColumnSpec.decode("68px"),
          ColumnSpec.decode("214px"),},
        new RowSpec[] {
          RowSpec.decode("41px"),
          RowSpec.decode("19px"),
          RowSpec.decode("37px"),
          RowSpec.decode("15px"),
          RowSpec.decode("37px"),
          RowSpec.decode("19px"),
          RowSpec.decode("28px"),
          RowSpec.decode("15px"),
          RowSpec.decode("37px"),
          RowSpec.decode("15px"),
          RowSpec.decode("37px"),
          RowSpec.decode("15px"),
          RowSpec.decode("37px"),
          RowSpec.decode("15px"),}));
      panel.add(lblNombre, "2, 2, fill, fill");
      {
        textNombre = new JTextField();
        panel.add(textNombre, "4, 2, fill, top");
        textNombre.setColumns(10);
      }
      {
        JLabel lblApellidos = new JLabel("Apellidos");
        panel.add(lblApellidos, "2, 4, left, top");
      }
      {
        textApellidos = new JTextField();
        textApellidos.setColumns(10);
        panel.add(textApellidos, "4, 4, fill, fill");
      }
      {
        JLabel lblFecha = new JLabel("Fecha de nacimiento");
        panel.add(lblFecha, "2, 6, left, top");
      }
      
      dateChooser = new JDateChooser();
      panel.add(dateChooser, "4, 6, fill, top");
      {
        JLabel lblPerfil = new JLabel("Perfil");
        panel.add(lblPerfil, "2, 8, left, top");
      }
      {
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Admin"}));
        comboBox.setSelectedIndex(0);
        panel.add(comboBox, "4, 8, fill, fill");
      }
      {
        JLabel lblEmail = new JLabel("Email");
        panel.add(lblEmail, "2, 10, left, top");
      }
      {
        textEmail = new JTextField();
        textEmail.setColumns(10);
        panel.add(textEmail, "4, 10, fill, fill");
      }
      {
        JLabel lblContrasena = new JLabel("Contraseña");
        panel.add(lblContrasena, "2, 12, left, top");
      }
      {
        textCont = new JTextField();
        textCont.setColumns(10);
        panel.add(textCont, "4, 12, fill, fill");
      }
      {
        JLabel lblRepiteContrasena = new JLabel("Repite Contraseña");
        panel.add(lblRepiteContrasena, "2, 14, left, top");
      }
      {
        textCont2 = new JTextField();
        textCont2.setColumns(10);
        panel.add(textCont2, "4, 14, fill, fill");
      }
    }
    {
      JPanel buttonPane = new JPanel();
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        okButton = new JButton("Enviar");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            addUsuario();
            
          }
        });
        okButton.setActionCommand("OK");
        getRootPane().setDefaultButton(okButton);
      }
      GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
      gl_buttonPane.setHorizontalGroup(
        gl_buttonPane.createParallelGroup(Alignment.LEADING)
          .addGroup(gl_buttonPane.createSequentialGroup()
            .addGap(375)
            .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      gl_buttonPane.setVerticalGroup(
        gl_buttonPane.createParallelGroup(Alignment.LEADING)
          .addGroup(gl_buttonPane.createSequentialGroup()
            .addGap(5)
            .addComponent(okButton)
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      buttonPane.setLayout(gl_buttonPane);
    }
  }



  private void addUsuario() {
    try {
      if (textCont.getText().equals(textCont2.getText())) {
        
        if(comboBox.getSelectedIndex() == 1) {
          usuarios.altaUsuario(new Admin(textNombre.getText(), textApellidos.getText(), dateChooser.getDate(), textEmail.getText(), textCont.getText()));
          
        }else {
          usuarios.altaUsuario(new Cliente(textNombre.getText(), textApellidos.getText(), dateChooser.getDate(), textEmail.getText(), textCont.getText()));
          
        }
        dispose();
        
      }else {
        JOptionPane.showMessageDialog(null, "La contraseña no coincide");
        
      }
      
      
    }catch (EmailNoValidoException e1) {
      JOptionPane.showMessageDialog(null, "El email debe tener un formato valido ej:\"miguel@gmail.com  \" ");
      
    } catch (FechaVaciaException u) {
      JOptionPane.showMessageDialog(null, "La fecha esta Vacia");
      
    }catch (IllegalCallerException e2) {
      JOptionPane.showMessageDialog(null, "El usuario ya existe");
      
    }catch (IllegalArgumentException e3) {
      JOptionPane.showMessageDialog(null, "Rellene todos los campos de manera válida");
      
    } 
    
    
  }
}
