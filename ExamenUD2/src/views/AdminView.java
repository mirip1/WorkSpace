package views;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import utils.ManejoClase;
import utils.ManejoUsuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminView extends JPanel {

  private static final long serialVersionUID = 1L;
  private ManejoUsuario usuarios;
  private ManejoClase clases;

  /**
   * Create the panel.
   */
  public AdminView(ManejoUsuario usuarios, ManejoClase clases, PantallaPrincipal pantalla) {

    this.usuarios = usuarios;
    this.clases = clases;
    
    
    JLabel lblAddclase = new JLabel("Añade Clase");
    lblAddclase.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        NuevaClase addClase = new NuevaClase(clases);
        addClase.setVisible(true);
      }
    });
    lblAddclase.setIcon(new ImageIcon(AdminView.class.getResource("/resources/addClase.png")));
    lblAddclase.setHorizontalAlignment(SwingConstants.TRAILING);
    
    JLabel lblVerClientes = new JLabel("Ver Clientes");
    lblVerClientes.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        ListarClientes listarClientes = new ListarClientes(usuarios);
        listarClientes.setVisible(true);
        
      }
    });
    lblVerClientes.setIcon(new ImageIcon(AdminView.class.getResource("/resources/listarUsuarios.png")));
    
    JLabel lblCerrarSesin = new JLabel("Cerrar Sesión");
    lblCerrarSesin.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        
        Login login = new Login(usuarios, clases);
        login.setVisible(true);
        pantalla.dispose();
        
      }
    });
    lblCerrarSesin.setIcon(new ImageIcon(AdminView.class.getResource("/resources/cierreSesion.png")));
    
    JLabel lblVerReservas = new JLabel("Ver Reservas");
    lblVerReservas.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        VerReserva verReserva = new VerReserva(clases);
        verReserva.setVisible(true);
        
      }
    });
    lblVerReservas.setIcon(new ImageIcon(AdminView.class.getResource("/resources/listarReservas.png")));
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.TRAILING)
        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
          .addGap(121)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(lblAddclase, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
              .addGap(164)
              .addComponent(lblVerReservas, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(lblVerClientes, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
              .addGap(166)
              .addComponent(lblCerrarSesin, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(141, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(99)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(lblAddclase, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblVerReservas, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
          .addGap(61)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(lblVerClientes, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblCerrarSesin, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(122, Short.MAX_VALUE))
    );
    setLayout(groupLayout);

  }
  
  
  

}
