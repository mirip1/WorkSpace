package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.ManejoClase;
import utils.ManejoUsuario;

public class PantallaPrincipal extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private ManejoUsuario usuarios;
  private ManejoClase clases;
  private JLabel lblAddclase;



  /**
   * Create the frame.
   */
  public PantallaPrincipal(ManejoUsuario usuarios, ManejoClase clases) {
    
    this.usuarios = usuarios;
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
    
    JPanel panel_1 = new JPanel();
    contentPane.add(panel_1, BorderLayout.CENTER);
    
    lblAddclase = new JLabel("Añade Clase");
    lblAddclase.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        NuevaClase addClase = new NuevaClase(clases);
        addClase.setVisible(true);
        
        
      }
    });
    lblAddclase.setHorizontalAlignment(SwingConstants.TRAILING);
    lblAddclase.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/resources/addClase.png")));
    
    JLabel lblVerReservas = new JLabel("Ver Reservas");
    lblVerReservas.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/resources/listarReservas.png")));
    
    JLabel lblVerClientes = new JLabel("Ver Clientes");
    lblVerClientes.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        ListarClientes listarClientes = new ListarClientes(usuarios);
        listarClientes.setVisible(true);
        
      }
    });
    lblVerClientes.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/resources/listarUsuarios.png")));
    
    JLabel lblCerrarSesin = new JLabel("Cerrar Sesión");
    lblCerrarSesin.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Login login = new Login(usuarios, clases);
        login.setVisible(true);
        dispose();
        
      }
    });
    lblCerrarSesin.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/resources/cierreSesion.png")));
    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
    gl_panel_1.setHorizontalGroup(
      gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
          .addContainerGap(164, Short.MAX_VALUE)
          .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
            .addComponent(lblAddclase)
            .addComponent(lblVerClientes))
          .addGap(164)
          .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
            .addComponent(lblCerrarSesin)
            .addComponent(lblVerReservas))
          .addGap(115))
    );
    gl_panel_1.setVerticalGroup(
      gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel_1.createSequentialGroup()
          .addGap(108)
          .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblAddclase)
            .addComponent(lblVerReservas))
          .addGap(61)
          .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblVerClientes)
            .addComponent(lblCerrarSesin))
          .addContainerGap(82, Short.MAX_VALUE))
    );
    panel_1.setLayout(gl_panel_1);
  }

}
