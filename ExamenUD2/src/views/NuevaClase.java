package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import models.Clase;
import utils.ManejoClase;

public class NuevaClase extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JTextField textNombre;
  private JTextField textProfesor;
  private ManejoClase clases;
  private JRadioButton rdbtnMaana;
  private JRadioButton rdbtnTarde;
  private ButtonGroup grupoTurno;

  /**
   * Create the dialog.
   */
  public NuevaClase(ManejoClase clases) {
    this.clases = clases;

    setModal(true);
    setBounds(100, 100, 456, 384);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(new BorderLayout(0, 0));
    {
      JPanel panel = new JPanel();
      panel.setBackground(new Color(37, 182, 211));
      contentPanel.add(panel, BorderLayout.NORTH);
      {
        JLabel lblNuevaClase = new JLabel("Nueva Clase");
        lblNuevaClase.setForeground(new Color(255, 255, 255));
        lblNuevaClase.setFont(new Font("Dialog", Font.BOLD, 20));
        panel.add(lblNuevaClase);
      }
    }
    {
      JPanel panel = new JPanel();
      contentPanel.add(panel, BorderLayout.CENTER);
      JLabel lblNombre = new JLabel("Nombre");
      JLabel lblProfesor = new JLabel("Profesor/a");
      JLabel lblTurno = new JLabel("Turno");
      textNombre = new JTextField();
      textNombre.setColumns(10);
      textProfesor = new JTextField();
      textProfesor.setColumns(10);

      rdbtnMaana = new JRadioButton("Mañana");
      rdbtnMaana.setSelected(true);

      rdbtnTarde = new JRadioButton("Tarde");

      grupoTurno = new ButtonGroup();
      grupoTurno.add(rdbtnMaana);
      grupoTurno.add(rdbtnTarde);

      GroupLayout gl_panel = new GroupLayout(panel);
      gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
          .createSequentialGroup().addGap(55)
          .addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNombre).addComponent(lblProfesor)
              .addComponent(lblTurno))
          .addGap(78)
          .addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(rdbtnTarde).addComponent(rdbtnMaana)
              .addComponent(textProfesor, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
              .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(48, Short.MAX_VALUE)));
      gl_panel
          .setVerticalGroup(
              gl_panel.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_panel.createSequentialGroup().addGap(39)
                      .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre)
                          .addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                      .addGap(46)
                      .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblProfesor)
                          .addComponent(textProfesor, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                      .addGap(42)
                      .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblTurno)
                          .addComponent(rdbtnMaana))
                      .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnTarde)
                      .addContainerGap(43, Short.MAX_VALUE)));
      panel.setLayout(gl_panel);
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("Enviar");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {

            addClase();

          }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
      }
    }
  }

  protected void addClase() {
    
    try {
      if (rdbtnMaana.isSelected()) {
        clases.addClase(new Clase(textNombre.getText(), textProfesor.getText(), "Mañana"));        
      } else {
        clases.addClase(new Clase(textNombre.getText(), textProfesor.getText(), "Tarde"));        
        
      }
      JOptionPane.showMessageDialog(null, "Se ha añadido la clase");
      dispose();
      
    }catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Rellene todos los campos");
      e.printStackTrace();
      

    }
    
    
    
  }
}
