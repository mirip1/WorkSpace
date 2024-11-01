package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Clase;
import models.Usuario;
import net.miginfocom.swing.MigLayout;
import utils.ManejoClase;

public class Reservar extends JDialog {

  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private ManejoClase clases;
  private JComboBox comboBoxClases;
  private JComboBox comboBoxTurnos;
  private Usuario usuario;




  /**
   * Create the dialog.
   */
  public Reservar(ManejoClase clases, Usuario usuario) {
    this.clases = clases;
    this.usuario = usuario;

    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(new BorderLayout(0, 0));
    {
      JPanel panel = new JPanel();
      panel.setBackground(new Color(37, 182, 211));
      contentPanel.add(panel, BorderLayout.NORTH);
      {
        JLabel lblReservarClase = new JLabel("Reservar Clase");
        lblReservarClase.setFont(new Font("Dialog", Font.BOLD, 21));
        lblReservarClase.setForeground(new Color(255, 255, 255));
        panel.add(lblReservarClase);
      }
    }
    {
      JPanel panel = new JPanel();
      contentPanel.add(panel, BorderLayout.CENTER);
      panel.setLayout(new MigLayout("", "[][][][][][][][][grow]", "[][][32.00][][32.00]"));
      {
        JLabel lblClase = new JLabel("Clase");
        panel.add(lblClase, "cell 1 2");
      
         comboBoxClases = new JComboBox();
        panel.add(comboBoxClases, "cell 8 2,growx");
     
        JLabel lblTurno = new JLabel("Turno");
        panel.add(lblTurno, "cell 1 4");
        
      
        comboBoxTurnos = new JComboBox();
        panel.add(comboBoxTurnos, "cell 8 4,growx");
        for (Clase clase : clases.getClases()) {
          comboBoxClases.addItem(clase.getNombreClase());
          comboBoxTurnos.addItem(clase.getTurno());
      }
        
      }
      
    }
    
    
    
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton cancelButton = new JButton("Reservar");
        cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            reservarClase(comboBoxClases.getSelectedItem().toString(), comboBoxTurnos.getSelectedItem().toString());

            
          }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }
  }
  
  private void reservarClase(String nombreClase, String turno) {
    // Aquí puedes agregar lógica para reservar la clase usando el objeto `clases`
    Date fechaActual = new Date();
    
    boolean claseReservada = clases.reservarClase(nombreClase, turno, usuario, fechaActual); 

    if (claseReservada) {
        JOptionPane.showMessageDialog(this, "Clase reservada exitosamente!");
        dispose(); // Cerrar el diálogo
    } else {
        JOptionPane.showMessageDialog(this, "Error al reservar la clase. Verifica que esté disponible.");
    }
}
  
}
