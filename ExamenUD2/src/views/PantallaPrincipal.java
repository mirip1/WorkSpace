package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Usuario;
import utils.ManejoClase;
import utils.ManejoUsuario;

public class PantallaPrincipal extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private ManejoUsuario usuarios;
  private ManejoClase clases;
  private Usuario usuario;



  /**
   * Create the frame.
   */
  public PantallaPrincipal(ManejoUsuario usuarios, ManejoClase clases, Usuario usuario) {
    
    this.usuarios = usuarios;
    this.usuario = usuario;
    this.clases = clases;
    
    setBackground(new Color(211, 245, 250));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 778, 586);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    JPanel Header = new JPanel();
    Header.setBackground(new Color(211, 245, 250));
    contentPane.add(Header, BorderLayout.NORTH);
    
    if(usuario.isCliente()) {
      ClienteView pantallaCliente = new ClienteView(usuarios, clases, this, usuario);
      cargarPanel(pantallaCliente);      
      
    }else {
      AdminView pantallaAdmin = new AdminView(usuarios, clases, this);
      cargarPanel(pantallaAdmin);      
    }
    
    
    
    JLabel lblNewLabel = new JLabel("  GYM Picasso");
    lblNewLabel.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/resources/logoApp.png")));
    lblNewLabel.setForeground(new Color(26, 95, 180));
    lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 33));
    Header.add(lblNewLabel);
    
    JPanel panel = new JPanel();
    panel.setBackground(new Color(153, 193, 241));
    contentPane.add(panel, BorderLayout.SOUTH);
    
    JLabel lblMiguelVelascoFernndez = new JLabel("Miguel Velasco Fernández 1/11/24");
    lblMiguelVelascoFernndez.setFont(new Font("Dialog", Font.BOLD, 17));
    lblMiguelVelascoFernndez.setForeground(new Color(26, 95, 180));
    panel.add(lblMiguelVelascoFernndez);
  }
  
  /**
   * Método para cargar el panel que se le da por parametro 
   * @param panel que se quiere cargar
   */
  private void cargarPanel(JPanel panel) {
    
    contentPane.add(panel, BorderLayout.CENTER);
    contentPane.revalidate();
    contentPane.repaint();
  }

}

